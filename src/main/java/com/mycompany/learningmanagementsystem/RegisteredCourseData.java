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
    private String studentName;
    private String courseId;
    private String courseName;
    private String paymentStatus;
    
    public RegisteredCourseData(String studentId,String studentName,String courseId,String courseName,String paymentStatus){
        this.studentId=studentId;
        this.studentName=studentName;
        this.courseId=courseId;
        this.courseName=courseName;
        this.paymentStatus=paymentStatus;
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
    public String getPaymentStatus(){
        return paymentStatus;
    }
}
