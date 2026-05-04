package items;

import java.util.HashSet;
import java.util.Set;

public abstract class Item implements Comparable<Item> {
    protected int year;
    protected String title;
    protected int id;
    protected Set<String> tags;
    protected Status status;

    public Item(String title, int releaseYear, int id){
        this.title = title;
        this.year = releaseYear;
        this.id = id;
        tags = new HashSet<>();
        status = Status.WANT;
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

    @Override
    public int compareTo(Item o) {
        return this.title.compareTo(o.title);
    }

    public void addTag(String newTag){
        tags.add(newTag);
    }

    public String tagString(){
        StringBuilder sb = new StringBuilder();
        for(String tag : tags){
            if(sb.isEmpty()){
                sb.append(tag);
            }
            sb.append(" | ").append(tag);
        }
        return sb.toString();
    }

    public void updateStatus(Status status){
        this.status = status;
    }

    public String getTitle(){
        return title;
    }


}
