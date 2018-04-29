package assignment05.exercise03;

public class Circle
{
    public final Point center;
    public final int radius;
    
    public Circle(Point center, int radius)
    {
        this.center = center.clone();
        this.radius = radius;
    }
    
    public void moveTo(int x, int y)
    {
        center.setX(x);
        center.setY(y);
    }
    
    @Override
    public String toString()
    {
        return "Circle{" +
            "center=" + center.toString() +
            ", radius=" + radius +
            '}';
    }
}
