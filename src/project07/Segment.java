package project07;

public class Segment {

    Point pt1;
    Point pt2;

    public Segment(Point pt1, Point pt2) {
        this.pt1 = pt1;
        this.pt2 = pt2;
    }

    private static double ccw(Point pt1, Point pt2, Point pt3){
        return (pt2.x() - pt1.x()) * (pt3.y() - pt1.y()) - (pt2.y() - pt1.y()) * (pt3.x() - pt1.x());
    }

    public static boolean intersection( Segment sgt1, Segment sgt2){
        double blue1, blue2, red1, red2;

        blue1 = ccw(sgt2.pt1, sgt2.pt2, sgt1.pt1);
        blue2 = ccw(sgt2.pt1, sgt2.pt2, sgt1.pt2);
        red1 = ccw(sgt1.pt1, sgt1.pt2, sgt2.pt1);
        red2 = ccw(sgt1.pt1, sgt1.pt2, sgt2.pt2);

        if (blue1 * blue2 < 0 && red1 * red2 < 0)
            return true;
        else
            return false;
    }
}
