/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.learningmanagementsystem;

/**
 *
 * @author User
 */
public class RegisteredCourseData {
    private String studentId;
    private String courseId;
    
    public RegisteredCourseData(String studentId,String courseId){
        this.studentId=studentId;
        this.courseId=courseId;
    }
    
    public String getStudentId(){
        return studentId;
    }
    public String getCourseId(){
        return courseId;
    }
}
