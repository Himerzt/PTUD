/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package giaodien;

import java.awt.Color;
import javax.swing.UIManager;

/**
 *
 * @author Admin
 */
public class GiaoDien {
    public static void main(String[] args) {
        UIManager.put("Button.select", new Color(0, 0, 0,0));
        Login LoginFrame = new Login();
        LoginFrame.setVisible(true);
        LoginFrame.pack();
        LoginFrame.setLocationRelativeTo(null); // center
    }
}
