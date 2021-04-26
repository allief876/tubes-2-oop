package tubes;

import javax.swing.*;
import java.awt.event.*; 

public class MainGUI {

    private JFrame frm_main;
    private GameSetup currentGame;

    public MainGUI() {
        frm_main = new JFrame("Menu Utama");
        frm_main.setSize(800,600);
        frm_main.setResizable(false); // Kalo diresize, nanti keliatan jelek-jeleknya

        // Add Title Image
        JLabel lbl_title = new JLabel(new ImageIcon("assets\\WillyWkwkwk.png"));
        lbl_title.setBounds(79,100,642,121);
        frm_main.add(lbl_title);

        // New Game
        JButton btn_newgame = new JButton("New Game");
        btn_newgame.setBounds(300,280,200,50);
        frm_main.add(btn_newgame);
        btn_newgame.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                currentGame = new GameSetup();
                frm_main.dispose();
            }
        });

        // Load Game
        JButton btn_load = new JButton("Load Game");
        btn_load.setBounds(300,360,200,50);
        frm_main.add(btn_load);
        btn_load.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //currentGame = new Game();
                frm_main.dispose();
            }
        });

        // Show frame
        frm_main.setLayout(null);
        frm_main.setVisible(true);
    }


    public static void main(String[] args) {
        MainGUI GUI = new MainGUI();
    }
}
