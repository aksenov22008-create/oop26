import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class DeathCauseStatisticList {
    List<DeathCauseStatistic> statistics;
    public static DeathCauseStatisticList fromCsv(Path path)  {
        DeathCauseStatisticList result = new DeathCauseStatisticList();
        try{
            result.statistics= Files.lines(path).skip(1).map(DeathCauseStatistic::fromCsvLine).toList();
        }catch ( IOException e){
            throw new RuntimeException(e);
        }
        return result;
    }
    public List<DeathCauseStatistic> mostDeadlyDiseases(int age,int n){
        return statistics.stream()
                .sorted((sta1,stat2)-> Integer.compare(stat2.getAge(age).deathCount(),sta1.getAge(age).deathCount()))
                .limit(n)
                .toList();
    }
}
