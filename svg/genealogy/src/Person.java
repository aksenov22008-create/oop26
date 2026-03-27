import java.time.LocalDate;
import java.util.Locale;

public class Person {
    private String firstName;
    private String lastName;
    private LocalDate birthday;

    public Person(String firstName, String lastName, LocalDate birthday) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Person{"+" firstName='"+firstName+"'"+" lastName='"+lastName+"'"+"birthday="+birthday+"}";
    }
}
