import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class ICDCodeTabularOptimizedForTime implements ICDCodeTabular{
    public Map<String,String> codeDecriptionMap= new HashMap<>();
    public ICDCodeTabularOptimizedForTime(Path path) {
        try (Stream<String> line = Files.lines(path)) {
            line.skip(88).map(String::trim)
                    .filter(s -> s.matches("[A-Z][0-9]{2}.*"))
                    .map(s -> s.split(" ", 2))
                    .forEach(parts -> codeDecriptionMap.put(parts[0], parts[1]));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public String getDescription(String code) {
        return codeDecriptionMap.getOrDefault(code,"?");
    }
}
