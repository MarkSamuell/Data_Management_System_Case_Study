package univ;

import dataAccessLayer.DataAccessLayer;
import static dataAccessLayer.DataAccessLayer.calculateGpa;
import static dataAccessLayer.DataAccessLayer.fetchCoursesByStudent;
import static dataAccessLayer.DataAccessLayer.fetchCoursesFromDatabase;
import static dataAccessLayer.DataAccessLayer.fetchStudentsByCourse;
import static dataAccessLayer.DataAccessLayer.fetchStudentsFromDatabase;
import static dataAccessLayer.DataAccessLayer.getAllDepartments;
import dto.Course;
import dto.Student;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class reportSceneBase extends StackPane {

    protected final ImageView imageView;
    protected final VBox vBox;
    protected final HBox hBox;
    protected final Label label;
    protected final Pane pane;
    protected final Button mainMenuBtn;
    protected final SplitPane splitPane;
    protected final AnchorPane anchorPane;
    protected final Label label0;
    protected final TextField departmentTxt;
    protected final MenuButton departmentsList;
    protected final Label label1;
    protected final TextField numOfStudentsTxt;
    protected final TableView<Course> departCrsTable;
    protected final TableColumn<Course, String> departCrsCol;
    protected final Label label2;
    protected final TextField numOfCoursesTxt;
    protected final ScrollPane scrollPane;
    protected final AnchorPane anchorPane0;
    protected final Label label3;
    protected final TableView<Student> studentsTable;
    protected final TableColumn<Student, Integer> studentIdCol;
    protected final TableColumn<Student, String> studentNameCol;
    protected final TableView<Course> stuCoursesTable;
    protected final TableColumn<Course, String> stuCourseCol;
    protected final TableColumn<Course, String> stuGradeCol;
    protected final Label label4;
    protected final TextField gpaTxt;
    protected final Label label5;
    protected final AnchorPane anchorPane1;
    protected final PieChart pieChart;
    protected final Label label6;
    protected final CategoryAxis barXaxis;
    protected final NumberAxis barYaxis;
    protected final BarChart barChart;
    protected final Label label7;
    protected final Label label8;
    protected final Label percentLabel;

    public reportSceneBase() throws SQLException {

        imageView = new ImageView();
        vBox = new VBox();
        hBox = new HBox();
        label = new Label();
        pane = new Pane();
        mainMenuBtn = new Button();
        splitPane = new SplitPane();
        anchorPane = new AnchorPane();
        label0 = new Label();
        departmentTxt = new TextField();
        departmentsList = new MenuButton();
        label1 = new Label();
        numOfStudentsTxt = new TextField();
        departCrsTable = new TableView();
        departCrsCol = new TableColumn();
        label2 = new Label();
        numOfCoursesTxt = new TextField();
        scrollPane = new ScrollPane();
        anchorPane0 = new AnchorPane();
        label3 = new Label();
        studentsTable = new TableView();
        studentIdCol = new TableColumn();
        studentNameCol = new TableColumn();
        stuCoursesTable = new TableView();
        stuCourseCol = new TableColumn();
        stuGradeCol = new TableColumn();
        label4 = new Label();
        gpaTxt = new TextField();
        label5 = new Label();
        anchorPane1 = new AnchorPane();
        pieChart = new PieChart();
        label6 = new Label();
        barXaxis = new CategoryAxis();
        barYaxis = new NumberAxis();
        barChart = new BarChart(barXaxis, barYaxis);
        label7 = new Label();
        label8 = new Label();
        percentLabel = new Label();

        imageView.setFitHeight(660.0);
        imageView.setFitWidth(1024.0);
        imageView.setOpacity(0.41);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        imageView.setImage(new Image(getClass().getResource("_d642b6ef-8443-4188-8799-b51a78d161c7.jpg").toExternalForm()));

        vBox.setOpacity(0.9);
        vBox.setPrefHeight(629.0);
        vBox.setPrefWidth(1024.0);

        VBox.setVgrow(hBox, javafx.scene.layout.Priority.NEVER);
        hBox.setAlignment(javafx.geometry.Pos.CENTER_LEFT);
        hBox.setId("HBox");
        hBox.setPrefHeight(27.0);
        hBox.setPrefWidth(1024.0);
        hBox.setSpacing(5.0);

        HBox.setHgrow(label, javafx.scene.layout.Priority.ALWAYS);
        label.setMaxHeight(Double.MAX_VALUE);
        label.setMaxWidth(-1.0);
        label.setText("Reports");
        label.setFont(new Font("System Bold", 11.0));

        HBox.setHgrow(pane, javafx.scene.layout.Priority.ALWAYS);
        pane.setPrefHeight(11.0);
        pane.setPrefWidth(860.0);

        mainMenuBtn.setLayoutX(865.0);
        mainMenuBtn.setLayoutY(-8.0);
        mainMenuBtn.setMnemonicParsing(false);
        mainMenuBtn.setOnAction(this::switchToMainScene);
        mainMenuBtn.setPrefHeight(38.0);
        mainMenuBtn.setPrefWidth(107.0);
        mainMenuBtn.setText("Main Menu");
        mainMenuBtn.setTextFill(javafx.scene.paint.Color.valueOf("#0033ff"));
        mainMenuBtn.setFont(new Font("Impact", 12.0));
        hBox.setPadding(new Insets(3.0));

        VBox.setVgrow(splitPane, javafx.scene.layout.Priority.ALWAYS);
        splitPane.setDividerPositions(0.2505567928730512, 0.7505567928730512);
        splitPane.setFocusTraversable(true);
        splitPane.setPrefHeight(-1.0);
        splitPane.setPrefWidth(-1.0);

        label0.setAlignment(javafx.geometry.Pos.CENTER);
        label0.setLayoutX(14.0);
        label0.setLayoutY(14.0);
        label0.setMinWidth(60.0);
        label0.setPrefWidth(-1.0);
        label0.setStyle("");
        label0.setText("Department");
        label0.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        label0.setTextFill(javafx.scene.paint.Color.valueOf("#bf1b1b"));
        label0.setUnderline(true);
        label0.setWrapText(false);
        label0.setFont(new Font(18.0));

        departmentTxt.setAlignment(javafx.geometry.Pos.CENTER);
        departmentTxt.setEditable(false);
        departmentTxt.setLayoutX(36.0);
        departmentTxt.setLayoutY(51.0);
        departmentTxt.setPrefHeight(25.0);
        departmentTxt.setPrefWidth(167.0);
        departmentTxt.setFont(new Font(12.0));

        departmentsList.setAlignment(javafx.geometry.Pos.CENTER);
        departmentsList.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        departmentsList.setLayoutX(57.0);
        departmentsList.setLayoutY(92.0);
        departmentsList.setMnemonicParsing(false);
        departmentsList.setText("departments list");
        departmentsList.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);

        label1.setLayoutX(9.0);
        label1.setLayoutY(530.0);
        label1.setPrefHeight(18.0);
        label1.setPrefWidth(122.0);
        label1.setText("Number of Students");
        label1.setUnderline(true);

        numOfStudentsTxt.setAlignment(javafx.geometry.Pos.CENTER);
        numOfStudentsTxt.setEditable(false);
        numOfStudentsTxt.setLayoutX(129.0);
        numOfStudentsTxt.setLayoutY(527.0);
        numOfStudentsTxt.setPrefHeight(31.0);
        numOfStudentsTxt.setPrefWidth(88.0);
        numOfStudentsTxt.setFont(new Font(15.0));

        departCrsTable.setLayoutY(164.0);
        departCrsTable.setPrefHeight(232.0);
        departCrsTable.setPrefWidth(239.0);

        departCrsCol.setPrefWidth(238.0);
        departCrsCol.setText("Courses");

        label2.setLayoutX(14.0);
        label2.setLayoutY(481.0);
        label2.setText("Number of Courses");
        label2.setUnderline(true);

        numOfCoursesTxt.setAlignment(javafx.geometry.Pos.CENTER);
        numOfCoursesTxt.setEditable(false);
        numOfCoursesTxt.setLayoutX(129.0);
        numOfCoursesTxt.setLayoutY(477.0);
        numOfCoursesTxt.setPrefHeight(31.0);
        numOfCoursesTxt.setPrefWidth(88.0);
        numOfCoursesTxt.setFont(new Font(15.0));

        scrollPane.setPrefHeight(-1.0);
        scrollPane.setPrefWidth(-1.0);

        anchorPane0.setId("Content");
        anchorPane0.setMinHeight(-1.0);
        anchorPane0.setMinWidth(-1.0);
        anchorPane0.setPrefHeight(628.0);
        anchorPane0.setPrefWidth(455.0);

        label3.setAlignment(javafx.geometry.Pos.CENTER);
        label3.setFont(javafx.scene.text.Font.font("Arial"));
        label3.setLayoutX(14.0);
        label3.setLayoutY(14.0);
        label3.setStyle("");
        label3.setText("Students");
        label3.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        label3.setTextFill(javafx.scene.paint.Color.valueOf("#bf1b1b"));
        label3.setUnderline(true);
        label3.setWrapText(false);

        studentsTable.setLayoutX(12.0);
        studentsTable.setLayoutY(58.0);
        studentsTable.setPrefHeight(286.0);
        studentsTable.setPrefWidth(416.0);

        studentIdCol.setPrefWidth(203.0);
        studentIdCol.setText("ID");

        studentNameCol.setPrefWidth(212.0);
        studentNameCol.setText("Name");

        stuCoursesTable.setLayoutX(11.0);
        stuCoursesTable.setLayoutY(355.0);
        stuCoursesTable.setPrefHeight(185.0);
        stuCoursesTable.setPrefWidth(417.0);

        stuCourseCol.setPrefWidth(206.0);
        stuCourseCol.setText("Course");

        stuGradeCol.setPrefWidth(210.0);
        stuGradeCol.setText("Grade");

        label4.setLayoutX(142.0);
        label4.setLayoutY(567.0);
        label4.setText("GPA");
        label4.setTextFill(javafx.scene.paint.Color.valueOf("#c31913"));
        label4.setUnderline(true);
        label4.setFont(new Font("Arial Black", 18.0));

        gpaTxt.setAlignment(javafx.geometry.Pos.CENTER);
        gpaTxt.setEditable(false);
        gpaTxt.setLayoutX(211.0);
        gpaTxt.setLayoutY(568.0);
        gpaTxt.setPrefHeight(25.0);
        gpaTxt.setPrefWidth(96.0);
        gpaTxt.setFont(new Font(15.0));

        label5.setLayoutX(111.0);
        label5.setLayoutY(41.0);
        label5.setText("click on any student ID to get more info");
        scrollPane.setContent(anchorPane0);

        pieChart.setLayoutX(11.0);
        pieChart.setLayoutY(362.0);
        pieChart.setPrefHeight(245.0);
        pieChart.setPrefWidth(297.0);

        label6.setAlignment(javafx.geometry.Pos.CENTER);
        label6.setFont(javafx.scene.text.Font.font("Arial"));
        label6.setLayoutX(14.0);
        label6.setLayoutY(14.0);
        label6.setStyle("");
        label6.setText("Stats");
        label6.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        label6.setTextFill(javafx.scene.paint.Color.valueOf("#bf1b1b"));
        label6.setUnderline(true);
        label6.setWrapText(false);

        barXaxis.setSide(javafx.geometry.Side.BOTTOM);

        barYaxis.setSide(javafx.geometry.Side.LEFT);
        barYaxis.setTickLabelGap(1.0);
        barYaxis.setUpperBound(90.0);
        barChart.setLayoutY(68.0);
        barChart.setPrefHeight(245.0);
        barChart.setPrefWidth(317.0);

        label7.setLayoutX(118.0);
        label7.setLayoutY(46.0);
        label7.setText("Grades % Barchart");

        label8.setLayoutX(118.0);
        label8.setLayoutY(342.0);
        label8.setText("Grades % PieChart");

        percentLabel.setLayoutX(251.0);
        percentLabel.setLayoutY(334.0);

        getChildren().add(imageView);
        hBox.getChildren().add(label);
        pane.getChildren().add(mainMenuBtn);
        hBox.getChildren().add(pane);
        vBox.getChildren().add(hBox);
        anchorPane.getChildren().add(label0);
        anchorPane.getChildren().add(departmentTxt);
        anchorPane.getChildren().add(departmentsList);
        anchorPane.getChildren().add(label1);
        anchorPane.getChildren().add(numOfStudentsTxt);
        departCrsTable.getColumns().add(departCrsCol);
        anchorPane.getChildren().add(departCrsTable);
        anchorPane.getChildren().add(label2);
        anchorPane.getChildren().add(numOfCoursesTxt);
        splitPane.getItems().add(anchorPane);
        anchorPane0.getChildren().add(label3);
        studentsTable.getColumns().add(studentIdCol);
        studentsTable.getColumns().add(studentNameCol);
        anchorPane0.getChildren().add(studentsTable);
        stuCoursesTable.getColumns().add(stuCourseCol);
        stuCoursesTable.getColumns().add(stuGradeCol);
        anchorPane0.getChildren().add(stuCoursesTable);
        anchorPane0.getChildren().add(label4);
        anchorPane0.getChildren().add(gpaTxt);
        anchorPane0.getChildren().add(label5);
        splitPane.getItems().add(scrollPane);
        anchorPane1.getChildren().add(pieChart);
        anchorPane1.getChildren().add(label6);
        anchorPane1.getChildren().add(barChart);
        anchorPane1.getChildren().add(label7);
        anchorPane1.getChildren().add(label8);
        anchorPane1.getChildren().add(percentLabel);
        splitPane.getItems().add(anchorPane1);
        vBox.getChildren().add(splitPane);
        getChildren().add(vBox);



                
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
                        departmentsList.getItems().add(menuItem);
                         // Add an event handler to set the selected course text to addCrsTxt
                        menuItem.setOnAction(event -> {
                                
                            try {
                                departmentTxt.setText(menuItem.getText());
                                
                                // set department courses table
                                // Retrieve data from the database
                                ObservableList<Course> courseData = fetchCoursesFromDatabase(departmentTxt.getText());
                                
                                // Clear existing columns before adding new ones
                                departCrsTable.getColumns().clear();
                                
                                // Populate TableView with data
                                departCrsTable.setItems(courseData);
                                
                                
                                if (!departCrsTable.getColumns().contains(departCrsCol)) {
                                    departCrsTable.getColumns().add(departCrsCol);
                                }
                                
                                departCrsCol.setCellValueFactory(cellData -> cellData.getValue().courseNameProperty());
                                ///////////////////////////////////////////////
                                // setting students table 
                               

                                // Retrieve data from the database
                                ObservableList<Student> studentData = fetchStudentsFromDatabase(departmentTxt.getText());

                                // Clear existing columns before adding new ones
                                studentsTable.getColumns().clear();

                                // Step 4: Populate TableView with data
                                studentsTable.setItems(studentData);
                                // Add columns only if they are not already present
                                 if (!studentsTable.getColumns().contains(studentIdCol)) {
                                     studentsTable.getColumns().add(studentIdCol);
                                 }

                                 if (!studentsTable.getColumns().contains(studentNameCol)) {
                                     studentsTable.getColumns().add(studentNameCol);
                                 }
                                // Set cell value factories for each column
                                studentIdCol.setCellValueFactory(cellData -> cellData.getValue().idProperty().asObject());
                                studentNameCol.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
                                    
                                // setting course and students count
                                numOfCoursesTxt.setText(String.valueOf(departCrsTable.getItems().size()));
                                numOfStudentsTxt.setText(String.valueOf(studentsTable.getItems().size()));    
                                 /////////////////////////////////////////////////////////////////////////////////////////////////
                                 // add action listner to each cell of students table 
                                 
                                 studentIdCol.setCellFactory(col -> {
                                        TableCell<Student, Integer> cell = new TableCell<Student, Integer>() {
                                            protected void updateItem(Integer item, boolean empty) {
                                                super.updateItem(item, empty);
                                                setText(empty ? null : item != null ? item.toString() : "");
                                            }
                                        };

                                        // Add action listener to each cell
                                        cell.setOnMouseClicked(event2 -> {
                                            if (!cell.isEmpty() && event2.getButton() == MouseButton.PRIMARY) {
                                                try {
                                                    // Get the selected student id
                                                    Integer selectedStudentId = cell.getItem();
                                                    // Perform the desired action based on the selected student id
                                                    gpaTxt.setText(calculateGpa(selectedStudentId));

                                                    // Update the "courses" table with associated students
                                                    ObservableList<Course> associatedStudents = fetchCoursesByStudent(selectedStudentId);
                                                    // Clear existing columns before adding new ones
                                                    stuCoursesTable.getColumns().clear();
                                                    // Add the columns to the TableView
                                                    stuCoursesTable.getColumns().addAll(stuCourseCol, stuGradeCol);
                                                    // Set cell value factories for each column
                                                    stuCourseCol.setCellValueFactory(cellData -> cellData.getValue().courseNameProperty());
                                                    stuGradeCol.setCellValueFactory(cellData -> cellData.getValue().courseGradeProperty());
                                                    // Populate TableView with data
                                                    stuCoursesTable.setItems(associatedStudents);

                                                    // create piechart
                                                    int studentId = cell.getItem();
                                                    ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();
                                                    try {
                                                        Map<String, Double> gradePercentages = DataAccessLayer.getStudentGradePercentages(studentId);
                                                        for (Map.Entry<String, Double> entry : gradePercentages.entrySet()) {
                                                            if (entry.getKey() != "NULL") {
                                                                String grade = entry.getKey();
                                                                double percentage = entry.getValue();
                                                                pieChartData.add(new PieChart.Data(grade, percentage));
                                                            }
                                                        }
                                                    } catch (SQLException e) {
                                                        e.printStackTrace();
                                                    }

                                                    // Create PieChart
                                                    pieChart.setData(pieChartData);


                                                    // Create BarChart using Platform.runLater
                                                    Platform.runLater(() -> {
                                                        barChart.getData().clear();

                                                        XYChart.Series<String, Number> series = new XYChart.Series<>();
                                                        series.setName("Grade Percentage");

                                                        // Explicitly set categories for the x-axis
                                                        barXaxis.setCategories(FXCollections.observableArrayList("A", "B", "C", "D", "F"));

                                                        try {
                                                            Map<String, Double> gradePercentages = DataAccessLayer.getStudentGradePercentages(studentId);

                                                            for (Map.Entry<String, Double> entry : gradePercentages.entrySet()) {
                                                                if (!"NULL".equals(entry.getKey())) {
                                                                    String grade = entry.getKey();
                                                                    double percentage = entry.getValue();
                                                                    series.getData().add(new XYChart.Data<>(grade, percentage));
                                                                }
                                                            }
                                                        } catch (SQLException e) {
                                                            e.printStackTrace();
                                                        }

                                                        barChart.getData().add(series);
                                                    });

                                                } catch (SQLException ex) {
                                                    Logger.getLogger(reportSceneBase.class.getName()).log(Level.SEVERE, null, ex);
                                                }
                                            }
                                        });


                                        return cell;
                                    });                           
                                
                            } catch (SQLException ex) {
                                Logger.getLogger(reportSceneBase.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        
                        
                                
                            });
                        }   
            }
         public void switchToMainScene(ActionEvent event) {

               }
        }