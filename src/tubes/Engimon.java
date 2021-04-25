package tubes;

import java.util.*;

public abstract class Engimon {
    protected String Name;                          // Nama engimon, default = engimon
    protected Coordinate Position = new Coordinate();
    protected String Species;                       //  spesies engimon, default = species
    protected ArrayList<String> Parent;             // nama parent engimon, jika tidak ada parent tetap buat element kosong
    protected ArrayList<Skill> Skills;              // array of skill engimon
    protected ArrayList<String> Elements;           // array of elements engimon
    protected Integer Level;                        // level engimon, default = 0
    protected Integer Exp;                          // exp engimon, default = 0
    protected Integer CumExp;                       // cumulative exp sebelom mati, default = 0
    protected static final Integer MaxExp = 10000;  // max exp sampai mati
    protected String Slogan;                        // text yang dikirim engimon saat berinteraksi
    protected Integer Live;
    protected Boolean isWildEngimon;
    protected static Integer JumlahWildEngimon = 0;
    protected static Integer LevelTertinggiEngimonNonWild = 1; 
    protected static final Integer JumlahMaxWildEngimon = 20;   // Jumlah wild engimon maksimal dalam peta
    
    /*
    public Engimon() {
        // Engimon dummy
        this.Name = "none";
        this.Species = "species";
        this.Slogan = "none";
        this.Level = 1;
        this.Exp = 0;
        this.CumExp = 0;
        this.Live = 3;
        this.isWildEngimon = false;
        // Inisialisasi array list Elements
        this.Elements = new ArrayList<String>();
        this.Elements.add("none");
        this.Elements.add("none"); 
        // Inisialisasi array list Parent
        this.Parent = new ArrayList<String>();
        Parent.add("none");
        // Inisialisasi array list Skills
        this.Skills = new ArrayList<Skill>();
        // Inisialisasi Coordinate 
        this.Position = new Coordinate(0,0);
     } */
    
    public Engimon(String name, String species, String element1, String element2, String slogan, Coordinate spawn, Integer level, Boolean isWildEngimon) {
        this.Name = name;
        this.Species = species;
        this.Slogan = slogan;
        this.Level = level;
        this.Exp = 0;
        this.CumExp = 0;
        this.Live = 3; 
        this.isWildEngimon = isWildEngimon;
        if (isWildEngimon) {
            JumlahWildEngimon++;
        } 
        // Inisialisasi array list Elements
        this.Elements = new ArrayList<String>();
        this.Elements.add(element1);
        this.Elements.add(element2); 
        // Inisialisasi array list Parent
        this.Parent = new ArrayList<String>();
        Parent.add("none");
        // Inisialisasi array list Skills
        this.Skills = new ArrayList<Skill>();
        // Inisialisasi Coordinate 
        this.Position.setCoordinate(spawn.x,spawn.y);
    } //c user-defined ctor
    
    
    public void displayInfo(){
        System.out.println("Name\t\t: " + this.Name);
        System.out.println("Experience\t: "+this.Exp+"/100");
        System.out.println("Level\t\t: "+ this.Level);
        System.out.println("Live\t\t: "+ this.Live);
        System.out.println("Species\t\t: " + this.Species);
        if (Parent.get(0) != "none") {
            System.out.println("Parent\t\t: " + Parent.get(0) + " and " + Parent.get(1));
        }
        else {
            System.out.println("Engimon tidak memiliki Parent");
        }
        System.out.println("Skills\t\t: ");
        printSkills();
        System.out.println();        
        /**System.out.print("Elements\t: " + Elements.get(0));
        if (!this.Elements.get(1).equals("none")) {
            System.out.println(" and " + Elements.get(1));
        }*/
        System.out.println(); 
    } // tampilin semua data engimon
    
    @Override
    //Ini buat tampilin data yang muncul saat printInventory()
    public String toString(){
        return this.getName();
        //return ("Nama: "+ this.getName() + 
        //        "\n Species: "+ this.getSpecies() + 
        //        "\n Level: " +this.getLevel()+"\n");
    }

    //Getter
    public final String getName() {
        return this.Name;
    }
    
    public final void setName(String name) {
        this.Name = name;
    }
    public final Coordinate getPosition() {
        return this.Position;
    }
    
    public final String getSpecies() {
        return this.Species;
    }
    
    public final ArrayList<String> getParent() throws NoParentException {
        if (Parent.get(0) == "none") {
            throw new NoParentException();
        }
        else {
            return Parent;
        }
    }
    
    public final ArrayList<Skill> getSkills() { 
       return this.Skills;
    }
    
    public final ArrayList<String> getElements() {
        return this.Elements;
    }
    
    public final Integer getLevel() {
        return this.Level;
    }
    
    public final Integer getExp() {
        return this.Exp;
    }
    
    public final Integer getCumExp() {
        return this.CumExp;
    }
    
    public final String getSlogan() {
        return this.Slogan;
    }

    public final Integer getLive() {
        return this.Live;
    }

    public final Boolean getIsWildEngimon() {
        return this.isWildEngimon;
    }
    
    // Setter
    public void setPositionEng(Coordinate z){
        this.Position = z;
    }
    
    public void setParent(String parent1, String parent2) {
        while (this.Parent.size()>0){
            this.Parent.remove(0);
            System.out.println("Remove Parent ");
        }
        this.Parent.add(parent1);
        this.Parent.add(parent2);
    }
    
    public void incSkills(Skill skill) {
        Skills.add(skill);
        // cout << "sekarang size skills = " << Skills.size() << endl;
    }
    public void removeSkill(String skill) {
        //bentar wait implementasinya buat learn
        
    }
    
    public void replaceSkills(Skill old_skill, Skill new_skill) {
        Skills.remove(old_skill);
        Skills.add(new_skill);
    }
    
    public void setLevel(Integer _level) {
        this.Level = _level;
        if (_level > LevelTertinggiEngimonNonWild) setLevelTertinggiEngimonNonWild(_level);;
    }

    protected static void setLevelTertinggiEngimonNonWild(Integer _level) {
        LevelTertinggiEngimonNonWild = _level;
    }
    
    public void setExp(Integer _experience) {
        this.Exp = _experience;     
    }
    
    public void setCumExp(Integer _cumulativeExp) {
        this.CumExp = _cumulativeExp;
    }

    public void setLive(Integer _live) {
        this.Live = _live;
    }

    public void setIsWildEngimon(Boolean _isWildEngimon) {
        this.isWildEngimon = _isWildEngimon;
    }
    
    // Lain
    public boolean isUpgradeable() {
        if (getCumExp() >= getLevel()*100) {
            return true;
        }
        else {
            return false;
        }
    }
    
    public void printSkills(){
        if (Skills.size()!=0){
            for (int i = 0; i<Skills.size(); i++) {
                System.out.println(i+1 + ". " + Skills.get(i).getNama() + ", Mastery level = " + Skills.get(i).getMasteryLevel());
                System.out.print("Elements: " + Skills.get(i).getElements().get(0));
                
                if (!Skills.get(i).getElements().get(1).equals("none")) {
                    System.out.println(" and " + Skills.get(i).getElements().get(1));
                }
                System.out.println();
            }
        } 
    } 

    public void upgradeEngimon() {
        while (isUpgradeable()) {
            this.setLevel(this.getLevel()+1);
            this.setExp(this.getExp()-100);
        }
    }
    public void interactEngimon() {
        System.out.println(this.Slogan);
    }
}