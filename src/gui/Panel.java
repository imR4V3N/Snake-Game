package gui;

import entity.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import fields.*;

public class Panel extends JPanel{
    Snake snake;
    Field field;
    Food food;
    int thread = 50;
    Image foodImage;
    Image bgImage;

    public Panel(Snake snake,Field fields, Food food) {
        this.snake = snake;
        this.field = fields;
        this.food = food;

        this.setBackground(Color.BLACK);
        this.setSize(600, 600);

        try {
            foodImage = ImageIO.read(new File("img/apple.png"));
            bgImage = ImageIO.read(new File("img/grass.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setSnake(Snake snake) {
        this.snake = snake;
    }

    public void paint(Graphics graph) {
        // Draw Field
        graph.setColor(Color.BLACK);
        graph.drawImage(bgImage, (int) (this.field.getRectangle().getX()),(int) (this.field.getRectangle().getY()), (int) (this.field.getRectangle().getWidth()), (int) (this.field.getRectangle().getHeight()), this);

        //Draw Snake 
        graph.setColor(new Color(101, 67, 33));
        for (int i = 0; i < snake.getSnake().size(); i++) {
            graph.fillRect((int) (((Point) snake.getSnake().get(i)).getX()),(int) (((Point) snake.getSnake().get(i)).getY()), snake.getWidth(), snake.getHeight());
        }

        //Draw Food
        graph.setColor(Color.RED);
        graph.drawImage(foodImage, (int) (food.getRectangle().getX()),(int) (food.getRectangle().getY()), (int) (food.getRectangle().getWidth()), (int) (food.getRectangle().getHeight()), this);

        // Draw Score
        graph.setFont(new Font("Ink Free",Font.BOLD,15));
        graph.setColor(Color.BLACK);
        FontMetrics metrics = getFontMetrics(graph.getFont());
        graph.drawString("SCORE: "+snake.getScore(), (this.getWidth()-metrics.stringWidth("SCORE"))/2,graph.getFont().getSize());
        
        if (!snake.GameOver(field)) {
            try {
                Thread.sleep(thread);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    
            int x = this.getWidth() - (int)food.getRectangle().getWidth();
            int y = this.getHeight() - (int)food.getRectangle().getHeight();
            if (snake.isFirstH() == 0) {
                snake.goLeft();
                snake.Impact(food, field,  snake,x , y);
            } else if (snake.isFirstH() == 1) {
                snake.goRight();
                snake.Impact(food, field,  snake,x , y);
            } else if (snake.isFirstV() == 0) {   
                snake.goUp();
                snake.Impact(food, field,  snake,x , y);
            } else if (snake.isFirstV() == 1) {   
                snake.goDown();
                snake.Impact(food, field,  snake,x , y);
            }
            repaint();
        } else {
            graph.setFont(new Font("Ink Free",Font.BOLD,50));
            graph.setColor(Color.RED);
            FontMetrics metric = getFontMetrics(graph.getFont());
            graph.drawString("GAME OVER", (this.getWidth()-metric.stringWidth("GAME OVER"))/2,this.getHeight()/2);
            graph.setFont(new Font("Ink Free",Font.BOLD,30));
        }
    }
}
