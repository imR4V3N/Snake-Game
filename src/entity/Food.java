package entity;
import java.awt.Rectangle;

import fields.Field;

import java.awt.Point;

public class Food extends Field{
    public Food(Rectangle r){
        super(r);
    }

    public boolean isFood(Point head, int width, int height){
        Rectangle snakeHead = new Rectangle((int)head.getX(), (int)head.getY(), width, height);
        return this.getRectangle().intersects(snakeHead);
    }
}
