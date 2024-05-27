/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package giaodien;

import java.awt.Color;
import java.awt.ScrollPane;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.BorderFactory;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.Desktop;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;

import dao.DichVuDao;
import dao.HoaDonDao;
import dao.PhongDao;
import entity.DichVuPhong;
import entity.HoaDon;
import entity.Phong;

import java.awt.Rectangle;
import java.awt.Dimension;
/**
 *
 * @author Admin
 */
public class HoaDonThanhToan_GUI extends javax.swing.JFrame {

    private PdfWriter writer;
    private  static int orderNumber = 1;
    private HoaDon hoadonLuuTru;
    private HoaDonDao hdDao = new HoaDonDao();
    
    
    public HoaDonThanhToan_GUI(HoaDon hoadon) {
    	this.hoadonLuuTru = hoadon;
        initComponents();
        drawBill();
        
    }
    
    
    public HoaDonThanhToan_GUI() {
        initComponents();
        drawBill();
    }
    public static void setOrderNumber(int newOrderNumber) {
    orderNumber = newOrderNumber;
}
    public static int getOrderNumber() {
        return orderNumber;
    }
    public void drawBill(){
    	maHoaDon.setText(hoadonLuuTru.getMaHoaDon());        
        gach.setText("--------------------------------------------------------------------------------------------------------------------------------------------------");
//        TraPhong traPhong = new TraPhong();

        String tenKhachHangStr = hdDao.layTenKhachHangTuMaHoaDon(hoadonLuuTru.getMaHoaDon());
        tenKhachHang.setText("Tên khách hàng: " + tenKhachHangStr);
        
        gach1.setText("--------------------------------------------------------------------------------------------------------------------------------------------------");
        
        ArrayList<String> dsNgayDatNhanTra = hdDao.layNgayDatNhanTratuMaHoaDon(hoadonLuuTru.getMaHoaDon());
        
        
        
        
        String ngayDennnStr = dsNgayDatNhanTra.get(1);
        String ngayDiiiiStr = dsNgayDatNhanTra.get(2);
        ngayDenDi.setText("Ngày đến: " + ngayDennnStr + "  ---    Ngày đi: " + ngayDiiiiStr);
        // Thời gian đi là thời gian tạo hóa đơn
        LocalDateTime ngayLap = hoadonLuuTru.getNgayLap();
        thoiGianDi.setText("Ngày lập hóa đơn: " + ngayLap);
        
        // Tạo một renderer mới
        DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
        // Thiết lập màu nền của renderer là màu trong suốt
        headerRenderer.setBackground(null);
        // Đặt renderer cho tất cả các cột trong hàng tiêu đề
        for (int i = 0; i < tableHoaDon.getColumnCount(); i++) {
            tableHoaDon.getTableHeader().getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
        }
        tableHoaDon.setBackground(Color.WHITE); 
        // Hiển thị đường kẻ giữa các ô và cột
        tableHoaDon.setShowGrid(true);
        // Đặt màu của đường kẻ
        tableHoaDon.setGridColor(Color.GRAY);
        // Đặt đường viền cho tiêu đề cột
        tableHoaDon.getTableHeader().setBorder(BorderFactory.createLineBorder(Color.GRAY));
        
        // Tính thông tin của hóa đơn từ danh sách các dịch vụ và phòng
        loadDataToTable();
    
    }
    private void loadDataToTable() {
		// Thêm thông tin phòng vào bảng
    	DefaultTableModel model = (DefaultTableModel) tableHoaDon.getModel();
    	// Tính tiền từng phòng
    	ArrayList<String> dsMaPhong = hdDao.layMaPhongDaDat(hoadonLuuTru.getMaHoaDon());
    	Phong phongThue = new Phong();
    	PhongDao phongDao = new PhongDao();
		for (String maPhong : dsMaPhong) { 	
			double giaPhong = 0;
			phongThue = phongDao.timPhongTheoMaPhong(maPhong);
			if (phongThue.getMaLoaiPhong().equalsIgnoreCase("tc")) {
				giaPhong = 450000;
			} else if (phongThue.getMaLoaiPhong().equalsIgnoreCase("nc")) {
				giaPhong = 700000;
			} else if (phongThue.getMaLoaiPhong().equalsIgnoreCase("cc")) {
				giaPhong = 1000000;
			} else {
				giaPhong = 1500000;
			}
			model.addRow(new Object[] { model.getRowCount() + 1, "Phòng " + phongThue.getMaPhong(), 1, giaPhong, giaPhong*1 });
		}
		
		
		int i = 0;
		// Thêm thông tin dịch vụ vào bảng
		ArrayList<DichVuPhong> dsDichVu = hdDao.layDichPhongSuDung(hoadonLuuTru.getMaHoaDon());
		DichVuDao dvDAO = new DichVuDao();
		for (DichVuPhong dv : dsDichVu) {
			// Tạo model cho tableDV STT mã dịch vụ tên dịch vụ số lượng phòng giá
			i++;
			String maDV = dv.getMaDichVu();
			String tenDV = dvDAO.timTheoMaDichVu(maDV).getTenDV();
			int soLuong = dv.getSoLuong();
			String maPhong = dv.getMaPhong();	
			// Tính giá dịch vụ bằng tìm kiếm theo mã dịch vụ lấy giá thông qua entity dichvuz
			double dongia = dvDAO.timTheoMaDichVu(dv.getMaDichVu()).getGiaDV();
			double tongGia = dongia * soLuong;
			// model STT + Phòng/dịch vụ + số lượng + Đơn giá + tổng
			model.addRow(new Object[] { model.getRowCount() + 1, tenDV , soLuong , dongia , tongGia } );
		}	
    	
		tongTien.setText(hoadonLuuTru.getTongTien() + " VND");
//		tienCoc.setText(hoadonLuuTru.getTienCoc() + " VND");
//		tienConLai.setText(hoadonLuuTru.getTienConLai() + " VND");
		
		
	}


	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mauHoaDon = new giaodien.CustomClass.PanelRound();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        maHoaDon = new javax.swing.JLabel();
        gach = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tenKhachHang = new javax.swing.JLabel();
        gach1 = new javax.swing.JLabel();
        ngayDenDi = new javax.swing.JLabel();
        thoiGianDi = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableHoaDon = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        tongTien = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        tienCoc = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        tienConLai = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lblTenNhanVien = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        inHoaDon = new giaodien.CustomClass.Button();
        huyHoaDon = new giaodien.CustomClass.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        mauHoaDon.setBackground(new java.awt.Color(255, 255, 255));
        mauHoaDon.setPreferredSize(new java.awt.Dimension(600, 700));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("StaRail Hotel  Management");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("12 Nguyễn Văn Bảo, Phường 4, Gò Vấp, Thành phố Hồ Chí Minh");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Số điện thoại: 0377293799");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Emai: nhom2ptud@gmail.com");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setText("Hóa đơn thanh toán dịch vụ");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Mã hóa đơn");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Tên khách hàng");

        ngayDenDi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        thoiGianDi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        tableHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Phòng, dịch vụ", "Số lượng", "Giá", "Tổng"
            }
        ));
        tableHoaDon.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tableHoaDon.setRowHeight(20);
        tableHoaDon.setSelectionBackground(new java.awt.Color(255, 255, 255));
        tableHoaDon.setShowVerticalLines(true);
        jScrollPane1.setViewportView(tableHoaDon);
        if (tableHoaDon.getColumnModel().getColumnCount() > 0) {
            tableHoaDon.getColumnModel().getColumn(0).setMaxWidth(60);
        }

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("Tổng tiền");

        tongTien.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("Đã cọc");

        tienCoc.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setText("Tiền còn lại");

        jLabel11.setText("Nhân viên lập hóa đơn");

        lblTenNhanVien.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTenNhanVien.setText("Nguyễn Quốc Huy");

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgLogin/LG (1).png"))); // NOI18N

        javax.swing.GroupLayout mauHoaDonLayout = new javax.swing.GroupLayout(mauHoaDon);
        mauHoaDon.setLayout(mauHoaDonLayout);
        mauHoaDonLayout.setHorizontalGroup(
            mauHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mauHoaDonLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addGroup(mauHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addGroup(mauHoaDonLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(26, 26, 26)
                        .addComponent(jLabel4)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(mauHoaDonLayout.createSequentialGroup()
                .addGroup(mauHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(mauHoaDonLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(mauHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mauHoaDonLayout.createSequentialGroup()
                                .addGroup(mauHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(mauHoaDonLayout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addGroup(mauHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)))
                                    .addGroup(mauHoaDonLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel10)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(mauHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tienConLai, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                                    .addComponent(tienCoc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(tongTien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(gach1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(gach, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(mauHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(mauHoaDonLayout.createSequentialGroup()
                            .addGap(38, 38, 38)
                            .addGroup(mauHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGap(30, 30, 30)
                            .addGroup(mauHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(maHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 449, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(tenKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(mauHoaDonLayout.createSequentialGroup()
                            .addGap(40, 40, 40)
                            .addGroup(mauHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(ngayDenDi, javax.swing.GroupLayout.DEFAULT_SIZE, 551, Short.MAX_VALUE)
                                .addComponent(thoiGianDi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(mauHoaDonLayout.createSequentialGroup()
                            .addGap(18, 18, 18)
                            .addGroup(mauHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel11)
                                .addComponent(lblTenNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(16, 16, 16))
        );
        mauHoaDonLayout.setVerticalGroup(
            mauHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mauHoaDonLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mauHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(mauHoaDonLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(mauHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5))
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(gach, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mauHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(maHoaDon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mauHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(tenKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(gach1, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ngayDenDi, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(thoiGianDi, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 346, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mauHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(mauHoaDonLayout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(mauHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tienConLai, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addContainerGap())
                    .addGroup(mauHoaDonLayout.createSequentialGroup()
                        .addGroup(mauHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(mauHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel8)
                                .addComponent(jLabel11)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(mauHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tienCoc, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTenNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24))))
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        inHoaDon.setBackground(new java.awt.Color(204, 204, 204));
        inHoaDon.setBorder(null);
        inHoaDon.setText("In");
        inHoaDon.setBorderColor(new java.awt.Color(255, 255, 255));
        inHoaDon.setRadius(20);
        inHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inHoaDonActionPerformed(evt);
            }
        });

        huyHoaDon.setBackground(new java.awt.Color(204, 204, 204));
        huyHoaDon.setBorder(null);
        huyHoaDon.setText("Hủy");
        huyHoaDon.setBorderColor(new java.awt.Color(255, 255, 255));
        huyHoaDon.setRadius(20);
        huyHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                huyHoaDonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(231, 231, 231)
                .addComponent(inHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(huyHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                    .addComponent(huyHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(mauHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 634, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mauHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 708, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void inHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inHoaDonActionPerformed
    // Lấy nội dung của panel mauHoaDon
    JPanel panel = mauHoaDon;
    
    // Tạo một tệp PDF mới
    Document document = new Document();
    try {
        // Đặt đường dẫn và tên cho tệp PDF
        String filePath = "mauHoaDon.pdf";
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(filePath));
        document.open();
        
        // Xác định kích thước của trang PDF
        com.itextpdf.text.Rectangle pageSize = document.getPageSize();
        
        // Xác định kích thước của panel
        Dimension panelSize = panel.getPreferredSize();
        
        // Tính toán vị trí để vẽ panel vào trang PDF ở giữa
        float x = (pageSize.getWidth() - panelSize.width) / 2;
        float y = (pageSize.getHeight() - panelSize.height) / 2;
        
        // Tạo đối tượng PdfContentByte để vẽ nội dung của panel vào tệp PDF
        PdfContentByte contentByte = writer.getDirectContent();
        contentByte.saveState();
        
        // Di chuyển ngữ cảnh vẽ đến vị trí đã tính toán
        contentByte.concatCTM(1, 0, 0, 1, x, y);
        
        Graphics2D graphics2d = contentByte.createGraphicsShapes(panelSize.width, panelSize.height);
        panel.print(graphics2d);
        graphics2d.dispose();
        contentByte.restoreState();
        
    } catch (DocumentException | IOException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Lỗi khi tạo tệp PDF: " + e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
    } finally {
        document.close();
    }
    // Mở tệp PDF sau khi tạo xong
    try {
        Desktop.getDesktop().open(new File("mauHoaDon.pdf"));
    } catch (IOException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Không thể mở tệp PDF: " + e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
    }
    
    }//GEN-LAST:event_inHoaDonActionPerformed

    private void huyHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_huyHoaDonActionPerformed
        orderNumber--;
        this.dispose();
    }//GEN-LAST:event_huyHoaDonActionPerformed

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
            java.util.logging.Logger.getLogger(HoaDonThanhToan_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HoaDonThanhToan_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HoaDonThanhToan_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HoaDonThanhToan_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HoaDonThanhToan_GUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel gach;
    private javax.swing.JLabel gach1;
    private giaodien.CustomClass.Button huyHoaDon;
    private giaodien.CustomClass.Button inHoaDon;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTenNhanVien;
    private javax.swing.JLabel maHoaDon;
    private giaodien.CustomClass.PanelRound mauHoaDon;
    private javax.swing.JLabel ngayDenDi;
    private javax.swing.JTable tableHoaDon;
    private javax.swing.JLabel tenKhachHang;
    private javax.swing.JLabel thoiGianDi;
    private javax.swing.JLabel tienCoc;
    private javax.swing.JLabel tienConLai;
    private javax.swing.JLabel tongTien;
    // End of variables declaration//GEN-END:variables
}
