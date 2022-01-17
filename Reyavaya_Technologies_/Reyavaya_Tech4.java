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
public class Reyavaya_Tech4 extends javax.swing.JFrame {
    
    public Reyavaya_Tech5 reyavayatech5;
   
    /**
     * Creates new form Reyavaya_Tech4
     */
    public Reyavaya_Tech4() {
        initComponents();
        setIconImage();    
    }
    
    private void setIconImage(){
    setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icons8-motherboard-100.png"))); 
    }
    
    Boolean booleanRecordExist = false;
    String strProd_id = null;
    String strProd_Name = null;
    String strQty = null;
    
    private void mGetValues()
    {
        strProd_id = txtProd_ID2.getText();
        strProd_Name= txtProd_Name2.getText();
        strQty = txtQty.getText();
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
            String strQuery = "Select * From stocks where Prod_id='" + txtProd_ID2 + "'and Prod_Name='" + txtProd_Name2 + "'and Qty='" + txtQty + "'";
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
    private void  mInsertToStockTable()
    {
        java.sql.Connection conMySQLConnectionString = null;
        String URL = "jdbc:mysql://127.0.0.1:3306/Reyavaya_technologies";
        String User = "root";
        String Password = "Daniel_25042577_Khoza";
        try
        {
            conMySQLConnectionString = DriverManager.getConnection(URL,User,Password);
            Statement myStatement = conMySQLConnectionString.createStatement();
            String sqlinsert = "insert into stocks" + "(Prod_id,Prod_Name,Qty)" + "Value('"+txtProd_ID2+"', '"+txtProd_Name2+"', '"+txtQty+"')";
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
            String strQuery = "Delete * From stocks where Prod_id='" + txtProd_ID2 + "'and Prod_Name='" + txtProd_Name2 + "'and Qty='" + txtQty +"'";
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
    private void mUpdateTostockTable()
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
            String sqlinsert = "Update stocks SET Prod_id='"+txtProd_ID2+"', + Prod_Name='"+txtProd_Name2+"'Qty='"+txtQty+"'";
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
        ResultSet rsStocks = null;
        String strSQLQuery;
        
        try
        {
            conMySQLConnectionString = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Reyavaya_technologies", "root", "Daniel_25042577_Khoza");
            strSQLQuery = "Select * from Stocks";
            rsStocks = stSQLQuery.executeQuery(strSQLQuery);
            ResultSetMetaData rsmt = rsStocks.getMetaData();
            int intColumnCount = rsmt.getColumnCount();
            Vector vColumn = new Vector(intColumnCount);
            
            for(int i=1; i<intColumnCount; i++)
            {
                vColumn.add(rsmt.getColumnName(i));
            }
            
            Vector vData = new Vector();
            Vector vRow = new Vector();
            
            while(rsStocks.next())
            {
                vRow = new Vector(intColumnCount);
                
                for(int i=1; 1<=intColumnCount; i++)
                {
                    vRow.add(rsStocks.getString(i));
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
                rsStocks.close();
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
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblStocks = new javax.swing.JTable();
        txtProd_ID2 = new javax.swing.JTextField();
        txtProd_Name2 = new javax.swing.JTextField();
        txtQty = new javax.swing.JTextField();
        btnAdd2 = new javax.swing.JButton();
        btnDelete2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        btnUpdate = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("REYAVAYA TECHNOLOGIES");
        setSize(new java.awt.Dimension(1299, 611));

        jPanel1.setPreferredSize(new java.awt.Dimension(1299, 611));
        jPanel1.setLayout(null);

        jLabel4.setFont(new java.awt.Font("Arial Rounded MT Bold", 3, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("STOCKS");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(600, 11, 90, 30);

        tblStocks.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Prod_id", "Prod_Name", "Qty"
            }
        ));
        tblStocks.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jScrollPane1.setViewportView(tblStocks);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(200, 40, 900, 350);

        txtProd_ID2.setForeground(new java.awt.Color(153, 153, 153));
        txtProd_ID2.setText("Prod_ID (Use Numbers Only)");
        txtProd_ID2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txtProd_ID2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtProd_ID2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtProd_ID2FocusLost(evt);
            }
        });
        jPanel1.add(txtProd_ID2);
        txtProd_ID2.setBounds(460, 420, 350, 28);

        txtProd_Name2.setForeground(new java.awt.Color(153, 153, 153));
        txtProd_Name2.setText("Prod_Name");
        txtProd_Name2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txtProd_Name2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtProd_Name2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtProd_Name2FocusLost(evt);
            }
        });
        jPanel1.add(txtProd_Name2);
        txtProd_Name2.setBounds(460, 450, 350, 28);

        txtQty.setForeground(new java.awt.Color(153, 153, 153));
        txtQty.setText("Qty (Use Numbers Only)");
        txtQty.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txtQty.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtQtyFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtQtyFocusLost(evt);
            }
        });
        jPanel1.add(txtQty);
        txtQty.setBounds(460, 480, 350, 28);

        btnAdd2.setBackground(new java.awt.Color(255, 255, 255));
        btnAdd2.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 12)); // NOI18N
        btnAdd2.setForeground(new java.awt.Color(0, 0, 0));
        btnAdd2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-plus-20.png"))); // NOI18N
        btnAdd2.setText("ADD");
        btnAdd2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAdd2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdd2ActionPerformed(evt);
            }
        });
        jPanel1.add(btnAdd2);
        btnAdd2.setBounds(340, 530, 115, 30);

        btnDelete2.setBackground(new java.awt.Color(255, 255, 255));
        btnDelete2.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 12)); // NOI18N
        btnDelete2.setForeground(new java.awt.Color(0, 0, 0));
        btnDelete2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-delete-bin-20.png"))); // NOI18N
        btnDelete2.setText("DELETE");
        btnDelete2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDelete2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelete2ActionPerformed(evt);
            }
        });
        jPanel1.add(btnDelete2);
        btnDelete2.setBounds(460, 530, 115, 30);

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
        jSeparator1.setBounds(140, 410, 1020, 10);
        jPanel1.add(jSeparator2);
        jSeparator2.setBounds(140, 522, 1020, 10);

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
        jLabel1.setBounds(0, 0, 1300, 610);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAdd2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdd2ActionPerformed
        if(txtProd_ID2.getText().equals("")||txtProd_Name2.getText().equals("")||txtQty.getText().equals(""))
        JOptionPane.showMessageDialog(null,"Please fill in Blank spaces !!" + "\n For Stocks Table",  "STOCKS TABLE", JOptionPane.WARNING_MESSAGE);
        else{
            String data[] = {txtProd_ID2.getText(),txtProd_Name2.getText(),txtQty.getText()};

            DefaultTableModel tblModel = (DefaultTableModel)tblStocks.getModel();
            tblModel.addRow(data);
            ImageIcon Icon = new javax.swing.ImageIcon(getClass().getResource("/icons8-checked-60.png"));
            JOptionPane.showMessageDialog(null,"Added succefully to Stocks Table", "STOCKS TABLE", JOptionPane.PLAIN_MESSAGE, Icon);
            txtProd_ID2.setText("");
            txtProd_ID2.setText("Prod_ID");
            txtProd_ID2.setForeground(new Color(153,153,153));
            
            txtProd_Name2.setText("");
            txtProd_Name2.setText("Prod_Name");
            txtProd_Name2.setForeground(new Color(153,153,153));
            
            txtQty.setText("");
            txtQty.setText("Qty");
            txtQty.setForeground(new Color(153,153,153));
            
            mGetValues();
            mCheckIfItemsExistInTable();
            
            if(booleanRecordExist==true)
            {
                booleanRecordExist=false;
                JOptionPane.showMessageDialog(null,"Stock Info Already Exist");
            }
            else if(booleanRecordExist==false)
            {
                mInsertToStockTable();
            }
            
        }
       
    }//GEN-LAST:event_btnAdd2ActionPerformed

    private void btnDelete2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelete2ActionPerformed
        DefaultTableModel tblModel = (DefaultTableModel)tblStocks.getModel();
        if(tblStocks.getSelectedRowCount()==1){
            tblModel.removeRow(tblStocks.getSelectedRow());
            mDeleteFromTable();
            JOptionPane.showMessageDialog(null,"Deleted",  "STOCKS TABLE", JOptionPane.WARNING_MESSAGE);
        }else{
            if(tblStocks.getRowCount()==0){
                JOptionPane.showMessageDialog(null,"Nothing to Delete From Stocks Table", "STOCKS TABLE", JOptionPane.ERROR_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(null,"Select Row to Delete From Stocks Table", "STOCKS TABLE", JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnDelete2ActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        this.toBack();
        setVisible(false);
        new Reyavaya_Tech().toFront();
        new Reyavaya_Tech().setState(java.awt.Frame.NORMAL);
    }//GEN-LAST:event_btnBackActionPerformed

    private void txtProd_ID2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtProd_ID2FocusGained
       if(txtProd_ID2.getText().equals("Prod_ID (Use Numbers Only)"))
        {
            txtProd_ID2.setText("");
            txtProd_ID2.setForeground(new Color(51,51,51));
        }
    }//GEN-LAST:event_txtProd_ID2FocusGained

    private void txtProd_ID2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtProd_ID2FocusLost
        if(txtProd_ID2.getText().equals(""))
        {
            txtProd_ID2.setText("Prod_ID (Use Numbers Only)");
            txtProd_ID2.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_txtProd_ID2FocusLost

    private void txtProd_Name2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtProd_Name2FocusGained
        if(txtProd_Name2.getText().equals("Prod_Name"))
        {
            txtProd_Name2.setText("");
            txtProd_Name2.setForeground(new Color(51,51,51));
        }
    }//GEN-LAST:event_txtProd_Name2FocusGained

    private void txtProd_Name2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtProd_Name2FocusLost
        if(txtProd_Name2.getText().equals(""))
        {
            txtProd_Name2.setText("Prod_Name");
            txtProd_Name2.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_txtProd_Name2FocusLost

    private void txtQtyFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtQtyFocusGained
         if(txtQty.getText().equals("Qty (Use Numbers Only)"))
        {
            txtQty.setText("");
            txtQty.setForeground(new Color(51,51,51));
        }
    }//GEN-LAST:event_txtQtyFocusGained

    private void txtQtyFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtQtyFocusLost
        if(txtQty.getText().equals(""))
        {
            txtQty.setText("Qty (Use Numbers Only)");
            txtQty.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_txtQtyFocusLost

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        mUpdateTostockTable();
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
            java.util.logging.Logger.getLogger(Reyavaya_Tech4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Reyavaya_Tech4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Reyavaya_Tech4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Reyavaya_Tech4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Reyavaya_Tech4().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd2;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnDelete2;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable tblStocks;
    private javax.swing.JTextField txtProd_ID2;
    private javax.swing.JTextField txtProd_Name2;
    private javax.swing.JTextField txtQty;
    // End of variables declaration//GEN-END:variables


}
