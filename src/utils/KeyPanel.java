package utils;
import javax.swing.*;
import fields.*;
import entity.*;



public class KeyPanel extends JPanel{
    Snake snake; 
    Food food; 
    Field field;

    public Snake getSnake() {
        return snake;
    }
    public void setSnake(Snake snake) {
        this.snake = snake;
    }
    public Food getFood() {
        return food;
    }
    public void setFood(Food food) {
        this.food = food;
    }
    public Field getField() {
        return field;
    }
    public void setField(Field field) {
        this.field = field;
    }

    boolean left = false, right = false, up = false, down = false;

    public boolean isLeft() {
        return left;
    }
    public void setLeft(boolean left) {
        this.left = left;
    }
    public boolean isRight() {
        return right;
    }
    public void setRight(boolean right) {
        this.right = right;
    }
    public boolean isUp() {
        return up;
    }
    public void setUp(boolean up) {
        this.up = up;
    }
    public boolean isDown() {
        return down;
    }
    public void setDown(boolean down) {
        this.down = down;
    }

    public KeyPanel(Snake snake, Food food, Field field) {
        this.setSnake(snake);
        this.setFood(food);
        this.setField(field);
        this.setSize(200,200);
        Key keyboard = new Key(this, food, snake, field);
        this.addKeyListener(keyboard);
    }
}
