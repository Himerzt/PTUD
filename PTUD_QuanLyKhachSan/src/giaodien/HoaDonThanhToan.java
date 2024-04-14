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
import java.awt.Rectangle;
import java.awt.Dimension;
/**
 *
 * @author Admin
 */
public class HoaDonThanhToan extends javax.swing.JFrame {

    private PdfWriter writer;
    public HoaDonThanhToan() {
        initComponents();
        drawBill();
    }
    public void drawBill(){
        // Lấy ngày hiện tại
        LocalDate currentDate = LocalDate.now();
        // Định dạng ngày thành chuỗi "YYYYMMDD"
        String formattedDate = currentDate.format(DateTimeFormatter.ofPattern("yyyyMMdd"));

        // Số thứ tự phát sinh hóa đơn (ví dụ: bạn có thể lấy từ cơ sở dữ liệu hoặc tính toán)
        int orderNumber = 1; // Ví dụ: số thứ tự là 1

        // Định dạng số thứ tự thành chuỗi "xxx" (có thể sử dụng DecimalFormat để thêm số 0 phía trước nếu cần)
        String formattedOrderNumber = String.format("%03d", orderNumber);
        maHoaDon.setText("HD" + formattedDate + formattedOrderNumber);
        gach.setText("--------------------------------------------------------------------------------------------------------------------------------------------------");
        TraPhong traPhong = new TraPhong(); // Tạo một đối tượng TraPhong
//        tenKhachHang.setText(traPhong.getTxtTenKH());
        gach1.setText("--------------------------------------------------------------------------------------------------------------------------------------------------");
        ngayDenDi.setText("Ngày đến: " + "" +  "   -    Ngày đi:  "+"");
        // Lấy thời gian hiện tại
        LocalDateTime thoiGianHienTai = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String gioHienTaiFormatted = thoiGianHienTai.format(formatter);
        // Hiển thị giờ hiện tại trong JTextPane
        thoiGianDi.setText("Thời gian đi: " + gioHienTaiFormatted);
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
        
        // thêm dữ liệu
//        JTable tableDanhSachPhong = traPhong.getTableDanhSachPhong();
//        JTable tableDV = traPhong.getTableDV();
//        DefaultTableModel model = (DefaultTableModel) tableHoaDon.getModel();

//        // Duyệt qua các hàng của bảng tableDanhSachPhong
//        for (int i = 0; i < tableDanhSachPhong.getRowCount(); i++) {
//            Object[] rowData = new Object[5]; // Mảng lưu trữ dữ liệu cho mỗi hàng
//
//            // Cột 1: Số thứ tự tự phát sinh
//            rowData[0] = i + 1;
//
//            // Cột 2: Lấy dữ liệu từ cột thứ ba của tableDanhSachPhong
//            rowData[1] = tableDanhSachPhong.getValueAt(i, 2);
//
//            // Cột 3: Ghi là 1
//            rowData[2] = 1;
//
//            // Cột 4: Lấy dữ liệu từ cột thứ năm của bảng tableDanhSachPhong
//            rowData[3] = tableDanhSachPhong.getValueAt(i, 4);
//
//            // Cột 5: Lấy dữ liệu từ cột thứ năm của bảng tableDanhSachPhong
//            rowData[4] = tableDanhSachPhong.getValueAt(i, 4);
//
//            // Thêm hàng vào bảng
//            model.addRow(rowData);
//        }
//        // Duyệt qua các hàng của bảng tableDV
//        for (int i = 0; i < tableDV.getRowCount(); i++) {
//            Object[] rowData = new Object[5]; // Mảng lưu trữ dữ liệu cho mỗi hàng
//
//            // Cột 1: Số thứ tự tự phát sinh
//            rowData[0] = i + 1 + tableDanhSachPhong.getRowCount(); // Cộng thêm số lượng hàng đã thêm từ bảng tableDanhSachPhong
//
//            // Cột 2: Lấy dữ liệu từ cột thứ ba của tableDV
//            rowData[1] = tableDV.getValueAt(i, 2);
//
//            // Cột 3: Lấy dữ liệu từ cột thứ tư của tableDV
//            rowData[2] = tableDV.getValueAt(i, 3);
//
//            // Cột 4: Lấy dữ liệu từ cột thứ sáu của bảng tableDV
//            rowData[3] = tableDV.getValueAt(i, 5);
//
//            // Cột 5: Lấy dữ liệu từ cột thứ bảy của bảng tableDV
//            rowData[4] = tableDV.getValueAt(i, 6);
//
//            // Thêm hàng vào bảng
//            model.addRow(rowData);
//        }

//        tongTien.setText(traPhong.getTongTien());
//        tienCoc.setText(traPhong.getTienCoc());
//        tienConLai.setText(traPhong.getTienConLai());

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
        jPanel1 = new javax.swing.JPanel();
        inHoaDon = new giaodien.CustomClass.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(600, 765));
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
        jLabel4.setText("Emai: khoikhoaito@gmail.com");

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
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tableHoaDon.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tableHoaDon.setRowHeight(40);
        tableHoaDon.setSelectionBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(tableHoaDon);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("Tổng tiền");

        tongTien.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("Đã cọc");

        tienCoc.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setText("Tiền còn lại");

        javax.swing.GroupLayout mauHoaDonLayout = new javax.swing.GroupLayout(mauHoaDon);
        mauHoaDon.setLayout(mauHoaDonLayout);
        mauHoaDonLayout.setHorizontalGroup(
            mauHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mauHoaDonLayout.createSequentialGroup()
                .addGroup(mauHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mauHoaDonLayout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(mauHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(30, 30, 30)
                        .addGroup(mauHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(maHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                            .addComponent(tenKhachHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(mauHoaDonLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(mauHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(thoiGianDi, javax.swing.GroupLayout.DEFAULT_SIZE, 519, Short.MAX_VALUE)
                            .addComponent(ngayDenDi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(mauHoaDonLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 564, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(18, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mauHoaDonLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(mauHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mauHoaDonLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(176, 176, 176))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mauHoaDonLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(95, 95, 95))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mauHoaDonLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(178, 178, 178))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mauHoaDonLayout.createSequentialGroup()
                        .addGroup(mauHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(200, 200, 200))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mauHoaDonLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(mauHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mauHoaDonLayout.createSequentialGroup()
                        .addGroup(mauHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(mauHoaDonLayout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tienConLai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(mauHoaDonLayout.createSequentialGroup()
                                .addGap(0, 12, Short.MAX_VALUE)
                                .addGroup(mauHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(mauHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tienCoc, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(51, 51, 51))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mauHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(gach1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 586, Short.MAX_VALUE)
                        .addComponent(gach, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        mauHoaDonLayout.setVerticalGroup(
            mauHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mauHoaDonLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel1)
                .addGap(27, 27, 27)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addGap(9, 9, 9)
                .addComponent(gach, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(mauHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(maHoaDon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(mauHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(tenKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(gach1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ngayDenDi, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(thoiGianDi, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
                .addGroup(mauHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(tongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(mauHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(tienCoc, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mauHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(tienConLai, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(57, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        inHoaDon.setBackground(new java.awt.Color(204, 204, 204));
        inHoaDon.setBorder(null);
        inHoaDon.setText("Print");
        inHoaDon.setBorderColor(new java.awt.Color(255, 255, 255));
        inHoaDon.setRadius(20);
        inHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inHoaDonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(250, 250, 250)
                .addComponent(inHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(inHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mauHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(mauHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
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
            java.util.logging.Logger.getLogger(HoaDonThanhToan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HoaDonThanhToan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HoaDonThanhToan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HoaDonThanhToan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HoaDonThanhToan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel gach;
    private javax.swing.JLabel gach1;
    private giaodien.CustomClass.Button inHoaDon;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
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
