/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reyavaya_Technologies_;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.BorderLayout;
import javax.swing.*;
import java.util.Vector;

/**
 *
 * @author Daniel Khoza
 */
public class Reyavaya_Tech5 extends javax.swing.JFrame {
    
    public Reyavaya_Tech6 reyavayatech6;

    /**
     * Creates new form Reyavaya_Tech5
     */
    public Reyavaya_Tech5() {
        initComponents();
        setIconImage();
    }
    
    private void setIconImage(){
    setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icons8-motherboard-100.png"))); 
    }
    
    Boolean booleanRecordExist = false;
    String strCus_id = null;
    String strCus_Name = null;
    String strCus_Address = null;
    String strCus_Contact = null;
    String strCus_Email = null;
    
    private void mGetValues()
    {
        strCus_id = txtf6.getText();
        strCus_Name = txtf7.getText();
        strCus_Address = txtf8.getText();
        strCus_Contact = txtf9.getText();
        strCus_Email = txtf10.getText();
    }
    
    private void mCheckIfItemsExistInTable()
    {        
            String strDBConnectionString = "jdbc:mysql://127.0.0.1:3306/Reyavaya_technologies";
            String strDBUser = "root";
            String strDBPassword = "Daniel_25042577_Khoza";
            java.sql.Connection conMySQLConnectionString;
            Statement stStatement = null;
            ResultSet rs = null;
    
        try
        {
            conMySQLConnectionString = DriverManager.getConnection(strDBConnectionString,strDBUser,strDBPassword);
            stStatement = conMySQLConnectionString.createStatement();
            String strQuery = "Select * From customers where Cus_id='" + txtf6 + "'and Cus_Name='" + txtf7 + "'and Cus_Address='" + txtf8 + "'and Cus_Contact='" + txtf9 + "'and Cus_Email='" + txtf10 +"'";
            stStatement.executeQuery(strQuery);
            rs = stStatement.getResultSet();
            booleanRecordExist = rs.next();
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
        finally
        {
            try
            {
                stStatement.close();
            }
            catch (Exception e)
            {
                JOptionPane.showMessageDialog(null,"Connection String not closed" + " " + e);
            }
        }
    }
    
    //Add to database
    private void  mInsertToCustomersTable()
    {
        java.sql.Connection conMySQLConnectionString = null;
        String URL = "jdbc:mysql://127.0.0.1:3306/Reyavaya_technologies";
        String User = "root";
        String Password = "Daniel_25042577_Khoza";
        try
        {
            conMySQLConnectionString = DriverManager.getConnection(URL,User,Password);
            Statement myStatement = conMySQLConnectionString.createStatement();
            String sqlinsert = "insert into customers" + "(Cus_id,Cus_Name,Cus_Address,Cus_Contact,Cus_Email)" + "Value('"+txtf6+"', '"+txtf7+"', '"+txtf8+"', '"+txtf9+"', '"+txtf10+"')";
            myStatement.executeUpdate(sqlinsert);
            myStatement.close();
            JOptionPane.showMessageDialog(null,"Added Successfully to the Server");
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    //Delete From database
    private void mDeleteFromTable()
    {        
            String strDBConnectionString = "jdbc:mysql://127.0.0.1:3306/Reyavaya_technologies";
            String strDBUser = "root";
            String strDBPassword = "Daniel_25042577_Khoza";
            java.sql.Connection conMySQLConnectionString;
            Statement stStatement = null;
            ResultSet rs = null;
    
        try
        {
            conMySQLConnectionString = DriverManager.getConnection(strDBConnectionString,strDBUser,strDBPassword);
            stStatement = conMySQLConnectionString.createStatement();
            String strQuery = "Delete * From customers where Cus_id='" + txtf6 + "'and Cus_Name='" + txtf7 + "'and Cus_Address='" + txtf8 + "'and Cus_Contact='" + txtf9 + "'and Cus_Email='" + txtf10 +"'";
            stStatement = conMySQLConnectionString.prepareStatement(strQuery);
            stStatement.execute(strQuery);
           
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
        finally
        {
            try
            {
                stStatement.close();
            }
            catch (Exception e)
            {
                JOptionPane.showMessageDialog(null,"Connection String not closed" + " " + e);
            }
        }
    }
    
    //Update from the database
    private void mUpdateToCustomerTable()
    {
        java.sql.Connection conMySQLConnectionString = null;
        String URL = "jdbc:mysql://127.0.0.1:3306/Reyavaya_technologies";
        String User = "root";
        String Password = "Daniel_25042577_Khoza";
        Statement stStatement = null;
        ResultSet rs = null;
        
        try
        {
            conMySQLConnectionString = DriverManager.getConnection(URL,User,Password);
            Statement myStatement = conMySQLConnectionString.createStatement();
            String sqlinsert = "Update customers SET Cus_id='"+txtf6+"', + Cus_Name='"+txtf7+"'Cus_Address='"+txtf8+"'Cus_Contact='"+txtf9+"'Cus_Email='"+txtf10+"'";
            myStatement.executeUpdate(sqlinsert);
            JOptionPane.showMessageDialog(null,"Updated Successfully to the Server");
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
        finally
        {
            try
            {
                stStatement.close();
            }
            catch (Exception e)
            {
                JOptionPane.showMessageDialog(null,"Connection String not closed" + " " + e);
            }
        }
    }
    
    //View from Database
    private void mViewFromDatabase()
    {
        Connection conMySQLConnectionString = null;
        Statement stSQLQuery = null;
        ResultSet rsCustomers = null;
        String strSQLQuery;
        
        try
        {
            conMySQLConnectionString = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Reyavaya_technologies", "root", "Daniel_25042577_Khoza");
            strSQLQuery = "Select * from customers";
            rsCustomers = stSQLQuery.executeQuery(strSQLQuery);
            ResultSetMetaData rsmt = rsCustomers.getMetaData();
            int intColumnCount = rsmt.getColumnCount();
            Vector vColumn = new Vector(intColumnCount);
            
            for(int i=1; i<intColumnCount; i++)
            {
                vColumn.add(rsmt.getColumnName(i));
            }
            
            Vector vData = new Vector();
            Vector vRow = new Vector();
            
            while(rsCustomers.next())
            {
                vRow = new Vector(intColumnCount);
                
                for(int i=1; 1<=intColumnCount; i++)
                {
                    vRow.add(rsCustomers.getString(i));
                }
                vData.add(vRow);
            }
            
            //creating form
            // Remember to add Libraries
            JFrame ViewData = new JFrame();
            ViewData.setSize(500,500);
            ViewData.setLocationRelativeTo(null);
            ViewData.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            JPanel pnlTable = new JPanel();
            JTable tblSupplier = new JTable(vData,vColumn);
            JScrollPane jspSupplirPane = new JScrollPane(tblSupplier);
            pnlTable.setLayout(new BorderLayout());
            pnlTable.add(jspSupplirPane, BorderLayout.CENTER);
            ViewData.setContentPane(pnlTable);
            ViewData.setVisible(true);
            
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null,"ERROR" + e);
        }
        finally
        {
            try
            {
                stSQLQuery.close();
                rsCustomers.close();
                conMySQLConnectionString.close();
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,"ERROR!!" + e);
            }
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
        jLabel3 = new javax.swing.JLabel();
        btnAdd2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblCustomers = new javax.swing.JTable();
        txtf6 = new javax.swing.JTextField();
        txtf7 = new javax.swing.JTextField();
        txtf8 = new javax.swing.JTextField();
        txtf9 = new javax.swing.JTextField();
        txtf10 = new javax.swing.JTextField();
        btnDELETE = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        btnUpdate = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("REYAVAYA TECHNOLOGIES");
        setMinimumSize(new java.awt.Dimension(1299, 611));
        setSize(new java.awt.Dimension(1299, 611));

        jPanel1.setLayout(null);

        jLabel3.setFont(new java.awt.Font("Arial Rounded MT Bold", 3, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("CUSTOMERS");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(580, 10, 130, 30);

        btnAdd2.setBackground(new java.awt.Color(255, 255, 255));
        btnAdd2.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 12)); // NOI18N
        btnAdd2.setForeground(new java.awt.Color(0, 0, 0));
        btnAdd2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-add-user-male-20.png"))); // NOI18N
        btnAdd2.setText("ADD");
        btnAdd2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAdd2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdd2ActionPerformed(evt);
            }
        });
        jPanel1.add(btnAdd2);
        btnAdd2.setBounds(370, 530, 115, 30);

        tblCustomers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cus_id", "Cus_name", "Cus_address", "Cus_contact", "Cus_email"
            }
        ));
        tblCustomers.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jScrollPane2.setViewportView(tblCustomers);

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(200, 40, 900, 360);

        txtf6.setForeground(new java.awt.Color(153, 153, 153));
        txtf6.setText("Cus_ID (Use Numbers Only)");
        txtf6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txtf6.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtf6FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtf6FocusLost(evt);
            }
        });
        jPanel1.add(txtf6);
        txtf6.setBounds(260, 420, 350, 28);

        txtf7.setForeground(new java.awt.Color(153, 153, 153));
        txtf7.setText("Cus_Name");
        txtf7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txtf7.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtf7FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtf7FocusLost(evt);
            }
        });
        jPanel1.add(txtf7);
        txtf7.setBounds(260, 450, 350, 28);

        txtf8.setForeground(new java.awt.Color(153, 153, 153));
        txtf8.setText("Cus_Address");
        txtf8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txtf8.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtf8FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtf8FocusLost(evt);
            }
        });
        jPanel1.add(txtf8);
        txtf8.setBounds(260, 480, 350, 28);

        txtf9.setForeground(new java.awt.Color(153, 153, 153));
        txtf9.setText("Cus_Contact (Use Numbers Only)");
        txtf9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txtf9.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtf9FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtf9FocusLost(evt);
            }
        });
        txtf9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtf9ActionPerformed(evt);
            }
        });
        jPanel1.add(txtf9);
        txtf9.setBounds(690, 420, 350, 28);

        txtf10.setForeground(new java.awt.Color(153, 153, 153));
        txtf10.setText("Cus_Email");
        txtf10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txtf10.setVerifyInputWhenFocusTarget(false);
        txtf10.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtf10FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtf10FocusLost(evt);
            }
        });
        jPanel1.add(txtf10);
        txtf10.setBounds(690, 450, 350, 28);

        btnDELETE.setBackground(new java.awt.Color(255, 255, 255));
        btnDELETE.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 12)); // NOI18N
        btnDELETE.setForeground(new java.awt.Color(0, 0, 0));
        btnDELETE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-delete-bin-20.png"))); // NOI18N
        btnDELETE.setText("DELETE");
        btnDELETE.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDELETE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDELETEActionPerformed(evt);
            }
        });
        jPanel1.add(btnDELETE);
        btnDELETE.setBounds(490, 530, 115, 30);

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 0, 0));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-database-view-20.png"))); // NOI18N
        jButton2.setText("VIEW");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(730, 530, 115, 30);

        btnBack.setBackground(new java.awt.Color(255, 255, 255));
        btnBack.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 12)); // NOI18N
        btnBack.setForeground(new java.awt.Color(0, 0, 0));
        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-back-arrow-20 (1).png"))); // NOI18N
        btnBack.setText("BACK");
        btnBack.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        jPanel1.add(btnBack);
        btnBack.setBounds(850, 530, 115, 30);
        jPanel1.add(jSeparator1);
        jSeparator1.setBounds(140, 410, 1010, 10);
        jPanel1.add(jSeparator2);
        jSeparator2.setBounds(140, 520, 1010, 10);

        btnUpdate.setBackground(new java.awt.Color(255, 255, 255));
        btnUpdate.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 12)); // NOI18N
        btnUpdate.setForeground(new java.awt.Color(0, 0, 0));
        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UpdateIcon_1.png"))); // NOI18N
        btnUpdate.setText("UPDATE");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        jPanel1.add(btnUpdate);
        btnUpdate.setBounds(610, 530, 115, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Background.png"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 1300, 610);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1299, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 611, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAdd2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdd2ActionPerformed
        if(txtf6.getText().equals("")||txtf7.getText().equals("")||txtf8.getText().equals("")||txtf9.getText().equals("")||txtf10.getText().equals(""))
        JOptionPane.showMessageDialog(this,"Please fill in Blank spaces !!" + "\nTo Add Customers", "CUSTOMER TABLE", JOptionPane.WARNING_MESSAGE);
        else{
            String data[] = {txtf6.getText(),txtf7.getText(),txtf8.getText(),txtf9.getText(),txtf10.getText()};

            DefaultTableModel tblModel = (DefaultTableModel)tblCustomers.getModel();
            tblModel.addRow(data);
            ImageIcon Icon = new javax.swing.ImageIcon(getClass().getResource("/icons8-add-user-male-65.png"));
            JOptionPane.showMessageDialog(this,"Customer Added succefully", "CUSTOMER TABLE", JOptionPane.PLAIN_MESSAGE, Icon);
            txtf6.setText("");
            txtf6.setText("Cus_ID");
            txtf6.setForeground(new Color(153,153,153));
            
            txtf7.setText("");
            txtf7.setText("Cus_Name");
            txtf7.setForeground(new Color(153,153,153));
            
            txtf8.setText("");
            txtf8.setText("Cus_Address");
            txtf8.setForeground(new Color(153,153,153));
            
            txtf9.setText("");
            txtf9.setText("Cus_Contact");
            txtf9.setForeground(new Color(153,153,153));
            
            txtf10.setText("");
            txtf10.setText("Cus_Email");
            txtf10.setForeground(new Color(153,153,153));
            
            mGetValues();
            mCheckIfItemsExistInTable();
            
            if(booleanRecordExist==true)
            {
                booleanRecordExist=false;
                JOptionPane.showMessageDialog(null,"Customer Info Already Exist");
            }
            else if(booleanRecordExist==false)
            {
                mInsertToCustomersTable();
            }
            
            
        }
        
        try 
        {
            
        }
        catch (Exception e)
        {
            
        }
    }//GEN-LAST:event_btnAdd2ActionPerformed

    private void txtf9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtf9ActionPerformed

    }//GEN-LAST:event_txtf9ActionPerformed

    private void btnDELETEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDELETEActionPerformed
        DefaultTableModel tblModel = (DefaultTableModel)tblCustomers.getModel();
        if(tblCustomers.getSelectedRowCount()==1){
            tblModel.removeRow(tblCustomers.getSelectedRow());
            mDeleteFromTable();
            JOptionPane.showMessageDialog(null,"Deleted", "CUSTOMER TABLE", JOptionPane.WARNING_MESSAGE);
        }else{
            if(tblCustomers.getRowCount()==0){
                JOptionPane.showMessageDialog(this,"Nothing to Delete From Customers Table", "CUSTOMER TABLE", JOptionPane.ERROR_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(this,"Select Row to Delete From Customes Table", "CUSTOMER TABLE", JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnDELETEActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        this.toBack();
        setVisible(false);
        new Reyavaya_Tech().toFront();
        new Reyavaya_Tech().setState(java.awt.Frame.NORMAL);
    }//GEN-LAST:event_btnBackActionPerformed

    private void txtf6FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtf6FocusGained
        if(txtf6.getText().equals("Cus_ID (Use Numbers Only)"))
        {
            txtf6.setText("");
            txtf6.setForeground(new Color(51,51,51));
        }
    }//GEN-LAST:event_txtf6FocusGained

    private void txtf6FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtf6FocusLost
        if(txtf6.getText().equals(""))
        {
            txtf6.setText("Cus_ID (Use Numbers Only)");
            txtf6.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_txtf6FocusLost

    private void txtf7FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtf7FocusGained
        if(txtf7.getText().equals("Cus_Name"))
        {
            txtf7.setText("");
            txtf7.setForeground(new Color(51,51,51));
        }
    }//GEN-LAST:event_txtf7FocusGained

    private void txtf7FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtf7FocusLost
        if(txtf7.getText().equals(""))
        {
            txtf7.setText("Cus_Name");
            txtf7.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_txtf7FocusLost

    private void txtf8FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtf8FocusGained
        if(txtf8.getText().equals("Cus_Address"))
        {
            txtf8.setText("");
            txtf8.setForeground(new Color(51,51,51));
        }
    }//GEN-LAST:event_txtf8FocusGained

    private void txtf8FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtf8FocusLost
         if(txtf8.getText().equals(""))
        {
            txtf8.setText("Cus_Address");
            txtf8.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_txtf8FocusLost

    private void txtf9FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtf9FocusGained
        if(txtf9.getText().equals("Cus_Contact (Use Numbers Only)"))
        {
            txtf9.setText("");
            txtf9.setForeground(new Color(51,51,51));
        }
    }//GEN-LAST:event_txtf9FocusGained

    private void txtf9FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtf9FocusLost
        if(txtf9.getText().equals(""))
        {
            txtf9.setText("Cus_Contact (Use Numbers Only)");
            txtf9.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_txtf9FocusLost

    private void txtf10FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtf10FocusGained
        if(txtf10.getText().equals("Cus_Email"))
        {
            txtf10.setText("");
            txtf10.setForeground(new Color(51,51,51));
        }
    }//GEN-LAST:event_txtf10FocusGained

    private void txtf10FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtf10FocusLost
        if(txtf10.getText().equals(""))
        {
            txtf10.setText("Cus_Email");
            txtf10.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_txtf10FocusLost

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        mUpdateToCustomerTable();
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        mViewFromDatabase();
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(Reyavaya_Tech5.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Reyavaya_Tech5.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Reyavaya_Tech5.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Reyavaya_Tech5.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Reyavaya_Tech5().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd2;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnDELETE;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable tblCustomers;
    private javax.swing.JTextField txtf10;
    private javax.swing.JTextField txtf6;
    private javax.swing.JTextField txtf7;
    private javax.swing.JTextField txtf8;
    private javax.swing.JTextField txtf9;
    // End of variables declaration//GEN-END:variables
}
