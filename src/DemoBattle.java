import tubes.*;

public class DemoBattle {
    public static void main (String[] args) {
        Coordinate pos1 = new Coordinate(1,1);
        Coordinate pos2 = new Coordinate(1,2);
        Coordinate pos0 = new Coordinate(2,1);
        Player P = new Player(pos0);
        Engimon E1 = new Pikachu("eng1", pos1, 1, true);
        Engimon E2 = new Squirtle("musu", pos2, 99999, false);
        P.addEngimon(E1);
        P.setActiveEngimon(E1);
        Battle tes1 = new Battle(P, E1,E2);
        Battle tes2 = new Battle(P, E1,E2);
        Battle tes3 = new Battle(P, E1,E2);
        //Engimon E3 = new Engimon("Test3", "Charmander", 11);
        //Engimon E4 = new Engimon("Test4", "Squirtle", 10);

        // P.showListSkillItem();
        // P.showListEngimon();
    }
}
