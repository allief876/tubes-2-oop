import tubes.*;
public class DemoBreed {
    public static void main (String[] args) {
        Coordinate pos1 = new Coordinate(1,1);
        Coordinate pos2 = new Coordinate(1,2);
        Coordinate pos0 = new Coordinate(2,1);
        Player P = new Player(pos0);
        //Engimon(String name, String species, String element1, String element2, String slogan, Coordinate spawn, Integer level, Boolean isWildEngimon)
        Engimon E1 = new Pikachu("eng1", pos1, 5,false);
        Engimon E2 = new Squirtle("musu", pos2, 5,false);
        
        Breed tes1 = new Breed(P, E1,E2);
        //Battle tes2 = new Battle(P, E1,E2);
        //Battle tes3 = new Battle(P, E1,E2);
        //Engimon E3 = new Engimon("Test3", "Charmander", 11);
        //Engimon E4 = new Engimon("Test4", "Squirtle", 10);

        // P.showListSkillItem();
        // P.showListEngimon();
    }
}
