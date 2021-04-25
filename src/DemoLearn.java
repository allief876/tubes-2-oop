import tubes.*;
import java.util.*;
public class DemoLearn {
    public static void main (String[] args) {
        Coordinate pos1 = new Coordinate(1,1);
        Coordinate pos2 = new Coordinate(1,2);
        Coordinate pos0 = new Coordinate(2,1);
        Player P = new Player(pos0);
        //Engimon(String name, String species, String element1, String element2, String slogan, Coordinate spawn, Integer level, Boolean isWildEngimon)
        Scanner input = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Masukkan nama Engimon1: ");
        String name = input.nextLine();  // Read user input

        Engimon E1 = new Charmander("Parent1", pos1, 5,false);
        Engimon E2 = new Lapras("Parent2", pos2, 5,false);
        P.addEngimon(E1);
        P.addEngimon(E2);
        P.setActiveEngimon(E1);
        // tambahin 1 skill dulu gan biar bisa dipelajari
        System.out.println("Ini skill sebelumnya");
        System.out.println(E1.getSkills().size());
        E1.printSkills();
        //P.InventSkill.addItem(E2.getSkills().get(0), 1);
        System.out.println(P.isEngimonExist("Parent1"));
        Learn learn = new Learn(P,P.findEngimon(name.toString()));

        System.out.println("Ini skill sesudah");
        
        System.out.println(E1.getSkills().size());
        E1.printSkills();
        
    }
}
