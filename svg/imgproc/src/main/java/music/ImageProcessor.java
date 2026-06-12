package music;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static java.lang.Math.clamp;

public class ImageProcessor {
    private BufferedImage img;
    public void load(String path) throws IOException {
        File file = new File(path);
        this.img = ImageIO.read(file);
    }
    public void save(String path) throws IOException {
        File file = new File(path);
        ImageIO.write(this.img,"png",file);
    }
    public void addBrightness(int amount){
        for(int y = 0;y<img.getHeight();y++){
            for(int x = 0;x<img.getWidth();x++){
                int color =img.getRGB(x,y);
                int blue = color & 0x0000FF;
                int green = (color & 0x00FF00)>>8;
                int red = (color & 0xFF0000)>>16;

                blue = clamp(blue + amount,0,255);
                green = clamp(green + amount,0,255);
                red = clamp(red + amount,0,255);

                int newColor = blue | (green << 8) | (red << 16);
                img.setRGB(x,y,newColor);
            }
        }
    }
}
