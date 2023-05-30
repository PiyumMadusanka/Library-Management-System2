package Lbs;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class IssuedBooks extends javax.swing.JFrame {

    int LOGED_STUDENT_ID = 0;

    public IssuedBooks() {
        initComponents();
        setPermission();
        getAllIssuedBooks();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_issue_book = new javax.swing.JButton();
        btn_reload = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_issued_books = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(890, 650));
        setResizable(false);
        getContentPane().setLayout(null);

        btn_issue_book.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_issue_book.setText("Issue Book");
        btn_issue_book.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_issue_bookActionPerformed(evt);
            }
        });
        getContentPane().add(btn_issue_book);
        btn_issue_book.setBounds(750, 55, 100, 30);

        btn_reload.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_reload.setText("Reload");
        btn_reload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_reloadActionPerformed(evt);
            }
        });
        getContentPane().add(btn_reload);
        btn_reload.setBounds(645, 55, 100, 30);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Issued Books");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 10, 864, 40);

        tbl_issued_books.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Book Code", "Student", "Issued Date", "Return Date", "Return Status"
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
        jScrollPane1.setViewportView(tbl_issued_books);
        if (tbl_issued_books.getColumnModel().getColumnCount() > 0) {
            tbl_issued_books.getColumnModel().getColumn(0).setResizable(false);
            tbl_issued_books.getColumnModel().getColumn(0).setPreferredWidth(0);
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

    private void btn_issue_bookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_issue_bookActionPerformed
        new EnterBookIssue().setVisible(true);
    }//GEN-LAST:event_btn_issue_bookActionPerformed

    private void btn_reloadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_reloadActionPerformed
        getAllIssuedBooks();
    }//GEN-LAST:event_btn_reloadActionPerformed

    private void getAllIssuedBooks() {

        tbl_issued_books.removeAll();
        DatabaseCon databaseCon = new DatabaseCon();
        DefaultTableModel model = (DefaultTableModel) tbl_issued_books.getModel();
        model.setRowCount(0);
        ArrayList list = databaseCon.getAllIssuedBooksFromDB(LOGED_STUDENT_ID);
        list.forEach(item -> {
            model.addRow((Object[]) item);
        });

    }

    private void setPermission() {
        LoggedUser loggedUser = new LoggedUser();
        if (loggedUser.getLoginUser().role.equals("Student")) {
            LOGED_STUDENT_ID = loggedUser.getLoginUser().userId;
            btn_issue_book.setEnabled(false);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IssuedBooks().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_issue_book;
    private javax.swing.JButton btn_reload;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_issued_books;
    // End of variables declaration//GEN-END:variables
}
