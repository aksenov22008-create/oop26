public class main {
    public static void main(String[] args){
        DeathCauseStatistic statistic = DeathCauseStatistic.fromCsvLine("A04.7          ,758,-,-,-,-,-,1,-,1,3,5,9,12,30,58,64,94,161,192,95,33");
        System.out.println("KOD ICD-10:"+statistic.getCode());

        DeathCauseStatistic.AgeBracketDeaths abd = statistic.getAge(77);
        System.out.println(abd);
    }
}
