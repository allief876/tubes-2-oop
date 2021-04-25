import tubes.*;
public class DemoBreed {
    public static void main (String[] args) {
        Coordinate pos1 = new Coordinate(1,1);
        Coordinate pos2 = new Coordinate(1,2);
        Coordinate pos0 = new Coordinate(2,1);
        Player P = new Player(pos0);
        //Engimon(String name, String species, String element1, String element2, String slogan, Coordinate spawn, Integer level, Boolean isWildEngimon)
        Engimon E1 = new Charmander("Parent1", pos1, 5,false);
        Engimon E2 = new Pikachu("Parent2", pos2, 5,false);
        P.addEngimon(E1);
        P.addEngimon(E2);
        
        Breed tes1 = new Breed(P, E1,E2);
        P.InventEngimon.printInventory();
        
    }
}
