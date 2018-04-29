// Loris Witschard & Nicolas Bovet
package project07;

import oop.lib.Paintable;
import oop.project.Bench;

import java.awt.*;
import java.util.ListIterator;


public class Test extends Bench
{

    final double UNIT = 60;
    final double SMALL_TRIANGLE_SIDE = UNIT;
    final double SMALL_TRIANGLE_HYP = Triangle.hypothenus(SMALL_TRIANGLE_SIDE,SMALL_TRIANGLE_SIDE);
    final double SMALL_TRIANGLE_HEIGHT = Math.sqrt(-Math.pow(SMALL_TRIANGLE_HYP/2,2)+Math.pow(UNIT,2));
    final double AVERAGE_TRIANGLE_SIDE = Triangle.hypothenus(UNIT,UNIT);
    final double AVERAGE_TRIANGLE_HYP = Triangle.hypothenus(AVERAGE_TRIANGLE_SIDE,AVERAGE_TRIANGLE_SIDE);
    final double AVERAGE_TRIANGLE_HEIGHT = Math.sqrt(-Math.pow(AVERAGE_TRIANGLE_HYP/2,2)+Math.pow(AVERAGE_TRIANGLE_SIDE,2));
    final double LARGE_TRIANGLE_SIDE = UNIT*2;
    final double LARGE_TRIANGLE_HYP = Triangle.hypothenus(LARGE_TRIANGLE_SIDE,LARGE_TRIANGLE_SIDE);
    final double LARGE_TRIANGLE_HEIGHT = Math.sqrt(-Math.pow(LARGE_TRIANGLE_HYP/2,2)+Math.pow(LARGE_TRIANGLE_SIDE,2));
    final double SQUARE_DIAGONAL = UNIT*Math.sqrt(2);
    List<Paintable> paintableList = new List<>();
    List<Shape> shape = new List<>();


    public static void main(String[] args)
    {
        new Test();
    }


    private Square carre = new Square(UNIT, Color.BLACK);
    private Triangle smallTri01 = new Triangle(Color.RED, SMALL_TRIANGLE_HYP,SMALL_TRIANGLE_HEIGHT,0);
    private Triangle smallTri02 = new Triangle(Color.GREEN,SMALL_TRIANGLE_HYP,SMALL_TRIANGLE_HEIGHT,0);
    private Triangle averaTri01 = new Triangle(Color.GRAY,AVERAGE_TRIANGLE_HYP,AVERAGE_TRIANGLE_HEIGHT,0);
    private Parallelogram para = new Parallelogram(Color.BLUE,SMALL_TRIANGLE_HYP,SMALL_TRIANGLE_HYP/2,SMALL_TRIANGLE_HYP/2);
    private Triangle largeTri01 = new Triangle(Color.MAGENTA,LARGE_TRIANGLE_HYP,LARGE_TRIANGLE_HEIGHT,0);
    private Triangle largeTri02 = new Triangle(Color.ORANGE,LARGE_TRIANGLE_HYP,LARGE_TRIANGLE_HEIGHT,0);
    private Circle circle = new Circle(new project07.Point(45,-10),33,Color.RED);
    private int counter = 0;

    @Override
    public void init()
    {


        System.out.println(SMALL_TRIANGLE_HEIGHT);

        defineCoordinates(300,200,1,true);
        getPanel().setContent(paintableList);
        paintableList.add(para);
        shape.add(para);
        paintableList.add(largeTri01);
        shape.add(largeTri01);
        paintableList.add(smallTri01);
        shape.add(smallTri01);
        paintableList.add(circle);
        shape.add(circle);



    }
    
    @Override
    public void step()
    {

    }

    @Override
    public void click(double x, double y) {
        ListIterator<Shape> iter = shape.listIterator(shape.size()+1);
        boolean autorisation = true;
        while (iter.hasPrevious()){
            Shape elem = iter.previous();
            if(elem.contains(new project07.Point(x,y)) && autorisation) {
                paintableList.remove(elem);
                shape.remove(elem);

                paintableList.add(elem);
                shape.add(elem);
                autorisation = false;
            }
        }
    }
}
