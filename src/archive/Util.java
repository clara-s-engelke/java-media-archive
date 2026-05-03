package archive;

import items.Item;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Util {
    static Comparator<Item> BY_TITLE = Comparator.comparing(Item::getTitle);

    public static List<Item> linSearch(List<Item> items, String targetTitle) {
        List<Item> hits = new ArrayList<>();
        for (Item item : items) {
            if (item.getTitle().contains(targetTitle)) {
                hits.add(item);
            }
        }
        return hits;
    }

    public static List<Item> binSearch(List<Item> items, String targetTitle){
        sortByTitle(items);
        int pos = -1;
        int middle;
        int start = 0;
        int end = items.size()-1;

        while( start <= end && pos == -1) {
            middle = (start+end)/2;
            if(items.get(middle).getTitle().compareTo(targetTitle) < 0) {
                start  = middle+1;
            } else if(items.get(middle).getTitle().compareTo(targetTitle) > 0) {
                end  = middle-1;
            } else {
                pos = middle;
            }
        }

        int left, right;
        if(pos > -1){
            left = right = pos;
        } else{
            left = right = 0;
        }
        while(left > 0 && items.get(left).getTitle().equals(items.get(left-1).getTitle())){
            left--;
        }
        while(right < items.size()-1 && items.get(right).getTitle().equals(items.get(right+1).getTitle())){
            right++;
        }

        return items.subList(left, right+1);

    }

    public static void sortByTitle(List<Item> items){
        items.sort(BY_TITLE);
    }

}
