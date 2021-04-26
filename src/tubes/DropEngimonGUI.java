package tubes;

import javax.swing.*;
import java.awt.event.*; 
import java.awt.*;
import java.util.*;

public class DropEngimonGUI {

    private JFrame frm_main; 

    public DropEngimonGUI(Player P) {

        // Set font
        Font ftitle = new Font("Consolas", Font.PLAIN, 16);
        Font fbtn = new Font("Consolas", Font.PLAIN, 12);
        
        frm_main = new JFrame("Drop Engimon");
        frm_main.setSize(400,300);
        frm_main.setResizable(false);

        // Add title
        JLabel title = new JLabel("Choose Engimon to be removed");
        title.setBounds(50, 50, 100, 30);
        title.setFont(ftitle);

        // Add inventory engimon to array
        ArrayList<String> listEng = new ArrayList<String>();
        for (Engimon engimon : P.InventEngimon.returnItem()) {
            listEng.add(engimon.getName() + " (" + engimon.getSpecies() + ")");
        }

        // Add combobox
        JComboBox selectEngimon = new JComboBox(listEng.toArray());
        selectEngimon.setBounds(50, 100, 100, 30);
        selectEngimon.setFont(fbtn);

        // Add select button
        JButton selected = new JButton("Select");
        selected.setBounds(50, 150, 50, 30);
        selected.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int id = selectEngimon.getSelectedIndex();
                P.lepasEngimon(P.InventEngimon.returnItem().get(id).getName());
                frm_main.dispose();
            }
        });
        selected.setFont(fbtn);

        // Add to frame
        frm_main.add(title);
        frm_main.add(selectEngimon);
        frm_main.add(selected);

        frm_main.setLayout(null);
        frm_main.setVisible(true);
    }
}
