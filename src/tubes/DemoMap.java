package tubes;

public class DemoMap {
    public static void main(String[] args) {
        Coordinate mid = new Coordinate(0,0);
        mid.x = 5;
        mid.y = 5;
        Map tesMap = new Map("tubes/inputPeta.txt", mid); // Tes Konstruktor
        // Konstruktor lolos tes yay
        //tesMap.printMap(); // PrintMap
        // resetMap lolos tes
        // printmap lolos tes
        //tesMap.changePeta(0, 0, 'X');
        // changemap lolos tes
        //tesMap.printMap();

        // Kalau mau tes method yg lain, artinya engimon, player, dkk. harus dites dulu

        // TESTING ENGIMON
        Coordinate pos = new Coordinate();
        int level = 1;
        Engimon E = new Squirtle("Hello, World", pos, 1);
        E.displayInfo(); // displayInfo ???
    }
}