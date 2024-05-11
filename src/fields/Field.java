package fields;
import java.awt.Rectangle;

public class Field {
    Rectangle rectangle;

    public Field(Rectangle rectangle){
        this.rectangle = rectangle;
    }
    
    public Rectangle getRectangle(){
        return rectangle;
    }    

    public void setRectangle(Rectangle r){
        this.rectangle = r;
    }
}
