package music;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        ImageProcessor procesor = new ImageProcessor();
        procesor.load("imgproc/11729.png");
        procesor.addBrightness(50);
        procesor.save("imgproc/output.png");
    }
}
