// Loris Witschard & Nicolas Bovet
package project04;

import java.awt.Color;

import oop.lib.Painting;

public class Polygon extends Shape
{
    private Point[] vectors;
    
    public Polygon(Point center, Point[] vectors, Color color)
    {
        super(center, color);
        this.vectors = vectors;
    }
    
    public Polygon(Point center, Point[] vectors)
    {
        this(center, vectors, Color.RED);
    }
    
    public Polygon duplicate()
    {
        Point[] newVectors = new Point[vectors.length];
        for(int i = 0; i < vectors.length; ++i)
            newVectors[i] = vectors[i].duplicate();
        
        return new Polygon(getCenter().duplicate(), newVectors, getColor());
    }
    
    @Override
    public void scale(double scalar)
    {
        for(Point vector : vectors)
            vector.scale(scalar, getCentroid());
    }
    
    @Override
    public void rotate(double angle, Point origin)
    {
        super.rotate(angle, origin);
        
        for(Point vector : vectors)
            vector.rotate(angle, origin);
    }
    
    @Override
    public void paint(Painting display)
    {
        super.paint(display);
        
        Point centroid = getCentroid();
        Point center = getCenter();
        
        double[][] vertices = new double[vectors.length + 1][2];
        vertices[0][0] = center.x() + centroid.x();
        vertices[0][1] = center.y() + centroid.y();
        
        for(int i = 0; i < vectors.length; ++i)
        {
            vertices[i + 1][0] = vertices[i][0] + vectors[i].x();
            vertices[i + 1][1] = vertices[i][1] + vectors[i].y();
        }
        
        display.fillPolygon(vertices);
    }
    
    @Override
    public double getArea()
    {
        double area = 0;
        for(int i = 0; i < vectors.length - 1; ++i)
            area += vectors[i].x() * vectors[i + 1].y() - vectors[i + 1].x() * vectors[i].y();
        
        return Math.abs(area / 2);
    }
    
    @Override
    public Point getCentroid() // NOT WORKING
    {
        double xg = 0;
        for(int i = 0; i < vectors.length - 1; ++i)
            xg += (vectors[i].x() + vectors[i + 1].x()) * (vectors[i].x() * vectors[i + 1].y() - vectors[i + 1].x() * vectors[i].y());
        
        double yg = 0;
        for(int i = 0; i < vectors.length - 1; ++i)
            yg += (vectors[i].y() + vectors[i + 1].y()) * (vectors[i].x() * vectors[i + 1].y() - vectors[i + 1].x() * vectors[i].y());
        
        double area = getArea();
        
        return new Point(xg / 6 / area, yg / 6 / area);
    }
}
