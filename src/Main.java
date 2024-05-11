import java.awt.Point;
import java.awt.Rectangle;
import entity.*;
import fields.*;
import gui.Frame;

public class Main {

    public static void main(String[] args) {
        Point[] body = new Point[2];
        body[0] = new Point(50, 50);
        body[1] = new Point(50, 65);

        Snake snake = new Snake(body, 4);
        snake.setWidth(10);
        snake.setHeight(10);

        Rectangle field = new Rectangle(0, 0, 600, 600);
        Field terrain = new Field(field);

        Rectangle food = new Rectangle(15, 17, 10, 10);
        Food apple = new Food(food);

        new Frame(snake,apple,terrain);
    }
}
