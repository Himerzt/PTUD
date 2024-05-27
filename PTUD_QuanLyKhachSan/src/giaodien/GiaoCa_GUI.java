package giaodien;

import connectDB.ConnectDB;
import dao.NhanVienDao;
import entity.NhanVien;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;

public class GiaoCa_GUI extends javax.swing.JPanel {

    

    public GiaoCa_GUI() throws SQLException {
     
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelRound1 = new giaodien.CustomClass.PanelRound();
        jLabel1 = new javax.swing.JLabel();
        btnGiaoCa = new giaodien.CustomClass.Button();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtDoanhThuHeThong = new giaodien.CustomClass.TextFieldShadow();
        txtDoanhThuThucTe = new giaodien.CustomClass.TextFieldShadow();

        panelRound1.setBackground(new java.awt.Color(255, 255, 255));
        panelRound1.setRoundBottomLeft(30);
        panelRound1.setRoundBottomRight(30);
        panelRound1.setRoundTopLeft(30);
        panelRound1.setRoundTopRight(30);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Doanh thu theo hệ thống");

        btnGiaoCa.setBorder(null);
        btnGiaoCa.setText("Giao ca");
        btnGiaoCa.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnGiaoCa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGiaoCaActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Doanh thu thực tế");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setText("GIAO CA");

        txtDoanhThuHeThong.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtDoanhThuThucTe.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4))
                        .addGap(58, 58, 58)
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtDoanhThuHeThong, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                            .addComponent(txtDoanhThuThucTe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addGap(243, 243, 243)
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(btnGiaoCa, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(71, Short.MAX_VALUE))
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(txtDoanhThuHeThong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtDoanhThuThucTe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(btnGiaoCa, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnGiaoCaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGiaoCaActionPerformed
         String doanhThuHeThong = txtDoanhThuHeThong.getText();
        String doanhThuThucTe = txtDoanhThuThucTe.getText();

        if (doanhThuHeThong.equals(doanhThuThucTe)) {
            // Chuyển đến trang đăng nhập
            JOptionPane.showMessageDialog(this, "Giao ca thành công, trở lại trang đăng nhập.");
            // Logic để chuyển đến trang đăng nhập
            // Ví dụ:
            // JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
            // topFrame.dispose();
            // new Login().setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Giao ca không thành công, vui lòng kiểm tra lại.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_btnGiaoCaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private giaodien.CustomClass.Button btnGiaoCa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private giaodien.CustomClass.PanelRound panelRound1;
    private giaodien.CustomClass.TextFieldShadow txtDoanhThuHeThong;
    private giaodien.CustomClass.TextFieldShadow txtDoanhThuThucTe;
    // End of variables declaration//GEN-END:variables
    
}
