import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class GameSetup {
    private JFrame frm_main;
    private String name;
    private String species = "none";
    private MapGUI map;

    public GameSetup() {
        frm_main = new JFrame("Game Setup");
        frm_main.setSize(800,600);
        frm_main.setResizable(false);

        // add images
        JLabel charm = new JLabel(new ImageIcon("assets\\charmander.png"));
        charm.setBounds(79,100,100,101);
        frm_main.add(charm);


        // Add radiobutton
        JRadioButton charmander, squirtle, pikachu, diglett, glalie;
        charmander = new JRadioButton("Charmander");
        squirtle = new JRadioButton("Squirtle");
        pikachu = new JRadioButton("Pikachu");
        diglett = new JRadioButton("Diglett");
        glalie = new JRadioButton("Glalie");

        // Set their positions
        charmander.setBounds(130, 400, 100, 30);
        squirtle.setBounds(250, 400, 100, 30);
        pikachu.setBounds(350, 400, 100, 30);
        diglett.setBounds(450, 400, 100, 30);
        glalie.setBounds(550, 400, 100, 30);

        // Add to buttongroup
        ButtonGroup bg = new ButtonGroup();
        bg.add(charmander);
        bg.add(squirtle);
        bg.add(pikachu);
        bg.add(diglett);
        bg.add(glalie);

        // Add radiobutton to frm_main
        frm_main.add(charmander);
        frm_main.add(squirtle);
        frm_main.add(pikachu);
        frm_main.add(diglett);
        frm_main.add(glalie);

        // Add text field
        JTextField text = new JTextField("Insert name for Engimon");
        text.setBounds(270, 450, 200, 30);
        frm_main.add(text);

        // Add submit button
        JButton submit = new JButton("Submit");
        submit.setBounds(320, 500, 80, 30);
        frm_main.add(submit);
        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // set species
                if (charmander.isSelected()) species = "Charmander";
                else if (squirtle.isSelected()) species = "Squirtle";
                else if (pikachu.isSelected()) species = "Pikachu";
                else if (diglett.isSelected()) species = "Diglett";
                else if (glalie.isSelected()) species = "Glalie";

                // set name
                name = text.getText();

                // kalo species kosong
                if (species.equals("none")) {
                    JOptionPane.showMessageDialog(frm_main, "Please fill Engimon species", "Alert", JOptionPane.WARNING_MESSAGE);
                }

                // kalo name kosong
                else if (name.length() == 0 || name.equals("Insert name for Engimon")) {
                    JOptionPane.showMessageDialog(frm_main, "Please insert Engimon name", "Alert", JOptionPane.WARNING_MESSAGE);
                }

                // nutup
                else {
                    frm_main.dispose();
                    map = new MapGUI(species, name);
                }

                // pindah frm_main in game
            }
        });

        frm_main.setLayout(null);
        frm_main.setVisible(true);
    }

    
}