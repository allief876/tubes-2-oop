package tubes;

import javax.swing.*;
import java.awt.event.*; 
import java.awt.*;
import java.util.*;

public class BreedGUI {

    private JFrame frm_main; 

    public BreedGUI(Player P) {

        // Set font
        Font ftitle = new Font("Consolas", Font.PLAIN, 16);
        Font fbtn = new Font("Consolas", Font.PLAIN, 12);
        
        frm_main = new JFrame("Breed Engimon");
        frm_main.setSize(400,300);
        frm_main.setResizable(false);

        // Add title
        JLabel title = new JLabel("Choose Engimon to be bred");
        title.setBounds(50, 50, 100, 30);
        title.setFont(ftitle);

        // Add inventory engimon to array
        ArrayList<String> listEng = new ArrayList<String>();
        for (Engimon engimon : P.InventEngimon.returnItem()) {
            listEng.add(engimon.getName());
        }

        // Add combobox
        JComboBox selectParent1 = new JComboBox(listEng.toArray());
        selectParent1.setBounds(50, 100, 100, 30);
        selectParent1.setFont(fbtn);

        JComboBox selectParent2 = new JComboBox(listEng.toArray());
        selectParent2.setBounds(100, 100, 100, 30);
        selectParent2.setFont(fbtn);

        // Add error label
        JLabel label = new JLabel();            
        label.setHorizontalAlignment(JLabel.CENTER);    
        label.setSize(250,100);    
        label.setFont(fbtn);

        // Add select button
        JButton selected = new JButton("Breed");
        selected.setBounds(50, 150, 50, 30);
        selected.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                // kalo nama parent sama
                if (selectParent1.getSelectedIndex() == selectParent2.getSelectedIndex()) {
                    label.setText("Can not breed the same Engimon");
                }
                
                // parent punya 2 elemen
                else if (!((P.InventEngimon.returnItem()).get(selectParent1.getSelectedIndex())).getElements().get(1).equals("none") || !((P.InventEngimon.returnItem()).get(selectParent1.getSelectedIndex())).getElements().get(1).equals("none")) {
                    label.setText("Can not breed Engimon with 2 elements");
                }

                else {
                    Breed b = new Breed(P, (P.InventEngimon.returnItem()).get(selectParent1.getSelectedIndex()), (P.InventEngimon.returnItem()).get(selectParent2.getSelectedIndex()));
                    frm_main.dispose();
                }
            }
        });
        selected.setFont(fbtn);

        // Add to frame
        frm_main.add(title);
        frm_main.add(selectParent1);
        frm_main.add(selectParent2);
        frm_main.add(selected);
        frm_main.add(label);

        frm_main.setLayout(null);
        frm_main.setVisible(true);
    }
}
