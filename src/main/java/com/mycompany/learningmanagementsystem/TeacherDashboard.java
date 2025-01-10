/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.learningmanagementsystem;

import com.formdev.flatlaf.FlatClientProperties;
import java.awt.Image;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
/**
 *
 * @author User
 */
public class TeacherDashboard extends javax.swing.JFrame {

    /**
     * Creates new form TeacherDashboard
     */
    public TeacherDashboard() {
        initComponents();
        FetchCourseData();
        populateStudentComboBox();
        populateCourseComboBox();
        FetchMarksData();
        DisplayTotalCount();
        FetchRecentlyUpdatedCourses();
        CourseTableDesign();
        PanelBoxDesign();
        AssignedCoursesTableDesign();
        MarksUploadTableDesign();
        ScaleImage();
    }
    
    Connection connection;
    PreparedStatement pst;
    ResultSet rs;
    
    
    private void ScaleImage(){
        ImageIcon icon=new ImageIcon("D:\\nibm project\\LearningManagementSystem\\src\\main\\java\\com\\mycompany\\learningmanagementsystem\\Images\\file-3.png");
        Image img=icon.getImage();
        Image imgScale=img.getScaledInstance(label5.getWidth(), label5.getHeight(), Image.SCALE_AREA_AVERAGING);
        ImageIcon scaledIcon=new ImageIcon(imgScale);
        label5.setIcon(scaledIcon);
        
        ImageIcon icon2=new ImageIcon("D:\\nibm project\\LearningManagementSystem\\src\\main\\java\\com\\mycompany\\learningmanagementsystem\\Images\\signout.png");
        Image img2=icon2.getImage();
        Image imgScale2=img2.getScaledInstance(label8.getWidth(), label8.getHeight(), Image.SCALE_AREA_AVERAGING);
        ImageIcon scaledIcon2=new ImageIcon(imgScale2);
        label8.setIcon(scaledIcon2);
        
        ImageIcon icon3=new ImageIcon("D:\\nibm project\\LearningManagementSystem\\src\\main\\java\\com\\mycompany\\learningmanagementsystem\\Images\\Education-rafiki.png");
        Image img3=icon3.getImage();
        Image imgScale3=img3.getScaledInstance(jLabel1.getWidth(), jLabel1.getHeight(), Image.SCALE_AREA_AVERAGING);
        ImageIcon scaledIcon3=new ImageIcon(imgScale3);
        jLabel1.setIcon(scaledIcon3);
        
    }
    
    private void PanelBoxDesign(){
        jPanel1.putClientProperty(FlatClientProperties.STYLE, "" +
            "arc: 20;");
        jPanel7.putClientProperty(FlatClientProperties.STYLE, "" +
            "arc: 20;");
        jPanel11.putClientProperty(FlatClientProperties.STYLE, "" +
            "arc: 20;");
        jPanel12.putClientProperty(FlatClientProperties.STYLE, "" +
            "arc: 20;");
        jPanel8.putClientProperty(FlatClientProperties.STYLE, "" +
            "arc: 20;" +                  
            "borderColor: #1366D9;" +      
            "borderWidth: 2;");            
    }
    
    private void CourseTableDesign(){
        jPanel13.putClientProperty(FlatClientProperties.STYLE, "" +
            "arc: 20;" +
            "background: $Table.background");

    
         TeacherDashboardTable.getTableHeader().putClientProperty(FlatClientProperties.STYLE, "" +
            "height: 30;" +
            "separatorColor: $Table.gridColor;" +
            "font: bold $Table.font");

    
         TeacherDashboardTable.putClientProperty(FlatClientProperties.STYLE, "" +
            "rowHeight: 30;" +
            "showHorizontalLines: true;" +
            "showVerticalLines: true;" +
            "intercellSpacing: 0,1;" +
            "selectionBackground: lighten(@Table.background,8%);" +
            "selectionInactiveBackground: lighten(@Table.background,8%)");

    
         jScrollPane1.setBorder(BorderFactory.createEmptyBorder());
         
         DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

        for (int i = 0; i < TeacherDashboardTable.getColumnCount(); i++) {
        TeacherDashboardTable.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);}
    }
    
    private void AssignedCoursesTableDesign(){
        jPanel5.putClientProperty(FlatClientProperties.STYLE, "" +
            "arc: 20;" +
            "background: $Table.background");

    
         assignedCoursesTable.getTableHeader().putClientProperty(FlatClientProperties.STYLE, "" +
            "height: 30;" +
            "separatorColor: $Table.gridColor;" +
            "font: bold $Table.font");

    
         assignedCoursesTable.putClientProperty(FlatClientProperties.STYLE, "" +
            "rowHeight: 30;" +
            "showHorizontalLines: true;" +
            "showVerticalLines: true;" +
            "intercellSpacing: 0,1;" +
            "selectionBackground: lighten(@Table.background,8%);" +
            "selectionInactiveBackground: lighten(@Table.background,8%)");

    
         jScrollPane2.setBorder(BorderFactory.createEmptyBorder());
         
         DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

        for (int i = 0; i < assignedCoursesTable.getColumnCount(); i++) {
        assignedCoursesTable.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);}
    }
    
    private void MarksUploadTableDesign(){
        jPanel14.putClientProperty(FlatClientProperties.STYLE, "" +
            "arc: 20;" +
            "background: $Table.background");

    
         studentMarksTable.getTableHeader().putClientProperty(FlatClientProperties.STYLE, "" +
            "height: 30;" +
            "separatorColor: $Table.gridColor;" +
            "font: bold $Table.font");

    
         studentMarksTable.putClientProperty(FlatClientProperties.STYLE, "" +
            "rowHeight: 30;" +
            "showHorizontalLines: true;" +
            "showVerticalLines: true;" +
            "intercellSpacing: 0,1;" +
            "selectionBackground: lighten(@Table.background,8%);" +
            "selectionInactiveBackground: lighten(@Table.background,8%)");

    
         jScrollPane3.setBorder(BorderFactory.createEmptyBorder());
         
         DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

        for (int i = 0; i < studentMarksTable.getColumnCount(); i++) {
        studentMarksTable.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);}
    }
    
    public void FetchRecentlyUpdatedCourses(){
         try {
        
        connection = Database.connectiondb();

        
        String sql = "SELECT id, name, fees, months FROM course WHERE date >= DATE_SUB(CURDATE(), INTERVAL 2 MONTH)";
        pst = connection.prepareStatement(sql);
        rs = pst.executeQuery();

       
        DefaultTableModel model = (DefaultTableModel) TeacherDashboardTable.getModel();
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
        
        DefaultTableModel df=(DefaultTableModel)studentMarksTable.getModel();
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
           String query = "SELECT c.courseId, c.coursename, c.studentId, CONCAT(s.fName, ' ', s.lName) AS studentName, COALESCE(m.marks, NULL) AS marks, c.paymentstatus " +
               "FROM coursereg c " +
               "JOIN student s ON c.studentId = s.Id " +
               "LEFT JOIN marks m ON c.courseId = m.courseId AND c.studentId = m.studentId " +
               "WHERE c.paymentstatus = 'Paid'";




           pst = connection.prepareStatement(query);
           rs = pst.executeQuery();
            
            while(rs.next()){
                String studentId=rs.getString("studentId");
                String studentName=rs.getString("studentname");
                String courseId=rs.getString("courseId");
                String courseName=rs.getString("courseName");
                int marks=rs.getInt("marks");
                
                
                
                mark.add(new MarksData(studentId,studentName,courseId,courseName,marks));
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return mark;
    }
    
    private void populateStudentComboBox() {
    try {
        connection = Database.connectiondb();
        pst = connection.prepareStatement("SELECT id FROM student");
        rs = pst.executeQuery();
        
        while (rs.next()) {
            String studentId = rs.getString("id");
            studentId_cmb.addItem(studentId); 
            
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
            courseId_cmb.addItem(courseId); 
            courseId_cmb1.addItem(courseId);
            
        }
    } catch (Exception ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error loading teacher data: " + ex.getMessage());
    }
}
    
    private void FetchCourseData(){
        List<CourseData>course=getCourseData();
        
        DefaultTableModel df=(DefaultTableModel)assignedCoursesTable.getModel();
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        tsignout_btn = new com.mycompany.learningmanagementsystem.Button();
        overview_btn = new com.mycompany.learningmanagementsystem.Button();
        overview_btn1 = new com.mycompany.learningmanagementsystem.Button();
        overview_btn2 = new com.mycompany.learningmanagementsystem.Button();
        jPanel22 = new javax.swing.JPanel();
        label5 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        label8 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        totalTeachers_txt = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        totalStudent_txt = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        totalCourses_txt = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TeacherDashboardTable = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        assignedCoursesTable = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        studentMarksTable = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        studentId_cmb = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        marks_txt = new javax.swing.JTextField();
        courseId_cmb = new javax.swing.JComboBox<>();
        add_btn = new com.mycompany.learningmanagementsystem.Button();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        studentName_txt = new javax.swing.JTextField();
        courseName_txt = new javax.swing.JTextField();
        marksReport_btn = new com.mycompany.learningmanagementsystem.Button();
        jLabel14 = new javax.swing.JLabel();
        courseId_cmb1 = new javax.swing.JComboBox<>();
        courseSearch_btn1 = new com.mycompany.learningmanagementsystem.Button();
        marksReset_btn = new com.mycompany.learningmanagementsystem.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        tsignout_btn.setBorder(null);
        tsignout_btn.setText("Sign Out");
        tsignout_btn.setBorderColor(new java.awt.Color(0, 0, 0));
        tsignout_btn.setBorderPainted(false);
        tsignout_btn.setColor(new java.awt.Color(255, 106, 106));
        tsignout_btn.setColorClick(new java.awt.Color(255, 31, 31));
        tsignout_btn.setColorOver(new java.awt.Color(255, 31, 31));
        tsignout_btn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tsignout_btn.setRadius(15);
        tsignout_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tsignout_btnActionPerformed(evt);
            }
        });

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

        overview_btn1.setBorder(null);
        overview_btn1.setText("Courses");
        overview_btn1.setBorderColor(new java.awt.Color(0, 0, 0));
        overview_btn1.setBorderPainted(false);
        overview_btn1.setColor(new java.awt.Color(19, 102, 217));
        overview_btn1.setColorClick(new java.awt.Color(16, 162, 252));
        overview_btn1.setColorOver(new java.awt.Color(60, 141, 255));
        overview_btn1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        overview_btn1.setRadius(15);
        overview_btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                overview_btn1ActionPerformed(evt);
            }
        });

        overview_btn2.setBorder(null);
        overview_btn2.setText("Marks");
        overview_btn2.setBorderColor(new java.awt.Color(0, 0, 0));
        overview_btn2.setBorderPainted(false);
        overview_btn2.setColor(new java.awt.Color(19, 102, 217));
        overview_btn2.setColorClick(new java.awt.Color(16, 162, 252));
        overview_btn2.setColorOver(new java.awt.Color(60, 141, 255));
        overview_btn2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        overview_btn2.setRadius(15);
        overview_btn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                overview_btn2ActionPerformed(evt);
            }
        });

        jPanel22.setBackground(new java.awt.Color(255, 255, 255));

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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(label5, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("<html><center>LEARNING MANAGEMENT SYSTEM</center></html>");

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label8, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(7, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(label8, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(overview_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(overview_btn1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(overview_btn2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tsignout_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(overview_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(overview_btn1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(overview_btn2, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(tsignout_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38))))
        );

        jTabbedPane1.setEnabled(false);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        jPanel8.setBackground(new java.awt.Color(96, 162, 252));
        jPanel8.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 0, true));
        jPanel8.setPreferredSize(new java.awt.Dimension(102, 107));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("<html>Total Number Of  Teachers Available</html> ");

        totalTeachers_txt.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        totalTeachers_txt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        totalTeachers_txt.setText("0");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(totalTeachers_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                    .addComponent(totalTeachers_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel11.setBackground(new java.awt.Color(96, 162, 252));
        jPanel11.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 0, true));
        jPanel11.setPreferredSize(new java.awt.Dimension(102, 107));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("<html>Total Number Of Students   Entrolled</html> ");

        totalStudent_txt.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        totalStudent_txt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        totalStudent_txt.setText("0");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(totalStudent_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                    .addComponent(totalStudent_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel12.setBackground(new java.awt.Color(96, 162, 252));
        jPanel12.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 0, true));
        jPanel12.setPreferredSize(new java.awt.Dimension(102, 107));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("<html>Total Number Of Courses Available</html>");

        totalCourses_txt.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        totalCourses_txt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        totalCourses_txt.setText("0");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(totalCourses_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 139, Short.MAX_VALUE)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(130, 130, 130)
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

        TeacherDashboardTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(TeacherDashboardTable);

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 451, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        jTabbedPane1.addTab("", jPanel2);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setText("Assigned Courses");

        assignedCoursesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Id", "Name", "Months", "Fees", "Teacher Id"
            }
        ));
        jScrollPane2.setViewportView(assignedCoursesTable);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 853, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel1.setText("jLabel1");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE)
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
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("", jPanel3);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Marks Upload");

        studentMarksTable.setModel(new javax.swing.table.DefaultTableModel(
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
        studentMarksTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                studentMarksTableMouseClicked(evt);
            }
        });
        studentMarksTable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                studentMarksTableKeyPressed(evt);
            }
        });
        jScrollPane3.setViewportView(studentMarksTable);

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 859, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("Marks");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Student Id");

        studentId_cmb.setEnabled(false);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Course Name");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("Marks");

        marks_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                marks_txtActionPerformed(evt);
            }
        });

        courseId_cmb.setEnabled(false);

        add_btn.setBorder(null);
        add_btn.setText("UPDATE");
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

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setText("Student Name");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel13.setText("Course Id");

        studentName_txt.setEnabled(false);

        courseName_txt.setEnabled(false);

        marksReport_btn.setBorder(null);
        marksReport_btn.setText("View Marks Report");
        marksReport_btn.setBorderColor(new java.awt.Color(0, 0, 0));
        marksReport_btn.setBorderPainted(false);
        marksReport_btn.setColor(new java.awt.Color(126, 255, 131));
        marksReport_btn.setColorClick(new java.awt.Color(47, 255, 55));
        marksReport_btn.setColorOver(new java.awt.Color(102, 255, 108));
        marksReport_btn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        marksReport_btn.setRadius(15);
        marksReport_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                marksReport_btnActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setText("Select Your Course Id");

        courseSearch_btn1.setBorder(null);
        courseSearch_btn1.setText("Search");
        courseSearch_btn1.setBorderColor(new java.awt.Color(0, 0, 0));
        courseSearch_btn1.setBorderPainted(false);
        courseSearch_btn1.setColor(new java.awt.Color(255, 106, 106));
        courseSearch_btn1.setColorClick(new java.awt.Color(255, 31, 31));
        courseSearch_btn1.setColorOver(new java.awt.Color(255, 31, 31));
        courseSearch_btn1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        courseSearch_btn1.setRadius(15);
        courseSearch_btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                courseSearch_btn1ActionPerformed(evt);
            }
        });

        marksReset_btn.setBorder(null);
        marksReset_btn.setText("RESET Table");
        marksReset_btn.setBorderColor(new java.awt.Color(0, 0, 0));
        marksReset_btn.setBorderPainted(false);
        marksReset_btn.setColor(new java.awt.Color(255, 106, 106));
        marksReset_btn.setColorClick(new java.awt.Color(255, 31, 31));
        marksReset_btn.setColorOver(new java.awt.Color(255, 31, 31));
        marksReset_btn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        marksReset_btn.setRadius(15);
        marksReset_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                marksReset_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(62, 62, 62)
                        .addComponent(jLabel14)
                        .addGap(18, 18, 18)
                        .addComponent(courseId_cmb1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(courseSearch_btn1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(marksReset_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(marks_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(courseName_txt))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(studentName_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(courseId_cmb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(115, 115, 115)
                                .addComponent(add_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(130, 130, 130)
                        .addComponent(marksReport_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(studentId_cmb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel14)
                    .addComponent(courseId_cmb1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(courseSearch_btn1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(marksReset_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(studentId_cmb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(studentName_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(courseId_cmb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(courseName_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(marks_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(add_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(marksReport_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );

        jTabbedPane1.addTab("", jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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

    private void marks_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_marks_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_marks_txtActionPerformed

    private void add_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_btnActionPerformed
        try {
            connection = Database.connectiondb();
            pst = connection.prepareStatement("INSERT INTO marks (studentId, studentname, courseId, coursename, marks) VALUES (?, ?, ?, ?, ?)");

            pst.setString(1, studentId_cmb.getSelectedItem().toString());
            pst.setString(2,studentName_txt.getText());
            pst.setString(3, courseId_cmb.getSelectedItem().toString());
            pst.setString(4,courseName_txt.getText());
            pst.setString(5, marks_txt.getText());

            int rowsInserted = pst.executeUpdate();
            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(null, "Marks Updated successfully!");
                FetchMarksData();
                

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

    private void tsignout_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tsignout_btnActionPerformed
        int response = JOptionPane.showConfirmDialog(this, "Are you sure you want to sign out?", "Confirm Sign Out", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (response == JOptionPane.YES_OPTION) {
            this.dispose(); 
            TeacherLoginForm frame = new TeacherLoginForm();
            frame.setVisible(true);
            frame.setLocationRelativeTo(null);
}

    }//GEN-LAST:event_tsignout_btnActionPerformed

    private void overview_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_overview_btnActionPerformed
        jTabbedPane1.setSelectedIndex(0);
    }//GEN-LAST:event_overview_btnActionPerformed

    private void overview_btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_overview_btn1ActionPerformed
        jTabbedPane1.setSelectedIndex(1);
    }//GEN-LAST:event_overview_btn1ActionPerformed

    private void overview_btn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_overview_btn2ActionPerformed
         jTabbedPane1.setSelectedIndex(2);
    }//GEN-LAST:event_overview_btn2ActionPerformed

    private void studentMarksTableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_studentMarksTableKeyPressed
          
    }//GEN-LAST:event_studentMarksTableKeyPressed

    private void studentMarksTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_studentMarksTableMouseClicked
        try {
        int selectedRow = studentMarksTable.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) studentMarksTable.getModel();

        
        String studentId = model.getValueAt(selectedRow, 0).toString(); 
        String studentName = model.getValueAt(selectedRow, 1).toString(); 
        String courseId = model.getValueAt(selectedRow, 2).toString(); 
        String courseName = model.getValueAt(selectedRow, 3).toString(); 
        String marks = model.getValueAt(selectedRow, 4).toString(); 

        studentId_cmb.setSelectedItem(studentId); 
        studentName_txt.setText(studentName);   
        courseId_cmb.setSelectedItem(courseId);
        courseName_txt.setText(courseName);             
        marks_txt.setText(marks);                 

    } catch (Exception ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error retrieving data from table: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_studentMarksTableMouseClicked

    private void marksReport_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_marksReport_btnActionPerformed
        try{
            connection=Database.connectiondb();
            JasperReport jr=JasperCompileManager.compileReport("D:\\nibm project\\LearningManagementSystem\\src\\main\\java\\com\\mycompany\\learningmanagementsystem\\Reports\\Marks.jrxml");
            JasperPrint jp=JasperFillManager.fillReport(jr,null,connection);
            JasperViewer viewer = new JasperViewer(jp, false);
            viewer.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
            viewer.setVisible(true);

        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }//GEN-LAST:event_marksReport_btnActionPerformed

    private void courseSearch_btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_courseSearch_btn1ActionPerformed
         String courseId = courseId_cmb1.getSelectedItem().toString();
    
    // Check if the course ID is empty
    if (courseId.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Please select a course ID.");
        return;
    }
    
    // Prepare the table model and clear existing data
    DefaultTableModel tableModel = (DefaultTableModel) studentMarksTable.getModel(); 
    tableModel.setRowCount(0); 
    
    // Fetch data from the database
    try {
        // Establish database connection
        connection = Database.connectiondb();
        
        // Prepare SQL query
        pst = connection.prepareStatement("SELECT studentId, studentname, courseId, courseName, marks FROM marks WHERE courseId = ?");
        pst.setString(1, courseId);
        
        // Execute query
        rs = pst.executeQuery();
        
        // Populate the table with data
        while (rs.next()) {
            String studentId = rs.getString("studentId");
            String studentName = rs.getString("studentname");
            String fetchedCourseId = rs.getString("courseId");
            String courseName = rs.getString("courseName");
            int marks = rs.getInt("marks");
            
            // Add row to the table
            tableModel.addRow(new Object[]{studentId, studentName, fetchedCourseId, courseName, marks});
        }
        
        // Check if no records were found
        if (tableModel.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "No records found for the selected course ID.", "No Data", JOptionPane.WARNING_MESSAGE);
        }
    } catch (Exception ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error retrieving data: " + ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
    } finally {
        // Clean up resources
        try {
            if (rs != null) rs.close();
            if (pst != null) pst.close();
            if (connection != null) connection.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    }//GEN-LAST:event_courseSearch_btn1ActionPerformed

    private void marksReset_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_marksReset_btnActionPerformed
        try {
            FetchMarksData();
            JOptionPane.showMessageDialog(null, "Table reset to default state.");
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error resetting table: " + ex.getMessage());
        }
    }//GEN-LAST:event_marksReset_btnActionPerformed

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
            java.util.logging.Logger.getLogger(TeacherDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TeacherDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TeacherDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TeacherDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TeacherDashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TeacherDashboardTable;
    private com.mycompany.learningmanagementsystem.Button add_btn;
    private javax.swing.JTable assignedCoursesTable;
    private javax.swing.JComboBox<String> courseId_cmb;
    private javax.swing.JComboBox<String> courseId_cmb1;
    private javax.swing.JTextField courseName_txt;
    private com.mycompany.learningmanagementsystem.Button courseSearch_btn1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
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
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel label5;
    private javax.swing.JLabel label8;
    private com.mycompany.learningmanagementsystem.Button marksReport_btn;
    private com.mycompany.learningmanagementsystem.Button marksReset_btn;
    private javax.swing.JTextField marks_txt;
    private com.mycompany.learningmanagementsystem.Button overview_btn;
    private com.mycompany.learningmanagementsystem.Button overview_btn1;
    private com.mycompany.learningmanagementsystem.Button overview_btn2;
    private javax.swing.JComboBox<String> studentId_cmb;
    private javax.swing.JTable studentMarksTable;
    private javax.swing.JTextField studentName_txt;
    private javax.swing.JLabel totalCourses_txt;
    private javax.swing.JLabel totalStudent_txt;
    private javax.swing.JLabel totalTeachers_txt;
    private com.mycompany.learningmanagementsystem.Button tsignout_btn;
    // End of variables declaration//GEN-END:variables
}
