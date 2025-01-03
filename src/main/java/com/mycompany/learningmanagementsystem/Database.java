/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.learningmanagementsystem;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author User
 */
public class Database {
    public static Connection connectiondb(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connect=DriverManager.getConnection("jdbc:mysql://localhost:3306/lms","root","");
            return connect;
        }
        catch(Exception ex){
            ex.printStackTrace();
            return null;
        }
    }
}
