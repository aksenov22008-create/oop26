import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class PersonWithParentString {

    private Person person;
    private String[] parents;

    public PersonWithParentString(Person peron,String[] parents){
        this.person=peron;
        this.parents=parents;
    }
    public static PersonWithParentString fromCsvLine(String line) throws NegativeLifespanException {
        Person person = Person.fromCsvLine(line);
        String[] columns = line.split(",",-1);
        return new PersonWithParentString(person, Arrays.copyOfRange(columns,3,5));
    }
    public String name(){
        return this.person.name();
    }
    public static void connectRelaives(Map<String,PersonWithParentString> peopleMap){
        for(PersonWithParentString child : peopleMap.values()){
            for(String parentString : child.parents){
                if(!parentString.isEmpty()){
                    peopleMap.get(parentString).person.adopt(child.person);}
            }
        }
    }
    public static List<Person> unpackMap(Map<String,PersonWithParentString> people){
        ArrayList<Person> peopleResult = new ArrayList<>();
        for(PersonWithParentString personWithParentString : people.values()){
            peopleResult.add(personWithParentString.person);
        }
        return peopleResult;
    }
}
