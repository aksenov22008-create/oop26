import java.time.LocalDate;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

public class Person {
    private String firstName;
    private String lastName;
    private LocalDate birthday;
    private Set<Person> children = new HashSet<>();

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
