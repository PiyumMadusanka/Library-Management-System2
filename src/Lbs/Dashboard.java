package Lbs;

public class Dashboard extends javax.swing.JFrame {

    public Dashboard() {
        initComponents();
        setPermission();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_username = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btn_issue_book = new javax.swing.JButton();
        btn_manage_book = new javax.swing.JButton();
        btn_return_book = new javax.swing.JButton();
        btn_logout = new javax.swing.JButton();
        btn_user = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(975, 660));
        setResizable(false);
        getContentPane().setLayout(null);

        lbl_username.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_username.setForeground(new java.awt.Color(255, 51, 51));
        lbl_username.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_username.setText("Hello User");
        lbl_username.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        getContentPane().add(lbl_username);
        lbl_username.setBounds(270, 180, 470, 30);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 51, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Dashboard");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(10, 40, 955, 49);

        btn_issue_book.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_issue_book.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Lbs/lend.png"))); // NOI18N
        btn_issue_book.setText("Issue Book");
        btn_issue_book.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_issue_book.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_issue_bookActionPerformed(evt);
            }
        });
        getContentPane().add(btn_issue_book);
        btn_issue_book.setBounds(510, 220, 230, 95);

        btn_manage_book.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_manage_book.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Lbs/book2.png"))); // NOI18N
        btn_manage_book.setText("Manage Book");
        btn_manage_book.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_manage_book.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_manage_bookActionPerformed(evt);
            }
        });
        getContentPane().add(btn_manage_book);
        btn_manage_book.setBounds(270, 220, 230, 95);

        btn_return_book.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_return_book.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Lbs/return.png"))); // NOI18N
        btn_return_book.setText("Retun Book");
        btn_return_book.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_return_book.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_return_bookActionPerformed(evt);
            }
        });
        getContentPane().add(btn_return_book);
        btn_return_book.setBounds(270, 330, 230, 95);

        btn_logout.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_logout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Lbs/logout.png"))); // NOI18N
        btn_logout.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_logoutActionPerformed(evt);
            }
        });
        getContentPane().add(btn_logout);
        btn_logout.setBounds(20, 530, 70, 60);

        btn_user.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_user.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Lbs/profile.png"))); // NOI18N
        btn_user.setText("Users");
        btn_user.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_user.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_userActionPerformed(evt);
            }
        });
        getContentPane().add(btn_user);
        btn_user.setBounds(510, 330, 230, 95);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("LBS 1.0");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(10, 600, 100, 15);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Lbs/background_image.jpg"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(-140, -100, 1140, 850);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_issue_bookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_issue_bookActionPerformed
        new IssuedBooks().setVisible(true);
    }//GEN-LAST:event_btn_issue_bookActionPerformed

    private void btn_manage_bookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_manage_bookActionPerformed
        new Books().setVisible(true);
    }//GEN-LAST:event_btn_manage_bookActionPerformed

    private void btn_return_bookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_return_bookActionPerformed
        new ReturnBooks().setVisible(true);
    }//GEN-LAST:event_btn_return_bookActionPerformed

    private void btn_logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_logoutActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btn_logoutActionPerformed

    private void btn_userActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_userActionPerformed
        new Users().setVisible(true);
    }//GEN-LAST:event_btn_userActionPerformed

    private void setPermission() {
        LoggedUser loggedUser = new LoggedUser();
        lbl_username.setText("Hello " + loggedUser.getLoginUser().name + ".");
        if (loggedUser.getLoginUser().role.equals("Student")) {
            btn_user.setEnabled(false);
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
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_issue_book;
    private javax.swing.JButton btn_logout;
    private javax.swing.JButton btn_manage_book;
    private javax.swing.JButton btn_return_book;
    private javax.swing.JButton btn_user;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lbl_username;
    // End of variables declaration//GEN-END:variables
}
