import java.nio.file.Path;

public class main {
    public static void main(String[] args){
        DeathCauseStatisticList staistics = DeathCauseStatisticList.fromCsv(Path.of("death/src/zgony.csv"));
        int age=70;
        ICDCodeTabular icd = new ICDCodeTabularOptimizedForTime(Path.of("death/src/icd10.txt"));
        staistics.mostDeadlyDiseases(age,10).stream()
                .forEach(stat -> System.out.println(stat.getCode()+"\t"+ stat.getAge(age).deathCount()
                                +" "+icd.getDescription(stat.getCode())
                        ));
    }
}
