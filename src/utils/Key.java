package utils;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Point;
import fields.*;
import entity.*;

public class Key implements KeyListener{
    KeyPanel space;
    Food snack;
    Snake snake;
    Field field;

    public KeyPanel getSpace() {
        return space;
    }
    public void setSpace(KeyPanel space) {
        this.space = space;
    }
    public Food getSnack() {
        return snack;
    } 
    public void setSnack(Food snack) {
        this.snack = snack;
    }
    public Snake getSnake() {
        return snake;
    }
    public void setSnake(Snake snake) {
        this.snake = snake;
    }
    public Field getfield() {
        return field;
    }
    public void setfield(Field field) {
        this.field = field;
    }

    public Key(KeyPanel space,Food snack,Snake snake,Field field){
        this.space = space;
        this.field = field;
        this.snake = snake;
        this.snack = snack;
    }    

    public void afficher(){
        for (int i = 0; i < snake.getSnake().size(); i++) {
            System.out.println(((Point) snake.getSnake().get(i)).getX() +"-----"+ ((Point) snake.getSnake().get(i)).getY());
        }
    }
    
    @Override
    public void keyPressed(KeyEvent key){
        if (key.getKeyCode() == 37) {
            space.setLeft(true);
            snake.goLeft();
            // snake.Impact(snack, field, snake);
        }
        else if (key.getKeyCode() == 39) {
            space.setRight(true);
            snake.goRight();
            // snake.Impact(snack, field, snake);
        }
        else if (key.getKeyCode() == 38) {
            space.setUp(true);
            snake.goUp();
            // snake.Impact(snack, field, snake);
        }
        else if (key.getKeyCode() == 40) {
            space.setDown(true);
            snake.goDown();
            // snake.Impact(snack, field, snake);
        }
    }

    @Override
    public void keyReleased(KeyEvent key){
        if (key.getKeyCode() == 37) {
            space.setLeft(false);
        }
        else if (key.getKeyCode() == 39) {
            space.setRight(false);
        }
        else if (key.getKeyCode() == 38) {
            space.setUp(false);
        }
        else if (key.getKeyCode() == 40) {
            space.setDown(false);
        }
    }
    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Unimplemented method 'keyTyped'");
    }
}
