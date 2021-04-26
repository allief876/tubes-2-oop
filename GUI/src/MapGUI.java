import javax.swing.*;
import java.awt.event.*; 
import java.awt.*;

public class MapGUI {

    private JFrame frm_main;
    GameSetup currentGame;

    public MapGUI(/*int ukuranMap*/) {

        // Set up frm utama
        frm_main = new JFrame("WillyWkwkwk");
        frm_main.setSize(800,650);
        frm_main.setResizable(false);

        JButton btn_map;

        // GUI map
        for (int i = 0; i < 10; i++) { // y
            for (int j = 0; j < 10; j++) { // x
                btn_map = new JButton("M");
                btn_map.setBounds(j*55+100, i*55+35, 50, 50);
                frm_main.add(btn_map);
            }
        }

        // Show frame
        frm_main.setLayout(null);
        frm_main.setVisible(true);
    }

    public static void main(String[] args) {
        new MapGUI();
    }

    /*public void CetakMap(Map ?) {

    }*/
}