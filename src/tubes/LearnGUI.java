import javax.swing.*;
import java.awt.*;

public class LearnGUI {

    private JFrame frm_main;
    protected Skill targetSkill;
    protected Engimon targetEngimon;
    protected Player player;

    public LearnGUI(Player P, Engimon eng1) {
        this.player = P;
        this.targetEngimon = eng1;

        // Set up frm utama
        frm_main = new JFrame("Learn New Skill");
        frm_main.setSize(400, 300);
        frm_main.setResizable(false);

        // Add title
        JLabel lbl_title = new JLabel("Train your Engimon!");
        title.setBounds(50, 50, 100, 50);

        if ((eng1.getSkills().size()==4) && (this.player.InventSkill.getJumlahInventory()!=0)){
            
            // Notif penuh
            JLabel lbl_subtitle = new JLabel("Skill Engimon Anda penuh!");
            lbl_subtitle.setBounds(20,110,120,50);
            frm_main.add(lbl_subtitle);

            // Tombol balik
            JButton btn_balik = new JButton("Kembali ke permainan");
            btn_balik.setBounds(50,170,100,50);
            btn_int.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    frm_main.dispose();
                }
            });

        }
        else if ((eng1.getSkills().size()!=0)&&(this.player.InventSkill.getJumlahInventory()!=0)){

            // Skill yang dapat dipelajari
            JLabel lbl_subtitle = new JLabel("Skills you can learn");
            lbl_subtitle.setBounds(20,110,120,50);
            frm_main.add(lbl_subtitle);

            JComboBox selectSkill = new JComboBox(player.InventSkill.returnItem().toArray());
            selectSkill.setBounds(50, 160, 100, 50);
            frm_main.add(selectSkill);

            // Input skill
            JLabel lbl_addskill = new JLabel("Choose skill to add");
            lbl_addskill.setBounds(20,170,120,50);
            frm_main.add(lbl_addskill);

            // TextField
            JTextField ent_addskill = new JTextField("Nama skill yang ingin Anda pelajari");
            ent_addskill.setBounds(20,230,140,50);
            frm_main.add(ent_addskill);

            // Button
            JButton btn_add = new JButton("Submit");
            btn_add.setBounds(20,290,80,50);
            btn_add.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    name = btn_add.getText();
                    if (this.player.CheckSkillCompatible(eng1,name)) {
                        // add skill pada engimon)
                        //System.out.println("INIIIIII:"+this.player.InventSkill.findItem(name));
                        this.targetSkill = this.player.InventSkill.findItem(name);
                        this.targetEngimon.incSkills(this.targetSkill);

                        if (!this.player.InventSkill.findItem(name).equals(null)) {
                            //System.out.println("Skill teremove");
                            this.player.InventSkill.removeItem(this.player.InventSkill.findItem(name), 1);

                            //update inventory engimon
                            // remove engimon dengan skill lama
                            this.player.InventEngimon.removeItem(this.player.InventEngimon.findItem(this.targetEngimon.getName()), 1);
                            
                            // add engimon dgn skill baru
                            this.player.InventEngimon.addItem(this.targetEngimon, 1);
                        } else {
                            UIManager.put("OptionPane.messageFont", new Font("Consolas", Font.PLAIN, 14));
                            UIManager.put("OptionPane.buttonFont", new Font("Consolas", Font.PLAIN, 12));
                            JOptionPane.showMessageDialog(frm_main, "Tidak ada pilihan skill, learn gagal");
                            frm_main.dispose();
                        }
                        
                    }
                    else {
                        UIManager.put("OptionPane.messageFont", new Font("Consolas", Font.PLAIN, 14));
                        UIManager.put("OptionPane.buttonFont", new Font("Consolas", Font.PLAIN, 12));
                        JOptionPane.showMessageDialog(frm_main, "pilihan skill tidak compatible, learn gagal");
                        frm_main.dispose();
                    }
                }
            });

            frm_main.add(btn_add);
        }
        else{
            // Notif penuh
            JLabel lbl_subtitle = new JLabel("Tidak ada skill yang bisa anda pelajari.");
            lbl_subtitle.setBounds(20,110,120,50);
            frm_main.add(lbl_subtitle);

            // Tombol balik
            JButton btn_balik = new JButton("Kembali ke permainan");
            btn_balik.setBounds(50,170,100,50);
            btn_int.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    frm_main.dispose();
                }
        }

        // Show frame
        frm_main.setLayout(null);
        frm_main.setVisible(true);
    }
}
