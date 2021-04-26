package tubes;

import java.util.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class BattleGUI {
    private JFrame battleFrame;
    private Player P;
    private Engimon activeEngimon;
    private Engimon enemyEngimon;

    public BattleGUI(Player _P, Engimon _activeEngimon, Engimon _enemyEngimon) {
        this.P = _P;
        this.activeEngimon = _activeEngimon;
        this.enemyEngimon = _enemyEngimon;

        // Setup JFrame
        battleFrame = new JFrame("Battle");
        battleFrame.setSize(600, 450);
        battleFrame.setResizable(true);

        // Display Active and Enemy Engimon Info
        String activeEngimonInfoString = makeInfo(activeEngimon);
        String enemyEngimonInfoString = makeInfo(enemyEngimon);
        JLabel activeEngimonInfo = new JLabel(activeEngimonInfoString);
        JLabel enemyEngimonInfo = new JLabel(enemyEngimonInfoString);
        activeEngimonInfo.setBounds(100,100,150,150);
        enemyEngimonInfo.setBounds(300,100,150,150);

        // Button battle and cancel
        JButton battleButton = new JButton("Battle");
        JButton cancelButton = new JButton("Cancel");
        battleButton.setBounds(500,200,100,50);
        cancelButton.setBounds(500,350,200,50);
        battleFrame.add(battleButton);
        battleFrame.add(cancelButton);
        battleButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JLabel label = new JLabel();            
                label.setHorizontalAlignment(JLabel.CENTER);    
                label.setSize(250,100);
                Battle B = new Battle(P,activeEngimon,enemyEngimon);
                if (B.getLoseStatus()) {
                    JOptionPane.showMessageDialog(battleFrame, "Engimon kehilangan satu nyawa!");
            
                }
                else {
                    JOptionPane.showMessageDialog(battleFrame, "Engimon menang!");
                }
            }
        });
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                battleFrame.dispose();
            }
        });

        battleFrame.setLayout(null);
        battleFrame.setVisible(true);
    }

    private String makeInfo(Engimon E) {
        String nama = "Nama\t\t:" + E.getName() + "\n";
        String exp = "Experience\t:" + E.getExp() + "/100\n";
        String level = "Level\t\t:" + E.getLevel() + "\n";
        String live = "Live\t\t:" + E.getLive() + "\n";
        String species = "Species\t\t:" + E.getSpecies() + "\n";
        String skills = formattedPrintSkills(E.getSkills(), E);
        return nama+exp+level+live+species+skills;
    }

    private String formattedPrintSkills(ArrayList<Skill> arraySkill, Engimon E) {
        for (int i = 0; i < (E.getSkills()).size(); i++) {
            String skill = Integer.toString(i+1) + ". " + arraySkill.get(i).getNama() + ", Mastery level = " + arraySkill.get(i).getMasteryLevel();
            String element1 = "Elements: " + arraySkill.get(i).getElements().get(0);
            String skillString1 = skill.concat(element1);
            if (!arraySkill.get(i).getElements().get(1).equals("none")) {
                String element2 = " and " + arraySkill.get(i).getElements().get(1) + "\n";
                return skillString1.concat(element2);
            }
            else {
                return skillString1.concat("\n");
            }
        }
        return ("");
    }
}