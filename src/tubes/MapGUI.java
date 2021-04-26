import javax.swing.*;
import java.awt.event.*; 
import java.awt.*;

public class MapGUI  {

    private JFrame frm_main;
    GameSetup currentGame;
    private Player P;
    private Map Peta;

    public MapGUI(String species, String name, Map Peta, Player P) {

        this.P = P;
        this.Peta = Peta;
        
        Font ftitle = new Font(Font.Monospace, Font.PLAIN, 16);
        Font fbtn = new Font(Font.Monospace, Font.PLAIN, 12);

        // Set up frm utama
        frm_main = new JFrame("WillyWkwkwk");
        frm_main.setSize(800,650);
        frm_main.setResizable(false);

        JButton btn_map;

        // GUI map
        for (int i = 0; i < 10; i++) { // y
            for (int j = 0; j < 10; j++) { // x
                // Baca karakter di matrix of char yang merepresentasikan peta
                btn_map = new JButton(Peta.PetaModifikasi[i][y]); // print sesuai karakter tsb.
                btn_map.setBounds(j*55+100, i*55+35, 50, 50);
                frm_main.add(btn_map);
            }
        }

        // help
        JButton btn_help = new JButton("Help");
        btn_help.setBounds(675,285,80,40);
        btn_help.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                UIManager.put("OptionPane.messageFont", new Font("Consolas", Font.PLAIN, 14));
                UIManager.put("OptionPane.buttonFont", new Font("Consolas", Font.PLAIN, 12));
                JOptionPane.showMessageDialog(frm_main, "+-----------------------------------------+\n|              Engimon Help               |\n|-----------------+-----------------------|\n|     command     |        action         |\n|-----------------+-----------------------|\n|W/w              |move north             |\n|A/a              |move west              |\n|S/s              |move south             |\n|D/d              |move east              |\n|change           |change active engimon  |\n|breed            |breed engimon          |\n|battle           |battle wild engimon    |\n|learn            |learn skill to engimon |\n|inventory        |view inventory         |\n|interact         |interact with engimon  |\n|changeName       |change engimon name    |\n|status           |view game status       |\n|dropSkillItem    |membuang skill item    |\n|dropEngimon      |membuang engimon       |\n|help             |view help              |\n+-----------------------------------------+");
            }
        });
        frm_main.add(btn_help);

        // change
        JButton btn_chg = new JButton("Change"); // ChangeGUI.java
        btn_chg.setBounds(675,235,80,40);
        btn_chg.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new ChangeGUI(P);
            }
        });
        frm_main.add(btn_chg);

        // breed
        JButton btn_brd = new JButton("Breed"); // BreedGUI.java (?)
        btn_brd.setBounds(675,185,80,40);
        btn_brd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new ChangeGUI(P);
            }
        });
        frm_main.add(btn_brd);

        // battle
        JButton btn_btl = new JButton("Battle"); // BattleGUI.java
        btn_btl.setBounds(675,135,80,40);
        btn_btl.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new BattleGUI(P,P.getActiveEngimon(),P.isEngimonNearby(wildEng));
            }
        });
        frm_main.add(btn_btl);

        // inventory
        JButton btn_inv = new JButton("Inventory"); // disini aja
        btn_inv.setBounds(675,85,80,40);
        btn_inv.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Panggil fungsi GUI inventory here
                new InventoryGUI();
            }
        });
        frm_main.add(btn_inv);

        // learn
        JButton btn_lrn = new JButton("Learn"); // LearnGUI.java
        btn_lrn.setBounds(675,35,80,40);
        btn_lrn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                P.showListEngimon();
                System.out.println( "Masukkan engimon: ");
                command = myObj.nextLine();
                if (!(P.findEngimon(command).getName().equals("none") )){
                    learn = new Learn(P,P.findEngimon(command));
                }
            }
        });
        frm_main.add(btn_lrn);

        // interact
        JButton btn_int = new JButton("Interact"); // GUI
        btn_int.setBounds(675,335,80,40);
        btn_int.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                UIManager.put("OptionPane.messageFont", new Font("Consolas", Font.PLAIN, 14));
                UIManager.put("OptionPane.buttonFont", new Font("Consolas", Font.PLAIN, 12));
                JOptionPane.showMessageDialog(frm_main, P.activeEngimon().interactEngimon());
            }
        });
        frm_main.add(btn_int);

        // changeName
        JButton btn_chgnm = new JButton("ChangeName"); // GUI
        btn_chgnm.setBounds(675,385,80,40);
        btn_chgnm.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Minta nama engimon here
                // Panggil fungsi LearnGUI dengan paramaternya here
            }
        });
        frm_main.add(btn_chgnm);

        // status
        JButton btn_stats = new JButton("Status"); // messageDialog
        btn_stats.setBounds(675,435,80,40);
        btn_stats.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                UIManager.put("OptionPane.messageFont", new Font("Consolas", Font.PLAIN, 14));
                UIManager.put("OptionPane.buttonFont", new Font("Consolas", Font.PLAIN, 12));
                JOptionPane.showMessageDialog(frm_main, "Game Status\n Active Engimon\t:" + P.getActiveEngimon().displayInfo + "Player\t:\n Koordinat PLayer: (" + P.getPlayerPosition().x + "," + P.getPlayerPosition().y + ")");
            }
        });
        frm_main.add(btn_stats);

        // dropSkill
        JButton btn_drpsk = new JButton("dropSkillItem"); // GUI
        btn_drpsk.setBounds(675,485,80,40);
        btn_drpsk.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new DropSkillGUI(P);
            }
        });
        frm_main.add(btn_drpsk);

        // dropEng
        JButton btn_drpeng = new JButton("dropEngimon"); // GUI
        btn_drpeng.setBounds(675,535,80,40);
        btn_drpeng.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new DropEngimonGUI(P);
            }
        });
        frm_main.add(btn_drpeng);

        // w
        JButton btn_w = new JButton("W");
        btn_w.setBounds(25,210,50,40);
        btn_w.addActionListener(new ActionListener() {
            Peta.move('w', P)
        })
        frm_main.add(btn_w);

        // a
        JButton btn_a = new JButton("A");
        btn_a.setBounds(25,260,50,40);
        btn_a.addActionListener(new ActionListener() {
            Peta.move('a', P)
        })
        frm_main.add(btn_a);

        // s
        JButton btn_s = new JButton("S");
        btn_s.setBounds(25,310,50,40);
        btn_s.addActionListener(new ActionListener() {
            Peta.move('s', P)
        })
        frm_main.add(btn_s);

        // d
        JButton btn_d = new JButton("D");
        btn_d.setBounds(25,360,50,40);
        btn_d.addActionListener(new ActionListener() {
            Peta.move('d', P)
        })
        frm_main.add(btn_d);

        // Show frame
        frm_main.setLayout(null);
        frm_main.setVisible(true);
    }

    public static void main(String[] args) {
        new MapGUI();
    }

}