package items;

public abstract class Item {
    int year;
    String title;

    public Item(String title, int releaseYear, int id){
        this.title = title;
        this.year = releaseYear;
    }

    public abstract String displayInfo();


    @Override
    public String toString(){
        return year + ": " + title;
    }

    public boolean equals(Item li){
        return (title.equals(li.title) && year == li.year);
    }

}
