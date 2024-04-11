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
import javax.swing.JCheckBox;
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
    
    private String getTenPhong;

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
        pnQuanLyPhong = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        pnBody = new javax.swing.JPanel();
        Tang2 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        phong2 = new javax.swing.JPanel();
        lblTenPhong2 = new javax.swing.JLabel();
        lblLoaiPhong2 = new javax.swing.JLabel();
        lblTrangThai2 = new javax.swing.JLabel();
        checkBoxPhong2 = new javax.swing.JCheckBox();
        phong3 = new javax.swing.JPanel();
        lblTenPhong3 = new javax.swing.JLabel();
        lblLoaiPhong3 = new javax.swing.JLabel();
        lblTrangThai3 = new javax.swing.JLabel();
        checkBoxPhong3 = new javax.swing.JCheckBox();
        phong4 = new javax.swing.JPanel();
        lblTenPhong4 = new javax.swing.JLabel();
        lblLoaiPhong4 = new javax.swing.JLabel();
        lblTrangThai4 = new javax.swing.JLabel();
        checkBoxPhong4 = new javax.swing.JCheckBox();
        phong5 = new javax.swing.JPanel();
        lblTenPhong5 = new javax.swing.JLabel();
        lblLoaiPhong5 = new javax.swing.JLabel();
        lblTrangThai5 = new javax.swing.JLabel();
        checkBoxPhong5 = new javax.swing.JCheckBox();
        phong6 = new javax.swing.JPanel();
        lblTenPhong6 = new javax.swing.JLabel();
        lblLoaiPhong6 = new javax.swing.JLabel();
        lblTrangThai6 = new javax.swing.JLabel();
        checkBoxPhong6 = new javax.swing.JCheckBox();
        phong8 = new javax.swing.JPanel();
        lblTenPhong8 = new javax.swing.JLabel();
        lblLoaiPhong8 = new javax.swing.JLabel();
        lblTrangThai8 = new javax.swing.JLabel();
        checkBoxPhong8 = new javax.swing.JCheckBox();
        phong9 = new javax.swing.JPanel();
        lblTenPhong9 = new javax.swing.JLabel();
        lblLoaiPhong9 = new javax.swing.JLabel();
        lblTrangThai9 = new javax.swing.JLabel();
        checkBoxPhong9 = new javax.swing.JCheckBox();
        phong10 = new javax.swing.JPanel();
        lblTenPhong10 = new javax.swing.JLabel();
        lblLoaiPhong10 = new javax.swing.JLabel();
        lblTrangThai10 = new javax.swing.JLabel();
        checkBoxPhong10 = new javax.swing.JCheckBox();
        phong7 = new javax.swing.JPanel();
        lblTenPhong7 = new javax.swing.JLabel();
        lblLoaiPhong7 = new javax.swing.JLabel();
        lblTrangThai7 = new javax.swing.JLabel();
        checkBoxPhong7 = new javax.swing.JCheckBox();
        phong11 = new javax.swing.JPanel();
        lblTenPhong11 = new javax.swing.JLabel();
        lblLoaiPhong11 = new javax.swing.JLabel();
        lblTrangThai11 = new javax.swing.JLabel();
        checkBoxPhong11 = new javax.swing.JCheckBox();
        Tang1 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        phong12 = new javax.swing.JPanel();
        lblTenPhong12 = new javax.swing.JLabel();
        lblLoaiPhong12 = new javax.swing.JLabel();
        lblTrangThai12 = new javax.swing.JLabel();
        checkBoxPhong12 = new javax.swing.JCheckBox();
        phong13 = new javax.swing.JPanel();
        lblTenPhong13 = new javax.swing.JLabel();
        lblLoaiPhong13 = new javax.swing.JLabel();
        lblTrangThai13 = new javax.swing.JLabel();
        checkBoxPhong13 = new javax.swing.JCheckBox();
        phong14 = new javax.swing.JPanel();
        lblTenPhong14 = new javax.swing.JLabel();
        lblLoaiPhong14 = new javax.swing.JLabel();
        lblTrangThai14 = new javax.swing.JLabel();
        checkBoxPhong14 = new javax.swing.JCheckBox();
        phong15 = new javax.swing.JPanel();
        lblTenPhong15 = new javax.swing.JLabel();
        lblLoaiPhong15 = new javax.swing.JLabel();
        lblTrangThai15 = new javax.swing.JLabel();
        checkBoxPhong15 = new javax.swing.JCheckBox();
        phong16 = new javax.swing.JPanel();
        lblTenPhong16 = new javax.swing.JLabel();
        lblLoaiPhong16 = new javax.swing.JLabel();
        lblTrangThai16 = new javax.swing.JLabel();
        checkBoxPhong16 = new javax.swing.JCheckBox();
        phong22 = new javax.swing.JPanel();
        lblTenPhong22 = new javax.swing.JLabel();
        lblLoaiPhong22 = new javax.swing.JLabel();
        lblTrangThai22 = new javax.swing.JLabel();
        checkBoxPhong22 = new javax.swing.JCheckBox();
        phong23 = new javax.swing.JPanel();
        lblTenPhong23 = new javax.swing.JLabel();
        lblLoaiPhong23 = new javax.swing.JLabel();
        lblTrangThai23 = new javax.swing.JLabel();
        checkBoxPhong23 = new javax.swing.JCheckBox();
        phong29 = new javax.swing.JPanel();
        lblTenPhong29 = new javax.swing.JLabel();
        lblLoaiPhong29 = new javax.swing.JLabel();
        lblTrangThai29 = new javax.swing.JLabel();
        checkBoxPhong29 = new javax.swing.JCheckBox();
        phong30 = new javax.swing.JPanel();
        lblTenPhong30 = new javax.swing.JLabel();
        lblLoaiPhong30 = new javax.swing.JLabel();
        lblTrangThai30 = new javax.swing.JLabel();
        checkBoxPhong30 = new javax.swing.JCheckBox();
        phong43 = new javax.swing.JPanel();
        lblTenPhong43 = new javax.swing.JLabel();
        lblLoaiPhong43 = new javax.swing.JLabel();
        lblTrangThai43 = new javax.swing.JLabel();
        checkBoxPhong43 = new javax.swing.JCheckBox();
        Tang4 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        phong44 = new javax.swing.JPanel();
        lblTenPhong44 = new javax.swing.JLabel();
        lblLoaiPhong44 = new javax.swing.JLabel();
        lblTrangThai44 = new javax.swing.JLabel();
        checkBoxPhong44 = new javax.swing.JCheckBox();
        phong45 = new javax.swing.JPanel();
        lblTenPhong45 = new javax.swing.JLabel();
        lblLoaiPhong45 = new javax.swing.JLabel();
        lblTrangThai45 = new javax.swing.JLabel();
        checkBoxPhong45 = new javax.swing.JCheckBox();
        phong46 = new javax.swing.JPanel();
        lblTenPhong46 = new javax.swing.JLabel();
        lblLoaiPhong46 = new javax.swing.JLabel();
        lblTrangThai46 = new javax.swing.JLabel();
        checkBoxPhong46 = new javax.swing.JCheckBox();
        phong47 = new javax.swing.JPanel();
        lblTenPhong47 = new javax.swing.JLabel();
        lblLoaiPhong47 = new javax.swing.JLabel();
        lblTrangThai47 = new javax.swing.JLabel();
        checkBoxPhong47 = new javax.swing.JCheckBox();
        phong51 = new javax.swing.JPanel();
        lblTenPhong51 = new javax.swing.JLabel();
        lblLoaiPhong51 = new javax.swing.JLabel();
        lblTrangThai51 = new javax.swing.JLabel();
        checkBoxPhong51 = new javax.swing.JCheckBox();
        Tang3 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        phong57 = new javax.swing.JPanel();
        lblTenPhong57 = new javax.swing.JLabel();
        lblLoaiPhong57 = new javax.swing.JLabel();
        lblTrangThai57 = new javax.swing.JLabel();
        checkBoxPhong57 = new javax.swing.JCheckBox();
        phong58 = new javax.swing.JPanel();
        lblTenPhong58 = new javax.swing.JLabel();
        lblLoaiPhong58 = new javax.swing.JLabel();
        lblTrangThai58 = new javax.swing.JLabel();
        checkBoxPhong58 = new javax.swing.JCheckBox();
        phong59 = new javax.swing.JPanel();
        lblTenPhong59 = new javax.swing.JLabel();
        lblLoaiPhong59 = new javax.swing.JLabel();
        lblTrangThai59 = new javax.swing.JLabel();
        checkBoxPhong59 = new javax.swing.JCheckBox();
        phong60 = new javax.swing.JPanel();
        lblTenPhong60 = new javax.swing.JLabel();
        lblLoaiPhong60 = new javax.swing.JLabel();
        lblTrangThai60 = new javax.swing.JLabel();
        checkBoxPhong60 = new javax.swing.JCheckBox();
        phong61 = new javax.swing.JPanel();
        lblTenPhong61 = new javax.swing.JLabel();
        lblLoaiPhong61 = new javax.swing.JLabel();
        lblTrangThai61 = new javax.swing.JLabel();
        checkBoxPhong61 = new javax.swing.JCheckBox();
        phong62 = new javax.swing.JPanel();
        lblTenPhong62 = new javax.swing.JLabel();
        lblLoaiPhong62 = new javax.swing.JLabel();
        lblTrangThai62 = new javax.swing.JLabel();
        checkBoxPhong62 = new javax.swing.JCheckBox();
        phong63 = new javax.swing.JPanel();
        lblTenPhong63 = new javax.swing.JLabel();
        lblLoaiPhong63 = new javax.swing.JLabel();
        lblTrangThai63 = new javax.swing.JLabel();
        checkBoxPhong63 = new javax.swing.JCheckBox();
        phong64 = new javax.swing.JPanel();
        lblTenPhong64 = new javax.swing.JLabel();
        lblLoaiPhong64 = new javax.swing.JLabel();
        lblTrangThai64 = new javax.swing.JLabel();
        checkBoxPhong64 = new javax.swing.JCheckBox();
        phong65 = new javax.swing.JPanel();
        lblTenPhong65 = new javax.swing.JLabel();
        lblLoaiPhong65 = new javax.swing.JLabel();
        lblTrangThai65 = new javax.swing.JLabel();
        checkBoxPhong65 = new javax.swing.JCheckBox();
        phong66 = new javax.swing.JPanel();
        lblTenPhong66 = new javax.swing.JLabel();
        lblLoaiPhong66 = new javax.swing.JLabel();
        lblTrangThai66 = new javax.swing.JLabel();
        checkBoxPhong66 = new javax.swing.JCheckBox();
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
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        datPhong.setText("Đặt phòng");
        datPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                datPhongActionPerformed(evt);
            }
        });
        chucNang.add(datPhong);

        huyDatPhong.setText("Hủy đặt phòng");
        huyDatPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                huyDatPhongActionPerformed(evt);
            }
        });
        chucNang.add(huyDatPhong);

        traPhong.setText("Trả phòng");
        traPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                traPhongActionPerformed(evt);
            }
        });
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

        pnBody.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        Tang2.setBackground(new java.awt.Color(255, 255, 255));
        Tang2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Tầng 2", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N

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
                    .addGroup(phong2Layout.createSequentialGroup()
                        .addComponent(lblLoaiPhong2, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(checkBoxPhong2))
                    .addComponent(lblTrangThai2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(lblTenPhong2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        phong2Layout.setVerticalGroup(
            phong2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(checkBoxPhong2)
                    .addComponent(lblLoaiPhong2))
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
                    .addGroup(phong3Layout.createSequentialGroup()
                        .addComponent(lblLoaiPhong3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(checkBoxPhong3))
                    .addComponent(lblTrangThai3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phong3Layout.setVerticalGroup(
            phong3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLoaiPhong3)
                    .addComponent(checkBoxPhong3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTenPhong3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTrangThai3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addGroup(phong4Layout.createSequentialGroup()
                        .addComponent(lblLoaiPhong4, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(checkBoxPhong4))
                    .addComponent(lblTrangThai4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phong4Layout.setVerticalGroup(
            phong4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLoaiPhong4)
                    .addComponent(checkBoxPhong4))
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
                    .addGroup(phong5Layout.createSequentialGroup()
                        .addComponent(lblLoaiPhong5, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(checkBoxPhong5))
                    .addComponent(lblTrangThai5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phong5Layout.setVerticalGroup(
            phong5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLoaiPhong5)
                    .addComponent(checkBoxPhong5))
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
                    .addGroup(phong6Layout.createSequentialGroup()
                        .addComponent(lblLoaiPhong6, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(checkBoxPhong6))
                    .addComponent(lblTrangThai6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phong6Layout.setVerticalGroup(
            phong6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLoaiPhong6)
                    .addComponent(checkBoxPhong6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTenPhong6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTrangThai6)
                .addContainerGap())
        );

        phong8.setBackground(new java.awt.Color(255, 255, 153));

        lblTenPhong8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTenPhong8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhong8.setText("102NC");

        lblLoaiPhong8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblLoaiPhong8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhong8.setText("Nâng cao");

        lblTrangThai8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTrangThai8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThai8.setText("Đang trống");

        javax.swing.GroupLayout phong8Layout = new javax.swing.GroupLayout(phong8);
        phong8.setLayout(phong8Layout);
        phong8Layout.setHorizontalGroup(
            phong8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTenPhong8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phong8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(phong8Layout.createSequentialGroup()
                        .addComponent(lblLoaiPhong8, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(checkBoxPhong8))
                    .addComponent(lblTrangThai8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phong8Layout.setVerticalGroup(
            phong8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLoaiPhong8)
                    .addComponent(checkBoxPhong8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTenPhong8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTrangThai8)
                .addContainerGap())
        );

        phong9.setBackground(new java.awt.Color(255, 255, 153));

        lblTenPhong9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTenPhong9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhong9.setText("103CC");

        lblLoaiPhong9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblLoaiPhong9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhong9.setText("Cao cấp");

        lblTrangThai9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTrangThai9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThai9.setText("Đã đặt");

        javax.swing.GroupLayout phong9Layout = new javax.swing.GroupLayout(phong9);
        phong9.setLayout(phong9Layout);
        phong9Layout.setHorizontalGroup(
            phong9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phong9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(phong9Layout.createSequentialGroup()
                        .addComponent(lblLoaiPhong9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(checkBoxPhong9))
                    .addComponent(lblTrangThai9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(lblTenPhong9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        phong9Layout.setVerticalGroup(
            phong9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLoaiPhong9)
                    .addComponent(checkBoxPhong9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTenPhong9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTrangThai9)
                .addContainerGap())
        );

        phong10.setBackground(new java.awt.Color(255, 255, 153));

        lblTenPhong10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTenPhong10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhong10.setText("109TC");

        lblLoaiPhong10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblLoaiPhong10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhong10.setText("Thương gia");

        lblTrangThai10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTrangThai10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThai10.setText("Đang thuê");

        javax.swing.GroupLayout phong10Layout = new javax.swing.GroupLayout(phong10);
        phong10.setLayout(phong10Layout);
        phong10Layout.setHorizontalGroup(
            phong10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTenPhong10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phong10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(phong10Layout.createSequentialGroup()
                        .addComponent(lblLoaiPhong10, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(checkBoxPhong10))
                    .addComponent(lblTrangThai10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phong10Layout.setVerticalGroup(
            phong10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLoaiPhong10)
                    .addComponent(checkBoxPhong10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTenPhong10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTrangThai10)
                .addContainerGap())
        );

        phong7.setBackground(new java.awt.Color(255, 255, 153));
        phong7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                phong7MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                phong7MouseEntered(evt);
            }
        });

        lblTenPhong7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTenPhong7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhong7.setText("101TC");

        lblLoaiPhong7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblLoaiPhong7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhong7.setText("Tiêu chuẩn");

        lblTrangThai7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTrangThai7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThai7.setText("Đang thuê");

        javax.swing.GroupLayout phong7Layout = new javax.swing.GroupLayout(phong7);
        phong7.setLayout(phong7Layout);
        phong7Layout.setHorizontalGroup(
            phong7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phong7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(phong7Layout.createSequentialGroup()
                        .addComponent(lblLoaiPhong7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(checkBoxPhong7))
                    .addComponent(lblTrangThai7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(lblTenPhong7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        phong7Layout.setVerticalGroup(
            phong7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(checkBoxPhong7)
                    .addComponent(lblLoaiPhong7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTenPhong7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTrangThai7)
                .addContainerGap())
        );

        phong11.setBackground(new java.awt.Color(255, 255, 153));

        lblTenPhong11.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTenPhong11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhong11.setText("102TC");

        lblLoaiPhong11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblLoaiPhong11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhong11.setText("Tiêu chuẩn");

        lblTrangThai11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTrangThai11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThai11.setText("Trạng thái");

        javax.swing.GroupLayout phong11Layout = new javax.swing.GroupLayout(phong11);
        phong11.setLayout(phong11Layout);
        phong11Layout.setHorizontalGroup(
            phong11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTenPhong11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phong11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(phong11Layout.createSequentialGroup()
                        .addComponent(lblLoaiPhong11, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(checkBoxPhong11))
                    .addComponent(lblTrangThai11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phong11Layout.setVerticalGroup(
            phong11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLoaiPhong11)
                    .addComponent(checkBoxPhong11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTenPhong11, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTrangThai11)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(phong2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(phong7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(phong8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(phong3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(phong4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(phong5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(phong6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(phong9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(phong10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(phong11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(115, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(phong2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phong6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(phong5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(phong3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(phong4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(phong11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(phong10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(phong9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(phong8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(phong7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout Tang2Layout = new javax.swing.GroupLayout(Tang2);
        Tang2.setLayout(Tang2Layout);
        Tang2Layout.setHorizontalGroup(
            Tang2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Tang2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        Tang2Layout.setVerticalGroup(
            Tang2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Tang2Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        Tang1.setBackground(new java.awt.Color(255, 255, 255));
        Tang1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Tầng 1", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N

        phong12.setBackground(new java.awt.Color(255, 255, 153));
        phong12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                phong12MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                phong12MouseEntered(evt);
            }
        });

        lblTenPhong12.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTenPhong12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhong12.setText("101TC");

        lblLoaiPhong12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblLoaiPhong12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhong12.setText("Tiêu chuẩn");

        lblTrangThai12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTrangThai12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThai12.setText("Đang thuê");

        javax.swing.GroupLayout phong12Layout = new javax.swing.GroupLayout(phong12);
        phong12.setLayout(phong12Layout);
        phong12Layout.setHorizontalGroup(
            phong12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phong12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(phong12Layout.createSequentialGroup()
                        .addComponent(lblLoaiPhong12, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(checkBoxPhong12))
                    .addComponent(lblTrangThai12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(lblTenPhong12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        phong12Layout.setVerticalGroup(
            phong12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(checkBoxPhong12)
                    .addComponent(lblLoaiPhong12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTenPhong12, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTrangThai12)
                .addContainerGap())
        );

        phong13.setBackground(new java.awt.Color(255, 255, 153));

        lblTenPhong13.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTenPhong13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhong13.setText("102NC");

        lblLoaiPhong13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblLoaiPhong13.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhong13.setText("Nâng cao");

        lblTrangThai13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTrangThai13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThai13.setText("Đang trống");

        javax.swing.GroupLayout phong13Layout = new javax.swing.GroupLayout(phong13);
        phong13.setLayout(phong13Layout);
        phong13Layout.setHorizontalGroup(
            phong13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTenPhong13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phong13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(phong13Layout.createSequentialGroup()
                        .addComponent(lblLoaiPhong13, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(checkBoxPhong13))
                    .addComponent(lblTrangThai13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phong13Layout.setVerticalGroup(
            phong13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLoaiPhong13)
                    .addComponent(checkBoxPhong13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTenPhong13, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTrangThai13, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        phong14.setBackground(new java.awt.Color(255, 255, 153));

        lblTenPhong14.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTenPhong14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhong14.setText("103CC");

        lblLoaiPhong14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblLoaiPhong14.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhong14.setText("Cao cấp");

        lblTrangThai14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTrangThai14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThai14.setText("Đã đặt");

        javax.swing.GroupLayout phong14Layout = new javax.swing.GroupLayout(phong14);
        phong14.setLayout(phong14Layout);
        phong14Layout.setHorizontalGroup(
            phong14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTenPhong14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phong14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(phong14Layout.createSequentialGroup()
                        .addComponent(lblLoaiPhong14, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(checkBoxPhong14))
                    .addComponent(lblTrangThai14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phong14Layout.setVerticalGroup(
            phong14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLoaiPhong14)
                    .addComponent(checkBoxPhong14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTenPhong14, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTrangThai14)
                .addContainerGap())
        );

        phong15.setBackground(new java.awt.Color(255, 255, 153));

        lblTenPhong15.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTenPhong15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhong15.setText("109TC");

        lblLoaiPhong15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblLoaiPhong15.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhong15.setText("Thương gia");

        lblTrangThai15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTrangThai15.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThai15.setText("Đang thuê");

        javax.swing.GroupLayout phong15Layout = new javax.swing.GroupLayout(phong15);
        phong15.setLayout(phong15Layout);
        phong15Layout.setHorizontalGroup(
            phong15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTenPhong15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phong15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(phong15Layout.createSequentialGroup()
                        .addComponent(lblLoaiPhong15, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(checkBoxPhong15))
                    .addComponent(lblTrangThai15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phong15Layout.setVerticalGroup(
            phong15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLoaiPhong15)
                    .addComponent(checkBoxPhong15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTenPhong15, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTrangThai15)
                .addContainerGap())
        );

        phong16.setBackground(new java.awt.Color(255, 255, 153));

        lblTenPhong16.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTenPhong16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhong16.setText("102TC");

        lblLoaiPhong16.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblLoaiPhong16.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhong16.setText("Tiêu chuẩn");

        lblTrangThai16.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTrangThai16.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThai16.setText("Trạng thái");

        javax.swing.GroupLayout phong16Layout = new javax.swing.GroupLayout(phong16);
        phong16.setLayout(phong16Layout);
        phong16Layout.setHorizontalGroup(
            phong16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTenPhong16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phong16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(phong16Layout.createSequentialGroup()
                        .addComponent(lblLoaiPhong16, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(checkBoxPhong16))
                    .addComponent(lblTrangThai16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phong16Layout.setVerticalGroup(
            phong16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLoaiPhong16)
                    .addComponent(checkBoxPhong16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTenPhong16, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTrangThai16)
                .addContainerGap())
        );

        phong22.setBackground(new java.awt.Color(255, 255, 153));

        lblTenPhong22.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTenPhong22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhong22.setText("102NC");

        lblLoaiPhong22.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblLoaiPhong22.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhong22.setText("Nâng cao");

        lblTrangThai22.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTrangThai22.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThai22.setText("Đang trống");

        javax.swing.GroupLayout phong22Layout = new javax.swing.GroupLayout(phong22);
        phong22.setLayout(phong22Layout);
        phong22Layout.setHorizontalGroup(
            phong22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTenPhong22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phong22Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(phong22Layout.createSequentialGroup()
                        .addComponent(lblLoaiPhong22, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(checkBoxPhong22))
                    .addComponent(lblTrangThai22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phong22Layout.setVerticalGroup(
            phong22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong22Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLoaiPhong22)
                    .addComponent(checkBoxPhong22))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTenPhong22, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTrangThai22)
                .addContainerGap())
        );

        phong23.setBackground(new java.awt.Color(255, 255, 153));

        lblTenPhong23.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTenPhong23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhong23.setText("103CC");

        lblLoaiPhong23.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblLoaiPhong23.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhong23.setText("Cao cấp");

        lblTrangThai23.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTrangThai23.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThai23.setText("Đã đặt");

        javax.swing.GroupLayout phong23Layout = new javax.swing.GroupLayout(phong23);
        phong23.setLayout(phong23Layout);
        phong23Layout.setHorizontalGroup(
            phong23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTenPhong23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phong23Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(phong23Layout.createSequentialGroup()
                        .addComponent(lblLoaiPhong23, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(checkBoxPhong23))
                    .addComponent(lblTrangThai23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phong23Layout.setVerticalGroup(
            phong23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong23Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLoaiPhong23)
                    .addComponent(checkBoxPhong23))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTenPhong23, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTrangThai23)
                .addContainerGap())
        );

        phong29.setBackground(new java.awt.Color(255, 255, 153));

        lblTenPhong29.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTenPhong29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhong29.setText("109TC");

        lblLoaiPhong29.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblLoaiPhong29.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhong29.setText("Thương gia");

        lblTrangThai29.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTrangThai29.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThai29.setText("Đang thuê");

        javax.swing.GroupLayout phong29Layout = new javax.swing.GroupLayout(phong29);
        phong29.setLayout(phong29Layout);
        phong29Layout.setHorizontalGroup(
            phong29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTenPhong29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phong29Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(phong29Layout.createSequentialGroup()
                        .addComponent(lblLoaiPhong29, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(checkBoxPhong29))
                    .addComponent(lblTrangThai29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phong29Layout.setVerticalGroup(
            phong29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong29Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLoaiPhong29)
                    .addComponent(checkBoxPhong29))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTenPhong29, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTrangThai29)
                .addContainerGap())
        );

        phong30.setBackground(new java.awt.Color(255, 255, 153));
        phong30.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                phong30MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                phong30MouseEntered(evt);
            }
        });

        lblTenPhong30.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTenPhong30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhong30.setText("101TC");

        lblLoaiPhong30.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblLoaiPhong30.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhong30.setText("Tiêu chuẩn");

        lblTrangThai30.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTrangThai30.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThai30.setText("Đang thuê");

        javax.swing.GroupLayout phong30Layout = new javax.swing.GroupLayout(phong30);
        phong30.setLayout(phong30Layout);
        phong30Layout.setHorizontalGroup(
            phong30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phong30Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(phong30Layout.createSequentialGroup()
                        .addComponent(lblLoaiPhong30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(checkBoxPhong30))
                    .addComponent(lblTrangThai30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(lblTenPhong30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        phong30Layout.setVerticalGroup(
            phong30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong30Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(checkBoxPhong30)
                    .addComponent(lblLoaiPhong30))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTenPhong30, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTrangThai30)
                .addContainerGap())
        );

        phong43.setBackground(new java.awt.Color(255, 255, 153));

        lblTenPhong43.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTenPhong43.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhong43.setText("102TC");

        lblLoaiPhong43.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblLoaiPhong43.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhong43.setText("Tiêu chuẩn");

        lblTrangThai43.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTrangThai43.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThai43.setText("Trạng thái");

        javax.swing.GroupLayout phong43Layout = new javax.swing.GroupLayout(phong43);
        phong43.setLayout(phong43Layout);
        phong43Layout.setHorizontalGroup(
            phong43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTenPhong43, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phong43Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(phong43Layout.createSequentialGroup()
                        .addComponent(lblLoaiPhong43, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(checkBoxPhong43))
                    .addComponent(lblTrangThai43, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phong43Layout.setVerticalGroup(
            phong43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong43Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLoaiPhong43)
                    .addComponent(checkBoxPhong43))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTenPhong43, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTrangThai43)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(phong12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(phong30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(phong22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(phong23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(phong29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(phong43, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(phong13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(phong14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(phong15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(phong16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(phong12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phong16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(phong15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(phong13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(phong14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(24, 24, 24)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(phong43, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(phong29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(phong23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(phong22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(phong30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout Tang1Layout = new javax.swing.GroupLayout(Tang1);
        Tang1.setLayout(Tang1Layout);
        Tang1Layout.setHorizontalGroup(
            Tang1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Tang1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        Tang1Layout.setVerticalGroup(
            Tang1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Tang1Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        Tang4.setBackground(new java.awt.Color(255, 255, 255));
        Tang4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Tầng 4", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N

        phong44.setBackground(new java.awt.Color(255, 255, 153));
        phong44.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                phong44MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                phong44MouseEntered(evt);
            }
        });

        lblTenPhong44.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTenPhong44.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhong44.setText("101TC");

        lblLoaiPhong44.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblLoaiPhong44.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhong44.setText("Tiêu chuẩn");

        lblTrangThai44.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTrangThai44.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThai44.setText("Đang thuê");

        javax.swing.GroupLayout phong44Layout = new javax.swing.GroupLayout(phong44);
        phong44.setLayout(phong44Layout);
        phong44Layout.setHorizontalGroup(
            phong44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phong44Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(phong44Layout.createSequentialGroup()
                        .addComponent(lblLoaiPhong44, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(checkBoxPhong44))
                    .addComponent(lblTrangThai44, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(lblTenPhong44, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        phong44Layout.setVerticalGroup(
            phong44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong44Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(checkBoxPhong44)
                    .addComponent(lblLoaiPhong44))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTenPhong44, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTrangThai44)
                .addContainerGap())
        );

        phong45.setBackground(new java.awt.Color(255, 255, 153));

        lblTenPhong45.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTenPhong45.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhong45.setText("102NC");

        lblLoaiPhong45.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblLoaiPhong45.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhong45.setText("Nâng cao");

        lblTrangThai45.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTrangThai45.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThai45.setText("Đang trống");

        javax.swing.GroupLayout phong45Layout = new javax.swing.GroupLayout(phong45);
        phong45.setLayout(phong45Layout);
        phong45Layout.setHorizontalGroup(
            phong45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTenPhong45, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phong45Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(phong45Layout.createSequentialGroup()
                        .addComponent(lblLoaiPhong45, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(checkBoxPhong45))
                    .addComponent(lblTrangThai45, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phong45Layout.setVerticalGroup(
            phong45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong45Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLoaiPhong45)
                    .addComponent(checkBoxPhong45))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTenPhong45, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTrangThai45, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        phong46.setBackground(new java.awt.Color(255, 255, 153));

        lblTenPhong46.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTenPhong46.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhong46.setText("103CC");

        lblLoaiPhong46.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblLoaiPhong46.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhong46.setText("Cao cấp");

        lblTrangThai46.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTrangThai46.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThai46.setText("Đã đặt");

        javax.swing.GroupLayout phong46Layout = new javax.swing.GroupLayout(phong46);
        phong46.setLayout(phong46Layout);
        phong46Layout.setHorizontalGroup(
            phong46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTenPhong46, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phong46Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(phong46Layout.createSequentialGroup()
                        .addComponent(lblLoaiPhong46, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(checkBoxPhong46))
                    .addComponent(lblTrangThai46, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phong46Layout.setVerticalGroup(
            phong46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong46Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLoaiPhong46)
                    .addComponent(checkBoxPhong46))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTenPhong46, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTrangThai46)
                .addContainerGap())
        );

        phong47.setBackground(new java.awt.Color(255, 255, 153));

        lblTenPhong47.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTenPhong47.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhong47.setText("109TC");

        lblLoaiPhong47.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblLoaiPhong47.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhong47.setText("Thương gia");

        lblTrangThai47.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTrangThai47.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThai47.setText("Đang thuê");

        javax.swing.GroupLayout phong47Layout = new javax.swing.GroupLayout(phong47);
        phong47.setLayout(phong47Layout);
        phong47Layout.setHorizontalGroup(
            phong47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTenPhong47, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phong47Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(phong47Layout.createSequentialGroup()
                        .addComponent(lblLoaiPhong47, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(checkBoxPhong47))
                    .addComponent(lblTrangThai47, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phong47Layout.setVerticalGroup(
            phong47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong47Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLoaiPhong47)
                    .addComponent(checkBoxPhong47))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTenPhong47, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTrangThai47)
                .addContainerGap())
        );

        phong51.setBackground(new java.awt.Color(255, 255, 153));

        lblTenPhong51.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTenPhong51.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhong51.setText("102TC");

        lblLoaiPhong51.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblLoaiPhong51.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhong51.setText("Tiêu chuẩn");

        lblTrangThai51.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTrangThai51.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThai51.setText("Trạng thái");

        javax.swing.GroupLayout phong51Layout = new javax.swing.GroupLayout(phong51);
        phong51.setLayout(phong51Layout);
        phong51Layout.setHorizontalGroup(
            phong51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTenPhong51, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phong51Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(phong51Layout.createSequentialGroup()
                        .addComponent(lblLoaiPhong51, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(checkBoxPhong51))
                    .addComponent(lblTrangThai51, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phong51Layout.setVerticalGroup(
            phong51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong51Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLoaiPhong51)
                    .addComponent(checkBoxPhong51))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTenPhong51, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTrangThai51)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addComponent(phong44, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(phong45, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(phong46, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(phong47, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(phong51, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(91, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(phong44, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phong51, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(phong47, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(phong45, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(phong46, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout Tang4Layout = new javax.swing.GroupLayout(Tang4);
        Tang4.setLayout(Tang4Layout);
        Tang4Layout.setHorizontalGroup(
            Tang4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Tang4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        Tang4Layout.setVerticalGroup(
            Tang4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Tang4Layout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Tang3.setBackground(new java.awt.Color(255, 255, 255));
        Tang3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Tầng 3", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N

        phong57.setBackground(new java.awt.Color(255, 255, 153));
        phong57.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                phong57MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                phong57MouseEntered(evt);
            }
        });

        lblTenPhong57.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTenPhong57.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhong57.setText("101TC");

        lblLoaiPhong57.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblLoaiPhong57.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhong57.setText("Tiêu chuẩn");

        lblTrangThai57.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTrangThai57.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThai57.setText("Đang thuê");

        javax.swing.GroupLayout phong57Layout = new javax.swing.GroupLayout(phong57);
        phong57.setLayout(phong57Layout);
        phong57Layout.setHorizontalGroup(
            phong57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phong57Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(phong57Layout.createSequentialGroup()
                        .addComponent(lblLoaiPhong57, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(checkBoxPhong57))
                    .addComponent(lblTrangThai57, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(lblTenPhong57, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        phong57Layout.setVerticalGroup(
            phong57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong57Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(checkBoxPhong57)
                    .addComponent(lblLoaiPhong57))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTenPhong57, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTrangThai57)
                .addContainerGap())
        );

        phong58.setBackground(new java.awt.Color(255, 255, 153));

        lblTenPhong58.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTenPhong58.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhong58.setText("102NC");

        lblLoaiPhong58.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblLoaiPhong58.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhong58.setText("Nâng cao");

        lblTrangThai58.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTrangThai58.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThai58.setText("Đang trống");

        javax.swing.GroupLayout phong58Layout = new javax.swing.GroupLayout(phong58);
        phong58.setLayout(phong58Layout);
        phong58Layout.setHorizontalGroup(
            phong58Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTenPhong58, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phong58Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong58Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(phong58Layout.createSequentialGroup()
                        .addComponent(lblLoaiPhong58, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(checkBoxPhong58))
                    .addComponent(lblTrangThai58, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phong58Layout.setVerticalGroup(
            phong58Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong58Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong58Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLoaiPhong58)
                    .addComponent(checkBoxPhong58))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTenPhong58, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTrangThai58, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        phong59.setBackground(new java.awt.Color(255, 255, 153));

        lblTenPhong59.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTenPhong59.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhong59.setText("103CC");

        lblLoaiPhong59.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblLoaiPhong59.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhong59.setText("Cao cấp");

        lblTrangThai59.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTrangThai59.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThai59.setText("Đã đặt");

        javax.swing.GroupLayout phong59Layout = new javax.swing.GroupLayout(phong59);
        phong59.setLayout(phong59Layout);
        phong59Layout.setHorizontalGroup(
            phong59Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTenPhong59, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phong59Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong59Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(phong59Layout.createSequentialGroup()
                        .addComponent(lblLoaiPhong59, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(checkBoxPhong59))
                    .addComponent(lblTrangThai59, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phong59Layout.setVerticalGroup(
            phong59Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong59Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong59Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLoaiPhong59)
                    .addComponent(checkBoxPhong59))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTenPhong59, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTrangThai59)
                .addContainerGap())
        );

        phong60.setBackground(new java.awt.Color(255, 255, 153));

        lblTenPhong60.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTenPhong60.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhong60.setText("109TC");

        lblLoaiPhong60.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblLoaiPhong60.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhong60.setText("Thương gia");

        lblTrangThai60.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTrangThai60.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThai60.setText("Đang thuê");

        javax.swing.GroupLayout phong60Layout = new javax.swing.GroupLayout(phong60);
        phong60.setLayout(phong60Layout);
        phong60Layout.setHorizontalGroup(
            phong60Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTenPhong60, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phong60Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong60Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(phong60Layout.createSequentialGroup()
                        .addComponent(lblLoaiPhong60, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(checkBoxPhong60))
                    .addComponent(lblTrangThai60, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phong60Layout.setVerticalGroup(
            phong60Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong60Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong60Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLoaiPhong60)
                    .addComponent(checkBoxPhong60))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTenPhong60, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTrangThai60)
                .addContainerGap())
        );

        phong61.setBackground(new java.awt.Color(255, 255, 153));

        lblTenPhong61.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTenPhong61.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhong61.setText("102TC");

        lblLoaiPhong61.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblLoaiPhong61.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhong61.setText("Tiêu chuẩn");

        lblTrangThai61.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTrangThai61.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThai61.setText("Trạng thái");

        javax.swing.GroupLayout phong61Layout = new javax.swing.GroupLayout(phong61);
        phong61.setLayout(phong61Layout);
        phong61Layout.setHorizontalGroup(
            phong61Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTenPhong61, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phong61Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong61Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(phong61Layout.createSequentialGroup()
                        .addComponent(lblLoaiPhong61, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(checkBoxPhong61))
                    .addComponent(lblTrangThai61, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phong61Layout.setVerticalGroup(
            phong61Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong61Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong61Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLoaiPhong61)
                    .addComponent(checkBoxPhong61))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTenPhong61, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTrangThai61)
                .addContainerGap())
        );

        phong62.setBackground(new java.awt.Color(255, 255, 153));

        lblTenPhong62.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTenPhong62.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhong62.setText("102NC");

        lblLoaiPhong62.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblLoaiPhong62.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhong62.setText("Nâng cao");

        lblTrangThai62.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTrangThai62.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThai62.setText("Đang trống");

        javax.swing.GroupLayout phong62Layout = new javax.swing.GroupLayout(phong62);
        phong62.setLayout(phong62Layout);
        phong62Layout.setHorizontalGroup(
            phong62Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTenPhong62, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phong62Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong62Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(phong62Layout.createSequentialGroup()
                        .addComponent(lblLoaiPhong62, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(checkBoxPhong62))
                    .addComponent(lblTrangThai62, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phong62Layout.setVerticalGroup(
            phong62Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong62Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong62Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLoaiPhong62)
                    .addComponent(checkBoxPhong62))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTenPhong62, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTrangThai62)
                .addContainerGap())
        );

        phong63.setBackground(new java.awt.Color(255, 255, 153));

        lblTenPhong63.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTenPhong63.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhong63.setText("103CC");

        lblLoaiPhong63.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblLoaiPhong63.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhong63.setText("Cao cấp");

        lblTrangThai63.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTrangThai63.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThai63.setText("Đã đặt");

        javax.swing.GroupLayout phong63Layout = new javax.swing.GroupLayout(phong63);
        phong63.setLayout(phong63Layout);
        phong63Layout.setHorizontalGroup(
            phong63Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTenPhong63, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phong63Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong63Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(phong63Layout.createSequentialGroup()
                        .addComponent(lblLoaiPhong63, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(checkBoxPhong63))
                    .addComponent(lblTrangThai63, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phong63Layout.setVerticalGroup(
            phong63Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong63Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong63Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLoaiPhong63)
                    .addComponent(checkBoxPhong63))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTenPhong63, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTrangThai63)
                .addContainerGap())
        );

        phong64.setBackground(new java.awt.Color(255, 255, 153));

        lblTenPhong64.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTenPhong64.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhong64.setText("109TC");

        lblLoaiPhong64.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblLoaiPhong64.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhong64.setText("Thương gia");

        lblTrangThai64.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTrangThai64.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThai64.setText("Đang thuê");

        javax.swing.GroupLayout phong64Layout = new javax.swing.GroupLayout(phong64);
        phong64.setLayout(phong64Layout);
        phong64Layout.setHorizontalGroup(
            phong64Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTenPhong64, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phong64Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong64Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(phong64Layout.createSequentialGroup()
                        .addComponent(lblLoaiPhong64, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(checkBoxPhong64))
                    .addComponent(lblTrangThai64, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phong64Layout.setVerticalGroup(
            phong64Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong64Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong64Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLoaiPhong64)
                    .addComponent(checkBoxPhong64))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTenPhong64, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTrangThai64)
                .addContainerGap())
        );

        phong65.setBackground(new java.awt.Color(255, 255, 153));
        phong65.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                phong65MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                phong65MouseEntered(evt);
            }
        });

        lblTenPhong65.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTenPhong65.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhong65.setText("101TC");

        lblLoaiPhong65.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblLoaiPhong65.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhong65.setText("Tiêu chuẩn");

        lblTrangThai65.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTrangThai65.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThai65.setText("Đang thuê");

        javax.swing.GroupLayout phong65Layout = new javax.swing.GroupLayout(phong65);
        phong65.setLayout(phong65Layout);
        phong65Layout.setHorizontalGroup(
            phong65Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phong65Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong65Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(phong65Layout.createSequentialGroup()
                        .addComponent(lblLoaiPhong65, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(checkBoxPhong65))
                    .addComponent(lblTrangThai65, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(lblTenPhong65, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        phong65Layout.setVerticalGroup(
            phong65Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong65Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong65Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(checkBoxPhong65)
                    .addComponent(lblLoaiPhong65))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTenPhong65, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTrangThai65)
                .addContainerGap())
        );

        phong66.setBackground(new java.awt.Color(255, 255, 153));

        lblTenPhong66.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTenPhong66.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhong66.setText("102TC");

        lblLoaiPhong66.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblLoaiPhong66.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhong66.setText("Tiêu chuẩn");

        lblTrangThai66.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTrangThai66.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThai66.setText("Trạng thái");

        javax.swing.GroupLayout phong66Layout = new javax.swing.GroupLayout(phong66);
        phong66.setLayout(phong66Layout);
        phong66Layout.setHorizontalGroup(
            phong66Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTenPhong66, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phong66Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong66Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(phong66Layout.createSequentialGroup()
                        .addComponent(lblLoaiPhong66, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(checkBoxPhong66))
                    .addComponent(lblTrangThai66, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phong66Layout.setVerticalGroup(
            phong66Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong66Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong66Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLoaiPhong66)
                    .addComponent(checkBoxPhong66))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTenPhong66, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTrangThai66)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(phong57, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(phong65, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(phong62, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(phong63, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(phong64, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(phong66, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(phong58, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(phong59, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(phong60, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(phong61, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(phong57, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phong61, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(phong60, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(phong58, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(phong59, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(24, 24, 24)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(phong66, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(phong64, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(phong63, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(phong62, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(phong65, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout Tang3Layout = new javax.swing.GroupLayout(Tang3);
        Tang3.setLayout(Tang3Layout);
        Tang3Layout.setHorizontalGroup(
            Tang3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Tang3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        Tang3Layout.setVerticalGroup(
            Tang3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Tang3Layout.createSequentialGroup()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnBodyLayout = new javax.swing.GroupLayout(pnBody);
        pnBody.setLayout(pnBodyLayout);
        pnBodyLayout.setHorizontalGroup(
            pnBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnBodyLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(pnBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Tang1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Tang2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Tang3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Tang4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnBodyLayout.setVerticalGroup(
            pnBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnBodyLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(Tang1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Tang2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Tang3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(Tang4, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        jScrollPane1.setViewportView(pnBody);

        funtionPanel.setBackground(new java.awt.Color(204, 255, 204));
        funtionPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Quản lý phòng", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N

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

        jButton1.setText("Trả phòng");

        jButton2.setText("Đổi phòng");

        jButton3.setText("Hủy đặt phòng");

        jButton4.setText("Đặt phòng");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
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
                .addGap(41, 41, 41)
                .addGroup(funtionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(radPhongTieuChuan)
                    .addComponent(radPhongNangCao, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(radPhongThuongGia)
                    .addComponent(radPhongCaoCap, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(funtionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(radPhongDangThue)
                    .addComponent(radPhongTrong, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(radPhongDaDat, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFindbyPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(funtionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnResetTrangThai, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        funtionPanelLayout.setVerticalGroup(
            funtionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, funtionPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(funtionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbldate, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jButton4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(funtionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblcurrentdate)
                    .addComponent(radPhongTieuChuan, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(radPhongTrong)
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(funtionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbltime)
                    .addComponent(radPhongNangCao)
                    .addComponent(radPhongDangThue)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(funtionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radPhongCaoCap)
                    .addComponent(radPhongDaDat)
                    .addComponent(lblcurrentTime)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(funtionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radPhongThuongGia)
                    .addComponent(btnResetTrangThai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnFindbyPhone))
                .addGap(12, 12, 12))
        );

        javax.swing.GroupLayout pnQuanLyPhongLayout = new javax.swing.GroupLayout(pnQuanLyPhong);
        pnQuanLyPhong.setLayout(pnQuanLyPhongLayout);
        pnQuanLyPhongLayout.setHorizontalGroup(
            pnQuanLyPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnQuanLyPhongLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnQuanLyPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(funtionPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1253, Short.MAX_VALUE))
                .addContainerGap(54, Short.MAX_VALUE))
        );
        pnQuanLyPhongLayout.setVerticalGroup(
            pnQuanLyPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnQuanLyPhongLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(funtionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 431, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(126, Short.MAX_VALUE))
        );

        jPanel1.add(pnQuanLyPhong, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void radPhongTieuChuanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radPhongTieuChuanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radPhongTieuChuanActionPerformed

    private void btnFindbyPhoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindbyPhoneActionPerformed
        // TODO add your handling code here:
        JPanel[] phong = {phong2, phong3, phong4, phong5, phong6 , phong9, phong10,
            phong11, phong13, phong14, phong15 , phong16 ,phong22,phong23,phong29,phong30,
            phong43, phong44, phong45, phong46, phong47, phong51, phong57, phong58, phong59,
            phong61, phong62, phong63, phong64, phong65, phong66};
        
        JLabel[] loaiPhong = {lblLoaiPhong2, lblLoaiPhong3, lblLoaiPhong4, lblLoaiPhong5, lblLoaiPhong6 , lblLoaiPhong9, lblLoaiPhong10,
            lblLoaiPhong11, lblLoaiPhong13, lblLoaiPhong14, lblLoaiPhong15 , lblLoaiPhong16 ,lblLoaiPhong22,lblLoaiPhong23,lblLoaiPhong29,lblLoaiPhong30,
            lblLoaiPhong43, lblLoaiPhong44, lblLoaiPhong45, lblLoaiPhong46, lblLoaiPhong47, lblLoaiPhong51, lblLoaiPhong57, lblLoaiPhong58, lblLoaiPhong59,
            lblLoaiPhong61, lblLoaiPhong62, lblLoaiPhong63, lblLoaiPhong64, lblLoaiPhong65, lblLoaiPhong66};
        
        JLabel[] tenPhong = {lblTenPhong2, lblTenPhong3, lblTenPhong4, lblTenPhong5, lblTenPhong6 , lblTenPhong9, lblTenPhong10,
            lblTenPhong11, lblTenPhong13, lblTenPhong14, lblTenPhong15 , lblTenPhong16 ,lblTenPhong22,lblTenPhong23,lblTenPhong29,lblTenPhong30,
            lblTenPhong43, lblTenPhong44, lblTenPhong45, lblTenPhong46, lblTenPhong47, lblTenPhong51, lblTenPhong57, lblTenPhong58, lblTenPhong59,
            lblTenPhong61, lblTenPhong62, lblTenPhong63, lblTenPhong64, lblTenPhong65, lblTenPhong66};
        
        JLabel[] trangThai = {lblTrangThai2, lblTrangThai3, lblTrangThai4, lblTrangThai5, lblTrangThai6 , lblTrangThai9, lblTrangThai10,
            lblTrangThai11, lblTrangThai13, lblTrangThai14, lblTrangThai15 , lblTrangThai16 ,lblTrangThai22,lblTrangThai23,lblTrangThai29,lblTrangThai30,
            lblTrangThai43, lblTrangThai44, lblTrangThai45, lblTrangThai46, lblTrangThai47, lblTrangThai51, lblTrangThai57, lblTrangThai58, lblTrangThai59,
            lblTrangThai61, lblTrangThai62, lblTrangThai63, lblTrangThai64, lblTrangThai65, lblTrangThai66};
        
        JCheckBox[] cks = {checkBoxPhong2, checkBoxPhong3, checkBoxPhong4, checkBoxPhong5, checkBoxPhong6 , checkBoxPhong9, checkBoxPhong10,
            checkBoxPhong11, checkBoxPhong13, checkBoxPhong14, checkBoxPhong15 , checkBoxPhong16 ,checkBoxPhong22,checkBoxPhong23,checkBoxPhong29,checkBoxPhong30,
            checkBoxPhong43, checkBoxPhong44, checkBoxPhong45, checkBoxPhong46, checkBoxPhong47, checkBoxPhong51, checkBoxPhong57, checkBoxPhong58, checkBoxPhong59,
            checkBoxPhong61, checkBoxPhong62, checkBoxPhong63, checkBoxPhong64, checkBoxPhong65, checkBoxPhong66};
        
        
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
        JFrame datphongz = new DatPhong(getTenPhong);
        datphongz.show();
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

    private void huyDatPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_huyDatPhongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_huyDatPhongActionPerformed

    private void traPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_traPhongActionPerformed
        // TODO add your handling code here:
        JFrame traPhong = new TraPhong(getTenPhong);
        traPhong.show();
    }//GEN-LAST:event_traPhongActionPerformed

    private void phong7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_phong7MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_phong7MouseClicked

    private void phong7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_phong7MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_phong7MouseEntered

    private void phong12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_phong12MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_phong12MouseClicked

    private void phong12MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_phong12MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_phong12MouseEntered

    private void phong30MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_phong30MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_phong30MouseClicked

    private void phong30MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_phong30MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_phong30MouseEntered

    private void phong44MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_phong44MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_phong44MouseClicked

    private void phong44MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_phong44MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_phong44MouseEntered

    private void phong57MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_phong57MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_phong57MouseClicked

    private void phong57MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_phong57MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_phong57MouseEntered

    private void phong65MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_phong65MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_phong65MouseClicked

    private void phong65MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_phong65MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_phong65MouseEntered

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    
    
    
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
    private javax.swing.JCheckBox checkBoxPhong10;
    private javax.swing.JCheckBox checkBoxPhong11;
    private javax.swing.JCheckBox checkBoxPhong12;
    private javax.swing.JCheckBox checkBoxPhong13;
    private javax.swing.JCheckBox checkBoxPhong14;
    private javax.swing.JCheckBox checkBoxPhong15;
    private javax.swing.JCheckBox checkBoxPhong16;
    private javax.swing.JCheckBox checkBoxPhong2;
    private javax.swing.JCheckBox checkBoxPhong22;
    private javax.swing.JCheckBox checkBoxPhong23;
    private javax.swing.JCheckBox checkBoxPhong29;
    private javax.swing.JCheckBox checkBoxPhong3;
    private javax.swing.JCheckBox checkBoxPhong30;
    private javax.swing.JCheckBox checkBoxPhong4;
    private javax.swing.JCheckBox checkBoxPhong43;
    private javax.swing.JCheckBox checkBoxPhong44;
    private javax.swing.JCheckBox checkBoxPhong45;
    private javax.swing.JCheckBox checkBoxPhong46;
    private javax.swing.JCheckBox checkBoxPhong47;
    private javax.swing.JCheckBox checkBoxPhong5;
    private javax.swing.JCheckBox checkBoxPhong51;
    private javax.swing.JCheckBox checkBoxPhong57;
    private javax.swing.JCheckBox checkBoxPhong58;
    private javax.swing.JCheckBox checkBoxPhong59;
    private javax.swing.JCheckBox checkBoxPhong6;
    private javax.swing.JCheckBox checkBoxPhong60;
    private javax.swing.JCheckBox checkBoxPhong61;
    private javax.swing.JCheckBox checkBoxPhong62;
    private javax.swing.JCheckBox checkBoxPhong63;
    private javax.swing.JCheckBox checkBoxPhong64;
    private javax.swing.JCheckBox checkBoxPhong65;
    private javax.swing.JCheckBox checkBoxPhong66;
    private javax.swing.JCheckBox checkBoxPhong7;
    private javax.swing.JCheckBox checkBoxPhong8;
    private javax.swing.JCheckBox checkBoxPhong9;
    private javax.swing.JPopupMenu chucNang;
    private javax.swing.JMenuItem datPhong;
    private javax.swing.JMenuItem doiPhong;
    private javax.swing.JPanel funtionPanel;
    private javax.swing.JMenuItem huyDatPhong;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblLoaiPhong10;
    private javax.swing.JLabel lblLoaiPhong11;
    private javax.swing.JLabel lblLoaiPhong12;
    private javax.swing.JLabel lblLoaiPhong13;
    private javax.swing.JLabel lblLoaiPhong14;
    private javax.swing.JLabel lblLoaiPhong15;
    private javax.swing.JLabel lblLoaiPhong16;
    private javax.swing.JLabel lblLoaiPhong2;
    private javax.swing.JLabel lblLoaiPhong22;
    private javax.swing.JLabel lblLoaiPhong23;
    private javax.swing.JLabel lblLoaiPhong29;
    private javax.swing.JLabel lblLoaiPhong3;
    private javax.swing.JLabel lblLoaiPhong30;
    private javax.swing.JLabel lblLoaiPhong4;
    private javax.swing.JLabel lblLoaiPhong43;
    private javax.swing.JLabel lblLoaiPhong44;
    private javax.swing.JLabel lblLoaiPhong45;
    private javax.swing.JLabel lblLoaiPhong46;
    private javax.swing.JLabel lblLoaiPhong47;
    private javax.swing.JLabel lblLoaiPhong5;
    private javax.swing.JLabel lblLoaiPhong51;
    private javax.swing.JLabel lblLoaiPhong57;
    private javax.swing.JLabel lblLoaiPhong58;
    private javax.swing.JLabel lblLoaiPhong59;
    private javax.swing.JLabel lblLoaiPhong6;
    private javax.swing.JLabel lblLoaiPhong60;
    private javax.swing.JLabel lblLoaiPhong61;
    private javax.swing.JLabel lblLoaiPhong62;
    private javax.swing.JLabel lblLoaiPhong63;
    private javax.swing.JLabel lblLoaiPhong64;
    private javax.swing.JLabel lblLoaiPhong65;
    private javax.swing.JLabel lblLoaiPhong66;
    private javax.swing.JLabel lblLoaiPhong7;
    private javax.swing.JLabel lblLoaiPhong8;
    private javax.swing.JLabel lblLoaiPhong9;
    private javax.swing.JLabel lblTenPhong10;
    private javax.swing.JLabel lblTenPhong11;
    private javax.swing.JLabel lblTenPhong12;
    private javax.swing.JLabel lblTenPhong13;
    private javax.swing.JLabel lblTenPhong14;
    private javax.swing.JLabel lblTenPhong15;
    private javax.swing.JLabel lblTenPhong16;
    private javax.swing.JLabel lblTenPhong2;
    private javax.swing.JLabel lblTenPhong22;
    private javax.swing.JLabel lblTenPhong23;
    private javax.swing.JLabel lblTenPhong29;
    private javax.swing.JLabel lblTenPhong3;
    private javax.swing.JLabel lblTenPhong30;
    private javax.swing.JLabel lblTenPhong4;
    private javax.swing.JLabel lblTenPhong43;
    private javax.swing.JLabel lblTenPhong44;
    private javax.swing.JLabel lblTenPhong45;
    private javax.swing.JLabel lblTenPhong46;
    private javax.swing.JLabel lblTenPhong47;
    private javax.swing.JLabel lblTenPhong5;
    private javax.swing.JLabel lblTenPhong51;
    private javax.swing.JLabel lblTenPhong57;
    private javax.swing.JLabel lblTenPhong58;
    private javax.swing.JLabel lblTenPhong59;
    private javax.swing.JLabel lblTenPhong6;
    private javax.swing.JLabel lblTenPhong60;
    private javax.swing.JLabel lblTenPhong61;
    private javax.swing.JLabel lblTenPhong62;
    private javax.swing.JLabel lblTenPhong63;
    private javax.swing.JLabel lblTenPhong64;
    private javax.swing.JLabel lblTenPhong65;
    private javax.swing.JLabel lblTenPhong66;
    private javax.swing.JLabel lblTenPhong7;
    private javax.swing.JLabel lblTenPhong8;
    private javax.swing.JLabel lblTenPhong9;
    private javax.swing.JLabel lblTrangThai10;
    private javax.swing.JLabel lblTrangThai11;
    private javax.swing.JLabel lblTrangThai12;
    private javax.swing.JLabel lblTrangThai13;
    private javax.swing.JLabel lblTrangThai14;
    private javax.swing.JLabel lblTrangThai15;
    private javax.swing.JLabel lblTrangThai16;
    private javax.swing.JLabel lblTrangThai2;
    private javax.swing.JLabel lblTrangThai22;
    private javax.swing.JLabel lblTrangThai23;
    private javax.swing.JLabel lblTrangThai29;
    private javax.swing.JLabel lblTrangThai3;
    private javax.swing.JLabel lblTrangThai30;
    private javax.swing.JLabel lblTrangThai4;
    private javax.swing.JLabel lblTrangThai43;
    private javax.swing.JLabel lblTrangThai44;
    private javax.swing.JLabel lblTrangThai45;
    private javax.swing.JLabel lblTrangThai46;
    private javax.swing.JLabel lblTrangThai47;
    private javax.swing.JLabel lblTrangThai5;
    private javax.swing.JLabel lblTrangThai51;
    private javax.swing.JLabel lblTrangThai57;
    private javax.swing.JLabel lblTrangThai58;
    private javax.swing.JLabel lblTrangThai59;
    private javax.swing.JLabel lblTrangThai6;
    private javax.swing.JLabel lblTrangThai60;
    private javax.swing.JLabel lblTrangThai61;
    private javax.swing.JLabel lblTrangThai62;
    private javax.swing.JLabel lblTrangThai63;
    private javax.swing.JLabel lblTrangThai64;
    private javax.swing.JLabel lblTrangThai65;
    private javax.swing.JLabel lblTrangThai66;
    private javax.swing.JLabel lblTrangThai7;
    private javax.swing.JLabel lblTrangThai8;
    private javax.swing.JLabel lblTrangThai9;
    private javax.swing.JLabel lblcurrentTime;
    private javax.swing.JLabel lblcurrentdate;
    private javax.swing.JLabel lbldate;
    private javax.swing.JLabel lbltime;
    private javax.swing.JPanel phong10;
    private javax.swing.JPanel phong11;
    private javax.swing.JPanel phong12;
    private javax.swing.JPanel phong13;
    private javax.swing.JPanel phong14;
    private javax.swing.JPanel phong15;
    private javax.swing.JPanel phong16;
    private javax.swing.JPanel phong2;
    private javax.swing.JPanel phong22;
    private javax.swing.JPanel phong23;
    private javax.swing.JPanel phong29;
    private javax.swing.JPanel phong3;
    private javax.swing.JPanel phong30;
    private javax.swing.JPanel phong4;
    private javax.swing.JPanel phong43;
    private javax.swing.JPanel phong44;
    private javax.swing.JPanel phong45;
    private javax.swing.JPanel phong46;
    private javax.swing.JPanel phong47;
    private javax.swing.JPanel phong5;
    private javax.swing.JPanel phong51;
    private javax.swing.JPanel phong57;
    private javax.swing.JPanel phong58;
    private javax.swing.JPanel phong59;
    private javax.swing.JPanel phong6;
    private javax.swing.JPanel phong60;
    private javax.swing.JPanel phong61;
    private javax.swing.JPanel phong62;
    private javax.swing.JPanel phong63;
    private javax.swing.JPanel phong64;
    private javax.swing.JPanel phong65;
    private javax.swing.JPanel phong66;
    private javax.swing.JPanel phong7;
    private javax.swing.JPanel phong8;
    private javax.swing.JPanel phong9;
    private javax.swing.JPanel pnBody;
    private javax.swing.JPanel pnHeader;
    private javax.swing.JPanel pnMenu;
    private javax.swing.JPanel pnQuanLyPhong;
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
            phong11, phong13, phong14, phong15 , phong16 ,phong22,phong23,phong29,phong30,
            phong43, phong44, phong45, phong46, phong47, phong51, phong57, phong58, phong59,
            phong61, phong62, phong63, phong64, phong65, phong66};
        for(int i = 0; i< phong.length;i++){
                JPanel p = phong[i];
                p.show();
            }
    }

    private void ShowHideOption() {
        JPanel[] phong = {phong2, phong3, phong4, phong5, phong6 , phong9, phong10,
            phong11, phong13, phong14, phong15 , phong16 ,phong22,phong23,phong29,phong30,
            phong43, phong44, phong45, phong46, phong47, phong51, phong57, phong58, phong59,
            phong61, phong62, phong63, phong64, phong65, phong66};
        
        JLabel[] loaiPhong = {lblLoaiPhong2, lblLoaiPhong3, lblLoaiPhong4, lblLoaiPhong5, lblLoaiPhong6 , lblLoaiPhong9, lblLoaiPhong10,
            lblLoaiPhong11, lblLoaiPhong13, lblLoaiPhong14, lblLoaiPhong15 , lblLoaiPhong16 ,lblLoaiPhong22,lblLoaiPhong23,lblLoaiPhong29,lblLoaiPhong30,
            lblLoaiPhong43, lblLoaiPhong44, lblLoaiPhong45, lblLoaiPhong46, lblLoaiPhong47, lblLoaiPhong51, lblLoaiPhong57, lblLoaiPhong58, lblLoaiPhong59,
            lblLoaiPhong61, lblLoaiPhong62, lblLoaiPhong63, lblLoaiPhong64, lblLoaiPhong65, lblLoaiPhong66};
        
        JLabel[] tenPhong = {lblTenPhong2, lblTenPhong3, lblTenPhong4, lblTenPhong5, lblTenPhong6 , lblTenPhong9, lblTenPhong10,
            lblTenPhong11, lblTenPhong13, lblTenPhong14, lblTenPhong15 , lblTenPhong16 ,lblTenPhong22,lblTenPhong23,lblTenPhong29,lblTenPhong30,
            lblTenPhong43, lblTenPhong44, lblTenPhong45, lblTenPhong46, lblTenPhong47, lblTenPhong51, lblTenPhong57, lblTenPhong58, lblTenPhong59,
            lblTenPhong61, lblTenPhong62, lblTenPhong63, lblTenPhong64, lblTenPhong65, lblTenPhong66};
        
        JLabel[] trangThai = {lblTrangThai2, lblTrangThai3, lblTrangThai4, lblTrangThai5, lblTrangThai6 , lblTrangThai9, lblTrangThai10,
            lblTrangThai11, lblTrangThai13, lblTrangThai14, lblTrangThai15 , lblTrangThai16 ,lblTrangThai22,lblTrangThai23,lblTrangThai29,lblTrangThai30,
            lblTrangThai43, lblTrangThai44, lblTrangThai45, lblTrangThai46, lblTrangThai47, lblTrangThai51, lblTrangThai57, lblTrangThai58, lblTrangThai59,
            lblTrangThai61, lblTrangThai62, lblTrangThai63, lblTrangThai64, lblTrangThai65, lblTrangThai66};
        
        JCheckBox[] cks = {checkBoxPhong2, checkBoxPhong3, checkBoxPhong4, checkBoxPhong5, checkBoxPhong6 , checkBoxPhong9, checkBoxPhong10,
            checkBoxPhong11, checkBoxPhong13, checkBoxPhong14, checkBoxPhong15 , checkBoxPhong16 ,checkBoxPhong22,checkBoxPhong23,checkBoxPhong29,checkBoxPhong30,
            checkBoxPhong43, checkBoxPhong44, checkBoxPhong45, checkBoxPhong46, checkBoxPhong47, checkBoxPhong51, checkBoxPhong57, checkBoxPhong58, checkBoxPhong59,
            checkBoxPhong61, checkBoxPhong62, checkBoxPhong63, checkBoxPhong64, checkBoxPhong65, checkBoxPhong66};
        
        for (int i = 0; i < phong.length; i++) {
            JPanel p = phong[i];
            JLabel loaiP = loaiPhong[i]; 
            JLabel ttP = trangThai[i]; 
            JLabel tenP = tenPhong[i];
            p.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (SwingUtilities.isRightMouseButton(e)) { 
                                           
                        datPhong.hide();
                        huyDatPhong.hide();
                        doiPhong.hide();
                        traPhong.hide();
                            
                            
                        if (ttP.getText().equalsIgnoreCase("Đang trống")) {
                            datPhong.show();
                        } else if (ttP.getText().equalsIgnoreCase("Đang thuê")) {
                            doiPhong.show();
                            traPhong.show();
                        } else if (ttP.getText().equalsIgnoreCase("Đã đặt")) {
                            doiPhong.show();
                            huyDatPhong.show();
                        } 
                        
                        chucNang.show(p, e.getX(), e.getY());     
                        
                        getTenPhong = tenP.getText();
                    }
                }
            });
        }
    }

    

    
    
   
}
