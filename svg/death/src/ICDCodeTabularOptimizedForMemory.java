import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class ICDCodeTabularOptimizedForMemory implements ICDCodeTabular{
    private Path path;
    public ICDCodeTabularOptimizedForMemory(Path path){
        this.path=path;
    }
    public String getDescription(String code) {
        try (Stream<String> line = Files.lines(path)) {
            return line.skip(88).map(String::trim)
                    .filter(s -> s.matches("[A-Z][0-9]{2}.*"))
                    .map(s -> s.split(" ", 2))
                    .filter(parts -> parts[0].equals(code))
                    .findFirst().map(parts -> parts[1]).orElse("?");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
