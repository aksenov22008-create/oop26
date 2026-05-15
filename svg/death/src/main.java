import java.nio.file.Path;

public class main {
    public static void main(String[] args){
        DeathCauseStatisticList staistics = DeathCauseStatisticList.fromCsv(Path.of("death/src/zgony.csv"));
        int age=70;
        staistics.mostDeadlyDiseases(age,10).stream()
                .forEach(stat -> System.out.println(stat.getCode()+"\t"+ stat.getAge(age).deathCount()));
    }
}
