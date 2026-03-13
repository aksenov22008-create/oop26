import java.util.Arrays;
import java.util.Locale;

public class Polygon extends Shape{
    private Point[] points;
    //private Style style;
    public Polygon(Point[] points ,Style style){
        super(style);
        this.points = new Point[points.length];
        this.style=style;
        for(int i = 0;i<points.length;i++){
            this.points[i] = new Point(points[i]);
        }
    }
    public Polygon(Point[] points){
        this(points, new Style("transparen","black",1.0));
    }

    public Polygon(Polygon p){
        this(p.points);
    }

    public String toString(){
        return "Polygon{points="+ Arrays.toString(points)+"}";
    }
    public String toSvg(){
        String pointstring =" ";
        for (Point point : points){
            pointstring += point.getX()+","+point.getY()+" ";
        }

        return String.format(Locale.ENGLISH,
                "<polygon points=\"%s\" style= \"%s\" />",pointstring,style.toSvg());
    }
    public BoundingBox boundingBox(){
        if(points.length == 0){
            return new BoundingBox(0,0,0,0);
        }
        float minX= points[0].getX();
        float maxX= points[0].getX();
        float minY= points[0].getY();
        float maxY= points[0].getY();
        for(Point p : points){
            if(p.getX()< minX) minX = p.getX();
            if(p.getX()> maxX) maxX = p.getX();
            if(p.getY()< minY) minY = p.getY();
            if(p.getY()> maxY) maxY = p.getY();
        }
        return new BoundingBox(minX,minY,maxX-minX,maxY-minY);
    }
    public static Polygon square(Segment segment, Style style){
        Segment perp = segment.perpendicular();

        Point[] pointSquare = new Point[4];
        pointSquare[0]= segment.getP();
        pointSquare[1]= perp.getP();
        pointSquare[2]= segment.getQ();
        pointSquare[3]= perp.getQ();

        return new Polygon(pointSquare, style);
    }
}
