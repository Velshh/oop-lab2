import java.util.Locale;

public class Style {
    public final String fillColor;
    public final String strokeColor;
    public final double width;

    public Style(String fillColor, String strokeColor, double width) {
        this.fillColor = fillColor;
        this.strokeColor = strokeColor;
        this.width = width;
    }

    public String toSvg() {
        return String.format(Locale.ENGLISH, "style=\"fill:%s;stroke:%s;stroke-width:%f\"", fillColor,strokeColor, width);
    }
}
