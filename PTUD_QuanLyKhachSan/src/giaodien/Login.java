
package giaodien;
import java.awt.Color;
public class Login extends javax.swing.JFrame {

    public Login() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Right = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        Left = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        textField1 = new giaodien.TextField();
        passwordField1 = new giaodien.PasswordField();
        button1 = new giaodien.Button();
        button2 = new giaodien.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("LOGIN");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 500));
        jPanel1.setLayout(null);

        Right.setBackground(new java.awt.Color(106, 247, 154));
        Right.setMinimumSize(new java.awt.Dimension(400, 500));
        Right.setPreferredSize(new java.awt.Dimension(400, 500));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgLogin/tien-sanh-khach-san.jpg"))); // NOI18N
        jLabel5.setMaximumSize(new java.awt.Dimension(800, 500));
        jLabel5.setMinimumSize(new java.awt.Dimension(800, 500));
        jLabel5.setPreferredSize(new java.awt.Dimension(800, 500));

        javax.swing.GroupLayout RightLayout = new javax.swing.GroupLayout(Right);
        Right.setLayout(RightLayout);
        RightLayout.setHorizontalGroup(
            RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RightLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 400, Short.MAX_VALUE)
                .addContainerGap())
        );
        RightLayout.setVerticalGroup(
            RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel1.add(Right);
        Right.setBounds(0, 0, 400, 500);

        Left.setBackground(new java.awt.Color(255, 255, 255));
        Left.setPreferredSize(new java.awt.Dimension(400, 500));

        jLabel1.setBackground(new java.awt.Color(23, 195, 178));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 32)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(23, 195, 178));
        jLabel1.setText("ĐĂNG NHẬP");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel4.setText("Thay đổi mật khẩu");

        jLabel6.setFont(new java.awt.Font("Showcard Gothic", 0, 18)); // NOI18N
        jLabel6.setText("StaRail Hotel  Management");

        textField1.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        textField1.setLabelText("Tên đăng nhập");
        textField1.setLineColor(new java.awt.Color(23, 195, 178));
        textField1.setPreferredSize(new java.awt.Dimension(64, 50));

        passwordField1.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        passwordField1.setLabelText("Mật khẩu");
        passwordField1.setLineColor(new java.awt.Color(23, 195, 178));

        button1.setBackground(new java.awt.Color(23, 195, 178));
        button1.setBorder(null);
        button1.setText("ĐĂNG NHẬP");
        button1.setBorderColor(new java.awt.Color(23, 195, 178));
        button1.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        button1.setRadius(20);
        button1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button1MouseExited(evt);
            }
        });

        button2.setBackground(new java.awt.Color(254, 109, 115));
        button2.setBorder(null);
        button2.setText("Đổi mật khẩu");
        button2.setBorderColor(new java.awt.Color(254, 109, 115));
        button2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        button2.setRadius(15);
        button2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button2MouseExited(evt);
            }
        });
        button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout LeftLayout = new javax.swing.GroupLayout(Left);
        Left.setLayout(LeftLayout);
        LeftLayout.setHorizontalGroup(
            LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LeftLayout.createSequentialGroup()
                .addContainerGap(70, Short.MAX_VALUE)
                .addGroup(LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(LeftLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LeftLayout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(101, 101, 101))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LeftLayout.createSequentialGroup()
                            .addComponent(jLabel6)
                            .addGap(67, 67, 67)))))
            .addGroup(LeftLayout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addGroup(LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(textField1, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                    .addComponent(passwordField1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(button1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        LeftLayout.setVerticalGroup(
            LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LeftLayout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(jLabel1)
                .addGap(32, 32, 32)
                .addComponent(textField1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(passwordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(jLabel6)
                .addGap(42, 42, 42))
        );

        jPanel1.add(Left);
        Left.setBounds(400, 0, 400, 500);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel1.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void button1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button1MouseExited
            button1.setBackground(new Color(23,195,178)); 
    }//GEN-LAST:event_button1MouseExited

    private void button2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button2MouseExited
        button2.setBackground(new Color(254,109,115)); 
    }//GEN-LAST:event_button2MouseExited

    private void button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button2ActionPerformed
        // TODO add your handling code here:
        ChangePassword changePasswordFrame = new ChangePassword();
        changePasswordFrame.setVisible(true);
        changePasswordFrame.pack();
        changePasswordFrame.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_button2ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Left;
    private javax.swing.JPanel Right;
    private giaodien.Button button1;
    private giaodien.Button button2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private giaodien.PasswordField passwordField1;
    private giaodien.TextField textField1;
    // End of variables declaration//GEN-END:variables
}
