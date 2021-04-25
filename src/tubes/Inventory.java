package tubes;

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
            if (quantity == 0){
                Container.remove(t);
            }
            else{
                Container.put(t, quantity);
            }
        }
        else {
            System.out.println("Tidak ada item tersebut");
        }
    }
    
    //return jumlah inventory
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

    //Ngeliat ada item apa aja
    public void Entry () {
        System.out.println(Container.entrySet());
    }

    public void printInventory() {
        if (Container.size() == 0) {
            System.out.println("Inventory kosong");
        }
        else {
              for (HashMap.Entry<T, Integer> me : Container.entrySet()) {
                  System.out.print(me.getValue()+"x ");//mencetak value
                  System.out.println(me.getKey()); //mencetak key
              }
        }
    }

    public T findItem(String name) {
            for(HashMap.Entry<T, Integer> entry: Container.entrySet()) {
                if(entry.getKey().toString().equals(name)) {
                    return entry.getKey();
                }
            }
            return null;
        }
    
    //mengembalikan item dalam arraylist, bisa untuk diproses lebih lanjut
    public ArrayList<T> returnItem() {
        ArrayList<T> temp = new ArrayList<T>();
        for(HashMap.Entry<T, Integer> entry: Container.entrySet()) {
            temp.add(entry.getKey());
        }
        return temp;
    }
}