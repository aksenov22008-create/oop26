package music;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        ImageProcessor procesor = new ImageProcessor();
        procesor.load("imgproc/11729.png");
        long start = System.currentTimeMillis();
        procesor.addBrightness(-100);
        long end = System.currentTimeMillis();
        System.out.println("Czas:"+(end-start));
        long start1 = System.currentTimeMillis();
        procesor.AddBrightnessThreaded(-100);
        long end1 = System.currentTimeMillis();
        System.out.println("Czas:"+(end1-start1));
        procesor.save("imgproc/output.png");
    }
}
