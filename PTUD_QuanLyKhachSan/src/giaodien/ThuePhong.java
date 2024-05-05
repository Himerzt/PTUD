package giaodien;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import connectDB.ConnectDB;
import dao.DichVuDao;
import dao.KhachHangDao;
import dao.LoaiPhongDao;
import dao.PhongDao;
import dao.ThongTinDatThuePhongDao;
import entity.DichVu;
import entity.DichVuPhong;
import entity.KhachHang;
import entity.LoaiPhong;
import entity.Phong;
import java.awt.event.ActionEvent;

/**
 *
 * @author Huynguyen
 */
public class ThuePhong extends javax.swing.JDialog {

    private String[] dsPhongThue;
    private DichVuDao dvDao;
    private PhongDao phongDao;
    private ThongTinDatThuePhongDao thongTinDatThuePhongDao;
    private LoaiPhongDao loaiPhongDao;
    private KhachHangDao khachHangDao;

    /**
     * Creates new form ThuePhong
     */
    public ThuePhong(List<String> dsTenPhong) {
        dsPhongThue = new String[dsTenPhong.size()];
        int index = 0;
        for (String tenPhong : dsTenPhong) {
            dsPhongThue[index++] = tenPhong;
        }
        ConnectDB.getInstance().getConnection();
        initComponents();
        loadDanhSachPhongThue();
    }

    public String[] layDanhSachPhongThue() {
        return dsPhongThue;
    }

    private static String[] loadDanhSachDichVu() {
        DichVuDao dvDao = new DichVuDao();
        ArrayList<DichVu> danhSachDV = dvDao.timTatCaDichVu();
        String[] tenDV = new String[danhSachDV.size()];
        for (int i = 0; i < danhSachDV.size(); i++) {
            tenDV[i] = String.format("%s %s", danhSachDV.get(i).getMaDV(), danhSachDV.get(i).getTenDV());
        }
        return tenDV;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dateNgayTra = new giaodien.CustomClass.DateChooser();
        dateNgayNhan = new giaodien.CustomClass.DateChooser();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jScrollPane2 = new giaodien.CustomClass.ScrollPaneWin11();
        tableDanhSachPhong = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new giaodien.CustomClass.ScrollPaneWin11();
        tableDV = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        panelRound1 = new giaodien.CustomClass.PanelRound();
        jLabel17 = new javax.swing.JLabel();
        txtSoNguoiLon = new giaodien.CustomClass.TextFieldShadow();
        txtSoTreEm = new giaodien.CustomClass.TextFieldShadow();
        jLabel22 = new javax.swing.JLabel();
        txtCCCD = new giaodien.CustomClass.TextFieldShadow();
        jLabel24 = new javax.swing.JLabel();
        btnCCCD = new giaodien.CustomClass.Button();
        txtCheckIn = new giaodien.CustomClass.TextFieldShadow();
        jLabel28 = new javax.swing.JLabel();
        txtCheckOut = new giaodien.CustomClass.TextFieldShadow();
        jLabel29 = new javax.swing.JLabel();
        btnNgayTra = new giaodien.CustomClass.Button();
        jLabel23 = new javax.swing.JLabel();
        panelRound4 = new giaodien.custom2.PanelRound();
        cbKieuThue = new giaodien.CustomClass.Combobox();
        jLabel26 = new javax.swing.JLabel();
        txtTenKH = new giaodien.CustomClass.TextFieldShadow();
        cbxKieuThue = new giaodien.CustomClass.Combobox();
        btnNgayNhan = new giaodien.CustomClass.Button();
        panelRound2 = new giaodien.CustomClass.PanelRound();
        btnThemDichVu = new giaodien.CustomClass.Button();
        panelRound3 = new giaodien.custom2.PanelRound();
        comboBoxDichVu = new giaodien.CustomClass.Combobox();
        btnThuePhong = new giaodien.CustomClass.Button();
        btnHuy = new giaodien.CustomClass.Button();

        dateNgayTra.setForeground(new java.awt.Color(255, 203, 119));
        dateNgayTra.setTextRefernce(txtCheckOut);

        dateNgayNhan.setForeground(new java.awt.Color(255, 203, 119));
        dateNgayNhan.setTextRefernce(txtCheckIn);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel1.setText("Thuê phòng");

        jLabel32.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel32.setText("Danh sách phòng");

        tableDanhSachPhong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Tên phòng", "Loại phòng"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableDanhSachPhong.setRowHeight(40);
        tableDanhSachPhong.setSelectionBackground(new java.awt.Color(254, 109, 115));
        jScrollPane2.setViewportView(tableDanhSachPhong);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Danh sách dịch vụ");

        tableDV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Tên dịch vụ", "Số lượng", "Phòng", "Đơn giá", "Tổng"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableDV.setRowHeight(40);
        jScrollPane1.setViewportView(tableDV);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Thêm dịch vụ phòng");

        panelRound1.setPreferredSize(new java.awt.Dimension(1047, 238));
        panelRound1.setRoundBottomLeft(20);
        panelRound1.setRoundBottomRight(20);
        panelRound1.setRoundTopLeft(20);
        panelRound1.setRoundTopRight(20);

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel17.setText("Tên khách hàng");

        txtSoTreEm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSoTreEmActionPerformed(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel22.setText("Trẻ em");

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel24.setText("CCCD/Passport");

        btnCCCD.setText("+");
        btnCCCD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCCCDActionPerformed(evt);
            }
        });

        jLabel28.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel28.setText("Ngày nhận");

        jLabel29.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel29.setText("Ngày trả");

        btnNgayTra.setBorder(null);
        btnNgayTra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgLogin/calendar.png"))); // NOI18N
        btnNgayTra.setBorderColor(new java.awt.Color(255, 255, 255));
        btnNgayTra.setColorOver(new java.awt.Color(204, 204, 204));
        btnNgayTra.setRadius(20);
        btnNgayTra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNgayTraActionPerformed(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel23.setText("Kiểu thuê");

        panelRound4.setBackground(new java.awt.Color(255, 255, 255));
        panelRound4.setRoundBottomLeft(15);
        panelRound4.setRoundBottomRight(15);
        panelRound4.setRoundTopLeft(15);
        panelRound4.setRoundTopRight(15);

        cbKieuThue.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Theo ngày", "Theo giờ", "Qua đêm" }));
        cbKieuThue.setSelectedIndex(-1);
        cbKieuThue.setLabeText("");

        javax.swing.GroupLayout panelRound4Layout = new javax.swing.GroupLayout(panelRound4);
        panelRound4.setLayout(panelRound4Layout);
        panelRound4Layout.setHorizontalGroup(
            panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound4Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(cbKieuThue, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelRound4Layout.setVerticalGroup(
            panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound4Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(cbKieuThue, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        jLabel26.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel26.setText("Người lớn");

        txtTenKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenKHActionPerformed(evt);
            }
        });

        cbxKieuThue.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Theo ngày", "Theo giờ ", "Qua đêm" }));

        btnNgayNhan.setBorder(null);
        btnNgayNhan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgLogin/calendar.png"))); // NOI18N
        btnNgayNhan.setBorderColor(new java.awt.Color(255, 255, 255));
        btnNgayNhan.setColorOver(new java.awt.Color(204, 204, 204));
        btnNgayNhan.setRadius(20);
        btnNgayNhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNgayNhanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel28, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(jLabel23)))
                .addGap(3, 3, 3)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbxKieuThue, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(txtTenKH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addComponent(txtCheckIn, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnNgayNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelRound1Layout.createSequentialGroup()
                                .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtCheckOut, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnNgayTra, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelRound1Layout.createSequentialGroup()
                                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtCCCD, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCCCD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtSoNguoiLon, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSoTreEm, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(panelRound4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(44, 44, 44))
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24)
                    .addComponent(txtCCCD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCCCD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelRound4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSoTreEm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSoNguoiLon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxKieuThue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCheckIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCheckOut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(btnNgayNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(btnNgayTra, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        panelRound2.setPreferredSize(new java.awt.Dimension(312, 72));
        panelRound2.setRoundBottomLeft(20);
        panelRound2.setRoundBottomRight(20);
        panelRound2.setRoundTopLeft(20);
        panelRound2.setRoundTopRight(20);

        btnThemDichVu.setText("Thêm dịch vụ");

        panelRound3.setBackground(new java.awt.Color(255, 255, 255));
        panelRound3.setRoundBottomLeft(15);
        panelRound3.setRoundBottomRight(15);
        panelRound3.setRoundTopLeft(15);
        panelRound3.setRoundTopRight(15);

        comboBoxDichVu.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ăn sáng", "Ăn trưa", "Ăn chiều", "Giặt quần áo", "Đưa đón khách", "Thêm giường", "Thêm gối", "Thêm chăn", "Nước ngọt", "Nước suối", "Gọi món tại phòng" }));
        comboBoxDichVu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        comboBoxDichVu.setLabeText("");

        javax.swing.GroupLayout panelRound3Layout = new javax.swing.GroupLayout(panelRound3);
        panelRound3.setLayout(panelRound3Layout);
        panelRound3Layout.setHorizontalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(comboBoxDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        panelRound3Layout.setVerticalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound3Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(comboBoxDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout panelRound2Layout = new javax.swing.GroupLayout(panelRound2);
        panelRound2.setLayout(panelRound2Layout);
        panelRound2Layout.setHorizontalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound2Layout.createSequentialGroup()
                        .addComponent(panelRound3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound2Layout.createSequentialGroup()
                        .addComponent(btnThemDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(64, 64, 64))))
        );
        panelRound2Layout.setVerticalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound2Layout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addComponent(panelRound3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnThemDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );

        btnThuePhong.setText("Thuê phòng");
        btnThuePhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThuePhongActionPerformed(evt);
            }
        });

        btnHuy.setText("Hủy");
        btnHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel32)
                        .addGap(203, 203, 203)
                        .addComponent(jLabel2))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, 1069, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(514, 514, 514)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 469, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(24, 24, 24)
                                        .addComponent(btnThuePhong, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                                        .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(panelRound2, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)))))))
                .addGap(12, 12, 12))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(panelRound2, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 142, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnThuePhong, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(30, 30, 30))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtTenKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenKHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenKHActionPerformed

    private void btnCCCDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCCCDActionPerformed
            
    }//GEN-LAST:event_btnCCCDActionPerformed

    private void btnThuePhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThuePhongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnThuePhongActionPerformed

    private void btnNgayNhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNgayNhanActionPerformed
        dateNgayNhan.showPopup();
    }//GEN-LAST:event_btnNgayNhanActionPerformed

    private void btnNgayTraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNgayTraActionPerformed
        dateNgayTra.showPopup();
    }//GEN-LAST:event_btnNgayTraActionPerformed

    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnHuyActionPerformed

    private void txtSoTreEmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSoTreEmActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSoTreEmActionPerformed

    private int tinhSoPhongTrongCua1LoaiPhong(String maLoaiPhong) {
        int soPhong = 0;
        ArrayList<Phong> dsPhong = phongDao.timPhongTheoLoaiPhong(maLoaiPhong);
        for (Phong phong : dsPhong) {
            if (phong.getTrangThai().equalsIgnoreCase("Trống")) {
                soPhong++;
            }
        }
        return soPhong;
    }

    private int tinhSoPhongToiThieu(int soNguoiLon, int soTreEm, String maLoaiPhong) {
        int soPhong = 0;
        // Tính số phòng cần thuê
        int soNguoi = soNguoiLon + soTreEm;
        int soNguoiToiDa = loaiPhongDao.timTheoMaLoaiPhong(maLoaiPhong).getSoNguoiToiDa();
        soPhong = (int) Math.ceil((double) soNguoi / soNguoiToiDa);
        return soPhong;
    }

//	private int tinhS
    private void btnThuePhongActionPerformed() {// GEN-FIRST:event_btnThuePhongActionPerformed
        // GEN-FIRST:event_btnThuePhongActionPerformed
        String[] dsPhongThue = layDanhSachPhongThue();
        ArrayList<Phong> dsPhong = new ArrayList<Phong>();
        // Lấy tên trong dsPhongThue, so sánh và lấy thông tin phòng từ CSDL
        for (String tenPhong : dsPhongThue) {
            dsPhong.add(phongDao.timPhongTheoSoPhong(Integer.parseInt(tenPhong)));
        }

        khachHangDao.timTheoCCCD(txtCCCD.getText());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        LocalDate.parse(txtCheckIn.getText(), formatter);
        LocalDate.parse(txtCheckOut.getText(), formatter);
        String loaiPhong = "";
        String kieuThue = "";
        if (cbKieuThue.getSelectedItem().toString().equals("Theo ngày")) {
            kieuThue = "D";
        } else if (cbKieuThue.getSelectedItem().toString().equals("Theo giờ")) {
            kieuThue = "H";
        } else {
            kieuThue = "N";
        }

        for (Phong phong : dsPhong) {
            loaiPhong = layTenLoaiPhong(phong.getMaLoaiPhong());
            if (loaiPhong.equalsIgnoreCase("Tiêu chuẩn")) {
                loaiPhong = "TC";
            } else if (loaiPhong.equalsIgnoreCase("Cao cấp")) {
                loaiPhong = "CC";
            } else if (loaiPhong.equalsIgnoreCase("Nâng cao")) {
                loaiPhong = "NC";
            } else {
                loaiPhong = "TG";
            }
            String.format("%s%s", kieuThue, loaiPhong);
        }

    }// GEN-LAST:event_btnThuePhongActionPerformed

    private void btnHuyActionPerformed() {// GEN-FIRST:event_btnHuyActionPerformed
        this.setVisible(false);
    }// GEN-LAST:event_btnHuyActionPerformed

    private void txtSoLuongTreEmActionPerformed() {// GEN-FIRST:event_txtSoLuongTreEmActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_txtSoLuongTreEmActionPerformed

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

    public void loadDanhSachPhongThue() {
        // Hiện danh sách phòng vào bảng
        String[] dsPhongThue = layDanhSachPhongThue();
        ArrayList<Phong> dsPhong = new ArrayList<Phong>();
        for (String tenPhong : dsPhongThue) {
            dsPhong.add(phongDao.timPhongTheoSoPhong(Integer.parseInt(tenPhong)));
        }
        DefaultTableModel model = (DefaultTableModel) tableDanhSachPhong.getModel();
        String loaiPhong = "";
        for (Phong phong : dsPhong) {
            loaiPhong = layTenLoaiPhong(phong.getMaLoaiPhong());
            Object[] rowData = {model.getRowCount() + 1, phong.getSoPhong(), loaiPhong};
            model.addRow(rowData);
        }
    }

    private void btnThemDichVuActionPerformed() {
        loadDanhSachDichVu();
        DichVuPhong dvPhong = new DichVuPhong();
        int selectedPhong = tableDanhSachPhong.getSelectedRow();
        if (selectedPhong != -1) {
            String tenPhong = tableDanhSachPhong.getValueAt(selectedPhong, 1).toString();
            String maDichVu = comboBoxDichVu.getSelectedItem().toString().split(" ")[0];
            dvPhong.setMaPhong(phongDao.timMaPhongTheoTenPhong(tenPhong));
            dvPhong.setMaDichVu(maDichVu);
            double giaDichVu = dvDao.timTheoMaDichVu(maDichVu).getGiaDV();
            DefaultTableModel model = (DefaultTableModel) tableDV.getModel();
            // Kiểm tra và tăng giá trị cột số lượng nếu trùng tên phòng và mã dịch vụ
            boolean daThem = false;
            for (int i = 0; i < model.getRowCount(); i++) {
                String tenPhongTrongBang = model.getValueAt(i, 3).toString();
                String maDichVuTrongBang = model.getValueAt(i, 1).toString().split(" ")[0];
                if (tenPhong.equals(tenPhongTrongBang) && maDichVu.equals(maDichVuTrongBang)) {
                    int soLuongHienTai = Integer.parseInt(model.getValueAt(i, 2).toString());
                    int soLuongMoi = soLuongHienTai + 1;
                    model.setValueAt(soLuongMoi, i, 2);
                    dvPhong.setSoLuong(soLuongMoi);
                    // Cập nhật lại giá dịch vụ
                    double giaMoi = giaDichVu * soLuongMoi;
                    model.setValueAt(giaMoi, i, 5);
                    daThem = true;
                    break;
                }
            }
            if (!daThem) {
                Object[] rowData = {model.getRowCount() + 1, comboBoxDichVu.getSelectedItem().toString(), 1, tenPhong,
                    dvDao.timTheoMaDichVu(maDichVu).getGiaDV(), giaDichVu};
                model.addRow(rowData);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn phòng cần thêm dịch vụ");
        }
    }// GEN-LAST:event_btnThemDichVuActionPerformed

    private void btnThemKhachHangActionPerformed() {// GEN-FIRST:event_btnThemKhachHangActionPerformed
        KhachHang kh = new KhachHang();
        kh.setCccd_passport(txtCCCD.getText());
        if (khachHangDao.timTheoCCCD(kh.getCccd_passport()) != null) {
            kh = khachHangDao.timTheoCCCD(kh.getCccd_passport());
            txtSoNguoiLon.setText(kh.getHoTenKH());
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng thêm khách hàng trước khi đặt phòng");
            return;
        }
    }// GEN-LAST:event_btnThemKhachHangActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
		 * If Nimbus (introduced in Java SE 6) is not available, stay with the default
		 * look and feel. For details see
		 * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ThuePhong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ThuePhong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ThuePhong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ThuePhong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
//		java.awt.EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				List<String> args = new ArrayList<String>();
//				args.add("101");
//				args.add("102");
//				args.add("103");
//				ThuePhong guiDatPhong = new ThuePhong(args);
//				guiDatPhong.setVisible(true);
//				guiDatPhong.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
//			}
//		});

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private giaodien.CustomClass.Button btnCCCD;
    private giaodien.CustomClass.Button btnHuy;
    private giaodien.CustomClass.Button btnNgayNhan;
    private giaodien.CustomClass.Button btnNgayTra;
    private giaodien.CustomClass.Button btnThemDichVu;
    private giaodien.CustomClass.Button btnThuePhong;
    private giaodien.CustomClass.Combobox cbKieuThue;
    private giaodien.CustomClass.Combobox cbxKieuThue;
    private giaodien.CustomClass.Combobox comboBoxDichVu;
    private giaodien.CustomClass.DateChooser dateNgayNhan;
    private giaodien.CustomClass.DateChooser dateNgayTra;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private giaodien.CustomClass.PanelRound panelRound1;
    private giaodien.CustomClass.PanelRound panelRound2;
    private giaodien.custom2.PanelRound panelRound3;
    private giaodien.custom2.PanelRound panelRound4;
    private javax.swing.JTable tableDV;
    private javax.swing.JTable tableDanhSachPhong;
    private giaodien.CustomClass.TextFieldShadow txtCCCD;
    private giaodien.CustomClass.TextFieldShadow txtCheckIn;
    private giaodien.CustomClass.TextFieldShadow txtCheckOut;
    private giaodien.CustomClass.TextFieldShadow txtSoNguoiLon;
    private giaodien.CustomClass.TextFieldShadow txtSoTreEm;
    private giaodien.CustomClass.TextFieldShadow txtTenKH;
    // End of variables declaration//GEN-END:variables
}
