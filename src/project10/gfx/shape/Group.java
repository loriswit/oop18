// Loris Witschard & Nicolas Bovet
package project10.gfx.shape;

import oop.lib.Painting;
import project10.gfx.Point;
import project10.list.List;

import java.awt.*;
import java.util.Arrays;

public class Group extends Shape
{
    private List<Shape> shapes = new List<>();
    
    public Group(Shape... shapes)
    {
        super(averageColor(shapes));
        add(shapes);
    }
    
    public void add(Shape... shapes)
    {
        this.shapes.addAll(Arrays.asList(shapes));
    }
    
    @Override
    public void rotate(double angle, Point anchor)
    {
        for(var elem : shapes)
            elem.rotate(angle, anchor);
    }
    
    @Override
    public void translate(double deltaX, double deltaY)
    {
        for(var shape : shapes)
            shape.translate(deltaX, deltaY);
    }
    
    @Override
    public void scale(double factor, Point anchor)
    {
        for(var shape : shapes)
            shape.scale(factor, anchor);
    }
    
    @Override
    public double area()
    {
        double area = 0;
        for(var shape : shapes)
            area += shape.area();
        
        return area;
    }
    
    @Override
    public Point centroid()
    {
        double x = 0;
        double y = 0;
        double area = 0;
        
        for(var shape : shapes)
        {
            x += shape.centroid().x() * shape.area();
            y += shape.centroid().y() * shape.area();
            area += shape.area();
        }
        
        return new Point(x / area, y / area);
    }
    
    @Override
    public boolean contains(Point point)
    {
        for(var shape : shapes)
            if(shape.contains(point))
                return true;
        
        return false;
    }
    
    @Override
    public void paint(Painting painting)
    {
        for(var shape : shapes)
            shape.paint(painting);
    }
    
    private static Color averageColor(Shape... shapes)
    {
        int r = 0;
        int g = 0;
        int b = 0;
        
        for(var shape : shapes)
        {
            r += shape.getColor().getRed();
            g += shape.getColor().getGreen();
            b += shape.getColor().getBlue();
        }
        
        return new Color(r / shapes.length, g / shapes.length, b / shapes.length);
    }
}