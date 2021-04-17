public class Player {

    private Coordinate position;
    private Engimon activeEngimon;
    //Inventory<Engimon> *inventoryEngimon;
    //Inventory<Skill> *inventorySkill;

    private Inventory<Engimon> InventEngimon;
    private Inventory<Skill> InventSkill;
    private int maxCapacity = 30;

    //Player();
    public Player(int x, int y){
        this.position.x = x;
        this.position.y = y;
    }
    //void move(char, Map);
    public void setPosition(Coordinate z){
        this.position.x = z.x;
        this.position.y = z.y;
    }
    public Coordinate getPlayerPosition(){
        return this.position;
    }
    public void setActiveEngimon(Engimon _engimon){
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

    public void showListSkillItem() {
        InventSkill.printInventory();
    }

    public void showListEngimon(){} 
    public void showDataEngimon(Engimon _engimon){}
    public void showDataSkillItem(Skill _skill){}
    // public void battle(Engimon *eng1, Engimon eng2, vector<Engimon>* list_enemies){}
    // Return type BuildNewEng diubah biar bisa assign objek aslinya, bukan pointer ke objek itu.
    // public Engimon BuildNewEng(String nama,String species){}
    // public void breed(Engimon _engimon1, Engimon _engimon2){}
    public void addEngimon(Engimon _engimon){
        InventEngimon.addItem(_engimon, 1);
    }
    public void addSkillItem(Skill _skill){
        InventSkill.addItem(_skill, 1);
    }
    public Boolean isInventoryFull(){
        return (InventEngimon.getJumlahInventory() + InventSkill.getJumlahInventory() == this.maxCapacity);
    }
    // public double getAdValues(Engimon eng1, Engimon eng2){}
    // public int getIdx(String _element){} //untuk mendapatkan indeks pada tabel advantages values
    //public boolean isInventoryEngimonEmpty(){}
    //public Engimon isEngimonNearby(ArrayList<Engimon> InventEngimon){}
    //public Engimon findEngimon(String _name){}
    //public Skill findSkill(String _name){}
};


