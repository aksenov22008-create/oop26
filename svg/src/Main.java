//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args){
        System.out.println("Hello world");
        Point p = new Point();

        p.x = 5F;
        p.y = 7.5F;

        System.out.println(p.toSvg());
        System.out.println(p);
        p.translate(p.x,p.y);
        System.out.println(p);

        Point p2= p.translated(-30F,-0.5F);
        System.out.println(p2);

        Segment s = new Segment();
        s.p = p;
        s.q= p2;
        System.out.println(s.length());

        Point p3 =new Point();
        p3.x = 12;
        p3.y = 7;
        Point p4 =new Point();
        p4.x = 8;
        p4.y = 15;
        Segment s2= new Segment();
        s2.p = p3;
        s2.q = p4;

        Point p5 =new Point();
        p3.x = 5;
        p3.y = 6;
        Point p6 =new Point();
        p4.x = 7;
        p4.y = 8;
        Segment s3= new Segment();
        s3.p = p5;
        s3.q = p6;

        Segment [] segments = new Segment[3];
        segments[0] = s;
        segments[1] = s2;
        segments[2] = s3;

        System.out.println(findMax(segments).p);
    }

    public static Segment findMax(Segment[] segments){
        Segment maxSeg = segments[0];
        for (Segment s : segments){
            if (s.length() > maxSeg.length()) maxSeg=s;
        }
        return maxSeg;
    }
}