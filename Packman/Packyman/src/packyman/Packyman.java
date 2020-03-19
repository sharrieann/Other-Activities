package packyman;

/**
 * @author Sharrie Mitabtab
 */
import java.awt.*;
import javax.swing.JFrame;
import java.awt.event.*;

public class Packyman extends Panel
        implements KeyListener {

    static int y = 120, x = 100, sa = 30, mouth = 400;
    static int tempX = 0;
    static int tempY = 0;
    static int score;

    static boolean food1 = true;
    static boolean food2 = false;
    static boolean foodf1 = false;
    static boolean foodf2 = false;

    static int rand1;
    static int rand2;

    static int foodLocX;
    static int foodLocY;

    @Override
    public void paint(Graphics g) {
         g.setColor(Color.pink);
        g.fillOval(foodLocX, foodLocY, 20, 20);
        
        g.setColor(new Color(255, 255, 0));
        g.fillArc(x, y, 50, 50, sa, mouth);

       
        
        g.setColor(Color.BLACK);
        g.drawString("Score = " + score, 200, 350);
    }

    public static void main(String args[]) {
        JFrame frame = new JFrame();
        Packyman panel = new Packyman();

        while (food1) {
            rand1 = (int) (Math.random() * 250);
            if (rand1 % 5 == 0) {
                foodLocX = rand1 + 100;
                food1 = false;
                food2 = true;
            } else {
                food1 = true;
            }
        }
        while (food2) {
            rand2 = (int) (Math.random() * 250);
            if (rand2 % 5 == 0) {
                foodLocY = rand2 + 100;
                food2 = false;
            } else {
                food2 = true;
            }
        }
        if (score == 1) {
            System.out.println("You Win");
            frame.dispose();
        }

        frame.add(panel);
        panel.addKeyListener(panel);
        panel.setBackground(Color.GRAY);

        frame.setSize(400, 400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            y -= 5;
            sa = 113;
            if (y % 2 == 0) {
                mouth = 360;
            } else {
                mouth = 315;
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            y += 5;
            sa = 293;
            if (y % 2 == 0) {
                mouth = 360;
            } else {
                mouth = 315;
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            x -= 5;
            sa = 203;

            if (x % 2 == 0) {
                mouth = 360;
            } else {
                mouth = 315;
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            x += 5;
            sa = 23;

            if (x % 2 == 0) {
                mouth = 360;
            } else {
                mouth = 315;
            }
        }

        tempX = x + 15;
        tempY = y + 15;

        if (tempX == foodLocX && tempY == foodLocY) {
            foodf1 = true;

            while (foodf1) {
                rand1 = (int) (Math.random() * 350);
                if (rand1 % 5 == 0) {
                    foodLocX = rand1 + 10;
                    foodf1 = false;
                    foodf2 = true;
                } else {
                    food1 = true;
                }
            }

            while (foodf2) {
                rand2 = (int) (Math.random() * 350);

                if (rand2 % 5 == 0) {
                    foodLocY = rand2 + 10;
                    foodf2 = false;
                } else {
                    foodf2 = true;
                }
            }

            score = score + 1;

        }

        if (tempX <= 10) {
            x = 280;
        }
        if (tempX >= 385) {
            x = 10;
        }
        if (tempY <= 10) {
            y = 380;
        }
        if (tempY >= 385) {
            y = 10;
        }
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
