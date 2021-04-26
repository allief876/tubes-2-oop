import javax.swing.*;
import java.awt.event.*; 
import java.awt.*;
import java.util.*;

public class ChangeGUI {

    private JFrame frm_main; 

    public ChangeGUI(Player P) {

        // Set font
        Font ftitle = new Font(Font.Monospace, Font.PLAIN, 16);
        Font fbtn = new Font(Font.Monospace, Font.PLAIN, 12);
        
        frm_main = new JFrame("Change Active Engimon");
        frm_main.setSize(400,300);
        frm_main.setResizable(false);

        // Add title
        JLabel title = new JLabel("Choose new active Engimon");
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
                P.setActiveEngimon(P.InventEngimon.returnItem.get(id)); // MASIH BLM YAKIN
                frm_main.dispose();
            }
        })
        selected.setFont(fbtn);

        // Add to frame
        frm_main.add(title);
        frm_main.add(selectEngimon);
        frm_main.add(selected);

        frm_main.setLayout(null);
        frm_main.setVisible(true);
    }
}
