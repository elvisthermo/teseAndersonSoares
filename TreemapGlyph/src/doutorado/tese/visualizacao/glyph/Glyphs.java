package doutorado.tese.visualizacao.glyph;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.SVGPath;

public class Glyphs {

    public float setx;
    public float sety;
    public float width;
    public float height;
    public String tipo;
    Group root;

    public Glyphs(float setx, float sety, float width, float height, String tipo) {
        this.setx = setx;
        this.sety = sety;
        this.width = width;
        this.height = height;

        if (tipo == "1") {
            Rectangle rect01 = new Rectangle(this.setx, this.sety, this.width, this.height);
            rect01.setFill(Color.DARKSLATEGRAY);

            root = new Group(rect01);
        }

        if (tipo == "2") {
            Rectangle rect01 = new Rectangle(this.setx, this.sety, this.width, this.height);
            rect01.setFill(Color.DARKSLATEGRAY);
            Rectangle rect02 = new Rectangle(this.setx, this.sety, this.width, this.height / 2);
            rect02.setFill(Color.PALETURQUOISE);
            root = new Group(rect01, rect02);
        }
        if (tipo == "3") {
            Rectangle rect01 = new Rectangle(this.setx, this.sety, this.width, this.height);
            rect01.setFill(Color.DARKSLATEGRAY);
            Rectangle rect02 = new Rectangle(this.setx, this.sety, this.width, this.height / 2);
            rect02.setFill(Color.PALETURQUOISE);
            Rectangle rect03 = new Rectangle(this.setx, this.sety + (this.sety / 2), this.width / 2, this.height / 2);
            rect03.setFill(Color.RED);

            root = new Group(rect01, rect02, rect03);
        }
        if (tipo == "4") {
            Rectangle rect01 = new Rectangle(this.setx, this.sety, this.width, this.height);
            rect01.setFill(Color.DARKSLATEGRAY);
            Rectangle rect02 = new Rectangle(this.setx, this.sety, this.width, this.height / 2);
            rect02.setFill(Color.PALETURQUOISE);
            Rectangle rect03 = new Rectangle(this.setx, this.sety + (this.sety / 2), this.width / 2, this.height / 2);
            rect03.setFill(Color.RED);
            Rectangle rect04 = new Rectangle(this.setx, this.sety, this.width / 2, this.height / 2);
            rect04.setFill(Color.VIOLET);

            root = new Group(rect01, rect02, rect03, rect04);

        }


          }

    public Group montar() {
        return root;

    }

}
