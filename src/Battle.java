public class Battle {
    public Battle(){
    public  battle(Engimon *eng1, Engimon eng2, vector<Engimon>* list_enemies){}
    public double getAdValues(Engimon eng1, Engimon eng2){
        // Elements Advantages (Fire, Water, Electric, Ground, Ice)
        
        // int FirexFire = 1; int WaterxWater = 1; int ElectricxElectric = 1; int GroungxGround = 1; int IcexIce = 1;
        // int FirexWater = 0 ; int FirexElectric = 1; int FirexGroung = 0.5; int FirexIce = 2; 
        // int WaterxFire = 2; int WaterxElectric = 0; int WaterxGround = 1; int WaterxIce = 1;
        // int ElectricxFire = 1; int ElectricxWater = 2; int ElectricxGroung = 0; int ElectricxIce = 1.5;
        // int GroundxFire = 1.5; int GroundxWater = 1; int GroundxElectric = 2; int GroundxIce = 0; 
        // int IcexFire = 0; int IcexWater = 1; int IcexElectric = 0.5; int IcexGroung = 2;
        vector<string> elements1; elements1.push_back(eng1.getElements()[0]); elements1.push_back(eng1.getElements()[1]);
        vector<string> elements2; elements2.push_back(eng1.getElements()[0]); elements2.push_back(eng1.getElements()[1]);
       
        // elements1 = eng1.getElements();
        // elements2 = eng2.getElements();
        //matriks element advantage values
        double AdValues[5][5] = {{1,0,1,0.5,2}, {2,1,0,1,1}, {1,2,1,0,1.5}, {1.5,1,2,1,0}, {0,1,0.5,2,1}};
        if (elements1[1] == "none" && elements2[1] == "none"){
            int idxEng1 = getIdx(elements1[0]);
            int idxEng2 = getIdx(elements2[0]);
            //kombinasi nilai element advantages engimon 1
            double engValues = AdValues[idxEng1][idxEng2];
            return engValues;
        }
        else if (elements1[1] != "none" && elements2[1] == "none")
        {
            int idxEng1_1 = getIdx(elements1[0]);
            int idxEng1_2 = getIdx(elements1[1]);
    
            int idxEng2 = getIdx(elements2[0]);
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
        else if (elements1[1] == "none" && elements2[1] != "none")
        {
            int idxEng1 = getIdx(elements1[0]);
            int idxEng2_1 = getIdx(elements2[0]);
            int idxEng2_2 = getIdx(elements2[1]);
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
            int idxEng1_1 = getIdx(elements1[0]);
            int idxEng1_2 = getIdx(elements1[1]);
            int idxEng2_1 = getIdx(elements2[0]);
            int idxEng2_2 = getIdx(elements2[1]);
            //kombinasi nilai element anvantages engimon 1
            double engValues1 = AdValues[idxEng1_1][idxEng2_1];
            double engValues2 = AdValues[idxEng1_1][idxEng2_2];
            double engValues3 = AdValues[idxEng1_2][idxEng2_1];
            double engValues4 = AdValues[idxEng1_2][idxEng2_2];
            double engValList[4] = {engValues1, engValues2, engValues3, engValues4};
            double max =  engValList[0];
            for (int i = 0; i < 4; i++){
                if (max < engValList[i]){
                    max = engValList[i];
                }
            }
            return max;
        }
        
    }
    // public int getIdx(String _element){} //untuk mendapatkan indeks pada tabel advantages values
    // public boolean isInventoryEngimonEmpty(){}
    // public Engimon isEngimonNearby(ArrayList<Engimon> InventEngimon){}
    // public Engimon findEngimon(String _name){}
    // public Skill findSkill(String _name){}
    }
}
