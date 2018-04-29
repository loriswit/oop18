package project07;

import oop.lib.Paintable;
import oop.lib.Painting;

import java.awt.*;

public abstract class Shape implements Paintable, Properties {

    private Point center;
    private Color color;

    public Shape(Point center, Color color) {
        this.center = center;
        this.color = color;
    }

    public Shape(Color color) {
        this.color = color;
    }

    public abstract void translate(double dx, double dy);

    public abstract void rotate(double angle, Point anchor);

    public void rotate(double angle) {
        rotate(angle, centroid());
    }

    public Point getCenter() {
        return center;
    }

    public Color getColor() {
        return color;
    }

    public abstract void scale(double scalrar, Point anchor);

    public void scale(double scalar){
        scale(scalar,centroid());
    }

    public abstract double getArea();



    @Override
    public void paint(Painting display) {
        display.setColor(color);
    }
}
