package univ;

import dataAccessLayer.DataAccessLayer;
import static dataAccessLayer.DataAccessLayer.fetchCoursesFromDatabase;
import static dataAccessLayer.DataAccessLayer.fetchStudentsByCourse;
import static dataAccessLayer.DataAccessLayer.fetchStudentsFromDatabase;
import static dataAccessLayer.DataAccessLayer.getAllDepartments;
import dto.Course;
import dto.Student;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class departSceneBase extends StackPane {

    protected final Pane pane;
    protected final ImageView imageView;
    protected final TabPane tabPane;
    protected final Tab tab;
    protected final AnchorPane anchorPane;
    protected final TableView<Course> Courses_Table;
    protected final TableColumn<Course, Integer> Course_Id_Column;
    protected final TableColumn<Course, String> Course_Name_Column;
    protected final TableView<Student> Student_Table;
    protected final TableColumn<Student, Integer> Student_Id_Column;
    protected final TableColumn<Student, String> Student_Name_Column;
    protected final Button searchSearchBtn;
    protected final MenuButton departmentSearchList;
    protected final TextField searchDepartmentTxt;
    protected final Tab tab0;
    protected final AnchorPane anchorPane0;
    protected final SplitPane splitPane;
    protected final AnchorPane anchorPane1;
    protected final Text text;
    protected final Text text0;
    protected final TextField addDepartmentTxt;
    protected final Button addDepartmentBtn;
    protected final Text text1;
    protected final TextField addCourseNameTxt;
    protected final Text text2;
    protected final Text text3;
    protected final MenuButton addCourseDepartmentList;
    protected final Text text4;
    protected final TextField addCourseCreditTxt;
    protected final Button addCourseBtn;
    protected final TextField addCourseDepartmentTxt;
    protected final AnchorPane anchorPane2;
    protected final Text text5;
    protected final Text text6;
    protected final TextField deleteDepartmentIdTxt;
    protected final Button deleteDepartmentIdSearchBtn;
    protected final TextField deleteDepartmentNameTxt;
    protected final Button deleteDepartmentBtn;
    protected final Text text7;
    protected final TextField deleteCourseIdTxt;
    protected final Button deleteCourseIdSearchBtn;
    protected final TextField deleteCourseNameTxt;
    protected final Button deleteCourseBtn;
    protected final Button mainMenuBtn;

    public departSceneBase() throws SQLException {

        pane = new Pane();
        imageView = new ImageView();
        tabPane = new TabPane();
        tab = new Tab();
        anchorPane = new AnchorPane();
        Courses_Table = new TableView();
        Course_Id_Column = new TableColumn();
        Course_Name_Column = new TableColumn();
        Student_Table = new TableView();
        Student_Id_Column = new TableColumn();
        Student_Name_Column = new TableColumn();
        searchSearchBtn = new Button();
        departmentSearchList = new MenuButton();
        searchDepartmentTxt = new TextField();
        tab0 = new Tab();
        anchorPane0 = new AnchorPane();
        splitPane = new SplitPane();
        anchorPane1 = new AnchorPane();
        text = new Text();
        text0 = new Text();
        addDepartmentTxt = new TextField();
        addDepartmentBtn = new Button();
        text1 = new Text();
        addCourseNameTxt = new TextField();
        text2 = new Text();
        text3 = new Text();
        addCourseDepartmentList = new MenuButton();
        text4 = new Text();
        addCourseCreditTxt = new TextField();
        addCourseBtn = new Button();
        addCourseDepartmentTxt = new TextField();
        anchorPane2 = new AnchorPane();
        text5 = new Text();
        text6 = new Text();
        deleteDepartmentIdTxt = new TextField();
        deleteDepartmentIdSearchBtn = new Button();
        deleteDepartmentNameTxt = new TextField();
        deleteDepartmentBtn = new Button();
        text7 = new Text();
        deleteCourseIdTxt = new TextField();
        deleteCourseIdSearchBtn = new Button();
        deleteCourseNameTxt = new TextField();
        deleteCourseBtn = new Button();
        mainMenuBtn = new Button();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(660.0);
        setPrefWidth(1024.0);

        pane.setPrefHeight(200.0);
        pane.setPrefWidth(200.0);

        imageView.setFitHeight(660.0);
        imageView.setFitWidth(1024.0);
        imageView.setOpacity(0.7);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        imageView.setImage(new Image(getClass().getResource("_d642b6ef-8443-4188-8799-b51a78d161c7.jpg").toExternalForm()));

        tabPane.setLayoutY(-4.0);
        tabPane.setPrefHeight(666.0);
        tabPane.setPrefWidth(1024.0);
        tabPane.setTabClosingPolicy(javafx.scene.control.TabPane.TabClosingPolicy.UNAVAILABLE);

        tab.setText("Search Departments");

        anchorPane.setMinHeight(0.0);
        anchorPane.setMinWidth(0.0);
        anchorPane.setPrefHeight(180.0);
        anchorPane.setPrefWidth(200.0);

        Courses_Table.setLayoutY(281.0);
        Courses_Table.setOpacity(0.8);
        Courses_Table.setPrefHeight(345.0);
        Courses_Table.setPrefWidth(512.0);

        Course_Id_Column.setEditable(false);
        Course_Id_Column.setPrefWidth(260.0);
        Course_Id_Column.setText("Course ID");

        Course_Name_Column.setEditable(false);
        Course_Name_Column.setMinWidth(0.0);
        Course_Name_Column.setPrefWidth(255.0);
        Course_Name_Column.setText("Course Name");

        Student_Table.setLayoutX(512.0);
        Student_Table.setLayoutY(281.0);
        Student_Table.setOpacity(0.8);
        Student_Table.setPrefHeight(345.0);
        Student_Table.setPrefWidth(516.0);

        Student_Id_Column.setEditable(false);
        Student_Id_Column.setPrefWidth(249.0);
        Student_Id_Column.setText("Student ID");

        Student_Name_Column.setEditable(false);
        Student_Name_Column.setPrefWidth(266.0);
        Student_Name_Column.setText("Student Name");
        Student_Table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        searchSearchBtn.setLayoutX(424.0);
        searchSearchBtn.setLayoutY(171.0);
        searchSearchBtn.setMnemonicParsing(false);
        searchSearchBtn.setPrefHeight(27.0);
        searchSearchBtn.setPrefWidth(178.0);
        searchSearchBtn.setText("Search");
        searchSearchBtn.setTextFill(javafx.scene.paint.Color.valueOf("#2846c7"));
        searchSearchBtn.setFont(new Font("Impact", 12.0));

        departmentSearchList.setAlignment(javafx.geometry.Pos.CENTER);
        departmentSearchList.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        departmentSearchList.setLayoutX(263.0);
        departmentSearchList.setLayoutY(116.0);
        departmentSearchList.setMnemonicParsing(false);
        departmentSearchList.setPrefHeight(30.0);
        departmentSearchList.setPrefWidth(238.0);
        departmentSearchList.setText("Choose Department");
        departmentSearchList.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        departmentSearchList.setTextFill(javafx.scene.paint.Color.valueOf("#bf2323"));
        departmentSearchList.setFont(new Font("Arial Black", 12.0));

        searchDepartmentTxt.setEditable(false);
        searchDepartmentTxt.setLayoutX(525.0);
        searchDepartmentTxt.setLayoutY(115.0);
        searchDepartmentTxt.setOpacity(0.87);
        searchDepartmentTxt.setPrefHeight(33.0);
        searchDepartmentTxt.setPrefWidth(209.0);
        tab.setContent(anchorPane);

        tab0.setText(" Edit Departments");

        anchorPane0.setMinHeight(0.0);
        anchorPane0.setMinWidth(0.0);
        anchorPane0.setPrefHeight(637.0);
        anchorPane0.setPrefWidth(1021.0);

        splitPane.setDividerPositions(0.5);
        splitPane.setLayoutX(8.0);
        splitPane.setLayoutY(6.0);
        splitPane.setOpacity(0.8);
        splitPane.setPrefHeight(623.0);
        splitPane.setPrefWidth(1005.0);

        anchorPane1.setMinHeight(0.0);
        anchorPane1.setMinWidth(0.0);
        anchorPane1.setPrefHeight(631.0);
        anchorPane1.setPrefWidth(473.0);

        text.setLayoutX(223.0);
        text.setLayoutY(80.0);
        text.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text.setStrokeWidth(0.0);
        text.setText("ADD");
        text.setUnderline(true);
        text.setFont(new Font("Impact", 27.0));

        text0.setFill(javafx.scene.paint.Color.valueOf("#9e1818"));
        text0.setLayoutX(46.0);
        text0.setLayoutY(145.0);
        text0.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text0.setStrokeWidth(0.0);
        text0.setText("Department");
        text0.setUnderline(true);
        text0.setFont(new Font("Impact", 18.0));

        addDepartmentTxt.setAlignment(javafx.geometry.Pos.CENTER);
        addDepartmentTxt.setLayoutX(178.0);
        addDepartmentTxt.setLayoutY(130.0);
        addDepartmentTxt.setPrefHeight(25.0);
        addDepartmentTxt.setPrefWidth(214.0);
        addDepartmentTxt.setPromptText("add Department name");

        addDepartmentBtn.setLayoutX(224.0);
        addDepartmentBtn.setLayoutY(181.0);
        addDepartmentBtn.setMnemonicParsing(false);
        addDepartmentBtn.setText("Add Department");
        addDepartmentBtn.setTextFill(javafx.scene.paint.Color.valueOf("#0a5aee"));
        addDepartmentBtn.setFont(new Font("Impact", 13.0));

        text1.setFill(javafx.scene.paint.Color.valueOf("#b22020"));
        text1.setLayoutX(56.0);
        text1.setLayoutY(299.0);
        text1.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text1.setStrokeWidth(0.0);
        text1.setText("Course");
        text1.setUnderline(true);
        text1.setFont(new Font("Impact", 18.0));

        addCourseNameTxt.setAlignment(javafx.geometry.Pos.CENTER);
        addCourseNameTxt.setLayoutX(138.0);
        addCourseNameTxt.setLayoutY(405.0);
        addCourseNameTxt.setPrefHeight(25.0);
        addCourseNameTxt.setPrefWidth(225.0);
        addCourseNameTxt.setPromptText("add course name");

        text2.setLayoutX(62.0);
        text2.setLayoutY(421.0);
        text2.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text2.setStrokeWidth(0.0);
        text2.setText("Name");
        text2.setFont(new Font("Arial", 16.0));

        text3.setLayoutX(41.0);
        text3.setLayoutY(360.0);
        text3.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text3.setStrokeWidth(0.0);
        text3.setText("Departmnet");
        text3.setFont(new Font(16.0));

        addCourseDepartmentList.setAlignment(javafx.geometry.Pos.CENTER);
        addCourseDepartmentList.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        addCourseDepartmentList.setLayoutX(161.0);
        addCourseDepartmentList.setLayoutY(342.0);
        addCourseDepartmentList.setMnemonicParsing(false);
        addCourseDepartmentList.setPrefHeight(25.0);
        addCourseDepartmentList.setPrefWidth(106.0);
        addCourseDepartmentList.setText("Departments");
        addCourseDepartmentList.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);

        text4.setLayoutX(49.0);
        text4.setLayoutY(487.0);
        text4.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text4.setStrokeWidth(0.0);
        text4.setText("Credit Hours");
        text4.setFont(new Font(16.0));

        addCourseCreditTxt.setAlignment(javafx.geometry.Pos.CENTER);
        addCourseCreditTxt.setLayoutX(176.0);
        addCourseCreditTxt.setLayoutY(468.0);
        addCourseCreditTxt.setPromptText("add credit hours");

        addCourseBtn.setLayoutX(204.0);
        addCourseBtn.setLayoutY(539.0);
        addCourseBtn.setMnemonicParsing(false);
        addCourseBtn.setText("Add Course");
        addCourseBtn.setTextFill(javafx.scene.paint.Color.valueOf("#0e5fe1"));
        addCourseBtn.setFont(new Font("Impact", 13.0));

        addCourseDepartmentTxt.setEditable(false);
        addCourseDepartmentTxt.setLayoutX(299.0);
        addCourseDepartmentTxt.setLayoutY(342.0);
        addCourseDepartmentTxt.setPrefHeight(25.0);
        addCourseDepartmentTxt.setPrefWidth(166.0);

        anchorPane2.setMinHeight(0.0);
        anchorPane2.setMinWidth(0.0);
        anchorPane2.setPrefHeight(160.0);
        anchorPane2.setPrefWidth(100.0);

        text5.setLayoutX(225.0);
        text5.setLayoutY(83.0);
        text5.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text5.setStrokeWidth(0.0);
        text5.setText("DELETE");
        text5.setUnderline(true);
        text5.setFont(new Font("Impact", 27.0));

        text6.setFill(javafx.scene.paint.Color.valueOf("#ae1313"));
        text6.setLayoutX(67.0);
        text6.setLayoutY(148.0);
        text6.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text6.setStrokeWidth(0.0);
        text6.setText("Department ID");
        text6.setUnderline(true);
        text6.setWrappingWidth(122.0);
        text6.setFont(new Font("Impact", 18.0));

        deleteDepartmentIdTxt.setAlignment(javafx.geometry.Pos.CENTER);
        deleteDepartmentIdTxt.setLayoutX(197.0);
        deleteDepartmentIdTxt.setLayoutY(127.0);
        deleteDepartmentIdTxt.setPrefHeight(25.0);
        deleteDepartmentIdTxt.setPrefWidth(166.0);
        deleteDepartmentIdTxt.setPromptText("enter id");

        deleteDepartmentIdSearchBtn.setLayoutX(386.0);
        deleteDepartmentIdSearchBtn.setLayoutY(127.0);
        deleteDepartmentIdSearchBtn.setMnemonicParsing(false);
        deleteDepartmentIdSearchBtn.setText("Search");
        deleteDepartmentIdSearchBtn.setTextFill(javafx.scene.paint.Color.valueOf("#1854eb"));
        deleteDepartmentIdSearchBtn.setFont(new Font("Impact", 12.0));

        deleteDepartmentNameTxt.setEditable(false);
        deleteDepartmentNameTxt.setLayoutX(157.0);
        deleteDepartmentNameTxt.setLayoutY(171.0);
        deleteDepartmentNameTxt.setPrefHeight(25.0);
        deleteDepartmentNameTxt.setPrefWidth(224.0);

        deleteDepartmentBtn.setLayoutX(201.0);
        deleteDepartmentBtn.setLayoutY(227.0);
        deleteDepartmentBtn.setMnemonicParsing(false);
        deleteDepartmentBtn.setText("Delete Department");
        deleteDepartmentBtn.setTextFill(javafx.scene.paint.Color.RED);
        deleteDepartmentBtn.setFont(new Font("Arial Black", 12.0));

        text7.setFill(javafx.scene.paint.Color.valueOf("#ae1313"));
        text7.setLayoutX(58.0);
        text7.setLayoutY(361.0);
        text7.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text7.setStrokeWidth(0.0);
        text7.setText("Course ID");
        text7.setUnderline(true);
        text7.setWrappingWidth(122.0);
        text7.setFont(new Font("Impact", 18.0));

        deleteCourseIdTxt.setAlignment(javafx.geometry.Pos.CENTER);
        deleteCourseIdTxt.setLayoutX(188.0);
        deleteCourseIdTxt.setLayoutY(340.0);
        deleteCourseIdTxt.setPrefHeight(25.0);
        deleteCourseIdTxt.setPrefWidth(166.0);
        deleteCourseIdTxt.setPromptText("enter id");

        deleteCourseIdSearchBtn.setLayoutX(377.0);
        deleteCourseIdSearchBtn.setLayoutY(340.0);
        deleteCourseIdSearchBtn.setMnemonicParsing(false);
        deleteCourseIdSearchBtn.setText("Search");
        deleteCourseIdSearchBtn.setTextFill(javafx.scene.paint.Color.valueOf("#1854eb"));
        deleteCourseIdSearchBtn.setFont(new Font("Impact", 12.0));

        deleteCourseNameTxt.setEditable(false);
        deleteCourseNameTxt.setLayoutX(148.0);
        deleteCourseNameTxt.setLayoutY(384.0);
        deleteCourseNameTxt.setPrefHeight(25.0);
        deleteCourseNameTxt.setPrefWidth(224.0);

        deleteCourseBtn.setLayoutX(218.0);
        deleteCourseBtn.setLayoutY(440.0);
        deleteCourseBtn.setMnemonicParsing(false);
        deleteCourseBtn.setText("Delete Course");
        deleteCourseBtn.setTextFill(javafx.scene.paint.Color.RED);
        deleteCourseBtn.setFont(new Font("Arial Black", 12.0));
        tab0.setContent(anchorPane0);

        mainMenuBtn.setLayoutX(902.0);
        mainMenuBtn.setMnemonicParsing(false);
        mainMenuBtn.setPrefHeight(25.0);
        mainMenuBtn.setPrefWidth(122.0);
        mainMenuBtn.setText("Main Menu");
        mainMenuBtn.setTextFill(javafx.scene.paint.Color.valueOf("#1766d3"));
        mainMenuBtn.setFont(new Font("Impact", 12.0));

        pane.getChildren().add(imageView);
        Courses_Table.getColumns().add(Course_Id_Column);
        Courses_Table.getColumns().add(Course_Name_Column);
        anchorPane.getChildren().add(Courses_Table);
        Student_Table.getColumns().add(Student_Id_Column);
        Student_Table.getColumns().add(Student_Name_Column);
        anchorPane.getChildren().add(Student_Table);
        anchorPane.getChildren().add(searchSearchBtn);
        anchorPane.getChildren().add(departmentSearchList);
        anchorPane.getChildren().add(searchDepartmentTxt);
        tabPane.getTabs().add(tab);
        anchorPane1.getChildren().add(text);
        anchorPane1.getChildren().add(text0);
        anchorPane1.getChildren().add(addDepartmentTxt);
        anchorPane1.getChildren().add(addDepartmentBtn);
        anchorPane1.getChildren().add(text1);
        anchorPane1.getChildren().add(addCourseNameTxt);
        anchorPane1.getChildren().add(text2);
        anchorPane1.getChildren().add(text3);
        anchorPane1.getChildren().add(addCourseDepartmentList);
        anchorPane1.getChildren().add(text4);
        anchorPane1.getChildren().add(addCourseCreditTxt);
        anchorPane1.getChildren().add(addCourseBtn);
        anchorPane1.getChildren().add(addCourseDepartmentTxt);
        splitPane.getItems().add(anchorPane1);
        anchorPane2.getChildren().add(text5);
        anchorPane2.getChildren().add(text6);
        anchorPane2.getChildren().add(deleteDepartmentIdTxt);
        anchorPane2.getChildren().add(deleteDepartmentIdSearchBtn);
        anchorPane2.getChildren().add(deleteDepartmentNameTxt);
        anchorPane2.getChildren().add(deleteDepartmentBtn);
        anchorPane2.getChildren().add(text7);
        anchorPane2.getChildren().add(deleteCourseIdTxt);
        anchorPane2.getChildren().add(deleteCourseIdSearchBtn);
        anchorPane2.getChildren().add(deleteCourseNameTxt);
        anchorPane2.getChildren().add(deleteCourseBtn);
        splitPane.getItems().add(anchorPane2);
        anchorPane0.getChildren().add(splitPane);
        tabPane.getTabs().add(tab0);
        pane.getChildren().add(tabPane);
        pane.getChildren().add(mainMenuBtn);
        getChildren().add(pane);

   
        mainMenuBtn.setOnAction(e -> {
                   try {
                       new sceneController().switchToMainScene(e);
                   } catch (IOException ex) {
                       Logger.getLogger(stuSceneBase.class.getName()).log(Level.SEVERE, null, ex);
                   }
               });
        
// setting departments list
        List<String> departments = getAllDepartments();
                for (String department : departments) {
                        MenuItem menuItem = new MenuItem(department);
                        // Add the MenuItem to the menu
                        departmentSearchList.getItems().add(menuItem);
                         // Add an event handler to set the selected course text to addCrsTxt
                        menuItem.setOnAction(event -> {
                        searchDepartmentTxt.setText(menuItem.getText()); 
                                
                            });
                        }
        // ...

        // Add an event handler to the "Search Departments" tab
        tab.setOnSelectionChanged(event -> {
            if (tab.isSelected()) {
                try {
                    // Update the departments list when the tab is selected
                    updateDepartmentsList();
                } catch (SQLException ex) {
                    Logger.getLogger(departSceneBase.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        // Add an event handler to the "Edit Departments" tab
        tab0.setOnSelectionChanged(event -> {
            if (tab0.isSelected()) {
                try {
                    // Update the departments list when the tab is selected
                    updateDepartmentsList();
                } catch (SQLException ex) {
                    Logger.getLogger(departSceneBase.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

       // set earch button
       searchSearchBtn.setOnAction(e -> {
            if (searchDepartmentTxt.getText().isEmpty()){
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Please choose a Department.");
                             alert.show();
            }
            else 
            {
                try {
                     // Retrieve data from the database
                     ObservableList<Course> courseData = fetchCoursesFromDatabase(searchDepartmentTxt.getText());

                     // Clear existing columns before adding new ones
                     Courses_Table.getColumns().clear();

                     // Populate TableView with data
                     Courses_Table.setItems(courseData);

                     // Add columns only if they are not already present
                     if (!Courses_Table.getColumns().contains(Course_Id_Column)) {
                         Courses_Table.getColumns().add(Course_Id_Column);
                     }

                     if (!Courses_Table.getColumns().contains(Course_Name_Column)) {
                         Courses_Table.getColumns().add(Course_Name_Column);
                     }

                     // Set cell value factories for each column
                     Course_Id_Column.setCellValueFactory(cellData -> cellData.getValue().cidProperty().asObject());
                     Course_Name_Column.setCellValueFactory(cellData -> cellData.getValue().courseNameProperty());
                     
                    /////////////////////////////////////////////////////////////////////////////////////////////////
                    
                    Course_Id_Column.setCellFactory(col -> {
                        TableCell<Course, Integer> cell = new TableCell<Course, Integer>() {
                            protected void updateItem(Integer item, boolean empty) {
                                super.updateItem(item, empty);
                                setText(empty ? null : item != null ? item.toString() : "");
                            }
                        };

                        // Add action listener to each cell
                        cell.setOnMouseClicked(event -> {
                            if (!cell.isEmpty() && event.getButton() == MouseButton.PRIMARY) {
                                try {
                                    // Get the selected course id
                                    Integer selectedCourseId = cell.getItem();

                                    // Perform the desired action based on the selected course id
                                    System.out.println("Selected Course ID: " + selectedCourseId);

                                    // Update the "Students" table with associated students
                                    ObservableList<Student> associatedStudents = fetchStudentsByCourse(selectedCourseId);
                                    // Clear existing columns before adding new ones
                                    Student_Table.getColumns().clear();
                                    // Add the columns to the TableView
                                    Student_Table.getColumns().addAll(Student_Id_Column, Student_Name_Column);
                                    // Set cell value factories for each column
                                    Student_Id_Column.setCellValueFactory(cellData -> cellData.getValue().idProperty().asObject());
                                    Student_Name_Column.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
                                    // Populate TableView with data
                                    Student_Table.setItems(associatedStudents);
                                } catch (SQLException ex) {
                                    Logger.getLogger(departSceneBase.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                        });

                            return cell;
                        });

                    ////////////////////////////////////////////////////////////////////////////////////////////////
                    
                    Course_Name_Column.setCellFactory(col -> {
                            TableCell<Course, String> cell = new TableCell<Course, String>() {
                                protected void updateItem(String item, boolean empty) {
                                    super.updateItem(item, empty);
                                    setText(empty ? null : item);
                                }
                            };

                            // Add action listener to each cell
                            cell.setOnMouseClicked(event -> {
                                if (!cell.isEmpty() && event.getButton() == MouseButton.PRIMARY) {
                                    try {
                                        // Get the selected course name
                                        String selectedCourse = cell.getItem();
                                        
                                        // Perform the desired action based on the selected course
                                        System.out.println("Selected Course: " + selectedCourse);
                                        
                                        // Update the "Students" table with associated students
                                        ObservableList<Student> associatedStudents = fetchStudentsByCourse(selectedCourse);
                                        // Clear existing columns before adding new ones
                                        Student_Table.getColumns().clear();
                                        // Add the columns to the TableView
                                        Student_Table.getColumns().addAll(Student_Id_Column, Student_Name_Column);
                                        // Set cell value factories for each column
                                        Student_Id_Column.setCellValueFactory(cellData -> cellData.getValue().idProperty().asObject());
                                        Student_Name_Column.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
                                        // Populate TableView with data
                                        Student_Table.setItems(associatedStudents);
                                    } catch (SQLException ex) {
                                        Logger.getLogger(departSceneBase.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                }
                            });

                            return cell;
                        });
                    
                    
                    ////////////////////////////////////////////////////////////////////////////////////////////////

                     // Retrieve data from the database
                     ObservableList<Student> studentData = fetchStudentsFromDatabase(searchDepartmentTxt.getText());

                     // Clear existing columns before adding new ones
                     Student_Table.getColumns().clear();

                     // Step 4: Populate TableView with data
                     Student_Table.setItems(studentData);

                     // Create columns for the Students table
                     TableColumn<Student, Integer> Student_Id_Column = new TableColumn<>("Student ID");
                     TableColumn<Student, String> Student_Name_Column = new TableColumn<>("Student Name");
                     // Add the columns to the TableView
                     Student_Table.getColumns().addAll(Student_Id_Column, Student_Name_Column);

                     // Set cell value factories for each column
                     Student_Id_Column.setCellValueFactory(cellData -> cellData.getValue().idProperty().asObject());
                     Student_Name_Column.setCellValueFactory(cellData -> cellData.getValue().nameProperty());

                 } catch (SQLException ex) {
                     Logger.getLogger(departSceneBase.class.getName()).log(Level.SEVERE, null, ex);
                 }
            }
           

       });
       
       
       addDepartmentBtn.setOnAction(e -> {
            try {
                String departmentName = addDepartmentTxt.getText();
                

                if (departmentName.isEmpty()) {
                    // Display an alert if the department name is empty
                    Alert alert = new Alert(Alert.AlertType.WARNING, "Please enter a department name.");
                    alert.show();
                } else {
                    List<String> departmentsList = departments;

                    if (departments.contains(departmentName)) {
                        // Display an alert if the department already exists
                        Alert alert = new Alert(Alert.AlertType.WARNING, "Department already exists.");
                        alert.show();
                    } else {
                        // Add the department to the database
                        Connection con = DataAccessLayer.getInstance().connect();
                        PreparedStatement pst = con.prepareStatement("INSERT INTO departments (name) VALUES (?)");
                        pst.setString(1, departmentName);
                        pst.executeUpdate();
                        // Display a success message
                        Alert successAlert = new Alert(Alert.AlertType.INFORMATION, "Department added successfully.");
                        successAlert.show();
                        // Clear the text field after adding the department
                        addDepartmentTxt.clear();
                        
                    }  
                }
                
            } catch (SQLException ex) {
                // Handle any database exception
                Logger.getLogger(departSceneBase.class.getName()).log(Level.SEVERE, null, ex);
                // Display an error message
                Alert alert = new Alert(Alert.AlertType.ERROR, "Error adding department to the database.");
                alert.show();
            }
        });


                
   }

       public void switchToMainScene(ActionEvent event) {

       }
   
        private void updateDepartmentsList() throws SQLException {
         // Retrieve the updated list of departments
         List<String> departments = getAllDepartments();

         // Clear the existing items in the department search list
         departmentSearchList.getItems().clear();

         // Populate the department search list with the updated departments
         for (String department : departments) {
             MenuItem menuItem = new MenuItem(department);
             departmentSearchList.getItems().add(menuItem);

             menuItem.setOnAction(event -> {
                 searchDepartmentTxt.setText(menuItem.getText());
             });
         }
     }

}
