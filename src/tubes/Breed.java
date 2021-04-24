package tubes;

import java.util.*;


public class Breed {

    protected Engimon Engimon1;
    protected Engimon Engimon2;
    protected Player player;

    public Breed(Player _player, Engimon eng1, Engimon eng2){
        this.player = _player;
        this.Engimon1 = eng1;
        this.Engimon2 = eng2;
        Coordinate defaultCoordinate = new Coordinate(0,0);
        
        //Print detail kedua engimon
        eng1.displayInfo();
        eng2.displayInfo();

        // Cek requirement breeding
        if (eng1.getLevel() < 4 || eng2.getLevel() < 4){
            System.out.println("Level parent tidak mencukupi");
        }
        else{
            Scanner input = new Scanner(System.in);  // Create a Scanner object
            System.out.println("Masukkan nama engimon baru: ");
            String name = input.nextLine();  // Read user input
            
            ArrayList<String> elements1 =  new ArrayList<String>();
            ArrayList<String> elements2 =  new ArrayList<String>();
            elements1 = eng1.getElements();
            elements1 = eng2.getElements();
            String SpeciesInherited = "";

            double mastery1 = getAdValuesBreed(eng1,eng2);
            double mastery2 = getAdValuesBreed(eng1,eng2);

            // Inherit Elemen dan Species
            if (eng1.getElements().equals(eng2.getElements())){
                //anak akan memiliki elemen yang sama dengan kedua parent. Spesies anak dipilih dari parent A atau parent B secara bebas (boleh random atau aturan spesifik tertentu)
                //Spesies anak dipilih dari parent A atau parent B secara bebas (boleh random atau aturan spesifik tertentu)
                // bisa dirandom sementara ambil species engimon pertama
                SpeciesInherited = eng1.getSpecies();
            }
            else{
                // anak akan memiliki elemen dan spesies dari elemen yang memiliki element advantage yang lebih tinggi.
    
                if (mastery1>mastery2){
                    SpeciesInherited = eng1.getSpecies(); 
                }
                else if (mastery1<mastery2){
                    SpeciesInherited = eng2.getSpecies();
                }
            }

            if (SpeciesInherited.equals("Charmander")){
                Engimon NewEng = new Charmander(name,defaultCoordinate,0,false);
                
            }
            else if (SpeciesInherited.equals("Squirtle")){
                Engimon NewEng = new Squirtle(name,defaultCoordinate,0,false);
                
            }
            else if (SpeciesInherited.equals("Pikachu")){
                Engimon NewEng = new Pikachu(name,defaultCoordinate,0,false);
                
            }
            else if (SpeciesInherited.equals("Diglett")){
                Engimon NewEng = new Diglett(name,defaultCoordinate,0,false);
        
            }
            else if (SpeciesInherited.equals("Glalie")){
                Engimon NewEng = new Glalie(name,defaultCoordinate,0,false);
                
            }
            else{
                if (elements1.get(0).equals("Fire")&& elements2.get(0).equals("Electric")){
                        Engimon NewEng = new Rotom(name,defaultCoordinate,0,false);
                    }
                    else if (elements1.get(0).equals("Water") && elements2.get(0).equals("Ice")){
                        Engimon NewEng = new Lapras(name,defaultCoordinate,0,false);
                    }
                    else if (elements1.get(0).equals("Water") && elements2.get(0).equals("Ground")){
                        Engimon NewEng = new Wooper(name,defaultCoordinate,0,false);
                    }
            }

            //Inherit skills
            ArrayList<Skill> Skills1 = eng1.getSkills();
            ArrayList<Skill> Skills2 = eng2.getSkills();
            ArrayList<Skill> SkillsCompatible1 = new ArrayList<Skill>();
            ArrayList<Skill> SkillsCompatible2 = new ArrayList<Skill>();

            //get compatible skill from parent A
            for (int i =0; i<Skills1.size(); i++){
                if ( (Skills1.get(i).isElementSama(elements1.get(0)))  ){
                    //push skill ke skillcompatible1;
                    SkillsCompatible1.add(Skills1.get(i));
                }
            }
            //get compatible skill from parent B
            for (int i =0; i<Skills2.size(); i++){
                if ( (Skills2.get(i).isElementSama(elements2.get(0)))  ){
                    //push skill ke skillcompatible2;
                    SkillsCompatible2.add(Skills2.get(i));
                }
            }

            //Skill Pskill1 = new Skill();
            //Skill Pskill2 = new Skill();
            ArrayList<Skill> SkillsInherited = new ArrayList<Skill>();
            Boolean adaSkill = true;
            Boolean isEmpty1 = true;
            Boolean isEmpty2 = true;

            while ((SkillsCompatible1.size()!=0)||(SkillsCompatible2.size()!=0)){
                
                Skill CalonSkill1 = new Skill(SkillsCompatible1.get(0).getElements(), SkillsCompatible1.get(0).getBasePower(), SkillsCompatible1.get(0).getMasteryLevel(), SkillsCompatible1.get(0).getNama());
                //Get skill with max EM from Engimon1
                for (int i =0; i<SkillsCompatible1.size(); i++){
                    if ( (CalonSkill1.getMasteryLevel() < SkillsCompatible1.get(i).getMasteryLevel() )  ){
                        CalonSkill1 = SkillsCompatible1.get(i);
                        SkillsCompatible1.remove(i);
                        isEmpty1 = false;
                    }
                }

                Skill CalonSkill2 = new Skill(SkillsCompatible2.get(0).getElements(), SkillsCompatible2.get(0).getBasePower(), SkillsCompatible2.get(0).getMasteryLevel(), SkillsCompatible2.get(0).getNama());
                //Get skill with max EM from Engimon2
                for (int i =0; i<SkillsCompatible2.size(); i++){
                    if ( (CalonSkill2.getMasteryLevel() < SkillsCompatible2.get(i).getMasteryLevel() )  ){
                        CalonSkill2 = SkillsCompatible2.get(i);
                        SkillsCompatible2.remove(i);
                        isEmpty2 = false;
                    }
                }

                // Masukan skill pilihan ke arraylist skillinherited
                if ( (CalonSkill1.getMasteryLevel()==CalonSkill2.getMasteryLevel()) && (CalonSkill1.getNama()==CalonSkill2.getNama()) ){
                    //skill yang dipilih dimiliki oleh kedua parent:
                    //mastery level yang sama,skill yang di-inherit memiliki mastery level bernilai mastery level parent A + 1
                    CalonSkill1.SetEM(CalonSkill1.getMasteryLevel()+1);

                    SkillsInherited.add(CalonSkill1);
                }
                else if ( (CalonSkill1.getMasteryLevel()!=CalonSkill2.getMasteryLevel()) && (CalonSkill1.getNama()==CalonSkill2.getNama()) ) {
                    ////skill yang dipilih dimiliki oleh kedua parent:
                    //memiliki mastery level yang berbeda, 
                    //skill yang di-inherit memiliki mastery level bernilai max(mastery level parent A, mastery level parent B)
                    if (CalonSkill1.getMasteryLevel()>=CalonSkill2.getMasteryLevel()){
                        SkillsInherited.add(CalonSkill1);
                    }
                    else if (CalonSkill1.getMasteryLevel()<CalonSkill2.getMasteryLevel()){
                        SkillsInherited.add(CalonSkill2);
                    }  
                }
                else if ( (CalonSkill1.getMasteryLevel()==CalonSkill2.getMasteryLevel()) && (CalonSkill1.getNama()!=CalonSkill2.getNama()) ){
                    //Jika ada mastery level yang sama, skill dari Parent A diutamakan
                    // skill tidak dimiliki kedua parent
                    SkillsInherited.add(CalonSkill1);
                }
                else{   //masterylevel tidak sama dan hanya ada di 1 parent
                    if ((isEmpty1 != false) && (isEmpty2 == true)) {
                        SkillsInherited.add(CalonSkill1);
                    }
                    else {
                        SkillsInherited.add(CalonSkill2);
                    }
                }
            }   
            
            for (int i =0; i<SkillsInherited.size(); i++){
                NewEng.incSkills(SkillsInherited.get(i));
            } 
            NewEng.displayInfo();

        }
    }
    public int getIdxBreed(String _element)
    {
        int idx; 
        if (_element == "Fire") idx = 0;
        else if (_element == "Water") idx = 1;
        else if (_element == "Electric") idx = 2;
        else if (_element == "Ground") idx = 3;
        else idx = 4; //Ice
        return idx;
    }

    public double getAdValuesBreed(Engimon eng1, Engimon eng2){
        ArrayList<String> elements1 = eng1.getElements(); 
        ArrayList<String> elements2 = eng2.getElements();

        //matriks element advantage values
        final double [][]AdValues = {{1,0,1,0.5,2}, {2,1,0,1,1}, {1,2,1,0,1.5}, {1.5,1,2,1,0}, {0,1,0.5,2,1}};
        if (elements1.get(1) == "none" && elements2.get(1) == "none"){
            int idxEng1 = getIdxBreed(elements1.get(0));
            int idxEng2 = getIdxBreed(elements2.get(0));
            //kombinasi nilai element advantages engimon 1
            double engValues = AdValues[idxEng1][idxEng2];
            return engValues;
        }
        else if (elements1.get(1) != "none" && elements2.get(1) == "none")
        {
            int idxEng1_1 = getIdxBreed(elements1.get(0));
            int idxEng1_2 = getIdxBreed(elements1.get(1));
    
            int idxEng2 = getIdxBreed(elements2.get(0));
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
            int idxEng1 = getIdxBreed(elements1.get(0));
            int idxEng2_1 = getIdxBreed(elements2.get(0));
            int idxEng2_2 = getIdxBreed(elements2.get(1));
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
            int idxEng1_1 = getIdxBreed(elements1.get(0));
            int idxEng1_2 = getIdxBreed(elements1.get(1));
            int idxEng2_1 = getIdxBreed(elements2.get(0));
            int idxEng2_2 = getIdxBreed(elements2.get(1));
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
}