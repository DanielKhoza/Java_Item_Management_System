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
public class Reyavaya_Tech3 extends javax.swing.JFrame {
    
   
    public Reyavaya_Tech4 reyavayatech4;
    

    /**
     * Creates new form Reyavaya_Tech3
     */
    public Reyavaya_Tech3() {
        
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/50, dim.height/30);
        
        initComponents();
        setIconImage();   
    }
    
    private void setIconImage(){
    setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icons8-motherboard-100.png"))); 
    }
    
    Boolean booleanRecordExist = false;
    String strProd_id = null;
    String strSupp_id = null;
    String strPurchase_qty = null;
    String strPurchase_price = null;
    String strTotal = null;
    String strDate = null;
    
    private void mGetValues()
    {
        strProd_id = txtF1.getText();
        strSupp_id = txtF2.getText();
        strPurchase_qty = txtF3.getText();
        strPurchase_price = txtF4.getText();
        strTotal = txtF5.getText();
        strDate = txtF6.getText();
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
            String strQuery = "Select * From purchase where Prod_id='" + txtF1 + "'and Supp_id='" + txtF2 + "'and Purchase_qty='" + txtF3 + "'and Purchase_price='" + txtF4 + "'and Total='" + txtF5 + "'and Date='" + txtF6 + "'";
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
    private void  mInsertToPurchaseTable()
    {
        java.sql.Connection conMySQLConnectionString = null;
        String URL = "jdbc:mysql://127.0.0.1:3306/Reyavaya_technologies";
        String User = "root";
        String Password = "Daniel_25042577_Khoza";
        try
        {
            conMySQLConnectionString = DriverManager.getConnection(URL,User,Password);
            Statement myStatement = conMySQLConnectionString.createStatement();
            String sqlinsert = "insert into purchase" + "(Prod_id,Supp_id,Purchase_qty,Purchase_price,Total,Date)" + "Value('"+txtF1+"', '"+txtF1+"', '"+txtF1+"', '"+txtF1+"', '"+txtF1+"', '"+txtF1+"')";
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
            String strQuery = "Delete * From purchase where Prod_id='" + txtF1 + "'and Supp_id='" + txtF2 + "'and Purchase_qty='" + txtF3 + "'and Purchase_price='" + txtF4 + "'and Total='" + txtF5 + "'and Date='" + txtF6 +"'";
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
    private void mUpdateToPurchaseTable()
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
            String sqlinsert = "Update purchase SET Prod_id='"+txtF1+"', + Supp_id='"+txtF2+"'Purchase_qty='"+txtF3+"'Purchase_price='"+txtF4+"'Total='"+txtF5+"'Date='"+txtF6+"'";
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
        ResultSet rsPurchase = null;
        String strSQLQuery;
        
        try
        {
            conMySQLConnectionString = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Reyavaya_technologies", "root", "Daniel_25042577_Khoza");
            strSQLQuery = "Select * from purchase";
            rsPurchase = stSQLQuery.executeQuery(strSQLQuery);
            ResultSetMetaData rsmt = rsPurchase.getMetaData();
            int intColumnCount = rsmt.getColumnCount();
            Vector vColumn = new Vector(intColumnCount);
            
            for(int i=1; i<intColumnCount; i++)
            {
                vColumn.add(rsmt.getColumnName(i));
            }
            
            Vector vData = new Vector();
            Vector vRow = new Vector();
            
            while(rsPurchase.next())
            {
                vRow = new Vector(intColumnCount);
                
                for(int i=1; 1<=intColumnCount; i++)
                {
                    vRow.add(rsPurchase.getString(i));
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
                rsPurchase.close();
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
        tblPurchase = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        btnADD3 = new javax.swing.JButton();
        btnDELETE3 = new javax.swing.JButton();
        btnView3 = new javax.swing.JButton();
        txtF1 = new javax.swing.JTextField();
        txtF2 = new javax.swing.JTextField();
        txtF3 = new javax.swing.JTextField();
        txtF4 = new javax.swing.JTextField();
        txtF5 = new javax.swing.JTextField();
        txtF6 = new javax.swing.JTextField();
        btnBack = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        btnUpdate = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("REYAVAYA TECHNOLOGIES");
        setResizable(false);
        setSize(new java.awt.Dimension(1299, 611));

        jPanel1.setPreferredSize(new java.awt.Dimension(1299, 611));
        jPanel1.setLayout(null);

        tblPurchase.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Prod_id", "Supp_id", "Purchased_qty", "Purchased_price", "Total", "Date"
            }
        ));
        tblPurchase.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jScrollPane1.setViewportView(tblPurchase);
        if (tblPurchase.getColumnModel().getColumnCount() > 0) {
            tblPurchase.getColumnModel().getColumn(0).setResizable(false);
            tblPurchase.getColumnModel().getColumn(1).setResizable(false);
            tblPurchase.getColumnModel().getColumn(2).setResizable(false);
            tblPurchase.getColumnModel().getColumn(3).setResizable(false);
            tblPurchase.getColumnModel().getColumn(4).setResizable(false);
            tblPurchase.getColumnModel().getColumn(5).setResizable(false);
        }

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(200, 40, 900, 360);

        jLabel2.setFont(new java.awt.Font("Arial Rounded MT Bold", 3, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("PURCHASE");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(590, 10, 130, 30);

        btnADD3.setBackground(new java.awt.Color(255, 255, 255));
        btnADD3.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 12)); // NOI18N
        btnADD3.setForeground(new java.awt.Color(0, 0, 0));
        btnADD3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-plus-20.png"))); // NOI18N
        btnADD3.setText("ADD");
        btnADD3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnADD3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnADD3ActionPerformed(evt);
            }
        });
        jPanel1.add(btnADD3);
        btnADD3.setBounds(360, 530, 115, 30);

        btnDELETE3.setBackground(new java.awt.Color(255, 255, 255));
        btnDELETE3.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 12)); // NOI18N
        btnDELETE3.setForeground(new java.awt.Color(0, 0, 0));
        btnDELETE3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-delete-bin-20.png"))); // NOI18N
        btnDELETE3.setText("DELETE");
        btnDELETE3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDELETE3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDELETE3ActionPerformed(evt);
            }
        });
        jPanel1.add(btnDELETE3);
        btnDELETE3.setBounds(480, 530, 115, 30);

        btnView3.setBackground(new java.awt.Color(255, 255, 255));
        btnView3.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 12)); // NOI18N
        btnView3.setForeground(new java.awt.Color(0, 0, 0));
        btnView3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-database-view-20.png"))); // NOI18N
        btnView3.setText("VIEW");
        btnView3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnView3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnView3ActionPerformed(evt);
            }
        });
        jPanel1.add(btnView3);
        btnView3.setBounds(720, 530, 115, 30);

        txtF1.setForeground(new java.awt.Color(153, 153, 153));
        txtF1.setText("Prod_ID (Use Numbers Only)");
        txtF1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txtF1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtF1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtF1FocusLost(evt);
            }
        });
        jPanel1.add(txtF1);
        txtF1.setBounds(270, 420, 350, 28);

        txtF2.setForeground(new java.awt.Color(153, 153, 153));
        txtF2.setText("Supp_ID (Use Numbers Only)");
        txtF2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txtF2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtF2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtF2FocusLost(evt);
            }
        });
        jPanel1.add(txtF2);
        txtF2.setBounds(270, 450, 350, 28);

        txtF3.setForeground(new java.awt.Color(153, 153, 153));
        txtF3.setText("Purchase_qty (Use Numbers Only)");
        txtF3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txtF3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtF3FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtF3FocusLost(evt);
            }
        });
        jPanel1.add(txtF3);
        txtF3.setBounds(270, 480, 350, 28);

        txtF4.setForeground(new java.awt.Color(153, 153, 153));
        txtF4.setText("Purchase_price (Use Numbers Only)");
        txtF4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txtF4.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtF4FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtF4FocusLost(evt);
            }
        });
        txtF4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtF4ActionPerformed(evt);
            }
        });
        jPanel1.add(txtF4);
        txtF4.setBounds(680, 420, 350, 28);

        txtF5.setForeground(new java.awt.Color(153, 153, 153));
        txtF5.setText("Total");
        txtF5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txtF5.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtF5FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtF5FocusLost(evt);
            }
        });
        txtF5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtF5ActionPerformed(evt);
            }
        });
        jPanel1.add(txtF5);
        txtF5.setBounds(680, 450, 350, 28);

        txtF6.setForeground(new java.awt.Color(153, 153, 153));
        txtF6.setText("Date");
        txtF6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txtF6.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtF6FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtF6FocusLost(evt);
            }
        });
        jPanel1.add(txtF6);
        txtF6.setBounds(680, 480, 350, 28);

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
        btnBack.setBounds(840, 530, 115, 30);
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
        btnUpdate.setBounds(600, 530, 115, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Background.png"))); // NOI18N
        jLabel1.setPreferredSize(new java.awt.Dimension(1299, 611));
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 1299, 611);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1299, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnView3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnView3ActionPerformed
        mViewFromDatabase();
    }//GEN-LAST:event_btnView3ActionPerformed

    private void btnADD3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnADD3ActionPerformed
        if(txtF1.getText().equals("")||txtF2.getText().equals("")||txtF3.getText().equals("")||txtF4.getText().equals("")||txtF5.getText().equals("")||txtF6.getText().equals(""))
            JOptionPane.showMessageDialog(null,"Please fill in Blank spaces !!" + "\n For Purchase Table", "PURCHASE TABLE", JOptionPane.WARNING_MESSAGE);
        else{
            String data[] = {txtF1.getText(),txtF2.getText(),txtF3.getText(),txtF4.getText(),txtF5.getText(),txtF6.getText()};
            
            DefaultTableModel tblModel = (DefaultTableModel)tblPurchase.getModel();
            tblModel.addRow(data);
            ImageIcon Icon = new javax.swing.ImageIcon(getClass().getResource("/icons8-checked-60.png"));
            JOptionPane.showMessageDialog(null,"Added succefully to Purchase Table", "PURCHASE TABLE", JOptionPane.PLAIN_MESSAGE, Icon);
            txtF1.setText("");
            txtF1.setText("Prod_ID");
            txtF1.setForeground(new Color(153,153,153));
            
            txtF2.setText("");
            txtF2.setText("Supp_ID");
            txtF2.setForeground(new Color(153,153,153));
            
            txtF3.setText("");
            txtF3.setText("Purchase_qty");
            txtF3.setForeground(new Color(153,153,153));
            
            txtF4.setText("");
            txtF4.setText("Purchase_price");
            txtF4.setForeground(new Color(153,153,153));
            
            txtF5.setText("");
            txtF5.setText("Total");
            txtF5.setForeground(new Color(153,153,153));
            
            txtF6.setText("");
            txtF6.setText("Date");
            txtF6.setForeground(new Color(153,153,153));   
            
            mGetValues();
            mCheckIfItemsExistInTable();
            
            if(booleanRecordExist==true)
            {
                booleanRecordExist=false;
                JOptionPane.showMessageDialog(null,"Purchase Info Already Exist");
            }
            else if(booleanRecordExist==false)
            {
                mInsertToPurchaseTable();
            }
            
        }
    }//GEN-LAST:event_btnADD3ActionPerformed

    private void btnDELETE3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDELETE3ActionPerformed
        DefaultTableModel tblModel = (DefaultTableModel)tblPurchase.getModel();
        if(tblPurchase.getSelectedRowCount()==1){
            tblModel.removeRow(tblPurchase.getSelectedRow());
            mDeleteFromTable();
            JOptionPane.showMessageDialog(null,"Deleted", "PURCHASE TABLE", JOptionPane.WARNING_MESSAGE);
        }else{
            if(tblPurchase.getRowCount()==0){
               JOptionPane.showMessageDialog(null,"Nothing to Delete From Purchase Table", "PURCHASE TABLE", JOptionPane.ERROR_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(null,"Select Row to Delete From Purchase Table", "PURCHASE TABLE", JOptionPane.WARNING_MESSAGE);
            }
        } 
    }//GEN-LAST:event_btnDELETE3ActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed

        this.toBack();
        setVisible(false);
        new Reyavaya_Tech().toFront();
        new Reyavaya_Tech().setState(java.awt.Frame.NORMAL);
    }//GEN-LAST:event_btnBackActionPerformed

    private void txtF5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtF5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtF5ActionPerformed

    private void txtF1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtF1FocusGained
        if(txtF1.getText().equals("Prod_ID (Use Numbers Only)"))
        {
            txtF1.setText("");
            txtF1.setForeground(new Color(51,51,51));
        }
    }//GEN-LAST:event_txtF1FocusGained

    private void txtF1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtF1FocusLost
         if(txtF1.getText().equals(""))
        {
            txtF1.setText("Prod_ID (Use Numbers Only)");
            txtF1.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_txtF1FocusLost

    private void txtF2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtF2FocusGained
        if(txtF2.getText().equals("Supp_ID (Use Numbers Only)"))
        {
            txtF2.setText("");
            txtF2.setForeground(new Color(51,51,51));
        }
    }//GEN-LAST:event_txtF2FocusGained

    private void txtF2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtF2FocusLost
       if(txtF2.getText().equals(""))
        {
            txtF2.setText("Supp_ID (Use Numbers Only)");
            txtF2.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_txtF2FocusLost

    private void txtF3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtF3FocusGained
        if(txtF3.getText().equals("Purchase_qty (Use Numbers Only)"))
        {
            txtF3.setText("");
            txtF3.setForeground(new Color(51,51,51));
        }
    }//GEN-LAST:event_txtF3FocusGained

    private void txtF3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtF3FocusLost
        if(txtF3.getText().equals(""))
        {
            txtF3.setText("Purchase_qty (Use Numbers Only)");
            txtF3.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_txtF3FocusLost

    private void txtF4FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtF4FocusGained
         if(txtF4.getText().equals("Purchase_price (Use Numbers Only)"))
        {
            txtF4.setText("");
            txtF4.setForeground(new Color(51,51,51));
        }
    }//GEN-LAST:event_txtF4FocusGained

    private void txtF4FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtF4FocusLost
        if(txtF4.getText().equals(""))
        {
            txtF4.setText("Purchase_price (Use Numbers Only)");
            txtF4.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_txtF4FocusLost

    private void txtF5FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtF5FocusGained
         if(txtF5.getText().equals("Total (Use Numbers Only)"))
        {
            txtF5.setText("");
            txtF5.setForeground(new Color(51,51,51));
        }
    }//GEN-LAST:event_txtF5FocusGained

    private void txtF5FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtF5FocusLost
       if(txtF5.getText().equals(""))
        {
            txtF5.setText("Total (Use Numbers Only)");
            txtF5.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_txtF5FocusLost

    private void txtF6FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtF6FocusGained
          if(txtF6.getText().equals("Date"))
        {
            txtF6.setText("");
            txtF6.setForeground(new Color(51,51,51));
        }
    }//GEN-LAST:event_txtF6FocusGained

    private void txtF6FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtF6FocusLost
         if(txtF6.getText().equals(""))
        {
            txtF6.setText("Date");
            txtF6.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_txtF6FocusLost

    private void txtF4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtF4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtF4ActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        mUpdateToPurchaseTable();
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
            java.util.logging.Logger.getLogger(Reyavaya_Tech3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Reyavaya_Tech3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Reyavaya_Tech3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Reyavaya_Tech3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Reyavaya_Tech3().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnADD3;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnDELETE3;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton btnView3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable tblPurchase;
    private javax.swing.JTextField txtF1;
    private javax.swing.JTextField txtF2;
    private javax.swing.JTextField txtF3;
    private javax.swing.JTextField txtF4;
    private javax.swing.JTextField txtF5;
    private javax.swing.JTextField txtF6;
    // End of variables declaration//GEN-END:variables

}
