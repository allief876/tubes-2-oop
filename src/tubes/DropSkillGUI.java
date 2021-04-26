import javax.swing.*;
import java.awt.event.*; 
import java.awt.*;
import java.util.*;

public class DropSkillGUI {

    private JFrame frm_main; 

    public DropSkillGUI(Player P) {

        // Set font
        Font ftitle = new Font(Font.Monospace, Font.PLAIN, 16);
        Font fbtn = new Font(Font.Monospace, Font.PLAIN, 12);
        
        frm_main = new JFrame("Drop Skill");
        frm_main.setSize(400,300);
        frm_main.setResizable(false);

        // Add title
        JLabel title = new JLabel("Choose skill to be removed");
        title.setBounds(50, 50, 100, 30);
        title.setFont(ftitle);

        // Add combobox
        JComboBox selectSkill = new JComboBox(P.InventSkill.returnItem().toArray());
        selectSkill.setBounds(50, 100, 100, 30);
        selectSkill.setFont(fbtn);

        // Add spinner
        JSpinner spinner = new JSpinner(new SpinnerNumberModel(1, 1, 99, 1));
        spinner.setBounds(50, 150, 50, 30);
        spinner.setFont(fbtn);
        JLabel spinnertext = new JLabel("Amount: ");
        spinnertext.setBounds(25, 150, 50, 30);
        spinnertext.setFont(fbtn);

        // Add error label
        JLabel label = new JLabel();            
        label.setHorizontalAlignment(JLabel.CENTER);    
        label.setSize(250,100);    
        label.setFont(fbtn);

        // Add select button
        JButton selected = new JButton("Select");
        selected.setBounds(50, 150, 50, 30);
        selected.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = selectSkill.getItemAt(selectSkill.getSelectedIndex());  
                int count = P.InventSkill.findItem(name).getAmount();

                // Kondisi amount input > count
                if (((Integer) spinner.getValue()) > count) {
                    label.setText("Skill amount exceeded. Please decrease")
                }

                else {
                    P.lepasSkillItem(name, ((Integer) spinner.getValue()));
                    frm_main.dispose();
                }
            }
        })
        selected.setFont(fbtn);

        // Add to frame
        frm_main.add(title);
        frm_main.add(selectSkill);
        frm_main.add(selected);
        frm_main.add(spinner);
        frm_main.add(spinnertext);

        frm_main.setLayout(null);
        frm_main.setVisible(true);
    }
}
