/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package univ;

import java.io.IOException;
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author manue
 */
public class sceneController {

 private Stage stage;
 private Scene scene;
 private Parent root;
 
 public void switchToMainScene(ActionEvent event) throws IOException {
  root = FXMLLoader.load(getClass().getResource("mainScene.fxml"));
  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
  scene = new Scene(root);
  stage.setScene(scene);
  stage.show();
 }
 
 public void switchToGradScene(ActionEvent event) throws IOException {
  Parent root = new gradSceneBase();
  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
  scene = new Scene(root);
  stage.setScene(scene);
  stage.show();
 }
 
 public void switchToReportScene(ActionEvent event) throws IOException, SQLException {
  Parent root = new reportSceneBase();
  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
  scene = new Scene(root);
  stage.setScene(scene);
  stage.show();
 }
 
 public void switchToStuScene(ActionEvent event) throws IOException {
  Parent root = new stuSceneBase();
  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
  scene = new Scene(root);
  stage.setScene(scene);
  stage.show();
 }
 
 public void switchToDepartScene(ActionEvent event) throws IOException, SQLException {
  Parent root = new departSceneBase();
  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
  scene = new Scene(root);
  stage.setScene(scene);
  stage.show();
 }
}

    
    
    

