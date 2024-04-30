
package giaodien;

import entity.DichVu;
import entity.DichVuPhong;
import entity.KhachHang;
import entity.Phong;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import connectDB.ConnectDB;
import dao.DichVuDao;
import dao.DichVuPhongDao;
import dao.KhachHangDao;
import dao.LoaiPhongDao;
import dao.LoaiThueDao;
import dao.PhongDao;
import dao.ThongTinDatThuePhongDao;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 *
 * @author Huynguyen
 */
public class GiaHanPhongThue extends javax.swing.JDialog {

	private List<DichVuPhong> danhSachDichVu;
	private String[] dsPhongDat;
	List<String> dsTenPhong;

	/**
	 * Creates new form DatPhong
	 */
	public GiaHanPhongThue() {
		ConnectDB.getInstance().getConnection();
		initComponents();
                comboBoxDichVu.setBackground(new Color(0,0,0,0));
                cbKieuThue.setBackground(new Color(0,0,0,0));
	}

	public GiaHanPhongThue(List<String> dsTenPhong) {
		dsPhongDat = new String[dsTenPhong.size()];
		int index = 0;
		for (String tenPhong : dsTenPhong) {
			dsPhongDat[index++] = tenPhong;
		}
		ConnectDB.getInstance().getConnection();
		initComponents();
	}

	public String[] layDanhSachPhongDat() {
		return dsPhongDat;
	}

	@SuppressWarnings("unchecked")
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
        txtTenKH = new giaodien.CustomClass.TextFieldShadow();
        txtCCCD = new giaodien.CustomClass.TextFieldShadow();
        jLabel24 = new javax.swing.JLabel();
        txtNgayNhan = new giaodien.CustomClass.TextFieldShadow();
        jLabel28 = new javax.swing.JLabel();
        txtNgayTra = new giaodien.CustomClass.TextFieldShadow();
        jLabel29 = new javax.swing.JLabel();
        btnNgayTra = new giaodien.CustomClass.Button();
        panelRound4 = new giaodien.custom2.PanelRound();
        cbKieuThue = new giaodien.CustomClass.Combobox();
        btnNgayNhan = new giaodien.CustomClass.Button();
        jLabel30 = new javax.swing.JLabel();
        txtCheckOut1 = new giaodien.CustomClass.TextFieldShadow();
        btnNgayTra2 = new giaodien.CustomClass.Button();
        panelRound2 = new giaodien.CustomClass.PanelRound();
        btnThemDichVu = new giaodien.CustomClass.Button();
        panelRound3 = new giaodien.custom2.PanelRound();
        comboBoxDichVu = new giaodien.CustomClass.Combobox();
        btnGiaHan = new giaodien.CustomClass.Button();
        btnHuy = new giaodien.CustomClass.Button();

        dateNgayTra.setForeground(new java.awt.Color(255, 203, 119));
        dateNgayTra.setTextRefernce(txtNgayTra);

        dateNgayNhan.setForeground(new java.awt.Color(255, 203, 119));
        dateNgayNhan.setTextRefernce(txtNgayNhan);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel1.setText("Gia hạn phòng thuê");

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

        txtTenKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenKHActionPerformed(evt);
            }
        });

        txtCCCD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCCCDActionPerformed(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel24.setText("CCCD/Passport");

        txtNgayNhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNgayNhanActionPerformed(evt);
            }
        });

        jLabel28.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel28.setText("Ngày nhận");

        txtNgayTra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNgayTraActionPerformed(evt);
            }
        });

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

        jLabel30.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel30.setText("Ngày gia hạn");

        txtCheckOut1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCheckOut1ActionPerformed(evt);
            }
        });

        btnNgayTra2.setBorder(null);
        btnNgayTra2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgLogin/calendar.png"))); // NOI18N
        btnNgayTra2.setBorderColor(new java.awt.Color(255, 255, 255));
        btnNgayTra2.setColorOver(new java.awt.Color(204, 204, 204));
        btnNgayTra2.setRadius(20);
        btnNgayTra2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNgayTra2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(txtNgayNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnNgayNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel24))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtCCCD, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound1Layout.createSequentialGroup()
                        .addComponent(txtNgayTra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnNgayTra, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCheckOut1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(panelRound4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addComponent(btnNgayTra2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 49, Short.MAX_VALUE))))
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCCCD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panelRound4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelRound1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtNgayNhan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(btnNgayNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtNgayTra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(btnNgayTra, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel30)
                            .addComponent(txtCheckOut1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnNgayTra2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)))
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                        .addComponent(btnThemDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(64, 64, 64))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound2Layout.createSequentialGroup()
                        .addComponent(panelRound3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34))))
        );
        panelRound2Layout.setVerticalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound2Layout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addComponent(panelRound3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnThemDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );

        btnGiaHan.setText("Gia hạn");
        btnGiaHan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGiaHanActionPerformed(evt);
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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, 1067, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(834, 834, 834)
                            .addComponent(panelRound2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addGap(16, 16, 16)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(12, 12, 12)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGap(514, 514, 514)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 469, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(33, 33, 33)
                                            .addComponent(btnGiaHan, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel32)
                                    .addGap(203, 203, 203)
                                    .addComponent(jLabel2))
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
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
                            .addComponent(btnGiaHan, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(24, 24, 24))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtTenKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenKHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenKHActionPerformed

    private void txtCCCDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCCCDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCCCDActionPerformed

    private void txtNgayNhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNgayNhanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNgayNhanActionPerformed

    private void txtNgayTraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNgayTraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNgayTraActionPerformed

    private void btnNgayTraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNgayTraActionPerformed
       dateNgayTra.showPopup();
    }//GEN-LAST:event_btnNgayTraActionPerformed
    
    private void btnGiaHanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGiaHanActionPerformed
        // GEN-FIRST:event_btnDatPhongActionPerformed
		String[] dsPhongDat = layDanhSachPhongDat();
		PhongDao phongDao = new PhongDao();
		ArrayList<Phong> dsPhong = new ArrayList<Phong>();
		// Lấy tên trong dsPhongDat, so sánh và lấy thông tin phòng từ CSDL
		for (String tenPhong : dsPhongDat) {
			dsPhong.add(phongDao.timPhongTheoSoPhong(Integer.parseInt(tenPhong)));
		}

		// Khởi tạo thông tin đặt phòng
		ThongTinDatThuePhongDao thongTinDatThuePhongDao = new ThongTinDatThuePhongDao();
		KhachHangDao khachHangDao = new KhachHangDao();
		KhachHang khachHang = khachHangDao.timTheoCCCD(txtCCCD.getText());
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

//		LocalDate ngayDat = LocalDate.parse(txtCheckIn.getText(), formatter);
		LocalDate ngayNhan = LocalDate.parse(txtNgayNhan.getText(), formatter);
		LocalDate ngayTra = LocalDate.parse(txtNgayTra.getText(), formatter);
		String maLoaiThue = "";
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
			if (loaiPhong.equalsIgnoreCase("Tiêu chuẩn"))
				loaiPhong = "TC";
			else if (loaiPhong.equalsIgnoreCase("Cao cấp"))
				loaiPhong = "CC";
			else if (loaiPhong.equalsIgnoreCase("Nâng cao"))
				loaiPhong = "NC";
			else
				loaiPhong = "TG";
			maLoaiThue = String.format("%s%s", kieuThue, loaiPhong);
		}

//		if (thongTinDatThuePhongDao.datPhong(dsPhong, khachHang, ngayDat, ngayNhan, maLoaiThue, ngayTra)) {
//			JOptionPane.showMessageDialog(this, "Đặt phòng thành công");
//			DatPhong2.this.dispose();
//		} else {
//			JOptionPane.showMessageDialog(this, "Đặt phòng thất bại");
//		}

    }//GEN-LAST:event_btnGiaHanActionPerformed
    
    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyActionPerformed
        this.hide();
    }//GEN-LAST:event_btnHuyActionPerformed

    private void btnNgayNhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNgayNhanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNgayNhanActionPerformed

    private void txtCheckOut1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCheckOut1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCheckOut1ActionPerformed

    private void btnNgayTra2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNgayTra2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNgayTra2ActionPerformed

	public String layTenLoaiPhong(String maLoai) {
		if (maLoai.equalsIgnoreCase("tc"))
			return "Tiêu chuẩn";
		else if (maLoai.equalsIgnoreCase("cc"))
			return "Cao cấp";
		else if (maLoai.equalsIgnoreCase("nc"))
			return "Nâng cao";
		else
			return "Thương gia";
	}

	public void loadDanhSachPhongDat() {
		// Hiện danh sách phòng vào bảng
		String[] dsPhongDat = layDanhSachPhongDat();
		PhongDao phongDao = new PhongDao();
		ArrayList<Phong> dsPhong = new ArrayList<Phong>();
		for (String tenPhong : dsPhongDat) {
			dsPhong.add(phongDao.timPhongTheoSoPhong(Integer.parseInt(tenPhong)));
		}
		DefaultTableModel model = (DefaultTableModel) tableDanhSachPhong.getModel();
		String loaiPhong = "";
		for (Phong phong : dsPhong) {
			loaiPhong = layTenLoaiPhong(phong.getMaLoaiPhong());
			Object[] rowData = { model.getRowCount() + 1, phong.getSoPhong(), loaiPhong };
			model.addRow(rowData);
		}
	}
	

//	public double setGiaCoc() {
//		String[] dsPhongDat = layDanhSachPhongDat();
//		PhongDao phongDao = new PhongDao();
//		ArrayList<Phong> dsPhong = new ArrayList<Phong>();
//		// Lấy tên trong dsPhongDat, so sánh và lấy thông tin phòng từ CSDL
//		for (String tenPhong : dsPhongDat) {
//			dsPhong.add(phongDao.timPhongTheoSoPhong(Integer.parseInt(tenPhong)));
//		}
//		LoaiThueDao loaiThueDao = new LoaiThueDao();
//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
////		LocalDate ngayDat = LocalDate.parse(txtCheckIn.getText(), formatter);
//		LocalDate ngayNhan = LocalDate.parse(txtNgayNhan.getText(), formatter);
//		String loaiPhong = "";
//		String maLoaiThue = "";
//		double soTienCoc = 0;
//		
////		// Tính tiền cọc
////		for (Phong phong : dsPhong) {
////			loaiPhong = layTenLoaiPhong(phong.getMaLoaiPhong());
////			maLoaiThue = loaiThueDao.timMaLoaiThue(cbKieuThue.getSelectedItem().toString(), loaiPhong);
////			if (ngayDat.equals(ngayNhan)) {
////				return soTienCoc = 0;
////				
////			}
////			else if (ngayDat.isBefore(ngayNhan)) {
////				soTienCoc += loaiThueDao.timGiaCocTheoMaThue(maLoaiThue);
////			}
////		}
////		return soTienCoc;
//	}

	private void btnThemDichVuActionPerformed(java.awt.event.ActionEvent evt) {                                              
	    loadDanhSachDichVu();
	    PhongDao phongDao = new PhongDao();
	    DichVuDao dvDao = new DichVuDao();
	    DichVuPhongDao dvPhongDao = new DichVuPhongDao();
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
	                model.setValueAt(giaMoi, i, 4);
	                daThem = true;
	                break;
	            }
	        }
	        if (!daThem) {
	            Object[] rowData = { model.getRowCount() + 1, comboBoxDichVu.getSelectedItem().toString(), 1, tenPhong, giaDichVu};
	            model.addRow(rowData);
	        }
	    } else {
	        JOptionPane.showMessageDialog(this, "Vui lòng chọn phòng cần thêm dịch vụ");
	    }
	}// GEN-LAST:event_btnThemDichVuActionPerformed

	private void btnThemKhachHangActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnThemKhachHangActionPerformed
		KhachHang kh = new KhachHang();
		KhachHangDao khDAO = new KhachHangDao();
		kh.setCccd_passport(txtCCCD.getText());
		// Tìm khách hàng bằng CCCD. Nếu tìm thấy thì tự fill các textfield còn lại, nếu
		// không thì thông báo hỏi có thêm khách hàng vào CSDL hay không
		if (khDAO.timTheoCCCD(kh.getCccd_passport()) != null) {
			kh = khDAO.timTheoCCCD(kh.getCccd_passport());
			txtTenKH.setText(kh.getHoTenKH());
		} else {
			// Thông báo bằng JOptionpane hỏi có muốn thêm khách hàng vào CSDL không
			JOptionPane.showConfirmDialog(this, "Khách hàng không tồn tại. Bạn có muốn thêm khách hàng vào CSDL không?",
					"Xác nhận", JOptionPane.YES_NO_OPTION);
			if (JOptionPane.YES_OPTION == 0) {
				// Mở form thêm khách hàng

				// Thêm khách hàng vào CSDL

				// Sau khi thêm xong thì fill các textfield còn lại
			}
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
			java.util.logging.Logger.getLogger(GiaHanPhongThue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(GiaHanPhongThue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(GiaHanPhongThue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(GiaHanPhongThue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				List<String> args = new ArrayList<String>();
				args.add("101");
				args.add("102");
				args.add("103");
				GiaHanPhongThue guiDatPhong = new GiaHanPhongThue(args);
				guiDatPhong.setVisible(true);
				guiDatPhong.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
			}
		});

	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private giaodien.CustomClass.Button btnGiaHan;
    private giaodien.CustomClass.Button btnHuy;
    private giaodien.CustomClass.Button btnNgayNhan;
    private giaodien.CustomClass.Button btnNgayTra;
    private giaodien.CustomClass.Button btnNgayTra2;
    private giaodien.CustomClass.Button btnThemDichVu;
    private giaodien.CustomClass.Combobox cbKieuThue;
    private giaodien.CustomClass.Combobox comboBoxDichVu;
    private giaodien.CustomClass.DateChooser dateNgayNhan;
    private giaodien.CustomClass.DateChooser dateNgayTra;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
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
    private giaodien.CustomClass.TextFieldShadow txtCheckOut1;
    private giaodien.CustomClass.TextFieldShadow txtNgayNhan;
    private giaodien.CustomClass.TextFieldShadow txtNgayTra;
    private giaodien.CustomClass.TextFieldShadow txtTenKH;
    // End of variables declaration//GEN-END:variables

	private static String[] loadDanhSachDichVu() {
		DichVuDao dvDao = new DichVuDao();
		ArrayList<DichVu> danhSachDV = dvDao.timTatCaDichVu();
		String[] tenDV = new String[danhSachDV.size()];
		for (int i = 0; i < danhSachDV.size(); i++) {
			tenDV[i] = String.format("%s %s", danhSachDV.get(i).getMaDV(), danhSachDV.get(i).getTenDV());
		}
		return tenDV;
	}
}
