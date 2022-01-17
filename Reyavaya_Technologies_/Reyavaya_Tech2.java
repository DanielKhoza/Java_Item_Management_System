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
public class Reyavaya_Tech2 extends javax.swing.JFrame {
    
    public Reyavaya_Tech3 reyavayatech3;
    
    
    /**
     * Creates new form Reyavaya_Tech2
     */
    public Reyavaya_Tech2() {
        
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/50, dim.height/30);
        
        initComponents();
        
        setIconImage();
        
    }
    
    private void setIconImage(){
    setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icons8-motherboard-100.png"))); 
    }
    
    Boolean booleanRecordExist = false;
    String strSupp_id = null;
    String strSupp_Name = null;
    String strSupp_Address = null;
    String strSupp_Contact = null;
    String strSupp_Email = null;
    
    private void mGetValues()
    {
        strSupp_id = txtf1.getText();
        strSupp_Name = txtf2.getText();
        strSupp_Address = txtf3.getText();
        strSupp_Contact = txtf4.getText();
        strSupp_Email = txtf5.getText();
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
            String strQuery = "Select * From supplier where Supp_id='" + txtf1 + "'and Supp_Name='" + txtf2 + "'and Supp_Address='" + txtf3 + "'and Supp_Contact='" + txtf4 + "'and Supp_Email='" + txtf5 +"'";
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
    private void  mInsertToSupplierTable()
    {
        java.sql.Connection conMySQLConnectionString = null;
        String URL = "jdbc:mysql://127.0.0.1:3306/Reyavaya_technologies";
        String User = "root";
        String Password = "Daniel_25042577_Khoza";
        try
        {
            conMySQLConnectionString = DriverManager.getConnection(URL,User,Password);
            Statement myStatement = conMySQLConnectionString.createStatement();
            String sqlinsert = "insert into supplier" + "(Supp_id,Supp_Name,Supp_Address,Supp_Contact,Supp_Email)" + "Value('"+txtf1+"', '"+txtf2+"', '"+txtf3+"', '"+txtf4+"', '"+txtf5+"')";
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
            String strQuery = "Delete * From supplier where Supp_id='" + txtf1 + "'and Supp_Name='" + txtf2 + "'and Supp_Address='" + txtf3 + "'and Supp_Contact='" + txtf4 + "'and Supp_Email='" + txtf5 +"'";
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
    private void mUpdateToSupplierTable()
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
            String sqlinsert = "Update supplier SET Supp_id='"+txtf1+"', + Supp_Name='"+txtf2+"'Supp_Address='"+txtf3+"'Supp_Contact='"+txtf4+"'Supp_Email='"+txtf5+"'";
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
        ResultSet rsSupplier = null;
        String strSQLQuery;
        
        try
        {
            conMySQLConnectionString = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Reyavaya_technologies", "root", "Daniel_25042577_Khoza");
            strSQLQuery = "Select * from supllier";
            rsSupplier = stSQLQuery.executeQuery(strSQLQuery);
            ResultSetMetaData rsmt = rsSupplier.getMetaData();
            int intColumnCount = rsmt.getColumnCount();
            Vector vColumn = new Vector(intColumnCount);
            
            for(int i=1; i<intColumnCount; i++)
            {
                vColumn.add(rsmt.getColumnName(i));
            }
            
            Vector vData = new Vector();
            Vector vRow = new Vector();
            
            while(rsSupplier.next())
            {
                vRow = new Vector(intColumnCount);
                
                for(int i=1; 1<=intColumnCount; i++)
                {
                    vRow.add(rsSupplier.getString(i));
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
                rsSupplier.close();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSupplier = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtf1 = new javax.swing.JTextField();
        txtf2 = new javax.swing.JTextField();
        txtf3 = new javax.swing.JTextField();
        txtf4 = new javax.swing.JTextField();
        txtf5 = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        btnUpdate = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("REYAVAYA TECHNOLOGIES");
        setPreferredSize(new java.awt.Dimension(1299, 611));
        setResizable(false);

        jPanel1.setLayout(null);

        tblSupplier.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Supp_id", "Supp_name", "Supp_address", "Supp_contact", "Supp_email"
            }
        ));
        tblSupplier.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jScrollPane1.setViewportView(tblSupplier);
        if (tblSupplier.getColumnModel().getColumnCount() > 0) {
            tblSupplier.getColumnModel().getColumn(0).setResizable(false);
            tblSupplier.getColumnModel().getColumn(1).setResizable(false);
            tblSupplier.getColumnModel().getColumn(2).setResizable(false);
            tblSupplier.getColumnModel().getColumn(3).setResizable(false);
            tblSupplier.getColumnModel().getColumn(4).setResizable(false);
        }

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(200, 40, 900, 360);

        jLabel2.setFont(new java.awt.Font("Arial Rounded MT Bold", 3, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("SUPPLIER");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(590, 10, 110, 30);

        txtf1.setForeground(new java.awt.Color(153, 153, 153));
        txtf1.setText("Supp_ID (Use Numbers Only)");
        txtf1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txtf1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtf1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtf1FocusLost(evt);
            }
        });
        jPanel1.add(txtf1);
        txtf1.setBounds(250, 420, 350, 28);

        txtf2.setForeground(new java.awt.Color(153, 153, 153));
        txtf2.setText("Supp_Name");
        txtf2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txtf2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtf2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtf2FocusLost(evt);
            }
        });
        txtf2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtf2ActionPerformed(evt);
            }
        });
        jPanel1.add(txtf2);
        txtf2.setBounds(250, 450, 350, 28);

        txtf3.setForeground(new java.awt.Color(153, 153, 153));
        txtf3.setText("Supp_Address");
        txtf3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txtf3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtf3FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtf3FocusLost(evt);
            }
        });
        jPanel1.add(txtf3);
        txtf3.setBounds(250, 480, 350, 28);

        txtf4.setForeground(new java.awt.Color(153, 153, 153));
        txtf4.setText("Supp_Contact (Use Numbers Only)");
        txtf4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txtf4.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtf4FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtf4FocusLost(evt);
            }
        });
        jPanel1.add(txtf4);
        txtf4.setBounds(690, 420, 350, 28);

        txtf5.setForeground(new java.awt.Color(153, 153, 153));
        txtf5.setText("Supp_Email");
        txtf5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txtf5.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtf5FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtf5FocusLost(evt);
            }
        });
        jPanel1.add(txtf5);
        txtf5.setBounds(690, 450, 350, 28);

        btnAdd.setBackground(new java.awt.Color(255, 255, 255));
        btnAdd.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 12)); // NOI18N
        btnAdd.setForeground(new java.awt.Color(0, 0, 0));
        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-add-user-male-20.png"))); // NOI18N
        btnAdd.setText("ADD");
        btnAdd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        jPanel1.add(btnAdd);
        btnAdd.setBounds(340, 530, 115, 30);

        btnDelete.setBackground(new java.awt.Color(255, 255, 255));
        btnDelete.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 12)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(0, 0, 0));
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-delete-bin-20.png"))); // NOI18N
        btnDelete.setText("DELETE");
        btnDelete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        jPanel1.add(btnDelete);
        btnDelete.setBounds(460, 530, 115, 30);

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-database-view-20.png"))); // NOI18N
        jButton1.setText("VIEW");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(700, 530, 115, 30);

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
        btnBack.setBounds(820, 530, 115, 30);
        jPanel1.add(jSeparator1);
        jSeparator1.setBounds(140, 410, 1030, 10);
        jPanel1.add(jSeparator2);
        jSeparator2.setBounds(140, 520, 1030, 10);

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
        btnUpdate.setBounds(580, 530, 115, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Background.png"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 1300, 660);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1297, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 659, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        DefaultTableModel tblModel = (DefaultTableModel)tblSupplier.getModel();
        if(tblSupplier.getSelectedRowCount()==1){
            tblModel.removeRow(tblSupplier.getSelectedRow());
            mDeleteFromTable();
            JOptionPane.showMessageDialog(null,"Deleted", " SUPPLIER TABLE", JOptionPane.WARNING_MESSAGE);
        }else{
            if(tblSupplier.getRowCount()==0){
               JOptionPane.showMessageDialog(this,"Nothing to Delete From Supplier Table", "SUPPLIER TABLE", JOptionPane.ERROR_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(this,"Select Row to Delete From Supplier Table", "SUPPLIER TABLE", JOptionPane.WARNING_MESSAGE);
            }
        } 
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        if(txtf1.getText().equals("")||txtf2.getText().equals("")||txtf3.getText().equals("")||txtf4.getText().equals("")||txtf5.getText().equals(""))
            JOptionPane.showMessageDialog(this,"Please fill in Blank spaces !!" + "\nTo Add Supplier", "TABLE SUPPLIER", JOptionPane.WARNING_MESSAGE);
        else{
            String data[] = {txtf1.getText(),txtf2.getText(),txtf3.getText(),txtf4.getText(),txtf5.getText()};
            
            DefaultTableModel tblModel = (DefaultTableModel)tblSupplier.getModel();
            tblModel.addRow(data);
            ImageIcon Icon = new javax.swing.ImageIcon(getClass().getResource("/icons8-add-user-male-65.png"));
            JOptionPane.showMessageDialog(this," Supplier Added succefully", "SUPPLIER TABLE", JOptionPane.PLAIN_MESSAGE, Icon);
            txtf1.setText("");
            txtf1.setText("Supp_ID");
            txtf1.setForeground(new Color(153,153,153));
            
            txtf2.setText("");
            txtf2.setText("Supp_Name");
            txtf2.setForeground(new Color(153,153,153));
            
            txtf3.setText("");
            txtf3.setText("Supp_Address");
            txtf3.setForeground(new Color(153,153,153));
            
            txtf4.setText("");
            txtf4.setText("Supp_Contact");
            txtf4.setForeground(new Color(153,153,153));
            
            txtf5.setText("");
            txtf5.setText("Supp_Email");
            txtf5.setForeground(new Color(153,153,153));
            
            mGetValues();
            mCheckIfItemsExistInTable();
            
            if(booleanRecordExist==true)
            {
                booleanRecordExist=false;
                JOptionPane.showMessageDialog(null,"Supplier Info Already Exist");
            }
            else if(booleanRecordExist==false)
            {
                mInsertToSupplierTable();
            }
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        this.toBack();
        setVisible(false);
        new Reyavaya_Tech().toFront();
        new Reyavaya_Tech().setState(java.awt.Frame.NORMAL);
    }//GEN-LAST:event_btnBackActionPerformed

    private void txtf2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtf2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtf2ActionPerformed

    private void txtf1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtf1FocusGained
        if(txtf1.getText().equals("Supp_ID (Use Numbers Only)"))
        {
            txtf1.setText("");
            txtf1.setForeground(new Color(51,51,51));
        }
    }//GEN-LAST:event_txtf1FocusGained

    private void txtf1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtf1FocusLost
        if(txtf1.getText().equals(""))
        {
            txtf1.setText("Supp_ID (Use Numbers Only)");
            txtf1.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_txtf1FocusLost

    private void txtf2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtf2FocusGained
        if(txtf2.getText().equals("Supp_Name"))
        {
            txtf2.setText("");
            txtf2.setForeground(new Color(51,51,51));
        }
    }//GEN-LAST:event_txtf2FocusGained

    private void txtf2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtf2FocusLost
         if(txtf2.getText().equals(""))
        {
            txtf2.setText("Supp_Name");
            txtf2.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_txtf2FocusLost

    private void txtf3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtf3FocusGained
        if(txtf3.getText().equals("Supp_Address"))
        {
            txtf3.setText("");
            txtf3.setForeground(new Color(51,51,51));
        }
    }//GEN-LAST:event_txtf3FocusGained

    private void txtf3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtf3FocusLost
         if(txtf3.getText().equals(""))
        {
            txtf3.setText("Supp_Address");
            txtf3.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_txtf3FocusLost

    private void txtf4FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtf4FocusGained
        if(txtf4.getText().equals("Supp_Contact (Use Numbers Only)"))
        {
            txtf4.setText("");
            txtf4.setForeground(new Color(51,51,51));
        }
    }//GEN-LAST:event_txtf4FocusGained

    private void txtf4FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtf4FocusLost
        if(txtf4.getText().equals(""))
        {
            txtf4.setText("Supp_Contact (Use Numbers Only)");
            txtf4.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_txtf4FocusLost

    private void txtf5FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtf5FocusGained
        if(txtf5.getText().equals("Supp_Email"))
        {
            txtf5.setText("");
            txtf5.setForeground(new Color(51,51,51));
        }
    }//GEN-LAST:event_txtf5FocusGained

    private void txtf5FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtf5FocusLost
        if(txtf5.getText().equals(""))
        {
            txtf5.setText("Supp_Email");
            txtf5.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_txtf5FocusLost

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        mViewFromDatabase();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        mUpdateToSupplierTable();
    }//GEN-LAST:event_btnUpdateActionPerformed

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
            java.util.logging.Logger.getLogger(Reyavaya_Tech2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Reyavaya_Tech2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Reyavaya_Tech2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Reyavaya_Tech2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Reyavaya_Tech2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable tblSupplier;
    private javax.swing.JTextField txtf1;
    private javax.swing.JTextField txtf2;
    private javax.swing.JTextField txtf3;
    private javax.swing.JTextField txtf4;
    private javax.swing.JTextField txtf5;
    // End of variables declaration//GEN-END:variables


}
