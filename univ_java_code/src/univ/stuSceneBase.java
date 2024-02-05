package univ;

import dataAccessLayer.DataAccessLayer;
import static dataAccessLayer.DataAccessLayer.getStudent;
import static dataAccessLayer.DataAccessLayer.updateStudent;
import dto.Student;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class stuSceneBase extends StackPane {

    protected final Pane pane;
    protected final ImageView imageView;
    protected final TabPane tabPane;
    protected final Tab tab;
    protected final AnchorPane anchorPane;
    protected final GridPane gridPane;
    protected final ColumnConstraints columnConstraints;
    protected final ColumnConstraints columnConstraints0;
    protected final RowConstraints rowConstraints;
    protected final RowConstraints rowConstraints0;
    protected final RowConstraints rowConstraints1;
    protected final RowConstraints rowConstraints2;
    protected final RowConstraints rowConstraints3;
    protected final Text text;
    protected final Text text0;
    protected final Text text1;
    protected final Text text2;
    protected final Text text3;
    protected final TextField idText;
    protected final TextField nameText;
    protected final TextField levelText;
    protected final TextField emailText;
    protected final TextField didText;
    protected final Button addSubmitBtn;
    protected final Tab tab0;
    protected final AnchorPane anchorPane0;
    protected final GridPane gridPane0;
    protected final ColumnConstraints columnConstraints1;
    protected final ColumnConstraints columnConstraints2;
    protected final RowConstraints rowConstraints4;
    protected final RowConstraints rowConstraints5;
    protected final RowConstraints rowConstraints6;
    protected final RowConstraints rowConstraints7;
    protected final Text text4;
    protected final Text text5;
    protected final Text text6;
    protected final Text text7;
    protected final TextField uNameText;
    protected final TextField uLevelText;
    protected final TextField uEmailText;
    protected final TextField uDidText;
    protected final TextField uIdSearch;
    protected final Button uSearchBtn;
    protected final Button uSubmitBtn;
    protected final Button deleteBtn;
    protected final Button mainmenuBtn;

    public stuSceneBase() {

        pane = new Pane();
        imageView = new ImageView();
        tabPane = new TabPane();
        tab = new Tab();
        anchorPane = new AnchorPane();
        gridPane = new GridPane();
        columnConstraints = new ColumnConstraints();
        columnConstraints0 = new ColumnConstraints();
        rowConstraints = new RowConstraints();
        rowConstraints0 = new RowConstraints();
        rowConstraints1 = new RowConstraints();
        rowConstraints2 = new RowConstraints();
        rowConstraints3 = new RowConstraints();
        text = new Text();
        text0 = new Text();
        text1 = new Text();
        text2 = new Text();
        text3 = new Text();
        idText = new TextField();
        nameText = new TextField();
        levelText = new TextField();
        emailText = new TextField();
        didText = new TextField();
        addSubmitBtn = new Button();
        tab0 = new Tab();
        anchorPane0 = new AnchorPane();
        gridPane0 = new GridPane();
        columnConstraints1 = new ColumnConstraints();
        columnConstraints2 = new ColumnConstraints();
        rowConstraints4 = new RowConstraints();
        rowConstraints5 = new RowConstraints();
        rowConstraints6 = new RowConstraints();
        rowConstraints7 = new RowConstraints();
        text4 = new Text();
        text5 = new Text();
        text6 = new Text();
        text7 = new Text();
        uNameText = new TextField();
        uLevelText = new TextField();
        uEmailText = new TextField();
        uDidText = new TextField();
        uIdSearch = new TextField();
        uSearchBtn = new Button();
        uSubmitBtn = new Button();
        deleteBtn = new Button();
        mainmenuBtn = new Button();

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
        imageView.setOpacity(0.67);
        imageView.setImage(new Image(getClass().getResource("_d642b6ef-8443-4188-8799-b51a78d161c7.jpg").toExternalForm()));

        tabPane.setPrefHeight(660.0);
        tabPane.setPrefWidth(1024.0);
        tabPane.setTabClosingPolicy(javafx.scene.control.TabPane.TabClosingPolicy.UNAVAILABLE);

        tab.setText("ADD Student");

        anchorPane.setMinHeight(0.0);
        anchorPane.setMinWidth(0.0);
        anchorPane.setPrefHeight(180.0);
        anchorPane.setPrefWidth(200.0);

        gridPane.setLayoutX(87.0);
        gridPane.setLayoutY(143.0);
        gridPane.setPrefHeight(343.0);
        gridPane.setPrefWidth(857.0);

        columnConstraints.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints.setMaxWidth(503.0);
        columnConstraints.setMinWidth(10.0);
        columnConstraints.setPrefWidth(323.0);

        columnConstraints0.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints0.setMaxWidth(760.0);
        columnConstraints0.setMinWidth(10.0);
        columnConstraints0.setPrefWidth(534.0);

        rowConstraints.setMinHeight(10.0);
        rowConstraints.setPrefHeight(30.0);
        rowConstraints.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints0.setMinHeight(10.0);
        rowConstraints0.setPrefHeight(30.0);
        rowConstraints0.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints1.setMinHeight(10.0);
        rowConstraints1.setPrefHeight(30.0);
        rowConstraints1.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints2.setMinHeight(10.0);
        rowConstraints2.setPrefHeight(30.0);
        rowConstraints2.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints3.setMinHeight(10.0);
        rowConstraints3.setPrefHeight(30.0);
        rowConstraints3.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        text.setFill(javafx.scene.paint.Color.WHITE);
        text.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text.setStrokeWidth(0.0);
        text.setText("ID");
        text.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        text.setWrappingWidth(293.392578125);
        text.setFont(new Font("Impact", 35.0));

        GridPane.setRowIndex(text0, 1);
        text0.setFill(javafx.scene.paint.Color.WHITE);
        text0.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text0.setStrokeWidth(0.0);
        text0.setText("Name");
        text0.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        text0.setWrappingWidth(299.392578125);
        text0.setFont(new Font("Impact", 35.0));

        GridPane.setRowIndex(text1, 2);
        text1.setFill(javafx.scene.paint.Color.WHITE);
        text1.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text1.setStrokeWidth(0.0);
        text1.setText("Level");
        text1.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        text1.setWrappingWidth(301.392578125);
        text1.setFont(new Font("Impact", 35.0));

        GridPane.setRowIndex(text2, 3);
        text2.setFill(javafx.scene.paint.Color.WHITE);
        text2.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text2.setStrokeWidth(0.0);
        text2.setText("Email");
        text2.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        text2.setWrappingWidth(289.392578125);
        text2.setFont(new Font("Impact", 35.0));

        GridPane.setRowIndex(text3, 4);
        text3.setFill(javafx.scene.paint.Color.WHITE);
        text3.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text3.setStrokeWidth(0.0);
        text3.setText("Department id");
        text3.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        text3.setWrappingWidth(292.392578125);
        text3.setFont(new Font("Impact", 35.0));

        GridPane.setColumnIndex(idText, 1);
        idText.setOpacity(0.82);
        idText.setPrefHeight(13.0);
        idText.setPrefWidth(534.0);
        idText.setPromptText("enter id");
        idText.setFont(new Font(25.0));

        GridPane.setColumnIndex(nameText, 1);
        GridPane.setRowIndex(nameText, 1);
        nameText.setOpacity(0.82);
        nameText.setPrefHeight(50.0);
        nameText.setPrefWidth(534.0);
        nameText.setPromptText("enter name");
        nameText.setFont(new Font(25.0));

        GridPane.setColumnIndex(levelText, 1);
        GridPane.setRowIndex(levelText, 2);
        levelText.setOpacity(0.82);
        levelText.setPrefHeight(53.0);
        levelText.setPrefWidth(708.0);
        levelText.setPromptText("enter level");
        levelText.setFont(new Font(25.0));

        GridPane.setColumnIndex(emailText, 1);
        GridPane.setRowIndex(emailText, 3);
        emailText.setOpacity(0.82);
        emailText.setPrefHeight(56.0);
        emailText.setPrefWidth(708.0);
        emailText.setPromptText("enter email");
        emailText.setFont(new Font(25.0));

        GridPane.setColumnIndex(didText, 1);
        GridPane.setRowIndex(didText, 4);
        didText.setOpacity(0.82);
        didText.setPrefHeight(57.0);
        didText.setPrefWidth(708.0);
        didText.setPromptText("enter department id");
        didText.setFont(new Font(25.0));

        addSubmitBtn.setLayoutX(786.0);
        addSubmitBtn.setLayoutY(549.0);
        addSubmitBtn.setMnemonicParsing(false);
        addSubmitBtn.setPrefHeight(39.0);
        addSubmitBtn.setPrefWidth(184.0);
        addSubmitBtn.setText("Submit");
        addSubmitBtn.setTextFill(javafx.scene.paint.Color.valueOf("#cd0f0f"));
        addSubmitBtn.setFont(new Font("Arial Black", 20.0));
        tab.setContent(anchorPane);

        tab0.setText("UPDATE Student");

        anchorPane0.setMinHeight(0.0);
        anchorPane0.setMinWidth(0.0);
        anchorPane0.setPrefHeight(180.0);
        anchorPane0.setPrefWidth(200.0);

        gridPane0.setLayoutX(142.0);
        gridPane0.setLayoutY(178.0);
        gridPane0.setPrefHeight(303.0);
        gridPane0.setPrefWidth(717.0);

        columnConstraints1.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints1.setMaxWidth(372.0);
        columnConstraints1.setMinWidth(10.0);
        columnConstraints1.setPrefWidth(290.0);

        columnConstraints2.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints2.setMaxWidth(465.0);
        columnConstraints2.setMinWidth(10.0);
        columnConstraints2.setPrefWidth(463.0);

        rowConstraints4.setMinHeight(10.0);
        rowConstraints4.setPrefHeight(30.0);
        rowConstraints4.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints5.setMinHeight(10.0);
        rowConstraints5.setPrefHeight(30.0);
        rowConstraints5.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints6.setMinHeight(10.0);
        rowConstraints6.setPrefHeight(30.0);
        rowConstraints6.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints7.setMinHeight(10.0);
        rowConstraints7.setPrefHeight(30.0);
        rowConstraints7.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        text4.setFill(javafx.scene.paint.Color.WHITE);
        text4.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text4.setStrokeWidth(0.0);
        text4.setText("Name");
        text4.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        text4.setWrappingWidth(277.54931640625);
        text4.setFont(new Font("Impact", 37.0));

        GridPane.setRowIndex(text5, 1);
        text5.setFill(javafx.scene.paint.Color.WHITE);
        text5.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text5.setStrokeWidth(0.0);
        text5.setText("Level");
        text5.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        text5.setWrappingWidth(271.54931640625);
        text5.setFont(new Font("Impact", 37.0));

        GridPane.setRowIndex(text6, 2);
        text6.setFill(javafx.scene.paint.Color.WHITE);
        text6.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text6.setStrokeWidth(0.0);
        text6.setText("Email");
        text6.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        text6.setWrappingWidth(267.54931640625);
        text6.setFont(new Font("Impact", 37.0));

        GridPane.setRowIndex(text7, 3);
        text7.setFill(javafx.scene.paint.Color.WHITE);
        text7.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text7.setStrokeWidth(0.0);
        text7.setText("Department id");
        text7.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        text7.setWrappingWidth(261.54931640625);
        text7.setFont(new Font("Impact", 37.0));

        GridPane.setColumnIndex(uNameText, 1);
        uNameText.setOpacity(0.82);
        uNameText.setPrefHeight(53.0);
        uNameText.setPrefWidth(463.0);
        uNameText.setFont(new Font(27.0));

        GridPane.setColumnIndex(uLevelText, 1);
        GridPane.setRowIndex(uLevelText, 1);
        uLevelText.setOpacity(0.82);
        uLevelText.setPrefHeight(56.0);
        uLevelText.setPrefWidth(463.0);
        uLevelText.setFont(new Font(27.0));

        GridPane.setColumnIndex(uEmailText, 1);
        GridPane.setRowIndex(uEmailText, 2);
        uEmailText.setOpacity(0.82);
        uEmailText.setPrefHeight(60.0);
        uEmailText.setPrefWidth(463.0);
        uEmailText.setFont(new Font(27.0));

        GridPane.setColumnIndex(uDidText, 1);
        GridPane.setRowIndex(uDidText, 3);
        uDidText.setOpacity(0.82);
        uDidText.setPrefHeight(60.0);
        uDidText.setPrefWidth(463.0);
        uDidText.setFont(new Font(27.0));

        uIdSearch.setAlignment(javafx.geometry.Pos.CENTER);
        uIdSearch.setLayoutX(413.0);
        uIdSearch.setLayoutY(80.0);
        uIdSearch.setPrefHeight(36.0);
        uIdSearch.setPrefWidth(199.0);
        uIdSearch.setPromptText("enter student id");
        uIdSearch.setFont(new Font("Arial", 14.0));

        uSearchBtn.setLayoutX(643.0);
        uSearchBtn.setLayoutY(81.0);
        uSearchBtn.setMnemonicParsing(false);
        uSearchBtn.setPrefHeight(35.0);
        uSearchBtn.setPrefWidth(96.0);
        uSearchBtn.setText("Search");
        uSearchBtn.setFont(new Font("Impact", 15.0));

        uSubmitBtn.setLayoutX(795.0);
        uSubmitBtn.setLayoutY(549.0);
        uSubmitBtn.setMnemonicParsing(false);
        uSubmitBtn.setPrefHeight(44.0);
        uSubmitBtn.setPrefWidth(190.0);
        uSubmitBtn.setText("Update info");
        uSubmitBtn.setTextFill(javafx.scene.paint.Color.valueOf("#525fa4"));
        uSubmitBtn.setFont(new Font("Impact", 22.0));

        deleteBtn.setLayoutX(77.0);
        deleteBtn.setLayoutY(542.0);
        deleteBtn.setMnemonicParsing(false);
        deleteBtn.setPrefHeight(48.0);
        deleteBtn.setPrefWidth(181.0);
        deleteBtn.setText("Delete student");
        deleteBtn.setTextFill(javafx.scene.paint.Color.valueOf("#ff0d0d"));
        deleteBtn.setFont(new Font("Impact", 22.0));
        tab0.setContent(anchorPane0);

        mainmenuBtn.setLayoutX(916.0);
        mainmenuBtn.setMnemonicParsing(false);
        mainmenuBtn.setOnAction(this::switchToMainScene);
        mainmenuBtn.setPrefHeight(29.0);
        mainmenuBtn.setPrefWidth(108.0);
        mainmenuBtn.setText("Main Menu");
        mainmenuBtn.setTextFill(javafx.scene.paint.Color.valueOf("#1365a4"));
        mainmenuBtn.setFont(new Font("Arial Black", 12.0));

        pane.getChildren().add(imageView);
        gridPane.getColumnConstraints().add(columnConstraints);
        gridPane.getColumnConstraints().add(columnConstraints0);
        gridPane.getRowConstraints().add(rowConstraints);
        gridPane.getRowConstraints().add(rowConstraints0);
        gridPane.getRowConstraints().add(rowConstraints1);
        gridPane.getRowConstraints().add(rowConstraints2);
        gridPane.getRowConstraints().add(rowConstraints3);
        gridPane.getChildren().add(text);
        gridPane.getChildren().add(text0);
        gridPane.getChildren().add(text1);
        gridPane.getChildren().add(text2);
        gridPane.getChildren().add(text3);
        gridPane.getChildren().add(idText);
        gridPane.getChildren().add(nameText);
        gridPane.getChildren().add(levelText);
        gridPane.getChildren().add(emailText);
        gridPane.getChildren().add(didText);
        anchorPane.getChildren().add(gridPane);
        anchorPane.getChildren().add(addSubmitBtn);
        tabPane.getTabs().add(tab);
        gridPane0.getColumnConstraints().add(columnConstraints1);
        gridPane0.getColumnConstraints().add(columnConstraints2);
        gridPane0.getRowConstraints().add(rowConstraints4);
        gridPane0.getRowConstraints().add(rowConstraints5);
        gridPane0.getRowConstraints().add(rowConstraints6);
        gridPane0.getRowConstraints().add(rowConstraints7);
        gridPane0.getChildren().add(text4);
        gridPane0.getChildren().add(text5);
        gridPane0.getChildren().add(text6);
        gridPane0.getChildren().add(text7);
        gridPane0.getChildren().add(uNameText);
        gridPane0.getChildren().add(uLevelText);
        gridPane0.getChildren().add(uEmailText);
        gridPane0.getChildren().add(uDidText);
        anchorPane0.getChildren().add(gridPane0);
        anchorPane0.getChildren().add(uIdSearch);
        anchorPane0.getChildren().add(uSearchBtn);
        anchorPane0.getChildren().add(uSubmitBtn);
        anchorPane0.getChildren().add(deleteBtn);
        tabPane.getTabs().add(tab0);
        pane.getChildren().add(tabPane);
        pane.getChildren().add(mainmenuBtn);
        getChildren().add(pane);
        
        
        mainmenuBtn.setOnAction(e -> {
            try {
                new sceneController().switchToMainScene(e);
            } catch (IOException ex) {
                Logger.getLogger(stuSceneBase.class.getName()).log(Level.SEVERE, null, ex);
            }
        
                    });
        
        addSubmitBtn.setOnAction(e -> {
                try {
                    // Parse integers and get string values
                    int id = Integer.parseInt(idText.getText());
                    String name = nameText.getText();
                    String level = levelText.getText();
                    String email = emailText.getText();
                    int did = Integer.parseInt(didText.getText());
                    
                     // Clear the text fields
                    idText.clear();
                    nameText.clear();
                    levelText.clear();
                    emailText.clear();
                    didText.clear();

                    // Check for conditions
                    if (id <= 0 || name.isEmpty()) {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Invalid input! Please check your entries.");
                        alert.show();
                        
                    } else {
                        // Proceed to addStudent method
                        DataAccessLayer.addStudent(id, name, level, email, did);
                    }

                } catch (NumberFormatException ex) {
                    // Handle the case where parsing integers fails
                    Alert alert = new Alert(Alert.AlertType.INFORMATION, "Invalid input for ID or Department ID. Please enter valid integers.");
                    alert.show();


                    System.err.println(ex.getMessage());
                } catch (SQLException ex) {
                    // Handle SQL exception
                    Alert alert = new Alert(Alert.AlertType.INFORMATION, "Database error! Please try again.");
                    alert.show();

                    System.err.println(ex.getMessage());
                }
            });
        
        uSearchBtn.setOnAction(e -> {
                String userInput = uIdSearch.getText();

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
                            uNameText.setText(student.getName());
                            uLevelText.setText(student.getLevel());
                            uEmailText.setText(student.getEmail());
                            if (uNameText.getText().isEmpty()) {
                                uDidText.setText("");
                            } else {
                                uDidText.setText(Integer.toString(student.getDid()));
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


        
        uSubmitBtn.setOnAction(e -> {
                    // Parse integers and get string values
                    int id = Integer.parseInt(uIdSearch.getText());
                    String name = uNameText.getText();
                    String level = uLevelText.getText();
                    String email = uEmailText.getText();
                    int did = Integer.parseInt(uDidText.getText());         
                    try {
                        updateStudent(id, name, level, email, did);
                        uNameText.clear();
                        uLevelText.clear();
                        uEmailText.clear();
                        uDidText.clear();
                    } catch (SQLException ex) { 
                Logger.getLogger(stuSceneBase.class.getName()).log(Level.SEVERE, null, ex);
            } 
            });
        
        
       deleteBtn.setOnAction(e -> {
                // Parse integers and get string values
                int id = Integer.parseInt(uIdSearch.getText());

                // Create a confirmation alert
                Alert alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Dialog");
                alert.setHeaderText("Confirm Deletion");
                alert.setContentText("Are you sure you want to delete the student with ID " + id + "?");

                // Get the user's response
                ButtonType result = alert.showAndWait().orElse(ButtonType.CANCEL);

                if (result == ButtonType.OK) {
                    // User confirmed, proceed with deletion
                    try {
                        Connection con = DataAccessLayer.getInstance().connect();
                        PreparedStatement pst = con.prepareStatement("DELETE FROM students WHERE id = ?");
                        pst.setInt(1, id);
                        //clear fields
                        uNameText.clear();
                        uLevelText.clear();
                        uEmailText.clear();
                        uDidText.clear();

                        // Execute the deletion query
                        pst.executeUpdate();

                    } catch (SQLException ex) {
                        Logger.getLogger(stuSceneBase.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });
    }

    public void switchToMainScene(ActionEvent event) {

       }

}
