import java.util.Locale;

public class SvgScene {
    private Polygon[] polygons = new Polygon[3];

    private int index = 0;

    public void addPolygon(Polygon p){
        polygons[index]= p;
        index ++;
        if(index == 3 ){
            index = 0;
        }

    }
    public String toSvg(){
        StringBuilder polygonsString = new StringBuilder();
        for(Polygon p : polygons){
            if(p != null){
                polygonsString.append(p.toSvg()).append("\n");
            }
        }
        return String.format(Locale.ENGLISH, "<svg height=\"100\" width=\"100\" xmlns=\"http://www.w3.org/2000/svg\">%s</svg>",polygonsString);
    }
}
