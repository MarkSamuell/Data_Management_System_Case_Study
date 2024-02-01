-- Procedure that updates students' data
CREATE OR REPLACE PROCEDURE update_student_info(
    p_student_id IN NUMBER,
    p_name IN VARCHAR2,
    p_stulevel IN VARCHAR2,
    p_email IN VARCHAR2,
    p_did IN NUMBER
)
AS
BEGIN
    -- Update students' information based on the provided parameters
    UPDATE students
    SET
        name = p_name,
        stulevel = p_stulevel,
        email = p_email,
        Did = p_did
    WHERE ID = p_student_id;

    DBMS_OUTPUT.PUT_LINE('Student information updated successfully.');
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('Student with ID ' || p_student_id || ' not found.');
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('An error occurred: ' || SQLERRM);
END update_student_info;

------------------------------------------------------------------------------------------------------------------------

-- Trigger to set semester automatically
CREATE OR REPLACE TRIGGER update_semester_trigger
BEFORE INSERT ON stugrades
FOR EACH ROW
DECLARE
    v_current_month NUMBER;
    v_semester VARCHAR2(20);
BEGIN
    -- Extract the current month and year from the system date
    v_current_month := EXTRACT(MONTH FROM SYSDATE);

    -- Determine the semester based on the current month
    IF v_current_month BETWEEN 2 AND 7 THEN
        v_semester := '2nd semester';
    ELSE
        v_semester := '1st semester';
    END IF;

    -- Set the semester and year for the new row
    :NEW.semester := v_semester;
    :NEW.year := EXTRACT(YEAR FROM SYSDATE);
END;

--------------------------------------------------------------------------------------------------------------------------

-- Procedure to calculate GPA
CREATE OR REPLACE PROCEDURE calculate_gpa(
    student_id IN NUMBER,
    gpa_out OUT NUMBER
)
IS
    v_total_points NUMBER := 0;
    v_total_credits NUMBER := 0.0;
    v_gpa NUMBER; -- No specific precision specified
BEGIN
    -- Calculate GPA for a specific student
    FOR grade_record IN (SELECT grade, credits
                         FROM stugrades sg
                         JOIN courses c ON sg.Cid = c.Cid
                         WHERE sg.Id = student_id)
    LOOP
        CASE grade_record.grade
            WHEN 'A' THEN v_total_points := v_total_points + (4 * grade_record.credits);
            WHEN 'B' THEN v_total_points := v_total_points + (3 * grade_record.credits);
            WHEN 'C' THEN v_total_points := v_total_points + (2 * grade_record.credits);
            WHEN 'D' THEN v_total_points := v_total_points + (1 * grade_record.credits);
            WHEN 'F' THEN v_total_points := v_total_points + (0 * grade_record.credits);
            ELSE
                v_total_points := v_total_points + (0 * grade_record.credits);
        END CASE;

        v_total_credits := v_total_credits + grade_record.credits;
    END LOOP;

    -- Avoid division by zero
    IF v_total_credits = 0 THEN
        gpa_out := NULL;
    ELSE
        -- Calculate GPA without specifying precision
        v_gpa := v_total_points / v_total_credits;

        -- Round to two decimal places
        gpa_out := ROUND(v_gpa, 2);
    END IF;
END;

-- Procedure to get student courses
CREATE OR REPLACE PROCEDURE GetStudentCourses (
    p_StudentId IN NUMBER,
    p_Result OUT VARCHAR2
)
IS
    TYPE CourseNameList IS TABLE OF VARCHAR2(4000) INDEX BY PLS_INTEGER;
    v_Courses CourseNameList;

BEGIN
    -- Initialize the result string
    p_Result := '';

    -- Fetch course names for the given student using bulk collection
    SELECT crs.name BULK COLLECT INTO v_Courses
    FROM courses crs
    JOIN stugrades grd ON crs.cid = grd.cid
    WHERE grd.id = p_StudentId
    ORDER BY 1;

    -- Concatenate courses into a single string
    FOR i IN 1..v_Courses.COUNT
    LOOP
        p_Result := p_Result || v_Courses(i) || '|';
    END LOOP;

    -- Remove the trailing "|"
    p_Result := RTRIM(p_Result, '|');
END;

-- Test the GetStudentCourses procedure
SET SERVEROUTPUT ON;
DECLARE
    v_Result VARCHAR2(4000);
BEGIN
    GetStudentCourses(20, v_Result);
    DBMS_OUTPUT.PUT_LINE('Student 1 Courses: ' || v_Result);
END;

-- Procedure to get department courses
CREATE OR REPLACE PROCEDURE GetDepartmentCourses (
    p_DepartmentName IN VARCHAR2,
    p_Result OUT VARCHAR2
)
IS
    TYPE CourseNameList IS TABLE OF VARCHAR2(4000) INDEX BY PLS_INTEGER;
    v_Courses CourseNameList;

BEGIN
    -- Initialize the result string
    p_Result := '';

    -- Fetch course names for the given department using bulk collection
    SELECT crs.name BULK COLLECT INTO v_Courses
    FROM courses crs
    WHERE crs.Did = (SELECT Did FROM departments WHERE name = p_DepartmentName)
    ORDER BY 1;

    -- Concatenate courses into a single string
    FOR i IN 1..v_Courses.COUNT
    LOOP
        p_Result := p_Result || v_Courses(i) || '|';
    END LOOP;

    -- Remove the trailing "|"
    p_Result := RTRIM(p_Result, '|');
END;

-- Test the GetDepartmentCourses procedure
SET SERVEROUTPUT ON;
DECLARE
    v_Result VARCHAR2(4000);
BEGIN
    GetDepartmentCourses('Computer Science', v_Result);
    DBMS_OUTPUT.PUT_LINE('Courses in Computer Science Department: ' || v_Result);
END;

-----------------------------------------------------------------------------------------------------------------------------

-- Procedure to update student grade
CREATE OR REPLACE PROCEDURE UpdateStudentGrade (
    p_StudentId IN NUMBER,
    p_CourseName IN VARCHAR2,
    p_Grade IN VARCHAR2
)
IS
BEGIN
    -- Update the grade for the specified student and course
    UPDATE stugrades
    SET grade = p_Grade
    WHERE id = p_StudentId
      AND cid = (SELECT cid FROM courses WHERE name = p_CourseName);
    -- Commit the transaction
    COMMIT;
END;

-- Test the UpdateStudentGrade procedure
-- Note: Replace the placeholders with actual values before executing
BEGIN
    UpdateStudentGrade(
        p_StudentId => 1,
        p_CourseName => 'New Data Structures and Algorithms',
        p_Grade => 'B'
    );
END;

-------------------------------------------------------------------------------------------------------------------------------

-- Procedure to enroll students into new courses
CREATE OR REPLACE PROCEDURE EnrollStudent (
    p_Id IN NUMBER,
    p_CourseName IN VARCHAR2
)
IS
BEGIN
    -- Insert into stugrades directly
    INSERT INTO stugrades (id, cid)
    VALUES (p_Id, (SELECT cid FROM courses WHERE name = p_CourseName));

    -- Commit the transaction
    COMMIT;
END;

-- Create a view of departments with courses
CREATE OR REPLACE VIEW DepartmentCoursesView AS
SELECT d.name AS department_name, c.cid, c.name AS course_name
FROM courses c
JOIN departments d ON c.Did = d.Did;

-- Test the view
SELECT * FROM DepartmentCoursesView;

-- Create a view of students with departments
CREATE OR REPLACE VIEW StudentDepartmentView AS
SELECT s.id, s.name AS student_name, d.name AS department_name
FROM students s
JOIN departments d ON s.Did = d.Did
ORDER BY id;

-- Test the view
SELECT * FROM StudentDepartmentView;

-- Create a view of students with courses and grades
CREATE OR REPLACE VIEW StudentCourseNamesView AS
SELECT 
    s.id AS student_id, c.cid as course_id,
    s.name AS student_name, 
    c.name AS course_name, SG.GRADE as grade
FROM 
    students s
JOIN 
    stugrades sg ON s.id = sg.id
JOIN 
    courses c ON sg.cid = c.cid
ORDER BY 1;

-- Sequence-trigger pair for department ID
-- Sequence
CREATE SEQUENCE SCHOOL.DEPARTMENTS_SEQ
START WITH 110
INCREMENT BY 10
MAXVALUE 999999999999999999999999999
MINVALUE 1
NOCYCLE
CACHE 20
NOORDER;

-- Trigger
CREATE OR REPLACE TRIGGER SCHOOL.DEPARTMENTS_TRG
BEFORE INSERT ON SCHOOL.DEPARTMENTS
REFERENCING NEW AS New OLD AS Old
FOR EACH ROW
BEGIN
    -- For Toad: Highlight column DID
    :new.DID := DEPARTMENTS_SEQ.nextval;
END DEPARTMENTS_TRG;

--------------------------------------------------------------------------------------------------------------------------------

-- Sequence-trigger pair for course ID
-- Sequence
CREATE SEQUENCE SCHOOL.COURSES_SEQ
START WITH 33
MAXVALUE 999999999999999999999999999
MINVALUE 1
NOCYCLE
CACHE 20
NOORDER;

-- Trigger
CREATE OR REPLACE TRIGGER SCHOOL.COURSES_TRG
BEFORE INSERT ON SCHOOL.COURSES
REFERENCING NEW AS New OLD AS Old
FOR EACH ROW
BEGIN
    -- For Toad: Highlight column CID
    :new.CID := COURSES_SEQ.nextval;
END COURSES_TRG;
