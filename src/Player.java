public class Player {

    private Coordinate position = new Coordinate();
    private Engimon activeEngimon;

    private Inventory<Engimon> InventEngimon;
    private Inventory<Skill> InventSkill;
    private int maxCapacity = 30;

    //Player();
    public Player(Coordinate coor){
        this.position.x = coor.x;
        this.position.y = coor.y;
        this.InventEngimon = new Inventory<Engimon>();
        this.InventSkill = new Inventory<Skill>();
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

    /* 
    #mungkin klo mau nyoba biar ga usah pisah 2
    public void showInvent(Inventory<T> I) {
        I.printInventory();
    }
    */
    public void showListSkillItem() {
        InventSkill.printInventory();
    }

    public void showListEngimon() {
        InventEngimon.printInventory();
    }

    public void showDataEngimon(Engimon _engimon){}//Ini bukan displayInfo() di Engimon???
    public void showDataSkillItem(Skill _skill){}
    // public void battle(Engimon *eng1, Engimon eng2, vector<Engimon>* list_enemies){}
    // Return type BuildNewEng diubah biar bisa assign objek aslinya, bukan pointer ke objek itu.
    // public Engimon BuildNewEng(String nama,String species){}
    public void breed(Engimon _engimon1, Engimon _engimon2, String engimonName) {
        // Fire/Electric
        if ((_engimon1.getElements().get(0).equals("Fire") && _engimon2.getElements().get(0).equals("Electric")) || (_engimon1.getElements().get(0).equals("Electric") && _engimon1.getElements().get(0).equals("Fire"))) {
            Engimon newEng = new Rotom(engimonName, new Coordinate(2,2), 1);
        }
        // Water/Ice
        else if ((_engimon1.getElements().get(0).equals("Water") && _engimon2.getElements().get(0).equals("Ice")) || (_engimon1.getElements().get(0).equals("Ice") && _engimon1.getElements().get(0).equals("Water"))) {
            Engimon newEng = new Lapras(engimonName, new Coordinate(2,2), 1);
        }
        // Water/Ground
        else if ((_engimon1.getElements().get(0).equals("Water") && _engimon2.getElements().get(0).equals("Ground")) || (_engimon1.getElements().get(0).equals("Ground") && _engimon1.getElements().get(0).equals("Water"))) {
            Engimon newEng = new Wooper(engimonName, new Coordinate(2,2), 1);
        }
        // // Fire
        // else if (){}
    }
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
    // public double getAdValues(Engimon eng1, Engimon eng2){}
    // public int getIdx(String _element){} //untuk mendapatkan indeks pada tabel advantages values
    //public boolean isInventoryEngimonEmpty(){}
    //public Engimon isEngimonNearby(ArrayList<Engimon> InventEngimon){}
    //public Engimon findEngimon(String _name){}
    //public Skill findSkill(String _name){}
};


