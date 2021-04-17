import java.util.ArrayList;

public class Battle {

    protected Engimon activeEngimon;
    protected Engimon enemyEngimon;
    protected double powerValueActiveEngimon;
    protected double powerValueEnemyEngimon;
    public Battle(Engimon eng1, Engimon eng2){
        this.activeEngimon = eng1;
        this.enemyEngimon = eng2;
        powerValueActiveEngimon = getPowerValue(activeEngimon, enemyEngimon);
        powerValueEnemyEngimon = getPowerValue(enemyEngimon, activeEngimon);
        if (powerValueActiveEngimon > powerValueEnemyEngimon){
            //Menang
        }
        else{ //powerValueActiveEngimon < powerValueEnemyEngimon
            //Kalah
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
    // public int getIdx(String _element){} //untuk mendapatkan indeks pada tabel advantages values
    // public boolean isInventoryEngimonEmpty(){}
    // public Engimon isEngimonNearby(ArrayList<Engimon> InventEngimon){}
    // public Engimon findEngimon(String _name){}
    // public Skill findSkill(String _name){}
}
