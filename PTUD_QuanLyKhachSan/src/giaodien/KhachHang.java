/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package giaodien;

/**
 *
 * @author Huynguyen
 */
public class KhachHang extends javax.swing.JFrame {

    /**
     * Creates new form KhachHang
     */
    public KhachHang() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnKhachHang = new javax.swing.JPanel();
        pnLayOutKhachKhachHang = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        txtMaKhachHang = new javax.swing.JTextField();
        txtChiTieuKhachHang = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        txtTenKhachHang = new javax.swing.JTextField();
        txtSoDienThoaiKhachHang = new javax.swing.JTextField();
        txtNgaySinhKhachHang = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        txtCanCuocKhachHang = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        cbxGioiTinhKhachHang = new javax.swing.JComboBox<>();
        btnCapNhapKhachHang = new javax.swing.JButton();
        btnThemKhachHang = new javax.swing.JButton();
        jLabel35 = new javax.swing.JLabel();
        txtQuocTichKhachHang = new javax.swing.JTextField();
        txtHangThanhVien = new javax.swing.JTextField();
        btnXoaTrangKhachHangQL = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        TableKhachHang = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnLayOutKhachKhachHang.setBackground(new java.awt.Color(255, 255, 255));
        pnLayOutKhachKhachHang.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Quản lý khách hàng", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 24))); // NOI18N

        jPanel18.setBackground(new java.awt.Color(254, 249, 239));

        jLabel27.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel27.setText("Mã khách hàng");
        jLabel27.setToolTipText("");
        jLabel27.setPreferredSize(new java.awt.Dimension(120, 21));

        jLabel28.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel28.setText("Giới tính");
        jLabel28.setToolTipText("");
        jLabel28.setPreferredSize(new java.awt.Dimension(120, 21));

        jLabel29.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel29.setText("Chi tiêu");
        jLabel29.setToolTipText("");
        jLabel29.setPreferredSize(new java.awt.Dimension(120, 21));

        txtMaKhachHang.setText("Mã khách hàng");
        txtMaKhachHang.setEnabled(false);

        txtChiTieuKhachHang.setText("5000000");
        txtChiTieuKhachHang.setEnabled(false);

        jLabel30.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel30.setText("Tên khách hàng");
        jLabel30.setToolTipText("");
        jLabel30.setPreferredSize(new java.awt.Dimension(120, 21));

        jLabel31.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel31.setText("Số điện thoại");
        jLabel31.setToolTipText("");
        jLabel31.setPreferredSize(new java.awt.Dimension(120, 21));

        txtTenKhachHang.setText("Tên khách hàng");

        txtSoDienThoaiKhachHang.setText("Số điện thoại");
        txtSoDienThoaiKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSoDienThoaiKhachHangActionPerformed(evt);
            }
        });

        jLabel32.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel32.setText("Ngày sinh");
        jLabel32.setToolTipText("");
        jLabel32.setPreferredSize(new java.awt.Dimension(120, 21));

        txtCanCuocKhachHang.setText("Căn cước");

        jLabel33.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel33.setText("CCCD/VISA");
        jLabel33.setToolTipText("");
        jLabel33.setPreferredSize(new java.awt.Dimension(120, 21));

        jLabel34.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel34.setText("Hạng thành viên");
        jLabel34.setToolTipText("");
        jLabel34.setPreferredSize(new java.awt.Dimension(120, 21));

        cbxGioiTinhKhachHang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ", "Khác" }));

        btnCapNhapKhachHang.setBackground(new java.awt.Color(255, 203, 119));
        btnCapNhapKhachHang.setText("Cập nhập khách hàng");
        btnCapNhapKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhapKhachHangActionPerformed(evt);
            }
        });

        btnThemKhachHang.setBackground(new java.awt.Color(255, 203, 119));
        btnThemKhachHang.setText("Thêm khách hàng");
        btnThemKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemKhachHangActionPerformed(evt);
            }
        });

        jLabel35.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel35.setText("Quốc tịch");
        jLabel35.setToolTipText("");
        jLabel35.setPreferredSize(new java.awt.Dimension(120, 21));

        txtQuocTichKhachHang.setText("Quốc tịch");

        txtHangThanhVien.setText("Hạng thành viên");
        txtHangThanhVien.setEnabled(false);
        txtHangThanhVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHangThanhVienActionPerformed(evt);
            }
        });

        btnXoaTrangKhachHangQL.setBackground(new java.awt.Color(255, 203, 119));
        btnXoaTrangKhachHangQL.setText("Xóa trắng");
        btnXoaTrangKhachHangQL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaTrangKhachHangQLActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel18Layout.createSequentialGroup()
                                .addGap(59, 59, 59)
                                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                                    .addComponent(jLabel29, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel18Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtMaKhachHang, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                            .addComponent(txtChiTieuKhachHang, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtHangThanhVien, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(70, 70, 70)
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                            .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTenKhachHang)
                            .addComponent(txtSoDienThoaiKhachHang, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                            .addComponent(cbxGioiTinhKhachHang, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(75, 75, 75)
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel35, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel18Layout.createSequentialGroup()
                                .addComponent(txtNgaySinhKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                                .addGap(30, 30, 30))
                            .addComponent(txtCanCuocKhachHang, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtQuocTichKhachHang, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)))
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnXoaTrangKhachHangQL)
                        .addGap(18, 18, 18)
                        .addComponent(btnThemKhachHang)
                        .addGap(18, 18, 18)
                        .addComponent(btnCapNhapKhachHang)))
                .addGap(65, 65, 65))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNgaySinhKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCanCuocKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTenKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSoDienThoaiKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbxGioiTinhKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtQuocTichKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMaKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtHangThanhVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtChiTieuKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCapNhapKhachHang)
                    .addComponent(btnThemKhachHang)
                    .addComponent(btnXoaTrangKhachHangQL))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        TableKhachHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã khách hàng", "Tên khách hàng", "Giới tính", "Ngày sinh", "Số điện thoại", "CCCD", "Chi tiêu", "Hạng thành viên", "Quốc tịch"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane6.setViewportView(TableKhachHang);

        javax.swing.GroupLayout pnLayOutKhachKhachHangLayout = new javax.swing.GroupLayout(pnLayOutKhachKhachHang);
        pnLayOutKhachKhachHang.setLayout(pnLayOutKhachKhachHangLayout);
        pnLayOutKhachKhachHangLayout.setHorizontalGroup(
            pnLayOutKhachKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnLayOutKhachKhachHangLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnLayOutKhachKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane6))
                .addContainerGap())
        );
        pnLayOutKhachKhachHangLayout.setVerticalGroup(
            pnLayOutKhachKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnLayOutKhachKhachHangLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 437, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout pnKhachHangLayout = new javax.swing.GroupLayout(pnKhachHang);
        pnKhachHang.setLayout(pnKhachHangLayout);
        pnKhachHangLayout.setHorizontalGroup(
            pnKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnKhachHangLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnLayOutKhachKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(44, Short.MAX_VALUE))
        );
        pnKhachHangLayout.setVerticalGroup(
            pnKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnKhachHangLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnLayOutKhachKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(112, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1280, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pnKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 835, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pnKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtSoDienThoaiKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSoDienThoaiKhachHangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSoDienThoaiKhachHangActionPerformed

    private void btnCapNhapKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhapKhachHangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCapNhapKhachHangActionPerformed

    private void btnThemKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemKhachHangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnThemKhachHangActionPerformed

    private void txtHangThanhVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHangThanhVienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHangThanhVienActionPerformed

    private void btnXoaTrangKhachHangQLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaTrangKhachHangQLActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnXoaTrangKhachHangQLActionPerformed

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
            java.util.logging.Logger.getLogger(KhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(KhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(KhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(KhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new KhachHang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TableKhachHang;
    private javax.swing.JButton btnCapNhapKhachHang;
    private javax.swing.JButton btnThemKhachHang;
    private javax.swing.JButton btnXoaTrangKhachHangQL;
    private javax.swing.JComboBox<String> cbxGioiTinhKhachHang;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JPanel pnKhachHang;
    private javax.swing.JPanel pnLayOutKhachKhachHang;
    private javax.swing.JTextField txtCanCuocKhachHang;
    private javax.swing.JTextField txtChiTieuKhachHang;
    private javax.swing.JTextField txtHangThanhVien;
    private javax.swing.JTextField txtMaKhachHang;
    private javax.swing.JTextField txtNgaySinhKhachHang;
    private javax.swing.JTextField txtQuocTichKhachHang;
    private javax.swing.JTextField txtSoDienThoaiKhachHang;
    private javax.swing.JTextField txtTenKhachHang;
    // End of variables declaration//GEN-END:variables
}
