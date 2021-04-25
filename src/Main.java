import tubes.*;
import tubes.Map;
import tubes.Breed;

import java.util.*;  // Import the Scanner class

public class Main {

    public static int setRandomEngimonLevel() {
        //srand(time(0));
        // return rand() % 30 + 1;
        //.RandomNumbersInARange randomNumbersInARange = new RandomNumbersInARange();
        //int number = randomNumbersInARange.getRandomNumber(1, 10);
        return 7;
    }

    public static void gameover() {
        System.out.println("          _,---.      ,---.               ___         ,----.  ");
        System.out.println("  _.='.'-,  \\   .--.'  \\       .-._ .'=.'\\     ,-.--` , \\  ");
        System.out.println(" /==.'-     /   \\==\\-/\\ \\     /==/ \\|==|  |   |==|-  _.-` ");
        System.out.println("/==/ -   .-'    /==/-|_\\ |    |==|,|  / - |   |==|   `.-. ");
        System.out.println("|==|_   /_,-.   \\==\\,   - \\   |==|  \\/  , |  /==/_ ,    / ");
        System.out.println("|==|  , \\_.' )  /==/ -   ,|   |==|- ,   _ |  |==|    .-'  ");
        System.out.println("\\==\\-  ,    (  /==/-  /\\ - \\  |==| _ /\\   |  |==|_  ,`-._"); 
        System.out.println(" /==/ _  ,  /  \\==\\ _.\\=\\.-'  /==/  / / , /  /==/ ,     / ");
        System.out.println(" `--`------'    `--`          `--`./  `--`   `--`-----`` ");

        System.out.println("     _,.---._             ,-.-.       ,----.               ");
        System.out.println("  ,-.' , -  `.    ,--.-./=/ ,/    ,-.--` , \\   .-.,.---.   ");
        System.out.println(" /==/_,  ,  - \\  /==/, ||=| -|   |==|-  _.-`  /==/  `   \\  ");
        System.out.println("|==|   .=.     | \\==\\,  \\ / ,|   |==|   `.-. |==|-, .=., | ");
        System.out.println("|==|_ : ;=:  - |  \\==\\ - ' - /  /==/_ ,    / |==|   '='  / ");
        System.out.println("|==| , '='     |   \\==\\ ,   |   |==|    .-'  |==|- ,   .'");  
        System.out.println(" \\==\\ -    ,_ /    |==| -  ,/   |==|_  ,`-._ |==|_  . ,'.");
        System.out.println("  '.='. -   .'     \\==\\  _ /    /==/ ,     / /==/  /\\ ,  )"); 
        System.out.println("    `--`--''        `--`--'     `--`-----``  `--`-`--`--'  ");
    }
    
    public static void displayMain() {
        System.out.println("       ,___          .-;'    `.`\\_...._/`.-'`" );
        System.out.println("       `-.`\\_...._/`.`        \\        /      ,");
        System.out.println("    ,      \\        /        /()   () \\    .' `-._");
        System.out.println(" .-' ',    / ()   ()\\       |)  .    ()\\  /   _.'");
        System.out.println("`'._   \\  /()    .  (|      \\  -'-     ,; '. <");
        System.out.println("    > .' ;,     -'-  /       ;.__     ,;|   > \\ ");
        System.out.println("   / <   |;,     __.;       / ,    / ,  |.-'.-'");
        System.out.println("   '-.'-.|  , \\    , \\     (_/    (_/ ,;|.<`");
        System.out.println("      `>.|;, \\_)    \\_)          \\    ,;-`");
        System.out.println("       `-;     ,    /         >   \\    /");
        System.out.println("          \\    /   <         (_,-'`> .'");
        System.out.println("           '. <`'-,_)             (_,'");
        System.out.println("            '._)                      ");

        System.out.println("      ,----.   .-._               _,---.      .=-.-.          ___       _,.---._      .-._         ");
        System.out.println("   ,-.--` , \\ /==/ \\  .-._    _.='.'-,  \\    /==/_ /   .-._ .'=.'\\    ,-.' , -  `.   /==/   .-._  ");
        System.out.println("  |==|-  _.-` |==|, \\/ /, /  /==.'-     /   |==|, |   /==/ \\|==|  |  /==/_,  ,  - \\  |==|, \\/ /, / ");
        System.out.println("  |==|   `.-. |==|-  \\|  |  /==/ -   .-'    |==|  |   |==|,|  / - | |==|   .=.     | |==|-  \\|  |  ");
        System.out.println(" /==/_ ,    / |==| ,  | -|  |==|_   /_,-.   |==|- |   |==|  \\/  , | |==|_ : ;=:  - | |==| ,  | -|  ");
        System.out.println(" |==|    .-'  |==| -   _ |  |==|  , \\_.' )  |==| ,|   |==|- ,   _ | |==| , '='     | |==| -   _ |  ");
        System.out.println(" |==|_  ,`-._ |==|  /\\ , |  \\==\\-  ,    (   |==|- |   |==| _ /\\   |  \\==\\ -    ,_ /  |==|  /\\ , |");  
        System.out.println(" /==/ ,     / /==/, | |- |   /==/ _  ,  /   /==/. /   /==/  / / , /   '.='. -   .'   /==/, | |- |  ");
        System.out.println(" `--`-----``  `--`./  `--`   `--`------'    `--`-`    `--`./  `--`      `--`--''     `--`./  `--`  ");
    
        System.out.println("     _,---.     ,---.         _,.----.    ,--.--------.      _,.---._                                   ");
        System.out.println("  .-`.' ,  \\  .--.'  \\      .' .' -   \\  /==/,  -   , -\\   ,-.' , -  `.     .-.,.---.    ,--.-.  .-,--. ");
        System.out.println(" /==/_  _.-'  \\==\\-/\\ \\    /==/  ,  ,-'  \\==\\.-.  - ,-./  /==/_,  ,  - \\   /==/  `   \\  /==/- / /=/_ /  ");
        System.out.println("/==/-  '..-.  /==/-|_\\ |   |==|-   |  .   `--`\\==\\- \\    |==|   .=.     | |==|-, .=., | \\==\\, \\/=/. /   ");
        System.out.println("|==|_ ,    /  \\==\\,   - \\  |==|_   `-' \\       \\==\\_ \\   |==|_ : ;=:  - | |==|   '='  /  \\==\\  \\/ -/    ");
        System.out.println("|==|   .--'   /==/ -   ,|  |==|   _  , |       |==|- |   |==| , '='     | |==|- ,   .'    |==|  ,_/     ");
        System.out.println("|==|-  |     /==/-  /\\ - \\ \\==\\.       /       |==|, |    \\==\\ -    ,_ /  |==|_  . ,'.    \\==\\-, /      ");
        System.out.println("/==/   \\     \\==\\ _.\\=\\.-'  `-.`.___.-'        /==/ -/     '.='. -   .'   /==/  /\\ ,  )   /==/._/       ");
        System.out.println("`--`---'      `--`                             `--`--`       `--`--''     `--`-`--`--'    `--`-`   ");
    }

    public static void displayHelp() {
        System.out.println("+-----------------------------------------+");
        System.out.println("|              Engimon Help               |");
        System.out.println("|-----------------+-----------------------|");
        System.out.println("|     command     |        action         |");
        System.out.println("|-----------------+-----------------------|");
        System.out.println("|W/w              |move north             |");
        System.out.println("|A/a              |move west              |");
        System.out.println("|S/s              |move south             |");
        System.out.println("|D/d              |move east              |");
        System.out.println("|change           |change active engimon  |");
        System.out.println("|breed            |breed engimon          |");
        System.out.println("|battle           |battle wild engimon    |");
        System.out.println("|learn            |learn skill to engimon |");
        System.out.println("|inventory        |view inventory         |");
        System.out.println("|interact         |interact with engimon  |");
        System.out.println("|changeName       |change engimon name    |");
        System.out.println("|status           |view game status       |");
        System.out.println("|dropSkillItem    |membuang skill item    |");
        System.out.println("|dropEngimon      |membuang engimon       |");
        System.out.println("|help             |view help              |");
        System.out.println("+-----------------------------------------+");
    }
     
    public static void displayGameStatus(Player P) {
        // Tampilin data active engimon, data player, data inventory
        Engimon currentActiveEngimon = P.getActiveEngimon();
        System.out.println( "Game Status" );
        System.out.println( "Active Engimon:" );
        currentActiveEngimon.displayInfo();
        System.out.println( "Player: " );
        System.out.println( "Koordinat player: (" + P.getPlayerPosition().x + "," + P.getPlayerPosition().y + ")");
        System.out.println( "Engimon List: " );
        P.InventEngimon.printInventory();
        System.out.println( "Skill Item List: " );
        P.InventSkill.printInventory();
        System.out.println();
    }
    
    public static boolean isCommandValid (String command) {
        if (command.equals("W") || command.equals("w") || command.equals("A") || command.equals("a") || command.equals("S") || command.equals("s") || command.equals("D") || command.equals("d")) {
            return true;
        }
        else if (command.equals("change") || command.equals("battle") || command.equals("learn") || command.equals("inventory") || command.equals("help") || command.equals("status") || command.equals("breed") || command.equals("changeName") || command.equals("interact") || command.equals("dropEngimon")|| command.equals("dropSkillItem")) {
            return true;
        }
        else {
            return false;
        }
    }
    
    public static void deleteWildEng(String nama, ArrayList<Engimon> wildEng) {
            for (int i = 0 ; i<wildEng.size() ; i++) {
                if (nama.equals(wildEng.get(i).getName())){
                    wildEng.remove(i);
                }
            }
        }
    
    public static void main(String[] args) {
        ArrayList<Engimon> wildEng = new ArrayList<Engimon>();
        Scanner myObj = new Scanner(System.in);
        Coordinate c1 = new Coordinate();
        Coordinate c2 = new Coordinate();
        Coordinate c3 = new Coordinate();
        Coordinate c4 = new Coordinate();
        Coordinate c5 = new Coordinate();
        Coordinate c6 = new Coordinate();
        Coordinate c7 = new Coordinate();
        Coordinate c8 = new Coordinate();
    
        //Ini Levelnya mau diset gimana awalnya??
        // ctornya Charmander(name, coordinate, level)
        Engimon A =  new Charmander("Wild1",c1,setRandomEngimonLevel(),true); wildEng.add(A);
        Engimon B = new Squirtle("Wild2",c2,setRandomEngimonLevel(),true); wildEng.add(B);
        Engimon C = new Pikachu("Wild3",c3,setRandomEngimonLevel(),true); wildEng.add(C);
        Engimon D = new Diglett("Wild4",c4,setRandomEngimonLevel(),true); wildEng.add(D);
        Engimon E = new Glalie("Wild5",c5,setRandomEngimonLevel(),true); wildEng.add(E);
        Engimon F = new Rotom("Wild6",c6,setRandomEngimonLevel(),true); wildEng.add(F);
        Engimon G = new Lapras("Wild7",c7,setRandomEngimonLevel(),true); wildEng.add(G);
        Engimon H = new Wooper("Wild8",c8,setRandomEngimonLevel(),true); wildEng.add(H);

    
        displayMain();
    
        System.out.println("Pilih Engimon Starter: ");
        System.out.println("1. Charmander");
        System.out.println("2. Squirtle");
        System.out.println("3. Pikachu");
        System.out.println("4. Diglett");
        System.out.println("5. Glalie");
        
        //Atribut Ctor starting engimon
        Coordinate startingEngimon = new Coordinate(2,1);
        int levelStarting = 15; // Level engimon aktif awal
        Engimon E1; // Active engimon awal
    
        String starterSpecies = myObj.nextLine();
        while (true){
            if (starterSpecies.equals("Charmander") || starterSpecies.equals("Squirtle") || starterSpecies.equals("Pikachu") || starterSpecies.equals("Diglett") || starterSpecies.equals("Glalie")){
                break;
            }
            System.out.println("Input Salah, silahkan masukkan input baru");
            starterSpecies = myObj.nextLine();
        }
        System.out.print("Masukkan Nama Untuk "+ starterSpecies +": ");
        String nameStarter = myObj.nextLine();
        if (starterSpecies.equals("Charmander")){E1 = new Charmander(nameStarter, startingEngimon, levelStarting, false); }
        else if (starterSpecies.equals("Squirtle")){E1 = new Squirtle(nameStarter, startingEngimon, levelStarting, false); }
        else if (starterSpecies.equals("Pikachu")){E1 = new Pikachu(nameStarter, startingEngimon, levelStarting, false); }
        else if (starterSpecies.equals("Diglett")){E1 = new Diglett(nameStarter, startingEngimon, levelStarting, false); }
        else {
            E1 = new Glalie(nameStarter, startingEngimon, levelStarting, false);
        }
        Coordinate startingPlayer = new Coordinate(2,2);
        Player P = new Player(startingPlayer);
        
        /*
        Engimon E2 = new Diglett("SPAWN", startingEngimon, 10, false);
        P.addEngimon(E2);*/
        
        
        P.addEngimon(E1);
        P.setActiveEngimon(E1);
        //P.InventSkill.addItem(E1.getSkills().get(0), 1);

    
        // GAME ASLI (TERMASUK PETA)
        Boolean isGameRunning = true;
        tubes.Map M = new Map("tubes/inputPeta.txt");
        String command;
        String command2;
        int turn = 1;

        M.changePositionIfNecessary(wildEng, P);//random posisi wild engimon


        //Scanner input = new Scanner(System.in);

        Random rand = new Random();
        while (isGameRunning) {
            // Siapin dan print map
            if (turn % 4 == 0) {
                for (int i = 0; i < wildEng.size(); i++) {
                    M.setNewRandomPosition(wildEng.get(i),P, rand);
                }
            }
            Boolean gone;
            if (turn % 10 == 0) {
                for (int i = 0; i < wildEng.size() ; i++) {
                    gone = true;
                    for (int j = 0; j < wildEng.size() ; j++) {
                        if (("Wild"+String.valueOf(i+1)).equals(wildEng.get(i).getName())){
                            gone = false;
                        }
                    }
                    if (gone) {
                        if (i == 0) wildEng.add(A);
                        else if (i == 1) wildEng.add(B);
                        else if (i == 2) wildEng.add(C);
                        else if (i == 3) wildEng.add(D);
                        else if (i == 4) wildEng.add(E);
                        else if (i == 5) wildEng.add(F);
                        else if (i == 6) wildEng.add(G);
                        else if (i == 7) wildEng.add(H);
                    }
                }
                M.changePositionIfNecessary(wildEng, P);
            }
            M.fillMap(wildEng,P);
            M.printMap();
            
            // print status permainan
            displayGameStatus(P);
            System.out.println( "Ketik \"help\" untuk menampilkan list command" );
            System.out.println();
            // Memasukkan dan memvalidasi input
            System.out.println( "Masukkan command Anda: ");
            command = myObj.nextLine();
            while (!isCommandValid(command)) {
                System.out.println( "Command tidak valid!");
                System.out.println( "Masukkan command Anda: ");
                command = myObj.nextLine();
            }

            //System.out.println(command);
    
            // Menjalankan fungsionalitas berdasarkan command
            if (command.equals("W") || command.equals("w") || command.equals("A") || command.equals("a") || command.equals("S") || command.equals("s") || command.equals("D") || command.equals("d")){
                M.move(command.charAt(0), P);
            }
            else if (command.equals("help")) {
                displayHelp();
            }
            else if (command.equals("inventory")) {
                // Display inventory, pilih inventory
                System.out.println( "Pilih inventory yang ingin ditampilkan" );
                System.out.println( "Ketik \"engimon\" atau \"skill\"" );
                command = myObj.nextLine();
                if (command.equals("engimon")) {
                    P.showListEngimon();
                }
                else if (command.equals("skill")){
                    P.showListSkillItem();
                }
            }
            else if (command.equals("change")) {
                // change active engimon
                P.showListEngimon();
                System.out.println( "Masukkan engimon: ");
                command = myObj.nextLine();
                P.setActiveEngimon(P.InventEngimon.findItem(command.toString()));
            }
            else if (command.equals("battle")) {
                if (!P.isEngimonNearby(wildEng).getName().equals("none")){
                    // Cek apakah active engimon sudah di-set
                    if (P.getActiveEngimon() != null){
                        Battle btl = new Battle(P,P.getActiveEngimon(), P.isEngimonNearby(wildEng));
                        if (btl.getLoseStatus() == true){
                                if (!P.isInventoryEngimonEmpty()){
                                    System.out.println("Set active engimon! ");
                                    System.out.println("Inventory : ");
                                    P.showListEngimon();  // Create a Scanner object
                                    System.out.print("Pilih Engimon : ");
                                    String EngimonName = myObj.nextLine();
                                    while (P.findEngimon(EngimonName) == null){
                                        System.out.println("Tidak terdapat engimon dengan nama " + EngimonName + "!");
                                        System.out.print("Pilih Engimon : ");
                                        EngimonName = myObj.nextLine();
                                    }
                                    Engimon newActiveEngimon = P.findEngimon(EngimonName);
                                    P.setActiveEngimon(newActiveEngimon);
                                    System.out.println("Set active engimon berhasil!");
                                    System.out.println("Active Engimon : "+ P.getActiveEngimon().getName());
                                }
                                else //Inventory Engimon Empty
                                {
                                    System.out.println("Inventory Engimon kosong, game over!");
                                    isGameRunning = false;
                                }
                        }else{
                            if (!btl.getTolakBattle()){
                                deleteWildEng(btl.getEnemyEng().getName(), wildEng);
                            }
                        }
                    }
                    else{
                        System.out.println("Active engimon belum dipasang, battle tidak dapat dilakukan");
                    }
                }
            }
            else if (command.equals("learn")) {
                P.showListEngimon();
                System.out.println( "Masukkan engimon: ");
                command = myObj.nextLine();
                if (!(P.findEngimon(command).getName().equals("none") )){
                    Learn learn = new Learn(P,P.findEngimon(command));
                }
            }
            else if (command.equals("breed")){
                String engimon1, engimon2;
                P.showListEngimon();
                System.out.println( "Masukkan engimon parent 1: ");
                engimon1 = myObj.nextLine();
                System.out.println( "Masukkan engimon parent 2: ");
                engimon2 = myObj.nextLine();

           
                if ((P.findEngimon(engimon1).getElements().get(1).equals("none")) && (P.findEngimon(engimon2).getElements().get(1).equals("none"))){
                    if (!(P.findEngimon(engimon1).getName().equals("none") && P.findEngimon(engimon2).getName().equals("none"))){
                        Breed b = new Breed(P, P.findEngimon(engimon1), P.findEngimon(engimon2));
                    }
                }
                else{
                    System.out.println(" Breeding Gagal ");
                    System.out.println(" Salah satu parent memiliki 2 element");
                }
                

            }
            else if (command.equals("status")) {
                displayGameStatus(P);
            }
            else if (command.equals("interact")) {
                P.getActiveEngimon().interactEngimon();
            }
            else if (command.equals("changeName")) {
                System.out.println("Pilih engimon yang ingin diubah namanya: ");
                P.InventEngimon.printInventory();
                String name = myObj.nextLine();
                System.out.print("Masukkan nama baru engimon: ");
                String namaBaru = myObj.nextLine();
                P.changeNameEngimon(name, namaBaru);

            }
            else if (command.equals("dropSkillItem")) {
                System.out.println("Pilih skill item yang ingin dibuang: ");
                P.InventSkill.printInventory();
                String name = myObj.nextLine();
                while (P.InventSkill.findItem(name).equals(null)){
                    System.out.println("Skill item tidak ada di inventory, masukkan kembali");
                    System.out.println("Skill item yang ingin dibuang: ");
                    name = myObj.nextLine();
                }
                System.out.println("Jumlah yang ingin dibuang: ");
                Integer jumlah = myObj.nextInt();
                while (jumlah > P.InventSkill.getAmount(P.InventSkill.findItem(name))){
                    System.out.println("Jumlah melebihi yang dimiliki, masukkan kembali");
                    System.out.println("Jumlah yang ingin dibuang: ");
                    jumlah = myObj.nextInt();
                }
                P.lepasSkillItem(name, jumlah);
            }
            else if (command.equals("dropEngimon")) {
                if (P.InventEngimon.returnItem().size() == 1){
                    System.out.println("Hanya tersisa active engimon");
                }
                else {
                    System.out.println("Pilih engimon yang ingin dilepas: ");
                    P.InventEngimon.printInventory();
                    String name = myObj.nextLine();
                    while(P.InventEngimon.findItem(name)==(null) || name.equals(P.getActiveEngimon().getName())){
                        if (name.equals(P.getActiveEngimon().getName())){
                            System.out.println("Tidak bisa melepas active engimon, masukkan kembali");
                            System.out.println("Engimon yang ingin dilepas: ");
                        }
                        else{
                            System.out.println("Engimon tidak ada di inventory, masukkan kembali");
                            System.out.println("Engimon yang ingin dilepas: ");
                        }
                        name = myObj.nextLine();
                    }
                    P.lepasEngimon(name);
                }
            }
            turn++;
        }
        gameover();
    }
}