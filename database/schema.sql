--Shema :

-- 1. Departments Table
CREATE TABLE departments (
    Did NUMBER PRIMARY KEY,
    name VARCHAR2(50)
);

-- 2. Students Table
CREATE TABLE students (
    ID NUMBER PRIMARY KEY,
    name VARCHAR2(50),
    stulevel VARCHAR2(15),
    email VARCHAR2(50),
    Did NUMBER,
    CONSTRAINT fk_students_departments 
        FOREIGN KEY (Did) REFERENCES departments(Did) ON DELETE CASCADE
);

-- Add the new foreign key constraint with ON DELETE SET NULL
ALTER TABLE students
DROP CONSTRAINT  fk_students_departments; 

ALTER TABLE students
ADD CONSTRAINT  fk_students_departments 
FOREIGN KEY (did)
REFERENCES departments(did)
ON DELETE SET NULL;

-- 3. Courses Table
CREATE TABLE courses (
    Cid NUMBER PRIMARY KEY,
    name VARCHAR2(50),
    Did NUMBER,
    credits NUMBER(1),
    CONSTRAINT fk_courses_departments 
        FOREIGN KEY (Did) REFERENCES departments(Did) ON DELETE CASCADE
);

ALTER TABLE courses
MODIFY credits NUMBER(1) DEFAULT 3;

-- Add the new foreign key constraint with ON DELETE SET NULL
ALTER TABLE courses
DROP CONSTRAINT fk_courses_departments;

ALTER TABLE courses
ADD CONSTRAINT fk_courses_departments
FOREIGN KEY (did)
REFERENCES departments(did)
ON DELETE SET NULL;

-- 4. StuGrades Table
CREATE TABLE stugrades (
    Id NUMBER,
    Cid NUMBER,
    grade VARCHAR2(2),
    semester VARCHAR2(20),
     year NUMBER,
    PRIMARY KEY (Id, Cid),
    CONSTRAINT fk_stugrades_students 
        FOREIGN KEY (Id) REFERENCES students(ID) ON DELETE CASCADE,
    CONSTRAINT fk_stugrades_courses 
        FOREIGN KEY (Cid) REFERENCES courses(Cid) ON DELETE CASCADE
);


    

--Test 
-- Assuming the following columns in the departments table: Did, name
INSERT INTO departments VALUES (10, 'Computer Science');
INSERT INTO departments VALUES (20, 'Electrical Engineering');
INSERT INTO departments VALUES (30, 'Mechanical Engineering');
INSERT INTO departments VALUES (40, 'Physics');
INSERT INTO departments VALUES (50, 'Chemistry');
INSERT INTO departments VALUES (60, 'Biology');
INSERT INTO departments VALUES (70, 'Mathematics');
INSERT INTO departments VALUES (80, 'Economics');
INSERT INTO departments VALUES (90, 'History');
INSERT INTO departments VALUES (100, 'Psychology');
    
   
-- Assuming the following columns in the students table: ID, name, stulevel, email, Did
INSERT INTO students VALUES (1, 'John Doe', '1st', 'john.doe@example.com', 10);
INSERT INTO students VALUES (2, 'Jane Smith', '2nd', 'jane.smith@example.com', 20);
INSERT INTO students VALUES (3, 'Bob Johnson', '3rd', 'bob.johnson@example.com', 30);
INSERT INTO students VALUES (4, 'Alice Williams', '4th', 'alice.williams@example.com', 40);
INSERT INTO students VALUES (5, 'Charlie Brown', '1st', 'charlie.brown@example.com', 50);
INSERT INTO students VALUES (6, 'Eva Davis', '2nd', 'eva.davis@example.com', 60);
INSERT INTO students VALUES (7, 'Frank Wilson', '3rd', 'frank.wilson@example.com', 70);
INSERT INTO students VALUES (8, 'Grace Taylor', '4th', 'grace.taylor@example.com', 80);
INSERT INTO students VALUES (9, 'David Lee', '1st', 'david.lee@example.com', 90);
INSERT INTO students VALUES (10, 'Helen White', '2nd', 'helen.white@example.com', 100);
INSERT INTO students VALUES (11, 'James Miller', '3rd', 'james.miller@example.com', 10);
INSERT INTO students VALUES (12, 'Karen Davis', '4th', 'karen.davis@example.com', 20);
INSERT INTO students VALUES (13, 'Mark Johnson', '1st', 'mark.johnson@example.com', 30);
INSERT INTO students VALUES (14, 'Olivia Brown', '2nd', 'olivia.brown@example.com', 40);
INSERT INTO students VALUES (15, 'Paula Taylor', '3rd', 'paula.taylor@example.com', 50);
INSERT INTO students VALUES (16, 'Quincy Adams', '3rd', 'quincy.adams@example.com', 60);
INSERT INTO students VALUES (17, 'Rachel Evans', '1st', 'rachel.evans@example.com', 70);
INSERT INTO students VALUES (18, 'Samuel Thompson', '4th', 'samuel.thompson@example.com', 80);
INSERT INTO students VALUES (19, 'Tina Martinez', '2nd', 'tina.martinez@example.com', 90);
INSERT INTO students VALUES (20, 'Ulysses Turner', '3rd', 'ulysses.turner@example.com', 100);
INSERT INTO students VALUES (21, 'Vera Wilson', '1st', 'vera.wilson@example.com', 10);
INSERT INTO students VALUES (22, 'Walter Lewis', '4th', 'walter.lewis@example.com', 20);
INSERT INTO students VALUES (23, 'Xena Carter', '2nd', 'xena.carter@example.com', 30);
INSERT INTO students VALUES (24, 'Yvonne Harris', '3rd', 'yvonne.harris@example.com', 40);
INSERT INTO students VALUES (25, 'Zane King', '1st', 'zane.king@example.com', 50);
INSERT INTO students VALUES (26, 'Abby Brown', '4th', 'abby.brown@example.com', 60);
INSERT INTO students VALUES (27, 'Benjamin Foster', '2nd', 'benjamin.foster@example.com', 70);
INSERT INTO students VALUES (28, 'Cynthia Hill', '3rd', 'cynthia.hill@example.com', 80);
INSERT INTO students VALUES (29, 'Dylan Parker', '1st', 'dylan.parker@example.com', 90);
INSERT INTO students VALUES (30, 'Ella Mitchell', '4th', 'ella.mitchell@example.com', 100);
INSERT INTO students VALUES (31, 'John Doe 2', '1st', 'john.doe2@example.com', 10);
INSERT INTO students VALUES (32, 'Jane Smith 2', '2nd', 'jane.smith2@example.com', 20);
INSERT INTO students VALUES (33, 'Bob Johnson 2', '3rd', 'bob.johnson2@example.com', 30);
INSERT INTO students VALUES (34, 'Alice Williams 2', '4th', 'alice.williams2@example.com', 40);
INSERT INTO students VALUES (35, 'Charlie Brown 2', '1st', 'charlie.brown2@example.com', 50);
INSERT INTO students VALUES (36, 'Eva Davis 2', '2nd', 'eva.davis2@example.com', 60);
INSERT INTO students VALUES (37, 'Frank Wilson 2', '3rd', 'frank.wilson2@example.com', 70);
INSERT INTO students VALUES (38, 'Grace Taylor 2', '4th', 'grace.taylor2@example.com', 80);
INSERT INTO students VALUES (39, 'David Lee 2', '1st', 'david.lee2@example.com', 90);
INSERT INTO students VALUES (40, 'Helen White 2', '2nd', 'helen.white2@example.com', 100);
INSERT INTO students VALUES (41, 'James Miller 2', '3rd', 'james.miller2@example.com', 10);
INSERT INTO students VALUES (42, 'Karen Davis 2', '4th', 'karen.davis2@example.com', 20);
INSERT INTO students VALUES (43, 'Mark Johnson 2', '1st', 'mark.johnson2@example.com', 30);
INSERT INTO students VALUES (44, 'Olivia Brown 2', '2nd', 'olivia.brown2@example.com', 40);
INSERT INTO students VALUES (45, 'Paula Taylor 2', '3rd', 'paula.taylor2@example.com', 50);
INSERT INTO students VALUES (46, 'Quincy Adams 2', '3rd', 'quincy.adams2@example.com', 60);
INSERT INTO students VALUES (47, 'Rachel Evans 2', '1st', 'rachel.evans2@example.com', 70);
INSERT INTO students VALUES (48, 'Samuel Thompson 2', '4th', 'samuel.thompson2@example.com', 80);
INSERT INTO students VALUES (49, 'Tina Martinez 2', '2nd', 'tina.martinez2@example.com', 90);
INSERT INTO students VALUES (50, 'Ulysses Turner 2', '3rd', 'ulysses.turner2@example.com', 100);
INSERT INTO students VALUES (51, 'Vera Wilson 2', '1st', 'vera.wilson2@example.com', 10);
INSERT INTO students VALUES (52, 'Walter Lewis 2', '4th', 'walter.lewis2@example.com', 20);
INSERT INTO students VALUES (53, 'Xena Carter 2', '2nd', 'xena.carter2@example.com', 30);
INSERT INTO students VALUES (54, 'Yvonne Harris 2', '3rd', 'yvonne.harris2@example.com', 40);
INSERT INTO students VALUES (55, 'Zane King 2', '1st', 'zane.king2@example.com', 50);
INSERT INTO students VALUES (56, 'Abby Brown 2', '4th', 'abby.brown2@example.com', 60);
INSERT INTO students VALUES (57, 'Benjamin Foster 2', '2nd', 'benjamin.foster2@example.com', 70);
INSERT INTO students VALUES (58, 'Cynthia Hill 2', '3rd', 'cynthia.hill2@example.com', 80);
INSERT INTO students VALUES (59, 'Dylan Parker 2', '1st', 'dylan.parker2@example.com', 90);
INSERT INTO students VALUES (60, 'Ella Mitchell 2', '4th', 'ella.mitchell2@example.com', 100);
INSERT INTO students VALUES (91, 'NewName1', '1st', 'john.doe@example.com', 10);
INSERT INTO students VALUES (92, 'NewName2', '2nd', 'jane.smith@example.com', 20);
INSERT INTO students VALUES (93, 'NewName3', '3rd', 'bob.johnson@example.com', 30);
INSERT INTO students VALUES (94, 'NewName4', '4th', 'alice.williams@example.com', 40);
INSERT INTO students VALUES (95, 'NewName5', '1st', 'charlie.brown@example.com', 50);
INSERT INTO students VALUES (96, 'NewName6', '2nd', 'eva.davis@example.com', 60);
INSERT INTO students VALUES (97, 'NewName7', '3rd', 'frank.wilson@example.com', 70);
INSERT INTO students VALUES (98, 'NewName8', '4th', 'grace.taylor@example.com', 80);
INSERT INTO students VALUES (99, 'NewName9', '1st', 'david.lee@example.com', 90);
INSERT INTO students VALUES (100, 'NewName10', '2nd', 'helen.white@example.com', 100);
INSERT INTO students VALUES (101, 'NewName11', '3rd', 'james.miller@example.com', 10);
INSERT INTO students VALUES (102, 'NewName12', '4th', 'karen.davis@example.com', 20);
INSERT INTO students VALUES (103, 'NewName13', '1st', 'mark.johnson@example.com', 30);
INSERT INTO students VALUES (104, 'NewName14', '2nd', 'olivia.brown@example.com', 40);
INSERT INTO students VALUES (105, 'NewName15', '3rd', 'paula.taylor@example.com', 50);
INSERT INTO students VALUES (106, 'NewName16', '3rd', 'quincy.adams@example.com', 60);
INSERT INTO students VALUES (107, 'NewName17', '1st', 'rachel.evans@example.com', 70);
INSERT INTO students VALUES (108, 'NewName18', '4th', 'samuel.thompson@example.com', 80);
INSERT INTO students VALUES (109, 'NewName19', '2nd', 'tina.martinez@example.com', 90);
INSERT INTO students VALUES (110, 'NewName20', '3rd', 'ulysses.turner@example.com', 100);
INSERT INTO students VALUES (111, 'NewName21', '1st', 'vera.wilson@example.com', 10);
INSERT INTO students VALUES (112, 'NewName22', '4th', 'walter.lewis@example.com', 20);
INSERT INTO students VALUES (113, 'NewName23', '2nd', 'xena.carter@example.com', 30);
INSERT INTO students VALUES (114, 'NewName24', '3rd', 'yvonne.harris@example.com', 40);
INSERT INTO students VALUES (115, 'NewName25', '1st', 'zane.king@example.com', 50);
INSERT INTO students VALUES (116, 'NewName26', '4th', 'abby.brown@example.com', 60);
INSERT INTO students VALUES (117, 'NewName27', '2nd', 'benjamin.foster@example.com', 70);
INSERT INTO students VALUES (118, 'NewName28', '3rd', 'cynthia.hill@example.com', 80);
INSERT INTO students VALUES (119, 'NewName29', '1st', 'dylan.parker@example.com', 90);
INSERT INTO students VALUES (120, 'NewName30', '4th', 'ella.mitchell@example.com', 100);
-- Additional insert statements for more students (IDs 211 to 260)
INSERT INTO students VALUES (211, 'Fiona Adams', '1st', 'fiona.adams@example.com', 10);
INSERT INTO students VALUES (241, 'George Turner', '2nd', 'george.turner@example.com', 20);
INSERT INTO students VALUES (271, 'Heather Carter', '3rd', 'heather.carter@example.com', 30);
INSERT INTO students VALUES (301, 'Ivan Harris', '4th', 'ivan.harris@example.com', 40);
INSERT INTO students VALUES (331, 'Julia King', '1st', 'julia.king@example.com', 50);
INSERT INTO students VALUES (361, 'Kyle Mitchell', '2nd', 'kyle.mitchell@example.com', 60);
INSERT INTO students VALUES (391, 'Lily Foster', '3rd', 'lily.foster@example.com', 70);
INSERT INTO students VALUES (421, 'Max Hill', '4th', 'max.hill@example.com', 80);
INSERT INTO students VALUES (451, 'Nora Parker', '1st', 'nora.parker@example.com', 90);
INSERT INTO students VALUES (481, 'Oscar Lewis', '2nd', 'oscar.lewis@example.com', 100);
INSERT INTO students VALUES (511, 'Penny Carter', '3rd', 'penny.carter@example.com', 10);
INSERT INTO students VALUES (541, 'Quentin Brown', '4th', 'quentin.brown@example.com', 20);
INSERT INTO students VALUES (571, 'Riley Turner', '1st', 'riley.turner@example.com', 30);
INSERT INTO students VALUES (601, 'Sofia Davis', '2nd', 'sofia.davis@example.com', 40);
INSERT INTO students VALUES (631, 'Travis Smith', '3rd', 'travis.smith@example.com', 50);
INSERT INTO students VALUES (661, 'Uma Martinez', '4th', 'uma.martinez@example.com', 60);
INSERT INTO students VALUES (691, 'Victor White', '1st', 'victor.white@example.com', 70);
INSERT INTO students VALUES (721, 'Wendy Wilson', '2nd', 'wendy.wilson@example.com', 80);
INSERT INTO students VALUES (751, 'Xander Anderson', '3rd', 'xander.anderson@example.com', 90);
INSERT INTO students VALUES (781, 'Yasmine Brown', '4th', 'yasmine.brown@example.com', 100);
INSERT INTO students VALUES (811, 'Zack Taylor', '1st', 'zack.taylor@example.com', 10);
INSERT INTO students VALUES (841, 'Amelia Turner', '4th', 'amelia.turner@example.com', 20);
INSERT INTO students VALUES (871, 'Bryan Mitchell', '2nd', 'bryan.mitchell@example.com', 30);
INSERT INTO students VALUES (901, 'Chloe Foster', '3rd', 'chloe.foster@example.com', 40);
INSERT INTO students VALUES (931, 'Derek Hill', '1st', 'derek.hill@example.com', 50);
INSERT INTO students VALUES (961, 'Eva Parker', '4th', 'eva.parker@example.com', 60);
INSERT INTO students VALUES (991, 'Felix Adams', '2nd', 'felix.adams@example.com', 70);
INSERT INTO students VALUES (1021, 'Giselle Smith', '3rd', 'giselle.smith@example.com', 80);
INSERT INTO students VALUES (1051, 'Harrison Carter', '1st', 'harrison.carter@example.com', 90);
INSERT INTO students VALUES (1081, 'Isabel Harris', '4th', 'isabel.harris@example.com', 100);






-- Assuming the following columns in the courses table: Cid, name, Did
-- Insert 20 courses
INSERT INTO courses VALUES (101, 'Introduction to Programming', 10, 3);
INSERT INTO courses VALUES (102, 'Database Management', 20, 3);
INSERT INTO courses VALUES (103, 'Computer Networks', 30, 3);
INSERT INTO courses VALUES (104, 'Mechanics of Materials', 40, 3);
INSERT INTO courses VALUES (105, 'Organic Chemistry', 50, 3);
INSERT INTO courses VALUES (106, 'Cell Biology', 60, 3);
INSERT INTO courses VALUES (107, 'Calculus I', 70, 3);
INSERT INTO courses VALUES (108, 'Microeconomics', 80, 3);
INSERT INTO courses VALUES (109, 'World History', 90, 3);
INSERT INTO courses VALUES (110, 'Introduction to Psychology', 100, 3);
INSERT INTO courses VALUES (111, 'Data Structures and Algorithms', 10, 3);
INSERT INTO courses VALUES (112, 'Software Engineering', 20, 3);
INSERT INTO courses VALUES (113, 'Computer Architecture', 30, 3);
INSERT INTO courses VALUES (114, 'Thermodynamics', 40, 3);
INSERT INTO courses VALUES (115, 'Inorganic Chemistry', 50, 3);
INSERT INTO courses VALUES (116, 'Genetics', 60, 3);
INSERT INTO courses VALUES (117, 'Calculus II', 70, 3);
INSERT INTO courses VALUES (118, 'Macroeconomics', 80, 3);
INSERT INTO courses VALUES (119, 'Modern History', 90, 3);
INSERT INTO courses VALUES (120, 'Abnormal Psychology', 100, 3);
INSERT INTO courses VALUES (121, 'New Introduction to Programming', 30, 3);
INSERT INTO courses VALUES (122, 'New Database Management', 40, 3);
INSERT INTO courses VALUES (123, 'New Computer Networks', 50, 3);
INSERT INTO courses VALUES (124, 'New Mechanics of Materials', 60, 3);
INSERT INTO courses VALUES (125, 'New Organic Chemistry', 70, 3);
INSERT INTO courses VALUES (126, 'New Cell Biology', 80, 3);
INSERT INTO courses VALUES (127, 'New Calculus I', 90, 3);
INSERT INTO courses VALUES (128, 'New Microeconomics', 100, 3);
INSERT INTO courses VALUES (129, 'New World History', 110, 3);
INSERT INTO courses VALUES (130, 'New Introduction to Psychology', 120, 3);
INSERT INTO courses VALUES (131, 'New Data Structures and Algorithms', 30, 3);
INSERT INTO courses VALUES (132, 'New Software Engineering', 40, 3);
INSERT INTO courses VALUES (133, 'New Computer Architecture', 50, 3);
INSERT INTO courses VALUES (134, 'New Thermodynamics', 60, 3);
INSERT INTO courses VALUES (135, 'New Inorganic Chemistry', 70, 3);
INSERT INTO courses VALUES (136, 'New Genetics', 80, 3);
INSERT INTO courses VALUES (137, 'New Calculus II', 90, 3);
INSERT INTO courses VALUES (138, 'New Macroeconomics', 100, 3);
INSERT INTO courses VALUES (139, 'New Modern History', 110, 3);
INSERT INTO courses VALUES (140, 'New Abnormal Psychology', 120, 3);



-- Assuming the following columns in the stugrades table: Id, Cid, grade
-- Enroll the first 30 students in courses
INSERT INTO stugrades (id, cid, grade) VALUES (1, 101, 'A');
INSERT INTO stugrades (id, cid, grade) VALUES (2, 102, 'B');
INSERT INTO stugrades (id, cid, grade) VALUES (3, 103, 'C');
INSERT INTO stugrades (id, cid, grade) VALUES (4, 104, 'A');
INSERT INTO stugrades (id, cid, grade) VALUES (5, 105, 'B');
INSERT INTO stugrades (id, cid, grade) VALUES (6, 106, 'C');
INSERT INTO stugrades (id, cid, grade) VALUES (7, 107, 'A');
INSERT INTO stugrades (id, cid, grade) VALUES (8, 108, 'B');
INSERT INTO stugrades (id, cid, grade) VALUES (9, 109, 'C');
INSERT INTO stugrades (id, cid, grade) VALUES (11, 110, 'A');
INSERT INTO stugrades (id, cid, grade) VALUES (11, 111, 'B');
INSERT INTO stugrades (id, cid, grade) VALUES (11, 112, 'C');
INSERT INTO stugrades (id, cid, grade) VALUES (12, 113, 'A');
INSERT INTO stugrades (id, cid, grade) VALUES (12, 114, 'B');
INSERT INTO stugrades (id, cid, grade) VALUES (12, 115, 'C');
INSERT INTO stugrades (id, cid, grade) VALUES (13, 101, 'A');
INSERT INTO stugrades (id, cid, grade) VALUES (13, 102, 'B');
INSERT INTO stugrades (id, cid, grade) VALUES (14, 103, 'C');
INSERT INTO stugrades (id, cid, grade) VALUES (14, 104, 'A');
INSERT INTO stugrades (id, cid, grade) VALUES (15, 105, 'B');
INSERT INTO stugrades (id, cid, grade) VALUES (15, 106, 'C');
INSERT INTO stugrades (id, cid, grade) VALUES (16, 107, 'A');
INSERT INTO stugrades (id, cid, grade) VALUES (16, 108, 'B');
INSERT INTO stugrades (id, cid, grade) VALUES (16, 109, 'C');
INSERT INTO stugrades (id, cid, grade) VALUES (17, 110, 'A');
INSERT INTO stugrades (id, cid, grade) VALUES (17, 111, 'B');
INSERT INTO stugrades (id, cid, grade) VALUES (17, 112, 'C');
INSERT INTO stugrades (id, cid, grade) VALUES (18, 113, 'A');
INSERT INTO stugrades (id, cid, grade) VALUES (18, 114, 'B');
INSERT INTO stugrades (id, cid, grade) VALUES (18, 115, 'C');
-- Additional insert statements for enrolling students in courses (IDs 141 to 180)
INSERT INTO stugrades VALUES (31, 141, 'A');
INSERT INTO stugrades VALUES (32, 142, 'B');
INSERT INTO stugrades VALUES (33, 143, 'C');
INSERT INTO stugrades VALUES (34, 144, 'A');
INSERT INTO stugrades VALUES (35, 145, 'B');
INSERT INTO stugrades VALUES (36, 146, 'C');
INSERT INTO stugrades VALUES (37, 147, 'A');
INSERT INTO stugrades VALUES (38, 148, 'B');
INSERT INTO stugrades VALUES (39, 149, 'C');
INSERT INTO stugrades VALUES (40, 150, 'A');
INSERT INTO stugrades VALUES (41, 151, 'B');
INSERT INTO stugrades VALUES (42, 152, 'C');
INSERT INTO stugrades VALUES (43, 153, 'A');
INSERT INTO stugrades VALUES (44, 154, 'B');
INSERT INTO stugrades VALUES (45, 155, 'C');
INSERT INTO stugrades VALUES (46, 156, 'A');
INSERT INTO stugrades VALUES (47, 157, 'B');
INSERT INTO stugrades VALUES (48, 158, 'C');
INSERT INTO stugrades VALUES (49, 159, 'A');
INSERT INTO stugrades VALUES (50, 160, 'B');
INSERT INTO stugrades VALUES (51, 121, 'C');
INSERT INTO stugrades VALUES (52, 122, 'A');
INSERT INTO stugrades VALUES (53, 123, 'B');
INSERT INTO stugrades VALUES (54, 124, 'C');
INSERT INTO stugrades VALUES (55, 125, 'A');
INSERT INTO stugrades VALUES (56, 126, 'B');
INSERT INTO stugrades VALUES (57, 127, 'C');
INSERT INTO stugrades VALUES (58, 128, 'A');
INSERT INTO stugrades VALUES (59, 129, 'B');
INSERT INTO stugrades VALUES (60, 130, 'C');
INSERT INTO stugrades VALUES (91, 131, 'A');
INSERT INTO stugrades VALUES (92, 132, 'B');
INSERT INTO stugrades VALUES (93, 133, 'C');
INSERT INTO stugrades VALUES (94, 134, 'A');
INSERT INTO stugrades VALUES (95, 135, 'B');
INSERT INTO stugrades VALUES (96, 136, 'C');
INSERT INTO stugrades VALUES (97, 137, 'A');
INSERT INTO stugrades VALUES (98, 138, 'B');
INSERT INTO stugrades VALUES (99, 139, 'C');
INSERT INTO stugrades VALUES (100, 140, 'A');



-- Student 1
INSERT INTO stugrades (id, cid, grade) VALUES (1, 101, 'A');
INSERT INTO stugrades (id, cid, grade) VALUES (1, 102, 'B');
INSERT INTO stugrades (id, cid, grade) VALUES (1, 103, 'C');

-- Student 2
INSERT INTO stugrades (id, cid, grade) VALUES (2, 104, 'A');
INSERT INTO stugrades (id, cid, grade) VALUES (2, 105, 'B');
INSERT INTO stugrades (id, cid, grade) VALUES (2, 106, 'C');

-- Student 9
INSERT INTO stugrades (id, cid, grade) VALUES (9, 113, 'A');
INSERT INTO stugrades (id, cid, grade) VALUES (9, 114, 'B');
INSERT INTO stugrades (id, cid, grade) VALUES (9, 115, 'C');

-- Student 10
INSERT INTO stugrades (id, cid, grade) VALUES (10, 101, 'A');
INSERT INTO stugrades (id, cid, grade) VALUES (10, 102, 'B');
INSERT INTO stugrades (id, cid, grade) VALUES (10, 103, 'C');

INSERT INTO stugrades (id, cid, grade) VALUES (3, 107, 'A');
INSERT INTO stugrades (id, cid, grade) VALUES (3, 108, 'B');
INSERT INTO stugrades (id, cid, grade) VALUES (3, 109, 'C');

-- Student 4
INSERT INTO stugrades (id, cid, grade) VALUES (4, 110, 'A');
INSERT INTO stugrades (id, cid, grade) VALUES (4, 111, 'B');
INSERT INTO stugrades (id, cid, grade) VALUES (4, 112, 'C');

-- Student 5
INSERT INTO stugrades (id, cid, grade) VALUES (5, 113, 'A');
INSERT INTO stugrades (id, cid, grade) VALUES (5, 114, 'B');
INSERT INTO stugrades (id, cid, grade) VALUES (5, 115, 'C');

-- Student 6
INSERT INTO stugrades (id, cid, grade) VALUES (6, 101, 'A');
INSERT INTO stugrades (id, cid, grade) VALUES (6, 102, 'B');
INSERT INTO stugrades (id, cid, grade) VALUES (6, 103, 'C');

-- Student 7
INSERT INTO stugrades (id, cid, grade) VALUES (7, 104, 'A');
INSERT INTO stugrades (id, cid, grade) VALUES (7, 105, 'B');
INSERT INTO stugrades (id, cid, grade) VALUES (7, 106, 'C');

-- Student 8
INSERT INTO stugrades (id, cid, grade) VALUES (8, 107, 'A');
INSERT INTO stugrades (id, cid, grade) VALUES (8, 108, 'B');
INSERT INTO stugrades (id, cid, grade) VALUES (8, 109, 'C');

-- Additional insert statements for more students (IDs 121 to 170) in courses (101 to 140)
INSERT INTO stugrades (id, cid, grade) VALUES (45, 101, 'B');
INSERT INTO stugrades (id, cid, grade) VALUES (45, 102, 'C');
INSERT INTO stugrades (id, cid, grade) VALUES (45, 103, 'A');

INSERT INTO stugrades (id, cid, grade) VALUES (46, 104, 'C');
INSERT INTO stugrades (id, cid, grade) VALUES (46, 105, 'A');
INSERT INTO stugrades (id, cid, grade) VALUES (46, 106, 'B');

INSERT INTO stugrades (id, cid, grade) VALUES (47, 107, 'A');
INSERT INTO stugrades (id, cid, grade) VALUES (47, 108, 'B');
INSERT INTO stugrades (id, cid, grade) VALUES (47, 109, 'C');

INSERT INTO stugrades (id, cid, grade) VALUES (48, 110, 'B');
INSERT INTO stugrades (id, cid, grade) VALUES (48, 111, 'C');
INSERT INTO stugrades (id, cid, grade) VALUES (48, 112, 'A');

INSERT INTO stugrades (id, cid, grade) VALUES (49, 113, 'A');
INSERT INTO stugrades (id, cid, grade) VALUES (49, 114, 'B');
INSERT INTO stugrades (id, cid, grade) VALUES (49, 115, 'C');

INSERT INTO stugrades (id, cid, grade) VALUES (50, 116, 'B');
INSERT INTO stugrades (id, cid, grade) VALUES (50, 117, 'C');
INSERT INTO stugrades (id, cid, grade) VALUES (50, 118, 'A');

-- Continue this pattern for more students and courses as needed
-- Additional insert statements for more students (IDs 51 to 100) in courses (101 to 140)
INSERT INTO stugrades (id, cid, grade) VALUES (51, 101, 'A');
INSERT INTO stugrades (id, cid, grade) VALUES (51, 102, 'B');
INSERT INTO stugrades (id, cid, grade) VALUES (51, 103, 'C');

INSERT INTO stugrades (id, cid, grade) VALUES (52, 104, 'C');
INSERT INTO stugrades (id, cid, grade) VALUES (52, 105, 'A');
INSERT INTO stugrades (id, cid, grade) VALUES (52, 106, 'B');

INSERT INTO stugrades (id, cid, grade) VALUES (53, 107, 'A');
INSERT INTO stugrades (id, cid, grade) VALUES (53, 108, 'B');
INSERT INTO stugrades (id, cid, grade) VALUES (53, 109, 'C');

INSERT INTO stugrades (id, cid, grade) VALUES (54, 110, 'B');
INSERT INTO stugrades (id, cid, grade) VALUES (54, 111, 'C');
INSERT INTO stugrades (id, cid, grade) VALUES (54, 112, 'A');

INSERT INTO stugrades (id, cid, grade) VALUES (55, 113, 'A');
INSERT INTO stugrades (id, cid, grade) VALUES (55, 114, 'B');
INSERT INTO stugrades (id, cid, grade) VALUES (55, 115, 'C');

INSERT INTO stugrades (id, cid, grade) VALUES (56, 116, 'B');
INSERT INTO stugrades (id, cid, grade) VALUES (56, 117, 'C');
INSERT INTO stugrades (id, cid, grade) VALUES (56, 118, 'A');

-- Continue this pattern for more students and courses as needed

INSERT INTO stugrades (id, cid, grade) VALUES (100, 135, 'A');
INSERT INTO stugrades (id, cid, grade) VALUES (100, 136, 'B');
INSERT INTO stugrades (id, cid, grade) VALUES (100, 137, 'C');

-- End of additional insert statements







