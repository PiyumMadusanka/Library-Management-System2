package Lbs;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class Books extends javax.swing.JFrame {

    public Books() {
        initComponents();
        getAllBooks();
        setPermission();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_edit = new javax.swing.JButton();
        btn_add = new javax.swing.JButton();
        btn_reload = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btn_view = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_books = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(890, 650));
        setResizable(false);
        getContentPane().setLayout(null);

        btn_edit.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_edit.setText("Edit Book");
        btn_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editActionPerformed(evt);
            }
        });
        getContentPane().add(btn_edit);
        btn_edit.setBounds(645, 55, 100, 30);

        btn_add.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_add.setText("Add Book");
        btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addActionPerformed(evt);
            }
        });
        getContentPane().add(btn_add);
        btn_add.setBounds(750, 55, 100, 30);

        btn_reload.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_reload.setText("Reload");
        btn_reload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_reloadActionPerformed(evt);
            }
        });
        getContentPane().add(btn_reload);
        btn_reload.setBounds(435, 55, 100, 30);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Books");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 10, 864, 40);

        btn_view.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_view.setText("View Book");
        btn_view.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_viewActionPerformed(evt);
            }
        });
        getContentPane().add(btn_view);
        btn_view.setBounds(540, 55, 100, 30);

        tbl_books.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Book Code", "Book Name", "Category", "Add Date", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbl_books);
        if (tbl_books.getColumnModel().getColumnCount() > 0) {
            tbl_books.getColumnModel().getColumn(0).setResizable(false);
            tbl_books.getColumnModel().getColumn(0).setPreferredWidth(0);
        }

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(30, 90, 820, 470);

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Lbs/background_image.jpg"))); // NOI18N
        getContentPane().add(jLabel10);
        jLabel10.setBounds(-30, -100, 950, 850);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
        new EnterBook().setVisible(true);
    }//GEN-LAST:event_btn_addActionPerformed

    private void btn_reloadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_reloadActionPerformed
        getAllBooks();
    }//GEN-LAST:event_btn_reloadActionPerformed

    private void btn_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editActionPerformed
        updateOrViewBook("EDIT");
    }//GEN-LAST:event_btn_editActionPerformed

    private void btn_viewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_viewActionPerformed
        updateOrViewBook("VIEW");
    }//GEN-LAST:event_btn_viewActionPerformed

    private void getAllBooks() {

        tbl_books.removeAll();
        DatabaseCon databaseCon = new DatabaseCon();
        DefaultTableModel model = (DefaultTableModel) tbl_books.getModel();
        model.setRowCount(0);
        ArrayList list = databaseCon.getAllBooksFromDB();
        list.forEach(item -> {
            model.addRow((Object[]) item);
        });

    }

    private void updateOrViewBook(String type) {

        if (!tbl_books.getSelectionModel().isSelectionEmpty()) {

            EnterBook enterBook = new EnterBook();
            int selectedRow = tbl_books.getSelectedRow();
            TableModel model = tbl_books.getModel();
            enterBook.setUpdateBookData(
                    Integer.valueOf(model.getValueAt(selectedRow, 0).toString()),
                    model.getValueAt(selectedRow, 1).toString(),
                    model.getValueAt(selectedRow, 2).toString(),
                    model.getValueAt(selectedRow, 3).toString(),
                    type
            );
            enterBook.setVisible(true);

        } else {
            JOptionPane.showMessageDialog(null, "Please select the book!", "ERROR", 2);
        }
    }

    private void setPermission() {
        LoggedUser loggedUser = new LoggedUser();
        if (loggedUser.getLoginUser().role.equals("Student")) {
            btn_add.setEnabled(false);
            btn_edit.setEnabled(false);
        }
    }

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
            java.util.logging.Logger.getLogger(Books.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Books.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Books.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Books.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Books().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_add;
    private javax.swing.JButton btn_edit;
    private javax.swing.JButton btn_reload;
    private javax.swing.JButton btn_view;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_books;
    // End of variables declaration//GEN-END:variables
}