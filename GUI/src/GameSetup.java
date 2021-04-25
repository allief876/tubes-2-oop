import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class GameSetup {
    private JFrame frame;
    private String name;
    private String species;

    public GameSetup() {
        frame = new JFrame("Game Setup");
        frame.setSize(800,600);
        frame.setResizable(false);

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

        // Add radiobutton to frame
        frame.add(charmander);
        frame.add(squirtle);
        frame.add(pikachu);
        frame.add(diglett);
        frame.add(glalie);

        // Add text field
        JTextField text = new JTextField("Insert name for Engimon");
        text.setBounds(300, 450, 200, 30);
        frame.add(text);

        // Add submit button
        JButton submit = new JButton("Submit");
        submit.setBounds(375, 500, 50, 30);
        frame.add(submit);
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

                // nutup
                frame.dispose();

                // pindah frame in game
            }
        });

        frame.setLayout(null);
        frame.setVisible(true);
    }

    
}