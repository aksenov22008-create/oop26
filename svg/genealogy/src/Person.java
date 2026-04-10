import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Person implements Comparable{
    private String firstName;
    private String lastName;
    private LocalDate birthday;
    private Set<Person> children = new HashSet<>();

    private LocalDate death;
    public Person getYoungestChild(){
//        Iterator<Person> iter = this.children.iterator();
//        Person now = iter.next();
//        Person youngest = now;
//
//        while(true){
//            if(youngest.birthday.compareTo(now.birthday)<0){
//                youngest=now;
//            }
//            try {
//                iter.next();
//            } catch(NoSuchElementException e){
//                break;
//            }
//
//        }
        if( this.children.isEmpty())return null;
        Person youngest = children.iterator().next();
        for(Person person : children){
            if(youngest.compareTo(person)<0){
                youngest=person;
            }
        }
        return youngest;
    }

    public Person(String firstName, String lastName, LocalDate birthday,LocalDate death) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.death=death;
    }
    public Person (String firstName, String lastName, LocalDate birthday){
        this(firstName,lastName,birthday,null);
    }
    public boolean adopt(Person child){
        if(child == this){return false;}
        return children.add(child);
    }
    public List<Person> getChildren(){
//        List<Person> result = new ArrayList<>();
//        result.addAll(children);
//
//        result.sort(Person::compareTo);
//        return result;
        return children.stream().sorted().toList();
    }
    public static Person fromCsvLine(String line){
        String[] columns = line.split(",",-1);
        String fullName = columns[0];
        String[]  name = fullName.split(" ");
        String fname = name[0];
        String lname = name[1];
        String birth = columns[1];
        String death = columns[2];
        DateTimeFormatter formatter= DateTimeFormatter.ofPattern("d.M.y");
        LocalDate birthdate = LocalDate.parse(birth,formatter);
        LocalDate deathdate =null;
        if(!death.isEmpty()){
            deathdate = LocalDate.parse(death,formatter);
        }
        return new Person(fname,lname,birthdate,deathdate);
    }
    public String name(){
        return String.format("%s %s",firstName,lastName);
    }
    public int compareTo(Person other){
        return this.birthday.compareTo(other.birthday);
    }
    @Override
    public String toString() {
        return "Person{"+" firstName='"+firstName+"'"+" lastName='"+lastName+"'"+" birthday="+birthday+" children="+children+"death"+death+"}";
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
