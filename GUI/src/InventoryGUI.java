import javasx.swing.*;
import java.awt.*;

public class InventoryGUI {
    
    private JFrame frm_main;

    public InventoryGUI() {
        
        System.out.println( "Pilih inventory yang ingin ditampilkan" );
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
