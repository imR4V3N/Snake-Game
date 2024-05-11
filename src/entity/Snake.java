package entity;

import java.util.Random;
import java.util.Vector;
import fields.Field;

import java.awt.Point;
import java.awt.Rectangle;

public class Snake {
    Vector<Point> snake;
    int speed;
    int score = 0;
    int width;
    int height;

    public Vector<Point> getSnake() {
        return snake;
    }
    public void setSnake(Vector<Point> snake) {
        this.snake = snake;
    }
    public int getScore() {
        return score;
    }
    public void setScore(int score) {
        this.score = score;
    }
    public int getSpeed() {
        return speed;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }
    public int getWidth() {
        return width;
    }
    public void setWidth(int width) {
        this.width = width;
    }
    public int getHeight() {
        return height;
    }
    public void setHeight(int height) {
        this.height = height;
    }

    public Snake(){}
    public Snake(Vector<Point> snake, int score) {
        this.snake = snake;
        this.score = score;
    }

    public Snake(Point[] point, int speed) {
        this.speed = speed;
        this.snake = new Vector<>();
        for (int i = 0; i < point.length; i++) {
            this.snake.add(point[i]);
        }
    }   

    public boolean isHorizontal(){
        if(((Point) this.snake.get(0)).getY() == ((Point)this.snake.get(1)).getY()){
            return true;
        }
        return false;
    }

    public boolean isVertical(){
        if(((Point) this.snake.get(0)).getX() == ((Point) this.snake.get(1)).getX()){
            return true;
        }
        return false;
    }

    public int isFirstH() {
        if (((Point) this.snake.get(0)).getX() < ((Point) this.snake.get(1)).getX()) {
            return 0;// Horizontal by droite(goLeft)
        } else if (((Point) this.snake.get(0)).getX() > ((Point) this.snake.get(1)).getX()) {
            return 1;// Horizontal by gauche(goRight)
        }
        return -1;
    }
    
    public int isFirstV() {
        if (((Point) this.snake.get(0)).getY() < ((Point) this.snake.get(1)).getY()) {
            return 0;// Vertical by bas(goUp)
        } else if (((Point) this.snake.get(0)).getY() > ((Point) this.snake.get(1)).getY()) {
            return 1;// Vertical by haut(goDown)
        }
        return -1;  
    }

    public void Move(int dx, int dy) {
        this.snake.remove(this.snake.size() - 1);
        Point firstPoint = new Point();
        firstPoint = (Point) this.snake.firstElement();
        this.snake.add(0, new Point((int) firstPoint.x + dx, (int) firstPoint.y + dy));
    }

    public void goUp() {
        this.Move(0, (-1)*speed);
    }

    public void goDown() {
        this.Move(0, speed);
    }

    public void goLeft() {
        this.Move((-1)*speed, 0);
    }

    public void goRight() {
        this.Move(speed, 0);
    }

    public void eat(Food food) {
        Point newPoints = new Point();
        if (food.isFood((Point) this.snake.get(0), this.getWidth(), this.getHeight()) == true) {
            newPoints = (Point) this.snake.get(0);
            if (isFirstH() == 0) {
                this.snake.add(0, new Point(newPoints.x - width, newPoints.y));
            } else if (isFirstH() == 1) {
                this.snake.add(0, new Point(newPoints.x + width, newPoints.y));
            } else if (isFirstV() == 0) {
                this.snake.add(0, new Point(newPoints.x, newPoints.y - height));
            } else if (isFirstV() == 1) {
                this.snake.add(0, new Point(newPoints.x, newPoints.y + height));
            }
        }
    }

    public boolean isImpactField(Field field) {
        if (((Point) this.snake.get(0)).getX() <= field.getRectangle().getX() || ((Point) this.snake.get(0)).getX() + width >= field.getRectangle().getMaxX() || ((Point) this.snake.get(0)).getY() <= field.getRectangle().getY() || ((Point) this.snake.get(0)).getY() + height >= field.getRectangle().getMaxY()) {
            return true;
        }
        return false;
    }

    public boolean isDead(){  
        for (int i = 1; i < this.snake.size(); i++) {
            if (((Point)this.snake.get(0)).getX() == ((Point)this.snake.get(i)).getX() && ((Point)this.snake.get(0)).getY() == ((Point)this.snake.get(i)).getY()) {
                return true;
            }
        }
        return false;
    }

    public boolean GameOver(Field field){
        if (this.isImpactField(field) || this.isDead()) {
            return true;
        }
        return false;
    }

    public void Impact(Food food, Field field, Snake snake, int maxX, int maxY) {
        if (food.isFood((Point) this.getSnake().get(0),this.getWidth(), this.getHeight()) == true) {
            this.eat(food);
            Random[] random = new Random[2];
            for (int i = 0; i < random.length; i++) {
                random[i] = new Random();   
            }
            int x = random[0].nextInt(maxX);
            int y = random[1].nextInt(maxY); 
            food.setRectangle(new Rectangle(x,y,(int)food.getRectangle().getWidth(),(int)food.getRectangle().getHeight()));
            score++;
        }
        
        if (this.isImpactField(field)) System.out.println("Dead");
        this.isDead() ;
    }
}
