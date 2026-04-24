import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args){
//        try{
//            List<Person> people = Person.fromCsv("family.csv");
//            Person.toBinaryFile(people,"data.bin");
//            List<Person> people2 = Person.fromBinaryFile("data.bin");
//            System.out.println(people2);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        }
        PluntUmlPunner.setJarPath("C:/Users/student/Dowloads/plantuml-1.2026.2");
        String umlData = "@startuml\n" +
                "Alice -> Bob: Authentication Request\n" +
                "Bob --> Alice: Authentication Response\n" +
                "\n" +
                "Alice -> Bob: Another authentication Request\n" +
                "Alice <-- Bob: Another authentication Response\n" +
                "@enduml\n";

        PluntUmlPunner.generator(umlData,"output","test");
    }
}
