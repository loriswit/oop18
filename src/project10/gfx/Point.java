// Loris Witschard & Nicolas Bovet
package project10.gfx;

import oop.lib.Degrees;

public class Point
{
    private double x;
    private double y;
    
    public Point(double x, double y)
    {
        this.x = x;
        this.y = y;
    }
    
    public Point duplicate()
    {
        return new Point(x, y);
    }
    
    public double x()
    {
        return x;
    }
    
    public double y()
    {
        return y;
    }
    
    public void moveTo(double newX, double newY)
    {
        x = newX;
        y = newY;
    }
    
    public void translate(double dx, double dy)
    {
        moveTo(x + dx, y + dy);
    }
    
    public void rotate(double angle, Point center)
    {
        double dx = x - center.x;
        double dy = y - center.y;
        double newX = center.x + Degrees.cos(angle) * dx - Degrees.sin(angle) * dy;
        double newY = center.y + Degrees.sin(angle) * dx + Degrees.cos(angle) * dy;
        moveTo(newX, newY);
    }
    
    public void scale(double factor, Point anchor)
    {
        double newX = anchor.x + factor * (x - anchor.x);
        double newY = anchor.y + factor * (y - anchor.y);
        moveTo(newX, newY);
    }
    
    public double distance(Point other)
    {
        return Math.sqrt((other.x - x) * (other.x - x) + (other.y - y) * (other.y - y));
    }
    
    public double[] asArray()
    {
        return new double[]{x, y};
    }
    
}
