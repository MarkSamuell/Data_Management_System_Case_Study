package univ;

import dataAccessLayer.DataAccessLayer;
import static dataAccessLayer.DataAccessLayer.enrollStudent;
import static dataAccessLayer.DataAccessLayer.getAllCourses;
import static dataAccessLayer.DataAccessLayer.getStudent;
import static dataAccessLayer.DataAccessLayer.getStudentCourses;
import static dataAccessLayer.DataAccessLayer.updateGrade;
import dto.Student;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class gradSceneBase extends StackPane {

    protected final Pane pane;
    protected final ImageView imageView;
    protected final TabPane tabPane;
    protected final Tab tab;
    protected final AnchorPane anchorPane;
    protected final Text text;
    protected final Text text0;
    protected final Text text1;
    protected final Text text2;
    protected final Text text3;
    protected final TextField addSearchTxt;
    protected final Button addSearchBtn;
    protected final TextField addNameTxt;
    protected final TextField addLevelTxt;
    protected final TextField addCrsTxt;
    protected final MenuButton addCrsList;
    protected final MenuButton addGradList;
    protected final SeparatorMenuItem separatorMenuItem;
    protected final MenuItem menuItem;
    protected final SeparatorMenuItem separatorMenuItem0;
    protected final MenuItem menuItem0;
    protected final SeparatorMenuItem separatorMenuItem1;
    protected final MenuItem menuItem1;
    protected final SeparatorMenuItem separatorMenuItem2;
    protected final MenuItem menuItem2;
    protected final SeparatorMenuItem separatorMenuItem3;
    protected final MenuItem menuItem3;
    protected final TextField addGradTxt;
    protected final Button addSubmitBtn;
    protected final Tab tab0;
    protected final AnchorPane anchorPane0;
    protected final Text text4;
    protected final Text text5;
    protected final Text text6;
    protected final Text text7;
    protected final TextField enrollSearchTxt;
    protected final Button enrollSearchBtn;
    protected final TextField enrollNameTxt;
    protected final TextField enrollLevelTxt;
    protected final TextField enrollCrsTxt;
    protected final MenuButton enrollCrsList;
    protected final Button enrollBtn;
    protected final Button button;

    public gradSceneBase() {

        pane = new Pane();
        imageView = new ImageView();
        tabPane = new TabPane();
        tab = new Tab();
        anchorPane = new AnchorPane();
        text = new Text();
        text0 = new Text();
        text1 = new Text();
        text2 = new Text();
        text3 = new Text();
        addSearchTxt = new TextField();
        addSearchBtn = new Button();
        addNameTxt = new TextField();
        addLevelTxt = new TextField();
        addCrsTxt = new TextField();
        addCrsList = new MenuButton();
        addGradList = new MenuButton();
        separatorMenuItem = new SeparatorMenuItem();
        menuItem = new MenuItem();
        separatorMenuItem0 = new SeparatorMenuItem();
        menuItem0 = new MenuItem();
        separatorMenuItem1 = new SeparatorMenuItem();
        menuItem1 = new MenuItem();
        separatorMenuItem2 = new SeparatorMenuItem();
        menuItem2 = new MenuItem();
        separatorMenuItem3 = new SeparatorMenuItem();
        menuItem3 = new MenuItem();
        addGradTxt = new TextField();
        addSubmitBtn = new Button();
        tab0 = new Tab();
        anchorPane0 = new AnchorPane();
        text4 = new Text();
        text5 = new Text();
        text6 = new Text();
        text7 = new Text();
        enrollSearchTxt = new TextField();
        enrollSearchBtn = new Button();
        enrollNameTxt = new TextField();
        enrollLevelTxt = new TextField();
        enrollCrsTxt = new TextField();
        enrollCrsList = new MenuButton();
        enrollBtn = new Button();
        button = new Button();

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
        imageView.setOpacity(0.57);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        imageView.setImage(new Image(getClass().getResource("_d642b6ef-8443-4188-8799-b51a78d161c7.jpg").toExternalForm()));

        tabPane.setPrefHeight(660.0);
        tabPane.setPrefWidth(1024.0);
        tabPane.setTabClosingPolicy(javafx.scene.control.TabPane.TabClosingPolicy.UNAVAILABLE);

        tab.setText("Add grades");

        anchorPane.setMinHeight(0.0);
        anchorPane.setMinWidth(0.0);
        anchorPane.setPrefHeight(180.0);
        anchorPane.setPrefWidth(200.0);

        text.setLayoutX(104.0);
        text.setLayoutY(86.263671875);
        text.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text.setStrokeWidth(0.0);
        text.setText("ID");
        text.setFont(new Font("Impact", 30.0));

        text0.setLayoutX(297.0);
        text0.setLayoutY(185.263671875);
        text0.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text0.setStrokeWidth(0.0);
        text0.setText("Name");
        text0.setFont(new Font("Impact", 30.0));

        text1.setLayoutX(297.0);
        text1.setLayoutY(285.263671875);
        text1.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text1.setStrokeWidth(0.0);
        text1.setText("Level");
        text1.setWrappingWidth(80.2783203125);
        text1.setFont(new Font("Impact", 30.0));

        text2.setLayoutX(297.0);
        text2.setLayoutY(378.263671875);
        text2.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text2.setStrokeWidth(0.0);
        text2.setText("Courses");
        text2.setFont(new Font("Impact", 30.0));

        text3.setLayoutX(297.0);
        text3.setLayoutY(474.263671875);
        text3.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text3.setStrokeWidth(0.0);
        text3.setText("Grade");
        text3.setFont(new Font("Impact", 30.0));

        addSearchTxt.setLayoutX(160.0);
        addSearchTxt.setLayoutY(58.0);
        addSearchTxt.setOpacity(0.88);
        addSearchTxt.setPrefHeight(36.0);
        addSearchTxt.setPrefWidth(150.0);
        addSearchTxt.setPromptText("enter student id");
        addSearchTxt.setFont(new Font(18.0));

        addSearchBtn.setLayoutX(209.0);
        addSearchBtn.setLayoutY(107.0);
        addSearchBtn.setMnemonicParsing(false);
        addSearchBtn.setText("search");
        addSearchBtn.setFont(new Font("Impact", 12.0));

        addNameTxt.setEditable(false);
        addNameTxt.setLayoutX(440.0);
        addNameTxt.setLayoutY(157.0);
        addNameTxt.setOpacity(0.88);
        addNameTxt.setPrefHeight(37.0);
        addNameTxt.setPrefWidth(263.0);
        addNameTxt.setFont(new Font(18.0));

        addLevelTxt.setEditable(false);
        addLevelTxt.setLayoutX(441.0);
        addLevelTxt.setLayoutY(259.0);
        addLevelTxt.setOpacity(0.88);
        addLevelTxt.setPrefHeight(37.0);
        addLevelTxt.setPrefWidth(262.0);
        addLevelTxt.setFont(new Font(18.0));

        addCrsTxt.setAlignment(javafx.geometry.Pos.CENTER);
        addCrsTxt.setEditable(false);
        addCrsTxt.setLayoutX(622.0);
        addCrsTxt.setLayoutY(347.0);
        addCrsTxt.setOpacity(0.87);
        addCrsTxt.setPrefHeight(41.0);
        addCrsTxt.setPrefWidth(352.0);
        addCrsTxt.setFont(new Font(16.0));

        addCrsList.setAlignment(javafx.geometry.Pos.CENTER);
        addCrsList.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        addCrsList.setLayoutX(441.0);
        addCrsList.setLayoutY(348.0);
        addCrsList.setMnemonicParsing(false);
        addCrsList.setOpacity(0.83);
        addCrsList.setPrefHeight(38.0);
        addCrsList.setPrefWidth(171.0);
        addCrsList.setText("Courses list");

        addGradList.setLayoutX(441.0);
        addGradList.setLayoutY(450.0);
        addGradList.setMnemonicParsing(false);
        addGradList.setOpacity(0.83);
        addGradList.setPrefHeight(39.0);
        addGradList.setPrefWidth(83.0);
        addGradList.setText("Grades");

        separatorMenuItem.setMnemonicParsing(false);

        menuItem.setMnemonicParsing(false);
        menuItem.setText("A");

        separatorMenuItem0.setMnemonicParsing(false);

        menuItem0.setMnemonicParsing(false);
        menuItem0.setText("B");

        separatorMenuItem1.setMnemonicParsing(false);

        menuItem1.setMnemonicParsing(false);
        menuItem1.setText("C");

        separatorMenuItem2.setMnemonicParsing(false);

        menuItem2.setMnemonicParsing(false);
        menuItem2.setText("D");

        separatorMenuItem3.setMnemonicParsing(false);

        menuItem3.setMnemonicParsing(false);
        menuItem3.setText("F");

        addGradTxt.setAlignment(javafx.geometry.Pos.CENTER);
        addGradTxt.setEditable(false);
        addGradTxt.setLayoutX(546.0);
        addGradTxt.setLayoutY(451.0);
        addGradTxt.setPrefHeight(35.0);
        addGradTxt.setPrefWidth(90.0);
        addGradTxt.setFont(new Font(18.0));

        addSubmitBtn.setLayoutX(124.0);
        addSubmitBtn.setLayoutY(547.0);
        addSubmitBtn.setMnemonicParsing(false);
        addSubmitBtn.setPrefHeight(42.0);
        addSubmitBtn.setPrefWidth(217.0);
        addSubmitBtn.setText("Submit Grades");
        addSubmitBtn.setTextFill(javafx.scene.paint.Color.valueOf("#bc1717"));
        addSubmitBtn.setFont(new Font("Impact", 20.0));
        tab.setContent(anchorPane);

        tab0.setText("Enroll Students");

        anchorPane0.setMinHeight(0.0);
        anchorPane0.setMinWidth(0.0);
        anchorPane0.setPrefHeight(180.0);
        anchorPane0.setPrefWidth(200.0);

        text4.setLayoutX(104.0);
        text4.setLayoutY(86.263671875);
        text4.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text4.setStrokeWidth(0.0);
        text4.setText("ID");
        text4.setFont(new Font("Impact", 30.0));

        text5.setLayoutX(316.0);
        text5.setLayoutY(221.263671875);
        text5.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text5.setStrokeWidth(0.0);
        text5.setText("Name");
        text5.setFont(new Font("Impact", 30.0));

        text6.setLayoutX(316.0);
        text6.setLayoutY(321.263671875);
        text6.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text6.setStrokeWidth(0.0);
        text6.setText("Level");
        text6.setWrappingWidth(80.2783203125);
        text6.setFont(new Font("Impact", 30.0));

        text7.setLayoutX(316.0);
        text7.setLayoutY(414.263671875);
        text7.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text7.setStrokeWidth(0.0);
        text7.setText("Courses");
        text7.setFont(new Font("Impact", 30.0));

        enrollSearchTxt.setLayoutX(160.0);
        enrollSearchTxt.setLayoutY(58.0);
        enrollSearchTxt.setOpacity(0.88);
        enrollSearchTxt.setPrefHeight(36.0);
        enrollSearchTxt.setPrefWidth(150.0);
        enrollSearchTxt.setPromptText("enter student id");
        enrollSearchTxt.setFont(new Font(18.0));

        enrollSearchBtn.setLayoutX(209.0);
        enrollSearchBtn.setLayoutY(107.0);
        enrollSearchBtn.setMnemonicParsing(false);
        enrollSearchBtn.setText("search");
        enrollSearchBtn.setFont(new Font("Impact", 12.0));

        enrollNameTxt.setEditable(false);
        enrollNameTxt.setLayoutX(459.0);
        enrollNameTxt.setLayoutY(193.0);
        enrollNameTxt.setOpacity(0.88);
        enrollNameTxt.setPrefHeight(37.0);
        enrollNameTxt.setPrefWidth(263.0);
        enrollNameTxt.setFont(new Font(18.0));

        enrollLevelTxt.setEditable(false);
        enrollLevelTxt.setLayoutX(460.0);
        enrollLevelTxt.setLayoutY(295.0);
        enrollLevelTxt.setOpacity(0.88);
        enrollLevelTxt.setPrefHeight(37.0);
        enrollLevelTxt.setPrefWidth(262.0);
        enrollLevelTxt.setFont(new Font(18.0));

        enrollCrsTxt.setAlignment(javafx.geometry.Pos.CENTER);
        enrollCrsTxt.setEditable(false);
        enrollCrsTxt.setLayoutX(641.0);
        enrollCrsTxt.setLayoutY(383.0);
        enrollCrsTxt.setOpacity(0.87);
        enrollCrsTxt.setPrefHeight(41.0);
        enrollCrsTxt.setPrefWidth(358.0);
        enrollCrsTxt.setFont(new Font(16.0));

        enrollCrsList.setAlignment(javafx.geometry.Pos.CENTER);
        enrollCrsList.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        enrollCrsList.setLayoutX(460.0);
        enrollCrsList.setLayoutY(384.0);
        enrollCrsList.setMnemonicParsing(false);
        enrollCrsList.setOpacity(0.83);
        enrollCrsList.setPrefHeight(38.0);
        enrollCrsList.setPrefWidth(171.0);
        enrollCrsList.setText("Courses list");

        enrollBtn.setLayoutX(708.0);
        enrollBtn.setLayoutY(548.0);
        enrollBtn.setMnemonicParsing(false);
        enrollBtn.setPrefHeight(42.0);
        enrollBtn.setPrefWidth(217.0);
        enrollBtn.setText("Enroll Student");
        enrollBtn.setTextFill(javafx.scene.paint.Color.valueOf("#bc1717"));
        enrollBtn.setFont(new Font("Impact", 20.0));
        tab0.setContent(anchorPane0);

        button.setLayoutX(911.0);
        button.setMnemonicParsing(false);
        button.setOnAction(this::switchToMainScene);
        button.setPrefHeight(29.0);
        button.setPrefWidth(113.0);
        button.setText("Main Menu");
        button.setTextFill(javafx.scene.paint.Color.valueOf("#002bff"));
        button.setFont(new Font("Arial Black", 12.0));

        pane.getChildren().add(imageView);
        anchorPane.getChildren().add(text);
        anchorPane.getChildren().add(text0);
        anchorPane.getChildren().add(text1);
        anchorPane.getChildren().add(text2);
        anchorPane.getChildren().add(text3);
        anchorPane.getChildren().add(addSearchTxt);
        anchorPane.getChildren().add(addSearchBtn);
        anchorPane.getChildren().add(addNameTxt);
        anchorPane.getChildren().add(addLevelTxt);
        anchorPane.getChildren().add(addCrsTxt);
        anchorPane.getChildren().add(addCrsList);
        addGradList.getItems().add(separatorMenuItem);
        addGradList.getItems().add(menuItem);
        addGradList.getItems().add(separatorMenuItem0);
        addGradList.getItems().add(menuItem0);
        addGradList.getItems().add(separatorMenuItem1);
        addGradList.getItems().add(menuItem1);
        addGradList.getItems().add(separatorMenuItem2);
        addGradList.getItems().add(menuItem2);
        addGradList.getItems().add(separatorMenuItem3);
        addGradList.getItems().add(menuItem3);
        anchorPane.getChildren().add(addGradList);
        anchorPane.getChildren().add(addGradTxt);
        anchorPane.getChildren().add(addSubmitBtn);
        tabPane.getTabs().add(tab);
        anchorPane0.getChildren().add(text4);
        anchorPane0.getChildren().add(text5);
        anchorPane0.getChildren().add(text6);
        anchorPane0.getChildren().add(text7);
        anchorPane0.getChildren().add(enrollSearchTxt);
        anchorPane0.getChildren().add(enrollSearchBtn);
        anchorPane0.getChildren().add(enrollNameTxt);
        anchorPane0.getChildren().add(enrollLevelTxt);
        anchorPane0.getChildren().add(enrollCrsTxt);
        anchorPane0.getChildren().add(enrollCrsList);
        anchorPane0.getChildren().add(enrollBtn);
        tabPane.getTabs().add(tab0);
        pane.getChildren().add(tabPane);
        pane.getChildren().add(button);
        getChildren().add(pane);

    button.setOnAction(e -> {
                   try {
                       new sceneController().switchToMainScene(e);
                   } catch (IOException ex) {
                       Logger.getLogger(stuSceneBase.class.getName()).log(Level.SEVERE, null, ex);
                   }
               });
        
        
       addSearchBtn.setOnAction(e -> {
                String userInput = addSearchTxt.getText();

                if (userInput.isEmpty()) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION, "Please enter an ID value!");
                    alert.show();
                } else {
                    try {
                        // Attempt to parse the input as an integer
                        int id = Integer.parseInt(userInput);
                        Student student = getStudent(id);

                        if (student.getName() != null) {
                            // Student exists, update the UI with student details
                            addNameTxt.setText(student.getName());
                            addLevelTxt.setText(student.getLevel());
                            // get courses that the student is enrolled in
                            String courses = getStudentCourses(id);
                            if (courses != null){
                                String[] coursesArray = courses.split("\\|");

                                // Clear existing items in the menu
                                addCrsList.getItems().clear();

                                // Display each course,gh
                                for (String course : coursesArray) {
                                    // Create a new MenuItem for each course
                                    MenuItem menuItem = new MenuItem(course);
                                    // Add the MenuItem to the menu
                                    addCrsList.getItems().add(menuItem);
                                    // Add an event handler to set the selected course text to enrollCrsTxt
                                    menuItem.setOnAction(event -> {
                                        addCrsTxt.setText(menuItem.getText());
                                    });
                                    
                                }
                                
                            }
                            
                            else { 
                                addCrsList.getItems().clear();
                                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Student does not enrolled in any courses");
                            alert.show(); }

                        } else {
                            // Student does not exist, display a message
                            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Student does not exist!");
                            alert.show();
                        }

                    } catch (NumberFormatException ex) {
                        // If parsing fails, it's not a number
                        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Invalid input! Please enter a valid number.");
                        alert.show();
                    } catch (SQLException ex) {
                        Logger.getLogger(DataAccessLayer.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });
       
            for (MenuItem menuItem : addGradList.getItems()) {
                // Add an event handler to set the selected course text to enrollCrsTxt
                menuItem.setOnAction(event -> {
                    addGradTxt.setText(menuItem.getText());
                });
            }
            
            addSubmitBtn.setOnAction(e -> {
                // Parse integers and get string values
                String userInput = addSearchTxt.getText();
                if (userInput.isEmpty()) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION, "Please enter an ID value!");
                    alert.show();
                } else {
                    try {
                        // Attempt to parse the input as an integer
                        int id = Integer.parseInt(userInput);
                        Student student = getStudent(id);

                // Create a confirmation alert
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Dialog");
                alert.setHeaderText("Confirm grade");
                alert.setContentText("Are you sure you want add grade "+addGradTxt.getText()+" to student with id " + id + "?");

                // Get the user's response
                ButtonType result = alert.showAndWait().orElse(ButtonType.CANCEL);

                if (result == ButtonType.OK) {
                    // User confirmed, proceed with deletion
                    try {
                        updateGrade(id, addCrsTxt.getText() , addGradTxt.getText());
                        //clear fields
                        addSearchTxt.clear();
                        addNameTxt.clear();
                        addLevelTxt.clear();
                        addCrsTxt.clear();
                        addGradTxt.clear();
                        addCrsList.getItems().clear();

                    } catch (SQLException ex) {
                        Logger.getLogger(stuSceneBase.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }catch (SQLException ex) {
                        Logger.getLogger(gradSceneBase.class.getName()).log(Level.SEVERE, null, ex);
                }
                    }       
            
            });
            
            
            enrollSearchBtn.setOnAction(e -> {
                String userInput = enrollSearchTxt.getText();

                if (userInput.isEmpty()) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION, "Please enter an ID value!");
                    alert.show();
                } else {
                    try {
                        // Attempt to parse the input as an integer
                        int id = Integer.parseInt(userInput);
                        Student student = getStudent(id);

                        if (student.getName() != null) {
                            // Student exists, update the UI with student details
                            enrollNameTxt.setText(student.getName());
                            enrollLevelTxt.setText(student.getLevel());
                            
                            // get all courses that the student is doesn't enrolled in
                            List<String> allCourses = getAllCourses();
                            String[] coursesArray = {};
                            String courses = getStudentCourses(id);
                            
                            if (courses != null){
                                coursesArray = courses.split("\\|");}
                                // Clear existing items in the menu
                                enrollCrsList.getItems().clear();
                                // Display each course,gh
                                for (String course : allCourses) {
                                    // Create a new MenuItem for each course that the student doesn't enroll in
                                    if (!Arrays.asList(coursesArray).contains(course)) {
                                        MenuItem menuItem = new MenuItem(course);
                                        // Add the MenuItem to the menu
                                        enrollCrsList.getItems().add(menuItem);
                                        // Add an event handler to set the selected course text to addCrsTxt
                                        menuItem.setOnAction(event -> {
                                            enrollCrsTxt.setText(menuItem.getText());
                                        });
                                    }
                                }    

                        } else {
                            // Student does not exist, display a message
                            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Student does not exist!");
                            alert.show();
                        }

                    } catch (NumberFormatException ex) {
                        // If parsing fails, it's not a number
                        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Invalid input! Please enter a valid number.");
                        alert.show();
                    } catch (SQLException ex) {
                        Logger.getLogger(DataAccessLayer.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });
            
            
             enrollBtn.setOnAction(e -> {
                // Parse integers and get string values
                String userInput = enrollSearchTxt.getText();
                if (userInput.isEmpty()) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION, "Please enter an ID value!");
                    alert.show();
                } else {
                    try {
                        // Attempt to parse the input as an integer
                        int id = Integer.parseInt(userInput);
                        Student student = getStudent(id);

                // Create a confirmation alert
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Dialog");
                alert.setHeaderText("Confirm enrollement");
                alert.setContentText("Are you sure you want add course "+enrollCrsTxt.getText()+" to student with id " + id + "?");

                // Get the user's response
                ButtonType result = alert.showAndWait().orElse(ButtonType.CANCEL);

                if (result == ButtonType.OK) {
                    // enroll student to stugrade table 
                    try {
                        enrollStudent(id, enrollCrsTxt.getText());
                        //clear fields
                        enrollSearchTxt.clear();
                        enrollNameTxt.clear();
                        enrollLevelTxt.clear();
                        enrollCrsTxt.clear();
                        enrollCrsList.getItems().clear();
                    
                    } catch (SQLException ex) {
                        Logger.getLogger(stuSceneBase.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }catch (SQLException ex) {
                        Logger.getLogger(gradSceneBase.class.getName()).log(Level.SEVERE, null, ex);
                }
                    }       
            
            });
                                    
    }

   public void switchToMainScene(ActionEvent event) {

       }
}