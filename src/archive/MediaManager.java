package archive;

import items.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MediaManager {
    private final Archive a;
    private final UserInteraction u;


    public MediaManager(){
        a = new Archive("files\\\\books.csv", "files\\\\dvds.csv");
        a.load();
        u = new UserInteraction();
    }

    public void addMedia(){
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

                a.addItem(new DVD(title, director, year, duration, a.getNextID()));
            }
        }
    }

    public void removeMedia(){
        Optional<Item> item = u.choose(a.getItems());
        if(item.isEmpty()){
            System.out.println("Nothing to remove!");
        }
        else{
            a.removeItem(item.get());
        }
    }

    public void showArchive(){
        List<Item> list = a.getItems();
        Util.sortByTitle(list);
        if(list.isEmpty()){
            System.out.println("No media in Archive!");
        } else{
            List<String> display = new ArrayList<>();
            for(Item i : list){
              display.add(i.displayInfo());
            }
            for(String s : display){
                System.out.println(s);
            }
        }
    }

    public void search(){
        System.out.println("What title are you looking for? ");
        String title = u.readString();
        List<Item> hits = Util.binSearch(a.getItems(), title);
        if(hits.isEmpty()){
            System.out.println("Sorry, there's no media with this title");
        } else{
            System.out.println("We found following matches:");
            for(Item item : hits){
                System.out.println(item.displayInfo());
            }
        }
    }

    public void editMedia(){
        System.out.println("First, what item do you want to edit:");
        Optional<Item> choice = u.choose(a.getItems());
        if(choice.isPresent()){
            Item item = choice.get();
            System.out.println("Second, what do you want to edit?");
            List<String> options = new ArrayList<>();
            options.add("status");
            options.add("tags");
            Optional<String> c = u.choose(options);
            if(c.isPresent()){
                String s = c.get();
                if(s.equals("status")){
                    changeStatus(item);
                }else if(s.equals("tags")){
                    addTags(item);
                }
            }
        }
    }

    private void changeStatus(Item i){
        System.out.println("What's the new status?");
        Optional<Status> choice = u.choose(List.of(Status.values()));
        choice.ifPresent(i::updateStatus);
    }

    private void addTags(Item item) {
        System.out.println("Please type all the tags you want to add, devided by comma");
        String[] tags = u.readString().split(",");
        for(String tag : tags){
            tag = tag.strip();
            item.addTag(tag);
            a.newTag(tag);
        }
    }

    public void saveArchive(){
        a.save();
    }
}
