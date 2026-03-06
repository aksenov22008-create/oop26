import java.util.Arrays;
import java.util.Locale;

public class Polygon {
    private Point[] points;
    public Polygon(Point[] points){
        this.points = points;
    }
    public String toString(){
        return "Polygon{points="+ Arrays.toString(points)+"}";
    }
    public String toSvg(){
        String pointstring =" ";
        for (Point point : points){
            pointstring += point.getX()+","+point.getY()+" ";
        }
        return String.format(Locale.ENGLISH, "<polygon points=\"%s\" style \"fill:lime;stroke:purple;sroke-width:3\" />",pointstring);
    }
}
