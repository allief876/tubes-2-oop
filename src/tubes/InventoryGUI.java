import javasx.swing.*;
import java.awt.*;

public class InventoryGUI {
    
    private JFrame frm_main;

    public InventoryGUI() {

        frm_main = new JFrame("Pemilihan Inventory");
        frm_main.setSize(400,300);
        frm_main.setResizable(false);

        JLabel lbl_title = new JLabel("Pilih inventory yang ingin ditampilkan");
        lbl_title.setBounds(50,150,100,50);
        frm_main.add(lbl_title);

        JButton btn_eng = new JButton("Engimon");
        btn_eng.setBounds(50,210,40,50);
        frm_main.add(btn_eng);

        JButton btn_skill = new JButton("Skill");
        btn_skill.setBounds(50,270,40,50);
        frm_main.add(btn_skill);
        
        System.out.println( "Ketik \"engimon\" atau \"skill\"" );
        command = myObj.nextLine();
        if (command.equals("engimon")) {
            P.showListEngimon();
        }
        else if (command.equals("skill")){
            P.showListSkillItem();
        }
    }
}
