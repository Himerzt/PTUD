
package giaodien;

import java.awt.event.ActionEvent;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
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
import dao.LoaiThueDao;
import dao.PhongDao;
import dao.ThongTinDatThuePhongDao;
import entity.DichVu;
import entity.DichVuPhong;
import entity.KhachHang;
import entity.Phong;
import entity.ThongTinDatThuePhong;

/**
 *
 * @author Huynguyen
 */
public class DatPhong_GUI extends javax.swing.JDialog {

    private ArrayList<Phong> dsPhongDat;
    private DichVuDao dichVuDao;
    private DichVuPhongDao dichVuPhongDao;
    private ThongTinDatThuePhongDao thongTinDatThuePhongDao;
    private KhachHangDao khachHangDao;
    private LoaiThueDao loaiThueDao;
    private LoaiPhongDao loaiPhongDao;
    private PhongDao phongDao;

    /**
     * Creates new form DatPhong
     */
    public DatPhong_GUI(List<String> dsTenPhong) {
        initComponents();
        dichVuDao = new DichVuDao();
        thongTinDatThuePhongDao = new ThongTinDatThuePhongDao();
        khachHangDao = new KhachHangDao();
        loaiThueDao = new LoaiThueDao();
        loaiPhongDao = new LoaiPhongDao();
        phongDao = new PhongDao();
        dichVuPhongDao = new DichVuPhongDao();
        ConnectDB.getInstance().getConnection();
        dsPhongDat = new ArrayList<Phong>();
        for (String tenPhong : dsTenPhong) {
            dsPhongDat.add(phongDao.timPhongTheoSoPhong(Integer.parseInt(tenPhong)));
        }
        loadDanhSachPhongDat();
    }

    public ArrayList<Phong> getDsPhongDat() {
        return dsPhongDat;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dateNgayDat = new giaodien.CustomClass.DateChooser();
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
        txtTenKH = new giaodien.CustomClass.TextFieldShadow();
        txtSoNguoiLon = new giaodien.CustomClass.TextFieldShadow();
        jLabel22 = new javax.swing.JLabel();
        txtCCCD = new giaodien.CustomClass.TextFieldShadow();
        jLabel24 = new javax.swing.JLabel();
        btnThemKhachHang = new giaodien.CustomClass.Button();
        jLabel25 = new javax.swing.JLabel();
        txtCheckIn = new giaodien.CustomClass.TextFieldShadow();
        jLabel27 = new javax.swing.JLabel();
        txtNgayNhan = new giaodien.CustomClass.TextFieldShadow();
        jLabel28 = new javax.swing.JLabel();
        txtCheckOut = new giaodien.CustomClass.TextFieldShadow();
        jLabel29 = new javax.swing.JLabel();
        txtGiaCoc = new giaodien.CustomClass.TextFieldShadow();
        jLabel31 = new javax.swing.JLabel();
        btnGiaCoc = new giaodien.CustomClass.Button();
        txtSoTreEm = new giaodien.CustomClass.TextFieldShadow();
        jLabel23 = new javax.swing.JLabel();
        panelRound4 = new giaodien.custom2.PanelRound();
        cbKieuThue = new giaodien.CustomClass.Combobox();
        btnKiemTraTrung = new javax.swing.JButton();
        btnKTSLPhong = new javax.swing.JButton();
        panelRound2 = new giaodien.CustomClass.PanelRound();
        btnThemDichVu = new giaodien.CustomClass.Button();
        panelRound3 = new giaodien.custom2.PanelRound();
        comboBoxDichVu = new giaodien.CustomClass.Combobox();
        btnDatPhong = new giaodien.CustomClass.Button();
        btnHuy = new giaodien.CustomClass.Button();

        dateNgayDat.setForeground(new java.awt.Color(255, 203, 119));
        dateNgayDat.setTextRefernce(txtCheckIn);

        dateNgayTra.setForeground(new java.awt.Color(255, 203, 119));
        dateNgayTra.setTextRefernce(txtCheckOut);

        dateNgayNhan.setForeground(new java.awt.Color(255, 203, 119));
        dateNgayNhan.setTextRefernce(txtNgayNhan);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel1.setText("Đặt phòng");

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
        jLabel22.setText("Người lớn");

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

        jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel25.setText("Kiểu thuê");

        txtCheckIn.setEnabled(false);

        jLabel27.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel27.setText("Ngày đặt");

        jLabel28.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel28.setText("Ngày nhận");

        jLabel29.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel29.setText("Ngày trả");

        jLabel31.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel31.setText("Giá cọc");

        btnGiaCoc.setText("Xem tiền cọc");
        btnGiaCoc.setBorderColor(new java.awt.Color(47, 23, 23));
        btnGiaCoc.setRadius(10);
        btnGiaCoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGiaCocActionPerformed(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel23.setText("Trẻ em");

        panelRound4.setBackground(new java.awt.Color(255, 255, 255));
        panelRound4.setRoundBottomLeft(15);
        panelRound4.setRoundBottomRight(15);
        panelRound4.setRoundTopLeft(15);
        panelRound4.setRoundTopRight(15);

        cbKieuThue.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Theo ngày", "Qua đêm" }));
        cbKieuThue.setLabeText("");

        javax.swing.GroupLayout panelRound4Layout = new javax.swing.GroupLayout(panelRound4);
        panelRound4.setLayout(panelRound4Layout);
        panelRound4Layout.setHorizontalGroup(
            panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbKieuThue, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelRound4Layout.setVerticalGroup(
            panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(cbKieuThue, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        btnKiemTraTrung.setText("Kiểm tra trùng");
        btnKiemTraTrung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKiemTraTrungActionPerformed(evt);
            }
        });

        btnKTSLPhong.setText("Kiểm tra");
        btnKTSLPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKTSLPhongActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel31))
                    .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel25, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtCheckIn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panelRound4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtTenKH, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(23, 23, 23)
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel28, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelRound1Layout.createSequentialGroup()
                                .addComponent(txtCCCD, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnThemKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelRound1Layout.createSequentialGroup()
                                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtNgayNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtSoNguoiLon, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 25, Short.MAX_VALUE)
                                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtSoTreEm, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                                    .addComponent(txtCheckOut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addComponent(txtGiaCoc, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnGiaCoc, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnKiemTraTrung)
                    .addComponent(btnKTSLPhong))
                .addGap(9, 9, 9))
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCCCD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThemKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSoTreEm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25)
                    .addComponent(panelRound4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSoNguoiLon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnKTSLPhong))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtCheckIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtNgayNhan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCheckOut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnKiemTraTrung))))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGiaCoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtGiaCoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(65, 65, 65))
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
                .addContainerGap()
                .addComponent(comboBoxDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addContainerGap(32, Short.MAX_VALUE)
                .addComponent(panelRound3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
            .addGroup(panelRound2Layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addComponent(btnThemDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelRound2Layout.setVerticalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound2Layout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addComponent(panelRound3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnThemDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );

        btnDatPhong.setText("Đặt phòng");
        btnDatPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDatPhongActionPerformed(evt);
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
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(panelRound1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 1124, Short.MAX_VALUE)
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
                                                .addComponent(btnDatPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                                                .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(panelRound2, javax.swing.GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE)))))))
                        .addGap(12, 12, 12))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel32)
                                .addGap(203, 203, 203)
                                .addComponent(jLabel2)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(panelRound2, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnDatPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(30, 30, 30))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    private boolean btnKTSLPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKTSLPhongActionPerformed
        int soNguoiLon = txtSoNguoiLon.getText().isEmpty() ? 0 : Integer.parseInt(txtSoNguoiLon.getText());
        int soTreEm = txtSoTreEm.getText().isEmpty() ? 0 : Integer.parseInt(txtSoTreEm.getText());
        if (soNguoiLon <= 0 && soTreEm <= 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập số lượng người lớn hoặc trẻ em", "Lỗi",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        } else {
            int sucChuaToiDa = tinhSucChuaDanhSachPhong(dsPhongDat);
            if (soNguoiLon > sucChuaToiDa || (soNguoiLon == sucChuaToiDa && soTreEm > soNguoiLon)) {
                JOptionPane.showMessageDialog(this, "Số lượng người vượt quá sức chứa của phòng", "Lỗi",
                        JOptionPane.ERROR_MESSAGE);
                return false;
            } else if (soNguoiLon < dsPhongDat.size()) {
                JOptionPane.showMessageDialog(this, "Số lượng người không đủ sức chứa của phòng", "Lỗi",
                        JOptionPane.ERROR_MESSAGE);
                return false;
            } else {
                JOptionPane.showMessageDialog(this, "Số lượng người hợp lệ", "Thông báo",
                        JOptionPane.INFORMATION_MESSAGE);
                return true;
            }
        }
    }//GEN-LAST:event_btnKTSLPhongActionPerformed

    public boolean kiemTraTrungNgayNhan(String maPhong, LocalDateTime ngayNhan) {
        List<ThongTinDatThuePhong> dsTTDTP = thongTinDatThuePhongDao.timThongTinDatThuePhongTheoMaPhong(maPhong);
        for (ThongTinDatThuePhong thongTinDatThuePhong : dsTTDTP) {
            if (ngayNhan.isBefore(thongTinDatThuePhong.getNgayTraPhong())
                    && ngayNhan.isAfter(thongTinDatThuePhong.getNgayNhanPhong())) {
                JOptionPane.showMessageDialog(null,
                        "Ngày nhận phòng nằm trong khoảng thời gian thuê phòng đã có trước đó!", "Lỗi",
                        JOptionPane.ERROR_MESSAGE);
                return false;
            } else if (ngayNhan.equals(thongTinDatThuePhong.getNgayNhanPhong())) {
                JOptionPane.showMessageDialog(null, "Ngày nhận phòng trùng với ngày nhận phòng đã có trước đó!", "Lỗi",
                        JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        return true;
    }

    public boolean kiemTraTrungNgayTra(String maPhong, LocalDateTime ngayTra) {
        List<ThongTinDatThuePhong> dsTTDTP = thongTinDatThuePhongDao.timThongTinDatThuePhongTheoMaPhong(maPhong);
        for (ThongTinDatThuePhong thongTinDatThuePhong : dsTTDTP) {
            if (ngayTra.isBefore(thongTinDatThuePhong.getNgayTraPhong())
                    && ngayTra.isAfter(thongTinDatThuePhong.getNgayNhanPhong())) {
                JOptionPane.showMessageDialog(null,
                        "Ngày trả phòng nằm trong khoảng thời gian thuê phòng đã có trước đó!", "Lỗi",
                        JOptionPane.ERROR_MESSAGE);
                return false;
            } else if (ngayTra.equals(thongTinDatThuePhong.getNgayTraPhong())) {
                JOptionPane.showMessageDialog(null, "Ngày trả phòng trùng với ngày trả phòng đã có trước đó!", "Lỗi",
                        JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        return true;
    }

    public boolean kiemTraTrungThoiGianThue(String maPhong, LocalDateTime ngayNhan, LocalDateTime ngayTra) {
        List<ThongTinDatThuePhong> dsTTDTP = thongTinDatThuePhongDao.timThongTinDatThuePhongTheoMaPhong(maPhong);
        for (ThongTinDatThuePhong thongTinDatThuePhong : dsTTDTP) {
            LocalDateTime ngayNhanCoSan = thongTinDatThuePhong.getNgayNhanPhong();
            LocalDateTime ngayTraCoSan = thongTinDatThuePhong.getNgayTraPhong();
            // Kiểm tra khoảng thời gian từ ngày nhận đến ngày trả có chứa khoảng thời gian
            // khác có sẵn không
            if (ngayNhan.isBefore(ngayNhanCoSan) && ngayTra.isAfter(ngayTraCoSan)) {
                JOptionPane.showMessageDialog(null, "Trùng với thời gian thuê phòng đã có trước đó!");
                return false;
            } else if (ngayNhan.isAfter(ngayNhanCoSan) && ngayTra.isBefore(ngayTraCoSan)) {
                JOptionPane.showMessageDialog(null, "Trùng với thời gian thuê phòng đã có trước đó!");
                return false;
            }
        }
        return true;
    }

    private boolean btnKiemTraTrungActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnKiemTraTrungActionPerformed
        String ngayDatString = String.format("%s %s", txtCheckIn.getText(),
                LocalTime.now().truncatedTo(ChronoUnit.SECONDS).toString());
        String ngayNhanString = String.format("%s %s", txtNgayNhan.getText(), "14:00:00".toString());
        String ngayTraString = String.format("%s %s", txtCheckOut.getText(), "09:00:00".toString());
        // Chuyển đổi ngày nhận và ngày trả từ String sang LocalDateTime
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        LocalDateTime ngayDat = LocalDateTime.parse(ngayDatString, formatter);
        LocalDateTime ngayNhan = LocalDateTime.parse(ngayNhanString, formatter);
        LocalDateTime ngayTra = LocalDateTime.parse(ngayTraString, formatter);
        // Thêm thông tin dịch vụ
        // Thêm thông tin dịch vụ
        List<DichVuPhong> dsDVP = new ArrayList<>();
        // Duyệt từng dòng trong bảng dịch vụ
        for (int i = 0; i < tableDV.getRowCount(); i++) {
            DichVuPhong dvPhong = new DichVuPhong();
            dvPhong.setMaPhong(phongDao.timMaPhongTheoTenPhong(tableDV.getValueAt(i, 3).toString()));
            dvPhong.setMaDichVu(tableDV.getValueAt(i, 1).toString().split(" ")[0]);
            dvPhong.setSoLuong(Integer.parseInt(tableDV.getValueAt(i, 2).toString()));
            dsDVP.add(dvPhong);
        }
        dichVuPhongDao.themDichVuPhongTTK(dsDVP);
        for (Phong phong : dsPhongDat) {
            // Kiểm tra trùng ngày nhận
            if (!kiemTraTrungNgayNhan(phong.getMaPhong(), ngayNhan)) {
                JOptionPane.showMessageDialog(null, "Ngày nhận phòng trùng với ngày nhận phòng đã có trước đó!", "Lỗi",
                        JOptionPane.ERROR_MESSAGE);
                return false;
            } else if (ngayNhan.isBefore(ngayDat) || ngayNhan.equals(ngayDat)) {
                JOptionPane.showMessageDialog(null, "Ngày nhận phòng phải sau ngày đặt phòng!", "Lỗi",
                        JOptionPane.ERROR_MESSAGE);
                return false;
            }
            // Kiểm tra trùng ngày trả
            if (!kiemTraTrungNgayTra(phong.getMaPhong(), ngayTra)) {
                JOptionPane.showMessageDialog(null, "Ngày trả phòng trùng với ngày trả phòng đã có trước đó!", "Lỗi",
                        JOptionPane.ERROR_MESSAGE);
                return false;
            } else if (ngayTra.isBefore(ngayNhan) || ngayTra.isBefore(ngayDat) || ngayTra.isEqual(ngayNhan)
                    || ngayTra.isEqual(ngayDat)) {
                JOptionPane.showMessageDialog(null, "Ngày trả phòng phải sau ngày đặt phòng và ngày nhận phòng!", "Lỗi",
                        JOptionPane.ERROR_MESSAGE);
                return false;
            }
            // Kiểm tra trùng thời gian thuê
            if (!kiemTraTrungThoiGianThue(phong.getMaPhong(), ngayNhan, ngayTra)) {
                JOptionPane.showMessageDialog(null, "Trùng với thời gian thuê phòng đã có trước đó!", "Lỗi",
                        JOptionPane.ERROR_MESSAGE);
                return false;
            }
            // Nếu kiểu thuê là thuê qua đêm thì thời gian thuê phải là 1 ngày
            if (cbKieuThue.getSelectedItem().toString().equals("Qua đêm")) {
                if (ngayTra.minusDays(1).isAfter(ngayNhan)) {
                    JOptionPane.showMessageDialog(null, "Thời gian thuê phòng qua đêm chỉ được tôi đa là 1 ngày!",
                            "Lỗi", JOptionPane.ERROR_MESSAGE);
                    return false;
                }
            }
        }
        // Nếu không trùng thì thông báo thành công
        JOptionPane.showMessageDialog(null, "Thời gian thuê không trùng, có thể tiến hành đặt phòng!", "Thông báo",
                JOptionPane.INFORMATION_MESSAGE);
        return true;
    }// GEN-LAST:event_btnKiemTraTrungActionPerformed

    private int tinhSucChuaDanhSachPhong(List<Phong> dsPhong) {
        int suChuaToiDa = 0;
        for (Phong phong : dsPhong) {
            suChuaToiDa += loaiPhongDao.timTheoMaLoaiPhong(phong.getMaLoaiPhong()).getSoNguoiToiDa();
        }
        return suChuaToiDa;
    }

    // Kiểm tra khách hàng có đang đặt phòng hay không
    // Nếu có trong danh sách và ngày nhận phòng chưa qua ngày hiện tại hoặc ngày
    // nhận phòng đã qua và ngày trả phòng chưa qua thì không thể đặt phòng
    public boolean kiemTraKhachHangDatPhong(String cccd) {
        List<ThongTinDatThuePhong> dsTTDTP = thongTinDatThuePhongDao
                .timThongTinTheoMaKhachHang(khachHangDao.timTheoCCCD(cccd).getMaKH());
        for (ThongTinDatThuePhong thongTinDatThuePhong : dsTTDTP) {
            if (thongTinDatThuePhong.getNgayNhanPhong().isBefore(LocalDateTime.now())
                    || (thongTinDatThuePhong.getNgayNhanPhong().isAfter(LocalDateTime.now())
                    && thongTinDatThuePhong.getNgayTraPhong().isBefore(LocalDateTime.now()))) {
                JOptionPane.showMessageDialog(null, "Khách hàng đã đặt phòng!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        return true;
    }

    private boolean btnThemKhachHangActionPerformed(ActionEvent evt) {// GEN-FIRST:event_btnThemKhachHangActionPerformed
        KhachHang kh = new KhachHang();
        if (regCCCD_Passport(txtCCCD.getText()) == false) {
            return false;
        }
		if (khachHangDao.timTheoCCCD(txtCCCD.getText()) == null) {
			JOptionPane.showMessageDialog(this, "Khách hàng chưa được thêm!", "Lỗi", JOptionPane.ERROR_MESSAGE);
			return false;
		}
        // Nếu khách hàng đang đặt/thuê phòng thì không thể thuê phòng
        if (thongTinDatThuePhongDao.timThongTinTheoMaKhachHang(khachHangDao.timTheoCCCD(txtCCCD.getText()).getMaKH())
                .size() != 0) {
            JOptionPane.showMessageDialog(this, "Khách hàng đã đặt phòng!");
            return false;
        }
        if (khachHangDao.timTheoCCCD(txtCCCD.getText().trim()) != null) {
            kh = khachHangDao.timTheoCCCD(txtCCCD.getText().trim());
            txtTenKH.setText(kh.getHoTenKH());
            return true;
        } else {
            JOptionPane.showMessageDialog(this, "Khách hàng hiện chưa được thêm!");
            return false;
        }
    }// GEN-LAST:event_btnThemKhachHangActionPerformed

    private boolean btnGiaCocActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnGiaCocActionPerformed
        txtGiaCoc.setText(String.valueOf(tinhTienCoc()));
        return true;
    }// GEN-LAST:event_btnGiaCocActionPerformed

    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnHuyActionPerformed
        this.setVisible(false);
    }// GEN-LAST:event_btnHuyActionPerformed

    private void btnDatPhongActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnDatPhongActionPerformed
        ArrayList<Phong> dsPhongDat = getDsPhongDat();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        LocalDateTime ngayDat = LocalDateTime.parse(
                String.format("%s %s", txtCheckIn.getText(), LocalTime.now().truncatedTo(ChronoUnit.SECONDS)),
                formatter);
        LocalDateTime ngayNhan = LocalDateTime.parse(String.format("%s %s", txtNgayNhan.getText(), "14:00:00"),
                formatter);
        LocalDateTime ngayTra = LocalDateTime.parse(String.format("%s %s", txtCheckOut.getText(), "09:00:00"),
                formatter);
        String loaiPhong = "";
        String kieuThue = "";
        String maLoaiThue = "";
        if (cbKieuThue.getSelectedItem().toString().equals("Theo ngày")) {
            kieuThue = "D";
        } else if (cbKieuThue.getSelectedItem().toString().equals("Theo giờ")) {
            kieuThue = "H";
        } else {
            kieuThue = "N";
        }

        for (Phong phong : dsPhongDat) {
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
        // Kiểm tra lại toàn bộ thông tin trước khi đặt phòng
        // Khách hàng
        if (!btnThemKhachHangActionPerformed(evt)) {
            JOptionPane.showMessageDialog(this, "Chưa có thông tin khách hàng", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        // Số người lớn và trẻ em
        if (!btnKTSLPhongActionPerformed(evt)) {
            JOptionPane.showMessageDialog(this, "Số lượng người không hợp lệ", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        // Ngày đăt, nhận và trả phòng
        if (!btnKiemTraTrungActionPerformed(evt)) {
            JOptionPane.showMessageDialog(this, "Thời gian đặt phòng không hợp lệ", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        // Kiểm tra tiền cọc
        if (!btnGiaCocActionPerformed(evt)) {
            JOptionPane.showMessageDialog(this, "Tiền cọc chưa được hiển thị để thông báo cho khách hàng", "Lỗi",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (thongTinDatThuePhongDao.datPhong(dsPhongDat, khachHangDao.timTheoCCCD(txtCCCD.getText()), ngayDat, ngayNhan,
                ngayTra, maLoaiThue, tinhTienCoc(), "Đặt")) {
            JOptionPane.showMessageDialog(this, "Đặt phòng thành công");
            DatPhong_GUI.this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Đặt phòng thất bại");
        }
    }// GEN-LAST:event_btnDatPhongActionPerformed

    private void btnThemDichVuActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnThemDichVuActionPerformed
        loadDanhSachDichVu();
        DichVuPhong dvPhong = new DichVuPhong();
        int selectedPhong = tableDanhSachPhong.getSelectedRow();
        if (selectedPhong != -1) {
            String tenPhong = tableDanhSachPhong.getValueAt(selectedPhong, 1).toString();
            String maDichVu = comboBoxDichVu.getSelectedItem().toString().split(" ")[0];
            dvPhong.setMaPhong(phongDao.timMaPhongTheoTenPhong(tenPhong));
            dvPhong.setMaDichVu(maDichVu);
            double giaDichVu = dichVuDao.timTheoMaDichVu(maDichVu).getGiaDV();
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
                    dichVuDao.timTheoMaDichVu(maDichVu).getGiaDV(), giaDichVu};
                model.addRow(rowData);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn phòng cần thêm dịch vụ");
        }
    }// GEN-LAST:event_btnThemDichVuActionPerformed

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
        ArrayList<Phong> dsPhong = getDsPhongDat();
        DefaultTableModel model = (DefaultTableModel) tableDanhSachPhong.getModel();
        String loaiPhong = "";
        for (Phong phong : dsPhong) {
            loaiPhong = layTenLoaiPhong(phong.getMaLoaiPhong());
            Object[] rowData = {model.getRowCount() + 1, phong.getSoPhong(), loaiPhong};
            model.addRow(rowData);
        }
    }

    public double tinhTienCoc() {
        String maLoaiThue = "";
        double soTienCoc = 0;
        // Tính tiền cọc
        for (Phong phong : dsPhongDat) {
            maLoaiThue = loaiThueDao.timMaLoaiThue(cbKieuThue.getSelectedItem().toString(), phong.getMaLoaiPhong());
            soTienCoc += loaiThueDao.timGiaCocTheoMaThue(maLoaiThue);
            System.out.println(soTienCoc);
        }
        return soTienCoc;
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private giaodien.CustomClass.Button btnDatPhong;
    private giaodien.CustomClass.Button btnGiaCoc;
    private giaodien.CustomClass.Button btnHuy;
    private javax.swing.JButton btnKTSLPhong;
    private javax.swing.JButton btnKiemTraTrung;
    private giaodien.CustomClass.Button btnThemDichVu;
    private giaodien.CustomClass.Button btnThemKhachHang;
    private giaodien.CustomClass.Combobox cbKieuThue;
    private giaodien.CustomClass.Combobox comboBoxDichVu;
    private giaodien.CustomClass.DateChooser dateNgayDat;
    private giaodien.CustomClass.DateChooser dateNgayNhan;
    private giaodien.CustomClass.DateChooser dateNgayTra;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel31;
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
    private giaodien.CustomClass.TextFieldShadow txtGiaCoc;
    private giaodien.CustomClass.TextFieldShadow txtNgayNhan;
    private giaodien.CustomClass.TextFieldShadow txtSoNguoiLon;
    private giaodien.CustomClass.TextFieldShadow txtSoTreEm;
    private giaodien.CustomClass.TextFieldShadow txtTenKH;
    // End of variables declaration//GEN-END:variables
}
