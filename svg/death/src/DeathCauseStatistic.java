import java.util.HashMap;
import java.util.Map;

public class DeathCauseStatistic {
    private final String code;
    public static record Range(int begin,int end){ }
    private Map<Range,Integer> death = new HashMap<>();
    private DeathCauseStatistic(String code){
        this.code=code;
    }
    public static DeathCauseStatistic fromCsvLine(String line){
        String[] filed = line.split(",");
        DeathCauseStatistic statistic=new DeathCauseStatistic(filed[0].trim());
        int begin =0;
        int end = 4;
        for(int i=2;i<filed.length;i++){
            int number;
            try{
                number = Integer.parseInt(filed[i]);
            }catch (NumberFormatException e){
                number=0;
            }
            statistic.death.put(new Range(begin,end),number);
            begin +=5;
            end +=5;
        }
        return statistic;
    }
    public String getCode(){
        return code;
    }
}
