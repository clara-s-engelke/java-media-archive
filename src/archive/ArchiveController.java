package archive;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ArchiveController {
    private final UserInteraction u;
    private final MediaManager m;

    public ArchiveController(UserInteraction u){
        this.u = u;
        m = new MediaManager();
    }

    public Optional<Integer> menu(){
       List<String> options = new ArrayList<>();
       options.add("add");
       options.add("remove");
       options.add("show");
       options.add("search");

       Optional<String> choice = u.choose(options);
       if(choice.isEmpty()){
           return Optional.empty();
       }
       else{
           String s = choice.get();
           return Optional.of(options.indexOf(s)+1);
       }
    }

    public void handleChoice(int i){
        switch(i){
            case 1 -> m.addMedia();
            case 2 -> m.removeMedia();
            case 3 -> m.showArchive();
            case 4 -> m.search();
        }
    }

    public void exit(){
        m.saveArchive();
    }




}
