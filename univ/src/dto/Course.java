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


import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Course {
    private final SimpleIntegerProperty cid = new SimpleIntegerProperty();
    private final SimpleStringProperty courseGrade = new SimpleStringProperty();
    private final SimpleStringProperty courseName = new SimpleStringProperty();

    // Constructors
    public Course() {
        // Default constructor
    }

    public Course(int cid, String courseName) {
        this.cid.set(cid);
        this.courseName.set(courseName);
    }
    
    public Course(String courseName, String courseGrade) {
        this.courseName.set(courseName);
        this.courseGrade.set(courseGrade);
    }


    // cid property
    public int getCid() {
        return cid.get();
    }

    public void setCid(int cid) {
        this.cid.set(cid);
    }

    public SimpleIntegerProperty cidProperty() {
        return cid;
    }

    // courseName property
    public String getCourseName() {
        return courseName.get();
    }

    public void setCourseName(String courseName) {
        this.courseName.set(courseName);
    }

    public SimpleStringProperty courseNameProperty() {
        return courseName;
    }
    
    // courseGrade property
    public String getCourseGrade() {
        return courseGrade.get();
    }
    
    public void setCourseGrade(String courseGrade) {
        this.courseGrade.set(courseGrade);
    }
    
    public SimpleStringProperty courseGradeProperty() {
        return courseGrade;
    }
    

}



    

    
