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
    private String courseId;
    private int marks;
    
    public MarksData(String studentId,String courseId,int marks){
        this.studentId=studentId;
        this.courseId=courseId;
        this.marks=marks;
    }
    public String getStudentId(){
        return studentId;
    }
    public String getCourseId(){
        return courseId;
    }
    public int getMarks(){
        return marks;
    }
}
