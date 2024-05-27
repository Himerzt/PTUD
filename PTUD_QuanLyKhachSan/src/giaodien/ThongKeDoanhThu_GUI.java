package giaodien;

import java.awt.Dimension;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;


import dao.ChucVuDao;
import dao.DichVuDao;
import dao.HangThanhVienDao;
import dao.KhachHangDao;
import dao.NhanVienDao;
import dao.HoaDonDao;
import dao.ThongTinDatThuePhongDao;
import static java.awt.Color.red;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import giaodien.CustomClass.DateChooser;
import connectDB.ConnectDB;
import dao.PhongDao;
import dao.TaiKhoanDao;
import entity.ChucVu;
import entity.DichVu;
import entity.HangThanhVien;
import entity.KhachHang;
import entity.NhanVien;
import entity.Phong;
import entity.TaiKhoan;
import java.util.Calendar;

import javax.swing.JFrame;
import menu.MenuEvent;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;

/**
 * @author Huynguyen
 */
public class ThongKeDoanhThu_GUI extends javax.swing.JFrame {
    public ThongKeDoanhThu_GUI() throws Exception {

        initComponents();

           fillNamCombobox();
    }

    ;

	@SuppressWarnings("unchecked")

    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        scrollPaneWin112 = new giaodien.CustomClass.ScrollPaneWin11();
        pnMenu = new javax.swing.JPanel();
        Menu = new menu.Menu();
        pnHeader = new javax.swing.JPanel();
        jButton9 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        panelRound1 = new giaodien.CustomClass.PanelRound();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cbThang = new giaodien.CustomClass.Combobox();
        cbNam = new giaodien.CustomClass.Combobox();
        cbNgay = new giaodien.CustomClass.Combobox();
        btnThongKe = new giaodien.CustomClass.Button();
        SoLuongKhach = new javax.swing.JLabel();
        SoLuongDatPhong = new javax.swing.JLabel();
        DoanhThu = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        scrollPaneWin112.setBorder(null);

        pnMenu.setPreferredSize(new java.awt.Dimension(240, 800));
        pnMenu.setLayout(new java.awt.BorderLayout());
        pnMenu.add(Menu, java.awt.BorderLayout.CENTER);

        scrollPaneWin112.setViewportView(pnMenu);

        jPanel1.add(scrollPaneWin112, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 230, 710));

        pnHeader.setBackground(new java.awt.Color(34, 124, 157));
        pnHeader.setPreferredSize(new java.awt.Dimension(1553, 80));

        jButton9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-log-out-32.png"))); // NOI18N
        jButton9.setPreferredSize(new java.awt.Dimension(36, 36));

        jPanel5.setBackground(new java.awt.Color(34, 124, 157));
        jPanel5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setText("Nhoms2");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout pnHeaderLayout = new javax.swing.GroupLayout(pnHeader);
        pnHeader.setLayout(pnHeaderLayout);
        pnHeaderLayout.setHorizontalGroup(
            pnHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnHeaderLayout.createSequentialGroup()
                .addGap(1062, 1062, 1062)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 121, Short.MAX_VALUE)
                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(81, 81, 81))
        );
        pnHeaderLayout.setVerticalGroup(
            pnHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnHeaderLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(pnHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanel1.add(pnHeader, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1520, -1));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        panelRound1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel1.setText("Doanh thu");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel2.setText("Số lượng đặt phòng");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel3.setText("Số lượng khách");

        cbThang.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", " " }));
        cbThang.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        cbThang.setLabeText("");

        cbNam.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        cbNam.setLabeText("");

        cbNgay.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        cbNgay.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        cbNgay.setLabeText("");

        btnThongKe.setText("Thống kê");
        btnThongKe.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btnThongKe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThongKeActionPerformed(evt);
            }
        });

        SoLuongKhach.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        SoLuongDatPhong.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        DoanhThu.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel4.setText("Ngày");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel5.setText("Tháng");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel6.setText("Năm");

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound1Layout.createSequentialGroup()
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelRound1Layout.createSequentialGroup()
                                .addGap(93, 93, 93)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound1Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)))
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cbNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DoanhThu, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(74, 74, 74)
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5))
                        .addGap(46, 46, 46)
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panelRound1Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(SoLuongDatPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(107, 107, 107)
                                .addComponent(jLabel3))
                            .addGroup(panelRound1Layout.createSequentialGroup()
                                .addComponent(cbThang, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel6)))
                        .addGap(68, 68, 68)
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbNam, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelRound1Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(SoLuongKhach, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(96, 96, 96))
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(71, 71, 71)
                        .addComponent(jLabel5)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1)
                                .addComponent(jLabel3)
                                .addComponent(SoLuongKhach, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(DoanhThu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(SoLuongDatPhong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelRound1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cbNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbThang, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbNam, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(btnThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(23, 23, 23))
                            .addGroup(panelRound1Layout.createSequentialGroup()
                                .addGap(72, 72, 72)
                                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel6))
                                .addContainerGap(77, Short.MAX_VALUE))))))
        );

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel7.setText("Biểu đồ");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRound1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addContainerGap(435, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 80, 1290, 710));

        getContentPane().add(jPanel1, java.awt.BorderLayout.LINE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnThongKeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThongKeActionPerformed
        tinhToanDoanhThu();
        HoaDonDao hoaDonDao= new HoaDonDao();
        ThongTinDatThuePhongDao thongTinDatThuePhongDao = new ThongTinDatThuePhongDao();
        // Lấy dữ liệu từ combobox cbNam
        int nam = Integer.parseInt(cbNam.getSelectedItem().toString()); 

        // Lấy dữ liệu từ combobox cbNgay
        int ngay = Integer.parseInt(cbNgay.getSelectedItem().toString()); 

        // Lấy dữ liệu từ combobox cbThang
        int thang = Integer.parseInt(cbThang.getSelectedItem().toString());
        if(nam !=0 && thang !=0 && ngay != 0)
        {// Gọi hàm tinhTongHoaDonTheoNgay và chuyển kết quả sang kiểu String
        String doanhThu = String.valueOf(hoaDonDao.tinhTongHoaDonTheoNgay(ngay, thang, nam));
        String soLuongThuePhong = String.valueOf(thongTinDatThuePhongDao.demSoLuongPhongTheoNgay(ngay, thang, nam));
        String soLuongKH = String.valueOf(hoaDonDao.demSoLuongKhachHangTrongNgay(ngay, thang, nam));
        // Gán giá trị cho thành phần DoanhThu
        DoanhThu.setText(doanhThu +" VND");
        SoLuongDatPhong.setText(soLuongThuePhong);
        SoLuongKhach.setText(soLuongKH);
        } else if(nam !=0 && thang !=0 && ngay == 0){
            // Gọi hàm tinhTongHoaDonTheoNgay và chuyển kết quả sang kiểu String
        String doanhThu = String.valueOf(hoaDonDao.tinhTongHoaDonTheoThang( thang, nam));
        String soLuongThuePhong = String.valueOf(thongTinDatThuePhongDao.demSoLuongPhongTheoThangNam(thang, nam));
        String soLuongKH = String.valueOf(hoaDonDao.demSoLuongKhachHangTrongThang( thang, nam));
        // Gán giá trị cho thành phần DoanhThu
        DoanhThu.setText(doanhThu +" VND");
        SoLuongDatPhong.setText(soLuongThuePhong);
        SoLuongKhach.setText(soLuongKH);
        } else if(nam !=0 && thang ==0 && ngay == 0){
            // Gọi hàm tinhTongHoaDonTheoNgay và chuyển kết quả sang kiểu String
        String doanhThu = String.valueOf(hoaDonDao.tinhTongHoaDonTheoNam(nam));
        String soLuongThuePhong = String.valueOf(thongTinDatThuePhongDao.demSoLuongPhongTheoNam(nam));
        String soLuongKH = String.valueOf(hoaDonDao.demSoLuongKhachHangTrongNam( nam));
        // Gán giá trị cho thành phần DoanhThu
        DoanhThu.setText(doanhThu +" VND");
        SoLuongDatPhong.setText(soLuongThuePhong);
        SoLuongKhach.setText(soLuongKH);
        }
    }//GEN-LAST:event_btnThongKeActionPerformed

    

private void tinhToanDoanhThu() {
    HoaDonDao hoaDonDao = new HoaDonDao();
    // Lấy dữ liệu từ combobox cbNam
        int nam = Integer.parseInt(cbNam.getSelectedItem().toString()); 

        // Lấy dữ liệu từ combobox cbNgay
        int ngay = Integer.parseInt(cbNgay.getSelectedItem().toString()); 

        // Lấy dữ liệu từ combobox cbThang
        int thang = Integer.parseInt(cbThang.getSelectedItem().toString());
    // Cài đặt dữ liệu cho biểu đồ
    DefaultCategoryDataset dataset = new DefaultCategoryDataset();
    if(nam !=0 && thang !=0 && ngay == 0){
    // Tạo lớp Calendar để xác định số ngày trong tháng
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, nam);
        calendar.set(Calendar.MONTH, thang - 1); // Tháng trong Java bắt đầu từ 0
        int ngayCuoiThang = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

        // Lặp qua các ngày trong tháng hiện tại để tính toán doanh thu
        for (int day = 1; day <= ngayCuoiThang; day++) {
            double doanhThuNgay = hoaDonDao.tinhTongHoaDonTheoNgay(day, thang, nam);
            dataset.addValue(doanhThuNgay, "Doanh thu", String.valueOf(day));
        }

    // Tạo biểu đồ từ dataset
    JFreeChart chart = ChartFactory.createBarChart(
            "Biểu đồ doanh thu trong tháng " +thang, // Tiêu đề biểu đồ
            "Ngày",                           // Label trục x
            "Doanh thu",                      // Label trục y
            dataset,                          // Dữ liệu
            PlotOrientation.VERTICAL,
            true,
            true,
            false
    );

    // Đặt màu cho cột
    CategoryPlot plot = chart.getCategoryPlot();
    BarRenderer renderer = (BarRenderer) plot.getRenderer();
    renderer.setSeriesPaint(0, new Color(0xFE, 0x6D, 0x73)); // Đặt màu cho cột

    // Tạo panel chứa biểu đồ
    ChartPanel chartPanel = new ChartPanel(chart);

    // Tạo JFrame mới để chứa biểu đồ
    JFrame frame = new JFrame("Biểu đồ doanh thu trong năm");
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Đóng JFrame khi tắt cửa sổ
    frame.getContentPane().add(chartPanel);
    // Đặt kích thước cho JFrame
        frame.setSize(1106, 400);
        
        // Đặt vị trí của JFrame
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = (int) screenSize.getWidth();
        int screenHeight = (int) screenSize.getHeight();
        int frameWidth = frame.getWidth();
        int frameHeight = frame.getHeight();
        int x = screenWidth - frameWidth - 95;
        int y = screenHeight - frameHeight - 55;
        frame.setUndecorated(true); // Ẩn thanh công cụ
        frame.setLocation(x, y);
        frame.setVisible(true);
    } else if(nam !=0 && thang ==0 && ngay == 0){

        // Lặp qua các ngày trong tháng hiện tại để tính toán doanh thu
        for (int mounth = 1; mounth <= 12; mounth++) {
            double doanhThuThang = hoaDonDao.tinhTongHoaDonTheoThang( mounth, nam);
            dataset.addValue(doanhThuThang, "Doanh thu", String.valueOf(mounth));
        }

    // Tạo biểu đồ từ dataset
    JFreeChart chart = ChartFactory.createBarChart(
            "Biểu đồ doanh thu trong năm" + nam, // Tiêu đề biểu đồ
            "Tháng",                           // Label trục x
            "Doanh thu",                      // Label trục y
            dataset,                          // Dữ liệu
            PlotOrientation.VERTICAL,
            true,
            true,
            false
    );

    // Đặt màu cho cột
    CategoryPlot plot = chart.getCategoryPlot();
    BarRenderer renderer = (BarRenderer) plot.getRenderer();
    renderer.setSeriesPaint(0, new Color(0xFE, 0x6D, 0x73)); // Đặt màu cho cột

    // Tạo panel chứa biểu đồ
    ChartPanel chartPanel = new ChartPanel(chart);

    // Tạo JFrame mới để chứa biểu đồ
    JFrame frame = new JFrame("Biểu đồ doanh thu trong năm");
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Đóng JFrame khi tắt cửa sổ
    frame.getContentPane().add(chartPanel);
    // Đặt kích thước cho JFrame
        frame.setSize(1106, 400);
        
        // Đặt vị trí của JFrame
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = (int) screenSize.getWidth();
        int screenHeight = (int) screenSize.getHeight();
        int frameWidth = frame.getWidth();
        int frameHeight = frame.getHeight();
        int x = screenWidth - frameWidth - 95;
        int y = screenHeight - frameHeight - 55;
        frame.setUndecorated(true); // Ẩn thanh công cụ
        frame.setLocation(x, y);
        frame.setVisible(true);
    }
}

    private void fillNamCombobox() {
    HoaDonDao hoaDonDao = new HoaDonDao();
    List<Integer> years = hoaDonDao.layDanhSachNamHoaDon(); // Hàm này trả về danh sách các năm khác nhau trong hóa đơn
    for (Integer year : years) {
        cbNam.addItem(String.valueOf(year));
    }
}
    public static void main(String args[]) {

        //System.out.println(hoaDonDao.tinhTongHoaDonTheoNgay(1, LocalDate.now().getMonthValue(), LocalDate.now().getYear()));
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
            java.util.logging.Logger.getLogger(ThongKeDoanhThu_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ThongKeDoanhThu_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ThongKeDoanhThu_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ThongKeDoanhThu_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ThongKeDoanhThu_GUI trangChu = new ThongKeDoanhThu_GUI();
                    trangChu.setExtendedState(JFrame.MAXIMIZED_BOTH);
                    trangChu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    trangChu.setVisible(true);
                } catch (Exception e) {
                    // TODO: handle exception
                }
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel DoanhThu;
    private menu.Menu Menu;
    private javax.swing.JLabel SoLuongDatPhong;
    private javax.swing.JLabel SoLuongKhach;
    private giaodien.CustomClass.Button btnThongKe;
    private giaodien.CustomClass.Combobox cbNam;
    private giaodien.CustomClass.Combobox cbNgay;
    private giaodien.CustomClass.Combobox cbThang;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private giaodien.CustomClass.PanelRound panelRound1;
    private javax.swing.JPanel pnHeader;
    private javax.swing.JPanel pnMenu;
    private giaodien.CustomClass.ScrollPaneWin11 scrollPaneWin112;
    // End of variables declaration//GEN-END:variables

}
