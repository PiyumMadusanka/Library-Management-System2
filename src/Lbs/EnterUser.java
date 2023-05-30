package Lbs;

import javax.swing.JOptionPane;

public class EnterUser extends javax.swing.JFrame {

    int UPDATE_USER_ID = 0;
    DatabaseCon DATABASE_CON = new DatabaseCon();
    boolean VIEW_ONLY = false;

    public EnterUser() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_heading = new javax.swing.JLabel();
        txt_user_id = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_name = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_username = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txta_address = new javax.swing.JTextArea();
        txt_email = new javax.swing.JTextField();
        btn_add = new javax.swing.JButton();
        lbl_pro_image = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txt_password = new javax.swing.JPasswordField();
        jLabel12 = new javax.swing.JLabel();
        txt_tp = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txt_nic = new javax.swing.JTextField();
        com_user_type = new javax.swing.JComboBox<>();
        btn_clear = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(900, 700));
        setResizable(false);
        getContentPane().setLayout(null);

        lbl_heading.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lbl_heading.setForeground(new java.awt.Color(0, 51, 255));
        lbl_heading.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_heading.setText("Add User");
        getContentPane().add(lbl_heading);
        lbl_heading.setBounds(10, 0, 864, 49);

        txt_user_id.setEditable(false);
        txt_user_id.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(txt_user_id);
        txt_user_id.setBounds(330, 140, 210, 30);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Id");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(240, 140, 80, 30);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Name");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(240, 260, 80, 30);

        txt_name.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(txt_name);
        txt_name.setBounds(330, 260, 480, 30);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Password");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(240, 220, 80, 30);

        txt_username.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(txt_username);
        txt_username.setBounds(330, 180, 210, 30);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Email");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(550, 140, 50, 30);

        txta_address.setColumns(20);
        txta_address.setRows(5);
        jScrollPane1.setViewportView(txta_address);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(330, 300, 480, 70);

        txt_email.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(txt_email);
        txt_email.setBounds(600, 140, 210, 30);

        btn_add.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_add.setText("Add");
        btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addActionPerformed(evt);
            }
        });
        getContentPane().add(btn_add);
        btn_add.setBounds(730, 410, 80, 30);

        lbl_pro_image.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_pro_image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Lbs/profile_image.png"))); // NOI18N
        lbl_pro_image.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(lbl_pro_image);
        lbl_pro_image.setBounds(40, 140, 180, 150);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Username");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(240, 180, 80, 30);
        getContentPane().add(txt_password);
        txt_password.setBounds(330, 220, 210, 30);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("T.P");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(550, 180, 50, 30);

        txt_tp.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(txt_tp);
        txt_tp.setBounds(600, 180, 210, 30);

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setText("NIC");
        getContentPane().add(jLabel13);
        jLabel13.setBounds(550, 220, 50, 30);

        txt_nic.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(txt_nic);
        txt_nic.setBounds(600, 220, 210, 30);

        com_user_type.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        com_user_type.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Student", "Admin" }));
        getContentPane().add(com_user_type);
        com_user_type.setBounds(330, 380, 160, 30);

        btn_clear.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_clear.setText("Clear");
        btn_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clearActionPerformed(evt);
            }
        });
        getContentPane().add(btn_clear);
        btn_clear.setBounds(645, 410, 80, 30);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("Address");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(240, 300, 90, 30);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Role");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(240, 380, 90, 30);

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Lbs/background_image.jpg"))); // NOI18N
        getContentPane().add(jLabel10);
        jLabel10.setBounds(-30, -100, 950, 850);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
        addUserToDb();
    }//GEN-LAST:event_btn_addActionPerformed

    private void btn_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clearActionPerformed
        clearFeilds();
    }//GEN-LAST:event_btn_clearActionPerformed

    private void clearFeilds() {

        txt_username.setText("");
        txt_password.setText("");
        txt_name.setText("");
        txt_email.setText("");
        txt_tp.setText("");
        txt_nic.setText("");
        txta_address.setText("");
        com_user_type.setSelectedItem("Student");
        btn_add.setText("Add");
        btn_clear.setEnabled(true);

        txt_username.setEditable(true);
        txt_password.setEditable(true);
        txt_name.setEditable(true);
        txt_email.setEditable(true);
        txt_tp.setEditable(true);
        txt_nic.setEditable(true);
        txta_address.setEditable(true);
        UPDATE_USER_ID = 0;
        txt_user_id.setText("");
        lbl_heading.setText("Add User");
        VIEW_ONLY = false;
    }

    public void setUpdateUserData(int id, String type) {
        UPDATE_USER_ID = id;
        UserProfile profile = DATABASE_CON.getSelecteduserDetails(id);
        if (profile != null) {

            txt_user_id.setText(String.valueOf(profile.userId));
            txt_username.setText(profile.username);
            txt_name.setText(profile.name);
            txta_address.setText(profile.address);
            txt_tp.setText(profile.tpNo);
            txt_nic.setText(profile.nicNo);
            txt_email.setText(profile.email);
            com_user_type.setSelectedItem(profile.role);

            if (type.equals("EDIT")) {

                txt_username.setEditable(false);
                txt_password.setEnabled(false);
                lbl_heading.setText("Update User");
                btn_add.setText("Update");

            } else if (type.equals("VIEW")) {

                VIEW_ONLY = true;
                txt_username.setEditable(false);
                txt_password.setEditable(false);
                txt_name.setEditable(false);
                txt_email.setEditable(false);
                txt_tp.setEditable(false);
                txt_nic.setEditable(false);
                txta_address.setEditable(false);
                btn_clear.setEnabled(false);
                lbl_heading.setText("View User");
                btn_add.setText("Close");
            }

        } else {
            JOptionPane.showMessageDialog(rootPane, "User data did not found!", null, 0);
        }
    }

    private void addUserToDb() {

        if (!VIEW_ONLY) {
            if (!txt_username.getText().trim().isEmpty()) {
                if ((UPDATE_USER_ID == 0 && !txt_password.getText().trim().isEmpty()) || UPDATE_USER_ID > 0) {
                    if (!txt_name.getText().trim().isEmpty()) {
                        if (!txt_tp.getText().trim().isEmpty()) {
                            if (!txt_nic.getText().trim().isEmpty()) {
                                if (!txta_address.getText().trim().isEmpty()) {
                                    //insert new user
                                    if (UPDATE_USER_ID == 0) {
                                        if (!DATABASE_CON.isThisUsernameAlreadyUsed(txt_username.getText().trim())) {
                                            if (DATABASE_CON.addUser(txt_username.getText().trim(), txt_password.getText(), txt_name.getText().trim(), txt_email.getText().trim(), txt_tp.getText().trim(), txt_nic.getText().trim(), txta_address.getText().trim(), com_user_type.getSelectedItem().toString())) {
                                                clearFeilds();
                                                JOptionPane.showMessageDialog(rootPane, "user added!", null, 1);
                                            } else {
                                                JOptionPane.showMessageDialog(rootPane, "Something went wrong during the update. Please try again!", null, 0);
                                            }
                                        } else {
                                            JOptionPane.showMessageDialog(rootPane, "This username already used!", null, 0);
                                        }
                                        //update existing user
                                    } else {
                                        if (DATABASE_CON.updateUser(UPDATE_USER_ID, txt_name.getText().trim(), txt_email.getText().trim(), txt_tp.getText().trim(), txt_nic.getText().trim(), txta_address.getText().trim(), com_user_type.getSelectedItem().toString())) {
                                            clearFeilds();
                                            JOptionPane.showMessageDialog(rootPane, "user updated!", null, 1);
                                        } else {
                                            JOptionPane.showMessageDialog(rootPane, "Something went wrong during the update. Please try again!", null, 0);
                                        }
                                    }
                                } else {
                                    JOptionPane.showMessageDialog(rootPane, "address can not be empty!", null, 0);
                                }
                            } else {
                                JOptionPane.showMessageDialog(rootPane, "NIC can not be empty!", null, 0);
                            }
                        } else {
                            JOptionPane.showMessageDialog(rootPane, "T.P can not be empty!", null, 0);
                        }
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "name can not be empty!", null, 0);
                    }
                } else {
                    JOptionPane.showMessageDialog(rootPane, "password can not be empty!", null, 0);
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "username can not be empty!", null, 0);
            }
        } else {
            this.dispose();
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EnterUser().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_add;
    private javax.swing.JButton btn_clear;
    private javax.swing.JComboBox<String> com_user_type;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_heading;
    private javax.swing.JLabel lbl_pro_image;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_name;
    private javax.swing.JTextField txt_nic;
    private javax.swing.JPasswordField txt_password;
    private javax.swing.JTextField txt_tp;
    private javax.swing.JTextField txt_user_id;
    private javax.swing.JTextField txt_username;
    private javax.swing.JTextArea txta_address;
    // End of variables declaration//GEN-END:variables
}
