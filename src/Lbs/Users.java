package Lbs;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class Users extends javax.swing.JFrame {

    int logedUserId = 0;

    public Users() {
        initComponents();
        getAllUsers();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_edit = new javax.swing.JButton();
        btn_add = new javax.swing.JButton();
        btn_reload = new javax.swing.JButton();
        btn_view = new javax.swing.JButton();
        lbl_heading = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_users = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(890, 650));
        setResizable(false);
        getContentPane().setLayout(null);

        btn_edit.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_edit.setText("Edit User");
        btn_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editActionPerformed(evt);
            }
        });
        getContentPane().add(btn_edit);
        btn_edit.setBounds(645, 55, 100, 30);

        btn_add.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_add.setText("Add User");
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

        btn_view.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_view.setText("View User");
        btn_view.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_viewActionPerformed(evt);
            }
        });
        getContentPane().add(btn_view);
        btn_view.setBounds(540, 55, 100, 30);

        lbl_heading.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lbl_heading.setForeground(new java.awt.Color(0, 51, 255));
        lbl_heading.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_heading.setText("Users");
        getContentPane().add(lbl_heading);
        lbl_heading.setBounds(0, 10, 864, 40);

        tbl_users.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Username", "Name", "Role", "Add Date"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbl_users);
        if (tbl_users.getColumnModel().getColumnCount() > 0) {
            tbl_users.getColumnModel().getColumn(0).setResizable(false);
            tbl_users.getColumnModel().getColumn(0).setPreferredWidth(0);
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
        new EnterUser().setVisible(true);
    }//GEN-LAST:event_btn_addActionPerformed

    private void btn_reloadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_reloadActionPerformed
        getAllUsers();
    }//GEN-LAST:event_btn_reloadActionPerformed

    private void btn_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editActionPerformed
        updateOrViewUser("EDIT");
    }//GEN-LAST:event_btn_editActionPerformed

    private void btn_viewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_viewActionPerformed
        updateOrViewUser("VIEW");
    }//GEN-LAST:event_btn_viewActionPerformed

    private void getAllUsers() {

        tbl_users.removeAll();
        DatabaseCon databaseCon = new DatabaseCon();
        DefaultTableModel model = (DefaultTableModel) tbl_users.getModel();
        model.setRowCount(0);
        ArrayList list = databaseCon.getAlUsersFromDB();
        list.forEach(item -> {
            model.addRow((Object[]) item);
        });
    }

    private void updateOrViewUser(String type) {

        if (!tbl_users.getSelectionModel().isSelectionEmpty()) {
            EnterUser enterUser = new EnterUser();
            int selectedRow = tbl_users.getSelectedRow();
            TableModel model = tbl_users.getModel();
            enterUser.setUpdateUserData(Integer.valueOf(model.getValueAt(selectedRow, 0).toString()), type);
            enterUser.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Please select the user!", "ERROR", 2);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Users().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_add;
    private javax.swing.JButton btn_edit;
    private javax.swing.JButton btn_reload;
    private javax.swing.JButton btn_view;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_heading;
    private javax.swing.JTable tbl_users;
    // End of variables declaration//GEN-END:variables
}
