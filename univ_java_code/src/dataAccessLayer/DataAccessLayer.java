package dataAccessLayer;

import static dataAccessLayer.DataAccessLayer.getAllDepartments;
import dto.Course;
import dto.Student;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import oracle.jdbc.OracleDriver;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class DataAccessLayer {
    private static volatile DataAccessLayer instance;
    private static Connection conn;
    private static ResultSet rs;

    private DataAccessLayer() throws SQLException {
        // Initialize the database connection
        DriverManager.registerDriver(new OracleDriver());
        conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "SCHOOL", "root");
    }

    public static DataAccessLayer getInstance() throws SQLException {
        // Singleton pattern to ensure only one instance of DataAccessLayer is created
        DataAccessLayer result = instance;
        if (result == null) {
            synchronized (DataAccessLayer.class) {
                result = instance;
                if (result == null) {
                    instance = result = new DataAccessLayer();
                }
            }
        }
        return result;
    }

    public Connection connect() {
        // Get the database connection
        return conn;
    }

    // Retrieve student details by ID
    public static Student getStudent(int id) throws SQLException {
        Connection con = DataAccessLayer.getInstance().connect();
        PreparedStatement pst = con.prepareStatement("SELECT name, stulevel, email, did FROM students WHERE id=?");
        pst.setInt(1, id);
        Student student = new Student();
        student.setDid(id);
        rs = pst.executeQuery();
        if (rs.next()) {
            student.setName(rs.getString("name"));
            student.setLevel(rs.getString("stulevel"));
            student.setEmail(rs.getString("email"));
            student.setDid(rs.getInt("did"));
        }
        System.out.println("student:" + student.toString());
        return student;
    }

    // Add a new student to the database
    public static void addStudent(int id, String name, String level, String email, int did) throws SQLException {
        Connection con = DataAccessLayer.getInstance().connect();
        PreparedStatement pst = con.prepareStatement("insert into students values(?,?,?,?,?)");
        pst.setInt(1, id);
        pst.setString(2, name);
        pst.setString(3, level);
        pst.setString(4, email);
        pst.setInt(5, did);
        pst.executeUpdate();
    }

    // Update student details in the database
    public static void updateStudent(int id, String name, String level, String email, int did) throws SQLException {
        Connection con = DataAccessLayer.getInstance().connect();
        CallableStatement pst = con.prepareCall("{call update_student_info(?,?,?,?,?)}");
        pst.setInt(1, id);
        pst.setString(2, name);
        pst.setString(3, level);
        pst.setString(4, email);
        pst.setInt(5, did);
        pst.execute();
    }

    // Retrieve the courses a student is enrolled in
    public static String getStudentCourses(int id) throws SQLException {
        Connection con = DataAccessLayer.getInstance().connect();
        CallableStatement pst = con.prepareCall("{call GetStudentCourses(?, ?)}");
        pst.setInt(1, id);
        pst.registerOutParameter(2, Types.VARCHAR); // Register the output parameter as VARCHAR
        pst.execute();
        // Retrieve the output parameter
        String courses = pst.getString(2);
        System.out.println(courses);
        return courses;
    }
    
    // Retrieve the courses of a department
    public static String getDepartmentCourses(String name) throws SQLException {
        Connection con = DataAccessLayer.getInstance().connect();
        CallableStatement pst = con.prepareCall("{call GetDepartmentCourses(?, ?)}");
        pst.setString(1, name);
        pst.registerOutParameter(2, Types.VARCHAR); // Register the output parameter as VARCHAR
        pst.execute();
        // Retrieve the output parameter
        String courses = pst.getString(2);
        System.out.println(courses);
        return courses;
    }
    
      // فيها مشكلة feha moshkla ???????????
    // Update the grade of a student for a specific course
    public static void updateGrade(int id, String course, String grade) throws SQLException {
        Connection con = DataAccessLayer.getInstance().connect();
        CallableStatement pst = con.prepareCall("{call UpdateStudentGrade(?,?,?)}");
        pst.setInt(1, id);
        pst.setString(2, course);
        pst.setString(3, grade);
        pst.execute();
    }

    // Retrieve a list of all courses from the database
    public static List<String> getAllCourses() throws SQLException {
        List<String> courses = new ArrayList<>();
        Connection con = DataAccessLayer.getInstance().connect();
        PreparedStatement pst = con.prepareStatement("SELECT distinct name FROM courses");
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            String course = rs.getString("name");
            courses.add(course);
        }
        return courses;
    }

    // Enroll a student in a specific course
    public static void enrollStudent(int id, String course) throws SQLException {
        Connection con = DataAccessLayer.getInstance().connect();
        CallableStatement pst = con.prepareCall("{call EnrollStudent(?,?)}");
        pst.setInt(1, id);
        pst.setString(2, course);
        pst.execute();
    }

    // Retrieve a list of all departments from the database
    public static List<String> getAllDepartments() throws SQLException {
        List<String> departments = new ArrayList<>();
        Connection con = DataAccessLayer.getInstance().connect();
        PreparedStatement pst = con.prepareStatement("SELECT departments.name FROM school.departments");
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            String depart = rs.getString("name");
            departments.add(depart);
        }
        return departments;
    }
    
    
    // get courses for specefic department 
    public static ObservableList<Course> fetchCoursesFromDatabase(String department) throws SQLException {
    ObservableList<Course> courses = FXCollections.observableArrayList();
    Connection connection = DataAccessLayer.getInstance().connect();
    PreparedStatement statement = null;
    ResultSet resultSet = null;
    try {
        statement = connection.prepareStatement("SELECT cid, course_name FROM DepartmentCoursesView where department_name = ?");
        statement.setString(1, department);
        resultSet = statement.executeQuery();
        // Process the result set and populate the list of courses
        while (resultSet.next()) {
            int courseId = resultSet.getInt("cid");
            String courseName = resultSet.getString("course_name");
            // Create a Course object and add it to the list
            Course course = new Course(courseId, courseName);
            courses.add(course);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return courses;
}


    public static ObservableList<Student> fetchStudentsFromDatabase(String department) throws SQLException {
    ObservableList<Student> students = FXCollections.observableArrayList();
    Connection connection = DataAccessLayer.getInstance().connect();
    PreparedStatement statement = null;
    ResultSet resultSet = null;
    
    try {
        statement = connection.prepareStatement("SELECT id, student_name FROM StudentDepartmentView where department_name = ?");
        statement.setString(1, department);
        resultSet = statement.executeQuery();

        // Process the result set and populate the list of courses
        while (resultSet.next()) {
            int studentId = resultSet.getInt("id");
            String studentName = resultSet.getString("student_name");
            // Create a Student object and add it to the list
            Student student = new Student(studentId, studentName);
            students.add(student);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return students;
    }
    
    
    public static ObservableList<Student> fetchStudentsByCourse(String courseName) throws SQLException {
    ObservableList<Student> students = FXCollections.observableArrayList();
    Connection connection = DataAccessLayer.getInstance().connect();
    PreparedStatement statement = null;
    ResultSet resultSet = null;
    
    try {
        statement = connection.prepareStatement("SELECT student_id, student_name FROM StudentCourseNamesView where course_name = ?");
        statement.setString(1, courseName);
        resultSet = statement.executeQuery();

        // Process the result set and populate the list of courses
        while (resultSet.next()) {
            int studentId = resultSet.getInt("student_id");
            String studentName = resultSet.getString("student_name");
            // Create a Student object and add it to the list
            Student student = new Student(studentId, studentName);
            students.add(student);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return students;
    }
     
    
    // overload
    public static ObservableList<Student> fetchStudentsByCourse(int course_id) throws SQLException {
    ObservableList<Student> students = FXCollections.observableArrayList();
    Connection connection = DataAccessLayer.getInstance().connect();
    PreparedStatement statement = null;
    ResultSet resultSet = null;
    
    try {
        statement = connection.prepareStatement("SELECT student_id, student_name FROM StudentCourseNamesView where course_id = ?");
        statement.setInt(1, course_id);
        resultSet = statement.executeQuery();

        // Process the result set and populate the list of courses
        while (resultSet.next()) {
            int studentId = resultSet.getInt("student_id");
            String studentName = resultSet.getString("student_name");
            // Create a Student object and add it to the list
            Student student = new Student(studentId, studentName);
            students.add(student);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return students;
    }
    
    


    public static Map<String, Double> getStudentGradePercentages(int studentId) throws SQLException {
        Connection connection = DataAccessLayer.getInstance().connect();
        Map<String, Integer> gradeCountMap = new HashMap<>();
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            statement = connection.prepareStatement("SELECT grade, COUNT(grade) AS count FROM StudentCourseNamesView WHERE student_id = ? GROUP BY grade");
            statement.setInt(1, studentId);
            resultSet = statement.executeQuery();

            // Process the result set and populate the gradeCountMap
            while (resultSet.next()) {
                String grade = resultSet.getString("grade");
                int count = resultSet.getInt("count");
                gradeCountMap.put(grade == null ? "NULL" : grade, count);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } 

        // Calculate percentages
        int totalGrades = gradeCountMap.values().stream().mapToInt(Integer::intValue).sum();
        Map<String, Double> gradePercentageMap = new HashMap<>();
        for (Map.Entry<String, Integer> entry : gradeCountMap.entrySet()) {
            String grade = entry.getKey();
            int count = entry.getValue();
            double percentage = (double) count / totalGrades * 100;
            gradePercentageMap.put(grade, percentage);
        }

        return gradePercentageMap;
    }
    
    // Enroll a student in a specific course
    public static String calculateGpa(int id) throws SQLException {
        Connection con = DataAccessLayer.getInstance().connect();
        CallableStatement pst = con.prepareCall("{call calculate_gpa(?, ?)}");
        pst.setInt(1, id);
        pst.registerOutParameter(2, Types.DOUBLE);
        pst.execute();
        double gpa = pst.getDouble(2);
        String gpa_string = String.valueOf(gpa);
        return gpa_string;
    }
    
    
    // get courses with grades for a specific student 
    public static ObservableList<Course> fetchCoursesByStudent(int id) throws SQLException {
    ObservableList<Course> courses = FXCollections.observableArrayList();
    Connection connection = DataAccessLayer.getInstance().connect();
    PreparedStatement statement = null;
    ResultSet resultSet = null;
    
    try {
        statement = connection.prepareStatement("select course_name, grade from StudentCourseNamesView where student_id = ?");
        statement.setInt(1, id);
        resultSet = statement.executeQuery();
        // Process the result set and populate the list of courses
        while (resultSet.next()) {
            String course_name = resultSet.getString("course_name");
            String grade = resultSet.getString("grade");
            // Create a Student object and add it to the list
            Course course = new Course(course_name, grade);
            courses.add(course);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return courses;
    }
    

}

