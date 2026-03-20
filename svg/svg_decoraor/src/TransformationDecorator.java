import java.util.Locale;

public class TransformationDecorator extends ShapeDecorator{

    private String transform;

    public TransformationDecorator(Shape decoratorShape, Vec2 translation,double rotate,Vec2 scal) {
        super(decoratorShape);
        Builder builder = new Builder().translate(translation).rotation(rotate).scale(scal);
        this.transform=builder.build();
    }

    @Override
    public String toSvg() {
        return this.decoratorShape.toSvg().replace("/>",
                String.format("transform=\"%s\"/>",transform));
    }
    public static class Builder{
        private Vec2 translation;
        private double rotation;
        private Vec2 scale;

        public Builder translate(Vec2 translation){
            this.translation=translation;
            return this;
        }

        public Builder rotation(double rotation) {
            this.rotation = rotation;
            return this;
        }

        public Builder scale(Vec2 scale) {
            this.scale = scale;
            return this;
        }

        public String build(){
            StringBuilder result = new StringBuilder();
            if(translation != null){
                result.append(String.format(Locale.ENGLISH,"translate(%f,%f) ",translation.x(),translation.y()));
            }
            if(rotation != 0){
                result.append(String.format(Locale.ENGLISH,"rotate(%f) ",rotation));
            }
            if(scale != null){
                result.append(String.format(Locale.ENGLISH,"scale(%f,%f) ",scale.x(),scale.y()));
            }
        return result.toString();
        }
    }
}
