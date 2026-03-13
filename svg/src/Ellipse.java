import java.util.Locale;

public class Ellipse extends Shape{

    private Point center;
    private float rx,ry;

    public Ellipse(Point center, float rx, float ry, Style style){
        super(style);
        this.center=center;
        this.rx=rx;
        this.ry=ry;

    }
    public String toSvg(){
        return String.format(Locale.ENGLISH, "<ellipse rx=\"%f\" ry=\"%f\" cx=\"%f\" cy=\"%f\" style=\"%s\" />",
                rx,ry,center.getX(),center.getY(),style.toSvg());
    }
}
