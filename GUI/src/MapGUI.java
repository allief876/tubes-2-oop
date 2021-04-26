import javax.swing.*;
import java.awt.event.*; 
import java.awt.*;

public class MapGUI {

    private JFrame frm_main;
    GameSetup currentGame;

    public MapGUI(String species, String name) {

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

        // help
        JButton btn_help = new JButton("Help");
        btn_help.setBounds(675,285,80,40);
        btn_help.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frm_main, "Berikut ialah cara bermain");
            }
        });
        frm_main.add(btn_help);

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