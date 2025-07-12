import java.io.*;
import java.time.format.DateTimeFormatter;
import java.util.*;


public class JournalManager {
    List<JournalEntry> entries = new ArrayList<>();

    public void addEntry(String title, String entry) throws IOException{
        JournalEntry JE= new JournalEntry(title, entry);
        entries.add(JE);
        saveEntryToFile(JE);
    }



    public void saveEntryToFile(JournalEntry entry) throws IOException{

        DateTimeFormatter formatter= DateTimeFormatter.ofPattern("yyyyMMdd_HHmm");
        String date= entry.getDate().format(formatter);
        
        String title= entry.getTitle();
        String safeName= title.replaceAll("[^a-zA-Z0-9]", "_");
        String fileName= "./Entries/"+safeName+"_"+date+".txt";

        FileWriter writer= new FileWriter(fileName);

        writer.write("Date: "+entry.getDate()+"\n");
        writer.write("Title: "+entry.getTitle()+"\n");
        writer.write(entry.getEntry().toString());

        writer.close();
    
    }


    public List<String> listAllEntries(){
        List<String> list= new ArrayList<>();
        File folder = new File("./Entries/");
        File[] files= folder.listFiles((dir, name) -> name.endsWith(".txt"));

        if(files==null){
            return list;
        }

        for(File f: files){
            String res= f.getName();
            list.add(res);
        }

        return list;
    }





}
