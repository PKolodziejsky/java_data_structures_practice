import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

//Array implementation
public class ArrayStructure implements Directory {

    private Entry[] entries = new Entry[0];

    public ArrayStructure(Entry[] entries){
        this.entries = entries;
    }
    public ArrayStructure(){

    }
    
    //Starting menu
    
    public void menu() throws EmptyArrayException, NumberFormatException, FileNotFoundException{

        System.out.println("Commands:"+"\n" + "\"load\" to load entries from the file"+"\n"
                +"\"delete\" to delete by number or name "+"\n" +
                "\"lookup\" to find the person by number" + "\n" + "\"change\" to change the number"+"\n"+"> ");

        Scanner sc = new Scanner (System.in);
        String input =sc.next();

        switch(input){

            case "load":
                load();
                break;

            case "delete":

                if(entries.length>=1) {
                    delete();
                }else {
                    throw new EmptyArrayException ("EmptyArrayException: Cannnot delete from an empty list" +"\n");
                }
                break;
            case "lookup":

                if(entries.length>=1) {
                    lookup();
                    menu();
                }else {
                    throw new EmptyArrayException ("EmptyArrayException: Cannot lookup in an empty list" +"\n");
                }
                break;

            case "change":
                if(entries.length>=1) {
                    change();
                }else {
                    throw new EmptyArrayException("EmptyArrayException: Cannot change anything in an empty list" + "\n");
                }
                break;

            default:
                System.out.println("Wrong command");
                menu();
        }
    }
    
//Loading all entries from a file (tab separated name,initials and number)
    
    public void load() throws EmptyArrayException, NumberFormatException, FileNotFoundException{



        File file = new File("H:\\Desktop\\names.txt");
        Scanner read = new Scanner(file);

        while(read.hasNextLine()){

            String[] args = new String[3];
            args = read.nextLine().split("\\t");

            Entry[] entriesnew = Arrays.copyOf(entries, entries.length+1);
            entries = entriesnew;
            int i = entries.length-1;

            Entry e = new Entry(args[0],args[1],args[2]);
            entries[i]=e;

        }
        Arrays.sort(entries);
        printTable();
        menu();

    }

    public void delete() throws EmptyArrayException, NumberFormatException, FileNotFoundException{

        Scanner sc2 = new Scanner(System.in);

        System.out.println("Type in the number or name");

        String in = sc2.next();

        for (Entry q:entries) {

            if (in.equals(q.getName()) || in.equals(q.getNumber())){

                List<Entry> entriesl = new ArrayList<Entry>(Arrays.asList(entries));
                entriesl.remove(q);
                entries = entriesl.toArray(entries);
                entries = Arrays.copyOf(entries,entries.length-1);
                printTable();
                menu();
            }
        }
        System.out.println("Wrong input");
        printTable();
        menu();
    }

    public String lookup() throws EmptyArrayException, NumberFormatException, FileNotFoundException{

        Scanner sc3 = new Scanner(System.in);
        System.out.println("Type in the name");
        int r,l;
        r = entries.length-1;
        l =0;

        String inp = sc3.next();
        while (r>=l){
            int mid =l + (r-l)/2;
            if(inp.equals(entries[mid].getName())){
                System.out.println(entries[mid].getName() + "\'s number: " + entries[mid].getNumber() + "\n");
                return entries[mid].getName();

            }
            if (entries[mid].getName().compareTo(inp)>0){
                r = mid-1;

            }else{
                l=mid+1;

            }

        }
        System.out.println("No such name in directory...");
        return null;
    }

    public void change() throws NumberFormatException, FileNotFoundException, EmptyArrayException{

        Scanner sc4 = new Scanner(System.in);
        System.out.println("Type in the name");
        String inp = sc4.next();
        for (Entry e:entries) {
            if(inp.equals(e.getName())) {
                System.out.println("Type in new number: ");
                e.setNumber(sc4.next());
            }
        }

        printTable();
        menu();
    }

    public void printTable() {
        System.out.println("Your Entries ==================================" );
        {
            for(Entry i : entries)
                System.out.println(i);
        }
        System.out.println("\n");
    }

    public static void main(String[] args) throws NumberFormatException, FileNotFoundException{

        ArrayStructure ad = new ArrayStructure();

        try{

            ad.menu();
        }
        catch(EmptyArrayException ex){
            System.out.println(ex.getMessage());
        }
    }
}
