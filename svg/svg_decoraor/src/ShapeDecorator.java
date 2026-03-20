public class ShapeDecorator implements Shape{

    protected Shape decoratorShape;

    public ShapeDecorator(Shape decoratorShape) {
        this.decoratorShape = decoratorShape;
    }

    @Override
    public BoundingBox boundingBox() {
        return decoratorShape.boundingBox();
    }

    @Override
    public String toSvg() {
        return null;
    }
}
