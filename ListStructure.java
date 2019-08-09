import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

//LinkedList implementation

public class ListStructure implements Directory {

    private List<Entry> entries = new LinkedList<>();


    public ListStructure(List<Entry> entries){
        this.entries = entries;
    }

    public ListStructure(){

    }

    public void menu() throws EmptyArrayException, NumberFormatException, FileNotFoundException{

        System.out.println("Type:"+"\n" + "\"load\" to load entries from the file"+"\n" + "\"delete\" to delete by number or name "+"\n" +
                "\"lookup\" to find the person by number" + "\n" + "\"change\" to change the number");

        Scanner sc = new Scanner (System.in);
        String input =sc.next();

        switch(input){

            case "load":
                load();
                break;

            case "delete":

                if(entries.size()>=1) {
                    delete();
                }else {
                    throw new EmptyArrayException ("EmptyArrayException: Cannnot delete from an empty list" +"\n");
                }
                break;
            case "lookup":

                if(entries.size()>=1) {
                    lookup();
                    menu();
                }else {
                    throw new EmptyArrayException ("EmptyArrayException: Cannot lookup in an empty list" +"\n");
                }
                break;

            case "change":
                if(entries.size()>=1) {
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

    @SuppressWarnings("unchecked")
    public void load() throws EmptyArrayException, NumberFormatException, FileNotFoundException{

        File file = new File("H:\\Desktop\\names.txt");
        Scanner read = new Scanner(file);

        while(read.hasNextLine()){

            String[] args = new String[3];
            args = read.nextLine().split("\\t");

            Entry e = new Entry(args[0],args[1],args[2]);
            entries.add(e);

        }

        Collections.sort(entries);
        printTable();
        menu();
    }

    public void delete() throws EmptyArrayException, NumberFormatException, FileNotFoundException{

        Scanner sc2 = new Scanner(System.in);

        System.out.println("Type in the number or name");

        String in = sc2.next();

        for (Iterator<Entry> iterator = entries.iterator(); iterator.hasNext();) {
            Entry current = iterator.next();
            if (in.equals(current.getName()) || in.equals(current.getNumber())){

                iterator.remove();
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

        String inp = sc3.next();


        for (Iterator<Entry> iterator = entries.iterator(); iterator.hasNext();) {
            Entry current = iterator.next();
            if(inp.equals(current.getName())) {
                System.out.println(current.getName() + "\'s number: " + current.getNumber() + "\n");
                return current.getName();

            }

        }
        System.out.println("No such name in directory...");
        return null;
    }
    public void change() throws NumberFormatException, FileNotFoundException, EmptyArrayException{

        Scanner sc3 = new Scanner(System.in);
        System.out.println("Type in the name");
        String inp = sc3.next();
        for (Iterator<Entry> iterator = entries.iterator(); iterator.hasNext();) {
            Entry current = iterator.next();
            if(inp.equals(current.getName())) {
                System.out.println("Type in new number: ");
                current.setNumber(sc3.next());
            }
        }

        printTable();
        menu();
    }

    public void printTable() {
        System.out.println("Your Entries ==================================" );
        {
            for(Iterator<Entry> iterator = entries.iterator(); iterator.hasNext();){
                System.out.println(iterator.next());
            }
            System.out.println("\n");
        }
    }


    public static void main(String[] args) throws NumberFormatException, FileNotFoundException{

        ListStructure ld = new ListStructure();

        try{

            ld.menu();
        }
        catch(EmptyArrayException ex){
            System.out.println(ex.getMessage());
        }
    }



}
