import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.io.File;
import java.io.FileNotFoundException;

//Creating a HashSet of Lists
public class HashStructure implements Directory  {

    public HashStructure(){

    }

    private Set<List<Entry>> entries = new HashSet<>();

//One list for every letter in an alphabet to store entries alphabetically
    
    List<Entry> a_let = new LinkedList<>();
    List<Entry> b_let = new LinkedList<>();
    List<Entry> c_let = new LinkedList<>();
    List<Entry> d_let = new LinkedList<>();
    List<Entry> e_let = new LinkedList<>();
    List<Entry> f_let = new LinkedList<>();
    List<Entry> g_let = new LinkedList<>();
    List<Entry> h_let = new LinkedList<>();
    List<Entry> i_let = new LinkedList<>();
    List<Entry> j_let = new LinkedList<>();
    List<Entry> k_let = new LinkedList<>();
    List<Entry> l_let = new LinkedList<>();
    List<Entry> m_let = new LinkedList<>();
    List<Entry> n_let = new LinkedList<>();
    List<Entry> o_let = new LinkedList<>();
    List<Entry> p_let = new LinkedList<>();
    List<Entry> r_let = new LinkedList<>();
    List<Entry> s_let = new LinkedList<>();
    List<Entry> t_let = new LinkedList<>();
    List<Entry> q_let = new LinkedList<>();
    List<Entry> u_let = new LinkedList<>();
    List<Entry> w_let = new LinkedList<>();
    List<Entry> x_let = new LinkedList<>();
    List<Entry> y_let = new LinkedList<>();
    List<Entry> z_let = new LinkedList<>();


    public void menu() throws EmptyArrayException, NumberFormatException, FileNotFoundException{

        System.out.println("Commands:"+"\n" + "\"load\" to load entries from the file"+"\n" + "\"delete\" to delete by number or name "+"\n" +
                "\"lookup\" to find the person by number" + "\n" + "\"change\" to change the number"+"\n"+"> ");

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


    public void load() throws EmptyArrayException, NumberFormatException, FileNotFoundException{

        File file = new File("H:\\Desktop\\names.txt");
        Scanner read = new Scanner(file);

        while(read.hasNextLine()){

            String[] args = new String[3];
            args = read.nextLine().split("\\t");

            Entry e = new Entry(args[0],args[1],args[2]);
            char first = e.getName().charAt(0);

            switch(first){
                case 'A':
                    a_let.add(e);
                    break;
                case 'B':
                    b_let.add(e);
                    break;
                case 'C':
                    c_let.add(e);
                    break;
                case 'D':
                    d_let.add(e);
                    break;
                case 'E':
                    e_let.add(e);
                    break;
                case 'F':
                    f_let.add(e);
                    break;
                case 'G':
                    g_let.add(e);
                    break;
                case 'H':
                    h_let.add(e);
                    break;
                case 'I':
                    i_let.add(e);
                    break;
                case 'J':
                    j_let.add(e);
                    break;
                case 'K':
                    k_let.add(e);
                    break;
                case 'L':
                    l_let.add(e);
                    break;
                case 'M':
                    m_let.add(e);
                    break;
                case 'N':
                    n_let.add(e);
                    break;
                case 'O':
                    o_let.add(e);
                    break;
                case 'P':
                    p_let.add(e);
                    break;
                case 'R':
                    r_let.add(e);
                    break;
                case 'S':
                    s_let.add(e);
                    break;
                case 'T':
                    t_let.add(e);
                    break;
                case 'Q':
                    q_let.add(e);
                    break;
                case 'U':
                    u_let.add(e);
                    break;
                case 'W':
                    w_let.add(e);
                    break;
                case 'X':
                    x_let.add(e);
                    break;
                case 'Y':
                    y_let.add(e);
                    break;
                case 'Z':
                    z_let.add(e);
                    break;
            }
        }
        entries.add(a_let);
        entries.add(b_let);
        entries.add(c_let);
        entries.add(d_let);
        entries.add(e_let);
        entries.add(f_let);
        entries.add(g_let);
        entries.add(h_let);
        entries.add(i_let);
        entries.add(j_let);
        entries.add(k_let);
        entries.add(l_let);
        entries.add(m_let);
        entries.add(n_let);
        entries.add(o_let);
        entries.add(p_let);
        entries.add(r_let);
        entries.add(s_let);
        entries.add(t_let);
        entries.add(q_let);
        entries.add(u_let);
        entries.add(w_let);
        entries.add(x_let);
        entries.add(y_let);
        entries.add(z_let);
        printTable();
        menu();

    }

    public void delete() throws EmptyArrayException, NumberFormatException, FileNotFoundException{

        Scanner sc2 = new Scanner(System.in);

        System.out.println("Type in the number or name");

        String in = sc2.next();

        for (Iterator<List<Entry>> iterator = entries.iterator(); iterator.hasNext();) {
            for(Iterator<Entry> iterator1 = iterator.next().iterator();iterator1.hasNext();){
                Entry current = iterator1.next();
                if (in.equals(current.getName()) || in.equals(current.getNumber())){

                    iterator1.remove();
                    printTable();
                    menu();
                }
            }
        }
        System.out.println("Wrong input");
        printTable();
        menu();
    }

    public void change() throws NumberFormatException, FileNotFoundException, EmptyArrayException{

        Scanner sc3 = new Scanner(System.in);
        System.out.println("Type in the name");
        String inp = sc3.next();
        for (Iterator<List<Entry>> iterator = entries.iterator(); iterator.hasNext();) {
            for(Iterator<Entry> iterator1 = iterator.next().iterator();iterator1.hasNext();){
                Entry current = iterator1.next();
                if(inp.equals(current.getName())) {
                    System.out.println("Type in new number: ");
                    current.setNumber(sc3.next());
                }
            }
        }

        printTable();
        menu();
    }
    public String lookup() throws EmptyArrayException, NumberFormatException, FileNotFoundException{

        Scanner sc3 = new Scanner(System.in);
        System.out.println("Type in the name");

        String inp = sc3.next();


        for (Iterator<List<Entry>> iterator = entries.iterator(); iterator.hasNext();) {
            for(Iterator<Entry> iterator1 = iterator.next().iterator();iterator1.hasNext();){
                Entry current = iterator1.next();
                if(inp.equals(current.getName())) {
                    System.out.println(current.getName() + "\'s number: " + current.getNumber() + "\n");
                    return current.getName();

                }
            }
        }

        System.out.println("No such name in directory...");
        return null;
    }
    public void printTable() {
        System.out.println("Your Entries ==================================" );
        {
            for(Iterator<List<Entry>> iterator = entries.iterator(); iterator.hasNext();){
                for(Iterator<Entry> iterator1 = iterator.next().iterator();iterator1.hasNext();){
                    System.out.println(iterator1.next());
                }
            }
            System.out.println("\n");
        }
    }

    public static void main(String[] args) throws NumberFormatException, FileNotFoundException, EmptyArrayException{
        HashStructure hd  = new HashStructure();
        try{
            hd.menu();

        }
        catch(EmptyArrayException ex){
            System.out.println(ex.getMessage());
        }
    }
}
