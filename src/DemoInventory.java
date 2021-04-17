public class DemoInventory {
        public static void main (String[] args) {
        Inventory<Engimon> I = new Inventory<>();
        //Engimon E1 = new Engimon("Test1", "Charmander", 10);
        //Engimon E2 = new Engimon("Test1", "Charmander", 10);
        //Engimon E3 = new Engimon("Test3", "Charmander", 11);
        //Engimon E4 = new Engimon("Test4", "Squirtle", 10);

        //I.addItem(E1, 1);
        //I.addItem(E1, 1);
        //I.addItem(E2, 1);
        //I.addItem(E3, 1);
        //I.addItem(E4, 1);
        //System.out.println(I.getAmount(E1));
        I.Entry();
        I.printInventory();
    }
    /*
    public static void main(String[] args) {
        Inventory<String> inv = new Inventory<>();
        inv.addItem("Satu");
        inv.addItem("Dua");
        inv.addItem("Tiga");
        inv.subtractItem("Satuef");
        inv.printInventory();
    }
*/
}
