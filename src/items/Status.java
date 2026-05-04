package items;

public enum Status {
    WANT("want"),
    CURRENT("current"),
    FINISHED("finished");

    private final String displayName;

    Status(String displayName){
        this.displayName = displayName;
    }

    public String getDisplayName(){
        return displayName;
    }
}
