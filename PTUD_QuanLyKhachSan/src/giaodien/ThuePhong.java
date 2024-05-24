package giaodien;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.ComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

import connectDB.ConnectDB;
import dao.DichVuDao;
import dao.DichVuPhongDao;
import dao.KhachHangDao;
import dao.LoaiPhongDao;
import dao.PhongDao;
import dao.ThongTinDatThuePhongDao;
import entity.DichVu;
import entity.DichVuPhong;
import entity.KhachHang;
import entity.Phong;
import java.awt.event.ActionEvent;

/**
 *
 * @author Huynguyen
 */
public class ThuePhong extends javax.swing.JDialog {

    private ArrayList<Phong> dsPhongThue;
    private DichVuDao dvDao;
    private PhongDao phongDao;
    private ThongTinDatThuePhongDao thongTinDatThuePhongDao;
    private LoaiPhongDao loaiPhongDao;
    private KhachHangDao khachHangDao;
    private DichVuPhongDao dichVuPhongDao;

    /**
     * Creates new form ThuePhong
     */
    public ThuePhong(List<String> dsTenPhong) {
        initComponents();
        phongDao = new PhongDao();
		dvDao = new DichVuDao();
		thongTinDatThuePhongDao = new ThongTinDatThuePhongDao();
		loaiPhongDao = new LoaiPhongDao();
		khachHangDao = new KhachHangDao();
        phongDao = new PhongDao();
        dichVuPhongDao = new DichVuPhongDao();
        ConnectDB.getInstance().getConnection();
        dsPhongThue = new ArrayList<>();
        for (String tenPhong : dsTenPhong) {
            dsPhongThue.add(phongDao.timPhongTheoSoPhong(Integer.parseInt(tenPhong)));
        }
        loadDanhSachPhongThue();
    }

    private static ComboBoxModel loadDanhSachDichVu() {
        DichVuDao dvDao = new DichVuDao();
        ArrayList<DichVu> danhSachDV = dvDao.timTatCaDichVu();
        String[] tenDV = new String[danhSachDV.size()];
        for (int i = 0; i < danhSachDV.size(); i++) {
            tenDV[i] = String.format("%s %s", danhSachDV.get(i).getMaDV(), danhSachDV.get(i).getTenDV());
        }
        return new javax.swing.DefaultComboBoxModel<>(tenDV);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
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
        txtCheckIn = new giaodien.CustomClass.TextFieldShadow();
        jLabel28 = new javax.swing.JLabel();
        txtCheckOut = new giaodien.CustomClass.TextFieldShadow();
        jLabel29 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        panelRound4 = new giaodien.custom2.PanelRound();
        cbKieuThue = new giaodien.CustomClass.Combobox();
        jLabel26 = new javax.swing.JLabel();
        txtTenKH = new giaodien.CustomClass.TextFieldShadow();
        btnKTSLPhong = new javax.swing.JButton();
        btnCCCD = new javax.swing.JButton();
        panelRound5 = new giaodien.CustomClass.PanelRound();
        cbxKieuThue = new giaodien.CustomClass.Combobox();
        btnKiemTraTrung = new javax.swing.JButton();
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

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel22.setText("Trẻ em");

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel24.setText("CCCD/Passport");

        txtCheckIn.setEnabled(false);

        jLabel28.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel28.setText("Ngày nhận");

        jLabel29.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel29.setText("Ngày trả");

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

        btnKTSLPhong.setText("Kiểm tra");
        btnKTSLPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKTSLPhongActionPerformed(evt);
            }
        });

        btnCCCD.setText("Thêm khách hàng");
        btnCCCD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCCCDActionPerformed(evt);
            }
        });

        panelRound5.setBackground(new java.awt.Color(255, 255, 255));
        panelRound5.setRoundBottomLeft(10);
        panelRound5.setRoundBottomRight(10);
        panelRound5.setRoundTopLeft(10);
        panelRound5.setRoundTopRight(10);

        cbxKieuThue.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Theo ngày", "Theo giờ ", "Qua đêm" }));
        cbxKieuThue.setLabeText("");

        javax.swing.GroupLayout panelRound5Layout = new javax.swing.GroupLayout(panelRound5);
        panelRound5.setLayout(panelRound5Layout);
        panelRound5Layout.setHorizontalGroup(
            panelRound5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbxKieuThue, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelRound5Layout.setVerticalGroup(
            panelRound5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cbxKieuThue, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        btnKiemTraTrung.setText("Kiểm tra trùng");
        btnKiemTraTrung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKiemTraTrungActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                    .addComponent(jLabel28, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCheckIn, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelRound1Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(txtTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelRound5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(27, 27, 27)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel24, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel26, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtSoNguoiLon, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                            .addComponent(txtCCCD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCheckOut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSoTreEm, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnKiemTraTrung)
                            .addComponent(btnCCCD))))
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panelRound4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44))
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(btnKTSLPhong)
                        .addContainerGap(88, Short.MAX_VALUE))))
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24)
                    .addComponent(txtCCCD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCCCD))
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelRound1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(panelRound4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelRound1Layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtSoTreEm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnKTSLPhong))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelRound1Layout.createSequentialGroup()
                                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelRound1Layout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel26)
                                            .addComponent(txtSoNguoiLon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(panelRound1Layout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(21, 21, 21)
                                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtCheckIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCheckOut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnKiemTraTrung)))
                            .addComponent(panelRound5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 44, Short.MAX_VALUE))))
        );

        panelRound2.setPreferredSize(new java.awt.Dimension(312, 72));
        panelRound2.setRoundBottomLeft(20);
        panelRound2.setRoundBottomRight(20);
        panelRound2.setRoundTopLeft(20);
        panelRound2.setRoundTopRight(20);

        btnThemDichVu.setText("Thêm dịch vụ");
        btnThemDichVu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemDichVuActionPerformed(evt);
            }
        });

        panelRound3.setBackground(new java.awt.Color(255, 255, 255));
        panelRound3.setRoundBottomLeft(15);
        panelRound3.setRoundBottomRight(15);
        panelRound3.setRoundTopLeft(15);
        panelRound3.setRoundTopRight(15);

        comboBoxDichVu.setModel(loadDanhSachDichVu());
        comboBoxDichVu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        comboBoxDichVu.setLabeText("");

        javax.swing.GroupLayout panelRound3Layout = new javax.swing.GroupLayout(panelRound3);
        panelRound3.setLayout(panelRound3Layout);
        panelRound3Layout.setHorizontalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound3Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(comboBoxDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );
        panelRound3Layout.setVerticalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(comboBoxDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 43, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panelRound2Layout = new javax.swing.GroupLayout(panelRound2);
        panelRound2.setLayout(panelRound2Layout);
        panelRound2Layout.setHorizontalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound2Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(panelRound3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11))
            .addGroup(panelRound2Layout.createSequentialGroup()
                .addGap(125, 125, 125)
                .addComponent(btnThemDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelRound2Layout.setVerticalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound2Layout.createSequentialGroup()
                .addContainerGap(53, Short.MAX_VALUE)
                .addComponent(panelRound3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnThemDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panelRound1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1171, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel32)
                                .addGap(203, 203, 203)
                                .addComponent(jLabel2))
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
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
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(btnThuePhong, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(panelRound2, javax.swing.GroupLayout.DEFAULT_SIZE, 369, Short.MAX_VALUE))))))
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

    private void btnCCCDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCCCDActionPerformed
    	KhachHang kh = new KhachHang();
        if (regCCCD_Passport(txtCCCD.getText()) == false) {
            return;
        }
        // Nếu khách hàng đang đặt/thuê phòng thì không thể thuê phòng
        if (thongTinDatThuePhongDao.timThongTinTheoMaKhachHang(khachHangDao.timTheoCCCD(txtCCCD.getText()).getMaKH())
                .size() != 0) {
            JOptionPane.showMessageDialog(this, "Khách hàng đã đặt phòng!");
            return;
        }
        if (khachHangDao.timTheoCCCD(txtCCCD.getText().trim()) != null) {
            kh = khachHangDao.timTheoCCCD(txtCCCD.getText().trim());
            txtTenKH.setText(kh.getHoTenKH());
        } else {
            JOptionPane.showMessageDialog(this, "Khách hàng hiện chưa được thêm!");
            return;
        }
    }//GEN-LAST:event_btnCCCDActionPerformed

    private void btnThemDichVuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemDichVuActionPerformed
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
        loadDanhSachDichVu();
    }//GEN-LAST:event_btnThemDichVuActionPerformed

    private void btnKiemTraTrungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKiemTraTrungActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnKiemTraTrungActionPerformed

    private void btnNgayTraActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnNgayTraActionPerformed
        dateNgayTra.showPopup();
    }// GEN-LAST:event_btnNgayTraActionPerformed

    private void btnKTSLPhongActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnKTSLPhongActionPerformed
        int soNguoiLon = txtSoNguoiLon.getText().isEmpty() ? 0 : Integer.parseInt(txtSoNguoiLon.getText());
        int soTreEm = txtSoTreEm.getText().isEmpty() ? 0 : Integer.parseInt(txtSoTreEm.getText());
        if (soNguoiLon <= 0 && soTreEm <= 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập số lượng người lớn hoặc trẻ em", "Lỗi",
                    JOptionPane.ERROR_MESSAGE);
            return;
        } else {
        	int sucChuaToiDa = tinhSucChuaDanhSachPhong(dsPhongThue);
            if (soNguoiLon > sucChuaToiDa || (soNguoiLon == sucChuaToiDa && soTreEm > soNguoiLon)) {
                JOptionPane.showMessageDialog(this, "Số lượng người vượt quá sức chứa của phòng", "Lỗi",
                        JOptionPane.ERROR_MESSAGE);
                return;
            } else {
                JOptionPane.showMessageDialog(this, "Số lượng người hợp lệ", "Thông báo",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }// GEN-LAST:event_btnKTSLPhongActionPerformed
    private int tinhSucChuaDanhSachPhong(List<Phong> dsPhong) {
        int suChuaToiDa = 0;
        for (Phong phong : dsPhong) {
            suChuaToiDa += loaiPhongDao.timTheoMaLoaiPhong(phong.getMaLoaiPhong()).getSoNguoiToiDa();
        }
        return suChuaToiDa;
    }

    private void btnThuePhongActionPerformed(ActionEvent evt) {// GEN-FIRST:event_btnThuePhongActionPerformed
        // GEN-FIRST:event_btnThuePhongActionPerformed
        KhachHang kh = khachHangDao.timTheoCCCD(txtCCCD.getText());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        LocalDate ngayNhan = LocalDate.parse(txtCheckIn.getText(), formatter);
        LocalDate ngayTra = LocalDate.parse(txtCheckOut.getText(), formatter);
        String loaiPhong = "";
        String kieuThue = "";
        String maLoaiThue = "";
        if (cbxKieuThue.getSelectedItem().toString().equals("Theo ngày")) {
            kieuThue = "D";
        } else if (cbxKieuThue.getSelectedItem().toString().equals("Theo giờ")) {
            kieuThue = "H";
        } else {
            kieuThue = "N";
        }

        for (Phong phong : dsPhongThue) {
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
            maLoaiThue = String.format("%s%s", kieuThue, loaiPhong);
        }
        

        // Thêm thông tin dịch vụ
        DichVuPhong dvPhong = new DichVuPhong();
        // Duyệt từng dòng trong bảng dịch vụ
		for (int i = 0; i < tableDV.getRowCount(); i++) {
			dvPhong.setMaPhong(phongDao.timMaPhongTheoTenPhong(tableDV.getValueAt(i, 3).toString()));
			dvPhong.setMaDichVu(tableDV.getValueAt(i, 1).toString().split(" ")[0]);
			dvPhong.setSoLuong(Integer.parseInt(tableDV.getValueAt(i, 2).toString()));
			System.out.println(dvPhong.getMaPhong() + " " + dvPhong.getMaDichVu() + " " + dvPhong.getSoLuong());
			// Thêm dịch vụ vào cơ sở dữ liệu
			dichVuPhongDao.themDichVuPhong(dvPhong);
		}

        // Thêm thông tin thuê phòng
        if (thongTinDatThuePhongDao.thuePhong(dsPhongThue, kh, ngayNhan, ngayNhan, maLoaiThue, ngayTra, 0)) {
            JOptionPane.showMessageDialog(this, "Thuê phòng thành công");
            this.setVisible(false);
        } else {
            JOptionPane.showMessageDialog(this, "Thuê phòng thất bại");
        }

    }// GEN-LAST:event_btnThuePhongActionPerformed

    private void btnHuyActionPerformed(ActionEvent evt) {// GEN-FIRST:event_btnHuyActionPerformed
        this.setVisible(false);
    }// GEN-LAST:event_btnHuyActionPerformed

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
        DefaultTableModel model = (DefaultTableModel) tableDanhSachPhong.getModel();
        String loaiPhong = "";
        for (Phong phong : dsPhongThue) {
            loaiPhong = layTenLoaiPhong(phong.getMaLoaiPhong());
            Object[] rowData = {model.getRowCount() + 1, phong.getSoPhong(), loaiPhong};
            model.addRow(rowData);
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
                return false;
            }
            return true;
        }
    }

    private void btnThemKhachHangActionPerformed(ActionEvent evt) {// GEN-FIRST:event_btnThemKhachHangActionPerformed
        KhachHang kh = new KhachHang();
        if (regCCCD_Passport(txtCCCD.getText()) == false) {
            return;
        }
        // Nếu khách hàng đang đặt/thuê phòng thì không thể thuê phòng
        if (thongTinDatThuePhongDao.timThongTinTheoMaKhachHang(khachHangDao.timTheoCCCD(txtCCCD.getText()).getMaKH())
                .size() > 0) {
            JOptionPane.showMessageDialog(this, "Khách hàng đã đặt/thuê phòng!");
            return;
        }
        if (khachHangDao.timTheoCCCD(txtCCCD.getText().trim()) != null) {
            kh = khachHangDao.timTheoCCCD(txtCCCD.getText().trim());
            txtTenKH.setText(kh.getHoTenKH());
        } else {
            JOptionPane.showMessageDialog(this, "Khách hàng hiện chưa được thêm!");
            return;
        }
    }// GEN-LAST:event_btnThemKhachHangActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCCCD;
    private giaodien.CustomClass.Button btnHuy;
    private javax.swing.JButton btnKTSLPhong;
    private javax.swing.JButton btnKiemTraTrung;
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
    private giaodien.CustomClass.PanelRound panelRound5;
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
