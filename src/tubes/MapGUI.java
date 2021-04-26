package tubes;

import java.util.*;
import javax.swing.*;
import java.awt.event.*; 
import java.awt.*;

public class MapGUI  {

    private JFrame frm_main;
    GameSetup currentGame;
    private Player P;
    private Map Peta;
    private ArrayList<Engimon> wildEng;

    public MapGUI(String species, String name/*, Map Peta, Player P, ArrayList<Engimon> wildEng*/) {

        // load Peta
        Peta = new Map("tubes/inputPeta.txt");

        wildEng = new ArrayList<Engimon>();
        Coordinate startingPlayer = new Coordinate(2,2);
        P = new Player(startingPlayer);

        Coordinate c1 = new Coordinate();
        Coordinate c2 = new Coordinate();
        Coordinate c3 = new Coordinate();
        Coordinate c4 = new Coordinate();
        Coordinate c5 = new Coordinate();
        Coordinate c6 = new Coordinate();
        Coordinate c7 = new Coordinate();
        Coordinate c8 = new Coordinate();
        
        //Atribut Ctor starting engimon
        Coordinate startingEngimon = new Coordinate(2,1);
        int levelStarting = 1; // Level engimon aktif awal
        Engimon E1; // Active engimon awal
    
        if (species.equals("Charmander")){E1 = new Charmander(name, startingEngimon, levelStarting, false); }
        else if (species.equals("Squirtle")){E1 = new Squirtle(name, startingEngimon, levelStarting, false); }
        else if (species.equals("Pikachu")){E1 = new Pikachu(name, startingEngimon, levelStarting, false); }
        else if (species.equals("Diglett")){E1 = new Diglett(name, startingEngimon, levelStarting, false); }
        else {
            E1 = new Glalie(name, startingEngimon, levelStarting, false);
        }

        P.addEngimon(E1);
        P.setActiveEngimon(E1);
        
        Engimon A =  new Charmander("Wild1",c1,P.getHighestLevel(),true); wildEng.add(A);
        Engimon B = new Squirtle("Wild2",c2,P.getHighestLevel(),true); wildEng.add(B);
        Engimon C = new Pikachu("Wild3",c3,P.getHighestLevel(),true); wildEng.add(C);
        Engimon D = new Diglett("Wild4",c4,P.getHighestLevel(),true); wildEng.add(D);
        Engimon E = new Glalie("Wild5",c5,P.getHighestLevel(),true); wildEng.add(E);
        Engimon F = new Rotom("Wild6",c6,P.getHighestLevel(),true); wildEng.add(F);
        Engimon G = new Lapras("Wild7",c7,P.getHighestLevel(),true); wildEng.add(G);
        Engimon H = new Wooper("Wild8",c8,P.getHighestLevel(),true); wildEng.add(H);

        Boolean isGameRunning = true;

        //this.P = P;
        //this.Peta = Peta;
        
        Font ftitle = new Font("Consolas", Font.PLAIN, 16);
        Font fbtn = new Font("Consolas", Font.PLAIN, 12);

        // Set up frm utama
        frm_main = new JFrame("WillyWkwkwk");
        frm_main.setSize(800,650);
        frm_main.setResizable(false);

        //JButton btn_map;

        // GUI map
        for (int i = 0; i < 10; i++) { // y
            for (int j = 0; j < 10; j++) { // x

                if (P.getPlayerPosition().x == i && P.getPlayerPosition().y == j) {
                    String str = "P";
                    JButton btn_map = new JButton(str);
                    btn_map.setBounds(j*55+100,i*55+35,50,50);
                    frm_main.add(btn_map);
                }
                else if (P.getActiveEngimon().getPosition().x == i && P.getActiveEngimon().getPosition().y == j) {
                    String str = "A";
                    JButton btn_map = new JButton(str);
                    btn_map.setBounds(j*55+100,i*55+35,50,50);
                    frm_main.add(btn_map);
                }
                else {
                    char ch = Peta.PetaModifikasi[i][j];
		
                    //char to string conversion
                    String str = String.valueOf(ch);
    
                    JButton btn_map = new JButton(str); // print sesuai karakter tsb.
                    btn_map.setBounds(j*55+100, i*55+35, 50, 50);
                    frm_main.add(btn_map);
                }
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
                new InventoryGUI(P);
            }
        });
        frm_main.add(btn_inv);

        // learn
        JButton btn_lrn = new JButton("Learn"); // LearnGUI.java
        btn_lrn.setBounds(675,35,80,40);
        btn_lrn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                /*P.showListEngimon();
                System.out.println( "Masukkan engimon: ");
                command = myObj.nextLine();
                if (!(P.findEngimon(command).getName().equals("none") )){
                    learn = new Learn(P,P.findEngimon(command));
                }*/
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
                JOptionPane.showMessageDialog(frm_main, P.getActiveEngimon().getSlogan());
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
                JOptionPane.showMessageDialog(frm_main, "Game Status\nActive Engimon\t:\n" + P.getActiveEngimon().displayInfo() + "Player\t:\nKoordinat PLayer: (" + P.getPlayerPosition().x + "," + P.getPlayerPosition().y + ")");
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
            public void actionPerformed(ActionEvent e) {
                Peta.move('w', P);
            }
        });
        frm_main.add(btn_w);

        // a
        JButton btn_a = new JButton("A");
        btn_a.setBounds(25,260,50,40);
        btn_a.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Peta.move('a', P);
            }
        });
        frm_main.add(btn_a);

        // s
        JButton btn_s = new JButton("S");
        btn_s.setBounds(25,310,50,40);
        btn_s.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Peta.move('s', P);
            }
        });
        frm_main.add(btn_s);

        // d
        JButton btn_d = new JButton("D");
        btn_d.setBounds(25,360,50,40);
        btn_d.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Peta.move('d', P);
            }

        });
        frm_main.add(btn_d);

        // Show frame
        frm_main.setLayout(null);
        frm_main.setVisible(true);
    }

}