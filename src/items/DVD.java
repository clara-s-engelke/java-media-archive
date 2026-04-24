package items;

public class DVD extends Item {
    private final int duration;
    private final String director;

    public DVD(String title, String director, int year, int duration, int id) {
        super(title, year, id);
        this.director = director;
        this.duration = duration;

    }

    @Override
    public String displayInfo() {
        return "[DVD] " + title + " directed by " + director + ". Runtime: " + duration +"mins";
    }

    @Override
    public String toString(){
        return super.toString() + " directed by " + director;
    }
}
