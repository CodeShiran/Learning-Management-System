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
import javax.swing.JOptionPane;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class StudentDashboard extends javax.swing.JFrame {

    /**
     * Creates new form StudentDashboard
     */
    public StudentDashboard() {
        initComponents();
        populateStudentComboBox();
        populateCourseComboBox();
        FetchRegisteredCourseData();
        FetchMarksData();
        FetchRecentlyUpdatedCourses();
        DisplayTotalCount();
        ScaleImage();
        RecentlyAddedCoursesTableDesign();
        CourseSelectionTableDesign();
        ExamMarksTableDesign();
        PanelBoxDesign();
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
    
    private void ExamMarksTableDesign(){
        jPanel9.putClientProperty(FlatClientProperties.STYLE, "" +
            "arc: 20;" +
            "background: $Table.background");

    
         sStudentMarksViewTable.getTableHeader().putClientProperty(FlatClientProperties.STYLE, "" +
            "height: 30;" +
            "separatorColor: $Table.gridColor;" +
            "font: bold $Table.font");

    
         sStudentMarksViewTable.putClientProperty(FlatClientProperties.STYLE, "" +
            "rowHeight: 30;" +
            "showHorizontalLines: true;" +
            "showVerticalLines: true;" +
            "intercellSpacing: 0,1;" +
            "selectionBackground: lighten(@Table.background,8%);" +
            "selectionInactiveBackground: lighten(@Table.background,8%)");

    
         jScrollPane3.setBorder(BorderFactory.createEmptyBorder());
         
         DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

        for (int i = 0; i < sStudentMarksViewTable.getColumnCount(); i++) {
        sStudentMarksViewTable.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);}
         
         
    }
    
    private void CourseSelectionTableDesign(){
        jPanel6.putClientProperty(FlatClientProperties.STYLE, "" +
            "arc: 20;" +
            "background: $Table.background");

    
         registeredCourseDataTable.getTableHeader().putClientProperty(FlatClientProperties.STYLE, "" +
            "height: 30;" +
            "separatorColor: $Table.gridColor;" +
            "font: bold $Table.font");

    
         registeredCourseDataTable.putClientProperty(FlatClientProperties.STYLE, "" +
            "rowHeight: 30;" +
            "showHorizontalLines: true;" +
            "showVerticalLines: true;" +
            "intercellSpacing: 0,1;" +
            "selectionBackground: lighten(@Table.background,8%);" +
            "selectionInactiveBackground: lighten(@Table.background,8%)");

    
         jScrollPane2.setBorder(BorderFactory.createEmptyBorder());
         
         DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

        for (int i = 0; i < registeredCourseDataTable.getColumnCount(); i++) {
        registeredCourseDataTable.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);}
    }
    
    private void RecentlyAddedCoursesTableDesign(){
        jPanel13.putClientProperty(FlatClientProperties.STYLE, "" +
            "arc: 20;" +
            "background: $Table.background");

    
         recentlyUpdatedCoursesTable.getTableHeader().putClientProperty(FlatClientProperties.STYLE, "" +
            "height: 30;" +
            "separatorColor: $Table.gridColor;" +
            "font: bold $Table.font");

    
         recentlyUpdatedCoursesTable.putClientProperty(FlatClientProperties.STYLE, "" +
            "rowHeight: 30;" +
            "showHorizontalLines: true;" +
            "showVerticalLines: true;" +
            "intercellSpacing: 0,1;" +
            "selectionBackground: lighten(@Table.background,8%);" +
            "selectionInactiveBackground: lighten(@Table.background,8%)");

    
         jScrollPane1.setBorder(BorderFactory.createEmptyBorder());
         
         
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

        for (int i = 0; i < recentlyUpdatedCoursesTable.getColumnCount(); i++) {
        recentlyUpdatedCoursesTable.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);}
         
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
        
        ImageIcon icon3=new ImageIcon("D:\\nibm project\\LearningManagementSystem\\src\\main\\java\\com\\mycompany\\learningmanagementsystem\\Images\\Education-rafiki.png");
        Image img3=icon3.getImage();
        Image imgScale3=img3.getScaledInstance(jLabel2.getWidth(), jLabel2.getHeight(), Image.SCALE_AREA_AVERAGING);
        ImageIcon scaledIcon3=new ImageIcon(imgScale3);
        jLabel2.setIcon(scaledIcon3);
        
    }
    
    public void FetchRecentlyUpdatedCourses(){
         try {
        
        connection = Database.connectiondb();

        
        String sql = "SELECT id, name, fees, months FROM course WHERE date >= DATE_SUB(CURDATE(), INTERVAL 2 MONTH)";
        pst = connection.prepareStatement(sql);
        rs = pst.executeQuery();

       
        DefaultTableModel model = (DefaultTableModel) recentlyUpdatedCoursesTable.getModel();
        model.setRowCount(0); 

        
        while (rs.next()) {
            String courseId = rs.getString("id");
            String courseName = rs.getString("name");
            double fees = rs.getDouble("fees");
            int months = rs.getInt("months");

            
            model.addRow(new Object[]{courseId, courseName, fees, months});
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
    
    private void FetchMarksData(){
        List<MarksData>mark=getMarksData();
        
        DefaultTableModel df=(DefaultTableModel)sStudentMarksViewTable.getModel();
        df.setRowCount(0);
        
        for(MarksData data:mark){
            Object[] rowData={data.getStudentId(), data.getStudentName(), data.getCourseId(), data.getCourseName(), data.getMarks()};
            df.addRow(rowData);
        }
    }
    
    public List<MarksData> getMarksData(){
        List<MarksData>mark=new ArrayList<>();
        
        try{
            connection=Database.connectiondb();
            pst=connection.prepareStatement("SELECT c.courseId, c.coursename, c.studentId, CONCAT(s.fName, ' ', s.lName) AS studentName, m.marks " +
               "FROM coursereg c " +
               "JOIN student s ON c.studentId = s.Id " +
               "JOIN marks m ON c.courseId = m.courseId AND c.studentId = m.studentId " +
               "WHERE c.paymentStatus = 'Paid'");
            rs=pst.executeQuery();
            
            while(rs.next()){
                String studentId=rs.getString("studentId");
                String studentName=rs.getString("studentname");
                String courseId=rs.getString("courseId");
                String courseName=rs.getString("coursename");
                int marks=rs.getInt("marks");
                
                
                
                mark.add(new MarksData(studentId,studentName,courseId,courseName,marks));
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return mark;
    }
    
    private void FetchRegisteredCourseData(){
        List<RegisteredCourseData>courseData=getRegisteredData();
        
        DefaultTableModel df=(DefaultTableModel)registeredCourseDataTable.getModel();
        df.setRowCount(0);
        
        for(RegisteredCourseData data:courseData){
            Object[] rowData={data.getStudentId(), data.getStudentName(), data.getCourseId(), data.getCourseName(), data.getPaymentStatus()};
            df.addRow(rowData);
        }
    }
    
    public List<RegisteredCourseData> getRegisteredData(){
        List<RegisteredCourseData>courseData=new ArrayList<>();
        
        try{
            connection=Database.connectiondb();
            pst = connection.prepareStatement("SELECT * FROM coursereg");
            rs=pst.executeQuery();
            
            while(rs.next()){
                String studentId=rs.getString("studentId");
                String studentName=rs.getString("studentname");
                String courseId=rs.getString("courseId");
                String courseName=rs.getString("coursename");
                String paymentStatus=rs.getString("paymentstatus");

                courseData.add(new RegisteredCourseData(studentId, studentName, courseId, courseName, paymentStatus));
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return courseData;
    }
    
    
     private void populateStudentComboBox() {
    try {
        connection = Database.connectiondb();
        pst = connection.prepareStatement("SELECT id FROM student");
        rs = pst.executeQuery();
        
        while (rs.next()) {
            String studentId = rs.getString("id");
            sstudentId_cmb.addItem(studentId); 
            studentSearchId_cmb.addItem(studentId);
            
        }
    } catch (Exception ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error loading teacher data: " + ex.getMessage());
    }
}
     private void populateCourseComboBox() {
    try {
        connection = Database.connectiondb();
        pst = connection.prepareStatement("SELECT id FROM course");
        rs = pst.executeQuery();
        
        while (rs.next()) {
            String courseId = rs.getString("id");
            scourseId_cmb.addItem(courseId); 
            
        }
    } catch (Exception ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error loading teacher data: " + ex.getMessage());
    }
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
        jPanel10 = new javax.swing.JPanel();
        label8 = new javax.swing.JLabel();
        overview_btn = new com.mycompany.learningmanagementsystem.Button();
        teacher_btn = new com.mycompany.learningmanagementsystem.Button();
        student_btn = new com.mycompany.learningmanagementsystem.Button();
        ssignout_btn = new com.mycompany.learningmanagementsystem.Button();
        jPanel22 = new javax.swing.JPanel();
        label5 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        totalTeachers_txt = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        totalStudent_txt = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        totalCourses_txt = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        recentlyUpdatedCoursesTable = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        registeredCourseDataTable = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        sstudentId_cmb = new javax.swing.JComboBox<>();
        supdate_btn = new com.mycompany.learningmanagementsystem.Button();
        jLabel3 = new javax.swing.JLabel();
        sstudentName_txt = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        scourseId_cmb = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        scourseName_txt = new javax.swing.JTextField();
        studentSearch_btn1 = new com.mycompany.learningmanagementsystem.Button();
        courseSearch_btn = new com.mycompany.learningmanagementsystem.Button();
        jLabel13 = new javax.swing.JLabel();
        paymentStatus_txt = new javax.swing.JLabel();
        spaymentStatus_cmb = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        sStudentMarksViewTable = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        studentSearch_btn = new com.mycompany.learningmanagementsystem.Button();
        studentReset_btn = new com.mycompany.learningmanagementsystem.Button();
        studentSearchId_cmb = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(label8, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(label8, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

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
        teacher_btn.setText("Course");
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
        student_btn.setText("Exam");
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

        label5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(label5, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label5, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(ssignout_btn, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(overview_btn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
            .addComponent(student_btn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(teacher_btn, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addComponent(overview_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(79, 79, 79)
                .addComponent(student_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(ssignout_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44))))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(285, 285, 285)
                    .addComponent(teacher_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(352, Short.MAX_VALUE)))
        );

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        jPanel8.setBackground(new java.awt.Color(96, 162, 252));
        jPanel8.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 0, true));
        jPanel8.setPreferredSize(new java.awt.Dimension(102, 107));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("<html>Total Number Of  Teachers Available</html> ");

        totalTeachers_txt.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        totalTeachers_txt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        totalTeachers_txt.setText("0");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(totalTeachers_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                    .addComponent(totalTeachers_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel11.setBackground(new java.awt.Color(96, 162, 252));
        jPanel11.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 0, true));
        jPanel11.setPreferredSize(new java.awt.Dimension(102, 107));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("<html>Total Number Of  Students Enrolled</html> ");

        totalStudent_txt.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        totalStudent_txt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        totalStudent_txt.setText("0");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(totalStudent_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                    .addComponent(totalStudent_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel12.setBackground(new java.awt.Color(96, 162, 252));
        jPanel12.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 0, true));
        jPanel12.setPreferredSize(new java.awt.Dimension(102, 107));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("<html>Total Number Of  Courses Available</html> ");

        totalCourses_txt.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        totalCourses_txt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        totalCourses_txt.setText("0");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(totalCourses_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                    .addComponent(totalCourses_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(133, 133, 133)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 137, Short.MAX_VALUE)
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

        recentlyUpdatedCoursesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Course Id", "Title", "Fees", "Duration(Months)"
            }
        ));
        jScrollPane1.setViewportView(recentlyUpdatedCoursesTable);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Recently Added Courses");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(25, 25, 25))
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
        jLabel1.setText("Course Selection");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        registeredCourseDataTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Course Id", "Course Name", "Student Id", "Student Name", "Payment Status"
            }
        ));
        registeredCourseDataTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                registeredCourseDataTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(registeredCourseDataTable);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 848, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Select Your Student Id");

        supdate_btn.setBorder(null);
        supdate_btn.setText("Select");
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

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Student Name");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Select Course Id");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("Course Name");

        studentSearch_btn1.setBorder(null);
        studentSearch_btn1.setText("Search");
        studentSearch_btn1.setBorderColor(new java.awt.Color(0, 0, 0));
        studentSearch_btn1.setBorderPainted(false);
        studentSearch_btn1.setColor(new java.awt.Color(255, 106, 106));
        studentSearch_btn1.setColorClick(new java.awt.Color(255, 31, 31));
        studentSearch_btn1.setColorOver(new java.awt.Color(255, 31, 31));
        studentSearch_btn1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        studentSearch_btn1.setRadius(15);
        studentSearch_btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentSearch_btn1ActionPerformed(evt);
            }
        });

        courseSearch_btn.setBorder(null);
        courseSearch_btn.setText("Search");
        courseSearch_btn.setBorderColor(new java.awt.Color(0, 0, 0));
        courseSearch_btn.setBorderPainted(false);
        courseSearch_btn.setColor(new java.awt.Color(255, 106, 106));
        courseSearch_btn.setColorClick(new java.awt.Color(255, 31, 31));
        courseSearch_btn.setColorOver(new java.awt.Color(255, 31, 31));
        courseSearch_btn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        courseSearch_btn.setRadius(15);
        courseSearch_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                courseSearch_btnActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel13.setText("Payment Status");

        spaymentStatus_cmb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pending", "Paid" }));
        spaymentStatus_cmb.setEnabled(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE))
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(spaymentStatus_cmb, 0, 84, Short.MAX_VALUE)
                            .addComponent(sstudentId_cmb, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(scourseId_cmb, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(paymentStatus_txt)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(scourseName_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sstudentName_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(courseSearch_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(studentSearch_btn1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(supdate_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(96, 96, 96))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(scourseId_cmb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(scourseName_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(courseSearch_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(sstudentId_cmb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(supdate_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(sstudentName_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(studentSearch_btn1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(spaymentStatus_cmb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(paymentStatus_txt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(3, 3, 3)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("tab2", jPanel3);

        sStudentMarksViewTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Student Id", "Student Name", "Course Id", "Course Name", "Marks"
            }
        ));
        jScrollPane3.setViewportView(sStudentMarksViewTable);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Exam Marks");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Student Id");

        studentSearch_btn.setBorder(null);
        studentSearch_btn.setText("Search");
        studentSearch_btn.setBorderColor(new java.awt.Color(0, 0, 0));
        studentSearch_btn.setBorderPainted(false);
        studentSearch_btn.setColor(new java.awt.Color(16, 162, 252));
        studentSearch_btn.setColorClick(new java.awt.Color(19, 102, 217));
        studentSearch_btn.setColorOver(new java.awt.Color(60, 141, 255));
        studentSearch_btn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        studentSearch_btn.setRadius(15);
        studentSearch_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentSearch_btnActionPerformed(evt);
            }
        });

        studentReset_btn.setBorder(null);
        studentReset_btn.setText("RESET Table");
        studentReset_btn.setBorderColor(new java.awt.Color(0, 0, 0));
        studentReset_btn.setBorderPainted(false);
        studentReset_btn.setColor(new java.awt.Color(255, 106, 106));
        studentReset_btn.setColorClick(new java.awt.Color(255, 31, 31));
        studentReset_btn.setColorOver(new java.awt.Color(255, 31, 31));
        studentReset_btn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        studentReset_btn.setRadius(15);
        studentReset_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentReset_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 848, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(studentSearchId_cmb, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(studentSearch_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(studentReset_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47))))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(studentSearch_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(studentReset_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(studentSearchId_cmb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 621, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("tab3", jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void supdate_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supdate_btnActionPerformed
          try {
    connection = Database.connectiondb();

    // SQL query to check for duplicate entries
    pst = connection.prepareStatement("SELECT COUNT(*) FROM coursereg WHERE courseId = ? AND studentId = ?");
    pst.setString(1, scourseId_cmb.getSelectedItem().toString());
    pst.setString(2, sstudentId_cmb.getSelectedItem().toString());
    rs = pst.executeQuery();

    if (rs.next() && rs.getInt(1) > 0) {
        // If a duplicate entry exists, show a message
        JOptionPane.showMessageDialog(null, "This registration already exists!", "Duplicate Entry", JOptionPane.WARNING_MESSAGE);
    } else {
        // SQL query to insert the new registration with additional fields
        pst = connection.prepareStatement("INSERT INTO coursereg (courseId, coursename, studentId, studentname, paymentstatus) VALUES (?, ?, ?, ?, ?)");

        // Retrieve selected course and student details
        String selectedCourseId = scourseId_cmb.getSelectedItem().toString();
        String selectedStudentId = sstudentId_cmb.getSelectedItem().toString();
        String courseName = scourseName_txt.getText(); // Assuming scourseName_txt contains the course name
        String studentName = sstudentName_txt.getText(); // Assuming sstudentName_txt contains the student name
        String paymentStatus = "Pending";

        // Set parameters for the query
        pst.setString(1, selectedCourseId);
        pst.setString(2, courseName);
        pst.setString(3, selectedStudentId);
        pst.setString(4, studentName);
        pst.setString(5, paymentStatus);

        // Execute the query
        int rowsInserted = pst.executeUpdate();
        if (rowsInserted > 0) {
            JOptionPane.showMessageDialog(null, "Successfully Registered!");
            FetchRegisteredCourseData();

            // Set the payment status label to "Pending"
            paymentStatus_txt.setText(paymentStatus);
        }
    }
} catch (Exception ex) {
    ex.printStackTrace();
    JOptionPane.showMessageDialog(null, "Error during registration: " + ex.getMessage());
} finally {
    try {
        if (rs != null) rs.close();
        if (pst != null) pst.close();
        if (connection != null) connection.close();
    } catch (Exception ex) {
        ex.printStackTrace();
    }
}

    }//GEN-LAST:event_supdate_btnActionPerformed

    private void studentSearch_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentSearch_btnActionPerformed
        String studentId = studentSearchId_cmb.getSelectedItem().toString();
    
    if (studentId.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Please enter a student ID.");
        return;
    }
    
    DefaultTableModel tableModel = (DefaultTableModel) sStudentMarksViewTable.getModel(); 
    tableModel.setRowCount(0); 
    
    try {
        connection = Database.connectiondb();
        pst = connection.prepareStatement("SELECT * FROM marks WHERE studentId = ?");
        pst.setString(1, studentId);
        rs = pst.executeQuery();
        
        while (rs.next()) {
            String courseId = rs.getString("courseId");
            String courseName=rs.getString("courseName");
            String studentName=rs.getString("studentname");
            int marks = rs.getInt("marks");
            tableModel.addRow(new Object[]{studentId, studentName, courseId, courseName, marks}); 
        }
        
        if (tableModel.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "No records found for the provided student ID.");
        }
    } catch (Exception ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error retrieving data: " + ex.getMessage());
    } finally {
        try {
            if (rs != null) rs.close();
            if (pst != null) pst.close();
            if (connection != null) connection.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    }//GEN-LAST:event_studentSearch_btnActionPerformed

    private void studentReset_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentReset_btnActionPerformed
        try {
        FetchMarksData();
        JOptionPane.showMessageDialog(null, "Table reset to default state.");
    } catch (Exception ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error resetting table: " + ex.getMessage());
    }

    }//GEN-LAST:event_studentReset_btnActionPerformed

    private void overview_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_overview_btnActionPerformed
        jTabbedPane1.setSelectedIndex(0);
    }//GEN-LAST:event_overview_btnActionPerformed

    private void teacher_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_teacher_btnActionPerformed
        jTabbedPane1.setSelectedIndex(1);
    }//GEN-LAST:event_teacher_btnActionPerformed

    private void student_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_student_btnActionPerformed
        jTabbedPane1.setSelectedIndex(2);
    }//GEN-LAST:event_student_btnActionPerformed

    private void ssignout_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ssignout_btnActionPerformed
        this.hide();
        StudentLoginForm frame=new StudentLoginForm();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }//GEN-LAST:event_ssignout_btnActionPerformed

    private void studentSearch_btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentSearch_btn1ActionPerformed
        try {

            String selectedStudentId = sstudentId_cmb.getSelectedItem().toString();

            connection = Database.connectiondb();

            pst = connection.prepareStatement("SELECT fname, lname FROM student WHERE id = ?");
            pst.setString(1, selectedStudentId);

            rs = pst.executeQuery();

            if (rs.next()) {

                String firstName = rs.getString("fName");
                String lastName = rs.getString("lName");

                String fullName = firstName + " " + lastName;

                sstudentName_txt.setText(fullName);
            } else {

                sstudentName_txt.setText("");
                JOptionPane.showMessageDialog(null, "No student found with the selected ID.", "No Data", JOptionPane.WARNING_MESSAGE);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error fetching student data: " + ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (rs != null) rs.close();
                if (pst != null) pst.close();
                if (connection != null) connection.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_studentSearch_btn1ActionPerformed

    private void courseSearch_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_courseSearch_btnActionPerformed
        try {

            String selectedCourseId = scourseId_cmb.getSelectedItem().toString();

            connection = Database.connectiondb();

            pst = connection.prepareStatement("SELECT name FROM course WHERE id = ?");
            pst.setString(1, selectedCourseId);

            rs = pst.executeQuery();

            if (rs.next()) {

                String courseName = rs.getString("name");

                scourseName_txt.setText(courseName);
            } else {

                scourseName_txt.setText("");
                JOptionPane.showMessageDialog(null, "No course found with the selected ID.", "No Data", JOptionPane.WARNING_MESSAGE);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error fetching course data: " + ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (rs != null) rs.close();
                if (pst != null) pst.close();
                if (connection != null) connection.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_courseSearch_btnActionPerformed

    private void registeredCourseDataTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registeredCourseDataTableMouseClicked
       try {
        
        int selectedRow = registeredCourseDataTable.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) registeredCourseDataTable.getModel();

        
        String courseId = model.getValueAt(selectedRow, 0).toString().trim(); 
        String srcourseName = model.getValueAt(selectedRow, 1).toString(); 
        String srstudentId = model.getValueAt(selectedRow, 2).toString().trim(); 
        String studentName = model.getValueAt(selectedRow, 3).toString().trim(); 
        String paymentStatus=model.getValueAt(selectedRow, 4).toString();
         

        
        scourseId_cmb.setSelectedItem(courseId);
        scourseName_txt.setText(srcourseName);
        sstudentId_cmb.setSelectedItem(srstudentId);
        sstudentName_txt.setText(studentName);
        spaymentStatus_cmb.setSelectedItem(paymentStatus); 
        
        
    } catch (Exception ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error retrieving data from table: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_registeredCourseDataTableMouseClicked

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
            java.util.logging.Logger.getLogger(StudentDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StudentDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StudentDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StudentDashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.mycompany.learningmanagementsystem.Button courseSearch_btn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
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
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel label5;
    private javax.swing.JLabel label8;
    private com.mycompany.learningmanagementsystem.Button overview_btn;
    private javax.swing.JLabel paymentStatus_txt;
    private javax.swing.JTable recentlyUpdatedCoursesTable;
    private javax.swing.JTable registeredCourseDataTable;
    private javax.swing.JTable sStudentMarksViewTable;
    private javax.swing.JComboBox<String> scourseId_cmb;
    private javax.swing.JTextField scourseName_txt;
    private javax.swing.JComboBox<String> spaymentStatus_cmb;
    private com.mycompany.learningmanagementsystem.Button ssignout_btn;
    private javax.swing.JComboBox<String> sstudentId_cmb;
    private javax.swing.JTextField sstudentName_txt;
    private com.mycompany.learningmanagementsystem.Button studentReset_btn;
    private javax.swing.JComboBox<String> studentSearchId_cmb;
    private com.mycompany.learningmanagementsystem.Button studentSearch_btn;
    private com.mycompany.learningmanagementsystem.Button studentSearch_btn1;
    private com.mycompany.learningmanagementsystem.Button student_btn;
    private com.mycompany.learningmanagementsystem.Button supdate_btn;
    private com.mycompany.learningmanagementsystem.Button teacher_btn;
    private javax.swing.JLabel totalCourses_txt;
    private javax.swing.JLabel totalStudent_txt;
    private javax.swing.JLabel totalTeachers_txt;
    // End of variables declaration//GEN-END:variables
}
