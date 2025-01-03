/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.learningmanagementsystem;

/**
 *
 * @author User
 */
public class MarksData {
    private String studentId;
    private String studentName;
    private String courseId;
    private String courseName;
    private int marks;
    
    public MarksData(String studentId,String studentName,String courseId,String courseName,int marks){
        this.studentId=studentId;
        this.studentName=studentName;
        this.courseId=courseId;
        this.courseName=courseName;
        this.marks=marks;
    }
    public String getStudentId(){
        return studentId;
    }
    public String getStudentName(){
        return studentName;
    }
    public String getCourseId(){
        return courseId;
    }
    public String getCourseName(){
        return courseName;
    }
    public int getMarks(){
        return marks;
    }
}
