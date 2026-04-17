package archive;

import items.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Archive {
    List<Item> items;

    public Archive(){
        items = new ArrayList<>();
    }

    public void addItem(Item item){
        items.add(item);
    }

    public void removeItem(Item item){
            items.remove(item);
    }

    public Optional<List<String>> showArchive(){
        List<String> display = new ArrayList<>();
        for(Item item : items){
            display.add(item.displayInfo());
        }
        if(display.isEmpty()){
            return Optional.empty();
        }
        return Optional.of(display);
    }
}
