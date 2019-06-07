import java.util.Comparator;

public class Entry implements Comparable{

    private String name;
    private String initials;
    private String number;

    public Entry(String name,String initials,String number){
        this.name=name;
        this.initials=initials;
        this.number=number;
    }


    @Override
    public String toString() {
        return "Entry: " + "name: " + name + ", initials: " + initials + ", number: " + number;
    }

    public void setName(String name){
        this.name = name;
    }
    public void setInit(String initials){
        this.initials = initials;
    }
    public void setNumber(String number){
        this.number = number;
    }
    public String getNumber(){
        return number;
    }
    public String getName() {
        return name;
    }
    public String getInit() {
        return initials;
    }

    @Override
    public int compareTo(Object x) {
        return this.getName().compareTo(((Entry) x).getName());
    }

}