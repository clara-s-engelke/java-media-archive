package archive;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        UserInteraction u = new UserInteraction();
        ArchiveController ac = new ArchiveController(u);

        while(true){
           Optional<Integer> i = ac.mainMenu();
           if(i.isEmpty()){
               ac.exit();
               break;
           } else{
               ac.handleChoice(i.get());
           }
        }
    }
}
