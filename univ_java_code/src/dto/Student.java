/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author manue
 */
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Student {

    private final SimpleIntegerProperty id = new SimpleIntegerProperty();
    private final SimpleStringProperty name = new SimpleStringProperty();
    private final SimpleStringProperty level = new SimpleStringProperty();
    private final SimpleStringProperty email = new SimpleStringProperty();
    private final SimpleIntegerProperty did = new SimpleIntegerProperty();

    // Constructors
    public Student() {
        // Default constructor
    }
    
    public Student(int id, String name){
        this.id.set(id);
        this.name.set(name);
    }
    
    public Student(int id, String name, String level, String email, int did) {
        this.id.set(id);
        this.name.set(name);
        this.level.set(level);
        this.email.set(email);
        this.did.set(did);
    }

    public Student(String course_name, String grade) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    // id property
    public int getId() {
        return id.get();
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public SimpleIntegerProperty idProperty() {
        return id;
    }

    // name property
    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    // level property
    public String getLevel() {
        return level.get();
    }

    public void setLevel(String level) {
        this.level.set(level);
    }

    public SimpleStringProperty levelProperty() {
        return level;
    }

    // email property
    public String getEmail() {
        return email.get();
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public SimpleStringProperty emailProperty() {
        return email;
    }

    // did property
    public int getDid() {
        return did.get();
    }

    public void setDid(int did) {
        this.did.set(did);
    }

    public SimpleIntegerProperty didProperty() {
        return did;
    }
}



