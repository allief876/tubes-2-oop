import java.util.*;
class Skill {

    private ArrayList<String> Elements; 
    private Integer BasePower;
    private Integer MasteryLevel;
    private String Nama;

    public Skill(ArrayList<String> _elements, int _basePower, int _masteryLevel, String _nama) {
        this.Elements = _elements;
        this.BasePower = _basePower;
        this.MasteryLevel = _masteryLevel;
        this.Nama = _nama;
    }

    @Override
    //Ini buat tampilin data yang muncul saat printInventory()
    public String toString(){
        return ("Nama: "+ this.getNama() + "\n");
    }

    public Integer getBasePower() {
        return this.BasePower;
    }

    public Integer getMasteryLevel() {
        return this.MasteryLevel;
    }

    public String getNama() {
        return this.Nama;
    }

    public void printDetail() {
        System.out.println("Skill Name\t:" + this.Nama);
        System.out.println("Element 1\t: " + Elements.get(0));
        System.out.println("Element 2\t: " + Elements.get(1));
        System.out.println("Base Power\t: " + this.BasePower);
        System.out.println("Mastery Level\t: " + this.MasteryLevel);
    }

    public Boolean isElementSama(String _element) {
        for (int i = 0 ; i < 2 ; i++) {
            if (Elements.get(i) == _element) {
                return true;
            }
        }
        return false;
    }

    public void SetEM(int newEM) {
        this.MasteryLevel = newEM;
    }

    public Boolean CheckMasteryLevel() {
        return (MasteryLevel <= 3);
    }

    /*
    List skill:
    0. Spesies - Skill
    1. Charmander - Pyro Ball (unik ke Charmender)
    2. Squirtle - Waterfall (unik ke Squirtle)
    3. Pikachu - Thunderbolt (unik ke Pikachu)
    4. Diglett - Max Quake (unik ke Diglett)
    5. Glalie - Freeze Shock (unik ke Glalie)
    6. Rotom - Overloaded (unik ke Rotom)
    7. Lapras - Frozen (unik ke Lapras)
    8. Wooper - Crystalize (unik ke Wooper)
    */

}
