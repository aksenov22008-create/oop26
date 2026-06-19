package src.main.java;

import java.awt.*;

public abstract class GraphicsItem {
    protected  static double canvasWidth;
    protected  static double canvasHeight;

    protected double x;
    protected double y;

    protected double width;
    protected double height;
    public static void setCanvasSize(double canvasWidth,double canvasHeight){
        GraphicsItem.canvasHeight = canvasHeight;
        GraphicsItem.canvasWidth = canvasWidth;
    };

    public abstract void draw(Graphics2D graphics2D);

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public static double getCanvasWidth() {
        return canvasWidth;
    }

    public static double getCanvasHeight() {
        return canvasHeight;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}
