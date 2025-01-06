/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.learningmanagementsystem;

import com.formdev.flatlaf.FlatClientProperties;
import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author User
 */
public class AdminDashboard extends javax.swing.JFrame {

    /**
     * Creates new form AdminDashboard
     */
    public AdminDashboard() {
        initComponents();
        FetchTeacherData();
        FetchStudentData();
        DisplayTotalCount();
        FetchCourseData();
        populateTeacherComboBox();
        ScaleImage();
        FetchRecentlyAddedStudents();
        TeacherTableDesign();
        RecentlyAddedStudentsTableDesign();
        StudentTableDesign();
        CourseTableDesign();
        PanelBoxDesign();
        //populateTeacherTextBox();
    }
    Connection connection;
    PreparedStatement pst;
    ResultSet rs;
    
    private void PanelBoxDesign(){
        jPanel8.putClientProperty(FlatClientProperties.STYLE, "" +
            "arc: 20;");
        jPanel11.putClientProperty(FlatClientProperties.STYLE, "" +
            "arc: 20;");
        jPanel12.putClientProperty(FlatClientProperties.STYLE, "" +
            "arc: 20;");
        jPanel7.putClientProperty(FlatClientProperties.STYLE, "" +
            "arc: 20;" +                  
            "borderColor: #1366D9;" +      
            "borderWidth: 2;");            
    }
    
    private void CourseTableDesign(){
        jPanel19.putClientProperty(FlatClientProperties.STYLE, "" +
            "arc: 20;" +
            "background: $Table.background");

    
         courseDataTable.getTableHeader().putClientProperty(FlatClientProperties.STYLE, "" +
            "height: 30;" +
            "separatorColor: $Table.gridColor;" +
            "font: bold $Table.font");

    
         courseDataTable.putClientProperty(FlatClientProperties.STYLE, "" +
            "rowHeight: 30;" +
            "showHorizontalLines: true;" +
            "showVerticalLines: true;" +
            "intercellSpacing: 0,1;" +
            "selectionBackground: lighten(@Table.background,8%);" +
            "selectionInactiveBackground: lighten(@Table.background,8%)");

    
         jScrollPane5.setBorder(BorderFactory.createEmptyBorder());
         
         DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

        for (int i = 0; i < courseDataTable.getColumnCount(); i++) {
        courseDataTable.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);}
    }
    
    private void StudentTableDesign(){
         jPanel18.putClientProperty(FlatClientProperties.STYLE, "" +
            "arc: 20;" +
            "background: $Table.background");

    
         studentDataTable.getTableHeader().putClientProperty(FlatClientProperties.STYLE, "" +
            "height: 30;" +
            "separatorColor: $Table.gridColor;" +
            "font: bold $Table.font");

    
         studentDataTable.putClientProperty(FlatClientProperties.STYLE, "" +
            "rowHeight: 30;" +
            "showHorizontalLines: true;" +
            "showVerticalLines: true;" +
            "intercellSpacing: 0,1;" +
            "selectionBackground: lighten(@Table.background,8%);" +
            "selectionInactiveBackground: lighten(@Table.background,8%)");

    
         jScrollPane4.setBorder(BorderFactory.createEmptyBorder());
         
         DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

        for (int i = 0; i < studentDataTable.getColumnCount(); i++) {
        studentDataTable.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);}
    }
    
    
    private void RecentlyAddedStudentsTableDesign(){
        jPanel13.putClientProperty(FlatClientProperties.STYLE, "" +
            "arc: 20;" +
            "background: $Table.background");

    
        recentlyAddedStudentsTable.getTableHeader().putClientProperty(FlatClientProperties.STYLE, "" +
            "height: 30;" +
            "separatorColor: $Table.gridColor;" +
            "font: bold $Table.font");

    
        recentlyAddedStudentsTable.putClientProperty(FlatClientProperties.STYLE, "" +
            "rowHeight: 30;" +
            "showHorizontalLines: true;" +
            "showVerticalLines: true;" +
            "intercellSpacing: 0,1;" +
            "selectionBackground: lighten(@Table.background,8%);" +
            "selectionInactiveBackground: lighten(@Table.background,8%)");

    
        jScrollPane1.setBorder(BorderFactory.createEmptyBorder());
        
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

        for (int i = 0; i < recentlyAddedStudentsTable.getColumnCount(); i++) {
        recentlyAddedStudentsTable.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);}
    
    
    }
    
    
    private void TeacherTableDesign(){
       
        jPanel6.putClientProperty(FlatClientProperties.STYLE, "" +
            "arc: 20;" +
            "background: $Table.background");

    
        teacherDataTable.getTableHeader().putClientProperty(FlatClientProperties.STYLE, "" +
            "height: 30;" +
            "separatorColor: $Table.gridColor;" +
            "font: bold $Table.font");

    
        teacherDataTable.putClientProperty(FlatClientProperties.STYLE, "" +
            "rowHeight: 30;" +
            "showHorizontalLines: true;" +
            "showVerticalLines: true;" +
            "intercellSpacing: 0,1;" +
            "selectionBackground: lighten(@Table.background,8%);" +
            "selectionInactiveBackground: lighten(@Table.background,8%)");

    
        jScrollPane2.setBorder(BorderFactory.createEmptyBorder());
        
         DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

        for (int i = 0; i < teacherDataTable.getColumnCount(); i++) {
        teacherDataTable.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);}

    }
    
    
    private void FetchRecentlyAddedStudents(){
        try {
        
        connection = Database.connectiondb();

        
        String sql = "SELECT id, fName, age, gender FROM student WHERE date >= DATE_SUB(CURDATE(), INTERVAL 5 DAY)";
        pst = connection.prepareStatement(sql);
        rs = pst.executeQuery();

        
        DefaultTableModel model = (DefaultTableModel) recentlyAddedStudentsTable.getModel();
        model.setRowCount(0); 

       
        while (rs.next()) {
            String studentId = rs.getString("id");
            String fName = rs.getString("fName");
            int age = rs.getInt("age");
            String gender = rs.getString("gender");

           
            model.addRow(new Object[]{studentId, fName, age, gender});
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error fetching data: " + ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
    } finally {
        try {
            if (rs != null) rs.close();
            if (pst != null) pst.close();
            if (connection != null) connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    }
    public void ScaleImage(){
        ImageIcon icon=new ImageIcon("D:\\nibm project\\LearningManagementSystem\\src\\main\\java\\com\\mycompany\\learningmanagementsystem\\Images\\file-3.png");
        Image img=icon.getImage();
        Image imgScale=img.getScaledInstance(label5.getWidth(), label5.getHeight(), Image.SCALE_AREA_AVERAGING);
        ImageIcon scaledIcon=new ImageIcon(imgScale);
        label5.setIcon(scaledIcon);
        
        ImageIcon icon2=new ImageIcon("D:\\nibm project\\LearningManagementSystem\\src\\main\\java\\com\\mycompany\\learningmanagementsystem\\Images\\Logout-1.png");
        Image img2=icon2.getImage();
        Image imgScale2=img2.getScaledInstance(label8.getWidth(), label8.getHeight(), Image.SCALE_AREA_AVERAGING);
        ImageIcon scaledIcon2=new ImageIcon(imgScale2);
        label8.setIcon(scaledIcon2);
    }
    
    /*private void populateTeacherTextBox(){
        try {
        String teacherId = teacherId_cmb.getSelectedItem().toString(); // Get selected teacher ID from combo box

        // Establish the database connection
        connection = Database.connectiondb();
        
        // Prepare the SQL statement to fetch teacher's name based on the selected ID
        pst = connection.prepareStatement("SELECT fName, lName FROM teacher WHERE id = ?");
        pst.setString(1, teacherId); // Set the teacherId parameter
        
        rs = pst.executeQuery();
        
        // Process the result set
        if (rs.next()) {
            String teacherName = rs.getString("fName") + " " + rs.getString("lName"); // Combine fName and lName
            cteacherName_txt.setText(teacherName); // Set the label text
        } else {
            cteacherName_txt.setText(""); // Clear the label if no match found
        }
    } catch (Exception ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error loading teacher data: " + ex.getMessage());
    } finally {
        try {
            if (rs != null) rs.close();
            if (pst != null) pst.close();
            if (connection != null) connection.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    }*/
    
    private void populateTeacherComboBox() {
    try {
        connection = Database.connectiondb();
        pst = connection.prepareStatement("SELECT id, fName, lName FROM teacher");
        rs = pst.executeQuery();
        
        while (rs.next()) {
            String teacherId = rs.getString("id");
            cteacherId_cmb.addItem(teacherId); 
            
        }
    } catch (Exception ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error loading teacher data: " + ex.getMessage());
    }
}

    private void FetchCourseData(){
        List<CourseData>course=getCourseData();
        
        DefaultTableModel df=(DefaultTableModel)courseDataTable.getModel();
        df.setRowCount(0);
        
        for(CourseData data:course){
            Object[] rowData={data.getId(), data.getName(), data.getMonth(), data.getFees(), data.getTeacherId(), data.getTeacherName(), data.getDate()};
            df.addRow(rowData);
        }
    }
    
    
    
    public List<CourseData> getCourseData(){
        List<CourseData>course=new ArrayList<>();
        
        try{
            connection=Database.connectiondb();
            pst=connection.prepareStatement("SELECT * FROM course");
            rs=pst.executeQuery();
            
            while(rs.next()){
                String id=rs.getString("id");
                String name=rs.getString("name");
                int months=rs.getInt("months");
                String fees=rs.getString("fees");
                String teacherId=rs.getString("teacherId");
                String teacherName=rs.getString("teacherName");
                Date date = rs.getDate("date");
                
                
                course.add(new CourseData(id,name,months,fees,teacherId,teacherName,date));
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return course;
    }
    
    private void DisplayTotalCount(){
        try {
        
        connection = Database.connectiondb();
        
        
        pst = connection.prepareStatement("SELECT COUNT(*) FROM student");
        rs = pst.executeQuery();
        if (rs.next()) {
            totalStudent_txt.setText(rs.getString(1)); 
        }

        
        pst = connection.prepareStatement("SELECT COUNT(*) FROM teacher");
        rs = pst.executeQuery();
        if (rs.next()) {
            totalTeachers_txt.setText(rs.getString(1)); 
        }

        
        pst = connection.prepareStatement("SELECT COUNT(*) FROM course");
        rs = pst.executeQuery();
        if (rs.next()) {
           totalCourses_txt.setText(rs.getString(1)); 
        }

    } catch (SQLException ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error fetching totals: " + ex.getMessage());
    } finally {
        try {
            if (rs != null) rs.close();
            if (pst != null) pst.close();
            if (connection != null) connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    }
    private void FetchTeacherData(){
        List<TeacherData>teacher=getTeacherData();
        
        DefaultTableModel df=(DefaultTableModel)teacherDataTable.getModel();
        df.setRowCount(0);
        
        for(TeacherData data:teacher){
            Object[] rowData={data.getId(), data.getFName(), data.getLName(), data.getUserName(), data.getEmai(), data.getTel(), data.getPasswod(), data.getDate()};
            df.addRow(rowData);
        }
    }
    
    public List<TeacherData> getTeacherData(){
        List<TeacherData>teacher=new ArrayList<>();
        
        try{
            connection=Database.connectiondb();
            pst=connection.prepareStatement("SELECT id, fName, lName, userName, email, tel, password, date FROM teacher");
            rs=pst.executeQuery();
            
            while(rs.next()){
                String id=rs.getString("id");
                String lName=rs.getString("fName");
                String fName=rs.getString("lName");
                String userName=rs.getString("userName");
                String email=rs.getString("email");
                String tel=rs.getString("tel");
                String password=rs.getString("password");
                Date date = rs.getDate("date");
                
                teacher.add(new TeacherData(id,fName,lName,userName,email,tel,password,date));
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return teacher;
    }
    private void FetchStudentData(){
        List<StudentData>student=getStudentData();
        
        DefaultTableModel df=(DefaultTableModel)studentDataTable.getModel();
        df.setRowCount(0);
        
        for(StudentData data:student){
            Object[] rowData={data.getId(), data.getFName(), data.getLName(), data.getUserName(), data.getEmail(), data.getGender(), data.getAge(), data.getPassword(),data.getDate()};
            df.addRow(rowData);
        }
    }
    
    public List<StudentData> getStudentData(){
        List<StudentData>student=new ArrayList<>();
        
        try{
            connection=Database.connectiondb();
            pst=connection.prepareStatement("SELECT * FROM student");
            rs=pst.executeQuery();
            
            while(rs.next()){
                String id=rs.getString("id");
                String lName=rs.getString("fName");
                String fName=rs.getString("lName");
                String userName=rs.getString("userName");
                String email=rs.getString("email");
                String gender=rs.getString("gender");
                int age=rs.getInt("age");
                String password=rs.getString("password");
                 Date date = rs.getDate("date");
                
                student.add(new StudentData(id,fName,lName,userName,email,gender,age,password,date));
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return student;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        overview_btn = new com.mycompany.learningmanagementsystem.Button();
        teacher_btn = new com.mycompany.learningmanagementsystem.Button();
        student_btn = new com.mycompany.learningmanagementsystem.Button();
        jPanel10 = new javax.swing.JPanel();
        label8 = new javax.swing.JLabel();
        jPanel22 = new javax.swing.JPanel();
        label5 = new javax.swing.JLabel();
        ssignout_btn = new com.mycompany.learningmanagementsystem.Button();
        course_btn = new com.mycompany.learningmanagementsystem.Button();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        totalStudent_txt = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        totalTeachers_txt = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        totalCourses_txt = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        recentlyAddedStudentsTable = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        id_txt = new javax.swing.JTextField();
        fName_txt = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        lName_txt = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        atuserName_txt = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        email_txt = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        tel_txt = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        add_btn = new com.mycompany.learningmanagementsystem.Button();
        update_btn = new com.mycompany.learningmanagementsystem.Button();
        delete_btn = new com.mycompany.learningmanagementsystem.Button();
        reset_btn = new com.mycompany.learningmanagementsystem.Button();
        jLabel15 = new javax.swing.JLabel();
        password_txt = new javax.swing.JTextField();
        teacherReport_btn = new com.mycompany.learningmanagementsystem.Button();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        teacherDataTable = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        sid_txt = new javax.swing.JTextField();
        sfName_txt = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        slName_txt = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        satuserName_txt = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        semail_txt = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        sadd_btn1 = new com.mycompany.learningmanagementsystem.Button();
        supdate_btn = new com.mycompany.learningmanagementsystem.Button();
        sdelete_btn = new com.mycompany.learningmanagementsystem.Button();
        sreset_btn = new com.mycompany.learningmanagementsystem.Button();
        jLabel22 = new javax.swing.JLabel();
        sage_txt = new javax.swing.JTextField();
        sgender_cmb = new javax.swing.JComboBox<>();
        jLabel23 = new javax.swing.JLabel();
        spassword_txt = new javax.swing.JTextField();
        studentReport_btn = new com.mycompany.learningmanagementsystem.Button();
        jPanel18 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        studentDataTable = new javax.swing.JTable();
        jPanel14 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        cname_txt = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        cfees_txt = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        cmonths_cmb = new javax.swing.JComboBox<>();
        cteacherId_cmb = new javax.swing.JComboBox<>();
        jLabel30 = new javax.swing.JLabel();
        teacherName_txt = new javax.swing.JTextField();
        searchTeacher_btn = new com.mycompany.learningmanagementsystem.Button();
        ccourseId_txt = new javax.swing.JTextField();
        jPanel19 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        courseDataTable = new javax.swing.JTable();
        cadd_btn = new com.mycompany.learningmanagementsystem.Button();
        cupdate_btn = new com.mycompany.learningmanagementsystem.Button();
        cdelete_btn = new com.mycompany.learningmanagementsystem.Button();
        creset_btn = new com.mycompany.learningmanagementsystem.Button();
        courseReport_btn = new com.mycompany.learningmanagementsystem.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        overview_btn.setBorder(null);
        overview_btn.setText("Overview");
        overview_btn.setBorderColor(new java.awt.Color(0, 0, 0));
        overview_btn.setBorderPainted(false);
        overview_btn.setColor(new java.awt.Color(19, 102, 217));
        overview_btn.setColorClick(new java.awt.Color(16, 162, 252));
        overview_btn.setColorOver(new java.awt.Color(60, 141, 255));
        overview_btn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        overview_btn.setRadius(15);
        overview_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                overview_btnActionPerformed(evt);
            }
        });

        teacher_btn.setBorder(null);
        teacher_btn.setText("Teacher");
        teacher_btn.setBorderColor(new java.awt.Color(0, 0, 0));
        teacher_btn.setBorderPainted(false);
        teacher_btn.setColor(new java.awt.Color(19, 102, 217));
        teacher_btn.setColorClick(new java.awt.Color(16, 162, 252));
        teacher_btn.setColorOver(new java.awt.Color(60, 141, 255));
        teacher_btn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        teacher_btn.setRadius(15);
        teacher_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                teacher_btnActionPerformed(evt);
            }
        });

        student_btn.setBorder(null);
        student_btn.setText("Student");
        student_btn.setBorderColor(new java.awt.Color(0, 0, 0));
        student_btn.setBorderPainted(false);
        student_btn.setColor(new java.awt.Color(19, 102, 217));
        student_btn.setColorClick(new java.awt.Color(16, 162, 252));
        student_btn.setColorOver(new java.awt.Color(60, 141, 255));
        student_btn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        student_btn.setRadius(15);
        student_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                student_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label8, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(7, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(label8, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label5, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label5, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                .addContainerGap())
        );

        ssignout_btn.setBorder(null);
        ssignout_btn.setText("Sign Out");
        ssignout_btn.setBorderColor(new java.awt.Color(0, 0, 0));
        ssignout_btn.setBorderPainted(false);
        ssignout_btn.setColor(new java.awt.Color(255, 106, 106));
        ssignout_btn.setColorClick(new java.awt.Color(255, 31, 31));
        ssignout_btn.setColorOver(new java.awt.Color(255, 31, 31));
        ssignout_btn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ssignout_btn.setRadius(15);
        ssignout_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ssignout_btnActionPerformed(evt);
            }
        });

        course_btn.setBorder(null);
        course_btn.setText("Course");
        course_btn.setBorderColor(new java.awt.Color(0, 0, 0));
        course_btn.setBorderPainted(false);
        course_btn.setColor(new java.awt.Color(19, 102, 217));
        course_btn.setColorClick(new java.awt.Color(16, 162, 252));
        course_btn.setColorOver(new java.awt.Color(60, 141, 255));
        course_btn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        course_btn.setRadius(15);
        course_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                course_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(overview_btn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(teacher_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(student_btn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(course_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ssignout_btn, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(overview_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(teacher_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(student_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(course_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(ssignout_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51))))
        );

        jTabbedPane1.setEnabled(false);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        jPanel8.setBackground(new java.awt.Color(96, 162, 252));
        jPanel8.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 0, true));
        jPanel8.setPreferredSize(new java.awt.Dimension(102, 107));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("<html>Total Number\nOf Students \n Entrolled</html>\n");

        totalStudent_txt.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        totalStudent_txt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        totalStudent_txt.setText("0");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(totalStudent_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(totalStudent_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jPanel11.setBackground(new java.awt.Color(96, 162, 252));
        jPanel11.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 0, true));
        jPanel11.setPreferredSize(new java.awt.Dimension(102, 107));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("<html>Total Number Of Teachers  Available</html> ");

        totalTeachers_txt.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        totalTeachers_txt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        totalTeachers_txt.setText("0");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(totalTeachers_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(totalTeachers_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addContainerGap(43, Short.MAX_VALUE))
        );

        jPanel12.setBackground(new java.awt.Color(96, 162, 252));
        jPanel12.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 0, true));
        jPanel12.setPreferredSize(new java.awt.Dimension(102, 107));

        jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("<html>Total Number Of Courses Available</html> ");

        totalCourses_txt.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        totalCourses_txt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        totalCourses_txt.setText("0");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(totalCourses_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(totalCourses_txt)
                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 150, Short.MAX_VALUE)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(141, 141, 141)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        recentlyAddedStudentsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Id", "First Name", "Age", "Gender"
            }
        ));
        jScrollPane1.setViewportView(recentlyAddedStudentsTable);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Recently Added Students");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("tab1", jPanel2);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Add Teacher");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Teacher Id");

        id_txt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        fName_txt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setText("First Name");

        lName_txt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setText("Last Name");

        atuserName_txt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setText("User Name");

        email_txt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel13.setText("Email");

        tel_txt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel14.setText("Tel");

        add_btn.setBorder(null);
        add_btn.setText("ADD");
        add_btn.setBorderColor(new java.awt.Color(0, 0, 0));
        add_btn.setBorderPainted(false);
        add_btn.setColor(new java.awt.Color(16, 162, 252));
        add_btn.setColorClick(new java.awt.Color(19, 102, 217));
        add_btn.setColorOver(new java.awt.Color(60, 141, 255));
        add_btn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        add_btn.setRadius(15);
        add_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_btnActionPerformed(evt);
            }
        });

        update_btn.setBorder(null);
        update_btn.setText("UPDATE");
        update_btn.setBorderColor(new java.awt.Color(0, 0, 0));
        update_btn.setBorderPainted(false);
        update_btn.setColor(new java.awt.Color(16, 162, 252));
        update_btn.setColorClick(new java.awt.Color(19, 102, 217));
        update_btn.setColorOver(new java.awt.Color(60, 141, 255));
        update_btn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        update_btn.setRadius(15);
        update_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                update_btnActionPerformed(evt);
            }
        });

        delete_btn.setBorder(null);
        delete_btn.setText("DELETE");
        delete_btn.setBorderColor(new java.awt.Color(0, 0, 0));
        delete_btn.setBorderPainted(false);
        delete_btn.setColor(new java.awt.Color(16, 162, 252));
        delete_btn.setColorClick(new java.awt.Color(19, 102, 217));
        delete_btn.setColorOver(new java.awt.Color(60, 141, 255));
        delete_btn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        delete_btn.setRadius(15);
        delete_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete_btnActionPerformed(evt);
            }
        });

        reset_btn.setBorder(null);
        reset_btn.setText("RESET");
        reset_btn.setBorderColor(new java.awt.Color(0, 0, 0));
        reset_btn.setBorderPainted(false);
        reset_btn.setColor(new java.awt.Color(255, 106, 106));
        reset_btn.setColorClick(new java.awt.Color(255, 31, 31));
        reset_btn.setColorOver(new java.awt.Color(255, 31, 31));
        reset_btn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        reset_btn.setRadius(15);
        reset_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reset_btnActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel15.setText("password");

        password_txt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        teacherReport_btn.setBorder(null);
        teacherReport_btn.setText("Report");
        teacherReport_btn.setBorderColor(new java.awt.Color(0, 0, 0));
        teacherReport_btn.setBorderPainted(false);
        teacherReport_btn.setColor(new java.awt.Color(255, 106, 106));
        teacherReport_btn.setColorClick(new java.awt.Color(255, 31, 31));
        teacherReport_btn.setColorOver(new java.awt.Color(255, 31, 31));
        teacherReport_btn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        teacherReport_btn.setRadius(15);
        teacherReport_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                teacherReport_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(add_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(update_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(delete_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(reset_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(teacherReport_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(id_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(fName_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(lName_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(atuserName_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(email_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(tel_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(password_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(511, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(id_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(fName_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(lName_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(atuserName_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(email_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(tel_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(password_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(add_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(update_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(delete_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(reset_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(teacherReport_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );

        teacherDataTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Id", "First Name", "Last Name", "User Name", "Email", "Tel", "password", "Date"
            }
        ));
        teacherDataTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                teacherDataTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(teacherDataTable);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 850, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("tab2", jPanel3);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Add Student");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel16.setText("Student Id");

        sid_txt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        sfName_txt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel17.setText("First Name");

        slName_txt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel18.setText("Last Name");

        satuserName_txt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel19.setText("User Name");

        semail_txt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel20.setText("Email");

        jLabel21.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel21.setText("Gender");

        sadd_btn1.setBorder(null);
        sadd_btn1.setText("ADD");
        sadd_btn1.setBorderColor(new java.awt.Color(0, 0, 0));
        sadd_btn1.setBorderPainted(false);
        sadd_btn1.setColor(new java.awt.Color(16, 162, 252));
        sadd_btn1.setColorClick(new java.awt.Color(19, 102, 217));
        sadd_btn1.setColorOver(new java.awt.Color(60, 141, 255));
        sadd_btn1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        sadd_btn1.setRadius(15);
        sadd_btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sadd_btn1ActionPerformed(evt);
            }
        });

        supdate_btn.setBorder(null);
        supdate_btn.setText("UPDATE");
        supdate_btn.setBorderColor(new java.awt.Color(0, 0, 0));
        supdate_btn.setBorderPainted(false);
        supdate_btn.setColor(new java.awt.Color(16, 162, 252));
        supdate_btn.setColorClick(new java.awt.Color(19, 102, 217));
        supdate_btn.setColorOver(new java.awt.Color(60, 141, 255));
        supdate_btn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        supdate_btn.setRadius(15);
        supdate_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supdate_btnActionPerformed(evt);
            }
        });

        sdelete_btn.setBorder(null);
        sdelete_btn.setText("DELETE");
        sdelete_btn.setBorderColor(new java.awt.Color(0, 0, 0));
        sdelete_btn.setBorderPainted(false);
        sdelete_btn.setColor(new java.awt.Color(16, 162, 252));
        sdelete_btn.setColorClick(new java.awt.Color(19, 102, 217));
        sdelete_btn.setColorOver(new java.awt.Color(60, 141, 255));
        sdelete_btn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        sdelete_btn.setRadius(15);
        sdelete_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sdelete_btnActionPerformed(evt);
            }
        });

        sreset_btn.setBorder(null);
        sreset_btn.setText("RESET");
        sreset_btn.setBorderColor(new java.awt.Color(0, 0, 0));
        sreset_btn.setBorderPainted(false);
        sreset_btn.setColor(new java.awt.Color(255, 106, 106));
        sreset_btn.setColorClick(new java.awt.Color(255, 31, 31));
        sreset_btn.setColorOver(new java.awt.Color(255, 31, 31));
        sreset_btn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        sreset_btn.setRadius(15);
        sreset_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sreset_btnActionPerformed(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel22.setText("Age");

        sage_txt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        sgender_cmb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male ", "Female", " " }));

        jLabel23.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel23.setText("password");

        spassword_txt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        studentReport_btn.setBorder(null);
        studentReport_btn.setText("Report");
        studentReport_btn.setBorderColor(new java.awt.Color(0, 0, 0));
        studentReport_btn.setBorderPainted(false);
        studentReport_btn.setColor(new java.awt.Color(255, 106, 106));
        studentReport_btn.setColorClick(new java.awt.Color(255, 31, 31));
        studentReport_btn.setColorOver(new java.awt.Color(255, 31, 31));
        studentReport_btn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        studentReport_btn.setRadius(15);
        studentReport_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentReport_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(sadd_btn1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(supdate_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(sdelete_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(sreset_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(studentReport_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(sid_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(sfName_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(slName_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(satuserName_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(semail_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(sage_txt, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                            .addComponent(sgender_cmb, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(spassword_txt)))
                .addContainerGap(511, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(sid_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(sfName_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(slName_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(satuserName_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(semail_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(sgender_cmb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(sage_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(spassword_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sadd_btn1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(supdate_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sdelete_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sreset_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(studentReport_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        studentDataTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Id", "First Name", "Last Name", "User Name", "Email", "Gender", "Age", "Password", "Date"
            }
        ));
        studentDataTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                studentDataTableMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(studentDataTable);

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 850, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("tab3", jPanel4);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setText("Add Course");

        jLabel24.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel24.setText("Course Id");

        cname_txt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel26.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel26.setText("Course Name");

        jLabel27.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel27.setText("Months");

        cfees_txt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel28.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel28.setText("Fees");

        jLabel29.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel29.setText("Teacher Id");

        cmonths_cmb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "3", "6", "12" }));

        jLabel30.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel30.setText("Teacher Name");

        teacherName_txt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        searchTeacher_btn.setBorder(null);
        searchTeacher_btn.setText("Search");
        searchTeacher_btn.setBorderColor(new java.awt.Color(0, 0, 0));
        searchTeacher_btn.setBorderPainted(false);
        searchTeacher_btn.setColor(new java.awt.Color(255, 106, 106));
        searchTeacher_btn.setColorClick(new java.awt.Color(255, 31, 31));
        searchTeacher_btn.setColorOver(new java.awt.Color(255, 31, 31));
        searchTeacher_btn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        searchTeacher_btn.setRadius(15);
        searchTeacher_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchTeacher_btnActionPerformed(evt);
            }
        });

        ccourseId_txt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(cfees_txt))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cname_txt, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
                            .addComponent(cmonths_cmb, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ccourseId_txt, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE))))
                .addGap(45, 45, 45)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(cteacherId_cmb, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(teacherName_txt, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(searchTeacher_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(jLabel29)
                    .addComponent(cteacherId_cmb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchTeacher_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ccourseId_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel30)
                        .addComponent(teacherName_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel26)
                        .addComponent(cname_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(cmonths_cmb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(cfees_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        courseDataTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Name", "Months", "Fees", "Teacher Id", "Teacher Name", "Date Created"
            }
        ));
        courseDataTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                courseDataTableMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(courseDataTable);

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 850, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE)
                .addContainerGap())
        );

        cadd_btn.setBorder(null);
        cadd_btn.setText("ADD");
        cadd_btn.setBorderColor(new java.awt.Color(0, 0, 0));
        cadd_btn.setBorderPainted(false);
        cadd_btn.setColor(new java.awt.Color(16, 162, 252));
        cadd_btn.setColorClick(new java.awt.Color(19, 102, 217));
        cadd_btn.setColorOver(new java.awt.Color(60, 141, 255));
        cadd_btn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cadd_btn.setRadius(15);
        cadd_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadd_btnActionPerformed(evt);
            }
        });

        cupdate_btn.setBorder(null);
        cupdate_btn.setText("UPDATE");
        cupdate_btn.setBorderColor(new java.awt.Color(0, 0, 0));
        cupdate_btn.setBorderPainted(false);
        cupdate_btn.setColor(new java.awt.Color(16, 162, 252));
        cupdate_btn.setColorClick(new java.awt.Color(19, 102, 217));
        cupdate_btn.setColorOver(new java.awt.Color(60, 141, 255));
        cupdate_btn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cupdate_btn.setRadius(15);
        cupdate_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cupdate_btnActionPerformed(evt);
            }
        });

        cdelete_btn.setBorder(null);
        cdelete_btn.setText("DELETE");
        cdelete_btn.setBorderColor(new java.awt.Color(0, 0, 0));
        cdelete_btn.setBorderPainted(false);
        cdelete_btn.setColor(new java.awt.Color(16, 162, 252));
        cdelete_btn.setColorClick(new java.awt.Color(19, 102, 217));
        cdelete_btn.setColorOver(new java.awt.Color(60, 141, 255));
        cdelete_btn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cdelete_btn.setRadius(15);
        cdelete_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cdelete_btnActionPerformed(evt);
            }
        });

        creset_btn.setBorder(null);
        creset_btn.setText("RESET");
        creset_btn.setBorderColor(new java.awt.Color(0, 0, 0));
        creset_btn.setBorderPainted(false);
        creset_btn.setColor(new java.awt.Color(255, 106, 106));
        creset_btn.setColorClick(new java.awt.Color(255, 31, 31));
        creset_btn.setColorOver(new java.awt.Color(255, 31, 31));
        creset_btn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        creset_btn.setRadius(15);
        creset_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                creset_btnActionPerformed(evt);
            }
        });

        courseReport_btn.setBorder(null);
        courseReport_btn.setText("Report");
        courseReport_btn.setBorderColor(new java.awt.Color(0, 0, 0));
        courseReport_btn.setBorderPainted(false);
        courseReport_btn.setColor(new java.awt.Color(255, 106, 106));
        courseReport_btn.setColorClick(new java.awt.Color(255, 31, 31));
        courseReport_btn.setColorOver(new java.awt.Color(255, 31, 31));
        courseReport_btn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        courseReport_btn.setRadius(15);
        courseReport_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                courseReport_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addComponent(cadd_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cupdate_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cdelete_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(creset_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(courseReport_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cadd_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cupdate_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cdelete_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(creset_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(courseReport_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("tab4", jPanel14);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void add_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_btnActionPerformed
        try {
        connection = Database.connectiondb();
        pst = connection.prepareStatement("INSERT INTO teacher (id, fName, lName, userName, email, tel, password,date) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
        
        pst.setString(1, id_txt.getText());
        pst.setString(2, fName_txt.getText());
        pst.setString(3, lName_txt.getText());
        pst.setString(4, atuserName_txt.getText());
        pst.setString(5, email_txt.getText());
        pst.setString(6, tel_txt.getText());
        pst.setString(7, password_txt.getText());
        pst.setDate(8, new java.sql.Date(System.currentTimeMillis()));
        

        int rowsInserted = pst.executeUpdate();
        if (rowsInserted > 0) {
            JOptionPane.showMessageDialog(null, "Teacher added successfully!");
            FetchTeacherData();
            DisplayTotalCount();
            populateTeacherComboBox();
            
        }
    } catch (Exception ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error adding teacher: " + ex.getMessage());
    } finally {
        try {
            if (pst != null) pst.close();
            if (connection != null) connection.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    }//GEN-LAST:event_add_btnActionPerformed

    private void teacherDataTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_teacherDataTableMouseClicked
        int selectedRow = teacherDataTable.getSelectedRow(); 
        DefaultTableModel model = (DefaultTableModel) teacherDataTable.getModel(); 

        
        id_txt.setText(model.getValueAt(selectedRow, 0).toString());
        fName_txt.setText(model.getValueAt(selectedRow, 1).toString());
        lName_txt.setText(model.getValueAt(selectedRow, 2).toString());
        atuserName_txt.setText(model.getValueAt(selectedRow, 3).toString());
        email_txt.setText(model.getValueAt(selectedRow, 4).toString());
        tel_txt.setText(model.getValueAt(selectedRow, 5).toString());
        password_txt.setText(model.getValueAt(selectedRow, 6).toString());
    }//GEN-LAST:event_teacherDataTableMouseClicked

    private void update_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_update_btnActionPerformed
         try {
        connection = Database.connectiondb();
        pst = connection.prepareStatement("UPDATE teacher SET fName = ?, lName = ?, userName = ?, email = ?, tel = ?, password = ? WHERE id = ?");

        
        pst.setString(1, fName_txt.getText());
        pst.setString(2, lName_txt.getText());
        pst.setString(3, atuserName_txt.getText());
        pst.setString(4, email_txt.getText());
        pst.setString(5, tel_txt.getText());
        pst.setString(6, password_txt.getText());
        pst.setString(7, id_txt.getText());

        int rowsUpdated = pst.executeUpdate();
        if (rowsUpdated > 0) {
            JOptionPane.showMessageDialog(null, "Teacher updated successfully!");
            FetchTeacherData(); 
            DisplayTotalCount();
            populateTeacherComboBox();
        } else {
            JOptionPane.showMessageDialog(null, "No teacher found with the given ID.");
        }
    } catch (Exception ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error updating teacher: " + ex.getMessage());
    } finally {
        try {
            if (pst != null) pst.close();
            if (connection != null) connection.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    }//GEN-LAST:event_update_btnActionPerformed

    private void delete_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_btnActionPerformed
        try {
    
    int confirmation = JOptionPane.showConfirmDialog(null,"Are you sure you want to delete this teacher?","Confirm Deletion",JOptionPane.YES_NO_OPTION);

    
    if (confirmation == JOptionPane.YES_OPTION) {
        connection = Database.connectiondb();
        pst = connection.prepareStatement("DELETE FROM teacher WHERE id = ?");
        
        pst.setString(1, id_txt.getText()); 

        int rowsDeleted = pst.executeUpdate();
        if (rowsDeleted > 0) {
            JOptionPane.showMessageDialog(null, "Teacher deleted successfully!");
            FetchTeacherData(); 
            DisplayTotalCount();
            populateTeacherComboBox();
        } else {
            JOptionPane.showMessageDialog(null, "No teacher found with the given ID.");
        }
    } else {
        JOptionPane.showMessageDialog(null, "Deletion cancelled.");
    }
} catch (Exception ex) {
    ex.printStackTrace();
    JOptionPane.showMessageDialog(null, "Error deleting teacher: " + ex.getMessage());
} finally {
    try {
        if (pst != null) pst.close();
        if (connection != null) connection.close();
    } catch (Exception ex) {
        ex.printStackTrace();
    }
}
    }//GEN-LAST:event_delete_btnActionPerformed

    private void reset_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reset_btnActionPerformed
    id_txt.setText("");           
    fName_txt.setText("");        
    lName_txt.setText("");        
    atuserName_txt.setText("");   
    email_txt.setText("");        
    tel_txt.setText("");          
    password_txt.setText("");
    }//GEN-LAST:event_reset_btnActionPerformed

    private void sadd_btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sadd_btn1ActionPerformed
        try {

        connection = Database.connectiondb();

        String sql = "INSERT INTO student (id, fname, lname, username, email, gender, age, password, date) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        pst = connection.prepareStatement(sql);

        // Set parameters
        pst.setString(1, sid_txt.getText());
        pst.setString(2, sfName_txt.getText());
        pst.setString(3, slName_txt.getText());
        pst.setString(4, satuserName_txt.getText());
        pst.setString(5, semail_txt.getText());
        pst.setString(6, sgender_cmb.getSelectedItem().toString());
        pst.setInt(7, Integer.parseInt(sage_txt.getText()));
        pst.setString(8, spassword_txt.getText());
        pst.setDate(9, new java.sql.Date(System.currentTimeMillis()));

        // Execute update
        int rowsInserted = pst.executeUpdate();
        if (rowsInserted > 0) {
            JOptionPane.showMessageDialog(null, "Student added successfully!");
            FetchStudentData();
            DisplayTotalCount();
            sid_txt.setText("");
            sfName_txt.setText("");
            slName_txt.setText("");
            satuserName_txt.setText("");
            semail_txt.setText("");
            sgender_cmb.setSelectedIndex(0);
            sage_txt.setText("");
            spassword_txt.setText("");
            
        } else {
            JOptionPane.showMessageDialog(null, "Failed to add student.", "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error adding student: " + ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
    } finally {
        // Close resources
        try {
            if (pst != null) pst.close();
            if (connection != null) connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    }//GEN-LAST:event_sadd_btn1ActionPerformed

    private void supdate_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supdate_btnActionPerformed
        try {
        
        connection = Database.connectiondb();

        
        pst = connection.prepareStatement("UPDATE student SET fName = ?, lName = ?, userName = ?, email = ?, gender = ?, age = ?, password = ? WHERE id = ?");

        
        pst.setString(1, sfName_txt.getText().trim());
        pst.setString(2, slName_txt.getText().trim());
        pst.setString(3, satuserName_txt.getText().trim());
        pst.setString(4, semail_txt.getText().trim());
        pst.setString(5, sgender_cmb.getSelectedItem().toString());
        
        
        String ageText = sage_txt.getText().trim();
        int age;
        try {
            age = Integer.parseInt(ageText);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Please enter a valid integer for age.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        pst.setInt(6, age);
        pst.setString(7, spassword_txt.getText().trim());
        pst.setString(8, sid_txt.getText().trim());

        
        int rowsUpdated = pst.executeUpdate();

        if (rowsUpdated > 0) {
            JOptionPane.showMessageDialog(null, "Student details updated successfully!");
            FetchStudentData(); 
            DisplayTotalCount();
            sid_txt.setText("");
            sfName_txt.setText("");
            slName_txt.setText("");
            satuserName_txt.setText("");
            semail_txt.setText("");
            sgender_cmb.setSelectedIndex(0);
            sage_txt.setText("");
            spassword_txt.setText("");
        } else {
            JOptionPane.showMessageDialog(null, "No student found with the given ID.");
        }
    } catch (Exception ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error updating student: " + ex.getMessage());
    } finally {
        
        try {
            if (pst != null) pst.close();
            if (connection != null) connection.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    }//GEN-LAST:event_supdate_btnActionPerformed

    private void sdelete_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sdelete_btnActionPerformed
        try {

    int confirmation = JOptionPane.showConfirmDialog(null,"Are you sure you want to delete this student?","Confirm Deletion",JOptionPane.YES_NO_OPTION);


    if (confirmation == JOptionPane.YES_OPTION) {
        connection = Database.connectiondb();
        pst = connection.prepareStatement("DELETE FROM student WHERE id = ?");
        
        pst.setString(1, sid_txt.getText());

        int rowsDeleted = pst.executeUpdate();
        if (rowsDeleted > 0) {
            JOptionPane.showMessageDialog(null, "Student deleted successfully!");
            FetchStudentData();
            DisplayTotalCount();

            sid_txt.setText("");
            sfName_txt.setText("");
            slName_txt.setText("");
            satuserName_txt.setText("");
            semail_txt.setText("");
            sgender_cmb.setSelectedIndex(0);
            sage_txt.setText("");
            spassword_txt.setText("");
        } else {
            JOptionPane.showMessageDialog(null, "No student found with the given ID.");
        }
    } else {
        JOptionPane.showMessageDialog(null, "Deletion cancelled.");
    }
} catch (Exception ex) {
    ex.printStackTrace();
    JOptionPane.showMessageDialog(null, "Error deleting student: " + ex.getMessage());
} finally {
    try {
        if (pst != null) pst.close();
        if (connection != null) connection.close();
    } catch (Exception ex) {
        ex.printStackTrace();
    }
}
    }//GEN-LAST:event_sdelete_btnActionPerformed

    private void sreset_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sreset_btnActionPerformed
        sid_txt.setText("");
        sfName_txt.setText("");
        slName_txt.setText("");
        satuserName_txt.setText("");
        semail_txt.setText("");
        sgender_cmb.setSelectedIndex(0);
        sage_txt.setText("");
        spassword_txt.setText("");
        
        
    }//GEN-LAST:event_sreset_btnActionPerformed

    private void studentDataTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_studentDataTableMouseClicked
        int selectedRow = studentDataTable.getSelectedRow(); 
    DefaultTableModel model = (DefaultTableModel) studentDataTable.getModel();

    
    sid_txt.setText(model.getValueAt(selectedRow, 0).toString());
    sfName_txt.setText(model.getValueAt(selectedRow, 1).toString());
    slName_txt.setText(model.getValueAt(selectedRow, 2).toString());
    satuserName_txt.setText(model.getValueAt(selectedRow, 3).toString());
    semail_txt.setText(model.getValueAt(selectedRow, 4).toString());
    sgender_cmb.setSelectedItem(model.getValueAt(selectedRow, 5).toString());
    sage_txt.setText(model.getValueAt(selectedRow, 6).toString());
    spassword_txt.setText(model.getValueAt(selectedRow, 7).toString());
    }//GEN-LAST:event_studentDataTableMouseClicked

    private void overview_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_overview_btnActionPerformed
        jTabbedPane1.setSelectedIndex(0);
    }//GEN-LAST:event_overview_btnActionPerformed

    private void teacher_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_teacher_btnActionPerformed
        jTabbedPane1.setSelectedIndex(1);
    }//GEN-LAST:event_teacher_btnActionPerformed

    private void student_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_student_btnActionPerformed
        jTabbedPane1.setSelectedIndex(2);
    }//GEN-LAST:event_student_btnActionPerformed

    private void course_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_course_btnActionPerformed
        jTabbedPane1.setSelectedIndex(3);
    }//GEN-LAST:event_course_btnActionPerformed

    private void cadd_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadd_btnActionPerformed
       try {
        connection = Database.connectiondb();

        
        String sql = "INSERT INTO course (id, name, months, fees, teacherId, teacherName) VALUES (?, ?, ?, ?, ?, ?)";
        pst = connection.prepareStatement(sql);

       
        pst.setString(1, ccourseId_txt.getText().trim());
        pst.setString(2, cname_txt.getText().trim());
        pst.setInt(3, Integer.parseInt(cmonths_cmb.getSelectedItem().toString()));
        pst.setDouble(4, Double.parseDouble(cfees_txt.getText().trim()));
        pst.setString(5, cteacherId_cmb.getSelectedItem().toString());
        pst.setString(6, teacherName_txt.getText().trim());

        int rowsInserted = pst.executeUpdate();
        if (rowsInserted > 0) {
            JOptionPane.showMessageDialog(null, "Course added successfully!");

            
            FetchCourseData(); 
            DisplayTotalCount();
            ccourseId_txt.setText("");
            cname_txt.setText("");
            cfees_txt.setText("");
            cmonths_cmb.setSelectedIndex(0);
            cteacherId_cmb.setSelectedIndex(0); 
            teacherName_txt.setText("");
        } else {
            JOptionPane.showMessageDialog(null, "Failed to add course.", "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    } catch (NumberFormatException nfe) {
        JOptionPane.showMessageDialog(null, "Invalid number format in months or fees: " + nfe.getMessage(), "Input Error", JOptionPane.ERROR_MESSAGE);
    } catch (SQLException ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error adding course: " + ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
    } finally {
        try {
            if (pst != null) pst.close();
            if (connection != null) connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    }//GEN-LAST:event_cadd_btnActionPerformed

    private void cupdate_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cupdate_btnActionPerformed
        try {
        
        connection = Database.connectiondb();

        
        String sql = "UPDATE course SET name = ?, months = ?, fees = ?, teacherId = ? teacherName=? WHERE id = ?";
        pst = connection.prepareStatement(sql);

       
        pst.setString(1, cname_txt.getText().trim()); 
        pst.setInt(2, Integer.parseInt(cmonths_cmb.getSelectedItem().toString())); 
        pst.setDouble(3, Double.parseDouble(cfees_txt.getText().trim())); 
        pst.setString(4, teacherName_txt.getText().trim()); 
        pst.setString(5, ccourseId_txt.getText()); 
        

       
        int rowsUpdated = pst.executeUpdate();
        if (rowsUpdated > 0) {
            JOptionPane.showMessageDialog(null, "Course updated successfully!");
            
            FetchCourseData(); 
            DisplayTotalCount();
            ccourseId_txt.setText("");
            cname_txt.setText("");
            cfees_txt.setText("");
            cmonths_cmb.setSelectedIndex(0);
            cteacherId_cmb.setSelectedIndex(0);  
        } else {
            JOptionPane.showMessageDialog(null, "No course found with the given ID.", "Update Failed", JOptionPane.ERROR_MESSAGE);
        }
    } catch (NumberFormatException nfe) {
        JOptionPane.showMessageDialog(null, "Invalid number format in months or fees: " + nfe.getMessage(), "Input Error", JOptionPane.ERROR_MESSAGE);
    } catch (SQLException ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error updating course: " + ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
    } finally {
        
        try {
            if (pst != null) pst.close();
            if (connection != null) connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    }//GEN-LAST:event_cupdate_btnActionPerformed

    private void cdelete_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cdelete_btnActionPerformed
         try {
        
        if (ccourseId_txt.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter or select a Course ID to delete.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        
        int confirm = JOptionPane.showConfirmDialog(null, 
                "Are you sure you want to delete this course?", "Delete Confirmation", 
                JOptionPane.YES_NO_OPTION);
        if (confirm != JOptionPane.YES_OPTION) {
            return; 
        }

        
        connection = Database.connectiondb();

        
        String sql = "DELETE FROM course WHERE id = ?";
        pst = connection.prepareStatement(sql);

       
        pst.setString(1, ccourseId_txt.getText());

       
        int rowsDeleted = pst.executeUpdate();
        if (rowsDeleted > 0) {
            JOptionPane.showMessageDialog(null, "Course deleted successfully!");
            
            FetchCourseData(); 
            DisplayTotalCount();
            ccourseId_txt.setText("");
            cname_txt.setText("");
            cfees_txt.setText("");
            cmonths_cmb.setSelectedIndex(0);
            cteacherId_cmb.setSelectedIndex(0); 
        } else {
            JOptionPane.showMessageDialog(null, "No course found with the given ID.", "Delete Failed", JOptionPane.ERROR_MESSAGE);
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error deleting course: " + ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
    } finally {
        // Close database resources
        try {
            if (pst != null) pst.close();
            if (connection != null) connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    }//GEN-LAST:event_cdelete_btnActionPerformed

    private void creset_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_creset_btnActionPerformed
        ccourseId_txt.setText("");
        cname_txt.setText("");
        cfees_txt.setText("");
        cmonths_cmb.setSelectedIndex(0);
        cteacherId_cmb.setSelectedIndex(0); 
        teacherName_txt.setText("");
    }//GEN-LAST:event_creset_btnActionPerformed

    private void courseDataTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_courseDataTableMouseClicked
        int selectedRow = courseDataTable.getSelectedRow(); 
        DefaultTableModel model = (DefaultTableModel) courseDataTable.getModel(); 

        
        ccourseId_txt.setText(model.getValueAt(selectedRow, 0).toString()); // Assuming courseId is the first column
        cname_txt.setText(model.getValueAt(selectedRow, 1).toString());    // Assuming name is the second column
        cmonths_cmb.setSelectedItem(model.getValueAt(selectedRow, 2).toString());
        cfees_txt.setText(model.getValueAt(selectedRow, 3).toString());
        cteacherId_cmb.setSelectedItem(model.getValueAt(selectedRow, 4).toString());
        teacherName_txt.setText(model.getValueAt(selectedRow, 5).toString());
        
    }//GEN-LAST:event_courseDataTableMouseClicked

    private void ssignout_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ssignout_btnActionPerformed
        this.hide();
        AdminLoginForm frame=new AdminLoginForm();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }//GEN-LAST:event_ssignout_btnActionPerformed

    private void teacherReport_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_teacherReport_btnActionPerformed
        try{
          connection=Database.connectiondb();
          JasperReport jr=JasperCompileManager.compileReport("D:\\nibm project\\LearningManagementSystem\\src\\main\\java\\com\\mycompany\\learningmanagementsystem\\Reports\\teacherlist.jrxml");
          JasperPrint jp=JasperFillManager.fillReport(jr,null,connection);
          JasperViewer viewer = new JasperViewer(jp, false);
          viewer.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE); 
          viewer.setVisible(true); 
          
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }//GEN-LAST:event_teacherReport_btnActionPerformed

    private void studentReport_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentReport_btnActionPerformed
        try{
          connection=Database.connectiondb();
          JasperReport jr=JasperCompileManager.compileReport("D:\\nibm project\\LearningManagementSystem\\src\\main\\java\\com\\mycompany\\learningmanagementsystem\\Reports\\studentlist.jrxml");
          JasperPrint jp=JasperFillManager.fillReport(jr,null,connection);
          JasperViewer viewer = new JasperViewer(jp, false);
          viewer.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE); 
          viewer.setVisible(true); 
          
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }//GEN-LAST:event_studentReport_btnActionPerformed

    private void courseReport_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_courseReport_btnActionPerformed
        try{
          connection=Database.connectiondb();
          JasperReport jr=JasperCompileManager.compileReport("D:\\nibm project\\LearningManagementSystem\\src\\main\\java\\com\\mycompany\\learningmanagementsystem\\Reports\\courselist.jrxml");
          JasperPrint jp=JasperFillManager.fillReport(jr,null,connection);
          JasperViewer viewer = new JasperViewer(jp, false);
          viewer.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE); // Close only the report window
          viewer.setVisible(true);
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }//GEN-LAST:event_courseReport_btnActionPerformed

    private void searchTeacher_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchTeacher_btnActionPerformed
       try {
        
        String selectedTeacherId = cteacherId_cmb.getSelectedItem().toString();

        connection = Database.connectiondb();
        
        pst = connection.prepareStatement("SELECT CONCAT(fName, ' ', lName) AS fullName FROM teacher WHERE id = ?");
        pst.setString(1, selectedTeacherId); 

        rs = pst.executeQuery();

        if (rs.next()) {
            
            String fullName = rs.getString("fullName");

            
            teacherName_txt.setText(fullName);
        } else {
            
            teacherName_txt.setText("");
            JOptionPane.showMessageDialog(null, "No teacher found with the selected ID.", "No Data", JOptionPane.WARNING_MESSAGE);
        }
    } catch (Exception ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error fetching teacher data: " + ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
    } finally {
        try {
            if (rs != null) rs.close();
            if (pst != null) pst.close();
            if (connection != null) connection.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    }//GEN-LAST:event_searchTeacher_btnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AdminDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminDashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.mycompany.learningmanagementsystem.Button add_btn;
    private javax.swing.JTextField atuserName_txt;
    private com.mycompany.learningmanagementsystem.Button cadd_btn;
    private javax.swing.JTextField ccourseId_txt;
    private com.mycompany.learningmanagementsystem.Button cdelete_btn;
    private javax.swing.JTextField cfees_txt;
    private javax.swing.JComboBox<String> cmonths_cmb;
    private javax.swing.JTextField cname_txt;
    private javax.swing.JTable courseDataTable;
    private com.mycompany.learningmanagementsystem.Button courseReport_btn;
    private com.mycompany.learningmanagementsystem.Button course_btn;
    private com.mycompany.learningmanagementsystem.Button creset_btn;
    private javax.swing.JComboBox<String> cteacherId_cmb;
    private com.mycompany.learningmanagementsystem.Button cupdate_btn;
    private com.mycompany.learningmanagementsystem.Button delete_btn;
    private javax.swing.JTextField email_txt;
    private javax.swing.JTextField fName_txt;
    private javax.swing.JTextField id_txt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField lName_txt;
    private javax.swing.JLabel label5;
    private javax.swing.JLabel label8;
    private com.mycompany.learningmanagementsystem.Button overview_btn;
    private javax.swing.JTextField password_txt;
    private javax.swing.JTable recentlyAddedStudentsTable;
    private com.mycompany.learningmanagementsystem.Button reset_btn;
    private com.mycompany.learningmanagementsystem.Button sadd_btn1;
    private javax.swing.JTextField sage_txt;
    private javax.swing.JTextField satuserName_txt;
    private com.mycompany.learningmanagementsystem.Button sdelete_btn;
    private com.mycompany.learningmanagementsystem.Button searchTeacher_btn;
    private javax.swing.JTextField semail_txt;
    private javax.swing.JTextField sfName_txt;
    private javax.swing.JComboBox<String> sgender_cmb;
    private javax.swing.JTextField sid_txt;
    private javax.swing.JTextField slName_txt;
    private javax.swing.JTextField spassword_txt;
    private com.mycompany.learningmanagementsystem.Button sreset_btn;
    private com.mycompany.learningmanagementsystem.Button ssignout_btn;
    private javax.swing.JTable studentDataTable;
    private com.mycompany.learningmanagementsystem.Button studentReport_btn;
    private com.mycompany.learningmanagementsystem.Button student_btn;
    private com.mycompany.learningmanagementsystem.Button supdate_btn;
    private javax.swing.JTable teacherDataTable;
    private javax.swing.JTextField teacherName_txt;
    private com.mycompany.learningmanagementsystem.Button teacherReport_btn;
    private com.mycompany.learningmanagementsystem.Button teacher_btn;
    private javax.swing.JTextField tel_txt;
    private javax.swing.JLabel totalCourses_txt;
    private javax.swing.JLabel totalStudent_txt;
    private javax.swing.JLabel totalTeachers_txt;
    private com.mycompany.learningmanagementsystem.Button update_btn;
    // End of variables declaration//GEN-END:variables
}
