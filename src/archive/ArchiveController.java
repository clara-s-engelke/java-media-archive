package archive;

import items.Book;

import items.DVD;
import items.Item;
import items.ItemTypes;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ArchiveController {
    private final Archive a;
    private final Util u;

    public ArchiveController(Util u){
        a = new Archive();
        this.u = u;
    }

    private void addMedia(){
        while(true){
            System.out.println("What piece of media do you want to add?");
            Optional<ItemTypes> type = u.choose(List.of(ItemTypes.values()));
            if(type.isEmpty()){
                return;
            }

            System.out.print("What's the title? ");
            String title = u.readString();
            System.out.println("And when was it released? ");
            int year = u.readInt();

            if(type.get() == ItemTypes.BOOK){

                System.out.print("Who is the author? ");
                String author = u.readString();

                System.out.print("What is the ISBN? (If you want to skip this, type -1)");
                long isbn = u.readLong();

                System.out.print("Lastly, how many pages does the book have? ");
                int pages = u.readInt();

                a.addItem(new Book(title, author, year, a.getNextID(), isbn, pages));
            }

            if(type.get() == ItemTypes.DVD){

                System.out.print("Who is the director? ");
                String director = u.readString();

                System.out.print("How long is the movie (in minutes)?");
                int duration = u.readInt();

                a.addItem(new DVD(title, director, year, a.getNextID(), duration));
            }
        }
    }

    private void removeMedia(){
        Optional<Item> item = u.choose(a.getItems());
        if(item.isEmpty()){
            System.out.println("Nothing to remove!");
           }
        else{
            a.removeItem(item.get());
        }
    }



    public Optional<Integer> menu(){
       List<String> options = new ArrayList<>();
       options.add("add");
       options.add("remove");
       options.add("show");

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
            case 1 -> addMedia();
            case 2 -> removeMedia();
            case 3 -> {
                Optional<List<String>> list = a.showArchive();
                if(list.isEmpty()){
                    System.out.println("No media in Archive!");
                } else{
                    List<String> output = list.get();
                    for(String o : output){
                        System.out.println(o);
                    }
                }
            }
        }
    }




}
