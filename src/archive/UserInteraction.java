package archive;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class UserInteraction {
    private final Scanner s;

    public UserInteraction(){
        s = new Scanner(System.in);
    }
    public <T> Optional<T> choose(List<T> choices){
        if(choices.isEmpty()){
            throw new RuntimeException();
        }

        for(int i = 0; i< choices.size(); i++){
            System.out.println((i+1) + " - " + choices.get(i));
        }
        System.out.println((choices.size()+1) + " - " + "EXIT");

        while(true){
            System.out.print("Please choose one of the options: ");
            int choice = readInt();
            if(choice >= 1 && choice<choices.size()+1){
                return Optional.of(choices.get(choice-1));
            } else if (choice == choices.size()+1) {
                return Optional.empty();
            } else{
                System.out.println("Invalid choice, please try again!\n");
            }
        }
    }

    public int readInt(){
        while(true){
            try{
                return Integer.parseInt(s.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Not a number! Please try again: ");
            }
        }
    }

    public long readLong(){
        while(true){
            try{
                return Long.parseLong(s.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Not a number! Please try again: ");
            }
        }
    }

    public String readString(){
        return s.nextLine();
    }
}
