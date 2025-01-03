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

public class TeacherData {
    private String id;
    private String fName;
    private String lName;
    private String userName;
    private String email;
    private String tel;
    private String password;
    private Date date;
    
    public TeacherData(String id,String fName,String lName,String userName,String email,String tel,String password,Date date){
        this.id=id;
        this.fName=fName;
        this.lName=lName;
        this.userName=userName;
        this.email=email;
        this.tel=tel;
        this.password=password;
        this.date=date;
    }
    public String getId(){
        return id;
    }
    public String getFName(){
        return fName;
    }
    public String getLName(){
        return lName;
    }
    public String getUserName(){
        return userName;
    }
    public String getEmai(){
        return email;
    }
    public String getTel(){
        return tel;
    }
    public String getPasswod(){
        return password;
    }
    public Date getDate(){
        return date;
    }
    
}
