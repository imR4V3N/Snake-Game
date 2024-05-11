package gui;

import java.awt.BorderLayout;
import java.util.Vector;
import javax.swing.JFrame;
import entity.*;
import utils.*;
import fields.*;

public class Frame extends JFrame{
    Vector<Snake> listSnake;
    Vector<Food> listFood;
    KeyPanel keyPanel;

    public Vector<Snake> getSnake() {
        return listSnake;
    }
    public void setSnake(Snake snake) {
        this.listSnake.add(snake);
    }
    public Vector<Food> getFood() {
        return listFood;
    }
    public void setFood(Food food) {
        this.listFood.add(food);
    }
    
    public Frame(Snake snake,Food food, Field terrain){

        super.setTitle("Snake Game");
        super.setSize(616,640);

        super.setDefaultCloseOperation(Frame.EXIT_ON_CLOSE);
        keyPanel = new KeyPanel(snake,food,terrain);
        keyPanel.setFocusable(true);

        this.add(new Panel(snake, terrain, food));
        this.getContentPane().add(keyPanel,BorderLayout.CENTER);
        super.setVisible(true);
    }
}
