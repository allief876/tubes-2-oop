package tubes;

import java.util.*;
public class Learn {
    
    protected Skill targetSkill;
    protected Engimon targetEngimon;
    protected Player player;
    public Learn(Player _player, Engimon eng1){
        this.player = _player;
        this.targetEngimon = eng1;
   
        
        if ((eng1.getSkills().size()==4)&&(this.player.InventSkill.getJumlahInventory()!=0)){
            System.out.println("Skill Engimon anda penuh");
            System.out.println("Berikut adalah Skill yang engimon"+eng1.getName()+" miliki:");
            eng1.printSkills();
            Scanner input = new Scanner(System.in);  // Create a Scanner object
            System.out.println("Masukkan nama skill yang ingin di drop: ");
            String name = input.nextLine();  // Read user input
            // remove skill from engimon
            this.targetEngimon.removeSkill(name);
            //this.player.InventSkill.removeItem(this.player.InventSkill.findItem(name), 1);
            
            //antara ditampilkan element skill dan user pilih yang sesuai, atau seleksi jd skills compatible dahulu
            System.out.println("Berikut adalah Skill yang dapat anda pelajari:");
            this.player.showListSkillItem(); // <- ini harusnya udah WIl
            System.out.println("Masukkan nama skill yang ingin anda pelajari: ");
            name = input.nextLine();  // Read user input

            if (this.player.CheckSkillCompatible(eng1,name)){
                // add skill pada engimon)
                //System.out.println("INIIIIII:"+this.player.InventSkill.findItem(name));
                this.targetSkill = this.player.InventSkill.findItem(name);
                this.targetEngimon.incSkills(this.targetSkill);
                System.out.println("Skill yg ingin ditambah:");
                System.out.println(this.targetSkill);

                if (!this.player.InventSkill.findItem(name).equals(null)) {
                    //System.out.println("Skill teremove");
                    this.player.InventSkill.removeItem(this.player.InventSkill.findItem(name), 1);
                    //update inventory engimon
                    // remove engimon dengan skill lama
                    this.player.InventEngimon.removeItem(this.player.InventEngimon.findItem(this.targetEngimon.getName()), 1);
                    
                    // add engimon dgn skill baru
                    this.player.InventEngimon.addItem(this.targetEngimon, 1);
                }
                else{
                    System.out.println("Tidak ada pilihan skill, learn gagal");
                }
            }

            /**ArrayList<Skill> temp = new ArrayList<Skill>();
            temp = this.player.InventSkill.returnItem();
            for (int i =0; i<temp.size(); i++){
                System.out.println("masuk loop");
                System.out.println(temp.size());
                
                System.out.println(temp.get(i).getNama());
                System.out.println(name);
                System.out.println(temp.get(i).getNama().equals(name));
                if ( temp.get(i).getNama().equals(name) ){
                    System.out.println("masuk ada nama yg sama");
                    this.targetSkill = temp.get(i);
                    // remove dari temp dan inventory
                    //temp.remove(i); 
                    this.player.InventSkill.removeItem(this.player.InventSkill.findItem(name), 1);
                }
            }*/    
        
        }
        else if ((eng1.getSkills().size()!=0)&&(this.player.InventSkill.getJumlahInventory()!=0)){
            //antara ditampilkan element skill dan user pilih yang sesuai, atau seleksi jd skills compatible dahulu
            System.out.println("Berikut adalah Skill yang dapat anda pelajari:");
            /*************************************************************************** */
            /*************************************************************************** */
            this.player.showListSkillItem(); // <- ini harusnya udah WIl
            /*************************************************************************** */
            /*************************************************************************** */
            Scanner input = new Scanner(System.in);  // Create a Scanner object
            System.out.println("Masukkan nama skill yang ingin anda pelajari: ");
            String name = input.nextLine();  // Read user input

            if (this.player.CheckSkillCompatible(eng1,name)){
                // add skill pada engimon)
                //System.out.println("INIIIIII:"+this.player.InventSkill.findItem(name));
                this.targetSkill = this.player.InventSkill.findItem(name);
                this.targetEngimon.incSkills(this.targetSkill);
                System.out.println("Skill yg ingin ditambah:");
                System.out.println(this.targetSkill);

                if (!this.player.InventSkill.findItem(name).equals(null)) {
                    //System.out.println("Skill teremove");
                    this.player.InventSkill.removeItem(this.player.InventSkill.findItem(name), 1);
                    //update inventory engimon
                    // remove engimon dengan skill lama
                    this.player.InventEngimon.removeItem(this.player.InventEngimon.findItem(this.targetEngimon.getName()), 1);
                    
                    // add engimon dgn skill baru
                    this.player.InventEngimon.addItem(this.targetEngimon, 1);
                }
                else{
                    System.out.println("Tidak ada pilihan skill, learn gagal");
                }
            }
            else{
                System.out.println("pilihan skill tidak compatible, learn gagal");
            }
            
            /**ArrayList<Skill> temp = new ArrayList<Skill>();
            temp = this.player.InventSkill.returnItem();
            for (int i =0; i<temp.size(); i++){
                System.out.println("masuk loop");
                System.out.println(temp.size());
                
                System.out.println(temp.get(i).getNama());
                System.out.println(name);
                System.out.println(temp.get(i).getNama().equals(name));
                if (this.player.InventSkill.findItem(name)){

                })
                if ( temp.get(i).getNama().equals(name) ){
                    System.out.println("masuk ada nama yg sama");
                    this.targetSkill = temp.get(i);
                    // remove dari temp dan inventory
                    //temp.remove(i); 
                    this.player.InventSkill.removeItem(this.player.InventSkill.findItem(name), 1);
                }
            }*/

            
        }
        else{
            System.out.println("Tidak ada skill yang bisa anda pelajari");
        }

    }
}

