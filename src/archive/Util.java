package archive;

import items.Item;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Util {
    public static List<Item> linSearch(List<Item> items, String targetTitle) {
        List<Item> hits = new ArrayList<>();
        for (Item item : items) {
            if (item.getTitle().contains(targetTitle)) {
                hits.add(item);
            }
        }
        return hits;
    }

    public static void sortByTitle(List<Item> items){
        Comparator<Item> BY_TITLE = Comparator.comparing(Item::getTitle);
        items.sort(BY_TITLE);
    }
}
