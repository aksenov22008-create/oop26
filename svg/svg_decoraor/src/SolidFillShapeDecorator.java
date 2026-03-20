public class SolidFillShapeDecorator extends ShapeDecorator{

    private String color;

    public SolidFillShapeDecorator(Shape decoratorShape, String color) {
        super(decoratorShape);
        this.color = color;
    }

    @Override
    public String toSvg() {
        return decoratorShape.toSvg().replace("/",String.format("fill=\"%s\"/>",color));
    }
}
