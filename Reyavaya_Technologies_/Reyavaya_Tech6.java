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
public class Reyavaya_Tech6 extends javax.swing.JFrame {
  
    public Reyavaya_Tech reyavayatech;

    /**
     * Creates new form Reyavaya_Tech6
     */
    public Reyavaya_Tech6() {
        initComponents();
        setIconImage();
    }
    
    private void setIconImage(){
    setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icons8-motherboard-100.png"))); 
    }
    
    Boolean booleanRecordExist = false;
    String strProd_id = null;
    String strProd_Name = null;
    String strSold_qty = null;
    String strSelling_price = null;
    String strSale_Total = null;
    String strSale_Date = null;
    
    private void mGetValues()
    {
        strProd_id = txtF7.getText();
        strProd_Name = txtF8.getText();
        strSold_qty = txtF9.getText();
        strSelling_price = txtF10.getText();
        strSale_Total = txtF11.getText();
        strSale_Date = txtF12.getText();
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
            String strQuery = "Select * From sales where Prod_id='" + txtF7 + "'and Prod_name='" + txtF8 + "'and Sold_qty='" + txtF9 + "'and Selling_price='" + txtF10 + "'and Sale_Total='" + txtF11 + "'and Sale_Date='" + txtF10 + "'";
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
    private void  mInsertToSalesTable()
    {
        java.sql.Connection conMySQLConnectionString = null;
        String URL = "jdbc:mysql://127.0.0.1:3306/Reyavaya_technologies";
        String User = "root";
        String Password = "Daniel_25042577_Khoza";
        try
        {
            conMySQLConnectionString = DriverManager.getConnection(URL,User,Password);
            Statement myStatement = conMySQLConnectionString.createStatement();
            String sqlinsert = "insert into sales" + "(Prod_id,Prod_name,Sold_qty,Sold_price,Sold_Total,Sold_Date)" + "Value('"+txtF7+"', '"+txtF8+"', '"+txtF9+"', '"+txtF10+"', '"+txtF11+"', '"+txtF12+"')";
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
            String strQuery = "Delete * From sales where Prod_id='" + txtF7 + "'and Prod_name='" + txtF8 + "'and Sold_qty='" + txtF9 + "'and Sold_price='" + txtF10 + "'and Sold_Total='" + txtF11 + "'and sold_Date='" + txtF12 +"'";
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
    private void mUpdateToSalesTable()
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
            String sqlinsert = "Update sales SET Prod_id='"+txtF7+"', + Prod_name='"+txtF8+"'Sold_qty='"+txtF9+"'Sold_price='"+txtF10+"'Sold_Total='"+txtF11+"'sold_Date='"+txtF12+"'";
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
        ResultSet rsSales = null;
        String strSQLQuery;
        
        try
        {
            conMySQLConnectionString = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Reyavaya_technologies", "root", "Daniel_25042577_Khoza");
            strSQLQuery = "Select * from sales";
            rsSales = stSQLQuery.executeQuery(strSQLQuery);
            ResultSetMetaData rsmt = rsSales.getMetaData();
            int intColumnCount = rsmt.getColumnCount();
            Vector vColumn = new Vector(intColumnCount);
            
            for(int i=1; i<intColumnCount; i++)
            {
                vColumn.add(rsmt.getColumnName(i));
            }
            
            Vector vData = new Vector();
            Vector vRow = new Vector();
            
            while(rsSales.next())
            {
                vRow = new Vector(intColumnCount);
                
                for(int i=1; 1<=intColumnCount; i++)
                {
                    vRow.add(rsSales.getString(i));
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
                rsSales.close();
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
        txtF11 = new javax.swing.JTextField();
        txtF10 = new javax.swing.JTextField();
        txtF8 = new javax.swing.JTextField();
        txtF12 = new javax.swing.JTextField();
        txtF7 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        btnDELETE4 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        btnADD4 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblSales = new javax.swing.JTable();
        txtF9 = new javax.swing.JTextField();
        btnBack = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        btnUpdate = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("REYAVAYA TECHNOLOGIES");
        setSize(new java.awt.Dimension(1299, 611));

        jPanel1.setMaximumSize(new java.awt.Dimension(1299, 611));
        jPanel1.setMinimumSize(new java.awt.Dimension(1299, 611));
        jPanel1.setPreferredSize(new java.awt.Dimension(1299, 611));
        jPanel1.setLayout(null);

        txtF11.setForeground(new java.awt.Color(153, 153, 153));
        txtF11.setText("Sale_Total (Use Numbers Only)");
        txtF11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txtF11.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtF11FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtF11FocusLost(evt);
            }
        });
        jPanel1.add(txtF11);
        txtF11.setBounds(690, 450, 350, 28);

        txtF10.setForeground(new java.awt.Color(153, 153, 153));
        txtF10.setText("Selling_price (Use Numbers Only)");
        txtF10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txtF10.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtF10FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtF10FocusLost(evt);
            }
        });
        jPanel1.add(txtF10);
        txtF10.setBounds(690, 420, 350, 28);

        txtF8.setForeground(new java.awt.Color(153, 153, 153));
        txtF8.setText("Prod_Name");
        txtF8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txtF8.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtF8FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtF8FocusLost(evt);
            }
        });
        jPanel1.add(txtF8);
        txtF8.setBounds(260, 450, 350, 28);

        txtF12.setForeground(new java.awt.Color(153, 153, 153));
        txtF12.setText("Sale_Date");
        txtF12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txtF12.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtF12FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtF12FocusLost(evt);
            }
        });
        jPanel1.add(txtF12);
        txtF12.setBounds(690, 480, 350, 28);

        txtF7.setForeground(new java.awt.Color(153, 153, 153));
        txtF7.setText("Prod_ID (Use Numbers Only)");
        txtF7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txtF7.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtF7FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtF7FocusLost(evt);
            }
        });
        txtF7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtF7ActionPerformed(evt);
            }
        });
        jPanel1.add(txtF7);
        txtF7.setBounds(260, 420, 350, 28);

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
        jButton1.setBounds(720, 530, 115, 30);

        btnDELETE4.setBackground(new java.awt.Color(255, 255, 255));
        btnDELETE4.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 12)); // NOI18N
        btnDELETE4.setForeground(new java.awt.Color(0, 0, 0));
        btnDELETE4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-delete-bin-20.png"))); // NOI18N
        btnDELETE4.setText("DELETE");
        btnDELETE4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDELETE4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDELETE4ActionPerformed(evt);
            }
        });
        jPanel1.add(btnDELETE4);
        btnDELETE4.setBounds(480, 530, 115, 30);

        jLabel3.setFont(new java.awt.Font("Arial Rounded MT Bold", 3, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("SALES");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(610, 10, 80, 30);

        btnADD4.setBackground(new java.awt.Color(255, 255, 255));
        btnADD4.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 12)); // NOI18N
        btnADD4.setForeground(new java.awt.Color(0, 0, 0));
        btnADD4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-plus-20.png"))); // NOI18N
        btnADD4.setText("ADD");
        btnADD4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnADD4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnADD4ActionPerformed(evt);
            }
        });
        jPanel1.add(btnADD4);
        btnADD4.setBounds(360, 530, 115, 30);

        tblSales.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Prod_id", "Prod_name", "Sold_qty", "Selling_price", "Sale_total", "Sale_date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, true, true, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblSales.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jScrollPane2.setViewportView(tblSales);

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(200, 40, 910, 360);

        txtF9.setForeground(new java.awt.Color(153, 153, 153));
        txtF9.setText("Sold_qty (Use Numbers Only)");
        txtF9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txtF9.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtF9FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtF9FocusLost(evt);
            }
        });
        jPanel1.add(txtF9);
        txtF9.setBounds(260, 480, 350, 28);

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
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 1300, 610);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 611, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnADD4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnADD4ActionPerformed
        if(txtF7.getText().equals("")||txtF8.getText().equals("")||txtF9.getText().equals("")||txtF10.getText().equals("")||txtF11.getText().equals("")||txtF12.getText().equals(""))
        JOptionPane.showMessageDialog(null,"Please fill in Blank spaces !!" + "\n For Stocks Table", "SALES TABLE", JOptionPane.WARNING_MESSAGE);
        else{
            String data[] = {txtF7.getText(),txtF8.getText(),txtF9.getText(),txtF10.getText(),txtF11.getText(),txtF12.getText()};

            DefaultTableModel tblModel = (DefaultTableModel)tblSales.getModel();
            tblModel.addRow(data);
            ImageIcon Icon = new javax.swing.ImageIcon(getClass().getResource("/icons8-checked-60.png"));
            JOptionPane.showMessageDialog(null,"Added succefully to Sales Table", "SALES TABLE", JOptionPane.PLAIN_MESSAGE, Icon);
            txtF7.setText("");
            txtF7.setText("Prod_ID");
            txtF7.setForeground(new Color(153,153,153));
            
            txtF8.setText("");
            txtF8.setText("Prod_Name");
            txtF8.setForeground(new Color(153,153,153));
            
            txtF9.setText("");
            txtF9.setText("Prod_qty");
            txtF9.setForeground(new Color(153,153,153));
            
            txtF10.setText("");
            txtF10.setText("Selling_price");
            txtF10.setForeground(new Color(153,153,153));
            
            txtF11.setText("");
            txtF11.setText("Sale_Total");
            txtF11.setForeground(new Color(153,153,153));
            
            txtF12.setText("");
            txtF12.setText("Sale_Date");
            txtF12.setForeground(new Color(153,153,153));
            
            mGetValues();
            mCheckIfItemsExistInTable();
            
            if(booleanRecordExist==true)
            {
                booleanRecordExist=false;
                JOptionPane.showMessageDialog(null,"Sales Info Already Exist");
            }
            else if(booleanRecordExist==false)
            {
                mInsertToSalesTable();
            }
        }
        
        try 
        {
            
        }
        catch (Exception e)
        {
            
        }
    }//GEN-LAST:event_btnADD4ActionPerformed

    private void btnDELETE4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDELETE4ActionPerformed
        DefaultTableModel tblModel = (DefaultTableModel)tblSales.getModel();
        if(tblSales.getSelectedRowCount()==1){
            tblModel.removeRow(tblSales.getSelectedRow());
            mDeleteFromTable();
            JOptionPane.showMessageDialog(null,"Deleted", "SALES TABLE", JOptionPane.WARNING_MESSAGE);
        }else{
            if(tblSales.getRowCount()==0){
                JOptionPane.showMessageDialog(null,"Nothing to Delete From Table Sales", "SALES TABLE", JOptionPane.ERROR_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(null,"Select Row to Delete From Table Sales", "SALES TABLE", JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnDELETE4ActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        this.toBack();
        setVisible(false);
        new Reyavaya_Tech().toFront();
        new Reyavaya_Tech().setState(java.awt.Frame.NORMAL);
    }//GEN-LAST:event_btnBackActionPerformed

    private void txtF7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtF7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtF7ActionPerformed

    private void txtF7FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtF7FocusGained
        if(txtF7.getText().equals("Prod_ID (Use Numbers Only)"))
        {
            txtF7.setText("");
            txtF7.setForeground(new Color(51,51,51));
        }
    }//GEN-LAST:event_txtF7FocusGained

    private void txtF7FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtF7FocusLost
        if(txtF7.getText().equals(""))
        {
            txtF7.setText("Prod_ID (Use Numbers Only)");
            txtF7.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_txtF7FocusLost

    private void txtF8FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtF8FocusGained
        if(txtF8.getText().equals("Prod_Name"))
        {
            txtF8.setText("");
            txtF8.setForeground(new Color(51,51,51));
        }
    }//GEN-LAST:event_txtF8FocusGained

    private void txtF8FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtF8FocusLost
        if(txtF8.getText().equals(""))
        {
            txtF8.setText("Prod_Name");
            txtF8.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_txtF8FocusLost

    private void txtF9FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtF9FocusGained
        if(txtF9.getText().equals("Sold_qty (Use Numbers Only)"))
        {
            txtF9.setText("");
            txtF9.setForeground(new Color(51,51,51));
        }
    }//GEN-LAST:event_txtF9FocusGained

    private void txtF9FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtF9FocusLost
        if(txtF9.getText().equals(""))
        {
            txtF9.setText("Sold_qty (Use Numbers Only)");
            txtF9.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_txtF9FocusLost

    private void txtF10FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtF10FocusGained
         if(txtF10.getText().equals("Selling_price (Use Numbers Only)"))
        {
            txtF10.setText("");
            txtF10.setForeground(new Color(51,51,51));
        }
    }//GEN-LAST:event_txtF10FocusGained

    private void txtF10FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtF10FocusLost
        if(txtF10.getText().equals(""))
        {
            txtF10.setText("Selling_price (Use Numbers Only)");
            txtF10.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_txtF10FocusLost

    private void txtF11FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtF11FocusGained
         if(txtF11.getText().equals("Sale_Total (Use Numbers Only)"))
        {
            txtF11.setText("");
            txtF11.setForeground(new Color(51,51,51));
        }
    }//GEN-LAST:event_txtF11FocusGained

    private void txtF11FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtF11FocusLost
        if(txtF11.getText().equals(""))
        {
            txtF11.setText("Sale_Total (Use Numbers Only)");
            txtF11.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_txtF11FocusLost

    private void txtF12FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtF12FocusGained
        if(txtF12.getText().equals("Sale_Date"))
        {
            txtF12.setText("");
            txtF12.setForeground(new Color(51,51,51));
        }
    }//GEN-LAST:event_txtF12FocusGained

    private void txtF12FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtF12FocusLost
        if(txtF12.getText().equals(""))
        {
            txtF12.setText("Sale_Date");
            txtF12.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_txtF12FocusLost

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
         mUpdateToSalesTable();
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         mViewFromDatabase();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Reyavaya_Tech6.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Reyavaya_Tech6.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Reyavaya_Tech6.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Reyavaya_Tech6.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Reyavaya_Tech6().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnADD4;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnDELETE4;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable tblSales;
    private javax.swing.JTextField txtF10;
    private javax.swing.JTextField txtF11;
    private javax.swing.JTextField txtF12;
    private javax.swing.JTextField txtF7;
    private javax.swing.JTextField txtF8;
    private javax.swing.JTextField txtF9;
    // End of variables declaration//GEN-END:variables
}
