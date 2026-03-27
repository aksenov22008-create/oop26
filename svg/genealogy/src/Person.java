import java.time.LocalDate;
import java.util.*;

public class Person {
    private String firstName;
    private String lastName;
    private LocalDate birthday;
    private Set<Person> children = new HashSet<>();
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
            if(youngest.birthday.compareTo(person.birthday)<0){
                youngest=person;
            }
        }
        return youngest;
    }

    public Person(String firstName, String lastName, LocalDate birthday) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
    }
    public boolean adopt(Person child){
        if(child == this){return false;}
        return children.add(child);
    }
    @Override
    public String toString() {
        return "Person{"+" firstName='"+firstName+"'"+" lastName='"+lastName+"'"+" birthday="+birthday+" children="+children+"}";
    }
}
