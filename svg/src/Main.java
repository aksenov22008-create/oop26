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
    }
}