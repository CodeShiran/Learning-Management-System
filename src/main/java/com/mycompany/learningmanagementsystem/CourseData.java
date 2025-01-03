/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.learningmanagementsystem;

import java.sql.Date;

/**
 *
 * @author User
 */
public class CourseData {
    private String id;
    private String name;
    private int months;
    private String fees;
    private String teacherId;
    private String teacherName;
    private Date date;
    
    public CourseData(String id,String name,int months,String fees,String teacherId,String teacherName,Date date){
        this.id=id;
        this.name=name;
        this.months=months;
        this.fees=fees;
        this.teacherId=teacherId;
        this.teacherName=teacherName;
        this.date=date;
    }
    public String getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public int getMonth(){
        return months;
    }
    public String getFees(){
        return fees;
    }
    public String getTeacherId(){
        return teacherId;
    }
    public String getTeacherName(){
        return teacherName;
    }
    public Date getDate(){
        return date;
    }
}
