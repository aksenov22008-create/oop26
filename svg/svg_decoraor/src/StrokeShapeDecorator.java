import java.util.Locale;

public class StrokeShapeDecorator extends ShapeDecorator {
    private  final String color;
    private final double width;

    public StrokeShapeDecorator(Shape decoratorShape, String color, double width) {
        super(decoratorShape);
        this.color = color;
        this.width = width;
    }

    @Override
    public String toSvg() {
        return this.decoratorShape.toSvg().replace("/>",String.format(Locale.ENGLISH," stroke=\"%s\" stroke-width=\"%f\"/>",this.color,this.width));
    }
}
