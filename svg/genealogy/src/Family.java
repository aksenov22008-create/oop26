import java.util.HashMap;
import java.util.Map;

public class Family {
    private Map<String,Person> people= new HashMap<>();

    public void add(Person... person){
        for(Person p : person){
            this.people.put(p.name(),p);
        }
    }
    public Person get(String key){
        return people.get(key);
    }
}
