import java.util.Locale;

public class Segment {
    private Point point1;
    private Point point2;

    public Segment(Point point1, Point point2) {
        this.point1 = point1;
        this.point2 = point2;
    }

    public double getSegmentLength() {
        return Math.sqrt(Math.pow(point2.x - point1.x, 2) + Math.pow(point2.y - point1.x, 2));
    }
    public Point getPoint1() {
        return point1;
    }

    public Point getPoint2() {
        return point2;
    }
    /*
        public void setPoint1(Point point1) {
        this.point1 = point1;
    }

    public void setPoint2(Point point2) {
        this.point2 = point2;
    }
     */

    public static Segment[] perpendicular(Segment segment, Point point) {
        double a = segment.getPoint1().y - segment.getPoint2().y / (segment.getPoint1().x - segment.getPoint2().x);

        //b = y - ax
        double b = point.y - a*point.x;

        double x0;
        double y0;

        x0 = point.x;
        y0 = point.y;

        double r = segment.getSegmentLength();
        double sq = Math.sqrt((-y0*y0) + (2*a+x0+2*b)*y0 - (a*a)*(x0+x0)-2*a*b*x0+(a*a+1)*r*r-b*b);

        double x1 = (-(sq) - a*y0-x0+a*b)/(a*a+1);
        double y1 = -a*sq + a*a*y0+a*x0+b/(a*a+1);

        double x2 = (sq + a*y0+x0-a*b)/(a*a+1);
        double y2 = (a*sq+a*a*y0+a*x0+b)/(a*a+1);


        return new Segment[]{new Segment(point, new Point(x1, y1)), new Segment(point, new Point(x2, y2))};
    }
    public static Segment[] perpendicular(Segment segment, Point point, double r) {
        double a = segment.getPoint1().y - segment.getPoint2().y / (segment.getPoint1().x - segment.getPoint2().x);

        //b = y - ax
        double b = point.y - a*point.x;

        double x0;
        double y0;

        x0 = point.x;
        y0 = point.y;

        //double r = segment.getSegmentLength();
        double sq = Math.sqrt((-y0*y0) + (2*a+x0+2*b)*y0 - (a*a)*(x0+x0)-2*a*b*x0+(a*a+1)*r*r-b*b);

        double x1 = (-(sq) - a*y0-x0+a*b)/(a*a+1);
        double y1 = -a*sq + a*a*y0+a*x0+b/(a*a+1);

        double x2 = (sq + a*y0+x0-a*b)/(a*a+1);
        double y2 = (a*sq+a*a*y0+a*x0+b)/(a*a+1);


        return new Segment[]{new Segment(point, new Point(x1, y1)), new Segment(point, new Point(x2, y2))};
    }

    public String toSvg() {
        return String.format(Locale.ENGLISH,
                "<line x1=\"%f\" y1=\"%f\" x2=\"%f\" y2=\"%f\" style=\"stroke:rgb(0,0,0);stroke-width:2\"/>",
                point1.x, point1.y, point2.x, point2.y);
    }

}
