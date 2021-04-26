package tubes;

import java.util.*;

import tubes.Skill;


public class Player {

    private Coordinate position = new Coordinate();
    private Engimon activeEngimon;

    public Inventory<Engimon> InventEngimon;
    public Inventory<Skill> InventSkill;
    private int maxCapacity = 20;

    //Player();
    public Player(Coordinate coor){
        this.position.x = coor.x;
        this.position.y = coor.y;
        this.InventEngimon = new Inventory<Engimon>();
        this.InventSkill = new Inventory<Skill>();
    }
    //void move(char, Map);
    public void setPositionPlayer(Coordinate z){
        this.position.x = z.x;
        this.position.y = z.y;
    }
    public Coordinate getPlayerPosition(){
        return this.position;
    }

    public void setActiveEngimon(Engimon _engimon){
        if (this.activeEngimon != null){
            //this.activeEngimon.displayInfo();
            //System.out.println(this.activeEngimon.getPosition().x);
            Coordinate temp = this.activeEngimon.getPosition();
            //System.out.println(temp.x +"'"+temp.y);
            System.out.println(_engimon);
            _engimon.setPositionEng(temp);
        }
        this.activeEngimon = _engimon;
    }
    public void setEngPos(Coordinate z){
        this.activeEngimon.Position = z;
    }
    public Engimon getActiveEngimon(){
        return this.activeEngimon;
    }

    public void changeNameEngimon (String nameEngimon, String namaBaru) {
        (this.InventEngimon.findItem(nameEngimon)).setName(namaBaru);
    }
    /* 
    #mungkin klo mau nyoba biar ga usah pisah 2
    public void showInvent(Inventory<T> I) {
        I.printInventory();
    }
    */
    public void showListSkillItem() {
        //InventSkill.printInventory();
        ArrayList<Skill> temp = sortBasePower(InventSkill.returnItem());
        for (int i = 0 ; i<temp.size() ; i++) {
            System.out.println("Amount\t: "+InventSkill.getAmount(temp.get(i)));
            temp.get(i).printDetail();
        }
    }
    public void showPreviewSkillItem() {
        //InventSkill.printInventory();
        ArrayList<Skill> temp = sortBasePower(InventSkill.returnItem());
        for (int i = 0 ; i<temp.size() ; i++) {
            System.out.print(InventSkill.getAmount(temp.get(i))+"x ");
            System.out.println(temp.get(i).getNama());
        }
    }
    public boolean CheckSkillCompatible(Engimon eng, String namaskill) {
        //InventSkill.printInventory();
        boolean true1 = false;
        boolean true2 = false;
        ArrayList<Skill> Skills1 = new ArrayList<Skill>(eng.getSkills());
        for (int i = 0 ; i<Skills1.size() ; i++) {
            // cari skill yg sesuai dengan nama
            if (Skills1.get(i).getNama().equals(namaskill)){
                //pastikan element skill sesuai dengan element engimon
                if (Skills1.get(i).isElementSama(eng.getElements().get(0))){
                    true1 = true;
                }
                if (Skills1.get(i).isElementSama(eng.getElements().get(1))){
                    true2 = true;
                }
            }
        }
        return (true1 || true2);
    }
    public ArrayList<Skill> sortBasePower(ArrayList<Skill> input){
        ArrayList <Skill> result = new ArrayList<Skill>();
        ArrayList <Integer> basePower = new ArrayList<Integer>();
        for (int i = 0 ; i<input.size() ; i++){
            basePower.add(input.get(i).getBasePower());
        }
        Collections.sort(basePower, Collections.reverseOrder());

        while (basePower.size() != 0) {
            for (int j = 0 ; j < input.size() ; j++ ) {
                if(basePower.get(0) == (input.get(j)).getBasePower()) {
                    result.add(input.get(j));
                    input.remove(j);
                    basePower.remove(0);
                }
            }
        }
        return result;
    }
    /*public ArrayList<Skill> sortInventorySkillItem(){
        ArrayList <Skill> temp = sortBasePower(InventSkill.returnItem());

    }*/
    
    public ArrayList<Engimon> sortLevel (ArrayList<Engimon> input){
        ArrayList <Engimon> result = new ArrayList<Engimon>();
        ArrayList <Integer> level = new ArrayList<Integer>();
        for (int i = 0 ; i<input.size() ; i++){
            level.add(input.get(i).getLevel());
        }
        Collections.sort(level, Collections.reverseOrder());

        while (level.size() != 0) {
            for (int j = 0 ; j < input.size() ; j++ ) {
                if(level.get(0) == input.get(j).getLevel()) {
                    result.add(input.get(j));
                    input.remove(j);
                    level.remove(0);
                }
            }
        }
        return result;
    }
    public ArrayList<Engimon> sortInventory(){
        ArrayList <Engimon> temp = InventEngimon.returnItem();
        ArrayList <Engimon> result = new ArrayList<Engimon>();
        ArrayList <Engimon> fire = new ArrayList<Engimon>();
        ArrayList <Engimon> water = new ArrayList<Engimon>();
        ArrayList <Engimon> electric = new ArrayList<Engimon>();
        ArrayList <Engimon> ground = new ArrayList<Engimon>();
        ArrayList <Engimon> ice= new ArrayList<Engimon>();
        ArrayList <Engimon> fireElectric= new ArrayList<Engimon>();
        ArrayList <Engimon> waterIce = new ArrayList<Engimon>();
        ArrayList <Engimon> waterGround = new ArrayList<Engimon>();
        for (int i = 0 ; i<temp.size() ; i++){
            if ((((temp.get(i)).getElements()).get(0)).equals("Fire")) {
                //fire electric
                if (((temp.get(i).getElements()).get(1)).equals("Electric")){
                    fireElectric.add(temp.get(i));
                }
                //fire
                else {
                    fire.add(temp.get(i));
                }
            }
            else if ((((temp.get(i)).getElements()).get(0)).equals("Water")) {
                //water ice
                if (((temp.get(i).getElements()).get(1)).equals("Ice")){
                    waterIce.add(temp.get(i));
                }
                //water ground
                else if(((temp.get(i).getElements()).get(1)).equals("Ground")){
                    waterGround.add(temp.get(i));
                }
                //water
                else {
                    water.add(temp.get(i));
                }
            }
            else if ((((temp.get(i)).getElements()).get(0)).equals("Electric")) {
                //electric
                electric.add(temp.get(i));
            }
            else if ((((temp.get(i)).getElements()).get(0)).equals("Ground")) {
                //ground
                ground.add(temp.get(i));
            }
            else if ((((temp.get(i)).getElements()).get(0)).equals("Ice")) {
                // ice
                ice.add(temp.get(i));
            }   
        }
        fireElectric = sortLevel(fireElectric);
        waterIce = sortLevel(waterIce);
        waterGround = sortLevel(waterGround);
        fire = sortLevel(fire);
        water = sortLevel(water);
        electric = sortLevel(electric);
        ground = sortLevel(ground);
        ice = sortLevel(ice);
        result.addAll(fire);
        result.addAll(water);
        result.addAll(electric);
        result.addAll(ground);
        result.addAll(ice);
        result.addAll(fireElectric);
        result.addAll(waterIce);
        result.addAll(waterGround);
        return result;
    }
    public void showPreviewEngimon() {
        ArrayList<Engimon> temp = sortInventory();
        for (int i = 0 ; i<temp.size() ; i++) {
            System.out.print(temp.get(i).getName()+" / ");
            System.out.print(temp.get(i).getElements().get(0));
            if (!temp.get(i).getElements().get(1).equals("none")) {
                System.out.print(" and " + temp.get(i).getElements().get(1)+ " / ");
            }
            else {
                System.out.print(" / ");
            }
            System.out.println("Lv."+temp.get(i).getLevel());
        }
    }
    public void showListEngimon() {
        //InventEngimon.printInventory();
        ArrayList<Engimon> temp = sortInventory();
        for (int i = 0 ; i<temp.size() ; i++) {
            System.out.println("Nama\t: "+temp.get(i).getName());
            System.out.println("Level\t: "+temp.get(i).getLevel());
            System.out.println("Live\t: "+ temp.get(i).getLive());
            try{
                if (!temp.get(0).getParent().equals("none")) {
                    System.out.println("Parent\t\t: " + temp.get(0).getParent().get(0) + " and " + temp.get(0).getParent().get(1));
                }
            } catch (NoParentException e){
                System.out.println("Engimon tidak memiliki Parent");
            }
            System.out.println("Species\t: "+temp.get(i).getSpecies());
            System.out.print("Elements: " + temp.get(i).getElements().get(0));
            if (!temp.get(i).getElements().get(1).equals("none")) {
                System.out.println(" and " + temp.get(i).getElements().get(1));
            }
            else {
                System.out.println();
            }
            System.out.println("Skills: ");
            temp.get(i).printSkills();
            System.out.println();
        }
    }

    //public void showDataEngimon(Engimon _engimon){}//Ini bukan displayInfo() di Engimon???
    //public void showDataSkillItem(Skill _skill){}

    public void deleteEngimon(Engimon eng){
        InventEngimon.removeItem(eng, 1);
    }

    public void addEngimon(Engimon _engimon){
        if (isInventoryFull()){
            System.out.println("Inventory Penuh, engimon gagal ditambahkan");
        }
        else{
            InventEngimon.addItem(_engimon, 1);
        }
        
    }
    public void addSkillItem(Skill _skill){
        if (isInventoryFull()){
            System.out.println("Inventory Penuh, skill gagal ditambahkan");
        }
        else{
            InventSkill.addItem(_skill, 1);  
        }
        
    }
    public Boolean isInventoryFull(){
        return (InventEngimon.getJumlahInventory() + InventSkill.getJumlahInventory() == this.maxCapacity);
    }
    public Engimon findEngimon(String name){
        return (InventEngimon.findItem(name));
    }
    
    /*
    public boolean isEngimonExist(String name){
        boolean result = false;
        ArrayList<Engimon> temp = InventEngimon.returnItem();
        for (int i = 0; i < temp.size(); i++){
            if (name == ((temp.get(i)).getName())){
                result = true;
                break;
            }
        }
        return result;
    }*/
    
    public Boolean isInventoryEngimonEmpty(){
        return (InventEngimon.getJumlahInventory() == 0);
    }

    public Integer getHighestLevel() {
        Integer max = -1;
        ArrayList<Engimon> temp = InventEngimon.returnItem();
        for (int i = 0 ; i < temp.size() ; i++) {
            if (max < temp.get(i).getLevel()) {
                max = temp.get(i).getLevel();
            }
        }
        return max;
    }

    public Skill findSkill(String name){
        return(InventSkill.findItem(name));
    }

    public Engimon isEngimonNearby(ArrayList<Engimon> wildEng){
        ArrayList<Engimon> temp = this.InventEngimon.returnItem();
        int i = getPlayerPosition().x - 1;
        int j = getPlayerPosition().y - 1;
        int k;
        while (i <= getPlayerPosition().x + 1) {
            while (j <= getPlayerPosition().y + 1) {
                for (k = 0; k < wildEng.size(); k++) {
                    if (wildEng.get(k).getPosition().x == i && wildEng.get(k).getPosition().y == j) {
                        return wildEng.get(k);
                    }
                }
                j++;
            }
            j = getPlayerPosition().y-1;
            i++;
        }
        Engimon E = new Charmander("none", new Coordinate(0,0),0,false);
        return E;
        
    }
    
    public void lepasEngimon (String namaEngimon) {
        InventEngimon.removeItem(InventEngimon.findItem(namaEngimon), 1);
    }
    
    public void lepasSkillItem (String namaSkillItem, int quantity) {
        InventSkill.removeItem(InventSkill.findItem(namaSkillItem), quantity);
    }
    public boolean isEngimonExist (String nama){
        if (InventEngimon.findItem(nama) != null) {
            return true;
        }
        else{
            return false;
        }
    }
    /*int i = getPlayerPosition().x-1;
    int j = getPlayerPosition().y-1;
    int k;
    while (i <= getPlayerPosition().x+1){
        while(j <= getPlayerPosition().y+1){
            for (k = 0; k < enemies.size(); k++){
                if (enemies[k].getPosition().x == i && enemies[k].getPosition().y == j){
                    return enemies[k];
                }
            }
            j++;
        }
        j = getPlayerPosition().y-1;
        i++;
    }
    Engimon *E = new Engimon();
    return *E; */
};


