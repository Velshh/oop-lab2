import java.util.Locale;

public class Polygon extends Shape {
    private Point[] vertices;
    private Style style;
    public Polygon(int numberOfVertices, Style style) {
        super(style);
        this.vertices = new Point[numberOfVertices];
    }
    public Polygon(int numberOfVertices) {
        this(numberOfVertices,new Style("transparent","black",1));
    }

    //lab2 zad 3
    public static Polygon square(Segment segment, Style style) {
        Point mid = new Point((segment.getPoint1().x+segment.getPoint2().x)/2,
                (segment.getPoint1().y+segment.getPoint2().y)/2);
        Segment []segments = Segment.perpendicular(segment, mid, segment.getSegmentLength()/2);
        Point a[] = new Point[4];
        a[0] = segment.getPoint1();
        a[1] = segments[0].getPoint2();
        a[2] = segment.getPoint2();
        a[3] = segments[1].getPoint2();

        Polygon p2 = new Polygon(4, style);
        p2.setVertices(a);
        return p2;
    }

    public void setVertex(int vertexNumber, Point newVertex) {
        vertices[vertexNumber] = newVertex;
    }
    public void setVertices(Point[] newArrayOfVertices) {
        this.vertices = newArrayOfVertices;
    }
    public String toSvg() {
        String s = "";
        for(Point p : vertices) {
            //format wynika z tego, że w svg liczby są wprowadzane w taki sposób.
            //https://www.w3schools.com/graphics/svg_polygon.asp
            s+=p.x+","+p.y+" ";
        }
        return String.format(Locale.ENGLISH, "<polygon points=\"%s\" %s/>", s, style.toSvg());
    }
}
