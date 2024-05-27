package giaodien;

import java.awt.event.ActionEvent;
import java.awt.font.FontRenderContext;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import connectDB.ConnectDB;
import dao.ChiTietHoaDonDao;
import dao.DichVuDao;
import dao.DichVuPhongDao;
import dao.HoaDonDao;
import dao.KhachHangDao;
import dao.KhuyenMaiDao;
import dao.NhanVienDao;
import dao.PhongDao;
import dao.ThongTinDatThuePhongDao;
import entity.ChiTietHoaDon;
import entity.DichVu;
import entity.DichVuPhong;
import entity.HoaDon;
import entity.KhachHang;
import entity.KhuyenMai;
import entity.NhanVien;
import entity.Phong;
import entity.ThongTinDatThuePhong;

import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

/**
 *
 * @author Huynguyen
 */
public class TraPhong_GUI extends javax.swing.JDialog {

    private NhanVien nhanvien;
    private NhanVienDao nvdao;
    private List<DichVuPhong> danhSachDichVu;
    private static String[] dsPhongDat;
    private static List<String> dsTenPhong;
    private ThongTinDatThuePhongDao thongTinDao;
    private KhachHangDao khachHangDao;
    private DichVuDao dichVuDao;
    private double tongGiaDichVu = 0;
    private double tongGiaPhong = 0;
    private double tongGia = 0;
    private double chietKhau = 0;
    private double thue = 0;
    private double tienCanThu = 0;
    private double tienTraTruoc = 0;
    private double tongHoaDon = 0;
    private HoaDon hoaDonluuTru;
    private String maLSDP;
    private String maKhuyenMai;
    private String maNhanVien;

    /**
     * Creates new form DatPhong
     */
    public TraPhong_GUI() {
        initComponents();
    }

    public TraPhong_GUI(List<String> dsTenPhong, NhanVien nv) {
        this.nhanvien = nv;
        dsPhongDat = new String[dsTenPhong.size()];
        int index = 0;
        for (String tenPhong : dsTenPhong) {
            dsPhongDat[index++] = tenPhong;
        }
        ConnectDB.getInstance().getConnection();
        initComponents();
        loadThongTinTraPhong();
        loadDanhSachPhong();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jScrollPane2 = new giaodien.CustomClass.ScrollPaneWin11();
        tableDanhSachPhong = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new giaodien.CustomClass.ScrollPaneWin11();
        tableDV = new javax.swing.JTable();
        panelTraPhong = new giaodien.CustomClass.PanelRound();
        jLabel17 = new javax.swing.JLabel();
        txtTenKH = new giaodien.CustomClass.TextFieldShadow();
        txtHangThanhVienKH = new giaodien.CustomClass.TextFieldShadow();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txtSodienthoaiKH = new giaodien.CustomClass.TextFieldShadow();
        txtNgaySinh = new giaodien.CustomClass.TextFieldShadow();
        jLabel22 = new javax.swing.JLabel();
        txtChietKhau = new giaodien.CustomClass.TextFieldShadow();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        txtThue = new giaodien.CustomClass.TextFieldShadow();
        jLabel25 = new javax.swing.JLabel();
        txtNhanVien = new giaodien.CustomClass.TextFieldShadow();
        txtTongHoaDon = new giaodien.CustomClass.TextFieldShadow();
        jLabel27 = new javax.swing.JLabel();
        txtTraTruoc = new giaodien.CustomClass.TextFieldShadow();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        txtTienCanThu = new giaodien.CustomClass.TextFieldShadow();
        txtMaKhachHang = new giaodien.CustomClass.TextFieldShadow();
        jLabel30 = new javax.swing.JLabel();
        btnTraPhong = new giaodien.CustomClass.Button();
        btnHuy = new giaodien.CustomClass.Button();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel1.setText("Trả phòng");

        jLabel32.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel32.setText("Danh sách phòng");

        tableDanhSachPhong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã phòng", "Tên phòng", "Loại phòng", "Kiểu thuê", "Ngày đặt", "Ngày nhận", "Ngày trả"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
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
        if (tableDanhSachPhong.getColumnModel().getColumnCount() > 0) {
            tableDanhSachPhong.getColumnModel().getColumn(0).setMaxWidth(60);
        }

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Danh sách dịch vụ");

        tableDV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã dịch vụ", "Tên dịch vụ", "Số lượng", "Phòng", "Giá"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.String.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class
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
        tableDV.setRowHeight(40);
        jScrollPane1.setViewportView(tableDV);
        if (tableDV.getColumnModel().getColumnCount() > 0) {
            tableDV.getColumnModel().getColumn(0).setMaxWidth(60);
        }

        panelTraPhong.setRoundBottomLeft(20);
        panelTraPhong.setRoundBottomRight(20);
        panelTraPhong.setRoundTopLeft(20);
        panelTraPhong.setRoundTopRight(20);

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel17.setText("Tên khách hàng");

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel18.setText("Hạng thành viên");

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel19.setText("Số điện thoại");

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel22.setText("Ngày sinh");

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel23.setText("Chiết khấu");

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel24.setText("Thuế VAT");

        jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel25.setText("Nhân viên");

        jLabel27.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel27.setText("Tổng tiền");

        jLabel28.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel28.setText("Đã trả trước");

        jLabel29.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel29.setText("Tiền cần thu");

        jLabel30.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel30.setText("Mã khách hàng");

        javax.swing.GroupLayout panelTraPhongLayout = new javax.swing.GroupLayout(panelTraPhong);
        panelTraPhong.setLayout(panelTraPhongLayout);
        panelTraPhongLayout.setHorizontalGroup(
            panelTraPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTraPhongLayout.createSequentialGroup()
                .addGap(14, 23, Short.MAX_VALUE)
                .addGroup(panelTraPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTraPhongLayout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addGap(18, 18, 18)
                        .addComponent(txtTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTraPhongLayout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addGap(18, 18, 18)
                        .addComponent(txtSodienthoaiKH, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTraPhongLayout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addGap(18, 18, 18)
                        .addComponent(txtHangThanhVienKH, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelTraPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelTraPhongLayout.createSequentialGroup()
                        .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelTraPhongLayout.createSequentialGroup()
                        .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(txtThue, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelTraPhongLayout.createSequentialGroup()
                        .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(txtNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(panelTraPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelTraPhongLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(panelTraPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelTraPhongLayout.createSequentialGroup()
                                .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(txtTongHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelTraPhongLayout.createSequentialGroup()
                                .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(txtTraTruoc, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelTraPhongLayout.createSequentialGroup()
                                .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(txtTienCanThu, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTraPhongLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(txtMaKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTraPhongLayout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(jLabel23)
                        .addGap(18, 18, 18)
                        .addComponent(txtChietKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        panelTraPhongLayout.setVerticalGroup(
            panelTraPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTraPhongLayout.createSequentialGroup()
                .addGroup(panelTraPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelTraPhongLayout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(panelTraPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)
                        .addGroup(panelTraPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtHangThanhVienKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(63, 63, 63)
                        .addGroup(panelTraPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTraTruoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelTraPhongLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelTraPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(panelTraPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelTraPhongLayout.createSequentialGroup()
                                .addGap(63, 63, 63)
                                .addGroup(panelTraPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtSodienthoaiKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(panelTraPhongLayout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addGroup(panelTraPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelTraPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtThue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panelTraPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtChietKhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(11, 11, 11)
                                .addGroup(panelTraPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTongHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(panelTraPhongLayout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(panelTraPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMaKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(167, 167, 167)
                        .addGroup(panelTraPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTienCanThu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        btnTraPhong.setText("Trả phòng");
        btnTraPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTraPhongActionPerformed(evt);
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
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane2)
                        .addComponent(panelTraPhong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 916, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnTraPhong, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                            .addComponent(btnHuy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jLabel32))
                .addContainerGap(10, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelTraPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jLabel32)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnTraPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnTraPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTraPhongActionPerformed

        // Hỏi nhắc có muốn thực hiện trả phòng và xuất hóa đơn hay không
        int input = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn trả phòng và xuất hóa đơn không?", "Xác nhận trả phòng",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (input == 0) {
            // Tạo hóa đơn và chi tiết hóa đơn
            if (taoHoaDonvaCTHDDatabase()) {
                JOptionPane.showMessageDialog(null, "Trả phòng thành công", "Thành công",
                        JOptionPane.INFORMATION_MESSAGE);
                // gọi hóa đơn
                HoaDonThanhToan_GUI hoaDonThanhToan = new HoaDonThanhToan_GUI(hoaDonluuTru);
                hoaDonThanhToan.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                hoaDonThanhToan.setVisible(true);
                this.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(null, "Trả phòng thất bại", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        }

    }//GEN-LAST:event_btnTraPhongActionPerformed

    protected boolean taoHoaDonvaCTHDDatabase() {
        // Tạo mã hóa đơn HD + ngày + tháng + năm + số hóa đơn tự tăng trong ngày tìm trong database
        LocalDate now = LocalDate.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("ddMMyyyy");
        String ngay = dtf.format(now);

        // Định dạng số hóa đơn trong ngày 3 chữ số
        // Kiểm tra mã hóa đơn trong database
        // Nếu có thì tăng số hóa đơn lên so với số hóa đơn cuối cùng trong ngày
        // Nếu không thì tạo hóa đơn mới
        HoaDonDao hd = new HoaDonDao();
        int orderNumber = hd.demSoHoaDonTrongNgay(now);
        if (orderNumber == 0) {
            orderNumber = 1;
        } else {
            orderNumber++;
        }
        String formattedOrderNumber = String.format("%03d", orderNumber);
        String maHoaDon = "HD" + ngay + formattedOrderNumber;
        // Lấy mã nhân viên từ txtNhanVien
        String maNhanVien = nhanvien.getMaNV();
        // Lấy mã khách hàng từ txtMaKhachHang
        String maKhachHang = txtMaKhachHang.getText();
        // Lấy ngày lập hóa đơn từ ngày giờ hiện tại
        LocalDateTime ngayLap = LocalDateTime.now();
        // Tạo hóa đơn

        HoaDon hoaDon = new HoaDon(maHoaDon, maNhanVien, maKhachHang, ngayLap, maLSDP, maKhuyenMai, tongGia);
        this.hoaDonluuTru = hoaDon;

        PhongDao phong = new PhongDao();
        ArrayList<String> dsMaPhong = new ArrayList<>();
        for (String phongDat : dsPhongDat) {
            dsMaPhong.add(phong.timPhongTheoSoPhong(Integer.parseInt(phongDat)).getMaPhong());
        }
        // Lấy thông tin đặt thuê phòng và mã khách hàng

        ArrayList<ThongTinDatThuePhong> dsThongTin = new ArrayList<>();
        for (String maPhong : dsMaPhong) {
            dsThongTin.addAll(thongTinDao.timThongTinDatThuePhongTheoMaPhong(maPhong));
        }

        // Thêm hóa đơn vào database
        if (!hd.themHoaDon(hoaDon)) {
            JOptionPane.showMessageDialog(null, "Tạo hóa đơn thất bại", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        // Tạo chi tiết hóa đơn tương ứng CTHD - mã hóa đơn -- nhiều chi tiết tương ứng + stt trong db
        // với thông tin đặt thuê phòng
        ChiTietHoaDonDao chiTietHoaDonDao = new ChiTietHoaDonDao();
        for (ThongTinDatThuePhong thongTinDatThuePhong : dsThongTin) {
            // Xử lý ngày lập hóa đơn của hoaDonluuTru
            LocalDateTime ngaylaphoaDonns = hoaDonluuTru.getNgayLap();
            // Đổi localdatetime sang localdate
            LocalDate ngayLapHoaDonz = ngaylaphoaDonns.toLocalDate();
            int stt = 1;
            if (chiTietHoaDonDao.demTongSoChiTietHoaDonTrongNgay(ngayLapHoaDonz) > 0) {
                stt = chiTietHoaDonDao.demTongSoChiTietHoaDonTrongNgay(ngayLapHoaDonz) + 1;
            }

            String maCTHD = "CTHD-" + hoaDonluuTru.getMaHoaDon() + stt;
            ChiTietHoaDon chiTietHoaDon = new ChiTietHoaDon(maCTHD, hoaDonluuTru.getMaHoaDon(),
                    thongTinDatThuePhong.getMaTTDTP());
            // Thêm chi tiết hóa đơn vào database

            if (chiTietHoaDonDao.themChiTietHoaDon(chiTietHoaDon)) {
                JOptionPane.showMessageDialog(null, "Tạo chi tiết hóa đơn thành công", "Thành công",
                        JOptionPane.INFORMATION_MESSAGE);
                continue;
            } else {
                JOptionPane.showMessageDialog(null, "Tạo chi tiết hóa đơn thất bại", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return false;
            }

        }
        

        // Thay đổi dữ liệu phòng thuê
        PhongDao phongdaooo = new PhongDao();
        
        for (String phongDat : dsMaPhong) {
        	boolean kq = phongdaooo.capNhatTrangThaiPhong(phongDat, "Trống");
        	if(kq) {
        		JOptionPane.showMessageDialog(null, "Cập nhật trạng thái phòng thành công", "Thành công",
                        JOptionPane.INFORMATION_MESSAGE);
        	} else {
				JOptionPane.showMessageDialog(null, "Cập nhật trạng thái phòng thất bại", "Lỗi",
						JOptionPane.ERROR_MESSAGE);
				return false;
        	}
        }

        

        return true;
    }

    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnHuyActionPerformed
        this.setVisible(false);
    }// GEN-LAST:event_btnHuyActionPerformed

    // Load thông tin vào textfield
    protected void loadThongTinTraPhong() {
        // Từ dsPhongDat đặt lấy danh sách mã phòng
        thongTinDao = new ThongTinDatThuePhongDao();
        khachHangDao = new KhachHangDao();
        dichVuDao = new DichVuDao();
        PhongDao phong = new PhongDao();

        // Lấy mã phòng từ dsPhongDat
        ArrayList<String> dsMaPhong = new ArrayList<>();
        for (String phongDat : dsPhongDat) {
            dsMaPhong.add(phong.timPhongTheoSoPhong(Integer.parseInt(phongDat)).getMaPhong());
        }
        // Lấy thông tin đặt thuê phòng và mã khách hàng

        ArrayList<ThongTinDatThuePhong> dsThongTin = new ArrayList<>();
        for (String maPhong : dsMaPhong) {
            dsThongTin.addAll(thongTinDao.timThongTinDatThuePhongTheoMaPhong(maPhong));
        }

        // Lấy mã khách hàng từ thông tin đặt phòng
        String maKhachHang = dsThongTin.get(0).getMaKhachHang();
        // Xử lý thông tin khách hàng
        KhachHang khachHang = khachHangDao.timTheoMaKhachHang(maKhachHang);
        // Tính tỉ lệ chiết khấu
        String hangTV = "";
        double chietKhau = 0;
        if (khachHang.getMaHangThanhVien().equalsIgnoreCase("hb")) {
            hangTV = "Hạng Bạc - 3.75%";
            chietKhau = 0.0375;
        } else if (khachHang.getMaHangThanhVien().equalsIgnoreCase("hv")) {
            hangTV = "Hạng Vàng - 7.5%";
            chietKhau = 0.075;
        } else if (khachHang.getMaHangThanhVien().equalsIgnoreCase("kc")) {
            hangTV = "Hạng Kim Cương - 18.75%";
            chietKhau = 0.1875;
        } else if (khachHang.getMaHangThanhVien().equalsIgnoreCase("lb")) {
            hangTV = "Hạng Lục Bảo - 15%";
            chietKhau = 0.15;
        } else {
            hangTV = "Hạng Bạch Kim - 11.25%";
            chietKhau = 0.1125;
        }
        this.chietKhau = chietKhau;
        // Tính tiền phòng
        double tongTienPhong = 0;
        Phong phongThue = new Phong();
        for (String maPhong : dsMaPhong) {
            phongThue = phong.timPhongTheoMaPhong(maPhong);
            if (phongThue.getMaLoaiPhong().equalsIgnoreCase("tc")) {
                tongTienPhong += 450000;
            } else if (phongThue.getMaLoaiPhong().equalsIgnoreCase("nc")) {
                tongTienPhong += 700000;
            } else if (phongThue.getMaLoaiPhong().equalsIgnoreCase("cc")) {
                tongTienPhong += 1000000;
            } else {
                tongTienPhong += 1500000;
            }
        }
        this.tongGiaPhong = tongTienPhong;
        // Tính tiền dịch vụ
        double tongTienDichVu = 0;
        DichVuPhongDao dichVuPhongDao = new DichVuPhongDao();
        ArrayList<DichVuPhong> dsDichVu = new ArrayList<>();
        for (String maPhong : dsMaPhong) {
            dsDichVu.addAll(dichVuPhongDao.timDichVuSuDungTheoMaPhong(maPhong));
        }

        DefaultTableModel model = (DefaultTableModel) tableDV.getModel();
        model.setRowCount(0);
        int i = 0;
        for (DichVuPhong dv : dsDichVu) {
            // Tạo model cho tableDV STT mã dịch vụ tên dịch vụ số lượng phòng giá
            i++;
            String maDV = dv.getMaDichVu();
            String tenDV = new DichVuDao().timTheoMaDichVu(maDV).getTenDV();
            int soLuong = dv.getSoLuong();
            String maPhong = dv.getMaPhong();
            // Tính giá dịch vụ bằng tìm kiếm theo mã dịch vụ lấy giá thông qua entity dichvuz
            double gia = new DichVuDao().timTheoMaDichVu(maDV).getGiaDV();
            model.addRow(new Object[]{i, maDV, tenDV, soLuong, gia, gia * soLuong});
            tongTienDichVu += gia;
        }
        this.tongGiaDichVu = tongTienDichVu;
        // Tính tiền trả phòng trễ hơn 12h quá 1-3 tiếng 30% 3-6 tiếng 50% hơn 6 tiếng 100% tính vào tiền phòng
        double tienTraPhongTre = 0;
        // Lấy giờ hiện tại để trả phòng
        int gioTraPhong = LocalDate.now().getDayOfMonth();
        if (gioTraPhong > 12) {
            if (gioTraPhong <= 13) {
                tienTraPhongTre += 0;
            } else if (gioTraPhong <= 15) {
                tienTraPhongTre = tongTienPhong * 0.3;
            } else if (gioTraPhong <= 18) {
                tienTraPhongTre = tongTienPhong * 0.5;
            } else {
                tienTraPhongTre = tongTienPhong;
            }
        }
        // Tính tiền đổi phòng nếu có --- CHƯA CÓ DỮ LIỆU
        double tienDoiPhong = 0;
        // Tính tổng tiền
        double tongTien = tongTienPhong + tongTienDichVu + tienTraPhongTre + tienDoiPhong;
        // Tính chiết khấu
        tongTien -= tongTien * chietKhau;
        // Thêm khuyến mãi
        KhuyenMai khuyenMai = new KhuyenMai();
        KhuyenMaiDao khuyenMaiDao = new KhuyenMaiDao();
        //  ngày hiện còn trong khuyến mãi và đủ điều kiện thì áp dụng khuyến mãi tìm tất cả khuyến mãi và kiểm tra lấy giá trị khuyến mãi lớn nhât
        ArrayList<KhuyenMai> dsKhuyenMai = khuyenMaiDao.timTatCaKhuyenMai();
        for (KhuyenMai km : dsKhuyenMai) {
            if (LocalDate.now().isAfter(km.getThoiGianBatDau()) && LocalDate.now().isBefore(km.getThoiGianKetThuc())) {
                if (tongTien >= km.getDieuKienApDung()) {
                    if (km.getGiaTriKM() > khuyenMai.getGiaTriKM()) {
                        khuyenMai = km;
                        this.maKhuyenMai = km.getMaKM();
                    }
                }
            }
        }
        // Áp dụng khuyến mãi
        tongTien -= khuyenMai.getGiaTriKM();
        // Tính tiền trả trước thông qua thông tin đặt phòng
        double tienTraTruoc = 0;
        for (ThongTinDatThuePhong thongTin : dsThongTin) {
            tienTraTruoc += thongTin.getTienDaCoc();
        }
        // Tính tiền thuế
        double thue = tongTien * 0.1;
        tongTien += thue;
        this.thue = thue;
        this.tongGia = tongTien;

        tongTien -= tienTraTruoc;
        this.tienTraTruoc = tienTraTruoc;
        this.tienCanThu = tongTien;

        // Hiển thị thông tin khách hàng
        txtTenKH.setText(khachHang.getHoTenKH());
        txtHangThanhVienKH.setText(hangTV);
        txtSodienthoaiKH.setText(khachHang.getSoDT());
        txtNgaySinh.setText(khachHang.getNgaySinh().toString());
        txtChietKhau.setText(String.valueOf(chietKhau * 100) + "%");
        txtThue.setText("10% - " + String.valueOf(thue));
        txtNhanVien.setText(nhanvien.getHoTenNV());
        txtTongHoaDon.setText(String.valueOf(tongTien));
        txtTraTruoc.setText("0");
        txtTienCanThu.setText(String.valueOf(tongTien));
        txtMaKhachHang.setText(khachHang.getMaKH());

    }

    //load danh sách phòng vào table
    protected void loadDanhSachPhong() {
        DefaultTableModel model = (DefaultTableModel) tableDanhSachPhong.getModel();
        model.setRowCount(0);
        PhongDao phongDao = new PhongDao();
        Phong phong = new Phong();
        int i = 0;
        for (String phongDat : dsPhongDat) {
            phong = phongDao.timPhongTheoSoPhong(Integer.parseInt(phongDat));
            //datta row STT mã phòng tên phòng loại phòng kiểu thuê ngày đặt ngày nhận ngày trả
            i++;
            Object[] row = new Object[]{i, phong.getMaPhong(), phong.getSoPhong(), phong.getMaLoaiPhong(), "Thuê theo ngày",
                LocalDate.now(), LocalDate.now(), LocalDate.now()};
            model.addRow(row);
        }

    }

    ;
	



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
            java.util.logging.Logger.getLogger(TraPhong_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TraPhong_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TraPhong_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TraPhong_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        // </editor-fold>
        // </editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TraPhong_GUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private giaodien.CustomClass.Button btnHuy;
    private giaodien.CustomClass.Button btnTraPhong;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private giaodien.CustomClass.PanelRound panelTraPhong;
    private javax.swing.JTable tableDV;
    private javax.swing.JTable tableDanhSachPhong;
    private giaodien.CustomClass.TextFieldShadow txtChietKhau;
    private giaodien.CustomClass.TextFieldShadow txtHangThanhVienKH;
    private giaodien.CustomClass.TextFieldShadow txtMaKhachHang;
    private giaodien.CustomClass.TextFieldShadow txtNgaySinh;
    private giaodien.CustomClass.TextFieldShadow txtNhanVien;
    private giaodien.CustomClass.TextFieldShadow txtSodienthoaiKH;
    private giaodien.CustomClass.TextFieldShadow txtTenKH;
    private giaodien.CustomClass.TextFieldShadow txtThue;
    private giaodien.CustomClass.TextFieldShadow txtTienCanThu;
    private giaodien.CustomClass.TextFieldShadow txtTongHoaDon;
    private giaodien.CustomClass.TextFieldShadow txtTraTruoc;
    // End of variables declaration//GEN-END:variables

}
