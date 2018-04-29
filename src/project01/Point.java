// Loris Witschard & Nicolas Bovet
package project01;

public class Point
{
    private double x;
    private double y;
    
    public Point(double x, double y)
    {
        this.x = x;
        this.y = y;
    }
    
    public double getX()
    {
        return x;
    }
    
    public double getY()
    {
        return y;
    }
    
    public void setX(double x)
    {
        this.x = x;
    }
    
    public void setY(double x)
    {
        this.x = x;
    }
    
    public Point duplicate()
    {
        return new Point(x, y);
    }
    
    public void translate(Point vector)
    {
        x += vector.x;
        y += vector.y;
    }
    
    public void rotate(Point origin, double angle)
    {
        angle = Math.toRadians(angle);
    
        translate(origin.getOpposite());
        double nextX = Math.cos(angle) * x - Math.sin(angle) * y;
        double nextY = Math.sin(angle) * x + Math.cos(angle) * y;
        x = nextX;
        y = nextY;
        translate(origin);
    }
    
    public void scale(Point origin, double scalar)
    {
        translate(origin.getOpposite());
        x *= scalar;
        y *= scalar;
        translate(origin);
    }
    
    public double[] asArray()
    {
        return new double[]{x, y};
    }
    
    public double distance(Point target)
    {
        return Math.sqrt(Math.pow(target.x - x, 2) + Math.pow(target.y - y, 2));
    }
    
    private Point getOpposite()
    {
        return new Point(-x, -y);
    }
}
