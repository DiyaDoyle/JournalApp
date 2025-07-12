import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        JournalManager JM= new JournalManager();

        while(true){
            System.out.println("MENU");
            System.out.println("1. Add an Entry");
            System.out.println("2. List Saved Entries");
            System.out.println("3. Exit");
            System.out.println("Choose an option: ");

            int choice = sc.nextInt();
            sc.nextLine();
            switch(choice){
                case 1:
                System.out.println("Enter the title of the entry: ");
                String title= sc.nextLine();
                System.out.println("Enter the entry that you want to add to today's jounal: ");
                System.out.println("(Type '::end' on a new line to finish your entry)");
                StringBuilder entry= new StringBuilder();
                while (true) { 
                    String line=sc.nextLine();
                    if(line.equalsIgnoreCase("::end")){
                        break;
                    }
                    entry.append(line).append("\n");
                    
                }
                try{
                JM.addEntry(title, entry.toString());
                }
                catch(Exception e){
                    System.out.println("Cannot add entry : "+e.getMessage());
                }
                break;

                case 2:
                List<String> entries= JM.listAllEntries();
                if(entries.isEmpty()){
                    System.out.println("No entries have been added");
                }
                else{
                    System.out.println("Entries added are: ");
                    for(String str: entries){
                        System.out.println(str);
                    }
                }
                break;

                case 3:  
                return;

                default:
                System.err.println("Invalid option");;

            
            }
            }


        }

}
    

