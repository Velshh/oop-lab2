import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/*
Zadanie 2.
Napisz klasę SvgScene posiadającą prywatną listę obiektów Polygon.
Napisz metodę, która przyjmuje obiekt klasy Polygon oraz dodaje go do listy w obiekcie SvgScene.
Napisz funkcję save(String), która utworzy plik HTML w ścieżce danej argumentem i zapisze
do niego reprezentacje wszystkich wielokątów znajdujących się na kanwie.
 */
public class SvgScene {
   private List<Shape> list = new ArrayList<>();
   private double width=500;
   private double height=500;

   public void addToList(Shape shape) {
       list.add(shape);
   }

   public void save2(String path) throws IOException {
       try {
           FileWriter fw = new FileWriter(path);
           fw.write("<html>\n<body>\n</html>");
           fw.write(String.format(Locale.ENGLISH, "<svg height=\"%f\" width=\"%f\"", height, width));
           for(Shape s : list) {
               fw.write("\t"+s.toSvg()+"\n");
           }
           fw.write("</svg>\n</body>\n</html>");
           fw.close();
       }catch (IOException e) {
           e.printStackTrace();
       }
   }

   public void save(String path) {
       File file = new File(path);
       try {
           BufferedWriter bw = new BufferedWriter(new FileWriter(file));
           //bw.write("<html><body></body></html>");
           bw.close();
       } catch (IOException e) {
           e.printStackTrace();
       }
   }

}
