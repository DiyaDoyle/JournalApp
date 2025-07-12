import java.time.*;

class JournalEntry{
    private final LocalDateTime currentDate= LocalDateTime.now();
    private String title;
    private StringBuilder entry;

    public JournalEntry(String title,String entry){
        this.title = title;
        this.entry= new StringBuilder(entry);
    }

    public String getTitle(){
        return title;
    }

    public StringBuilder getEntry(){
        return entry;
    }

    public LocalDateTime getDate(){
        return currentDate;
    }

    public String toString(){
        return "Date: "+currentDate +"\nTitle: "+title+"\n\t\tEntry: \n"+entry.toString();
    }



}