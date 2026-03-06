//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args){
        Point p = new Point();

        System.out.println(p.toSvg());
        System.out.println(p);
        p.translate(20F,10F);
        System.out.println(p);

        Point p2=new Point(2.6F,9);
        System.out.println(p2);
    }


}