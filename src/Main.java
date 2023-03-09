import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Polygon rectangle = new Polygon(4, new Style("red", "blue", 1));
        Polygon triangle = new Polygon(3, new Style(null, null, 1));
        Ellipse ellipse = new Ellipse(new Point(5, 5), 5, 10,
                new Style("green", "black", 1));
        rectangle.setVertices(new Point[]{new Point(0,0), new Point(100, 0),
                new Point(100, 100), new Point(0, 100)});
        triangle.setVertices(new Point[]{new Point(200,200), new Point(200, 300), new Point(300, 200)});

        SvgScene scene = new SvgScene();
        scene.addToList(rectangle);
        scene.addToList(triangle);
        scene.addToList(ellipse);
        scene.save2("plik.html");
    }
}