package items;

public abstract class Item {
    int year;
    String title;
    int id;

    public Item(String title, int releaseYear, int id){
        this.title = title;
        this.year = releaseYear;
        this.id = id;
    }

    public abstract String displayInfo();


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

}
