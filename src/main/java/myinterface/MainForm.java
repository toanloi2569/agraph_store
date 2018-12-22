/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myinterface;

import com.franz.agraph.repository.AGRepositoryConnection;
import java.awt.Dimension;
import filereader.QueryReader;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import setting.Setting;
import setting.StructQuery;
import connection.*;
import static main.Main.calTime;
import static main.Main.conn;
import static main.Main.creatRepository;
import static main.Main.databaseConnecter;
import static main.Main.password;
import static main.Main.severURL;
import static main.Main.user;
import org.eclipse.rdf4j.model.Value;
import org.eclipse.rdf4j.query.BindingSet;
import org.eclipse.rdf4j.query.TupleQueryResult;
import query.Query;
import time.CalTime;

/**
 *
 * @author manh_vu
 */
public class MainForm extends javax.swing.JFrame {

    ArrayList<StructQuery> listNormalQuery;
    ArrayList<StructQuery> listAdvancedQuery;
    QueryReader reader = new QueryReader();

    /**
     * Creates new form MainForm
     */
    public MainForm() {
        initComponents();
        DatabaseConnecter databaseConnecter = DatabaseConnecter.getDatabaseConnecter(severURL, user, password);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        comboChooseStatement = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        queryStatement = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        resultQuery = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        queryRun = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        basicQuery = new javax.swing.JRadioButton();
        advancedQuery = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        comboChooseDB = new javax.swing.JComboBox<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        nameQuery = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        comboChooseStatement.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        comboChooseStatement.setForeground(new java.awt.Color(0, 51, 204));
        comboChooseStatement.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "query 1 ", "query 2 ", "query 3 ", "query 4 ", "query 5 ", "query 6 ", "query 7 ", "query 8 ", "query 9 ", "query 10 " }));
        comboChooseStatement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboChooseStatementActionPerformed(evt);
            }
        });

        queryStatement.setColumns(20);
        queryStatement.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        queryStatement.setLineWrap(true);
        queryStatement.setRows(5);
        queryStatement.setWrapStyleWord(true);
        jScrollPane1.setViewportView(queryStatement);

        resultQuery.setColumns(20);
        resultQuery.setLineWrap(true);
        resultQuery.setRows(5);
        resultQuery.setWrapStyleWord(true);
        jScrollPane2.setViewportView(resultQuery);

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 51, 204));
        jLabel3.setText("Query Statement");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 51, 204));
        jLabel2.setText("Select query type");

        queryRun.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        queryRun.setForeground(new java.awt.Color(0, 51, 204));
        queryRun.setIcon(new javax.swing.ImageIcon("/home/manh_vu/agraph_store/src/main/icon/run.png")); // NOI18N
        queryRun.setText("Query");
        queryRun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                queryRunActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 51, 204));
        jLabel4.setText("Select query statement");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        buttonGroup1.add(basicQuery);
        basicQuery.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        basicQuery.setForeground(new java.awt.Color(0, 51, 204));
        basicQuery.setSelected(true);
        basicQuery.setText("Basic Query");
        basicQuery.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                basicQueryActionPerformed(evt);
            }
        });

        buttonGroup1.add(advancedQuery);
        advancedQuery.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        advancedQuery.setForeground(new java.awt.Color(0, 51, 204));
        advancedQuery.setText("Advanced Query");

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 51, 204));
        jLabel5.setText("Select database");

        comboChooseDB.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        comboChooseDB.setForeground(new java.awt.Color(0, 51, 204));
        comboChooseDB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "100_entity_200_relation", "5000_entity_7000_relation", "60000_entity_80000_relation", "100000_entity_200000_relation", "500000_entity_1000000_relation" }));

        nameQuery.setColumns(20);
        nameQuery.setFont(new java.awt.Font("Dialog", 2, 14)); // NOI18N
        nameQuery.setLineWrap(true);
        nameQuery.setRows(5);
        nameQuery.setWrapStyleWord(true);
        jScrollPane3.setViewportView(nameQuery);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4)
                                    .addComponent(comboChooseDB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(31, 31, 31)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(advancedQuery)
                                            .addComponent(basicQuery)))
                                    .addComponent(comboChooseStatement, 0, 313, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(queryRun)
                                .addGap(146, 146, 146))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1065, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)))
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {comboChooseDB, comboChooseStatement});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(basicQuery)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(advancedQuery)
                        .addGap(39, 39, 39)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboChooseDB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboChooseStatement, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(queryRun)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {comboChooseDB, comboChooseStatement});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void basicQueryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_basicQueryActionPerformed

    }//GEN-LAST:event_basicQueryActionPerformed

    private void comboChooseStatementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboChooseStatementActionPerformed
        listNormalQuery = reader.getListNormalQuery();
        listAdvancedQuery = reader.getListAdvancedQuery();
        if (basicQuery.isSelected()) {
            for (int i = 0; i < 10; i++) {
                if (comboChooseStatement.getSelectedIndex() == i) {
                    nameQuery.setText(listNormalQuery.get(i).Description);
                    queryStatement.setText(listNormalQuery.get(i).Query);
                }
            }
        } else if (advancedQuery.isSelected()) {
            for (int i = 0; i < 10; i++) {
                if (comboChooseStatement.getSelectedIndex() == i) {
                    nameQuery.setText(listAdvancedQuery.get(i).Description);
                    queryStatement.setText(listAdvancedQuery.get(i).Query);
                }
            }
        }
    }//GEN-LAST:event_comboChooseStatementActionPerformed
    

    private void queryRunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_queryRunActionPerformed
        AGRepositoryConnection conn = null;        
        
        if (comboChooseDB.getSelectedIndex() == 0) {
            conn = databaseConnecter.getConnection("100_entity_200_relation");                        
        }else if(comboChooseDB.getSelectedIndex()==1){
            conn = databaseConnecter.getConnection("5000_entity_7000_relation");
        }else if(comboChooseDB.getSelectedIndex()==2){
            conn = databaseConnecter.getConnection("60000_entity_80000_relation");
        }else if(comboChooseDB.getSelectedIndex()==3){
            conn = databaseConnecter.getConnection("100000_entity_200000_relation");
        }else if(comboChooseDB.getSelectedIndex()==4){
            conn = databaseConnecter.getConnection("500000_entity_1000000_relation");
        }
        
        Query query =new Query(conn);
        TupleQueryResult result = query.getResult(queryStatement.getText(), conn);
        resultQuery.setText(query.printRows(result));
        databaseConnecter.closeConnection();
    }//GEN-LAST:event_queryRunActionPerformed

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
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                MainForm myInterface = new MainForm();
                myInterface.setVisible(true);
                myInterface.setTitle("OOP Project");
                myInterface.setLocation(200, 100);
                myInterface.setPreferredSize(new Dimension(2000, 1000));

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton advancedQuery;
    private javax.swing.JRadioButton basicQuery;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> comboChooseDB;
    private javax.swing.JComboBox<String> comboChooseStatement;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea nameQuery;
    private javax.swing.JButton queryRun;
    private javax.swing.JTextArea queryStatement;
    private javax.swing.JTextArea resultQuery;
    // End of variables declaration//GEN-END:variables
}
