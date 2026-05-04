package archive;

import items.Book;
import items.DVD;
import items.Item;
import items.Status;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Archive {
    private List<Item> items;
    private Set<String> allTags;
    private int id_Counter;
    private final File bookFile;
    private final File dvdFile;

    public Archive(String bookPath, String dvdPath){
        items = new ArrayList<>();
        id_Counter = 0;
        bookFile = new File(bookPath);
        dvdFile = new File(dvdPath);
        allTags = new HashSet<>();
    }

    public void addItem(Item item){
        items.add(item);
        id_Counter++;
    }

    public void removeItem(Item item){
            items.remove(item);
    }

    public void newTag(String tag){
        allTags.add(tag);
    }

    public void save(){
        try(BufferedWriter bookW = new BufferedWriter(new FileWriter(bookFile));
            BufferedWriter dvdW = new BufferedWriter(new FileWriter(dvdFile))) {
            if(items.isEmpty()){
                return;
            }
            for (Item item : items) {
                if (item.getClass() == Book.class) {
                    bookW.write(item.getCharacteristics());
                    bookW.newLine();
                } else if (item.getClass() == DVD.class) {
                    dvdW.write(item.getCharacteristics());
                    dvdW.newLine();
                }
            }
        } catch (IOException ioe){
            System.out.println("Error while saving the data...");
        }
    }

    public void load() {
        try(BufferedReader bookR = new BufferedReader(new FileReader(bookFile))){
            String s = bookR.readLine();
            while(s != null) {
                String[] parts = s.split(";");
                Book book = new Book(parts[0], parts[1], Integer.parseInt(parts[2]),
                        Integer.parseInt(parts[3]), Long.parseLong(parts[4]), Integer.parseInt(parts[5]));
                items.add(book);
                if(parts.length < 8){
                    s = bookR.readLine();
                    continue;
                }
                String[] tags = parts[7].split(" \\| ");
                for(String tag : tags){
                    book.addTag(tag);
                }
                if(parts[6].equals(Status.CURRENT.getDisplayName())){
                    book.updateStatus(Status.CURRENT);
                } else if (parts[6].equals(Status.FINISHED.getDisplayName())){
                    book.updateStatus(Status.FINISHED);
                } else{
                    book.updateStatus(Status.WANT);
                }
                s = bookR.readLine();
            }
        }catch(IOException ioe){
            System.out.println("Error while loading media of type \"book\"");
        }
        try(BufferedReader dvdR = new BufferedReader(new FileReader(dvdFile))){
            String s = dvdR.readLine();
            while(s != null) {
                String[] parts = s.split(";");
                DVD dvd = new DVD(parts[0], parts[1], Integer.parseInt(parts[2]),
                        Integer.parseInt(parts[3]), Integer.parseInt(parts[4]));
                items.add(dvd);
                String[] tags = parts[6].split(" \\| ");
                for(String tag : tags){
                    dvd.addTag(tag);
                }
                if(parts[5].equals(Status.CURRENT.getDisplayName())){
                    dvd.updateStatus(Status.CURRENT);
                } else if (parts[5].equals(Status.FINISHED.getDisplayName())){
                    dvd.updateStatus(Status.FINISHED);
                } else{
                    dvd.updateStatus(Status.WANT);
                }
                s = dvdR.readLine();
            }
        }catch(IOException ioe){
            System.out.println("Error while loading media of type \"dvd\"");
        }
    }

    public List<Item> getItems(){
        return items;
    }

    public Set<String> getAllTags(){
        return allTags;
    }
    public int getNextID(){
        return id_Counter+1;
    }
}

