package tubes;

import java.util.*;
import java.io.*;
import java.util.Random;

public class Map {
    // private Coordinate TitikTengah = new Coordinate();  // Titik batas 4 tipe cell
    private ArrayList<Coordinate> Mountain = new ArrayList<Coordinate>();
    private ArrayList<Coordinate> Grassland = new ArrayList<Coordinate>();
    private ArrayList<Coordinate> Sea = new ArrayList<Coordinate>();
    private ArrayList<Coordinate> Tundra = new ArrayList<Coordinate>();
    private final Integer LevelMin = 4;    // Level minimum engimon ditulis huruf besar (?)
    public char[][] PetaAwal;
    public char[][] PetaModifikasi;

    public Map(String namafile) {
        // Inisialisasi PetaAwal
        int row = 40;
        int col = 40;
        PetaAwal = new char[row][col];
        // for(int i = 0; i < row * col ; i++){
        //     PetaAwal[i/row][i % col] = '0';
        // }
        // Inisialisasi PetaModifikasi
        PetaModifikasi = new char[row][col];
        // for(int i = 0; i < row * col ; i++){
        //     PetaModifikasi[i/row][i % col] = '0';
        // }
        try {
            File fileSaya = new File(namafile);
            Scanner myReader = new Scanner(fileSaya);
            if (fileSaya.exists()) {
                int i = 0;
                while (myReader.hasNextLine()) {
                    String data = myReader.nextLine();
                    for (int j = 0; j < 40; j++) {
                        PetaAwal[i][j] = data.charAt(j);
                        if (data.charAt(j) == '^') {
                            Mountain.add(new Coordinate(i,j));
                        }
                        else if (data.charAt(j) == '-') {
                            Grassland.add(new Coordinate(i,j));
                        }
                        else if (data.charAt(j) == '~') {
                            Sea.add(new Coordinate(i,j));
                        }
                        else {
                            Tundra.add(new Coordinate(i,j));
                        }
                    }
                    i++;
                }
                myReader.close();
            }
            else {
                System.out.println("Tidak dapat membuka file"); 
            }
        }
            catch (IOException e) {
                e.printStackTrace();
            }
        
        this.resetMap();
        // TitikTengah.setCoordinate(tengah.x, tengah.y);
    }

    public void resetMap() {
        for (int i = 0; i < 40; i++) {
            for (int j = 0; j < 40; j++) {
                PetaModifikasi[i][j] = PetaAwal[i][j];
            }
        }
    }

    public void printMap() {
        for (int i = 0; i < 40; i++) {
            for (int j = 0; j < 40; j++) {
                System.out.print(PetaModifikasi[i][j]);
            }
            System.out.println();
        }
    }
    
    public void changePeta(int x, int y, char entity) {
        PetaModifikasi[x][y] = entity;
    }

    // yang dimasukkan ke vector engimon, itu user-defined engimon yang levelnya secara random ditentuin
    public void fillMap(ArrayList<Engimon> El, Player P) 
    {
        this.resetMap();
        changePeta(P.getPlayerPosition().x,P.getPlayerPosition().y, 'P');
        changePeta(P.getActiveEngimon().getPosition().x,P.getActiveEngimon().getPosition().y, 'A');
        for (int k = 0; k < El.size(); k++)
        {
            if (El.get(k).getSpecies().equals("Charmander")) 
            {
                if (El.get(k).getLevel() >= LevelMin) {
                    changePeta(El.get(k).getPosition().x, El.get(k).getPosition().y, 'F');
                }
                else {
                    changePeta(El.get(k).getPosition().x, El.get(k).getPosition().y, 'f');
                }

            }
            else if (El.get(k).getSpecies().equals("Squirtle")) 
            {
                if (El.get(k).getLevel() >= LevelMin) {
                    changePeta(El.get(k).getPosition().x, El.get(k).getPosition().y, 'W');
                }
                else {
                    changePeta(El.get(k).getPosition().x, El.get(k).getPosition().y, 'w');
                }
            }
            else if (El.get(k).getSpecies().equals("Pikachu"))
            {
                if (El.get(k).getLevel() >= LevelMin) {
                    changePeta(El.get(k).getPosition().x, El.get(k).getPosition().y, 'E');
                }
                else {
                    changePeta(El.get(k).getPosition().x, El.get(k).getPosition().y, 'e');
                }
            }
            else if (El.get(k).getSpecies().equals("Diglett"))
            {
                if (El.get(k).getLevel() >= LevelMin) {
                    changePeta(El.get(k).getPosition().x, El.get(k).getPosition().y, 'G');
                }
                else {
                    changePeta(El.get(k).getPosition().x, El.get(k).getPosition().y, 'g');
                }
            }
            else if (El.get(k).getSpecies().equals("Glalie"))
            {
                if (El.get(k).getLevel() >= LevelMin) {
                    changePeta(El.get(k).getPosition().x, El.get(k).getPosition().y, 'I');
                }
                else {
                    changePeta(El.get(k).getPosition().x, El.get(k).getPosition().y, 'i');
                }
            }
            else if (El.get(k).getSpecies().equals("Rotom"))
            {
                if (El.get(k).getLevel() >= LevelMin) {
                    changePeta(El.get(k).getPosition().x, El.get(k).getPosition().y, 'L');
                }
                else {
                    changePeta(El.get(k).getPosition().x, El.get(k).getPosition().y, 'l');
                }
            }
            else if (El.get(k).getSpecies().equals("Lapras"))
            {
                if (El.get(k).getLevel() >= LevelMin) {
                    changePeta(El.get(k).getPosition().x, El.get(k).getPosition().y, 'S');
                }
                else {
                    changePeta(El.get(k).getPosition().x, El.get(k).getPosition().y, 's');
                }
            }
            else
            {
                if (El.get(k).getLevel() >= LevelMin) {
                    changePeta(El.get(k).getPosition().x, El.get(k).getPosition().y, 'N');
                }
                else {
                    changePeta(El.get(k).getPosition().x, El.get(k).getPosition().y, 'n');
                }
            }
        } 
    }

    public void changePositionIfNecessary(ArrayList<Engimon> E, Player P) {
        Random rand = new Random();
        ArrayList<Engimon> ListOfEngimon = E;
        boolean isAllChecked = false, isToBreak = false;
        while (!isAllChecked) {
            for (int i = 0; i < ListOfEngimon.size(); i++) {
                for (int j = 0; j < ListOfEngimon.size(); j++) {
                    if (i == 0 && j == 0) {
                        isToBreak = false;
                    }
                    if (i >= j) {
                        if (i == (ListOfEngimon.size()-1) && j == (ListOfEngimon.size()-1)) {
                            isAllChecked = true;
                        }
                        else {
                            continue;
                        }
                    }
                    else {
                        if (ListOfEngimon.get(i).getPosition().x == ListOfEngimon.get(j).getPosition().x && ListOfEngimon.get(i).getPosition().y == ListOfEngimon.get(j).getPosition().y) {

                            isToBreak = true;
                            
                            setRandomSpawn(ListOfEngimon.get(j),P, rand);
                            break;
                        }
                    }
                }
                if (isToBreak) {
                    break;
                }
            }
        }
        E = ListOfEngimon;
    }

    public boolean isPositionEngimonSama (ArrayList<Engimon> E) {
        boolean isSama = false;
        int i = 0, j = 0;
        while (i < E.size() && !isSama) {
            while (j < E.size() && !isSama) {
                if (i != j) {
                    if (E.get(i).getPosition().x == E.get(j).getPosition().x && E.get(i).getPosition().y == E.get(j).getPosition().y) {
                        isSama = true;
                    }
                }
                j++;
            }
            i++;
        }
        return isSama;
    }

    public void setNewRandomPosition(Engimon E, Player P){
        Random rand = new Random();
        int x = E.getPosition().x + rand.nextInt(3) - 1; // output random between -1, 0 , 1
        int y = E.getPosition().y;
        if (x == E.getPosition().x) y = E.getPosition().y + rand.nextInt(3) - 1; // baru masuk kalo x nya 0
        if (x < 0) x = 0;
        else if (x > 39)  x = 39;
        if (y < 0) y = 0;
        else if (y > 39) y = 39;

        switch (E.getElements().get(0)){
            case "Fire": {
                // Fire/Electric
                if (E.getElements().get(1).equals("Electric")) {
                    while (PetaModifikasi[x][y] != '^' || PetaModifikasi[x][y] != '-' ||(P.getPlayerPosition().x == x && P.getPlayerPosition().y == y)) {
                        x = E.getPosition().x + rand.nextInt(3) - 1;
                        if (x == E.getPosition().x) y = E.getPosition().y + rand.nextInt(3) - 1;
                        else y = E.getPosition().y;
                        if (x < 0) x = 0;
                        else if (x > 39)  x = 39;
                        if (y < 0) y = 0;
                        else if (y > 39) y = 39;
                    }
                }
                // Fire/none
                else {
                    while (PetaModifikasi[x][y] != '^' ||(P.getPlayerPosition().x == x && P.getPlayerPosition().y == y)) {
                        x = E.getPosition().x + rand.nextInt(3) - 1;
                        if (x == E.getPosition().x) y = E.getPosition().y + rand.nextInt(3) - 1;
                        else y = E.getPosition().y;
                        if (x < 0) x = 0;
                        else if (x > 39)  x = 39;
                        if (y < 0) y = 0;
                        else if (y > 39) y = 39;
                    }
                }
                break;
            }
            case "Water": {
                // Water/Ground
                if (E.getElements().get(1).equals("Ground")) {
                    while (PetaModifikasi[x][y] != '~' || PetaModifikasi[x][y] != '-' ||(P.getPlayerPosition().x == x && P.getPlayerPosition().y == y)) {
                        x = E.getPosition().x + rand.nextInt(3) - 1;
                        if (x == E.getPosition().x) y = E.getPosition().y + rand.nextInt(3) - 1;
                        else y = E.getPosition().y;
                        if (x < 0) x = 0;
                        else if (x > 39)  x = 39;
                        if (y < 0) y = 0;
                        else if (y > 39) y = 39;
                    }
                }
                // Water/Ice
                else if (E.getElements().get(1).equals("Ice")) {
                    while (PetaModifikasi[x][y] != '~' || PetaModifikasi[x][y] != 'o' ||(P.getPlayerPosition().x == x && P.getPlayerPosition().y == y)) {
                        x = E.getPosition().x + rand.nextInt(3) - 1;
                        if (x == E.getPosition().x) y = E.getPosition().y + rand.nextInt(3) - 1;
                        else y = E.getPosition().y;
                        if (x < 0) x = 0;
                        else if (x > 39)  x = 39;
                        if (y < 0) y = 0;
                        else if (y > 39) y = 39;
                    }
                }
                // Water/none
                else {
                    while (PetaModifikasi[x][y] != 'S' ||(P.getPlayerPosition().x == x && P.getPlayerPosition().y == y)) {
                        x = E.getPosition().x + rand.nextInt(3) - 1;
                        if (x == E.getPosition().x) y = E.getPosition().y + rand.nextInt(3) - 1;
                        else y = E.getPosition().y;
                        if (x < 0) x = 0;
                        else if (x > 39)  x = 39;
                        if (y < 0) y = 0;
                        else if (y > 39) y = 39;
                    }
                }
                break;
            }
            case "Electric": {
                while (PetaModifikasi[x][y] != '-' ||(P.getPlayerPosition().x == x && P.getPlayerPosition().y == y)) {
                    x = E.getPosition().x + rand.nextInt(3) - 1;
                    if (x == E.getPosition().x) y = E.getPosition().y + rand.nextInt(3) - 1;
                    else y = E.getPosition().y;
                    if (x < 0) x = 0;
                    else if (x > 39)  x = 39;
                    if (y < 0) y = 0;
                    else if (y > 39) y = 39;
                }
                break;
            }
            case "Ground": {
                while (PetaModifikasi[x][y] != '-' ||(P.getPlayerPosition().x == x && P.getPlayerPosition().y == y)) {
                    x = E.getPosition().x + rand.nextInt(3) - 1;
                    if (x == E.getPosition().x) y = E.getPosition().y + rand.nextInt(3) - 1;
                    else y = E.getPosition().y;
                    if (x < 0) x = 0;
                    else if (x > 39)  x = 39;
                    if (y < 0) y = 0;
                    else if (y > 39) y = 39;
                }
                break;
            }   
            case "Ice": {
                while (PetaModifikasi[x][y] != 'o' ||(P.getPlayerPosition().x == x && P.getPlayerPosition().y == y)) {
                    x = E.getPosition().x + rand.nextInt(3) - 1;
                    if (x == E.getPosition().x) y = E.getPosition().y + rand.nextInt(3) - 1;
                    else y = E.getPosition().y;
                    if (x < 0) x = 0;
                    else if (x > 39)  x = 39;
                    if (y < 0) y = 0;
                    else if (y > 39) y = 39;
                }
                break;
            }               
        }
     
        Coordinate newPos = new Coordinate(x, y);
        E.setPosition(newPos);
    }

    // Posisi map:
    // +---+---+
    // | M | L |
    // +---+---+
    // | T | S |
    // +---+---+
    // Mountain(Fire), grassLand(Ground/Electric), Tundra(Ice), Sea(Water)

    public void setRandomSpawn(Engimon E, Player P, Random rand) {
        //Random rand = new Random();
        int x = rand.nextInt(40); 
        int y = rand.nextInt(40);

        // switch (E.getElements().get(0)){
            if (E.getElements().get(0) == "Fire") {
                // Fire/Electric
                if (E.getElements().get(1).equals("Electric")) {
                    while ((PetaModifikasi[x][y] != '^' && PetaModifikasi[x][y] != '-') ||(P.getPlayerPosition().x == x && P.getPlayerPosition().y == y)) {
                        //System.out.println("Masuk Fire Electric");
                        x = rand.nextInt(40); 
                        y = rand.nextInt(40); 
                    }
                }
                // Fire/none
                else {
                    while (PetaModifikasi[x][y] != '^' ||(P.getPlayerPosition().x == x && P.getPlayerPosition().y == y)) {
                        //System.out.println("Masuk Fire");
                        x = rand.nextInt(40); 
                        y = rand.nextInt(40); 
                    }
                }
            }
            else if (E.getElements().get(0) == "Water") {
                // Water/Ground
                if (E.getElements().get(1).equals("Ground")) {
                    while ((PetaModifikasi[x][y] != '~' && PetaModifikasi[x][y] != '-') ||(P.getPlayerPosition().x == x && P.getPlayerPosition().y == y)) {
                        //System.out.println("Masuk Water Ground");
                        x = rand.nextInt(40); 
                        y = rand.nextInt(40); 
                    }
                }
                // Water/Ice
                else if (E.getElements().get(1).equals("Ice")) {
                    while (true) {
                        if (PetaModifikasi[x][y] != '~' || PetaModifikasi[x][y] != 'o' || !(P.getPlayerPosition().x == x && P.getPlayerPosition().y == y)) {
                            break;
                        }
                        else {
                            //System.out.println("Masuk Water Ice");
                            x = rand.nextInt(40); 
                            y = rand.nextInt(40); 
                        }
                    }
                }
                // Water/none
                else {
                    while (PetaModifikasi[x][y] != '~' ||(P.getPlayerPosition().x == x && P.getPlayerPosition().y == y)) {
                        //System.out.println("Masuk Water");
                        x = rand.nextInt(40); 
                        y = rand.nextInt(40); 
                    }
                }
                // break;
            }
            else if (E.getElements().get(0) == "Electric") {
                while (PetaModifikasi[x][y] != '-' ||(P.getPlayerPosition().x == x && P.getPlayerPosition().y == y)) {
                    //System.out.println("Masuk Electric");
                    x = rand.nextInt(40); 
                    y = rand.nextInt(40); 
                }
                // break;
            }
            else if (E.getElements().get(0) == "Ground") {
                while (PetaModifikasi[x][y] != '-' ||(P.getPlayerPosition().x == x && P.getPlayerPosition().y == y)) {
                    //System.out.println("Masuk Ground");
                    x = rand.nextInt(40); 
                    y = rand.nextInt(40); 
                }
                // break;
            }   
            else if (E.getElements().get(0) == "Ice") {
                while (PetaModifikasi[x][y] != 'o' ||(P.getPlayerPosition().x == x && P.getPlayerPosition().y == y)) {
                    //System.out.println("Masuk ice");
                    x = rand.nextInt(40); 
                    y = rand.nextInt(40); 
                }
                // break;
            }               
        // }
        Coordinate newPos = new Coordinate(x, y);
        E.setPosition(newPos);
    }

    public void move(char InputTombol, Player P){ //asumsi koordinat normal pada map
    
        // update activepokemon position dengan position player sebelumnya,
        Coordinate CoorActiveEngimon = new Coordinate();
        CoorActiveEngimon.x = P.getPlayerPosition().x;
        CoorActiveEngimon.y = P.getPlayerPosition().y;

        switch(InputTombol) {
            case 'A':{
                if (P.getPlayerPosition().y > 0 && (PetaModifikasi[P.getPlayerPosition().x][P.getPlayerPosition().y-1] == 'o' || PetaModifikasi[P.getPlayerPosition().x][P.getPlayerPosition().y-1] == '-' || PetaModifikasi[P.getPlayerPosition().x][P.getPlayerPosition().y-1] == '~' || PetaModifikasi[P.getPlayerPosition().x][P.getPlayerPosition().y-1] == '^')){
                    Coordinate z = new Coordinate(P.getPlayerPosition().x, P.getPlayerPosition().y-1);
                    P.setPosition(z);
                    P.setEngPos(CoorActiveEngimon);
                }
                break;
            }
            case 'W':{
                if (P.getPlayerPosition().x > 0 && (PetaModifikasi[P.getPlayerPosition().x-1][P.getPlayerPosition().y] == 'o' || PetaModifikasi[P.getPlayerPosition().x-1][P.getPlayerPosition().y] == '-' || PetaModifikasi[P.getPlayerPosition().x-1][P.getPlayerPosition().y] == '~' || PetaModifikasi[P.getPlayerPosition().x-1][P.getPlayerPosition().y] == '^')){
                    Coordinate z = new Coordinate(P.getPlayerPosition().x-1, P.getPlayerPosition().y);
                    P.setPosition (z);
                    P.setEngPos(CoorActiveEngimon);
                } 
                break;
            }
            case 'D':{
                if (P.getPlayerPosition().y < 19 && (PetaModifikasi[P.getPlayerPosition().x][P.getPlayerPosition().y+1] == 'o' || PetaModifikasi[P.getPlayerPosition().x][P.getPlayerPosition().y+1] == '-' || PetaModifikasi[P.getPlayerPosition().x][P.getPlayerPosition().y+1] == '~' || PetaModifikasi[P.getPlayerPosition().x][P.getPlayerPosition().y+1] == '^')){
                    Coordinate z = new Coordinate(P.getPlayerPosition().x, P.getPlayerPosition().y+1);
                    P.setPosition (z);
                    P.setEngPos(CoorActiveEngimon);
                }
                break;
            }
            case 'S':{
                if (P.getPlayerPosition().x < 19 && (PetaModifikasi[P.getPlayerPosition().x+1][P.getPlayerPosition().y] == 'o' || PetaModifikasi[P.getPlayerPosition().x+1][P.getPlayerPosition().y] == '-' || PetaModifikasi[P.getPlayerPosition().x+1][P.getPlayerPosition().y] == '~' || PetaModifikasi[P.getPlayerPosition().x+1][P.getPlayerPosition().y] == '^')){
                    Coordinate z = new Coordinate(P.getPlayerPosition().x+1, P.getPlayerPosition().y);
                    P.setPosition (z);
                    P.setEngPos(CoorActiveEngimon);
                }
                break;
            }
            case 'a':{
                if (P.getPlayerPosition().y > 0 && (PetaModifikasi[P.getPlayerPosition().x][P.getPlayerPosition().y-1] == 'o' || PetaModifikasi[P.getPlayerPosition().x][P.getPlayerPosition().y-1] == '-' || PetaModifikasi[P.getPlayerPosition().x][P.getPlayerPosition().y-1] == '~' || PetaModifikasi[P.getPlayerPosition().x][P.getPlayerPosition().y-1] == '^')){
                    Coordinate z = new Coordinate(P.getPlayerPosition().x, P.getPlayerPosition().y-1);
                    P.setPosition (z);
                    P.setEngPos(CoorActiveEngimon);
                }
                break;
            }
            case 'w':{
                if (P.getPlayerPosition().x > 0 && (PetaModifikasi[P.getPlayerPosition().x-1][P.getPlayerPosition().y] == 'o' || PetaModifikasi[P.getPlayerPosition().x-1][P.getPlayerPosition().y] == '-' || PetaModifikasi[P.getPlayerPosition().x-1][P.getPlayerPosition().y] == '~' || PetaModifikasi[P.getPlayerPosition().x-1][P.getPlayerPosition().y] == '^')){
                    Coordinate z = new Coordinate(P.getPlayerPosition().x-1, P.getPlayerPosition().y);
                    P.setPosition (z);
                    P.setEngPos(CoorActiveEngimon);
                }
                break;
            }
            case 'd':{
                if (P.getPlayerPosition().y < 19 && (PetaModifikasi[P.getPlayerPosition().x][P.getPlayerPosition().y+1] == 'o' || PetaModifikasi[P.getPlayerPosition().x][P.getPlayerPosition().y+1] == '-' || PetaModifikasi[P.getPlayerPosition().x][P.getPlayerPosition().y+1] == '~' || PetaModifikasi[P.getPlayerPosition().x][P.getPlayerPosition().y+1] == '^')){
                    Coordinate z = new Coordinate(P.getPlayerPosition().x, P.getPlayerPosition().y+1);
                    P.setPosition (z);
                    P.setEngPos(CoorActiveEngimon);
                }
                break;
            }
            case 's':{
                if (P.getPlayerPosition().x < 19 && (PetaModifikasi[P.getPlayerPosition().x+1][P.getPlayerPosition().y] == 'o' || PetaModifikasi[P.getPlayerPosition().x+1][P.getPlayerPosition().y] == '-' || PetaModifikasi[P.getPlayerPosition().x+1][P.getPlayerPosition().y] == '~' || PetaModifikasi[P.getPlayerPosition().x+1][P.getPlayerPosition().y] == '^')){
                    Coordinate z = new Coordinate(P.getPlayerPosition().x+1, P.getPlayerPosition().y);
                    P.setPosition (z);
                    P.setEngPos(CoorActiveEngimon);
                }
                break;
            }
            default: {
                System.out.println("Error. Gunakan WASD/wasd\n");
            }
        }
    }
}
