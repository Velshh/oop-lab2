import java.util.Locale;

public class Ellipse extends Shape {
    private Point mid;
    private double r1;
    private double r2;
    private Style style;

    public Ellipse(Point center, double r1, double r2, Style style) {
        super(style);

        this.mid = center;
        this.r1 = r1;
        this.r2 = r2;
    }


    @Override
    public String toSvg() {
        return String.format(Locale.ENGLISH, "<ellipse cx=\"%f\" cy=\"%f\" rx=\"%f\" ry=\"%f\" %s/>",
                mid.x, mid.y, r1, r2, style, style.toSvg());
    }
}
