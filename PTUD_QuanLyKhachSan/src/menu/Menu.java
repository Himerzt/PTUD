
package menu;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.geom.Rectangle2D;
import java.net.URL;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;


public class Menu extends  JComponent{

    public MenuEvent getEvent() {
        return event;
    }

    public void setEvent(MenuEvent event) {
        this.event = event;
    }
    private MenuEvent event;
    private MigLayout layout;
    private String [][] menuItems= new String[][]{
    {"Trang chủ"},
//    {"Quản lý phòng","Đặt phòng","Thuê phòng","Đổi phòng","Trả phòng","Hủy đặt phòng","Xem chi tiết"},
    {"Quản lý phòng"},
    {"Nhân viên"},
    {"Dịch vụ"},
    {"Khuyến mãi"},
    {"Khách hàng"},
    {"Thoát"}
};
    public  Menu(){
        init();
    }
    private void init(){
        layout=new MigLayout("wrap 1, fillx,gapy 0, inset 2","fill");
        setLayout(layout);
        setOpaque(true);
        //init menu
        for(int i = 0;i<menuItems.length;i++){
            addMenu(menuItems[i][0], i);
        }
    }
    private Icon getIcon(int indext){
        URL url=getClass().getResource("/menu/"+indext+".png");
        if(url!=null){
            return new ImageIcon(url);
        }else{
            return null;
        }
    }
        public void addMenu(String menuName, int index){
        int lenght=menuItems[index].length;
        MenuItem item=new MenuItem(menuName, index, lenght>1);
        Icon icon=getIcon(index);
        if(icon != null){
            item.setIcon(icon);
        }
        item.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(lenght>1){
                    if(!item.isSelected()){
                        item.setSelected(true);
                    addSubMenu(item, index, lenght, getComponentZOrder(item));
                    }else{
                        // hide menu
                        hideMenu(item, index);
                        item.setSelected(false);
                    }
                } else{
                    if(event!=null){
                        event.selected(index, 0);
                    }
                }
            }
        
        });
            add(item);
            revalidate();
            repaint();
    }
        private void addSubMenu(MenuItem item,int index, int lenght, int indexZorder){
            JPanel panel = new JPanel(new MigLayout("wrap 1, fillx, inset 0, gapy 0","fill"));
            panel.setName(index +"");
            panel.setOpaque(false);
            for(int i= 1;i<lenght;i++){
                MenuItem subItem= new MenuItem(menuItems[index][i], i, false);
                subItem.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if(event!=null){
                            event.selected(index, subItem.getIndex());
                        }
                    }
                    
                });
                subItem.initSubMenu(i, lenght);
                panel.add(subItem);
            }
            add(panel,"h 0!", indexZorder+1);
            revalidate();
            repaint();
            MenuAnimation.showMenu(panel, item, layout, true);
        }
    private void hideMenu(MenuItem item, int index){
        for(Component com:getComponents()){
            if(com instanceof  JPanel && com.getName()!=null && com.getName().equals(index +"")){
                com.setName(null);
                MenuAnimation.showMenu(com, item, layout, false);
                break;
            }
        }
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2= (Graphics2D) grphcs.create();
        g2.setColor(new Color(34,124,157));
        g2.fill(new Rectangle2D.Double(0, 0, getWidth(), getHeight()));
        super.paintComponent(grphcs); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
}

