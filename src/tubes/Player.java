package tubes;

import java.util.*;

import tubes.Engimon;

public class Player {

    private Coordinate position = new Coordinate();
    private Engimon activeEngimon;

    public Inventory<Engimon> InventEngimon;
    public Inventory<Skill> InventSkill;
    private int maxCapacity = 30;

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

    public void learn(Engimon _engimon, Skill _skill){

    }

    /* 
    #mungkin klo mau nyoba biar ga usah pisah 2
    public void showInvent(Inventory<T> I) {
        I.printInventory();
    }
    */
    public void showListSkillItem() {
        InventSkill.printInventory();
        /*ArrayList temp = InventSkil.returnItem();
        for (int i = 0 ; i<temp.size() ; i++) {

        }*/
    }

    public void showListEngimon() {
        InventEngimon.printInventory();
    }

    public void showDataEngimon(Engimon _engimon){}//Ini bukan displayInfo() di Engimon???
    public void showDataSkillItem(Skill _skill){}
    // public void battle(Engimon *eng1, Engimon eng2, vector<Engimon>* list_enemies){}
    // Return type BuildNewEng diubah biar bisa assign objek aslinya, bukan pointer ke objek itu.
    // public Engimon BuildNewEng(String nama,String species){}
    /*public void breed(Engimon _engimon1, Engimon _engimon2, String engimonName) {
        // Fire/Electric
        if ((_engimon1.getElements().get(0).equals("Fire") && _engimon2.getElements().get(0).equals("Electric")) || (_engimon1.getElements().get(0).equals("Electric") && _engimon1.getElements().get(0).equals("Fire"))) {
            Engimon newEng = new Rotom(engimonName, new Coordinate(2,2), 1, false);
        }
        // Water/Ice
        else if ((_engimon1.getElements().get(0).equals("Water") && _engimon2.getElements().get(0).equals("Ice")) || (_engimon1.getElements().get(0).equals("Ice") && _engimon1.getElements().get(0).equals("Water"))) {
            Engimon newEng = new Lapras(engimonName, new Coordinate(2,2), 1, false);
        }
        // Water/Ground
        else if ((_engimon1.getElements().get(0).equals("Water") && _engimon2.getElements().get(0).equals("Ground")) || (_engimon1.getElements().get(0).equals("Ground") && _engimon1.getElements().get(0).equals("Water"))) {
            Engimon newEng = new Wooper(engimonName, new Coordinate(2,2), 1, false);
        }
        // // Fire
        // else if (){}
    }
    */
    public void deleteEngimon(Engimon eng){
        InventEngimon.removeItem(eng, 1);
    }

    public void addEngimon(Engimon _engimon){
        InventEngimon.addItem(_engimon, 1);
    }
    public void addSkillItem(Skill _skill){
        InventSkill.addItem(_skill, 1);
    }
    public Boolean isInventoryFull(){
        return (InventEngimon.getJumlahInventory() + InventSkill.getJumlahInventory() == this.maxCapacity);
    }
    public Engimon findEngimon(String name){
        return (InventEngimon.findItem(name));
    }
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
    }
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


