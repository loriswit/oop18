// Loris Witschard & Nicolas Bovet
package project09.gfx.shape;

import oop.lib.Painting;
import project09.gfx.Point;
import project09.gfx.Vector;

import java.awt.*;

public class Polygon extends Shape
{
    private Point[] vertices;
    
    public Polygon(Vector[] path, Color color)
    {
        this(asVertices(path), color);
    }
    
    public Polygon(Vector[] path, Color color, Point center)
    {
        this(asVertices(path), color, center);
    }
    
    private static Point[] asVertices(Vector[] vectors)
    {
        Point[] res = new Point[vectors.length + 1];
        double x = 0;
        double y = 0;
        res[0] = new Point(x, y);
        for(int i = 0; i < vectors.length; i++)
        {
            x += vectors[i].dx();
            y += vectors[i].dy();
            res[i + 1] = new Point(x, y);
        }
        return res;
    }
    
    private Polygon(Point[] points, Color color)
    {
        super(color);
        vertices = copy(points);
        locateAtOrigin();
    }
    
    private Polygon(Point[] points, Color color, Point center)
    {
        this(points, color);
        translate(center.x(), center.y());
    }
    
    private static Point[] copy(Point[] points)
    {
        Point[] res = new Point[points.length];
        for(int i = 0; i < points.length; i++)
        {
            res[i] = points[i].duplicate();
        }
        return res;
    }
    
    private void locateAtOrigin()
    {
        Point reference = centroid();
        for(Point vertex : vertices)
            vertex.translate(-reference.x(), -reference.y());
    }
    
    public Polygon duplicate()
    {
        return new Polygon(vertices, getColor(), centroid());
    }
    
    public int nbVertices()
    {
        return vertices.length;
    }
    
    public Point getVertex(int index)
    {
        return vertices[index].duplicate();
    }
    
    @Override
    public double area()
    {
        double sum = 0;
        for(int i = 0; i < vertices.length; i++)
        {
            sum += (vertices[i].x() * vertices[(i + 1) % vertices.length].y())
                - (vertices[(i + 1) % vertices.length].x() * vertices[i].y());
        }
        return Math.abs(sum / 2);
    }
    
    @Override
    public final Point centroid()
    {
        double sumX = 0;
        double sumY = 0;
        for(int i = 0; i < vertices.length; i++)
        {
            double aux = (vertices[i].x() * vertices[(i + 1) % vertices.length].y())
                - (vertices[(i + 1) % vertices.length].x() * vertices[i].y());
            sumX += (vertices[i].x() + vertices[(i + 1) % vertices.length].x()) * aux;
            sumY += (vertices[i].y() + vertices[(i + 1) % vertices.length].y()) * aux;
        }
        return new Point(sumX / (6 * area()), sumY / (6 * area()));
    }
    
    @Override
    public void translate(double deltaX, double deltaY)
    {
        for(Point vertex : vertices)
            vertex.translate(deltaX, deltaY);
    }
    
    @Override
    public void rotate(double angle, Point anchor)
    {
        for(Point vertex : vertices)
            vertex.rotate(angle, anchor);
    }
    
    @Override
    public void scale(double factor, Point anchor)
    {
        for(Point vertex : vertices)
            vertex.scale(factor, anchor);
    }
    
    @Override
    public void paint(Painting display)
    {
        display.setColor(getColor());
        display.fillPolygon(verticesAsArrays());
    }
    
    private double[][] verticesAsArrays()
    {
        double[][] array = new double[vertices.length][];
        for(int i = 0; i < vertices.length; i++)
        {
            array[i] = vertices[i].asArray();
        }
        return array;
    }
}
