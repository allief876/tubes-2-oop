import java.util.*;

public class Inventory<T> {
    private HashMap<T, Integer> Container;

    public Inventory() {
        this.Container = new HashMap<T, Integer>();
    }

    public void addItem(T t, int quantity) {
        if (Container.containsKey(t)) {
            quantity += Container.get(t);
        }
        Container.put(t, quantity);
    }

    public void removeItem(T t, int quantity) {
        if (Container.containsKey(t)) {
            quantity = Container.get(t) - quantity;
            Container.put(t, quantity);
        }
        else {
            System.out.println("Tidak ada item tersebut");
        }
    }

    /*public T getItem(int i) {
        return Container.getKey(i);
    }*/
    
    public int getJumlahInventory() {
        int jumlah = 0;
        if (Container.size() != 0) {
            for (HashMap.Entry<T, Integer> me : Container.entrySet()) {
                jumlah += (me.getValue());
            }
        }
        return jumlah;
    }

    public int getAmount(T t) {
        return Container.get(t);
    }
    public void Entry () {
        System.out.println(Container.entrySet());
    }

    public void printInventory() {
        if (Container.size() == 0) {
            System.out.println("Inventory kosong");
        }
        else {
              for (HashMap.Entry<T, Integer> me : Container.entrySet()) {
                  System.out.print(me.getKey() + " = "); //mencetak key
                  System.out.println(me.getValue()); //mencetak value
              }
        }
    }
/*
class Inventory<T> {
    private ArrayList<T> Container;
    
    public Inventory() {
        this.Container = new ArrayList<T>();
    }
    
    public void addItem(T t) {
        Container.add(t);
    }

    public void subtractItem(T t) {
        Container.remove(t);
    }

    public int getJumlah() {
        return Container.size();
    }

    public T getItem(int i) {
        return Container.get(i);
    }

    public ArrayList<T> getInternal() {
        return this.Container;
    }

    public void printInventory() {
        for (int i = 0; i < Container.size(); i++) {
            System.out.println(Container.get(i));
        }
    }*/
}