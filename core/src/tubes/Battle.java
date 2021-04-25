package tubes;

import java.util.*;

public class Battle {

    protected Engimon activeEngimon;
    protected Engimon enemyEngimon;
    protected double powerValueActiveEngimon;
    protected double powerValueEnemyEngimon;
    protected Player player;
    protected static int winExp = 50;

    public Battle(Player _player, Engimon eng1, Engimon eng2){
        this.player = _player;
        this.activeEngimon = eng1;
        this.enemyEngimon = eng2;
        powerValueActiveEngimon = getPowerValue(activeEngimon, enemyEngimon);
        powerValueEnemyEngimon = getPowerValue(enemyEngimon, activeEngimon);
        activeEngimon.displayInfo();
        enemyEngimon.displayInfo();
        System.out.println("Power Active Engimon: " + powerValueActiveEngimon);
        System.out.println("Power Enemy: " + powerValueEnemyEngimon);
        // Print Data engimon musuh
        // Menerima opsi masukan 
        Scanner input = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Apakah anda ingin bertarung? (yes/no) ");
        String option = input.nextLine();  // Read user input
        if (option.equals("yes")) bertarung();
        else if (option.equals("no")) System.out.println("Battle dibatalkan.");
        else System.out.println("Input tidak valid! Battle dibatalkan."); 
    }

    public void bertarung(){
        if (powerValueActiveEngimon > powerValueEnemyEngimon){
            System.out.println("Engimon anda menang!");
            win();
        }
        else { //powerValueActiveEngimon < powerValueEnemyEngimon
            System.out.println("Engimon anda kalah :(");
            lose();
        }
    }
    
    public int getIdx(String _element)
    {
        int idx; 
        if (_element == "Fire") idx = 0;
        else if (_element == "Water") idx = 1;
        else if (_element == "Electric") idx = 2;
        else if (_element == "Ground") idx = 3;
        else idx = 4; //Ice
        return idx;
    }
    public double getAdValues(Engimon eng1, Engimon eng2){
        ArrayList<String> elements1 = eng1.getElements(); 
        ArrayList<String> elements2 = eng2.getElements();

        //matriks element advantage values
        final double [][]AdValues = {{1,0,1,0.5,2}, {2,1,0,1,1}, {1,2,1,0,1.5}, {1.5,1,2,1,0}, {0,1,0.5,2,1}};
        if (elements1.get(1) == "none" && elements2.get(1) == "none"){
            int idxEng1 = getIdx(elements1.get(0));
            int idxEng2 = getIdx(elements2.get(0));
            //kombinasi nilai element advantages engimon 1
            double engValues = AdValues[idxEng1][idxEng2];
            return engValues;
        }
        else if (elements1.get(1) != "none" && elements2.get(1) == "none")
        {
            int idxEng1_1 = getIdx(elements1.get(0));
            int idxEng1_2 = getIdx(elements1.get(1));
    
            int idxEng2 = getIdx(elements2.get(0));
           //kombinasi nilai element anvantages engimon 1
            double engValues1 = AdValues[idxEng1_1][idxEng2];
            double engValues2 = AdValues[idxEng1_2][idxEng2];
            if  (engValues1 > engValues2)
            {
                return engValues1;
            }
            else
            {
                return engValues2;
            }
        }
        else if (elements1.get(1)== "none" && elements2.get(1) != "none")
        {
            int idxEng1 = getIdx(elements1.get(0));
            int idxEng2_1 = getIdx(elements2.get(0));
            int idxEng2_2 = getIdx(elements2.get(1));
            //kombinasi nilai element anvantages engimon 1
            double engValues1 = AdValues[idxEng1][idxEng2_1];
            double engValues2 = AdValues[idxEng1][idxEng2_2]; 
            if  (engValues1 > engValues2)
            {
                return engValues1;
            }
            else
            {
                return engValues2;
            }
        }
        else //elements[1] != "none" && elements2[1] != "none"
        {
            int idxEng1_1 = getIdx(elements1.get(0));
            int idxEng1_2 = getIdx(elements1.get(1));
            int idxEng2_1 = getIdx(elements2.get(0));
            int idxEng2_2 = getIdx(elements2.get(1));
            //kombinasi nilai element anvantages engimon 1
            double engValues1 = AdValues[idxEng1_1][idxEng2_1];
            double engValues2 = AdValues[idxEng1_1][idxEng2_2];
            double engValues3 = AdValues[idxEng1_2][idxEng2_1];
            double engValues4 = AdValues[idxEng1_2][idxEng2_2];
            double []engValList = {engValues1, engValues2, engValues3, engValues4};
            double max =  engValList[0];
            for (int i = 0; i < 4; i++){
                if (max < engValList[i]){
                    max = engValList[i];
                }
            }
            return max;
        }
        
    }

    public double getPowerValue(Engimon eng1, Engimon eng2){ 
        // Mengembalikan power engimon 1 saat berhadapan dengan engimon 2
        // jika ingin mendapatkan power engimon 2 gunakan getPowerValue(eng2, eng1)
        double engVal1 = getAdValues(eng1, eng2);
        ArrayList<Skill> skillEngimon1 = eng1.getSkills();
        double sumSkill1 = 0;

    
        for (int i = 0; i < skillEngimon1.size(); i++){
            sumSkill1 += (skillEngimon1.get(i)).getBasePower() * (skillEngimon1.get(i)).getMasteryLevel();
        }
        double powEngimon1 = (eng1.getLevel() * engVal1) + sumSkill1; //power engimon 1
        return powEngimon1;
    }

    public void win(){
        // Jika engimon player menang, player akan mendapatkan engimon yang menjadi lawan jika inventory masih cukup. 
        // Active engimon juga akan menerima experience points dengan besaran yang bebas (boleh statik atau menggunakan rumus tertentu). 
        // Player juga akan mendapatkan Skill Item yang berada skill di slot pertama dari engimon musuh.
        
        if(!player.isInventoryFull()){
            System.out.println("Engimon musuh menjadi milik anda!");
            player.addEngimon(enemyEngimon);
        }
        if(!player.isInventoryFull()){
            ArrayList<Skill> enemySkill = enemyEngimon.getSkills(); 
            player.addSkillItem(enemySkill.get(0));
            System.out.println("Anda mendapatkan skill musuh!");
        }  
        int baseExp = activeEngimon.getExp();
        activeEngimon.setExp(baseExp+winExp);
        
        activeEngimon.setCumExp(activeEngimon.getCumExp() + winExp);
        if (activeEngimon.getExp() > 100){
            activeEngimon.setExp(activeEngimon.getCumExp()-100);
            activeEngimon.setLevel(activeEngimon.getLevel()+1);
            System.out.println("Level Up!");
        }
        if (activeEngimon.getCumExp() >= 10000){
            System.out.println("Engimon  mencapai Exp maximum, Engimon dihapus dari Inventory");
            player.deleteEngimon(activeEngimon);

            //harus minta active engimon baru gak?
        }
    }

    public void lose(){
        // Jika engimon player kalah, engimon player akan kehilangan 1 life. 
        // Jika life dari engimon mencapai 0, engimon akan mati. 
        // Kemudian player dapat memilih command selanjutnya seperti biasa.
        this.activeEngimon.setLive(activeEngimon.getLive()-1);
        if (activeEngimon.getLive() == 0){
            //Engimon mati
            System.out.println("Engimon telah mati, Engimon dihapus dari inventory engimon");
            player.deleteEngimon(activeEngimon);
            if (!player.isInventoryEngimonEmpty()){
                System.out.println("Set active engimon! ");
                System.out.println("Inventory : ");
                player.showListEngimon();
                Scanner input = new Scanner(System.in);  // Create a Scanner object
                System.out.print("Pilih Engimon : ");
                String EngimonName = input.nextLine();
                while (!player.isEngimonExist(EngimonName)){
                    System.out.println("Tidak terdapat engimon dengan nama " + EngimonName + "!");
                    System.out.print("Pilih Engimon : ");
                    Scanner input2 = new Scanner(System.in);
                    EngimonName = input2.nextLine();
                }
                Engimon newActiveEngimon = player.InventEngimon.findItem(EngimonName);
                player.setActiveEngimon(newActiveEngimon);
            }
            else //Inventory Engimon Empty
            {
                System.out.print("Inventory Engimon kosong");
            }
        }
    }
    // public Engimon isEngimonNearby(ArrayList<Engimon> InventEngimon){}
}
