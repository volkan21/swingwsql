/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package volkan2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author volkan
 */
public class Demo extends javax.swing.JFrame {
    DefaultTableModel model;

    /**
     * Creates new form Demo
     */
    public Demo() {
        initComponents();
        populatetable();
      
    }
    public void populatetable(){
          model=(DefaultTableModel)tblcities.getModel();
           model.setRowCount(0);// modeli temizliyoruz
        try {
            ArrayList<City> cities=getcities();
            for(City city:cities) {
                Object [] row={city.getId(),city.getName(),city.getCountrycode(),city.getDistrict(),city.getPopulation()};
                   
                model.addRow(row);
               
            }
            
        } catch (SQLException ex) {
            
        }
        
    }
    public ArrayList<City> getcities() throws SQLException{
        Connection connect=null;
       DbHelper dbhelper=new DbHelper();
        Statement state=null;
        ResultSet result;
         ArrayList<City> cities=null;
        try {
            connect=dbhelper.getconnect();
            state=connect.createStatement();
            result=state.executeQuery("select *from city");
            cities=new ArrayList<City>();
            while(result.next()) {
                cities.add(new City(result.getInt("ID"),
                        result.getString("Name"),
                        result.getString("CountryCode"),
                        result.getString("District"),
                        result.getInt("Population")));
                
            }
        }catch(SQLException ex){
            dbhelper.showhata(ex);
            
        } finally {
            connect.close();
            state.close();
        }
        return cities;
        
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblcities = new javax.swing.JTable();
        txtsearch = new javax.swing.JTextField();
        lblsearch = new javax.swing.JLabel();
        lblname = new javax.swing.JLabel();
        lblcountrycode = new javax.swing.JLabel();
        lbldistrict = new javax.swing.JLabel();
        lblpopulation = new javax.swing.JLabel();
        tbxname = new javax.swing.JTextField();
        tbxcountrycode = new javax.swing.JTextField();
        tbxdistrict = new javax.swing.JTextField();
        tbxpopulation = new javax.swing.JTextField();
        btnadd = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblcities.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Name", "CountryCode", "District", "Population"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblcities);
        if (tblcities.getColumnModel().getColumnCount() > 0) {
            tblcities.getColumnModel().getColumn(0).setResizable(false);
            tblcities.getColumnModel().getColumn(1).setResizable(false);
            tblcities.getColumnModel().getColumn(2).setResizable(false);
            tblcities.getColumnModel().getColumn(3).setResizable(false);
            tblcities.getColumnModel().getColumn(4).setResizable(false);
        }

        txtsearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtsearchKeyReleased(evt);
            }
        });

        lblsearch.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblsearch.setText("Search:");

        lblname.setText("Name:");

        lblcountrycode.setText("CountryCode:");

        lbldistrict.setText("District:");

        lblpopulation.setText("Population");

        btnadd.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnadd.setText("Ekle");
        btnadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addComponent(lblsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblname, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblcountrycode))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tbxcountrycode, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tbxname, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 151, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(lblpopulation, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
                    .addComponent(lbldistrict, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tbxdistrict, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tbxpopulation, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(108, 108, 108))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnadd)
                .addGap(126, 126, 126))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblsearch)
                    .addComponent(txtsearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblname)
                    .addComponent(lbldistrict)
                    .addComponent(tbxname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tbxdistrict, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tbxpopulation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblpopulation))
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblcountrycode, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tbxcountrycode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)))
                .addComponent(btnadd)
                .addGap(29, 29, 29))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtsearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtsearchKeyReleased
        // TODO add your handling code here:
        String searchkey=txtsearch.getText();
        TableRowSorter<DefaultTableModel> tablerowsorter=new TableRowSorter<DefaultTableModel>(model);
        tblcities.setRowSorter(tablerowsorter);
        tablerowsorter.setRowFilter(RowFilter.regexFilter(searchkey));
    }//GEN-LAST:event_txtsearchKeyReleased

    private void btnaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddActionPerformed
        // TODO add your handling code here:
          Connection connect=null;
       DbHelper dbhelper=new DbHelper();
      PreparedStatement statement=null;
       try {
           connect=dbhelper.getconnect();
           String sql="insert into city(Name,CountryCode,District,Population) values(?,?,?,?)";
           statement=connect.prepareStatement(sql);
           statement.setString(1,tbxname.getText());
            statement.setString(2,tbxcountrycode.getText());
            statement.setString(3,tbxdistrict.getText());
            statement.setInt(4,Integer.valueOf(tbxpopulation.getText()));
            int result=statement.executeUpdate();
            populatetable();
           
       }catch(SQLException ex) {
           dbhelper.showhata(ex);
       }
       finally {
              try {
                  statement.close();
              } catch (SQLException ex) {
                  
              }
              try {
                  connect.close();
              } catch (SQLException ex) {
                 
              }
       }
    }//GEN-LAST:event_btnaddActionPerformed

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
            java.util.logging.Logger.getLogger(Demo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Demo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Demo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Demo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Demo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnadd;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblcountrycode;
    private javax.swing.JLabel lbldistrict;
    private javax.swing.JLabel lblname;
    private javax.swing.JLabel lblpopulation;
    private javax.swing.JLabel lblsearch;
    private javax.swing.JTable tblcities;
    private javax.swing.JTextField tbxcountrycode;
    private javax.swing.JTextField tbxdistrict;
    private javax.swing.JTextField tbxname;
    private javax.swing.JTextField tbxpopulation;
    private javax.swing.JTextField txtsearch;
    // End of variables declaration//GEN-END:variables
}
