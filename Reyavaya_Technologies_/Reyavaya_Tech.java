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
public class Reyavaya_Tech extends javax.swing.JFrame {
    public Reyavaya_Tech2 reyavayatech2;
    public Reyavaya_Tech3 reyavayatech3;
    public Reyavaya_Tech4 reyavayatech4;
    public Reyavaya_Tech5 reyavayatech5;
    public Reyavaya_Tech6 reyavayatech6;

    /**
     * Creates new form Reyavaya_Tech
     */
    public Reyavaya_Tech() {
        
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/50, dim.height/30);
        
        initComponents();
        reyavayatech2 = new Reyavaya_Tech2();
        reyavayatech3 = new Reyavaya_Tech3();
        reyavayatech4 = new Reyavaya_Tech4();
        reyavayatech5 = new Reyavaya_Tech5();
        reyavayatech6 = new Reyavaya_Tech6();
        //Reyavayalogin = new Reyavaya_Login();
        
        
        setIconImage();
        fileMenu();
        JMenuBarEvents();
    }
    
    private void setIconImage(){
    setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icons8-motherboard-100.png"))); 
}
    //File Menu
    javax.swing.JMenuBar mbMenuBar = new javax.swing.JMenuBar();
    javax.swing.JMenu mMenu = new javax.swing.JMenu("File");
    
    javax.swing.JMenuItem mMenuSupplier = new javax.swing.JMenuItem("'Supplier' Catalogue");
    javax.swing.JMenuItem mMenuPurchase = new javax.swing.JMenuItem("'Purchase' Catalogue");
    javax.swing.JMenuItem mMenuStocks = new javax.swing.JMenuItem("'Stocks' Catalogue");
    javax.swing.JMenuItem mMenuCustomer = new javax.swing.JMenuItem("'Customer' Catalogue");
    javax.swing.JMenuItem mMenuSales = new javax.swing.JMenuItem("'Sales' Catalogue");
    javax.swing.JMenuItem mMenuAbout = new javax.swing.JMenuItem("About");

    javax.swing.JMenuItem mMenuExit = new javax.swing.JMenuItem("Exit Application");
    
    private void fileMenu(){
        
        mMenu.add(mMenuSupplier);
        mMenu.add(mMenuPurchase);
        mMenu.add(mMenuStocks);
        mMenu.add(mMenuCustomer);
        mMenu.add(mMenuSales);
        mMenu.add(mMenuAbout);
        
        mMenu.add(mMenuExit);
        
        mbMenuBar.add(mMenu);
        
        this.setJMenuBar(mbMenuBar);
    }
    
    private void JMenuBarEvents(){
       
        mMenuSupplier.addActionListener( new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
            
            reyavayatech2.setVisible(true);
            reyavayatech2.toFront();          
                        
            }
        });
        
        mMenuPurchase.addActionListener( new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
            
            reyavayatech3.setVisible(true);
            reyavayatech3.toFront();
            
            }
        });
        
        mMenuStocks.addActionListener( new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
            
            reyavayatech4.setVisible(true);
            reyavayatech4.toFront();
            
            }
        });
        
         mMenuCustomer.addActionListener( new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
            
            reyavayatech5.setVisible(true);
            reyavayatech5.toFront();
            
            }
        });
         
         mMenuSales.addActionListener( new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
            
            reyavayatech6.setVisible(true);
            reyavayatech6.toFront();
            
            }
        });
        
        
         mMenuExit.addActionListener( new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
            ImageIcon Icon = new javax.swing.ImageIcon(getClass().getResource("/Exit1.png"));
        int response = JOptionPane.showConfirmDialog(null,"Do you want to Exit Application? " , "CONFIRM", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, Icon);
        if(response== JOptionPane.YES_NO_OPTION){
            System.exit(0);
        }
        else if(response== JOptionPane.NO_OPTION){
            setVisible(true);
        }
            }
        });
         
        mMenuAbout.addActionListener( new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                ImageIcon Icon = new javax.swing.ImageIcon(getClass().getResource("/ReyavayaAbout.png"));
                JOptionPane.showMessageDialog(null,"Reyavaya is a computer store \n"
                        + "That sells hardware \n"
                        + "Reyavaya Technologies supplies You \n"
                        + "With anything regarding \n"
                        + "Computer Hardware \n \n"
                        + "WE OFFER THE BEST COMPUTER HARDWARE \n"
                        + "Est.2020", " ABOUT REYAVAYA", JOptionPane.PLAIN_MESSAGE, Icon);
            }
        });
        
    }
    
    Boolean booleanRecordExist = false;
    String strProd_id = null;
    String strProd_Name = null;
    String strBrand = null;
    String strSupp_name = null;
    String strPurchase_price = null;
    String strSelling_price = null;
    
    private void mGetValues()
    {
        strProd_id = txtID.getText();
        strProd_Name = txtProdName.getText();
        strBrand = txtBrand.getText();
        strSupp_name = txtSuppName.getText();
        strPurchase_price = txtPurchase.getText();
        strSelling_price = txtSelling.getText();
    }
    //I was last here dawq
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
            String strQuery = "Select * From products where Prod_id='" + strProd_id + "'and Prod_Name='" + strProd_Name + "'and Brand='" + strBrand + "'and Supp_Name='" + strSupp_name + "'and Purchase_price='" + strPurchase_price + "'and Selling_prie='" + strSelling_price+"'";
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
    private void mInsertToProductsTable()
    {
        java.sql.Connection conMySQLConnectionString = null;
        String URL = "jdbc:mysql://127.0.0.1:3306/Reyavaya_technologies";
        String User = "root";
        String Password = "Daniel_25042577_Khoza";
        try
        {
            conMySQLConnectionString = DriverManager.getConnection(URL,User,Password);
            Statement myStatement = conMySQLConnectionString.createStatement();
            String sqlinsert = "insert into products" + "(Prod_id,Prod_Name,Brand,Supp_Name,Purchase_price,Selling_price)" + "Value('"+strProd_id+"', '"+strProd_Name+"', '"+strBrand+"', '"+strSupp_name+"', '"+strPurchase_price+"', '"+strSelling_price+"')";
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
            String strQuery = "Delete * From products where Prod_id='" + strProd_id + "'and Prod_Name='" + strProd_Name + "'and Brand='" + strBrand + "'and Supp_Name='" + strSupp_name + "'and Purchase_price='" + strPurchase_price + "'and Selling_prie='" + strSelling_price+"'";
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
    private void mUpdateToProductsTable()
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
            String sqlinsert = "Update products SET Prod_id='"+strProd_id+"', + Prod_Name='"+strProd_Name+"'Brand='"+strBrand+"'Supp_Name='"+strSupp_name+"'Purchase_price='"+strPurchase_price+"'Selling_prie='"+strSelling_price+"'";
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
        ResultSet rsProducts = null;
        String strSQLQuery;
        
        try
        {
            conMySQLConnectionString = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Reyavaya_technologies", "root", "Daniel_25042577_Khoza");
            strSQLQuery = "Select * from products";
            rsProducts = stSQLQuery.executeQuery(strSQLQuery);
            ResultSetMetaData rsmt = rsProducts.getMetaData();
            int intColumnCount = rsmt.getColumnCount();
            Vector vColumn = new Vector(intColumnCount);
            
            for(int i=1; i<intColumnCount; i++)
            {
                vColumn.add(rsmt.getColumnName(i));
            }
            
            Vector vData = new Vector();
            Vector vRow = new Vector();
            
            while(rsProducts.next())
            {
                vRow = new Vector(intColumnCount);
                
                for(int i=1; 1<=intColumnCount; i++)
                {
                    vRow.add(rsProducts.getString(i));
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
            JTable tblProducts = new JTable(vData,vColumn);
            JScrollPane jspProductsPane = new JScrollPane(tblProducts);
            pnlTable.setLayout(new BorderLayout());
            pnlTable.add(jspProductsPane, BorderLayout.CENTER);
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
                rsProducts.close();
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
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblProducts = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        txtSelling = new javax.swing.JTextField();
        txtPurchase = new javax.swing.JTextField();
        txtSuppName = new javax.swing.JTextField();
        txtBrand = new javax.swing.JTextField();
        txtID = new javax.swing.JTextField();
        txtProdName = new javax.swing.JTextField();
        btnADD = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnView = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        btnUpdate = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("REYAVAYA TECHNOLOGIES");
        setResizable(false);

        jPanel1.setLayout(null);

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Arial Rounded MT Bold", 3, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("REYAVAYA TECH");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(480, 0, 370, 40);

        tblProducts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Prod_id", "Prod_Name", "Brand", "Supp_name", "Purchased_price", "Selling_price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblProducts.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tblProducts.setGridColor(new java.awt.Color(0, 0, 0));
        jScrollPane2.setViewportView(tblProducts);
        if (tblProducts.getColumnModel().getColumnCount() > 0) {
            tblProducts.getColumnModel().getColumn(0).setResizable(false);
            tblProducts.getColumnModel().getColumn(1).setResizable(false);
            tblProducts.getColumnModel().getColumn(2).setResizable(false);
            tblProducts.getColumnModel().getColumn(3).setResizable(false);
            tblProducts.getColumnModel().getColumn(4).setResizable(false);
            tblProducts.getColumnModel().getColumn(5).setResizable(false);
        }

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(200, 80, 910, 330);

        jLabel3.setFont(new java.awt.Font("Arial Rounded MT Bold", 3, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("PRODUCTS");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(590, 50, 120, 30);

        txtSelling.setForeground(new java.awt.Color(153, 153, 153));
        txtSelling.setText("Selling_price (Use Numbers Only)");
        txtSelling.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txtSelling.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtSellingFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSellingFocusLost(evt);
            }
        });
        txtSelling.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSellingActionPerformed(evt);
            }
        });
        jPanel1.add(txtSelling);
        txtSelling.setBounds(700, 490, 350, 28);

        txtPurchase.setForeground(new java.awt.Color(153, 153, 153));
        txtPurchase.setText("Purchase_price (Use Numbers Only)");
        txtPurchase.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txtPurchase.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPurchaseFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPurchaseFocusLost(evt);
            }
        });
        jPanel1.add(txtPurchase);
        txtPurchase.setBounds(700, 460, 350, 28);

        txtSuppName.setForeground(new java.awt.Color(153, 153, 153));
        txtSuppName.setText("Supp_Name");
        txtSuppName.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txtSuppName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtSuppNameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSuppNameFocusLost(evt);
            }
        });
        jPanel1.add(txtSuppName);
        txtSuppName.setBounds(700, 430, 350, 28);

        txtBrand.setForeground(new java.awt.Color(153, 153, 153));
        txtBrand.setText("Brand");
        txtBrand.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txtBrand.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtBrandFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtBrandFocusLost(evt);
            }
        });
        txtBrand.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBrandActionPerformed(evt);
            }
        });
        jPanel1.add(txtBrand);
        txtBrand.setBounds(240, 490, 350, 28);

        txtID.setForeground(new java.awt.Color(153, 153, 153));
        txtID.setText("Prod_ID (Use Numbers Only)");
        txtID.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txtID.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtIDFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtIDFocusLost(evt);
            }
        });
        txtID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDActionPerformed(evt);
            }
        });
        jPanel1.add(txtID);
        txtID.setBounds(240, 430, 350, 28);

        txtProdName.setForeground(new java.awt.Color(153, 153, 153));
        txtProdName.setText("Prod_Name");
        txtProdName.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txtProdName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtProdNameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtProdNameFocusLost(evt);
            }
        });
        txtProdName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProdNameActionPerformed(evt);
            }
        });
        jPanel1.add(txtProdName);
        txtProdName.setBounds(240, 460, 350, 28);

        btnADD.setBackground(new java.awt.Color(255, 255, 255));
        btnADD.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 12)); // NOI18N
        btnADD.setForeground(new java.awt.Color(0, 0, 0));
        btnADD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-plus-20.png"))); // NOI18N
        btnADD.setText("ADD");
        btnADD.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnADD.setHideActionText(true);
        btnADD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnADDActionPerformed(evt);
            }
        });
        jPanel1.add(btnADD);
        btnADD.setBounds(360, 540, 115, 30);

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
        btnDelete.setBounds(480, 540, 115, 30);

        btnView.setBackground(new java.awt.Color(255, 255, 255));
        btnView.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 12)); // NOI18N
        btnView.setForeground(new java.awt.Color(0, 0, 0));
        btnView.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-database-view-20.png"))); // NOI18N
        btnView.setText("VIEW");
        btnView.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewActionPerformed(evt);
            }
        });
        jPanel1.add(btnView);
        btnView.setBounds(720, 540, 115, 30);

        btnBack.setBackground(new java.awt.Color(255, 255, 255));
        btnBack.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 12)); // NOI18N
        btnBack.setForeground(new java.awt.Color(0, 0, 0));
        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Exit.png"))); // NOI18N
        btnBack.setText("LOG OUT");
        btnBack.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        jPanel1.add(btnBack);
        btnBack.setBounds(840, 540, 130, 30);
        jPanel1.add(jSeparator1);
        jSeparator1.setBounds(140, 420, 1030, 10);
        jPanel1.add(jSeparator2);
        jSeparator2.setBounds(140, 530, 1030, 10);

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
        btnUpdate.setBounds(600, 540, 115, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Background.png"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 1300, 620);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1299, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 611, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtProdNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProdNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtProdNameActionPerformed

    private void txtIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDActionPerformed

    private void btnADDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnADDActionPerformed
        if(txtID.getText().equals("")||txtProdName.getText().equals("")||txtBrand.getText().equals("")||txtSuppName.getText().equals("")||txtPurchase.getText().equals("")||txtSelling.getText().equals(""))
            JOptionPane.showMessageDialog(null,"Please fill in Blank spaces !!" + "\n For Products Table", "PRODUCTS TABLE", JOptionPane.WARNING_MESSAGE);
            
        else{
            String data[] = {txtID.getText(),txtProdName.getText(),txtBrand.getText(),txtSuppName.getText(),txtPurchase.getText(),txtSelling.getText()};
            
            DefaultTableModel tblModel = (DefaultTableModel)tblProducts.getModel();
            tblModel.addRow(data);
            ImageIcon Icon = new javax.swing.ImageIcon(getClass().getResource("/icons8-checked-60.png"));
            JOptionPane.showMessageDialog(null,"Added succefully to Products Table", "PRODUCTS TABLE", JOptionPane.PLAIN_MESSAGE, Icon);
            
            //This already clears texts no need for clear text method
            txtID.setText("");
            txtID.setText("Prod_ID");
            txtID.setForeground(new Color(153,153,153));
            
            txtProdName.setText("");
            txtProdName.setText("Prod_Name");
            txtProdName.setForeground(new Color(153,153,153));
            
            txtBrand.setText("");
            txtBrand.setText("Brand");
            txtBrand.setForeground(new Color(153,153,153));
            
            txtSuppName.setText("");
            txtSuppName.setText("Supp_Name");
            txtSuppName.setForeground(new Color(153,153,153));
            
            txtPurchase.setText("");
            txtPurchase.setText("Purchase_price");
            txtPurchase.setForeground(new Color(153,153,153));
            
            txtSelling.setText("");
            txtSelling.setText("Selling_price");
            txtSelling.setForeground(new Color(153,153,153));
            
            //call database methods
            
            mGetValues();
            mCheckIfItemsExistInTable();
            
            if(booleanRecordExist==true)
            {
                booleanRecordExist=false;
                JOptionPane.showMessageDialog(null,"Product Info Already Exist");
            }
            else if(booleanRecordExist==false)
            {
                mInsertToProductsTable();
            }            
        }
        
        
    }//GEN-LAST:event_btnADDActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
       
        DefaultTableModel tblModel = (DefaultTableModel)tblProducts.getModel();
        if(tblProducts.getSelectedRowCount()==1){
            tblModel.removeRow(tblProducts.getSelectedRow());
            //call delete method 
            mDeleteFromTable();
            JOptionPane.showMessageDialog(null,"Deleted", "PRODUCTS TABLE", JOptionPane.WARNING_MESSAGE);
        }else{
            if(tblProducts.getRowCount()==0){
               JOptionPane.showMessageDialog(null,"Nothing to Delete From Products Table", "PRODUCTS TABLE", JOptionPane.ERROR_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(null,"Select Row to Delete From Products Table", "PRODUCTS TABLE", JOptionPane.WARNING_MESSAGE);
            }
        }  
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void txtSellingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSellingActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSellingActionPerformed

    private void btnViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewActionPerformed
        mViewFromDatabase();
    }//GEN-LAST:event_btnViewActionPerformed

    private void txtBrandActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBrandActionPerformed
       
    }//GEN-LAST:event_txtBrandActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        
        ImageIcon Icon = new javax.swing.ImageIcon(getClass().getResource("/Exit1.png"));
        int response = JOptionPane.showConfirmDialog(null,"Do you want to Exit Application? " , "CONFIRM", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, Icon);
        if(response== JOptionPane.YES_NO_OPTION){
            System.exit(0);
        }
        else if(response== JOptionPane.NO_OPTION){
            setVisible(true);
        }
        
    }//GEN-LAST:event_btnBackActionPerformed

    private void txtProdNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtProdNameFocusGained
        if(txtProdName.getText().equals("Prod_Name"))
        {
            txtProdName.setText("");
            txtProdName.setForeground(new Color(51,51,51));
        }
    }//GEN-LAST:event_txtProdNameFocusGained

    private void txtProdNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtProdNameFocusLost
        if(txtProdName.getText().equals(""))
        {
            txtProdName.setText("Prod_Name");
            txtProdName.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_txtProdNameFocusLost

    private void txtIDFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtIDFocusGained
        if(txtID.getText().equals("Prod_ID (Use Numbers Only)"))
        {
            txtID.setText("");
            txtID.setForeground(new Color(51,51,51));
        }
    }//GEN-LAST:event_txtIDFocusGained

    private void txtIDFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtIDFocusLost
        if(txtID.getText().equals(""))
        {
            txtID.setText("Prod_ID (Use Numbers Only)");
            txtID.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_txtIDFocusLost

    private void txtBrandFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBrandFocusGained
        if(txtBrand.getText().equals("Brand"))
        {
            txtBrand.setText("");
            txtBrand.setForeground(new Color(51,51,51));
        }
    }//GEN-LAST:event_txtBrandFocusGained

    private void txtBrandFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBrandFocusLost
        if(txtBrand.getText().equals(""))
        {
            txtBrand.setText("Brand");
            txtBrand.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_txtBrandFocusLost

    private void txtSuppNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSuppNameFocusGained
        if(txtSuppName.getText().equals("Supp_Name"))
        {
            txtSuppName.setText("");
            txtSuppName.setForeground(new Color(51,51,51));
        }
    }//GEN-LAST:event_txtSuppNameFocusGained

    private void txtSuppNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSuppNameFocusLost
         if(txtSuppName.getText().equals(""))
        {
            txtSuppName.setText("Supp_Name");
            txtSuppName.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_txtSuppNameFocusLost

    private void txtPurchaseFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPurchaseFocusGained
       if(txtPurchase.getText().equals("Purchase_price (Use Numbers Only)"))
        {
            txtPurchase.setText("");
            txtPurchase.setForeground(new Color(51,51,51));
        }
    }//GEN-LAST:event_txtPurchaseFocusGained

    private void txtPurchaseFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPurchaseFocusLost
         if(txtPurchase.getText().equals(""))
        {
            txtPurchase.setText("Purchase_price (Use Numbers Only)");
            txtPurchase.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_txtPurchaseFocusLost

    private void txtSellingFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSellingFocusGained
        if(txtSelling.getText().equals("Selling_price (Use Numbers Only)"))
        {
            txtSelling.setText("");
            txtSelling.setForeground(new Color(51,51,51));
        }
    }//GEN-LAST:event_txtSellingFocusGained

    private void txtSellingFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSellingFocusLost
         if(txtSelling.getText().equals(""))
        {
            txtSelling.setText("Selling_price (Use Numbers Only)");
            txtSelling.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_txtSellingFocusLost

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        mUpdateToProductsTable();
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
            java.util.logging.Logger.getLogger(Reyavaya_Tech.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Reyavaya_Tech.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Reyavaya_Tech.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Reyavaya_Tech.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Reyavaya_Tech().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnADD;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton btnView;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable tblProducts;
    private javax.swing.JTextField txtBrand;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtProdName;
    private javax.swing.JTextField txtPurchase;
    private javax.swing.JTextField txtSelling;
    private javax.swing.JTextField txtSuppName;
    // End of variables declaration//GEN-END:variables

    private void close() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }




}
