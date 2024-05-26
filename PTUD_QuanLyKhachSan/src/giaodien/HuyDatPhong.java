package giaodien;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import connectDB.ConnectDB;
import dao.DichVuDao;
import dao.KhachHangDao;
import dao.LoaiThueDao;
import dao.PhongDao;
import dao.ThongTinDatThuePhongDao;
import entity.KhachHang;
import entity.Phong;
import entity.ThongTinDatThuePhong;

/**
 *
 * @author Huynguyen
 */
public class HuyDatPhong extends javax.swing.JDialog {

    private DichVuDao dichVuDao;
    private ThongTinDatThuePhongDao thongTinDatThuePhongDao;
    private KhachHangDao khachHangDao;
    private LoaiThueDao loaiThueDao;
    private PhongDao phongDao;

    /**
     * Creates new form DatPhong
     */
    public HuyDatPhong() {
        ConnectDB.getInstance().getConnection();
        khachHangDao = new KhachHangDao();
        thongTinDatThuePhongDao = new ThongTinDatThuePhongDao();
        dichVuDao = new DichVuDao();
        loaiThueDao = new LoaiThueDao();
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dateNgayDat = new giaodien.CustomClass.DateChooser();
        dateNgayTra = new giaodien.CustomClass.DateChooser();
        dateNgayNhan = new giaodien.CustomClass.DateChooser();
        jSpinner1 = new javax.swing.JSpinner();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jScrollPane2 = new giaodien.CustomClass.ScrollPaneWin11();
        tableDanhSachPhong = new javax.swing.JTable();
        panelRound1 = new giaodien.CustomClass.PanelRound();
        jLabel17 = new javax.swing.JLabel();
        txtTenKH = new giaodien.CustomClass.TextFieldShadow();
        txtCCCD = new giaodien.CustomClass.TextFieldShadow();
        jLabel24 = new javax.swing.JLabel();
        btnThemKhachHang = new giaodien.CustomClass.Button();
        btnHuyTatCa = new giaodien.CustomClass.Button();
        btnHuy = new giaodien.CustomClass.Button();
        btnHuyPhongChon = new giaodien.CustomClass.Button();

        dateNgayDat.setForeground(new java.awt.Color(255, 203, 119));

        dateNgayTra.setForeground(new java.awt.Color(255, 203, 119));

        dateNgayNhan.setForeground(new java.awt.Color(255, 203, 119));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel1.setText("Hủy đặt phòng");

        jLabel32.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel32.setText("Danh sách phòng");

        tableDanhSachPhong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Tên phòng", "Loại phòng", "Kiểu thuê", "Ngày đặt", "Ngày nhận", "Ngày trả", "Tiền cọc"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableDanhSachPhong.setRowHeight(40);
        tableDanhSachPhong.setSelectionBackground(new java.awt.Color(254, 109, 115));
        jScrollPane2.setViewportView(tableDanhSachPhong);
        if (tableDanhSachPhong.getColumnModel().getColumnCount() > 0) {
            tableDanhSachPhong.getColumnModel().getColumn(0).setMaxWidth(60);
        }

        panelRound1.setPreferredSize(new java.awt.Dimension(1047, 238));
        panelRound1.setRoundBottomLeft(20);
        panelRound1.setRoundBottomRight(20);
        panelRound1.setRoundTopLeft(20);
        panelRound1.setRoundTopRight(20);

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel17.setText("Tên khách hàng");

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel24.setText("CCCD/Passport");

        btnThemKhachHang.setText("Thêm khách hàng");
        btnThemKhachHang.setRadius(10);
        btnThemKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemKhachHangActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jLabel24)
                .addGap(12, 12, 12)
                .addComponent(txtCCCD, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(btnThemKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 229, Short.MAX_VALUE))
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCCCD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThemKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        btnHuyTatCa.setText("Hủy tất cả");
        btnHuyTatCa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyTatCaActionPerformed(evt);
            }
        });

        btnHuy.setText("Hủy");
        btnHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyActionPerformed(evt);
            }
        });

        btnHuyPhongChon.setText("Hủy phòng chọn");
        btnHuyPhongChon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyPhongChonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel32)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnHuyPhongChon, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnHuyTatCa, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(panelRound1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 1120, Short.MAX_VALUE)
                            .addComponent(jScrollPane2))
                        .addGap(12, 12, 12))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel32)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnHuyTatCa, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHuyPhongChon, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnHuyActionPerformed

    private void btnHuyTatCaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyTatCaActionPerformed
    	
    }//GEN-LAST:event_btnHuyTatCaActionPerformed

    private void btnHuyPhongChonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyPhongChonActionPerformed
    	
    }//GEN-LAST:event_btnHuyPhongChonActionPerformed

    private void btnThemKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemKhachHangActionPerformed
        KhachHang kh = new KhachHang();
        if (regCCCD_Passport(txtCCCD.getText()) == false) {
            return;
        }
        if (khachHangDao.timTheoCCCD(txtCCCD.getText().trim()) != null) {
            kh = khachHangDao.timTheoCCCD(txtCCCD.getText().trim());
            txtTenKH.setText(kh.getHoTenKH());
            loadDanhSachPhongDat();
        } else {
            JOptionPane.showMessageDialog(this, "Không tìm thấy thông tin khách hàng!");
            return;
        }
    }//GEN-LAST:event_btnThemKhachHangActionPerformed

    public String layTenLoaiPhong(String maLoai) {
        if (maLoai.equalsIgnoreCase("tc")) {
            return "Tiêu chuẩn";
        } else if (maLoai.equalsIgnoreCase("cc")) {
            return "Cao cấp";
        } else if (maLoai.equalsIgnoreCase("nc")) {
            return "Nâng cao";
        } else {
            return "Thương gia";
        }
    }

    // Check CCCD
    public boolean regCCCD_Passport(String cccd_passport) {
        if (cccd_passport.equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập CCCD/Passport");
            return false;
        } else {
            // Regex cho mã số CCCD hoặc Visa
            String regex = "^(\\d{12}|\\d{16})$";

            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(cccd_passport);

            if (!matcher.matches()) {
                JOptionPane.showMessageDialog(this, "CCCD/Passport không hợp lệ");
                return false;
            }
            return true;
        }
    }

    public void loadDanhSachPhongDat() {
        // Hiện danh sách phòng vào bảng
    	KhachHang kh = khachHangDao.timTheoCCCD(txtCCCD.getText().trim());
        ArrayList<Phong> dsPhongDat = thongTinDatThuePhongDao.timPhongTheoMaKhachHang(kh.getMaKH());
        ArrayList<ThongTinDatThuePhong> dsTTDTP = thongTinDatThuePhongDao.timThongTinDatThuePhongTheoMaKhachHang(kh.getMaKH()); 
        // Load danh sách phòng đặt vào table
        DefaultTableModel model = (DefaultTableModel) tableDanhSachPhong.getModel();
        String kieuThue = "";
        model.setRowCount(0);
		for (int i = 0; i < dsPhongDat.size(); i++) {
			Phong p = dsPhongDat.get(i);
			kieuThue = loaiThueDao.timKieuThueTheoMaLoaiThue(dsTTDTP.get(i).getMaLoaiThue());
			model.addRow(new Object[] { i + 1, p.getSoPhong(), layTenLoaiPhong(p.getMaLoaiPhong()), p.getKieuThue(),
					p.getNgayDat(), p.getNgayNhan(), p.getNgayTra(), p.getTienCoc() });
		}
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private giaodien.CustomClass.Button btnHuy;
    private giaodien.CustomClass.Button btnHuyPhongChon;
    private giaodien.CustomClass.Button btnHuyTatCa;
    private giaodien.CustomClass.Button btnThemKhachHang;
    private giaodien.CustomClass.DateChooser dateNgayDat;
    private giaodien.CustomClass.DateChooser dateNgayNhan;
    private giaodien.CustomClass.DateChooser dateNgayTra;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSpinner jSpinner1;
    private giaodien.CustomClass.PanelRound panelRound1;
    private javax.swing.JTable tableDanhSachPhong;
    private giaodien.CustomClass.TextFieldShadow txtCCCD;
    private giaodien.CustomClass.TextFieldShadow txtTenKH;
    // End of variables declaration//GEN-END:variables
}
