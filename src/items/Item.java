package items;

import java.util.Comparator;
import java.util.List;

public abstract class Item implements Comparable<Item> {
    int year;
    String title;
    int id;
    Comparator<Item> BY_TITLE = Comparator.comparing(Item::getTitle);

    public Item(String title, int releaseYear, int id){
        this.title = title;
        this.year = releaseYear;
        this.id = id;
    }

    public abstract String displayInfo();

    public abstract String getCharacteristics();

    @Override
    public String toString(){
        return title + " from " + year;
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj) return true;
        if(!(obj instanceof Item other)) return false;
        return (title.equals(other.title) && year == other.year);
    }

    public String getTitle(){
        return title;
    }

    @Override
    public int compareTo(Item o) {
        return this.title.compareTo(o.title);
    }
}
