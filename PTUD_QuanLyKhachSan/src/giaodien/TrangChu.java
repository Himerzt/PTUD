package giaodien;

import static java.awt.Color.red;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import menu.MenuEvent;
/**
 *
 * @author Huynguyen
 */
public class TrangChu extends javax.swing.JFrame {

    public TrangChu() {
         
//        setUndecorated(true);
//        setAlwaysOnTop(true);
        setResizable(false);
        Toolkit tk = Toolkit.getDefaultToolkit();
        int x=(int) tk.getScreenSize().getWidth();
        int y=(int) tk.getScreenSize().getHeight();
        setSize(x, y);
        initComponents();
        datetime();
        times();
        
        
        Menu.setEvent(new MenuEvent(){
            @Override
            public void selected(int index, int subIndex) {
                if (index == 6) {
                System.exit(0); 
                }
                
                if ( index == 0){
                    pnedUngDung.setSelectedIndex(0);
                }
                
                if ( index == 1){
                    pnedUngDung.setSelectedIndex(1);
                }
                
                if ( index == 2){
                    pnedUngDung.setSelectedIndex(2);
                }
                if ( index == 3){
                    pnedUngDung.setSelectedIndex(3);
                }
                
                if ( index == 4){
                    pnedUngDung.setSelectedIndex(4);
                }
                if ( index == 5){
                    pnedUngDung.setSelectedIndex(5);
                }
                
            }
            
        });
        
    }

public void datetime(){
    Date d = new Date();
    
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MMM-dd");
    String df = format.format(d);
    
//    lbl_current_date.setText(df);
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
//        lbl_time.setText(timeindate);
        
        }        
    });
    
    time.start();
}
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGROUPLoaiPhong = new javax.swing.ButtonGroup();
        btnGROUPTrangThai = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        pnHeader = new javax.swing.JPanel();
        Header = new component.Header();
        lblMaNhanVien_header = new javax.swing.JLabel();
        jButton9 = new javax.swing.JButton();
        pnMenu = new javax.swing.JPanel();
        Menu = new menu.Menu();
        pnedUngDung = new javax.swing.JTabbedPane();
        pnTrangChu = new javax.swing.JPanel();
        pnLayOutTrangChu = new javax.swing.JPanel();
        ScrollPaneTrangChu = new javax.swing.JScrollPane();
        pnBody1 = new javax.swing.JPanel();
        Tang1_TrangChu = new javax.swing.JPanel();
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
        Tang2_TrangChu = new javax.swing.JPanel();
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
        Tang3_TrangChu = new javax.swing.JPanel();
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
        Tang4_TrangChu = new javax.swing.JPanel();
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
        pnQuanLyPhong = new javax.swing.JPanel();
        ScrollPaneQuanLyPhong = new javax.swing.JScrollPane();
        pnBody2 = new javax.swing.JPanel();
        Tang2_QuanLyPhong = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        phong7 = new javax.swing.JPanel();
        lblTenPhong7 = new javax.swing.JLabel();
        lblLoaiPhong7 = new javax.swing.JLabel();
        lblTrangThai7 = new javax.swing.JLabel();
        checkBoxPhong2 = new javax.swing.JCheckBox();
        phong8 = new javax.swing.JPanel();
        lblTenPhong8 = new javax.swing.JLabel();
        lblLoaiPhong8 = new javax.swing.JLabel();
        lblTrangThai8 = new javax.swing.JLabel();
        checkBoxPhong3 = new javax.swing.JCheckBox();
        phong12 = new javax.swing.JPanel();
        lblTenPhong12 = new javax.swing.JLabel();
        lblLoaiPhong12 = new javax.swing.JLabel();
        lblTrangThai12 = new javax.swing.JLabel();
        checkBoxPhong4 = new javax.swing.JCheckBox();
        phong15 = new javax.swing.JPanel();
        lblTenPhong15 = new javax.swing.JLabel();
        lblLoaiPhong15 = new javax.swing.JLabel();
        lblTrangThai15 = new javax.swing.JLabel();
        checkBoxPhong5 = new javax.swing.JCheckBox();
        phong16 = new javax.swing.JPanel();
        lblTenPhong16 = new javax.swing.JLabel();
        lblLoaiPhong16 = new javax.swing.JLabel();
        lblTrangThai16 = new javax.swing.JLabel();
        checkBoxPhong6 = new javax.swing.JCheckBox();
        phong22 = new javax.swing.JPanel();
        lblTenPhong22 = new javax.swing.JLabel();
        lblLoaiPhong22 = new javax.swing.JLabel();
        lblTrangThai22 = new javax.swing.JLabel();
        checkBoxPhong8 = new javax.swing.JCheckBox();
        phong23 = new javax.swing.JPanel();
        lblTenPhong23 = new javax.swing.JLabel();
        lblLoaiPhong23 = new javax.swing.JLabel();
        lblTrangThai23 = new javax.swing.JLabel();
        checkBoxPhong9 = new javax.swing.JCheckBox();
        phong29 = new javax.swing.JPanel();
        lblTenPhong29 = new javax.swing.JLabel();
        lblLoaiPhong29 = new javax.swing.JLabel();
        lblTrangThai29 = new javax.swing.JLabel();
        checkBoxPhong10 = new javax.swing.JCheckBox();
        phong30 = new javax.swing.JPanel();
        lblTenPhong30 = new javax.swing.JLabel();
        lblLoaiPhong30 = new javax.swing.JLabel();
        lblTrangThai30 = new javax.swing.JLabel();
        checkBoxPhong7 = new javax.swing.JCheckBox();
        phong43 = new javax.swing.JPanel();
        lblTenPhong43 = new javax.swing.JLabel();
        lblLoaiPhong43 = new javax.swing.JLabel();
        lblTrangThai43 = new javax.swing.JLabel();
        checkBoxPhong11 = new javax.swing.JCheckBox();
        Tang1_QuanLyPhong = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        phong44 = new javax.swing.JPanel();
        lblTenPhong44 = new javax.swing.JLabel();
        lblLoaiPhong44 = new javax.swing.JLabel();
        lblTrangThai44 = new javax.swing.JLabel();
        checkBoxPhong12 = new javax.swing.JCheckBox();
        phong45 = new javax.swing.JPanel();
        lblTenPhong45 = new javax.swing.JLabel();
        lblLoaiPhong45 = new javax.swing.JLabel();
        lblTrangThai45 = new javax.swing.JLabel();
        checkBoxPhong13 = new javax.swing.JCheckBox();
        phong46 = new javax.swing.JPanel();
        lblTenPhong46 = new javax.swing.JLabel();
        lblLoaiPhong46 = new javax.swing.JLabel();
        lblTrangThai46 = new javax.swing.JLabel();
        checkBoxPhong14 = new javax.swing.JCheckBox();
        phong47 = new javax.swing.JPanel();
        lblTenPhong47 = new javax.swing.JLabel();
        lblLoaiPhong47 = new javax.swing.JLabel();
        lblTrangThai47 = new javax.swing.JLabel();
        checkBoxPhong15 = new javax.swing.JCheckBox();
        phong51 = new javax.swing.JPanel();
        lblTenPhong51 = new javax.swing.JLabel();
        lblLoaiPhong51 = new javax.swing.JLabel();
        lblTrangThai51 = new javax.swing.JLabel();
        checkBoxPhong16 = new javax.swing.JCheckBox();
        phong52 = new javax.swing.JPanel();
        lblTenPhong52 = new javax.swing.JLabel();
        lblLoaiPhong52 = new javax.swing.JLabel();
        lblTrangThai52 = new javax.swing.JLabel();
        checkBoxPhong22 = new javax.swing.JCheckBox();
        phong53 = new javax.swing.JPanel();
        lblTenPhong53 = new javax.swing.JLabel();
        lblLoaiPhong53 = new javax.swing.JLabel();
        lblTrangThai53 = new javax.swing.JLabel();
        checkBoxPhong23 = new javax.swing.JCheckBox();
        phong54 = new javax.swing.JPanel();
        lblTenPhong54 = new javax.swing.JLabel();
        lblLoaiPhong54 = new javax.swing.JLabel();
        lblTrangThai54 = new javax.swing.JLabel();
        checkBoxPhong29 = new javax.swing.JCheckBox();
        phong55 = new javax.swing.JPanel();
        lblTenPhong55 = new javax.swing.JLabel();
        lblLoaiPhong55 = new javax.swing.JLabel();
        lblTrangThai55 = new javax.swing.JLabel();
        checkBoxPhong30 = new javax.swing.JCheckBox();
        phong56 = new javax.swing.JPanel();
        lblTenPhong56 = new javax.swing.JLabel();
        lblLoaiPhong56 = new javax.swing.JLabel();
        lblTrangThai56 = new javax.swing.JLabel();
        checkBoxPhong43 = new javax.swing.JCheckBox();
        Tang4_QuanLyPhong = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        phong57 = new javax.swing.JPanel();
        lblTenPhong57 = new javax.swing.JLabel();
        lblLoaiPhong57 = new javax.swing.JLabel();
        lblTrangThai57 = new javax.swing.JLabel();
        checkBoxPhong44 = new javax.swing.JCheckBox();
        phong58 = new javax.swing.JPanel();
        lblTenPhong58 = new javax.swing.JLabel();
        lblLoaiPhong58 = new javax.swing.JLabel();
        lblTrangThai58 = new javax.swing.JLabel();
        checkBoxPhong45 = new javax.swing.JCheckBox();
        phong59 = new javax.swing.JPanel();
        lblTenPhong59 = new javax.swing.JLabel();
        lblLoaiPhong59 = new javax.swing.JLabel();
        lblTrangThai59 = new javax.swing.JLabel();
        checkBoxPhong46 = new javax.swing.JCheckBox();
        phong60 = new javax.swing.JPanel();
        lblTenPhong60 = new javax.swing.JLabel();
        lblLoaiPhong60 = new javax.swing.JLabel();
        lblTrangThai60 = new javax.swing.JLabel();
        checkBoxPhong47 = new javax.swing.JCheckBox();
        phong61 = new javax.swing.JPanel();
        lblTenPhong61 = new javax.swing.JLabel();
        lblLoaiPhong61 = new javax.swing.JLabel();
        lblTrangThai61 = new javax.swing.JLabel();
        checkBoxPhong51 = new javax.swing.JCheckBox();
        Tang3_QuanLyPhong = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        phong62 = new javax.swing.JPanel();
        lblTenPhong62 = new javax.swing.JLabel();
        lblLoaiPhong62 = new javax.swing.JLabel();
        lblTrangThai62 = new javax.swing.JLabel();
        checkBoxPhong57 = new javax.swing.JCheckBox();
        phong63 = new javax.swing.JPanel();
        lblTenPhong63 = new javax.swing.JLabel();
        lblLoaiPhong63 = new javax.swing.JLabel();
        lblTrangThai63 = new javax.swing.JLabel();
        checkBoxPhong58 = new javax.swing.JCheckBox();
        phong64 = new javax.swing.JPanel();
        lblTenPhong64 = new javax.swing.JLabel();
        lblLoaiPhong64 = new javax.swing.JLabel();
        lblTrangThai64 = new javax.swing.JLabel();
        checkBoxPhong59 = new javax.swing.JCheckBox();
        phong65 = new javax.swing.JPanel();
        lblTenPhong65 = new javax.swing.JLabel();
        lblLoaiPhong65 = new javax.swing.JLabel();
        lblTrangThai65 = new javax.swing.JLabel();
        checkBoxPhong60 = new javax.swing.JCheckBox();
        phong66 = new javax.swing.JPanel();
        lblTenPhong66 = new javax.swing.JLabel();
        lblLoaiPhong66 = new javax.swing.JLabel();
        lblTrangThai66 = new javax.swing.JLabel();
        checkBoxPhong61 = new javax.swing.JCheckBox();
        phong67 = new javax.swing.JPanel();
        lblTenPhong67 = new javax.swing.JLabel();
        lblLoaiPhong67 = new javax.swing.JLabel();
        lblTrangThai67 = new javax.swing.JLabel();
        checkBoxPhong62 = new javax.swing.JCheckBox();
        phong68 = new javax.swing.JPanel();
        lblTenPhong68 = new javax.swing.JLabel();
        lblLoaiPhong68 = new javax.swing.JLabel();
        lblTrangThai68 = new javax.swing.JLabel();
        checkBoxPhong63 = new javax.swing.JCheckBox();
        phong69 = new javax.swing.JPanel();
        lblTenPhong69 = new javax.swing.JLabel();
        lblLoaiPhong69 = new javax.swing.JLabel();
        lblTrangThai69 = new javax.swing.JLabel();
        checkBoxPhong64 = new javax.swing.JCheckBox();
        phong70 = new javax.swing.JPanel();
        lblTenPhong70 = new javax.swing.JLabel();
        lblLoaiPhong70 = new javax.swing.JLabel();
        lblTrangThai70 = new javax.swing.JLabel();
        checkBoxPhong65 = new javax.swing.JCheckBox();
        phong71 = new javax.swing.JPanel();
        lblTenPhong71 = new javax.swing.JLabel();
        lblLoaiPhong71 = new javax.swing.JLabel();
        lblTrangThai71 = new javax.swing.JLabel();
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
        pnNhanVien = new javax.swing.JPanel();
        pnLayOutNhanVien = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtMaNhanVien = new javax.swing.JTextField();
        txtNgayVaoLamNhanVien = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtHoTenNhanVien = new javax.swing.JTextField();
        txtSoDienThoaiNhanVien = new javax.swing.JTextField();
        txtNgaySinhNhanVien = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtCanCuocCongDanNhanVien = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        btnNgaySinhNhanVien = new giaodien.CustomClass.Button();
        btnNgayVaoLamNhanVien = new giaodien.CustomClass.Button();
        cbxGioiTinh = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        cbxChucVuNhanVien = new javax.swing.JComboBox<>();
        btnCapNhapNhanVien = new javax.swing.JButton();
        btnTamChoNghiNhanVien = new javax.swing.JButton();
        btnThemNhanVien = new javax.swing.JButton();
        btnXoaTrangNhanVien = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        txtEmailNhanVien1 = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        TableNhanVien = new javax.swing.JTable();
        pnDichVu = new javax.swing.JPanel();
        pnLayOutDichVu = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtMaDichVu = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtTenDichVu = new javax.swing.JTextField();
        txtDonGiaDichVu = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        btnCapNhapDichVu = new javax.swing.JButton();
        btnThemDichVu = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        TableDichVu = new javax.swing.JTable();
        pnKhuyenMai = new javax.swing.JPanel();
        pnLayOutKhuyenMai = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txtMaKhuyenMai = new javax.swing.JTextField();
        txtNgayBatDauKhuyenMai = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        txtTenKhuyenMai = new javax.swing.JTextField();
        txtNgayKetThucKhuyenMai = new javax.swing.JTextField();
        txtGiaTriKhuyenMai = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        btnThoiGianKetThucKhuyenMai = new giaodien.CustomClass.Button();
        btnThoiGianBatDauKhuyenMai = new giaodien.CustomClass.Button();
        btnCapNhapKhuyenMai = new javax.swing.JButton();
        btnNgungKhuyenMai = new javax.swing.JButton();
        btnThemKhuyenMai = new javax.swing.JButton();
        btnXoaTrangKhuyenMai = new javax.swing.JButton();
        cbxDieuKienApDungKhuyenMai = new javax.swing.JComboBox<>();
        jScrollPane5 = new javax.swing.JScrollPane();
        TableKhuyenMai = new javax.swing.JTable();
        pnKhachHang = new javax.swing.JPanel();
        pnLayOutKhachKhachHang = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        txtMaKhachHang = new javax.swing.JTextField();
        txtChiTieuKhachHang = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        txtTenKhachHang = new javax.swing.JTextField();
        txtSoDienThoaiKhachHang = new javax.swing.JTextField();
        txtNgaySinhKhachHang = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        txtCanCuocKhachHang = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        btnNgaySinhNhanVien3 = new giaodien.CustomClass.Button();
        cbxHangThanhVienKhachHang = new javax.swing.JComboBox<>();
        jLabel34 = new javax.swing.JLabel();
        cbxGioiTinhKhachHang = new javax.swing.JComboBox<>();
        btnCapNhapKhachHang = new javax.swing.JButton();
        btnThemKhachHang = new javax.swing.JButton();
        jLabel35 = new javax.swing.JLabel();
        txtQuocTichKhachHang = new javax.swing.JTextField();
        jScrollPane6 = new javax.swing.JScrollPane();
        TableKhachHang = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnHeader.setBackground(new java.awt.Color(34, 124, 157));
        pnHeader.setPreferredSize(new java.awt.Dimension(1553, 80));

        lblMaNhanVien_header.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblMaNhanVien_header.setForeground(new java.awt.Color(204, 255, 255));
        lblMaNhanVien_header.setText("Mã nhân viên để ở đây nha");

        jButton9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-log-out-32.png"))); // NOI18N
        jButton9.setPreferredSize(new java.awt.Dimension(36, 36));

        javax.swing.GroupLayout pnHeaderLayout = new javax.swing.GroupLayout(pnHeader);
        pnHeader.setLayout(pnHeaderLayout);
        pnHeaderLayout.setHorizontalGroup(
            pnHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnHeaderLayout.createSequentialGroup()
                .addComponent(Header, javax.swing.GroupLayout.PREFERRED_SIZE, 1077, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 104, Short.MAX_VALUE)
                .addComponent(lblMaNhanVien_header)
                .addGap(58, 58, 58)
                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );
        pnHeaderLayout.setVerticalGroup(
            pnHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Header, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
            .addGroup(pnHeaderLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(pnHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                    .addComponent(lblMaNhanVien_header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(pnHeader, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

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

        jPanel1.add(pnMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, -1, -1));

        pnedUngDung.setBackground(new java.awt.Color(255, 153, 102));

        pnBody1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Trang chủ", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 24))); // NOI18N

        Tang1_TrangChu.setBackground(new java.awt.Color(255, 255, 255));
        Tang1_TrangChu.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Tầng 1", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N

        phong2.setBackground(new java.awt.Color(255, 255, 153));

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
                .addGap(40, 40, 40)
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

        javax.swing.GroupLayout Tang1_TrangChuLayout = new javax.swing.GroupLayout(Tang1_TrangChu);
        Tang1_TrangChu.setLayout(Tang1_TrangChuLayout);
        Tang1_TrangChuLayout.setHorizontalGroup(
            Tang1_TrangChuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Tang1_TrangChuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        Tang1_TrangChuLayout.setVerticalGroup(
            Tang1_TrangChuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Tang1_TrangChuLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        Tang2_TrangChu.setBackground(new java.awt.Color(255, 255, 255));
        Tang2_TrangChu.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Tầng 2", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N

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
                .addGap(40, 40, 40)
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
                .addContainerGap(40, Short.MAX_VALUE))
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

        javax.swing.GroupLayout Tang2_TrangChuLayout = new javax.swing.GroupLayout(Tang2_TrangChu);
        Tang2_TrangChu.setLayout(Tang2_TrangChuLayout);
        Tang2_TrangChuLayout.setHorizontalGroup(
            Tang2_TrangChuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Tang2_TrangChuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        Tang2_TrangChuLayout.setVerticalGroup(
            Tang2_TrangChuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        Tang3_TrangChu.setBackground(new java.awt.Color(255, 255, 255));
        Tang3_TrangChu.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Tầng 3", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N

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
                .addGap(40, 40, 40)
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

        javax.swing.GroupLayout Tang3_TrangChuLayout = new javax.swing.GroupLayout(Tang3_TrangChu);
        Tang3_TrangChu.setLayout(Tang3_TrangChuLayout);
        Tang3_TrangChuLayout.setHorizontalGroup(
            Tang3_TrangChuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Tang3_TrangChuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        Tang3_TrangChuLayout.setVerticalGroup(
            Tang3_TrangChuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        Tang4_TrangChu.setBackground(new java.awt.Color(255, 255, 255));
        Tang4_TrangChu.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Tầng 4", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N

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
                .addGap(40, 40, 40)
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

        javax.swing.GroupLayout Tang4_TrangChuLayout = new javax.swing.GroupLayout(Tang4_TrangChu);
        Tang4_TrangChu.setLayout(Tang4_TrangChuLayout);
        Tang4_TrangChuLayout.setHorizontalGroup(
            Tang4_TrangChuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Tang4_TrangChuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        Tang4_TrangChuLayout.setVerticalGroup(
            Tang4_TrangChuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Tang4_TrangChuLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout pnBody1Layout = new javax.swing.GroupLayout(pnBody1);
        pnBody1.setLayout(pnBody1Layout);
        pnBody1Layout.setHorizontalGroup(
            pnBody1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnBody1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnBody1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Tang3_TrangChu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Tang2_TrangChu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Tang1_TrangChu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Tang4_TrangChu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(75, Short.MAX_VALUE))
        );
        pnBody1Layout.setVerticalGroup(
            pnBody1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnBody1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Tang1_TrangChu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Tang2_TrangChu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Tang3_TrangChu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Tang4_TrangChu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        ScrollPaneTrangChu.setViewportView(pnBody1);

        javax.swing.GroupLayout pnLayOutTrangChuLayout = new javax.swing.GroupLayout(pnLayOutTrangChu);
        pnLayOutTrangChu.setLayout(pnLayOutTrangChuLayout);
        pnLayOutTrangChuLayout.setHorizontalGroup(
            pnLayOutTrangChuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnLayOutTrangChuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ScrollPaneTrangChu, javax.swing.GroupLayout.PREFERRED_SIZE, 1253, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(54, Short.MAX_VALUE))
        );
        pnLayOutTrangChuLayout.setVerticalGroup(
            pnLayOutTrangChuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnLayOutTrangChuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ScrollPaneTrangChu, javax.swing.GroupLayout.PREFERRED_SIZE, 718, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(64, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnTrangChuLayout = new javax.swing.GroupLayout(pnTrangChu);
        pnTrangChu.setLayout(pnTrangChuLayout);
        pnTrangChuLayout.setHorizontalGroup(
            pnTrangChuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1313, Short.MAX_VALUE)
            .addGroup(pnTrangChuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnTrangChuLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pnLayOutTrangChu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        pnTrangChuLayout.setVerticalGroup(
            pnTrangChuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 805, Short.MAX_VALUE)
            .addGroup(pnTrangChuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnTrangChuLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pnLayOutTrangChu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pnedUngDung.addTab("tab1", pnTrangChu);

        pnBody2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        Tang2_QuanLyPhong.setBackground(new java.awt.Color(255, 255, 255));
        Tang2_QuanLyPhong.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Tầng 2", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N

        phong7.setBackground(new java.awt.Color(255, 255, 153));

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
                        .addComponent(lblLoaiPhong7, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(checkBoxPhong2))
                    .addComponent(lblTrangThai7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(lblTenPhong7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        phong7Layout.setVerticalGroup(
            phong7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(checkBoxPhong2)
                    .addComponent(lblLoaiPhong7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTenPhong7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTrangThai7)
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
                        .addComponent(lblLoaiPhong8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(checkBoxPhong3))
                    .addComponent(lblTrangThai8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phong8Layout.setVerticalGroup(
            phong8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLoaiPhong8)
                    .addComponent(checkBoxPhong3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTenPhong8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTrangThai8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        phong12.setBackground(new java.awt.Color(255, 255, 153));

        lblTenPhong12.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTenPhong12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhong12.setText("103CC");

        lblLoaiPhong12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblLoaiPhong12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhong12.setText("Cao cấp");

        lblTrangThai12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTrangThai12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThai12.setText("Đã đặt");

        javax.swing.GroupLayout phong12Layout = new javax.swing.GroupLayout(phong12);
        phong12.setLayout(phong12Layout);
        phong12Layout.setHorizontalGroup(
            phong12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTenPhong12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phong12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(phong12Layout.createSequentialGroup()
                        .addComponent(lblLoaiPhong12, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(checkBoxPhong4))
                    .addComponent(lblTrangThai12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phong12Layout.setVerticalGroup(
            phong12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLoaiPhong12)
                    .addComponent(checkBoxPhong4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTenPhong12, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTrangThai12)
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
                        .addComponent(checkBoxPhong5))
                    .addComponent(lblTrangThai15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phong15Layout.setVerticalGroup(
            phong15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLoaiPhong15)
                    .addComponent(checkBoxPhong5))
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
                        .addComponent(checkBoxPhong6))
                    .addComponent(lblTrangThai16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phong16Layout.setVerticalGroup(
            phong16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLoaiPhong16)
                    .addComponent(checkBoxPhong6))
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
                        .addComponent(checkBoxPhong8))
                    .addComponent(lblTrangThai22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phong22Layout.setVerticalGroup(
            phong22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong22Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLoaiPhong22)
                    .addComponent(checkBoxPhong8))
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phong23Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(phong23Layout.createSequentialGroup()
                        .addComponent(lblLoaiPhong23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(checkBoxPhong9))
                    .addComponent(lblTrangThai23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(lblTenPhong23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        phong23Layout.setVerticalGroup(
            phong23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong23Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLoaiPhong23)
                    .addComponent(checkBoxPhong9))
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
                        .addComponent(checkBoxPhong10))
                    .addComponent(lblTrangThai29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phong29Layout.setVerticalGroup(
            phong29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong29Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLoaiPhong29)
                    .addComponent(checkBoxPhong10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTenPhong29, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTrangThai29)
                .addContainerGap())
        );

        phong30.setBackground(new java.awt.Color(255, 255, 153));

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
                        .addComponent(checkBoxPhong7))
                    .addComponent(lblTrangThai30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(lblTenPhong30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        phong30Layout.setVerticalGroup(
            phong30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong30Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(checkBoxPhong7)
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
                        .addComponent(checkBoxPhong11))
                    .addComponent(lblTrangThai43, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phong43Layout.setVerticalGroup(
            phong43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong43Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLoaiPhong43)
                    .addComponent(checkBoxPhong11))
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
                .addGap(40, 40, 40)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(phong7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(phong30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(phong22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(phong8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(phong12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(phong15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(phong16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addComponent(phong23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(phong29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(phong43, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(66, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(phong7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phong16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(phong15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(phong8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(phong12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(phong43, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(phong29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(phong23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(phong22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(phong30, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout Tang2_QuanLyPhongLayout = new javax.swing.GroupLayout(Tang2_QuanLyPhong);
        Tang2_QuanLyPhong.setLayout(Tang2_QuanLyPhongLayout);
        Tang2_QuanLyPhongLayout.setHorizontalGroup(
            Tang2_QuanLyPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Tang2_QuanLyPhongLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        Tang2_QuanLyPhongLayout.setVerticalGroup(
            Tang2_QuanLyPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Tang2_QuanLyPhongLayout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Tang1_QuanLyPhong.setBackground(new java.awt.Color(255, 255, 255));
        Tang1_QuanLyPhong.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Tầng 1", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N

        phong44.setBackground(new java.awt.Color(255, 255, 153));

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
                        .addComponent(checkBoxPhong12))
                    .addComponent(lblTrangThai44, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(lblTenPhong44, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        phong44Layout.setVerticalGroup(
            phong44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong44Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(checkBoxPhong12)
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
                        .addComponent(checkBoxPhong13))
                    .addComponent(lblTrangThai45, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phong45Layout.setVerticalGroup(
            phong45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong45Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLoaiPhong45)
                    .addComponent(checkBoxPhong13))
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
                        .addComponent(checkBoxPhong14))
                    .addComponent(lblTrangThai46, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phong46Layout.setVerticalGroup(
            phong46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong46Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLoaiPhong46)
                    .addComponent(checkBoxPhong14))
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
                        .addComponent(checkBoxPhong15))
                    .addComponent(lblTrangThai47, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phong47Layout.setVerticalGroup(
            phong47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong47Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLoaiPhong47)
                    .addComponent(checkBoxPhong15))
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
                        .addComponent(checkBoxPhong16))
                    .addComponent(lblTrangThai51, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phong51Layout.setVerticalGroup(
            phong51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong51Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLoaiPhong51)
                    .addComponent(checkBoxPhong16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTenPhong51, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTrangThai51)
                .addContainerGap())
        );

        phong52.setBackground(new java.awt.Color(255, 255, 153));

        lblTenPhong52.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTenPhong52.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhong52.setText("102NC");

        lblLoaiPhong52.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblLoaiPhong52.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhong52.setText("Nâng cao");

        lblTrangThai52.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTrangThai52.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThai52.setText("Đang trống");

        javax.swing.GroupLayout phong52Layout = new javax.swing.GroupLayout(phong52);
        phong52.setLayout(phong52Layout);
        phong52Layout.setHorizontalGroup(
            phong52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTenPhong52, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phong52Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(phong52Layout.createSequentialGroup()
                        .addComponent(lblLoaiPhong52, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(checkBoxPhong22))
                    .addComponent(lblTrangThai52, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phong52Layout.setVerticalGroup(
            phong52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong52Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLoaiPhong52)
                    .addComponent(checkBoxPhong22))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTenPhong52, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTrangThai52)
                .addContainerGap())
        );

        phong53.setBackground(new java.awt.Color(255, 255, 153));

        lblTenPhong53.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTenPhong53.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhong53.setText("103CC");

        lblLoaiPhong53.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblLoaiPhong53.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhong53.setText("Cao cấp");

        lblTrangThai53.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTrangThai53.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThai53.setText("Đã đặt");

        javax.swing.GroupLayout phong53Layout = new javax.swing.GroupLayout(phong53);
        phong53.setLayout(phong53Layout);
        phong53Layout.setHorizontalGroup(
            phong53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTenPhong53, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phong53Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(phong53Layout.createSequentialGroup()
                        .addComponent(lblLoaiPhong53, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(checkBoxPhong23))
                    .addComponent(lblTrangThai53, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phong53Layout.setVerticalGroup(
            phong53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong53Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLoaiPhong53)
                    .addComponent(checkBoxPhong23))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTenPhong53, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTrangThai53)
                .addContainerGap())
        );

        phong54.setBackground(new java.awt.Color(255, 255, 153));

        lblTenPhong54.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTenPhong54.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhong54.setText("109TC");

        lblLoaiPhong54.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblLoaiPhong54.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhong54.setText("Thương gia");

        lblTrangThai54.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTrangThai54.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThai54.setText("Đang thuê");

        javax.swing.GroupLayout phong54Layout = new javax.swing.GroupLayout(phong54);
        phong54.setLayout(phong54Layout);
        phong54Layout.setHorizontalGroup(
            phong54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTenPhong54, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phong54Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(phong54Layout.createSequentialGroup()
                        .addComponent(lblLoaiPhong54, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(checkBoxPhong29))
                    .addComponent(lblTrangThai54, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phong54Layout.setVerticalGroup(
            phong54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong54Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLoaiPhong54)
                    .addComponent(checkBoxPhong29))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTenPhong54, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTrangThai54)
                .addContainerGap())
        );

        phong55.setBackground(new java.awt.Color(255, 255, 153));

        lblTenPhong55.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTenPhong55.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhong55.setText("101TC");

        lblLoaiPhong55.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblLoaiPhong55.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhong55.setText("Tiêu chuẩn");

        lblTrangThai55.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTrangThai55.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThai55.setText("Đang thuê");

        javax.swing.GroupLayout phong55Layout = new javax.swing.GroupLayout(phong55);
        phong55.setLayout(phong55Layout);
        phong55Layout.setHorizontalGroup(
            phong55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phong55Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(phong55Layout.createSequentialGroup()
                        .addComponent(lblLoaiPhong55, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(checkBoxPhong30))
                    .addComponent(lblTrangThai55, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(lblTenPhong55, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        phong55Layout.setVerticalGroup(
            phong55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong55Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(checkBoxPhong30)
                    .addComponent(lblLoaiPhong55))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTenPhong55, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTrangThai55)
                .addContainerGap())
        );

        phong56.setBackground(new java.awt.Color(255, 255, 153));

        lblTenPhong56.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTenPhong56.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhong56.setText("102TC");

        lblLoaiPhong56.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblLoaiPhong56.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhong56.setText("Tiêu chuẩn");

        lblTrangThai56.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTrangThai56.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThai56.setText("Trạng thái");

        javax.swing.GroupLayout phong56Layout = new javax.swing.GroupLayout(phong56);
        phong56.setLayout(phong56Layout);
        phong56Layout.setHorizontalGroup(
            phong56Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTenPhong56, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phong56Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong56Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(phong56Layout.createSequentialGroup()
                        .addComponent(lblLoaiPhong56, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(checkBoxPhong43))
                    .addComponent(lblTrangThai56, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phong56Layout.setVerticalGroup(
            phong56Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong56Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong56Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLoaiPhong56)
                    .addComponent(checkBoxPhong43))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTenPhong56, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTrangThai56)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(phong44, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phong55, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(phong45, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(phong46, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(phong47, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(phong51, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(phong52, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(phong53, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(phong54, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(phong56, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(66, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(phong44, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phong51, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(phong47, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(phong45, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(phong46, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(phong56, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(phong54, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(phong53, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(phong52, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(phong55, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(27, 27, 27))
        );

        javax.swing.GroupLayout Tang1_QuanLyPhongLayout = new javax.swing.GroupLayout(Tang1_QuanLyPhong);
        Tang1_QuanLyPhong.setLayout(Tang1_QuanLyPhongLayout);
        Tang1_QuanLyPhongLayout.setHorizontalGroup(
            Tang1_QuanLyPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Tang1_QuanLyPhongLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        Tang1_QuanLyPhongLayout.setVerticalGroup(
            Tang1_QuanLyPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Tang1_QuanLyPhongLayout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Tang4_QuanLyPhong.setBackground(new java.awt.Color(255, 255, 255));
        Tang4_QuanLyPhong.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Tầng 4", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N

        phong57.setBackground(new java.awt.Color(255, 255, 153));

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
                        .addComponent(checkBoxPhong44))
                    .addComponent(lblTrangThai57, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(lblTenPhong57, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        phong57Layout.setVerticalGroup(
            phong57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong57Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(checkBoxPhong44)
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
                        .addComponent(checkBoxPhong45))
                    .addComponent(lblTrangThai58, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phong58Layout.setVerticalGroup(
            phong58Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong58Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong58Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLoaiPhong58)
                    .addComponent(checkBoxPhong45))
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
                        .addComponent(checkBoxPhong46))
                    .addComponent(lblTrangThai59, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phong59Layout.setVerticalGroup(
            phong59Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong59Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong59Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLoaiPhong59)
                    .addComponent(checkBoxPhong46))
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
                        .addComponent(checkBoxPhong47))
                    .addComponent(lblTrangThai60, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phong60Layout.setVerticalGroup(
            phong60Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong60Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong60Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLoaiPhong60)
                    .addComponent(checkBoxPhong47))
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
                        .addComponent(checkBoxPhong51))
                    .addComponent(lblTrangThai61, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phong61Layout.setVerticalGroup(
            phong61Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong61Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong61Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLoaiPhong61)
                    .addComponent(checkBoxPhong51))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTenPhong61, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTrangThai61)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(phong57, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(phong58, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(phong59, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(phong60, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(phong61, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(60, Short.MAX_VALUE))
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
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout Tang4_QuanLyPhongLayout = new javax.swing.GroupLayout(Tang4_QuanLyPhong);
        Tang4_QuanLyPhong.setLayout(Tang4_QuanLyPhongLayout);
        Tang4_QuanLyPhongLayout.setHorizontalGroup(
            Tang4_QuanLyPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Tang4_QuanLyPhongLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        Tang4_QuanLyPhongLayout.setVerticalGroup(
            Tang4_QuanLyPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Tang4_QuanLyPhongLayout.createSequentialGroup()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Tang3_QuanLyPhong.setBackground(new java.awt.Color(255, 255, 255));
        Tang3_QuanLyPhong.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Tầng 3", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N

        phong62.setBackground(new java.awt.Color(255, 255, 153));

        lblTenPhong62.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTenPhong62.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhong62.setText("101TC");

        lblLoaiPhong62.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblLoaiPhong62.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhong62.setText("Tiêu chuẩn");

        lblTrangThai62.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTrangThai62.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThai62.setText("Đang thuê");

        javax.swing.GroupLayout phong62Layout = new javax.swing.GroupLayout(phong62);
        phong62.setLayout(phong62Layout);
        phong62Layout.setHorizontalGroup(
            phong62Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phong62Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong62Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(phong62Layout.createSequentialGroup()
                        .addComponent(lblLoaiPhong62, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(checkBoxPhong57))
                    .addComponent(lblTrangThai62, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(lblTenPhong62, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        phong62Layout.setVerticalGroup(
            phong62Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong62Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong62Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(checkBoxPhong57)
                    .addComponent(lblLoaiPhong62))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTenPhong62, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTrangThai62)
                .addContainerGap())
        );

        phong63.setBackground(new java.awt.Color(255, 255, 153));

        lblTenPhong63.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTenPhong63.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhong63.setText("102NC");

        lblLoaiPhong63.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblLoaiPhong63.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhong63.setText("Nâng cao");

        lblTrangThai63.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTrangThai63.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThai63.setText("Đang trống");

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
                        .addComponent(checkBoxPhong58))
                    .addComponent(lblTrangThai63, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phong63Layout.setVerticalGroup(
            phong63Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong63Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong63Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLoaiPhong63)
                    .addComponent(checkBoxPhong58))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTenPhong63, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTrangThai63, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        phong64.setBackground(new java.awt.Color(255, 255, 153));

        lblTenPhong64.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTenPhong64.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhong64.setText("103CC");

        lblLoaiPhong64.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblLoaiPhong64.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhong64.setText("Cao cấp");

        lblTrangThai64.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTrangThai64.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThai64.setText("Đã đặt");

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
                        .addComponent(checkBoxPhong59))
                    .addComponent(lblTrangThai64, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phong64Layout.setVerticalGroup(
            phong64Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong64Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong64Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLoaiPhong64)
                    .addComponent(checkBoxPhong59))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTenPhong64, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTrangThai64)
                .addContainerGap())
        );

        phong65.setBackground(new java.awt.Color(255, 255, 153));

        lblTenPhong65.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTenPhong65.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhong65.setText("109TC");

        lblLoaiPhong65.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblLoaiPhong65.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhong65.setText("Thương gia");

        lblTrangThai65.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTrangThai65.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThai65.setText("Đang thuê");

        javax.swing.GroupLayout phong65Layout = new javax.swing.GroupLayout(phong65);
        phong65.setLayout(phong65Layout);
        phong65Layout.setHorizontalGroup(
            phong65Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTenPhong65, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phong65Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong65Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(phong65Layout.createSequentialGroup()
                        .addComponent(lblLoaiPhong65, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(checkBoxPhong60))
                    .addComponent(lblTrangThai65, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phong65Layout.setVerticalGroup(
            phong65Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong65Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong65Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLoaiPhong65)
                    .addComponent(checkBoxPhong60))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                        .addComponent(checkBoxPhong61))
                    .addComponent(lblTrangThai66, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phong66Layout.setVerticalGroup(
            phong66Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong66Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong66Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLoaiPhong66)
                    .addComponent(checkBoxPhong61))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTenPhong66, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTrangThai66)
                .addContainerGap())
        );

        phong67.setBackground(new java.awt.Color(255, 255, 153));

        lblTenPhong67.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTenPhong67.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhong67.setText("102NC");

        lblLoaiPhong67.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblLoaiPhong67.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhong67.setText("Nâng cao");

        lblTrangThai67.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTrangThai67.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThai67.setText("Đang trống");

        javax.swing.GroupLayout phong67Layout = new javax.swing.GroupLayout(phong67);
        phong67.setLayout(phong67Layout);
        phong67Layout.setHorizontalGroup(
            phong67Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTenPhong67, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phong67Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong67Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(phong67Layout.createSequentialGroup()
                        .addComponent(lblLoaiPhong67, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(checkBoxPhong62))
                    .addComponent(lblTrangThai67, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phong67Layout.setVerticalGroup(
            phong67Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong67Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong67Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLoaiPhong67)
                    .addComponent(checkBoxPhong62))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTenPhong67, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTrangThai67)
                .addContainerGap())
        );

        phong68.setBackground(new java.awt.Color(255, 255, 153));

        lblTenPhong68.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTenPhong68.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhong68.setText("103CC");

        lblLoaiPhong68.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblLoaiPhong68.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhong68.setText("Cao cấp");

        lblTrangThai68.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTrangThai68.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThai68.setText("Đã đặt");

        javax.swing.GroupLayout phong68Layout = new javax.swing.GroupLayout(phong68);
        phong68.setLayout(phong68Layout);
        phong68Layout.setHorizontalGroup(
            phong68Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTenPhong68, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phong68Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong68Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(phong68Layout.createSequentialGroup()
                        .addComponent(lblLoaiPhong68, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(checkBoxPhong63))
                    .addComponent(lblTrangThai68, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phong68Layout.setVerticalGroup(
            phong68Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong68Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong68Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLoaiPhong68)
                    .addComponent(checkBoxPhong63))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTenPhong68, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTrangThai68)
                .addContainerGap())
        );

        phong69.setBackground(new java.awt.Color(255, 255, 153));

        lblTenPhong69.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTenPhong69.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhong69.setText("109TC");

        lblLoaiPhong69.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblLoaiPhong69.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhong69.setText("Thương gia");

        lblTrangThai69.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTrangThai69.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThai69.setText("Đang thuê");

        javax.swing.GroupLayout phong69Layout = new javax.swing.GroupLayout(phong69);
        phong69.setLayout(phong69Layout);
        phong69Layout.setHorizontalGroup(
            phong69Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTenPhong69, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phong69Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong69Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(phong69Layout.createSequentialGroup()
                        .addComponent(lblLoaiPhong69, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(checkBoxPhong64))
                    .addComponent(lblTrangThai69, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phong69Layout.setVerticalGroup(
            phong69Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong69Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong69Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLoaiPhong69)
                    .addComponent(checkBoxPhong64))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTenPhong69, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTrangThai69)
                .addContainerGap())
        );

        phong70.setBackground(new java.awt.Color(255, 255, 153));

        lblTenPhong70.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTenPhong70.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhong70.setText("101TC");

        lblLoaiPhong70.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblLoaiPhong70.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhong70.setText("Tiêu chuẩn");

        lblTrangThai70.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTrangThai70.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThai70.setText("Đang thuê");

        javax.swing.GroupLayout phong70Layout = new javax.swing.GroupLayout(phong70);
        phong70.setLayout(phong70Layout);
        phong70Layout.setHorizontalGroup(
            phong70Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phong70Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong70Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(phong70Layout.createSequentialGroup()
                        .addComponent(lblLoaiPhong70, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(checkBoxPhong65))
                    .addComponent(lblTrangThai70, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(lblTenPhong70, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        phong70Layout.setVerticalGroup(
            phong70Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong70Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong70Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(checkBoxPhong65)
                    .addComponent(lblLoaiPhong70))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTenPhong70, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTrangThai70)
                .addContainerGap())
        );

        phong71.setBackground(new java.awt.Color(255, 255, 153));

        lblTenPhong71.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTenPhong71.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTenPhong71.setText("102TC");

        lblLoaiPhong71.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblLoaiPhong71.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblLoaiPhong71.setText("Tiêu chuẩn");

        lblTrangThai71.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTrangThai71.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrangThai71.setText("Trạng thái");

        javax.swing.GroupLayout phong71Layout = new javax.swing.GroupLayout(phong71);
        phong71.setLayout(phong71Layout);
        phong71Layout.setHorizontalGroup(
            phong71Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTenPhong71, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, phong71Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong71Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(phong71Layout.createSequentialGroup()
                        .addComponent(lblLoaiPhong71, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(checkBoxPhong66))
                    .addComponent(lblTrangThai71, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        phong71Layout.setVerticalGroup(
            phong71Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(phong71Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(phong71Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLoaiPhong71)
                    .addComponent(checkBoxPhong66))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTenPhong71, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTrangThai71)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(phong62, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(phong70, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(phong67, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(phong68, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(phong69, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(phong71, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(phong63, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(phong64, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(phong65, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(phong66, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(60, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(phong62, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phong66, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(phong65, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(phong63, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(phong64, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(phong71, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(phong69, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(phong68, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(phong67, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(phong70, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout Tang3_QuanLyPhongLayout = new javax.swing.GroupLayout(Tang3_QuanLyPhong);
        Tang3_QuanLyPhong.setLayout(Tang3_QuanLyPhongLayout);
        Tang3_QuanLyPhongLayout.setHorizontalGroup(
            Tang3_QuanLyPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Tang3_QuanLyPhongLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        Tang3_QuanLyPhongLayout.setVerticalGroup(
            Tang3_QuanLyPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Tang3_QuanLyPhongLayout.createSequentialGroup()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnBody2Layout = new javax.swing.GroupLayout(pnBody2);
        pnBody2.setLayout(pnBody2Layout);
        pnBody2Layout.setHorizontalGroup(
            pnBody2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnBody2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(pnBody2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Tang1_QuanLyPhong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Tang2_QuanLyPhong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Tang3_QuanLyPhong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Tang4_QuanLyPhong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnBody2Layout.setVerticalGroup(
            pnBody2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnBody2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(Tang1_QuanLyPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Tang2_QuanLyPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Tang3_QuanLyPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addComponent(Tang4_QuanLyPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        ScrollPaneQuanLyPhong.setViewportView(pnBody2);

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
                    .addComponent(ScrollPaneQuanLyPhong, javax.swing.GroupLayout.DEFAULT_SIZE, 1253, Short.MAX_VALUE))
                .addContainerGap(54, Short.MAX_VALUE))
        );
        pnQuanLyPhongLayout.setVerticalGroup(
            pnQuanLyPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnQuanLyPhongLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(funtionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ScrollPaneQuanLyPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 431, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(131, Short.MAX_VALUE))
        );

        pnedUngDung.addTab("tab2", pnQuanLyPhong);

        pnLayOutNhanVien.setBackground(new java.awt.Color(255, 204, 204));
        pnLayOutNhanVien.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Quản lý nhân viên", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 24))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Mã nhân viên");
        jLabel3.setToolTipText("");
        jLabel3.setPreferredSize(new java.awt.Dimension(120, 21));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Giới tính");
        jLabel4.setToolTipText("");
        jLabel4.setPreferredSize(new java.awt.Dimension(120, 21));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Ngày vào làm");
        jLabel5.setToolTipText("");
        jLabel5.setPreferredSize(new java.awt.Dimension(120, 21));

        txtMaNhanVien.setText("Mã nhân viên");

        txtNgayVaoLamNhanVien.setText("Ngày vào làm");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Họ tên nhân viên");
        jLabel7.setToolTipText("");
        jLabel7.setPreferredSize(new java.awt.Dimension(120, 21));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Số điện thoại");
        jLabel8.setToolTipText("");
        jLabel8.setPreferredSize(new java.awt.Dimension(120, 21));

        txtHoTenNhanVien.setText("Họ tên nhân viên");

        txtSoDienThoaiNhanVien.setText("Số điện thoại nhân viên");

        txtNgaySinhNhanVien.setText("Ngày sinh nhân viên");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel13.setText("Ngày sinh");
        jLabel13.setToolTipText("");
        jLabel13.setPreferredSize(new java.awt.Dimension(120, 21));

        txtCanCuocCongDanNhanVien.setText("Căn cước công dân");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel14.setText("CCCD");
        jLabel14.setToolTipText("");
        jLabel14.setPreferredSize(new java.awt.Dimension(120, 21));

        btnNgaySinhNhanVien.setBorder(null);
        btnNgaySinhNhanVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgLogin/calendar.png"))); // NOI18N
        btnNgaySinhNhanVien.setBorderColor(new java.awt.Color(255, 255, 255));
        btnNgaySinhNhanVien.setColorOver(new java.awt.Color(204, 204, 204));
        btnNgaySinhNhanVien.setRadius(20);
        btnNgaySinhNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNgaySinhNhanVienActionPerformed(evt);
            }
        });

        btnNgayVaoLamNhanVien.setBorder(null);
        btnNgayVaoLamNhanVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgLogin/calendar.png"))); // NOI18N
        btnNgayVaoLamNhanVien.setBorderColor(new java.awt.Color(255, 255, 255));
        btnNgayVaoLamNhanVien.setColorOver(new java.awt.Color(204, 204, 204));
        btnNgayVaoLamNhanVien.setRadius(20);
        btnNgayVaoLamNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNgayVaoLamNhanVienActionPerformed(evt);
            }
        });

        cbxGioiTinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ", "Khác", " " }));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Chức vụ");
        jLabel9.setToolTipText("");
        jLabel9.setPreferredSize(new java.awt.Dimension(120, 21));

        cbxChucVuNhanVien.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nhân viên lễ tân", "Nhân viên quản lý", " " }));

        btnCapNhapNhanVien.setText("Cập nhập nhân viên");

        btnTamChoNghiNhanVien.setText("Tạm cho nghỉ");

        btnThemNhanVien.setText("Thêm nhân viên");

        btnXoaTrangNhanVien.setText("Xóa trắng");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel15.setText("Email");
        jLabel15.setToolTipText("");
        jLabel15.setPreferredSize(new java.awt.Dimension(120, 21));

        txtEmailNhanVien1.setText("Email nhân viên");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(txtNgayVaoLamNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnNgayVaoLamNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtMaNhanVien, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbxGioiTinh, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(76, 76, 76)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtHoTenNhanVien)
                            .addComponent(txtSoDienThoaiNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                            .addComponent(cbxChucVuNhanVien, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(75, 75, 75)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel12Layout.createSequentialGroup()
                                .addComponent(txtNgaySinhNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnNgaySinhNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtCanCuocCongDanNhanVien, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtEmailNhanVien1, javax.swing.GroupLayout.Alignment.LEADING)))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnXoaTrangNhanVien)
                        .addGap(18, 18, 18)
                        .addComponent(btnThemNhanVien)
                        .addGap(18, 18, 18)
                        .addComponent(btnCapNhapNhanVien)
                        .addGap(18, 18, 18)
                        .addComponent(btnTamChoNghiNhanVien)))
                .addGap(65, 65, 65))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnNgaySinhNhanVien, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNgaySinhNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtHoTenNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSoDienThoaiNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCanCuocCongDanNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxChucVuNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEmailNhanVien1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMaNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtNgayVaoLamNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnNgayVaoLamNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 19, Short.MAX_VALUE)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTamChoNghiNhanVien)
                    .addComponent(btnCapNhapNhanVien)
                    .addComponent(btnThemNhanVien)
                    .addComponent(btnXoaTrangNhanVien))
                .addGap(21, 21, 21))
        );

        TableNhanVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã nhân viên", "Họ tên nhân viên", "Ngày sinh", "Giới tính", "Số điện thoại", "Địa chỉ", "Ngày vào làm", "Chức vụ"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, true, true, true, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(TableNhanVien);

        javax.swing.GroupLayout pnLayOutNhanVienLayout = new javax.swing.GroupLayout(pnLayOutNhanVien);
        pnLayOutNhanVien.setLayout(pnLayOutNhanVienLayout);
        pnLayOutNhanVienLayout.setHorizontalGroup(
            pnLayOutNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnLayOutNhanVienLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnLayOutNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3))
                .addContainerGap())
        );
        pnLayOutNhanVienLayout.setVerticalGroup(
            pnLayOutNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnLayOutNhanVienLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 437, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout pnNhanVienLayout = new javax.swing.GroupLayout(pnNhanVien);
        pnNhanVien.setLayout(pnNhanVienLayout);
        pnNhanVienLayout.setHorizontalGroup(
            pnNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnNhanVienLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnLayOutNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(51, Short.MAX_VALUE))
        );
        pnNhanVienLayout.setVerticalGroup(
            pnNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnNhanVienLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnLayOutNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(112, Short.MAX_VALUE))
        );

        pnedUngDung.addTab("tab3", pnNhanVien);

        pnLayOutDichVu.setBackground(new java.awt.Color(255, 204, 204));
        pnLayOutDichVu.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Quản lý dịch vụ", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 24))); // NOI18N

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Mã dịch vụ");
        jLabel6.setToolTipText("");
        jLabel6.setPreferredSize(new java.awt.Dimension(120, 21));

        txtMaDichVu.setText("Mã dịch vụ");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("Tên dịch vụ");
        jLabel12.setToolTipText("");
        jLabel12.setPreferredSize(new java.awt.Dimension(120, 21));

        txtTenDichVu.setText("Tên dịch vụ");

        txtDonGiaDichVu.setText("Đơn giá dịch vụ");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel16.setText("Đơn giá dịch vụ");
        jLabel16.setToolTipText("");
        jLabel16.setPreferredSize(new java.awt.Dimension(120, 21));

        btnCapNhapDichVu.setText("Cập nhập dịch vụ");

        btnThemDichVu.setText("Thêm dịch vụ");

        jButton13.setText("Xóa trắng");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtMaDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(76, 76, 76)
                        .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTenDichVu, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                        .addGap(75, 75, 75)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDonGiaDichVu, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnThemDichVu)
                        .addGap(18, 18, 18)
                        .addComponent(btnCapNhapDichVu)
                        .addGap(18, 18, 18)
                        .addComponent(jButton13)))
                .addGap(65, 65, 65))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDonGiaDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCapNhapDichVu)
                            .addComponent(btnThemDichVu)))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTenDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jButton13))
                    .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtMaDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        TableDichVu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "STT", "Mã dịch vụ", "Tên dịch vụ", "Đơn giá dịch vụ"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(TableDichVu);

        javax.swing.GroupLayout pnLayOutDichVuLayout = new javax.swing.GroupLayout(pnLayOutDichVu);
        pnLayOutDichVu.setLayout(pnLayOutDichVuLayout);
        pnLayOutDichVuLayout.setHorizontalGroup(
            pnLayOutDichVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnLayOutDichVuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnLayOutDichVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane4))
                .addContainerGap())
        );
        pnLayOutDichVuLayout.setVerticalGroup(
            pnLayOutDichVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnLayOutDichVuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 437, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout pnDichVuLayout = new javax.swing.GroupLayout(pnDichVu);
        pnDichVu.setLayout(pnDichVuLayout);
        pnDichVuLayout.setHorizontalGroup(
            pnDichVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnDichVuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnLayOutDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(51, Short.MAX_VALUE))
        );
        pnDichVuLayout.setVerticalGroup(
            pnDichVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnDichVuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnLayOutDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(193, Short.MAX_VALUE))
        );

        pnedUngDung.addTab("tab4", pnDichVu);

        pnLayOutKhuyenMai.setBackground(new java.awt.Color(255, 204, 204));
        pnLayOutKhuyenMai.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Quản lý Khuyến Mãi", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 24))); // NOI18N

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel19.setText("Mã khuyến mãi");
        jLabel19.setToolTipText("");
        jLabel19.setPreferredSize(new java.awt.Dimension(120, 21));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel20.setText("Thơi gian bắt đầu");
        jLabel20.setToolTipText("");
        jLabel20.setPreferredSize(new java.awt.Dimension(120, 21));

        txtMaKhuyenMai.setText("Mã khuyến mãi");

        txtNgayBatDauKhuyenMai.setText("Bắt đầu khuyến mãi");

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel22.setText("Tên khuyến mãi");
        jLabel22.setToolTipText("");
        jLabel22.setPreferredSize(new java.awt.Dimension(120, 21));

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel23.setText("Thời gian kết thúc");
        jLabel23.setToolTipText("");
        jLabel23.setPreferredSize(new java.awt.Dimension(120, 21));

        txtTenKhuyenMai.setText("Tên khuyến mãi");

        txtNgayKetThucKhuyenMai.setText("Kết thúc khuyến mãi");

        txtGiaTriKhuyenMai.setText("Giá trị khuyến mãi");

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel24.setText("Giá trị khuyễn mãi");
        jLabel24.setToolTipText("");
        jLabel24.setPreferredSize(new java.awt.Dimension(120, 21));

        jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel25.setText("Điều kiện áp dụng");
        jLabel25.setToolTipText("");
        jLabel25.setPreferredSize(new java.awt.Dimension(120, 21));

        btnThoiGianKetThucKhuyenMai.setBorder(null);
        btnThoiGianKetThucKhuyenMai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgLogin/calendar.png"))); // NOI18N
        btnThoiGianKetThucKhuyenMai.setBorderColor(new java.awt.Color(255, 255, 255));
        btnThoiGianKetThucKhuyenMai.setColorOver(new java.awt.Color(204, 204, 204));
        btnThoiGianKetThucKhuyenMai.setRadius(20);
        btnThoiGianKetThucKhuyenMai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoiGianKetThucKhuyenMaiActionPerformed(evt);
            }
        });

        btnThoiGianBatDauKhuyenMai.setBorder(null);
        btnThoiGianBatDauKhuyenMai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgLogin/calendar.png"))); // NOI18N
        btnThoiGianBatDauKhuyenMai.setBorderColor(new java.awt.Color(255, 255, 255));
        btnThoiGianBatDauKhuyenMai.setColorOver(new java.awt.Color(204, 204, 204));
        btnThoiGianBatDauKhuyenMai.setRadius(20);
        btnThoiGianBatDauKhuyenMai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoiGianBatDauKhuyenMaiActionPerformed(evt);
            }
        });

        btnCapNhapKhuyenMai.setText("Cập nhập khuyến mãi");

        btnNgungKhuyenMai.setText("Cho ngừng khuyễn mãi");

        btnThemKhuyenMai.setText("Thêm khuyến mãi");

        btnXoaTrangKhuyenMai.setText("Xóa trắng");

        cbxDieuKienApDungKhuyenMai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Khách hàng hạng Vàng", "Khách hàng hạng Đồng", "Khách hàng hạng Kim Cương", "Loại phòng thương gia", "Loại phòng tiêu chuẩn", "Tổng hóa đơn trên 500.000VNĐ" }));

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                            .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addComponent(txtNgayBatDauKhuyenMai, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnThoiGianBatDauKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtMaKhuyenMai, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(70, 70, 70)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                            .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addComponent(txtNgayKetThucKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnThoiGianKetThucKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtTenKhuyenMai))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                            .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtGiaTriKhuyenMai)
                            .addComponent(cbxDieuKienApDungKhuyenMai, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnXoaTrangKhuyenMai)
                        .addGap(18, 18, 18)
                        .addComponent(btnThemKhuyenMai)
                        .addGap(18, 18, 18)
                        .addComponent(btnCapNhapKhuyenMai)
                        .addGap(18, 18, 18)
                        .addComponent(btnNgungKhuyenMai)))
                .addGap(65, 65, 65))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTenKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtNgayKetThucKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnThoiGianKetThucKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtGiaTriKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxDieuKienApDungKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMaKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnThoiGianBatDauKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtNgayBatDauKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 14, Short.MAX_VALUE)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNgungKhuyenMai)
                    .addComponent(btnCapNhapKhuyenMai)
                    .addComponent(btnThemKhuyenMai)
                    .addComponent(btnXoaTrangKhuyenMai))
                .addGap(21, 21, 21))
        );

        TableKhuyenMai.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã khuyến mãi", "Tên khuyến mãi", "Giá trị khuyến mãi", "Thời gian bắt đầu", "Thời gian kết thúc", "Điều kiện áp dụng", "Nhân viên tạo khuyến mãi"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(TableKhuyenMai);

        javax.swing.GroupLayout pnLayOutKhuyenMaiLayout = new javax.swing.GroupLayout(pnLayOutKhuyenMai);
        pnLayOutKhuyenMai.setLayout(pnLayOutKhuyenMaiLayout);
        pnLayOutKhuyenMaiLayout.setHorizontalGroup(
            pnLayOutKhuyenMaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnLayOutKhuyenMaiLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnLayOutKhuyenMaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane5))
                .addContainerGap())
        );
        pnLayOutKhuyenMaiLayout.setVerticalGroup(
            pnLayOutKhuyenMaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnLayOutKhuyenMaiLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 437, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout pnKhuyenMaiLayout = new javax.swing.GroupLayout(pnKhuyenMai);
        pnKhuyenMai.setLayout(pnKhuyenMaiLayout);
        pnKhuyenMaiLayout.setHorizontalGroup(
            pnKhuyenMaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnKhuyenMaiLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnLayOutKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );
        pnKhuyenMaiLayout.setVerticalGroup(
            pnKhuyenMaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnKhuyenMaiLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnLayOutKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(155, Short.MAX_VALUE))
        );

        pnedUngDung.addTab("tab5", pnKhuyenMai);

        pnLayOutKhachKhachHang.setBackground(new java.awt.Color(255, 204, 204));
        pnLayOutKhachKhachHang.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Quản lý khách hàng", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 24))); // NOI18N

        jLabel27.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel27.setText("Mã khách hàng");
        jLabel27.setToolTipText("");
        jLabel27.setPreferredSize(new java.awt.Dimension(120, 21));

        jLabel28.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel28.setText("Giới tính");
        jLabel28.setToolTipText("");
        jLabel28.setPreferredSize(new java.awt.Dimension(120, 21));

        jLabel29.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel29.setText("Chi tiêu");
        jLabel29.setToolTipText("");
        jLabel29.setPreferredSize(new java.awt.Dimension(120, 21));

        txtMaKhachHang.setText("Mã khách hàng");

        txtChiTieuKhachHang.setText("5000000");

        jLabel30.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel30.setText("Tên khách hàng");
        jLabel30.setToolTipText("");
        jLabel30.setPreferredSize(new java.awt.Dimension(120, 21));

        jLabel31.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel31.setText("Số điện thoại");
        jLabel31.setToolTipText("");
        jLabel31.setPreferredSize(new java.awt.Dimension(120, 21));

        txtTenKhachHang.setText("Tên khách hàng");

        txtSoDienThoaiKhachHang.setText("Số điện thoại khách hàng");
        txtSoDienThoaiKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSoDienThoaiKhachHangActionPerformed(evt);
            }
        });

        txtNgaySinhKhachHang.setText("Ngày sinh  khách hàng");

        jLabel32.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel32.setText("Ngày sinh");
        jLabel32.setToolTipText("");
        jLabel32.setPreferredSize(new java.awt.Dimension(120, 21));

        txtCanCuocKhachHang.setText("Căn cước khách hàng");

        jLabel33.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel33.setText("CCCD/VISA");
        jLabel33.setToolTipText("");
        jLabel33.setPreferredSize(new java.awt.Dimension(120, 21));

        btnNgaySinhNhanVien3.setBorder(null);
        btnNgaySinhNhanVien3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgLogin/calendar.png"))); // NOI18N
        btnNgaySinhNhanVien3.setBorderColor(new java.awt.Color(255, 255, 255));
        btnNgaySinhNhanVien3.setColorOver(new java.awt.Color(204, 204, 204));
        btnNgaySinhNhanVien3.setRadius(20);
        btnNgaySinhNhanVien3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNgaySinhNhanVien3ActionPerformed(evt);
            }
        });

        cbxHangThanhVienKhachHang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Vàng", "Bạc", "Kim Cương", " " }));

        jLabel34.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel34.setText("Hạng thành viên");
        jLabel34.setToolTipText("");
        jLabel34.setPreferredSize(new java.awt.Dimension(120, 21));

        cbxGioiTinhKhachHang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nhân viên lễ tân", "Nhân viên quản lý", " " }));

        btnCapNhapKhachHang.setText("Cập nhập nhân viên");

        btnThemKhachHang.setText("Thêm nhân viên");

        jLabel35.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel35.setText("Quốc tịch");
        jLabel35.setToolTipText("");
        jLabel35.setPreferredSize(new java.awt.Dimension(120, 21));

        txtQuocTichKhachHang.setText("Quốc tịch khách hàng");

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel18Layout.createSequentialGroup()
                                .addGap(59, 59, 59)
                                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                                    .addComponent(jLabel29, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel18Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel34, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtMaKhachHang, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                            .addComponent(cbxHangThanhVienKhachHang, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtChiTieuKhachHang, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(76, 76, 76)
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                            .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTenKhachHang)
                            .addComponent(txtSoDienThoaiKhachHang, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                            .addComponent(cbxGioiTinhKhachHang, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(75, 75, 75)
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel35, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel18Layout.createSequentialGroup()
                                .addComponent(txtNgaySinhKhachHang, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnNgaySinhNhanVien3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtCanCuocKhachHang, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtQuocTichKhachHang, javax.swing.GroupLayout.Alignment.LEADING)))
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnThemKhachHang)
                        .addGap(18, 18, 18)
                        .addComponent(btnCapNhapKhachHang)))
                .addGap(65, 65, 65))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnNgaySinhNhanVien3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtNgaySinhKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCanCuocKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTenKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSoDienThoaiKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbxGioiTinhKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtQuocTichKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMaKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbxHangThanhVienKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtChiTieuKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCapNhapKhachHang)
                    .addComponent(btnThemKhachHang))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        TableKhachHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã khách hàng", "Tên khách hàng", "Giới tính", "Ngày sinh", "Số điện thoại", "CCCD", "Chi tiêu", "Hạng thành viên", "Quốc tịch"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true, true, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane6.setViewportView(TableKhachHang);

        javax.swing.GroupLayout pnLayOutKhachKhachHangLayout = new javax.swing.GroupLayout(pnLayOutKhachKhachHang);
        pnLayOutKhachKhachHang.setLayout(pnLayOutKhachKhachHangLayout);
        pnLayOutKhachKhachHangLayout.setHorizontalGroup(
            pnLayOutKhachKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnLayOutKhachKhachHangLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnLayOutKhachKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane6))
                .addContainerGap())
        );
        pnLayOutKhachKhachHangLayout.setVerticalGroup(
            pnLayOutKhachKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnLayOutKhachKhachHangLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 437, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout pnKhachHangLayout = new javax.swing.GroupLayout(pnKhachHang);
        pnKhachHang.setLayout(pnKhachHangLayout);
        pnKhachHangLayout.setHorizontalGroup(
            pnKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnKhachHangLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnLayOutKhachKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(51, Short.MAX_VALUE))
        );
        pnKhachHangLayout.setVerticalGroup(
            pnKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnKhachHangLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnLayOutKhachKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(112, Short.MAX_VALUE))
        );

        pnedUngDung.addTab("tab6", pnKhachHang);

        jPanel1.add(pnedUngDung, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 40, 1310, 840));

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void radPhongTieuChuanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radPhongTieuChuanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radPhongTieuChuanActionPerformed

    private void radPhongTrongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radPhongTrongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radPhongTrongActionPerformed

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

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void btnNgaySinhNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNgaySinhNhanVienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNgaySinhNhanVienActionPerformed

    private void btnNgayVaoLamNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNgayVaoLamNhanVienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNgayVaoLamNhanVienActionPerformed

    private void btnThoiGianKetThucKhuyenMaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoiGianKetThucKhuyenMaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnThoiGianKetThucKhuyenMaiActionPerformed

    private void btnNgaySinhNhanVien3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNgaySinhNhanVien3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNgaySinhNhanVien3ActionPerformed

    private void btnThoiGianBatDauKhuyenMaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoiGianBatDauKhuyenMaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnThoiGianBatDauKhuyenMaiActionPerformed

    private void txtSoDienThoaiKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSoDienThoaiKhachHangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSoDienThoaiKhachHangActionPerformed

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
            java.util.logging.Logger.getLogger(TrangChu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TrangChu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TrangChu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TrangChu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TrangChu().setVisible(true);
            }
        });
    }
    
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private component.Header Header;
    private menu.Menu Menu;
    private javax.swing.JScrollPane ScrollPaneQuanLyPhong;
    private javax.swing.JScrollPane ScrollPaneTrangChu;
    private javax.swing.JTable TableDichVu;
    private javax.swing.JTable TableKhachHang;
    private javax.swing.JTable TableKhuyenMai;
    private javax.swing.JTable TableNhanVien;
    private javax.swing.JPanel Tang1_QuanLyPhong;
    private javax.swing.JPanel Tang1_TrangChu;
    private javax.swing.JPanel Tang2_QuanLyPhong;
    private javax.swing.JPanel Tang2_TrangChu;
    private javax.swing.JPanel Tang3_QuanLyPhong;
    private javax.swing.JPanel Tang3_TrangChu;
    private javax.swing.JPanel Tang4_QuanLyPhong;
    private javax.swing.JPanel Tang4_TrangChu;
    private javax.swing.JButton btnCapNhapDichVu;
    private javax.swing.JButton btnCapNhapKhachHang;
    private javax.swing.JButton btnCapNhapKhuyenMai;
    private javax.swing.JButton btnCapNhapNhanVien;
    private javax.swing.JButton btnFindbyPhone;
    private javax.swing.ButtonGroup btnGROUPLoaiPhong;
    private javax.swing.ButtonGroup btnGROUPTrangThai;
    private giaodien.CustomClass.Button btnNgaySinhNhanVien;
    private giaodien.CustomClass.Button btnNgaySinhNhanVien3;
    private giaodien.CustomClass.Button btnNgayVaoLamNhanVien;
    private javax.swing.JButton btnNgungKhuyenMai;
    private javax.swing.JButton btnResetTrangThai;
    private javax.swing.JButton btnTamChoNghiNhanVien;
    private javax.swing.JButton btnThemDichVu;
    private javax.swing.JButton btnThemKhachHang;
    private javax.swing.JButton btnThemKhuyenMai;
    private javax.swing.JButton btnThemNhanVien;
    private giaodien.CustomClass.Button btnThoiGianBatDauKhuyenMai;
    private giaodien.CustomClass.Button btnThoiGianKetThucKhuyenMai;
    private javax.swing.JButton btnXoaTrangKhuyenMai;
    private javax.swing.JButton btnXoaTrangNhanVien;
    private javax.swing.JComboBox<String> cbxChucVuNhanVien;
    private javax.swing.JComboBox<String> cbxDieuKienApDungKhuyenMai;
    private javax.swing.JComboBox<String> cbxGioiTinh;
    private javax.swing.JComboBox<String> cbxGioiTinhKhachHang;
    private javax.swing.JComboBox<String> cbxHangThanhVienKhachHang;
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
    private javax.swing.JPanel funtionPanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JLabel lblLoaiPhong10;
    private javax.swing.JLabel lblLoaiPhong11;
    private javax.swing.JLabel lblLoaiPhong12;
    private javax.swing.JLabel lblLoaiPhong13;
    private javax.swing.JLabel lblLoaiPhong14;
    private javax.swing.JLabel lblLoaiPhong15;
    private javax.swing.JLabel lblLoaiPhong16;
    private javax.swing.JLabel lblLoaiPhong17;
    private javax.swing.JLabel lblLoaiPhong18;
    private javax.swing.JLabel lblLoaiPhong19;
    private javax.swing.JLabel lblLoaiPhong2;
    private javax.swing.JLabel lblLoaiPhong20;
    private javax.swing.JLabel lblLoaiPhong21;
    private javax.swing.JLabel lblLoaiPhong22;
    private javax.swing.JLabel lblLoaiPhong23;
    private javax.swing.JLabel lblLoaiPhong24;
    private javax.swing.JLabel lblLoaiPhong25;
    private javax.swing.JLabel lblLoaiPhong26;
    private javax.swing.JLabel lblLoaiPhong27;
    private javax.swing.JLabel lblLoaiPhong28;
    private javax.swing.JLabel lblLoaiPhong29;
    private javax.swing.JLabel lblLoaiPhong3;
    private javax.swing.JLabel lblLoaiPhong30;
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
    private javax.swing.JLabel lblLoaiPhong43;
    private javax.swing.JLabel lblLoaiPhong44;
    private javax.swing.JLabel lblLoaiPhong45;
    private javax.swing.JLabel lblLoaiPhong46;
    private javax.swing.JLabel lblLoaiPhong47;
    private javax.swing.JLabel lblLoaiPhong48;
    private javax.swing.JLabel lblLoaiPhong49;
    private javax.swing.JLabel lblLoaiPhong5;
    private javax.swing.JLabel lblLoaiPhong50;
    private javax.swing.JLabel lblLoaiPhong51;
    private javax.swing.JLabel lblLoaiPhong52;
    private javax.swing.JLabel lblLoaiPhong53;
    private javax.swing.JLabel lblLoaiPhong54;
    private javax.swing.JLabel lblLoaiPhong55;
    private javax.swing.JLabel lblLoaiPhong56;
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
    private javax.swing.JLabel lblLoaiPhong67;
    private javax.swing.JLabel lblLoaiPhong68;
    private javax.swing.JLabel lblLoaiPhong69;
    private javax.swing.JLabel lblLoaiPhong7;
    private javax.swing.JLabel lblLoaiPhong70;
    private javax.swing.JLabel lblLoaiPhong71;
    private javax.swing.JLabel lblLoaiPhong8;
    private javax.swing.JLabel lblLoaiPhong9;
    private javax.swing.JLabel lblMaNhanVien_header;
    private javax.swing.JLabel lblTenPhong10;
    private javax.swing.JLabel lblTenPhong11;
    private javax.swing.JLabel lblTenPhong12;
    private javax.swing.JLabel lblTenPhong13;
    private javax.swing.JLabel lblTenPhong14;
    private javax.swing.JLabel lblTenPhong15;
    private javax.swing.JLabel lblTenPhong16;
    private javax.swing.JLabel lblTenPhong17;
    private javax.swing.JLabel lblTenPhong18;
    private javax.swing.JLabel lblTenPhong19;
    private javax.swing.JLabel lblTenPhong2;
    private javax.swing.JLabel lblTenPhong20;
    private javax.swing.JLabel lblTenPhong21;
    private javax.swing.JLabel lblTenPhong22;
    private javax.swing.JLabel lblTenPhong23;
    private javax.swing.JLabel lblTenPhong24;
    private javax.swing.JLabel lblTenPhong25;
    private javax.swing.JLabel lblTenPhong26;
    private javax.swing.JLabel lblTenPhong27;
    private javax.swing.JLabel lblTenPhong28;
    private javax.swing.JLabel lblTenPhong29;
    private javax.swing.JLabel lblTenPhong3;
    private javax.swing.JLabel lblTenPhong30;
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
    private javax.swing.JLabel lblTenPhong43;
    private javax.swing.JLabel lblTenPhong44;
    private javax.swing.JLabel lblTenPhong45;
    private javax.swing.JLabel lblTenPhong46;
    private javax.swing.JLabel lblTenPhong47;
    private javax.swing.JLabel lblTenPhong48;
    private javax.swing.JLabel lblTenPhong49;
    private javax.swing.JLabel lblTenPhong5;
    private javax.swing.JLabel lblTenPhong50;
    private javax.swing.JLabel lblTenPhong51;
    private javax.swing.JLabel lblTenPhong52;
    private javax.swing.JLabel lblTenPhong53;
    private javax.swing.JLabel lblTenPhong54;
    private javax.swing.JLabel lblTenPhong55;
    private javax.swing.JLabel lblTenPhong56;
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
    private javax.swing.JLabel lblTenPhong67;
    private javax.swing.JLabel lblTenPhong68;
    private javax.swing.JLabel lblTenPhong69;
    private javax.swing.JLabel lblTenPhong7;
    private javax.swing.JLabel lblTenPhong70;
    private javax.swing.JLabel lblTenPhong71;
    private javax.swing.JLabel lblTenPhong8;
    private javax.swing.JLabel lblTenPhong9;
    private javax.swing.JLabel lblTrangThai10;
    private javax.swing.JLabel lblTrangThai11;
    private javax.swing.JLabel lblTrangThai12;
    private javax.swing.JLabel lblTrangThai13;
    private javax.swing.JLabel lblTrangThai14;
    private javax.swing.JLabel lblTrangThai15;
    private javax.swing.JLabel lblTrangThai16;
    private javax.swing.JLabel lblTrangThai17;
    private javax.swing.JLabel lblTrangThai18;
    private javax.swing.JLabel lblTrangThai19;
    private javax.swing.JLabel lblTrangThai2;
    private javax.swing.JLabel lblTrangThai20;
    private javax.swing.JLabel lblTrangThai21;
    private javax.swing.JLabel lblTrangThai22;
    private javax.swing.JLabel lblTrangThai23;
    private javax.swing.JLabel lblTrangThai24;
    private javax.swing.JLabel lblTrangThai25;
    private javax.swing.JLabel lblTrangThai26;
    private javax.swing.JLabel lblTrangThai27;
    private javax.swing.JLabel lblTrangThai28;
    private javax.swing.JLabel lblTrangThai29;
    private javax.swing.JLabel lblTrangThai3;
    private javax.swing.JLabel lblTrangThai30;
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
    private javax.swing.JLabel lblTrangThai43;
    private javax.swing.JLabel lblTrangThai44;
    private javax.swing.JLabel lblTrangThai45;
    private javax.swing.JLabel lblTrangThai46;
    private javax.swing.JLabel lblTrangThai47;
    private javax.swing.JLabel lblTrangThai48;
    private javax.swing.JLabel lblTrangThai49;
    private javax.swing.JLabel lblTrangThai5;
    private javax.swing.JLabel lblTrangThai50;
    private javax.swing.JLabel lblTrangThai51;
    private javax.swing.JLabel lblTrangThai52;
    private javax.swing.JLabel lblTrangThai53;
    private javax.swing.JLabel lblTrangThai54;
    private javax.swing.JLabel lblTrangThai55;
    private javax.swing.JLabel lblTrangThai56;
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
    private javax.swing.JLabel lblTrangThai67;
    private javax.swing.JLabel lblTrangThai68;
    private javax.swing.JLabel lblTrangThai69;
    private javax.swing.JLabel lblTrangThai7;
    private javax.swing.JLabel lblTrangThai70;
    private javax.swing.JLabel lblTrangThai71;
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
    private javax.swing.JPanel phong17;
    private javax.swing.JPanel phong18;
    private javax.swing.JPanel phong19;
    private javax.swing.JPanel phong2;
    private javax.swing.JPanel phong20;
    private javax.swing.JPanel phong21;
    private javax.swing.JPanel phong22;
    private javax.swing.JPanel phong23;
    private javax.swing.JPanel phong24;
    private javax.swing.JPanel phong25;
    private javax.swing.JPanel phong26;
    private javax.swing.JPanel phong27;
    private javax.swing.JPanel phong28;
    private javax.swing.JPanel phong29;
    private javax.swing.JPanel phong3;
    private javax.swing.JPanel phong30;
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
    private javax.swing.JPanel phong43;
    private javax.swing.JPanel phong44;
    private javax.swing.JPanel phong45;
    private javax.swing.JPanel phong46;
    private javax.swing.JPanel phong47;
    private javax.swing.JPanel phong48;
    private javax.swing.JPanel phong49;
    private javax.swing.JPanel phong5;
    private javax.swing.JPanel phong50;
    private javax.swing.JPanel phong51;
    private javax.swing.JPanel phong52;
    private javax.swing.JPanel phong53;
    private javax.swing.JPanel phong54;
    private javax.swing.JPanel phong55;
    private javax.swing.JPanel phong56;
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
    private javax.swing.JPanel phong67;
    private javax.swing.JPanel phong68;
    private javax.swing.JPanel phong69;
    private javax.swing.JPanel phong7;
    private javax.swing.JPanel phong70;
    private javax.swing.JPanel phong71;
    private javax.swing.JPanel phong8;
    private javax.swing.JPanel phong9;
    private javax.swing.JPanel pnBody1;
    private javax.swing.JPanel pnBody2;
    private javax.swing.JPanel pnDichVu;
    private javax.swing.JPanel pnHeader;
    private javax.swing.JPanel pnKhachHang;
    private javax.swing.JPanel pnKhuyenMai;
    private javax.swing.JPanel pnLayOutDichVu;
    private javax.swing.JPanel pnLayOutKhachKhachHang;
    private javax.swing.JPanel pnLayOutKhuyenMai;
    private javax.swing.JPanel pnLayOutNhanVien;
    private javax.swing.JPanel pnLayOutTrangChu;
    private javax.swing.JPanel pnMenu;
    private javax.swing.JPanel pnNhanVien;
    private javax.swing.JPanel pnQuanLyPhong;
    private javax.swing.JPanel pnTrangChu;
    private javax.swing.JTabbedPane pnedUngDung;
    private javax.swing.JRadioButton radPhongCaoCap;
    private javax.swing.JRadioButton radPhongDaDat;
    private javax.swing.JRadioButton radPhongDangThue;
    private javax.swing.JRadioButton radPhongNangCao;
    private javax.swing.JRadioButton radPhongThuongGia;
    private javax.swing.JRadioButton radPhongTieuChuan;
    private javax.swing.JRadioButton radPhongTrong;
    private javax.swing.JTextField txtCanCuocCongDanNhanVien;
    private javax.swing.JTextField txtCanCuocKhachHang;
    private javax.swing.JTextField txtChiTieuKhachHang;
    private javax.swing.JTextField txtDonGiaDichVu;
    private javax.swing.JTextField txtEmailNhanVien1;
    private javax.swing.JTextField txtGiaTriKhuyenMai;
    private javax.swing.JTextField txtHoTenNhanVien;
    private javax.swing.JTextField txtMaDichVu;
    private javax.swing.JTextField txtMaKhachHang;
    private javax.swing.JTextField txtMaKhuyenMai;
    private javax.swing.JTextField txtMaNhanVien;
    private javax.swing.JTextField txtNgayBatDauKhuyenMai;
    private javax.swing.JTextField txtNgayKetThucKhuyenMai;
    private javax.swing.JTextField txtNgaySinhKhachHang;
    private javax.swing.JTextField txtNgaySinhNhanVien;
    private javax.swing.JTextField txtNgayVaoLamNhanVien;
    private javax.swing.JTextField txtQuocTichKhachHang;
    private javax.swing.JTextField txtSoDienThoaiKhachHang;
    private javax.swing.JTextField txtSoDienThoaiNhanVien;
    private javax.swing.JTextField txtTenDichVu;
    private javax.swing.JTextField txtTenKhachHang;
    private javax.swing.JTextField txtTenKhuyenMai;
    // End of variables declaration//GEN-END:variables
}
