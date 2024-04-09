package giaodien;

import java.awt.Color;
import static java.awt.Color.red;
import java.awt.Component;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import menu.MenuEvent;
/**
 *
 * @author Huynguyen
 */
public class QuanLyPhong extends javax.swing.JFrame {

    public QuanLyPhong() {
         
//        setUndecorated(true);
//        setAlwaysOnTop(true);
        setResizable(false);
        Toolkit tk = Toolkit.getDefaultToolkit();
        int x=(int) tk.getScreenSize().getWidth();
        int y=(int) tk.getScreenSize().getHeight();
        setSize(x, y);
        initComponents();
        ShowHideOption();
        datetime();
        times();
        
        Menu.setEvent(new MenuEvent(){
            @Override
            public void selected(int index, int subIndex) {
                if (index == 6) {
                System.exit(0); 
                }
                
                
                if ( index == 0){
                    TrangChu tc = new TrangChu();
                    tc.show();
                    dispose();
                }
                
            }
            
        });
        
    }

public void datetime(){
    Date d = new Date();
    
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MMM-dd");
    String df = format.format(d);
    
    lblcurrentdate.setText(df);
}


public void times(){
    Timer time;
    
    time = new Timer(0, new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent ae) {
        Date d = new Date();
        
        SimpleDateFormat dformat;
        dformat =  new SimpleDateFormat("hh:mm:ss a");
        
        String timeindate = dformat.format(d);
        lblcurrentTime.setText(timeindate);
        
        }        
    });
    
    time.start();
}
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGROUPLoaiPhong = new javax.swing.ButtonGroup();
        btnGROUPTrangThai = new javax.swing.ButtonGroup();
        chucNang = new javax.swing.JPopupMenu();
        datPhong = new javax.swing.JMenuItem();
        huyDatPhong = new javax.swing.JMenuItem();
        traPhong = new javax.swing.JMenuItem();
        doiPhong = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        pnHeader = new javax.swing.JPanel();
        Header = new component.Header();
        pnMenu = new javax.swing.JPanel();
        Menu = new menu.Menu();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        pnBody = new javax.swing.JPanel();
        Tang1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        phong2 = new javax.swing.JPanel();
        lblTenPhong2 = new javax.swing.JLabel();
        lblLoaiPhong2 = new javax.swing.JLabel();
        lblTrangThai2 = new javax.swing.JLabel();
        phong3 = new javax.swing.JPanel();
        lblTenPhong3 = new javax.swing.JLabel();
        lblLoaiPhong3 = new javax.swing.JLabel();
        lblTrangThai3 = new javax.swing.JLabel();
        phong4 = new javax.swing.JPanel();
        lblTenPhong4 = new javax.swing.JLabel();
        lblLoaiPhong4 = new javax.swing.JLabel();
        lblTrangThai4 = new javax.swing.JLabel();
        phong5 = new javax.swing.JPanel();
        lblTenPhong5 = new javax.swing.JLabel();
        lblLoaiPhong5 = new javax.swing.JLabel();
        lblTrangThai5 = new javax.swing.JLabel();
        phong6 = new javax.swing.JPanel();
        lblTenPhong6 = new javax.swing.JLabel();
        lblLoaiPhong6 = new javax.swing.JLabel();
        lblTrangThai6 = new javax.swing.JLabel();
        phong9 = new javax.swing.JPanel();
        lblTenPhong9 = new javax.swing.JLabel();
        lblLoaiPhong9 = new javax.swing.JLabel();
        lblTrangThai9 = new javax.swing.JLabel();
        phong10 = new javax.swing.JPanel();
        lblTenPhong10 = new javax.swing.JLabel();
        lblLoaiPhong10 = new javax.swing.JLabel();
        lblTrangThai10 = new javax.swing.JLabel();
        phong11 = new javax.swing.JPanel();
        lblTenPhong11 = new javax.swing.JLabel();
        lblLoaiPhong11 = new javax.swing.JLabel();
        lblTrangThai11 = new javax.swing.JLabel();
        phong13 = new javax.swing.JPanel();
        lblTenPhong13 = new javax.swing.JLabel();
        lblLoaiPhong13 = new javax.swing.JLabel();
        lblTrangThai13 = new javax.swing.JLabel();
        phong14 = new javax.swing.JPanel();
        lblTenPhong14 = new javax.swing.JLabel();
        lblLoaiPhong14 = new javax.swing.JLabel();
        lblTrangThai14 = new javax.swing.JLabel();
        Tang2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        phong17 = new javax.swing.JPanel();
        lblTenPhong17 = new javax.swing.JLabel();
        lblLoaiPhong17 = new javax.swing.JLabel();
        lblTrangThai17 = new javax.swing.JLabel();
        phong18 = new javax.swing.JPanel();
        lblTenPhong18 = new javax.swing.JLabel();
        lblLoaiPhong18 = new javax.swing.JLabel();
        lblTrangThai18 = new javax.swing.JLabel();
        phong19 = new javax.swing.JPanel();
        lblTenPhong19 = new javax.swing.JLabel();
        lblLoaiPhong19 = new javax.swing.JLabel();
        lblTrangThai19 = new javax.swing.JLabel();
        phong20 = new javax.swing.JPanel();
        lblTenPhong20 = new javax.swing.JLabel();
        lblLoaiPhong20 = new javax.swing.JLabel();
        lblTrangThai20 = new javax.swing.JLabel();
        phong21 = new javax.swing.JPanel();
        lblTenPhong21 = new javax.swing.JLabel();
        lblLoaiPhong21 = new javax.swing.JLabel();
        lblTrangThai21 = new javax.swing.JLabel();
        phong24 = new javax.swing.JPanel();
        lblTenPhong24 = new javax.swing.JLabel();
        lblLoaiPhong24 = new javax.swing.JLabel();
        lblTrangThai24 = new javax.swing.JLabel();
        phong25 = new javax.swing.JPanel();
        lblTenPhong25 = new javax.swing.JLabel();
        lblLoaiPhong25 = new javax.swing.JLabel();
        lblTrangThai25 = new javax.swing.JLabel();
        phong26 = new javax.swing.JPanel();
        lblTenPhong26 = new javax.swing.JLabel();
        lblTrangThai26 = new javax.swing.JLabel();
        phong27 = new javax.swing.JPanel();
        lblTenPhong27 = new javax.swing.JLabel();
        lblLoaiPhong27 = new javax.swing.JLabel();
        lblTrangThai27 = new javax.swing.JLabel();
        lblLoaiPhong26 = new javax.swing.JLabel();
        phong28 = new javax.swing.JPanel();
        lblTenPhong28 = new javax.swing.JLabel();
        lblLoaiPhong28 = new javax.swing.JLabel();
        lblTrangThai28 = new javax.swing.JLabel();
        Tang3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        phong31 = new javax.swing.JPanel();
        lblTenPhong31 = new javax.swing.JLabel();
        lblLoaiPhong31 = new javax.swing.JLabel();
        lblTrangThai31 = new javax.swing.JLabel();
        phong32 = new javax.swing.JPanel();
        lblTenPhong32 = new javax.swing.JLabel();
        lblLoaiPhong32 = new javax.swing.JLabel();
        lblTrangThai32 = new javax.swing.JLabel();
        phong33 = new javax.swing.JPanel();
        lblTenPhong33 = new javax.swing.JLabel();
        lblLoaiPhong33 = new javax.swing.JLabel();
        lblTrangThai33 = new javax.swing.JLabel();
        phong34 = new javax.swing.JPanel();
        lblTenPhong34 = new javax.swing.JLabel();
        lblLoaiPhong34 = new javax.swing.JLabel();
        lblTrangThai34 = new javax.swing.JLabel();
        phong35 = new javax.swing.JPanel();
        lblTenPhong35 = new javax.swing.JLabel();
        lblLoaiPhong35 = new javax.swing.JLabel();
        lblTrangThai35 = new javax.swing.JLabel();
        phong38 = new javax.swing.JPanel();
        lblTenPhong38 = new javax.swing.JLabel();
        lblLoaiPhong38 = new javax.swing.JLabel();
        lblTrangThai38 = new javax.swing.JLabel();
        phong39 = new javax.swing.JPanel();
        lblTenPhong39 = new javax.swing.JLabel();
        lblLoaiPhong39 = new javax.swing.JLabel();
        lblTrangThai39 = new javax.swing.JLabel();
        phong40 = new javax.swing.JPanel();
        lblTenPhong40 = new javax.swing.JLabel();
        lblLoaiPhong40 = new javax.swing.JLabel();
        lblTrangThai40 = new javax.swing.JLabel();
        phong41 = new javax.swing.JPanel();
        lblTenPhong41 = new javax.swing.JLabel();
        lblLoaiPhong41 = new javax.swing.JLabel();
        lblTrangThai41 = new javax.swing.JLabel();
        phong42 = new javax.swing.JPanel();
        lblTenPhong42 = new javax.swing.JLabel();
        lblLoaiPhong42 = new javax.swing.JLabel();
        lblTrangThai42 = new javax.swing.JLabel();
        funtionPanel = new javax.swing.JPanel();
        lbldate = new javax.swing.JLabel();
        lbltime = new javax.swing.JLabel();
        lblcurrentdate = new javax.swing.JLabel();
        lblcurrentTime = new javax.swing.JLabel();
        radPhongTieuChuan = new javax.swing.JRadioButton();
        radPhongNangCao = new javax.swing.JRadioButton();
        radPhongCaoCap = new javax.swing.JRadioButton();
        radPhongThuongGia = new javax.swing.JRadioButton();
        radPhongTrong = new javax.swing.JRadioButton();
        radPhongDaDat = new javax.swing.JRadioButton();
        radPhongDangThue = new javax.swing.JRadioButton();
        btnFindbyPhone = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnResetTrangThai = new javax.swing.JButton();
        Tang4 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        phong36 = new javax.swing.JPanel();
        lblTenPhong36 = new javax.swing.JLabel();
        lblLoaiPhong36 = new javax.swing.JLabel();
        lblTrangThai36 = new javax.swing.JLabel();
        phong37 = new javax.swing.JPanel();
        lblTenPhong37 = new javax.swing.JLabel();
        lblLoaiPhong37 = new javax.swing.JLabel();
        lblTrangThai37 = new javax.swing.JLabel();
        phong48 = new javax.swing.JPanel();
        lblTenPhong48 = new javax.swing.JLabel();
        lblLoaiPhong48 = new javax.swing.JLabel();
        lblTrangThai48 = new javax.swing.JLabel();
        phong49 = new javax.swing.JPanel();
        lblTenPhong49 = new javax.swing.JLabel();
        lblLoaiPhong49 = new javax.swing.JLabel();
        lblTrangThai49 = new javax.swing.JLabel();
        phong50 = new javax.swing.JPanel();
        lblTenPhong50 = new javax.swing.JLabel();
        lblLoaiPhong50 = new javax.swing.JLabel();
        lblTrangThai50 = new javax.swing.JLabel();

        datPhong.setText("Đặt phòng");
        datPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                datPhongActionPerformed(evt);
            }
        });
        chucNang.add(datPhong);

        huyDatPhong.setText("Hủy đặt phòng");
        chucNang.add(huyDatPhong);

        traPhong.setText("Trả phòng");
        chucNang.add(traPhong);

        doiPhong.setText("Đổi phòng");
        chucNang.add(doiPhong);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new java.awt.BorderLayout());

        pnHeader.setBackground(new java.awt.Color(255, 153, 153));
        pnHeader.setPreferredSize(new java.awt.Dimension(1553, 80));

        javax.swing.GroupLayout pnHeaderLayout = new javax.swing.GroupLayout(pnHeader);
        pnHeader.setLayout(pnHeaderLayout);
        pnHeaderLayout.setHorizontalGroup(
            pnHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Header, javax.swing.GroupLayout.DEFAULT_SIZE, 1553, Short.MAX_VALUE)
        );
        pnHeaderLayout.setVerticalGroup(
            pnHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Header, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
        );

        jPanel1.add(pnHeader, java.awt.BorderLayout.PAGE_START);

        pnMenu.setPreferredSize(new java.awt.Dimension(240, 800));

        javax.swing.GroupLayout pnMenuLayout = new javax.swing.GroupLayout(pnMenu);
        pnMenu.setLayout(pnMenuLayout);
        pnMenuLayout.setHorizontalGroup(
            pnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Menu, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
        );
        pnMenuLayout.setVerticalGroup(
            pnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Menu, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
        );

        jPanel1.add(pnMenu, java.awt.BorderLayout.LINE_START);

        pnBody.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Quản lý phòng", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 24))); // NOI18N

        Tang1.setBackground(new java.awt.Color(255, 255, 255));
        Tang1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Tầng 1", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N

        phong2.setBackground(new java.awt.Color(255, 255, 153));
        phong2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                phong2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                phong2MouseEntered(evt);
            }
        });

        lblTenPhong2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTenPhong2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhong2.setText("101TC");

        lblLoaiPhong2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblLoaiPhong2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhong2.setText("Tiêu chuẩn");

        lblTrangThai2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTrangThai2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThai2.setText("Đang thuê");

        javax.swing.GroupLayout phong2Layout = new javax.swing.GroupLayout(phong2);
        phong2.setLayout(phong2Layout);
        phong2Layout.setHorizontalGroup(
            phong2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phong2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblLoaiPhong2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThai2, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(lblTenPhong2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        phong2Layout.setVerticalGroup(
            phong2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoaiPhong2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTenPhong2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTrangThai2)
                .addContainerGap())
        );

        phong3.setBackground(new java.awt.Color(255, 255, 153));

        lblTenPhong3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTenPhong3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhong3.setText("102NC");

        lblLoaiPhong3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblLoaiPhong3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhong3.setText("Nâng cao");

        lblTrangThai3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTrangThai3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThai3.setText("Đang trống");

        javax.swing.GroupLayout phong3Layout = new javax.swing.GroupLayout(phong3);
        phong3.setLayout(phong3Layout);
        phong3Layout.setHorizontalGroup(
            phong3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTenPhong3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phong3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblLoaiPhong3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThai3, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE))
                .addContainerGap())
        );
        phong3Layout.setVerticalGroup(
            phong3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoaiPhong3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTenPhong3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTrangThai3)
                .addContainerGap())
        );

        phong4.setBackground(new java.awt.Color(255, 255, 153));

        lblTenPhong4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTenPhong4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhong4.setText("103CC");

        lblLoaiPhong4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblLoaiPhong4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhong4.setText("Cao cấp");

        lblTrangThai4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTrangThai4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThai4.setText("Đã đặt");

        javax.swing.GroupLayout phong4Layout = new javax.swing.GroupLayout(phong4);
        phong4.setLayout(phong4Layout);
        phong4Layout.setHorizontalGroup(
            phong4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTenPhong4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phong4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblLoaiPhong4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThai4, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE))
                .addContainerGap())
        );
        phong4Layout.setVerticalGroup(
            phong4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoaiPhong4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTenPhong4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTrangThai4)
                .addContainerGap())
        );

        phong5.setBackground(new java.awt.Color(255, 255, 153));

        lblTenPhong5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTenPhong5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhong5.setText("109TC");

        lblLoaiPhong5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblLoaiPhong5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhong5.setText("Thương gia");

        lblTrangThai5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTrangThai5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThai5.setText("Đang thuê");

        javax.swing.GroupLayout phong5Layout = new javax.swing.GroupLayout(phong5);
        phong5.setLayout(phong5Layout);
        phong5Layout.setHorizontalGroup(
            phong5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTenPhong5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phong5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblLoaiPhong5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThai5, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE))
                .addContainerGap())
        );
        phong5Layout.setVerticalGroup(
            phong5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoaiPhong5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTenPhong5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTrangThai5)
                .addContainerGap())
        );

        phong6.setBackground(new java.awt.Color(255, 255, 153));

        lblTenPhong6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTenPhong6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhong6.setText("102TC");

        lblLoaiPhong6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblLoaiPhong6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhong6.setText("Tiêu chuẩn");

        lblTrangThai6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTrangThai6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThai6.setText("Trạng thái");

        javax.swing.GroupLayout phong6Layout = new javax.swing.GroupLayout(phong6);
        phong6.setLayout(phong6Layout);
        phong6Layout.setHorizontalGroup(
            phong6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTenPhong6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phong6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblLoaiPhong6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThai6, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE))
                .addContainerGap())
        );
        phong6Layout.setVerticalGroup(
            phong6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoaiPhong6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTenPhong6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTrangThai6)
                .addContainerGap())
        );

        phong9.setBackground(new java.awt.Color(255, 255, 153));

        lblTenPhong9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTenPhong9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhong9.setText("Tên phòng");

        lblLoaiPhong9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblLoaiPhong9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhong9.setText("Loại phòng");

        lblTrangThai9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTrangThai9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThai9.setText("Trạng thái");

        javax.swing.GroupLayout phong9Layout = new javax.swing.GroupLayout(phong9);
        phong9.setLayout(phong9Layout);
        phong9Layout.setHorizontalGroup(
            phong9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTenPhong9, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
            .addGroup(phong9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLoaiPhong9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThai9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phong9Layout.setVerticalGroup(
            phong9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoaiPhong9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTenPhong9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTrangThai9)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        phong10.setBackground(new java.awt.Color(255, 255, 153));

        lblTenPhong10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTenPhong10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhong10.setText("Tên phòng");

        lblLoaiPhong10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblLoaiPhong10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhong10.setText("Loại phòng");

        lblTrangThai10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTrangThai10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThai10.setText("Trạng thái");

        javax.swing.GroupLayout phong10Layout = new javax.swing.GroupLayout(phong10);
        phong10.setLayout(phong10Layout);
        phong10Layout.setHorizontalGroup(
            phong10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTenPhong10, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phong10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLoaiPhong10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThai10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phong10Layout.setVerticalGroup(
            phong10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoaiPhong10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTenPhong10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTrangThai10)
                .addContainerGap())
        );

        phong11.setBackground(new java.awt.Color(255, 255, 153));

        lblTenPhong11.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTenPhong11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhong11.setText("Tên phòng");

        lblLoaiPhong11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblLoaiPhong11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhong11.setText("Loại phòng");

        lblTrangThai11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTrangThai11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThai11.setText("Trạng thái");

        javax.swing.GroupLayout phong11Layout = new javax.swing.GroupLayout(phong11);
        phong11.setLayout(phong11Layout);
        phong11Layout.setHorizontalGroup(
            phong11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTenPhong11, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
            .addGroup(phong11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLoaiPhong11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThai11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phong11Layout.setVerticalGroup(
            phong11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoaiPhong11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTenPhong11, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTrangThai11)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        phong13.setBackground(new java.awt.Color(255, 255, 153));

        lblTenPhong13.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTenPhong13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhong13.setText("Tên phòng");

        lblLoaiPhong13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblLoaiPhong13.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhong13.setText("Loại phòng");

        lblTrangThai13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTrangThai13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThai13.setText("Trạng thái");

        javax.swing.GroupLayout phong13Layout = new javax.swing.GroupLayout(phong13);
        phong13.setLayout(phong13Layout);
        phong13Layout.setHorizontalGroup(
            phong13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTenPhong13, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
            .addGroup(phong13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLoaiPhong13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThai13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phong13Layout.setVerticalGroup(
            phong13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoaiPhong13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTenPhong13, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTrangThai13)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        phong14.setBackground(new java.awt.Color(255, 255, 153));

        lblTenPhong14.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTenPhong14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhong14.setText("Tên phòng");

        lblLoaiPhong14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblLoaiPhong14.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhong14.setText("Loại phòng");

        lblTrangThai14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTrangThai14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThai14.setText("Trạng thái");

        javax.swing.GroupLayout phong14Layout = new javax.swing.GroupLayout(phong14);
        phong14.setLayout(phong14Layout);
        phong14Layout.setHorizontalGroup(
            phong14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTenPhong14, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phong14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLoaiPhong14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThai14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phong14Layout.setVerticalGroup(
            phong14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoaiPhong14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTenPhong14, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTrangThai14)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(phong2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(phong3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(phong4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(phong5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(phong6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(phong9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(phong10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(phong11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(phong13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(phong14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(phong6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(phong5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(phong4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(phong3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(phong2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(phong14, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(phong13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(phong11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(phong10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(phong9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout Tang1Layout = new javax.swing.GroupLayout(Tang1);
        Tang1.setLayout(Tang1Layout);
        Tang1Layout.setHorizontalGroup(
            Tang1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Tang1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        Tang1Layout.setVerticalGroup(
            Tang1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Tang1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        Tang2.setBackground(new java.awt.Color(255, 255, 255));
        Tang2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Tầng 2", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N

        phong17.setBackground(new java.awt.Color(255, 255, 153));

        lblTenPhong17.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTenPhong17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhong17.setText("Tên phòng");

        lblLoaiPhong17.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblLoaiPhong17.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhong17.setText("Loại phòng");

        lblTrangThai17.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTrangThai17.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThai17.setText("Trạng thái");

        javax.swing.GroupLayout phong17Layout = new javax.swing.GroupLayout(phong17);
        phong17.setLayout(phong17Layout);
        phong17Layout.setHorizontalGroup(
            phong17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phong17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblLoaiPhong17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThai17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(lblTenPhong17, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
        );
        phong17Layout.setVerticalGroup(
            phong17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoaiPhong17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTenPhong17, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTrangThai17)
                .addContainerGap())
        );

        phong18.setBackground(new java.awt.Color(255, 255, 153));

        lblTenPhong18.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTenPhong18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhong18.setText("Tên phòng");

        lblLoaiPhong18.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblLoaiPhong18.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhong18.setText("Loại phòng");

        lblTrangThai18.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTrangThai18.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThai18.setText("Trạng thái");

        javax.swing.GroupLayout phong18Layout = new javax.swing.GroupLayout(phong18);
        phong18.setLayout(phong18Layout);
        phong18Layout.setHorizontalGroup(
            phong18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTenPhong18, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phong18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblLoaiPhong18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThai18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phong18Layout.setVerticalGroup(
            phong18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoaiPhong18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTenPhong18, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTrangThai18)
                .addContainerGap())
        );

        phong19.setBackground(new java.awt.Color(255, 255, 153));

        lblTenPhong19.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTenPhong19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhong19.setText("Tên phòng");

        lblLoaiPhong19.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblLoaiPhong19.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhong19.setText("Loại phòng");

        lblTrangThai19.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTrangThai19.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThai19.setText("Trạng thái");

        javax.swing.GroupLayout phong19Layout = new javax.swing.GroupLayout(phong19);
        phong19.setLayout(phong19Layout);
        phong19Layout.setHorizontalGroup(
            phong19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTenPhong19, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phong19Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblLoaiPhong19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThai19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phong19Layout.setVerticalGroup(
            phong19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong19Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoaiPhong19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTenPhong19, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTrangThai19)
                .addContainerGap())
        );

        phong20.setBackground(new java.awt.Color(255, 255, 153));

        lblTenPhong20.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTenPhong20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhong20.setText("Tên phòng");

        lblLoaiPhong20.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblLoaiPhong20.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhong20.setText("Loại phòng");

        lblTrangThai20.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTrangThai20.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThai20.setText("Trạng thái");

        javax.swing.GroupLayout phong20Layout = new javax.swing.GroupLayout(phong20);
        phong20.setLayout(phong20Layout);
        phong20Layout.setHorizontalGroup(
            phong20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTenPhong20, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phong20Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblLoaiPhong20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThai20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phong20Layout.setVerticalGroup(
            phong20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong20Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoaiPhong20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(lblTenPhong20, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTrangThai20)
                .addContainerGap())
        );

        phong21.setBackground(new java.awt.Color(255, 255, 153));

        lblTenPhong21.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTenPhong21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhong21.setText("Tên phòng");

        lblLoaiPhong21.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblLoaiPhong21.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhong21.setText("Loại phòng");

        lblTrangThai21.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTrangThai21.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThai21.setText("Trạng thái");

        javax.swing.GroupLayout phong21Layout = new javax.swing.GroupLayout(phong21);
        phong21.setLayout(phong21Layout);
        phong21Layout.setHorizontalGroup(
            phong21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTenPhong21, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phong21Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblLoaiPhong21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThai21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phong21Layout.setVerticalGroup(
            phong21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong21Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoaiPhong21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTenPhong21, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTrangThai21)
                .addContainerGap())
        );

        phong24.setBackground(new java.awt.Color(255, 255, 153));

        lblTenPhong24.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTenPhong24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhong24.setText("Tên phòng");

        lblLoaiPhong24.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblLoaiPhong24.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhong24.setText("Loại phòng");

        lblTrangThai24.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTrangThai24.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThai24.setText("Trạng thái");

        javax.swing.GroupLayout phong24Layout = new javax.swing.GroupLayout(phong24);
        phong24.setLayout(phong24Layout);
        phong24Layout.setHorizontalGroup(
            phong24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phong24Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblLoaiPhong24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThai24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(lblTenPhong24, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
        );
        phong24Layout.setVerticalGroup(
            phong24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong24Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoaiPhong24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTenPhong24, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(lblTrangThai24)
                .addContainerGap())
        );

        phong25.setBackground(new java.awt.Color(255, 255, 153));

        lblTenPhong25.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTenPhong25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhong25.setText("Tên phòng");

        lblLoaiPhong25.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblLoaiPhong25.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhong25.setText("Loại phòng");

        lblTrangThai25.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTrangThai25.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThai25.setText("Trạng thái");

        javax.swing.GroupLayout phong25Layout = new javax.swing.GroupLayout(phong25);
        phong25.setLayout(phong25Layout);
        phong25Layout.setHorizontalGroup(
            phong25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phong25Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblLoaiPhong25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThai25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(lblTenPhong25, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
        );
        phong25Layout.setVerticalGroup(
            phong25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong25Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoaiPhong25)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTenPhong25, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTrangThai25)
                .addContainerGap())
        );

        phong26.setBackground(new java.awt.Color(255, 255, 153));

        lblTenPhong26.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTenPhong26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhong26.setText("Tên phòng");

        lblTrangThai26.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTrangThai26.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThai26.setText("Trạng thái");

        javax.swing.GroupLayout phong26Layout = new javax.swing.GroupLayout(phong26);
        phong26.setLayout(phong26Layout);
        phong26Layout.setHorizontalGroup(
            phong26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phong26Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTrangThai26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(lblTenPhong26, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
        );
        phong26Layout.setVerticalGroup(
            phong26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong26Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(lblTenPhong26, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTrangThai26)
                .addContainerGap())
        );

        phong27.setBackground(new java.awt.Color(255, 255, 153));

        lblTenPhong27.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTenPhong27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhong27.setText("Tên phòng");

        lblLoaiPhong27.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblLoaiPhong27.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhong27.setText("Loại phòng");

        lblTrangThai27.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTrangThai27.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThai27.setText("Trạng thái");

        lblLoaiPhong26.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblLoaiPhong26.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhong26.setText("Loại phòng");

        javax.swing.GroupLayout phong27Layout = new javax.swing.GroupLayout(phong27);
        phong27.setLayout(phong27Layout);
        phong27Layout.setHorizontalGroup(
            phong27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phong27Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoaiPhong26, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(phong27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblLoaiPhong27, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)
                    .addComponent(lblTrangThai27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(lblTenPhong27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        phong27Layout.setVerticalGroup(
            phong27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong27Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLoaiPhong27)
                    .addComponent(lblLoaiPhong26))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTenPhong27, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTrangThai27)
                .addContainerGap())
        );

        phong28.setBackground(new java.awt.Color(255, 255, 153));

        lblTenPhong28.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTenPhong28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhong28.setText("Tên phòng");

        lblLoaiPhong28.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblLoaiPhong28.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhong28.setText("Loại phòng");

        lblTrangThai28.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTrangThai28.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThai28.setText("Trạng thái");

        javax.swing.GroupLayout phong28Layout = new javax.swing.GroupLayout(phong28);
        phong28.setLayout(phong28Layout);
        phong28Layout.setHorizontalGroup(
            phong28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phong28Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblLoaiPhong28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThai28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(lblTenPhong28, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
        );
        phong28Layout.setVerticalGroup(
            phong28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong28Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoaiPhong28)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTenPhong28, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTrangThai28)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(phong17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(phong18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(phong19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(phong20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(phong21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(phong24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(phong25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(phong26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(phong27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(phong28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(90, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(phong21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(phong20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(phong19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(phong18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(phong17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(phong24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(phong25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(phong26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(phong27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(phong28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout Tang2Layout = new javax.swing.GroupLayout(Tang2);
        Tang2.setLayout(Tang2Layout);
        Tang2Layout.setHorizontalGroup(
            Tang2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Tang2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        Tang2Layout.setVerticalGroup(
            Tang2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        Tang3.setBackground(new java.awt.Color(255, 255, 255));
        Tang3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Tầng 3", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N

        phong31.setBackground(new java.awt.Color(255, 255, 153));

        lblTenPhong31.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTenPhong31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhong31.setText("Tên phòng");

        lblLoaiPhong31.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblLoaiPhong31.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhong31.setText("Loại phòng");

        lblTrangThai31.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTrangThai31.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThai31.setText("Trạng thái");

        javax.swing.GroupLayout phong31Layout = new javax.swing.GroupLayout(phong31);
        phong31.setLayout(phong31Layout);
        phong31Layout.setHorizontalGroup(
            phong31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phong31Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblLoaiPhong31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThai31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(lblTenPhong31, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
        );
        phong31Layout.setVerticalGroup(
            phong31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong31Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoaiPhong31)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTenPhong31, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTrangThai31)
                .addContainerGap())
        );

        phong32.setBackground(new java.awt.Color(255, 255, 153));

        lblTenPhong32.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTenPhong32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhong32.setText("Tên phòng");

        lblLoaiPhong32.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblLoaiPhong32.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhong32.setText("Loại phòng");

        lblTrangThai32.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTrangThai32.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThai32.setText("Trạng thái");

        javax.swing.GroupLayout phong32Layout = new javax.swing.GroupLayout(phong32);
        phong32.setLayout(phong32Layout);
        phong32Layout.setHorizontalGroup(
            phong32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTenPhong32, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phong32Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblLoaiPhong32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThai32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phong32Layout.setVerticalGroup(
            phong32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong32Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoaiPhong32)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTenPhong32, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTrangThai32)
                .addContainerGap())
        );

        phong33.setBackground(new java.awt.Color(255, 255, 153));

        lblTenPhong33.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTenPhong33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhong33.setText("Tên phòng");

        lblLoaiPhong33.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblLoaiPhong33.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhong33.setText("Loại phòng");

        lblTrangThai33.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTrangThai33.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThai33.setText("Trạng thái");

        javax.swing.GroupLayout phong33Layout = new javax.swing.GroupLayout(phong33);
        phong33.setLayout(phong33Layout);
        phong33Layout.setHorizontalGroup(
            phong33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTenPhong33, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phong33Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblLoaiPhong33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThai33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phong33Layout.setVerticalGroup(
            phong33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong33Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoaiPhong33)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTenPhong33, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTrangThai33)
                .addContainerGap())
        );

        phong34.setBackground(new java.awt.Color(255, 255, 153));

        lblTenPhong34.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTenPhong34.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhong34.setText("Tên phòng");

        lblLoaiPhong34.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblLoaiPhong34.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhong34.setText("Loại phòng");

        lblTrangThai34.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTrangThai34.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThai34.setText("Trạng thái");

        javax.swing.GroupLayout phong34Layout = new javax.swing.GroupLayout(phong34);
        phong34.setLayout(phong34Layout);
        phong34Layout.setHorizontalGroup(
            phong34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTenPhong34, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phong34Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblLoaiPhong34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThai34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phong34Layout.setVerticalGroup(
            phong34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong34Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoaiPhong34)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTenPhong34, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTrangThai34)
                .addContainerGap())
        );

        phong35.setBackground(new java.awt.Color(255, 255, 153));

        lblTenPhong35.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTenPhong35.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhong35.setText("Tên phòng");

        lblLoaiPhong35.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblLoaiPhong35.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhong35.setText("Loại phòng");

        lblTrangThai35.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTrangThai35.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThai35.setText("Trạng thái");

        javax.swing.GroupLayout phong35Layout = new javax.swing.GroupLayout(phong35);
        phong35.setLayout(phong35Layout);
        phong35Layout.setHorizontalGroup(
            phong35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTenPhong35, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phong35Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblLoaiPhong35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThai35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phong35Layout.setVerticalGroup(
            phong35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong35Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoaiPhong35)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTenPhong35, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(lblTrangThai35)
                .addContainerGap())
        );

        phong38.setBackground(new java.awt.Color(255, 255, 153));

        lblTenPhong38.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTenPhong38.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhong38.setText("Tên phòng");

        lblLoaiPhong38.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblLoaiPhong38.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhong38.setText("Loại phòng");

        lblTrangThai38.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTrangThai38.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThai38.setText("Trạng thái");

        javax.swing.GroupLayout phong38Layout = new javax.swing.GroupLayout(phong38);
        phong38.setLayout(phong38Layout);
        phong38Layout.setHorizontalGroup(
            phong38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phong38Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblLoaiPhong38, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThai38, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(lblTenPhong38, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
        );
        phong38Layout.setVerticalGroup(
            phong38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong38Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoaiPhong38)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(lblTenPhong38, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTrangThai38)
                .addContainerGap())
        );

        phong39.setBackground(new java.awt.Color(255, 255, 153));

        lblTenPhong39.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTenPhong39.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhong39.setText("Tên phòng");

        lblLoaiPhong39.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblLoaiPhong39.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhong39.setText("Loại phòng");

        lblTrangThai39.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTrangThai39.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThai39.setText("Trạng thái");

        javax.swing.GroupLayout phong39Layout = new javax.swing.GroupLayout(phong39);
        phong39.setLayout(phong39Layout);
        phong39Layout.setHorizontalGroup(
            phong39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phong39Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblLoaiPhong39, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThai39, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(lblTenPhong39, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
        );
        phong39Layout.setVerticalGroup(
            phong39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong39Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoaiPhong39)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTenPhong39, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTrangThai39)
                .addContainerGap())
        );

        phong40.setBackground(new java.awt.Color(255, 255, 153));

        lblTenPhong40.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTenPhong40.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhong40.setText("Tên phòng");

        lblLoaiPhong40.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblLoaiPhong40.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhong40.setText("Loại phòng");

        lblTrangThai40.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTrangThai40.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThai40.setText("Trạng thái");

        javax.swing.GroupLayout phong40Layout = new javax.swing.GroupLayout(phong40);
        phong40.setLayout(phong40Layout);
        phong40Layout.setHorizontalGroup(
            phong40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phong40Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblLoaiPhong40, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThai40, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(lblTenPhong40, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
        );
        phong40Layout.setVerticalGroup(
            phong40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong40Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoaiPhong40)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTenPhong40, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTrangThai40)
                .addContainerGap())
        );

        phong41.setBackground(new java.awt.Color(255, 255, 153));

        lblTenPhong41.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTenPhong41.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhong41.setText("Tên phòng");

        lblLoaiPhong41.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblLoaiPhong41.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhong41.setText("Loại phòng");

        lblTrangThai41.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTrangThai41.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThai41.setText("Trạng thái");

        javax.swing.GroupLayout phong41Layout = new javax.swing.GroupLayout(phong41);
        phong41.setLayout(phong41Layout);
        phong41Layout.setHorizontalGroup(
            phong41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phong41Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblLoaiPhong41, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThai41, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(lblTenPhong41, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
        );
        phong41Layout.setVerticalGroup(
            phong41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong41Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoaiPhong41)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTenPhong41, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTrangThai41)
                .addContainerGap())
        );

        phong42.setBackground(new java.awt.Color(255, 255, 153));

        lblTenPhong42.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTenPhong42.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhong42.setText("Tên phòng");

        lblLoaiPhong42.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblLoaiPhong42.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhong42.setText("Loại phòng");

        lblTrangThai42.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTrangThai42.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThai42.setText("Trạng thái");

        javax.swing.GroupLayout phong42Layout = new javax.swing.GroupLayout(phong42);
        phong42.setLayout(phong42Layout);
        phong42Layout.setHorizontalGroup(
            phong42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phong42Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblLoaiPhong42, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThai42, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(lblTenPhong42, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
        );
        phong42Layout.setVerticalGroup(
            phong42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong42Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoaiPhong42)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTenPhong42, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTrangThai42)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(phong31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(phong32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(phong33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(phong34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(phong35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(phong38, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(phong39, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(phong40, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(phong41, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(phong42, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(phong35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(phong34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(phong33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(phong32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(phong31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(phong38, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(phong39, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(phong40, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(phong41, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(phong42, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout Tang3Layout = new javax.swing.GroupLayout(Tang3);
        Tang3.setLayout(Tang3Layout);
        Tang3Layout.setHorizontalGroup(
            Tang3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Tang3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        Tang3Layout.setVerticalGroup(
            Tang3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        funtionPanel.setBackground(new java.awt.Color(204, 255, 204));

        lbldate.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbldate.setText("Date");

        lbltime.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbltime.setText("Time");

        lblcurrentdate.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblcurrentdate.setText("currentDate");

        lblcurrentTime.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblcurrentTime.setText("currentTime");

        btnGROUPLoaiPhong.add(radPhongTieuChuan);
        radPhongTieuChuan.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        radPhongTieuChuan.setText("Phòng tiêu chuẩn");
        radPhongTieuChuan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radPhongTieuChuanActionPerformed(evt);
            }
        });

        btnGROUPLoaiPhong.add(radPhongNangCao);
        radPhongNangCao.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        radPhongNangCao.setText("Phòng nâng cao");

        btnGROUPLoaiPhong.add(radPhongCaoCap);
        radPhongCaoCap.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        radPhongCaoCap.setText("Phòng cao cấp");

        btnGROUPLoaiPhong.add(radPhongThuongGia);
        radPhongThuongGia.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        radPhongThuongGia.setText("Phòng thương gia");

        btnGROUPTrangThai.add(radPhongTrong);
        radPhongTrong.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        radPhongTrong.setText("Phòng trống");
        radPhongTrong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radPhongTrongActionPerformed(evt);
            }
        });

        btnGROUPTrangThai.add(radPhongDaDat);
        radPhongDaDat.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        radPhongDaDat.setText("Phòng đã đặt");

        btnGROUPTrangThai.add(radPhongDangThue);
        radPhongDangThue.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        radPhongDangThue.setText("Phòng đang thuê");

        btnFindbyPhone.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnFindbyPhone.setText("Tìm");
        btnFindbyPhone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindbyPhoneActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Tìm phòng theo trạng thái");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Tìm phòng theo loại phòng");

        btnResetTrangThai.setText("Reset");
        btnResetTrangThai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetTrangThaiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout funtionPanelLayout = new javax.swing.GroupLayout(funtionPanel);
        funtionPanel.setLayout(funtionPanelLayout);
        funtionPanelLayout.setHorizontalGroup(
            funtionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(funtionPanelLayout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(funtionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblcurrentdate, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblcurrentTime, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbltime, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbldate, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(68, 68, 68)
                .addGroup(funtionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(radPhongTieuChuan)
                    .addComponent(radPhongNangCao, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(radPhongThuongGia)
                    .addComponent(radPhongCaoCap, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55)
                .addGroup(funtionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(funtionPanelLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(funtionPanelLayout.createSequentialGroup()
                        .addGroup(funtionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(radPhongDangThue)
                            .addComponent(radPhongTrong, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnResetTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(funtionPanelLayout.createSequentialGroup()
                        .addComponent(radPhongDaDat, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnFindbyPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(85, 85, 85))
        );
        funtionPanelLayout.setVerticalGroup(
            funtionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, funtionPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(funtionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbldate, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addGroup(funtionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(funtionPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(funtionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblcurrentdate)
                            .addComponent(radPhongTieuChuan, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(radPhongTrong))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(funtionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(funtionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lbltime)
                                .addComponent(radPhongDangThue))
                            .addComponent(radPhongNangCao))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(funtionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(radPhongCaoCap)
                            .addComponent(radPhongDaDat)
                            .addComponent(lblcurrentTime))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(radPhongThuongGia))
                    .addGroup(funtionPanelLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(btnResetTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnFindbyPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(15, 15, 15))
        );

        Tang4.setBackground(new java.awt.Color(255, 255, 255));
        Tang4.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Tầng 4", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N

        phong36.setBackground(new java.awt.Color(255, 255, 153));

        lblTenPhong36.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTenPhong36.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhong36.setText("Tên phòng");

        lblLoaiPhong36.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblLoaiPhong36.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhong36.setText("Loại phòng");

        lblTrangThai36.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTrangThai36.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThai36.setText("Trạng thái");

        javax.swing.GroupLayout phong36Layout = new javax.swing.GroupLayout(phong36);
        phong36.setLayout(phong36Layout);
        phong36Layout.setHorizontalGroup(
            phong36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phong36Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblLoaiPhong36, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThai36, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(lblTenPhong36, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
        );
        phong36Layout.setVerticalGroup(
            phong36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong36Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoaiPhong36)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTenPhong36, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTrangThai36)
                .addContainerGap())
        );

        phong37.setBackground(new java.awt.Color(255, 255, 153));

        lblTenPhong37.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTenPhong37.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhong37.setText("Tên phòng");

        lblLoaiPhong37.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblLoaiPhong37.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhong37.setText("Loại phòng");

        lblTrangThai37.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTrangThai37.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThai37.setText("Trạng thái");

        javax.swing.GroupLayout phong37Layout = new javax.swing.GroupLayout(phong37);
        phong37.setLayout(phong37Layout);
        phong37Layout.setHorizontalGroup(
            phong37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTenPhong37, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phong37Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblLoaiPhong37, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThai37, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phong37Layout.setVerticalGroup(
            phong37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong37Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoaiPhong37)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTenPhong37, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTrangThai37)
                .addContainerGap())
        );

        phong48.setBackground(new java.awt.Color(255, 255, 153));

        lblTenPhong48.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTenPhong48.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhong48.setText("Tên phòng");

        lblLoaiPhong48.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblLoaiPhong48.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhong48.setText("Loại phòng");

        lblTrangThai48.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTrangThai48.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThai48.setText("Trạng thái");

        javax.swing.GroupLayout phong48Layout = new javax.swing.GroupLayout(phong48);
        phong48.setLayout(phong48Layout);
        phong48Layout.setHorizontalGroup(
            phong48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTenPhong48, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phong48Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblLoaiPhong48, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThai48, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phong48Layout.setVerticalGroup(
            phong48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong48Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoaiPhong48)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTenPhong48, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTrangThai48)
                .addContainerGap())
        );

        phong49.setBackground(new java.awt.Color(255, 255, 153));

        lblTenPhong49.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTenPhong49.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhong49.setText("Tên phòng");

        lblLoaiPhong49.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblLoaiPhong49.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhong49.setText("Loại phòng");

        lblTrangThai49.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTrangThai49.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThai49.setText("Trạng thái");

        javax.swing.GroupLayout phong49Layout = new javax.swing.GroupLayout(phong49);
        phong49.setLayout(phong49Layout);
        phong49Layout.setHorizontalGroup(
            phong49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTenPhong49, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phong49Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblLoaiPhong49, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThai49, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phong49Layout.setVerticalGroup(
            phong49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong49Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoaiPhong49)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTenPhong49, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTrangThai49)
                .addContainerGap())
        );

        phong50.setBackground(new java.awt.Color(255, 255, 153));

        lblTenPhong50.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTenPhong50.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhong50.setText("Tên phòng");

        lblLoaiPhong50.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblLoaiPhong50.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhong50.setText("Loại phòng");

        lblTrangThai50.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTrangThai50.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThai50.setText("Trạng thái");

        javax.swing.GroupLayout phong50Layout = new javax.swing.GroupLayout(phong50);
        phong50.setLayout(phong50Layout);
        phong50Layout.setHorizontalGroup(
            phong50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTenPhong50, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phong50Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblLoaiPhong50, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTrangThai50, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phong50Layout.setVerticalGroup(
            phong50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong50Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLoaiPhong50)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTenPhong50, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(lblTrangThai50)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(phong36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(phong37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(phong48, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(phong49, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(phong50, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(phong50, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(phong49, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(phong48, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(phong37, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(phong36, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(11, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout Tang4Layout = new javax.swing.GroupLayout(Tang4);
        Tang4.setLayout(Tang4Layout);
        Tang4Layout.setHorizontalGroup(
            Tang4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Tang4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        Tang4Layout.setVerticalGroup(
            Tang4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Tang4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout pnBodyLayout = new javax.swing.GroupLayout(pnBody);
        pnBody.setLayout(pnBodyLayout);
        pnBodyLayout.setHorizontalGroup(
            pnBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnBodyLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Tang3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Tang2, javax.swing.GroupLayout.PREFERRED_SIZE, 1200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Tang1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(funtionPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Tang4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnBodyLayout.setVerticalGroup(
            pnBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnBodyLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(funtionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Tang1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Tang2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Tang3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Tang4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(pnBody);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1253, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 756, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel5, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void radPhongTieuChuanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radPhongTieuChuanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radPhongTieuChuanActionPerformed

    private void btnFindbyPhoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindbyPhoneActionPerformed
        // TODO add your handling code here:
        JPanel[] phong = {phong2, phong3, phong4, phong5, phong6 , phong9, phong10,
            phong11, phong13, phong14, phong17, phong18, phong19, phong20, 
            phong21, phong24, phong25, phong26, phong27, phong28, 
            phong31, phong32, phong33, phong34, phong35,phong38, phong39, phong40,
            phong41, phong42, };
        JLabel[] loaiPhong = {lblLoaiPhong2, lblLoaiPhong3, lblLoaiPhong4, lblLoaiPhong5, lblLoaiPhong6, 
             lblLoaiPhong9, lblLoaiPhong10, lblLoaiPhong11, 
            lblLoaiPhong13, lblLoaiPhong14, lblLoaiPhong17, lblLoaiPhong18, 
            lblLoaiPhong19, lblLoaiPhong20, lblLoaiPhong21,  lblLoaiPhong24, 
            lblLoaiPhong25, lblLoaiPhong26, lblLoaiPhong27, lblLoaiPhong28, 
            lblLoaiPhong31, lblLoaiPhong32, lblLoaiPhong33, lblLoaiPhong34, lblLoaiPhong35,
            lblLoaiPhong38, lblLoaiPhong39, lblLoaiPhong40, lblLoaiPhong41, lblLoaiPhong42,
            
        };
        
        JLabel[] tenPhong = {lblTenPhong2, lblTenPhong3, lblTenPhong4, lblTenPhong5, lblTenPhong6, 
             lblTenPhong9, lblTenPhong10, lblTenPhong11, 
            lblTenPhong13, lblTenPhong14,  lblTenPhong17, lblTenPhong18, 
            lblTenPhong19, lblTenPhong20, lblTenPhong21,  lblTenPhong24, 
            lblTenPhong25, lblTenPhong26, lblTenPhong27, lblTenPhong28, 
            lblTenPhong31, lblTenPhong32, lblTenPhong33, lblTenPhong34, lblTenPhong35, 
            lblTenPhong38, lblTenPhong39, lblTenPhong40, lblTenPhong41, lblTenPhong42,
            
        };
        
        JLabel[] trangThai = {lblTrangThai2, lblTrangThai3, lblTrangThai4, lblTrangThai5, lblTrangThai6, 
            lblTrangThai9, lblTrangThai10, lblTrangThai11, 
            lblTrangThai13, lblTrangThai14,lblTrangThai17, lblTrangThai18, 
            lblTrangThai19, lblTrangThai20, lblTrangThai21, lblTrangThai24, 
            lblTrangThai25, lblTrangThai26, lblTrangThai27, lblTrangThai28, 
            lblTrangThai31, lblTrangThai32, lblTrangThai33, lblTrangThai34, lblTrangThai35, 
            lblTrangThai38, lblTrangThai39, lblTrangThai40, lblTrangThai41, lblTrangThai42,
            
        };
        
        
        if(radPhongTieuChuan.isSelected()){
            HienThiTatCaPhong();
            for(int i = 0; i< phong.length;i++){
                JPanel p = phong[i];
                JLabel loaiP = loaiPhong[i];
                
                if(loaiP.getText().equalsIgnoreCase("TC")){
                    p.setBackground(red);
                } else {
                    p.hide();
                }
            }
        } else if (radPhongNangCao.isSelected()){
            HienThiTatCaPhong();
            for(int i = 0; i< phong.length;i++){
                JPanel p = phong[i];
                JLabel loaiP = loaiPhong[i];
                
                if(loaiP.getText().equalsIgnoreCase("NC")){
                    p.setBackground(red);
                } else {
                    p.hide();
                }
            }
        } else if (radPhongCaoCap.isSelected()){
            HienThiTatCaPhong();
            for(int i = 0; i< phong.length;i++){
                JPanel p = phong[i];
                JLabel loaiP = loaiPhong[i];
                
                if(loaiP.getText().equalsIgnoreCase("CC")){
                    p.setBackground(red);
                } else {
                    p.hide();
                }
            }
        } else if (radPhongThuongGia.isSelected()){
            HienThiTatCaPhong();
            for(int i = 0; i< phong.length;i++){
                JPanel p = phong[i];
                JLabel loaiP = loaiPhong[i];
                
                if(loaiP.getText().equalsIgnoreCase("TG")){
                    p.setBackground(red);
                } else {
                    p.hide();
                }
            }
        }
        
        
        if(radPhongTrong.isSelected()){
            for(int i = 0; i< phong.length;i++){
                JPanel p = phong[i];
                JLabel trangThaiP = trangThai[i];
                
                if(trangThaiP.getText().equalsIgnoreCase("Đang trống")){
                    p.setBackground(red);
                } else {
                    p.hide();
                }
            }
        } else if (radPhongDaDat.isSelected()){
            for(int i = 0; i< phong.length;i++){
                JPanel p = phong[i];
                JLabel trangThaiP = trangThai[i];
                
                if(trangThaiP.getText().equalsIgnoreCase("Đã đặt")){
                    p.setBackground(red);
                } else {
                    p.hide();
                }
            }
        } else if (radPhongDangThue.isSelected()){
            for(int i = 0; i< phong.length;i++){
                JPanel p = phong[i];
                JLabel trangThaiP = trangThai[i];
                
                if(trangThaiP.getText().equalsIgnoreCase("Đang thuê")){
                    p.setBackground(red);
                } else {
                    p.hide();
                }
            }
        }
    }//GEN-LAST:event_btnFindbyPhoneActionPerformed

    private void btnResetTrangThaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetTrangThaiActionPerformed
        // TODO add your handling code here:
        HienThiTatCaPhong();
        radPhongTieuChuan.setSelected(false);
        radPhongNangCao.setSelected(false);
        radPhongCaoCap.setSelected(false);
        radPhongTrong.setSelected(false);
        radPhongDangThue.setSelected(false);
        radPhongDaDat.setSelected(false);
        btnGROUPLoaiPhong.clearSelection();
        btnGROUPTrangThai.clearSelection();
    }//GEN-LAST:event_btnResetTrangThaiActionPerformed

    private void radPhongTrongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radPhongTrongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radPhongTrongActionPerformed

    private void datPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_datPhongActionPerformed
        // TODO add your handling code here:
        JFrame fDatPhong = new DatPhong();
        JPanel firstPanel = getFirstPanelFromFrame(fDatPhong);
        fDatPhong.show();
//        firstPanel.show();

    }//GEN-LAST:event_datPhongActionPerformed
    private JPanel getFirstPanelFromFrame(JFrame frame) {
        // Lấy tất cả các thành phần con của JFrame
        Component[] components = frame.getContentPane().getComponents();

        // Lặp qua từng thành phần để tìm JPanel đầu tiên
        for (Component component : components) {
            if (component instanceof JPanel) {
                return (JPanel) component;
            }
        }

        // Trả về null nếu không tìm thấy JPanel
        return null;
    }

    
    private void phong2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_phong2MouseEntered
        // TODO add your handling code here:
        
    }//GEN-LAST:event_phong2MouseEntered

    private void phong2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_phong2MouseClicked
        // TODO add your handling code here:
        if(SwingUtilities.isRightMouseButton(evt)){
            chucNang.show(phong2, evt.getX(), evt.getY());

        }
    }//GEN-LAST:event_phong2MouseClicked

    
    
    
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
            java.util.logging.Logger.getLogger(QuanLyPhong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuanLyPhong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuanLyPhong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuanLyPhong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuanLyPhong().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private component.Header Header;
    private menu.Menu Menu;
    private javax.swing.JPanel Tang1;
    private javax.swing.JPanel Tang2;
    private javax.swing.JPanel Tang3;
    private javax.swing.JPanel Tang4;
    private javax.swing.JButton btnFindbyPhone;
    private javax.swing.ButtonGroup btnGROUPLoaiPhong;
    private javax.swing.ButtonGroup btnGROUPTrangThai;
    private javax.swing.JButton btnResetTrangThai;
    private javax.swing.JPopupMenu chucNang;
    private javax.swing.JMenuItem datPhong;
    private javax.swing.JMenuItem doiPhong;
    private javax.swing.JPanel funtionPanel;
    private javax.swing.JMenuItem huyDatPhong;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblLoaiPhong10;
    private javax.swing.JLabel lblLoaiPhong11;
    private javax.swing.JLabel lblLoaiPhong13;
    private javax.swing.JLabel lblLoaiPhong14;
    private javax.swing.JLabel lblLoaiPhong17;
    private javax.swing.JLabel lblLoaiPhong18;
    private javax.swing.JLabel lblLoaiPhong19;
    private javax.swing.JLabel lblLoaiPhong2;
    private javax.swing.JLabel lblLoaiPhong20;
    private javax.swing.JLabel lblLoaiPhong21;
    private javax.swing.JLabel lblLoaiPhong24;
    private javax.swing.JLabel lblLoaiPhong25;
    private javax.swing.JLabel lblLoaiPhong26;
    private javax.swing.JLabel lblLoaiPhong27;
    private javax.swing.JLabel lblLoaiPhong28;
    private javax.swing.JLabel lblLoaiPhong3;
    private javax.swing.JLabel lblLoaiPhong31;
    private javax.swing.JLabel lblLoaiPhong32;
    private javax.swing.JLabel lblLoaiPhong33;
    private javax.swing.JLabel lblLoaiPhong34;
    private javax.swing.JLabel lblLoaiPhong35;
    private javax.swing.JLabel lblLoaiPhong36;
    private javax.swing.JLabel lblLoaiPhong37;
    private javax.swing.JLabel lblLoaiPhong38;
    private javax.swing.JLabel lblLoaiPhong39;
    private javax.swing.JLabel lblLoaiPhong4;
    private javax.swing.JLabel lblLoaiPhong40;
    private javax.swing.JLabel lblLoaiPhong41;
    private javax.swing.JLabel lblLoaiPhong42;
    private javax.swing.JLabel lblLoaiPhong48;
    private javax.swing.JLabel lblLoaiPhong49;
    private javax.swing.JLabel lblLoaiPhong5;
    private javax.swing.JLabel lblLoaiPhong50;
    private javax.swing.JLabel lblLoaiPhong6;
    private javax.swing.JLabel lblLoaiPhong9;
    private javax.swing.JLabel lblTenPhong10;
    private javax.swing.JLabel lblTenPhong11;
    private javax.swing.JLabel lblTenPhong13;
    private javax.swing.JLabel lblTenPhong14;
    private javax.swing.JLabel lblTenPhong17;
    private javax.swing.JLabel lblTenPhong18;
    private javax.swing.JLabel lblTenPhong19;
    private javax.swing.JLabel lblTenPhong2;
    private javax.swing.JLabel lblTenPhong20;
    private javax.swing.JLabel lblTenPhong21;
    private javax.swing.JLabel lblTenPhong24;
    private javax.swing.JLabel lblTenPhong25;
    private javax.swing.JLabel lblTenPhong26;
    private javax.swing.JLabel lblTenPhong27;
    private javax.swing.JLabel lblTenPhong28;
    private javax.swing.JLabel lblTenPhong3;
    private javax.swing.JLabel lblTenPhong31;
    private javax.swing.JLabel lblTenPhong32;
    private javax.swing.JLabel lblTenPhong33;
    private javax.swing.JLabel lblTenPhong34;
    private javax.swing.JLabel lblTenPhong35;
    private javax.swing.JLabel lblTenPhong36;
    private javax.swing.JLabel lblTenPhong37;
    private javax.swing.JLabel lblTenPhong38;
    private javax.swing.JLabel lblTenPhong39;
    private javax.swing.JLabel lblTenPhong4;
    private javax.swing.JLabel lblTenPhong40;
    private javax.swing.JLabel lblTenPhong41;
    private javax.swing.JLabel lblTenPhong42;
    private javax.swing.JLabel lblTenPhong48;
    private javax.swing.JLabel lblTenPhong49;
    private javax.swing.JLabel lblTenPhong5;
    private javax.swing.JLabel lblTenPhong50;
    private javax.swing.JLabel lblTenPhong6;
    private javax.swing.JLabel lblTenPhong9;
    private javax.swing.JLabel lblTrangThai10;
    private javax.swing.JLabel lblTrangThai11;
    private javax.swing.JLabel lblTrangThai13;
    private javax.swing.JLabel lblTrangThai14;
    private javax.swing.JLabel lblTrangThai17;
    private javax.swing.JLabel lblTrangThai18;
    private javax.swing.JLabel lblTrangThai19;
    private javax.swing.JLabel lblTrangThai2;
    private javax.swing.JLabel lblTrangThai20;
    private javax.swing.JLabel lblTrangThai21;
    private javax.swing.JLabel lblTrangThai24;
    private javax.swing.JLabel lblTrangThai25;
    private javax.swing.JLabel lblTrangThai26;
    private javax.swing.JLabel lblTrangThai27;
    private javax.swing.JLabel lblTrangThai28;
    private javax.swing.JLabel lblTrangThai3;
    private javax.swing.JLabel lblTrangThai31;
    private javax.swing.JLabel lblTrangThai32;
    private javax.swing.JLabel lblTrangThai33;
    private javax.swing.JLabel lblTrangThai34;
    private javax.swing.JLabel lblTrangThai35;
    private javax.swing.JLabel lblTrangThai36;
    private javax.swing.JLabel lblTrangThai37;
    private javax.swing.JLabel lblTrangThai38;
    private javax.swing.JLabel lblTrangThai39;
    private javax.swing.JLabel lblTrangThai4;
    private javax.swing.JLabel lblTrangThai40;
    private javax.swing.JLabel lblTrangThai41;
    private javax.swing.JLabel lblTrangThai42;
    private javax.swing.JLabel lblTrangThai48;
    private javax.swing.JLabel lblTrangThai49;
    private javax.swing.JLabel lblTrangThai5;
    private javax.swing.JLabel lblTrangThai50;
    private javax.swing.JLabel lblTrangThai6;
    private javax.swing.JLabel lblTrangThai9;
    private javax.swing.JLabel lblcurrentTime;
    private javax.swing.JLabel lblcurrentdate;
    private javax.swing.JLabel lbldate;
    private javax.swing.JLabel lbltime;
    private javax.swing.JPanel phong10;
    private javax.swing.JPanel phong11;
    private javax.swing.JPanel phong13;
    private javax.swing.JPanel phong14;
    private javax.swing.JPanel phong17;
    private javax.swing.JPanel phong18;
    private javax.swing.JPanel phong19;
    private javax.swing.JPanel phong2;
    private javax.swing.JPanel phong20;
    private javax.swing.JPanel phong21;
    private javax.swing.JPanel phong24;
    private javax.swing.JPanel phong25;
    private javax.swing.JPanel phong26;
    private javax.swing.JPanel phong27;
    private javax.swing.JPanel phong28;
    private javax.swing.JPanel phong3;
    private javax.swing.JPanel phong31;
    private javax.swing.JPanel phong32;
    private javax.swing.JPanel phong33;
    private javax.swing.JPanel phong34;
    private javax.swing.JPanel phong35;
    private javax.swing.JPanel phong36;
    private javax.swing.JPanel phong37;
    private javax.swing.JPanel phong38;
    private javax.swing.JPanel phong39;
    private javax.swing.JPanel phong4;
    private javax.swing.JPanel phong40;
    private javax.swing.JPanel phong41;
    private javax.swing.JPanel phong42;
    private javax.swing.JPanel phong48;
    private javax.swing.JPanel phong49;
    private javax.swing.JPanel phong5;
    private javax.swing.JPanel phong50;
    private javax.swing.JPanel phong6;
    private javax.swing.JPanel phong9;
    private javax.swing.JPanel pnBody;
    private javax.swing.JPanel pnHeader;
    private javax.swing.JPanel pnMenu;
    private javax.swing.JRadioButton radPhongCaoCap;
    private javax.swing.JRadioButton radPhongDaDat;
    private javax.swing.JRadioButton radPhongDangThue;
    private javax.swing.JRadioButton radPhongNangCao;
    private javax.swing.JRadioButton radPhongThuongGia;
    private javax.swing.JRadioButton radPhongTieuChuan;
    private javax.swing.JRadioButton radPhongTrong;
    private javax.swing.JMenuItem traPhong;
    // End of variables declaration//GEN-END:variables

    private void HienThiTatCaPhong() {
        JPanel[] phong = {phong2, phong3, phong4, phong5, phong6 , phong9, phong10,
            phong11, phong13, phong14, phong17, phong18, phong19, phong20, 
            phong21,  phong24, phong25, phong26, phong27, phong28, 
            phong31, phong32, phong33, phong34, phong35,  phong38, phong39, phong40,
            phong41, phong42,};
        
         
        for(int i = 0; i< phong.length;i++){
                JPanel p = phong[i];
                p.show();
            }
    }

    private void ShowHideOption() {
        JPanel[] phong = {phong2, phong3, phong4, phong5, phong6 ,phong9, phong10,
            phong11, phong13, phong14,  phong17, phong18, phong19, phong20, 
            phong21,  phong24, phong25, phong26, phong27, phong28,
            phong31, phong32, phong33, phong34, phong35,  phong38, phong39, phong40,
            phong41, phong42, };

        JLabel[] loaiPhong = {lblLoaiPhong2, lblLoaiPhong3, lblLoaiPhong4, lblLoaiPhong5, lblLoaiPhong6, 
            lblLoaiPhong9, lblLoaiPhong10, lblLoaiPhong11, 
            lblLoaiPhong13, lblLoaiPhong14,  lblLoaiPhong17,lblLoaiPhong18, 
            lblLoaiPhong19, lblLoaiPhong20, lblLoaiPhong21, lblLoaiPhong24, 
            lblLoaiPhong25, lblLoaiPhong26, lblLoaiPhong27, lblLoaiPhong28,  
            lblLoaiPhong31, lblLoaiPhong32, lblLoaiPhong33, lblLoaiPhong34, lblLoaiPhong35,  
            lblLoaiPhong38, lblLoaiPhong39, lblLoaiPhong40, lblLoaiPhong41, lblLoaiPhong42,
            };
        
        JLabel[] trangThai = {lblTrangThai2, lblTrangThai3, lblTrangThai4, lblTrangThai5, lblTrangThai6, 
            lblTrangThai9, lblTrangThai10, lblTrangThai11, 
            lblTrangThai13, lblTrangThai14,  lblTrangThai17, lblTrangThai18, 
            lblTrangThai19, lblTrangThai20, lblTrangThai21,  lblTrangThai24, 
            lblTrangThai25, lblTrangThai26, lblTrangThai27, lblTrangThai28, 
            lblTrangThai31, lblTrangThai32, lblTrangThai33, lblTrangThai34, lblTrangThai35, 
            lblTrangThai38, lblTrangThai39, lblTrangThai40, lblTrangThai41, lblTrangThai42,
            
        };

        for (int i = 0; i < phong.length; i++) {
            JPanel p = phong[i];
            JLabel loaiP = loaiPhong[i]; 
            JLabel ttP = trangThai[i]; 
            p.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (SwingUtilities.isRightMouseButton(e)) { 
                        chucNang.show(p, e.getX(), e.getY());
                        datPhong.show();
                        huyDatPhong.show();
                        doiPhong.show();
                        traPhong.show();
                        if (ttP.getText().equalsIgnoreCase("Đang trống")) {
                            doiPhong.hide();
                            traPhong.hide();
                            huyDatPhong.hide();
                        } else if (ttP.getText().equalsIgnoreCase("Đang thuê")) {
                            datPhong.hide();
                            huyDatPhong.hide();
                        } else if (ttP.getText().equalsIgnoreCase("Đã đặt")) {
                            datPhong.hide();
                            traPhong.hide();
                        } 
                    }
                }
            });
        }
    }


    
    
   
}
