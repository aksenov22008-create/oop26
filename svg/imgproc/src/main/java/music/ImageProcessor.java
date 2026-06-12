package music;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

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

}
