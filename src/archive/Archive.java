package archive;

import items.Book;
import items.DVD;
import items.Item;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Archive {
    private List<Item> items;
    private int id_Counter;
    private final File bookFile;
    private final File dvdFile;

    public Archive(String bookPath, String dvdPath){
        items = new ArrayList<>();
        id_Counter = 0;
        bookFile = new File(bookPath);
        dvdFile = new File(dvdPath);
    }

    public void addItem(Item item){
        items.add(item);
        id_Counter++;
    }

    public void removeItem(Item item){
            items.remove(item);
    }

    public int getNextID(){
        return id_Counter+1;
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
            System.out.println("Error while saving... It may be your changes have not been saved");;
        }
    }

    public void load(){
        try(BufferedReader bookR = new BufferedReader(new FileReader(bookFile))){
            String s = bookR.readLine();
            while(s != null) {
                String[] parts = s.split(";");
                Book book = new Book(parts[0], parts[1], Integer.parseInt(parts[2]),
                        Integer.parseInt(parts[3]), Long.parseLong(parts[4]), Integer.parseInt(parts[5]));
                items.add(book);
                s = bookR.readLine();
            }
        }catch(IOException ioe){
            System.out.println("Error while Loading books, this media may not be displayed correctly");
        }
        try(BufferedReader dvdR = new BufferedReader(new FileReader(dvdFile))){
            String s = dvdR.readLine();
            while(s != null) {
                String[] parts = s.split(";");
                DVD dvd = new DVD(parts[0], parts[1], Integer.parseInt(parts[2]),
                        Integer.parseInt(parts[3]), Integer.parseInt(parts[4]));
                items.add(dvd);
                s = dvdR.readLine();
            }
        }catch(IOException ioe){
            System.out.println("Error while Loading dvds, this media may not be displayed correctly");
        }
    }

    public List<Item> getItems(){
        return items;
    }
}

