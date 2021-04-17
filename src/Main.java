import java.util.Scanner;  // Import the Scanner class

public class Main {

    public static int setRandomEngimonLevel() {
        //srand(time(0));
        // return rand() % 30 + 1;
        return 0; // ini cadangan doang
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
        System.out.println("|status           |view game status       |");
        System.out.println("|help             |view help              |");
        System.out.println("+-----------------------------------------+");
    }
     
    public void displayGameStatus(Player P) {
        // Tampilin data active engimon, data player, data inventory
        Engimon currentActiveEngimon = P.getActiveEngimon();
        System.out.println( "Game Status" );
        System.out.println( "Active Engimon:" );
        currentActiveEngimon.displayInfo();
        System.out.println( "Player: " );
        System.out.println( "Koordinat player: (" + P.getPlayerPosition().x + "," + P.getPlayerPosition().y + ")");
        System.out.println( "Engimon List: " );
        P.showListEngimon();
        System.out.println( "Skill Item List: " );
        P.showListSkillItem();
    }
    
    public static boolean isCommandValid (String command) {
        if (command.equals("W") || command.equals("w") || command.equals("A") || command.equals("a") || command.equals("S") || command.equals("s") || command.equals("D") || command.equals("d")) {
            return true;
        }
        else if (command == "change" || command == "battle" || command == "learn" || command == "inventory" || command == "help" || command == "status") {
            return true;
        }
        else {
            return false;
        }
    }
    
    public static void main(String[] args) {
        ArrayList<Engimon> wildEng;
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
        Engimon A =  new Charmander("Wild1",c1,setRandomEngimonLevel()); wildEng.add(A);
        Engimon B = new Squirtle("Wild2",c2,setRandomEngimonLevel()); wildEng.add(B);
        Engimon C = new Pikachu("Wild3",c3,setRandomEngimonLevel()); wildEng.add(C);
        Engimon D = new Diglett("Wild4",c4,setRandomEngimonLevel()); wildEng.add(D);
        Engimon E = new Glalie("Wild5",c5,setRandomEngimonLevel()); wildEng.add(E);
        Engimon F = new Rotom("Wild6",c6,setRandomEngimonLevel()); wildEng.add(F);
        Engimon G = new Lapras("Wild7",c7,setRandomEngimonLevel()); wildEng.add(G);
        Engimon H = new Wooper("Wild8",c8,setRandomEngimonLevel()); wildEng.add(H);
    
        displayMain();
    
        System.out.println("Pilih Engimon Starter: ");
        System.out.println("1. Charmander");
        System.out.println("2. Squirtle");
        System.out.println("3. Pikachu");
        System.out.println("4. Diglett");
        System.out.println("5. Glalie");
        String starterSpecies = myObj.nextLine();
        System.out.print("Masukkan Nama Untuk ");
        
        //Nama Pokemon
        String nameStarter = myObj.nextLine();
        //Atribut Ctor starting engimon
        Coordinate startingEngimon = new Coordinate(2,1);
        int levelStarting = 1; // Level engimon aktif awal
        Engimon E1; // Active engimon awal
    
        if (starterSpecies.equals("Charmander")){E1 = new Charmander(nameStarter, startingEngimon, levelStarting); }
        else if (starterSpecies.equals("Squirtle")){E1 = new Squirtle(nameStarter, startingEngimon, levelStarting); }
        else if (starterSpecies.equals("Pikachu")){E1 = new Pikachu(nameStarter, startingEngimon, levelStarting); }
        else if (starterSpecies.equals("Diglett")){E1 = new Diglett(nameStarter, startingEngimon, levelStarting); }
        else {
            E1 = new Glalie(nameStarter, startingEngimon, levelStarting); 
        }
    
        //Dibuat Player spawn pointnya di (2,2)
        Player P = new Player(2, 2);
        P.addEngimon(E1);
        P.setActiveEngimon(E1);
    
    
        // GAME ASLI (TERMASUK PETA)
        bool isGameRunning = true;
        Map M = new Map("inputPeta.txt", 0, 5, 14, 19);
        String command;
        String command2;
        int turn = 1;
        M.changePositionIfNecessary(wildEng, P);
        while (isGameRunning) {
            // Siapin dan print map
            if (turn % 4 == 0) {
                for (int i = 0; i < wildEng.size(); i++) {
                    M.setNewRandomPosition(wildEng[i],P);
                }
            }
            M.fillMap(wildEng,P);
            M.printMap();
            
            // print status permainan
            displayGameStatus(P);
            System.out.println( "Ketik \"help\" untuk menampilkan list command" );
            
            // Memasukkan dan memvalidasi input
            System.out.println( "Masukkan command Anda: ");
            command = myObj.nextLine();
            while (!isCommandValid(command)) {
                System.out.println( "Command tidak valid!");
                System.out.println( "Masukkan command Anda: ");
                command = myObj.nextLine();
            }
    
            // Menjalankan fungsionalitas berdasarkan command
            if (command.equals("W") || command.equals("w") || command.equals("A") || command.equals("a") || command.equals("S") || command.equals("s") || command.equals("D") || command.equals("d")){
                char arr[];
                strcpy(arr,command.c_str());
                M.move(arr[0], P);
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
                P.setActiveEngimon(P.findEngimon(command));
            }
            else if (command.equals("battle")) {
                if (P.isEngimonNearby(wildEng).getName().equals("none") != 0){
                    P.battle((P.getActiveEngimon()), P.isEngimonNearby(wildEng), wildEng);
                    if (P.isInventoryEngimonEmpty()){
                        isGameRunning = false;
                    }
                }
            }
            else if (command.equals("learn")) {
                P.showListEngimon();
                System.out.println( "Masukkan engimon: ");
                command = myObj.nextLine();
                P.showListSkillItem();
                System.out.println( "Masukkan skill: ");
                command2 = myObj.nextLine();
                if (P.findEngimon(command).getName().equals("none") != 0 && P.findSkill(command2).getNama().equals("none") != 0){
                    P.learn(P.findEngimon(command), P.findSkill(command2));
                }
            }
            else if (command.equals("breed")){
                String engimon1, engimon2;
                P.showListEngimon();
                System.out.println( "Masukkan engimon parent 1: ");
                engimon1 = myObj.nextLine();
                System.out.println( "Masukkan engimon parent 2: ");
                engimon2 = myObj.nextLine();
    
                if (P.findEngimon(engimon1).getName().equals("none") != 0 && P.findEngimon(engimon2).getName().equals("none") != 0){
                    P.breed( P.findEngimon(engimon1), P.findEngimon(engimon2) );
                }
    
            }
            else if (command.equals("status")) {
                displayGameStatus(P);
            }
            turn++;
        }
        gameover();
    }
}