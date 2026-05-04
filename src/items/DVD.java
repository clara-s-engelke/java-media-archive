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
        return "[DVD] " + title + " directed by " + director + ". Runtime: " + duration +"mins" +
                "\n Status: " + status + "\t" + tags.toString();
    }

    @Override
    public String getCharacteristics() {
        return this.title + ";" + this.director + ";" + this.year + ";" + this.duration + ";" + this.id +
                ";" + this.status.getDisplayName() + ";" +  tagString();
    }

    @Override
    public String toString(){
        return super.toString() + " directed by " + director;
    }
}
