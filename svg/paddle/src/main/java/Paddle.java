package src.main.java;

import java.awt.*;

public class Paddle extends GraphicsItem{
    public Paddle(){
        this.y=canvasHeight*0.9;
        this.height=canvasHeight *0.02;
        this.width = canvasWidth *0.2;

        this.x = (canvasWidth - width)/2;
    }
    public void updatePosition(double x){
        this.x = Math.clamp(x-this.width/2,0,canvasWidth-width);
    }
    @Override
    public void draw(Graphics2D graphics2D) {
        graphics2D.setColor(new Color(0XE70F37));

        graphics2D.fillRect((int)x,(int)y,(int) width,(int)height);

    }
}
