// Loris Witschard & Nicolas Bovet
package project08.gfx.shape;

import oop.lib.Painting;
import project08.gfx.Point;
import project08.list.List;

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
        for(Shape elem : shapes)
            elem.rotate(angle, anchor);
    }
    
    @Override
    public void translate(double deltaX, double deltaY)
    {
        for(Shape shape : shapes)
            shape.translate(deltaX, deltaY);
    }
    
    @Override
    public void scale(double factor, Point anchor)
    {
        for(Shape shape : shapes)
            shape.scale(factor, anchor);
    }
    
    @Override
    public double area()
    {
        double area = 0;
        for(Shape shape : shapes)
            area += shape.area();
        
        return area;
    }
    
    @Override
    public Point centroid()
    {
        double x = 0;
        double y = 0;
        double area = 0;
        
        for(Shape shape : shapes)
        {
            x += shape.centroid().x() * shape.area();
            y += shape.centroid().y() * shape.area();
            area += shape.area();
        }
        
        return new Point(x / area, y / area);
    }
    
    @Override
    public void paint(Painting painting)
    {
        for(Shape shape : shapes)
            shape.paint(painting);
    }
    
    private static Color averageColor(Shape... shapes)
    {
        int r = 0;
        int g = 0;
        int b = 0;
        
        for(Shape shape : shapes)
        {
            r += shape.getColor().getRed();
            g += shape.getColor().getGreen();
            b += shape.getColor().getBlue();
        }
        
        return new Color(r / shapes.length, g / shapes.length, b / shapes.length);
    }
}
