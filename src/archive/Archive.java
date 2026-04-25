package archive;

import items.Item;

import java.util.ArrayList;
import java.util.List;

public class Archive {
    private List<Item> items;
    private int id_Counter;

    public Archive(){
        items = new ArrayList<>();
        id_Counter = 0;
    }

    public void addItem(Item item){
        items.add(item);
        id_Counter++;
    }

    public void removeItem(Item item){
            items.remove(item);
    }

    public int getNextID(){
        return id_Counter+1;
    }

    public List<Item> getItems(){
        return items;
    }
}

