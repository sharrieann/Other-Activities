 package HappyFace;

import java.awt.*;
import javax.swing.JFrame;

public class HappyFace extends Panel {
    public HappyFace(){
        this.setBackground(Color.GRAY);
    }

    public void paint(Graphics h){  
         h.setColor(new Color(250, 232, 188));

         h.fillRect(408, 580, 80, 100);
         
         h.drawRect(300, 300, 300, 300); //Draws rectangle 
         h.fillRoundRect(300, 300, 300, 300, 300, 300);
         
         //RIGHT EYE
         h.setColor(Color.DARK_GRAY);
         h.fillOval(345, 405, 50, 90); // 1st at 2nd position, 3rd at 4th size, 5th at 6th angle
         
         h.setColor(Color.GRAY);
         h.fillOval(370, 410, 20, 50);
         
         //LEFT EYE
         h.setColor(Color.DARK_GRAY);
         h.fillOval(500, 405, 50, 90);
         
         h.setColor(Color.GRAY);
         h.fillOval(525, 410, 20, 50);
         
    
         
        
        //LIPS
        h.setColor(Color.PINK);
        h.fillArc(400, 480, 100, 100, 180, 180);
         
        //hAIR
        h.setColor(Color.BLACK);
        h.fillArc(300, 280, 300, 250, 0, 180);
        h.fillOval(280, 250, 110, 110);
        h.fillOval(520, 250, 110, 110);
        
        //BLUSH
        h.setColor(Color.PINK);
        h.fillOval(520, 485, 90, 50); //LEFFT
        h.fillOval(285, 485, 90, 50); //RIGHT
        
        //glasses
        h.setColor(Color.BLACK);
        h.drawRect(315, 400, 100, 100);
         h.drawRect(490, 400, 100, 100);
         h.drawLine(415, 450, 490, 450);
        
         //EYEBROWS
         h.setColor(Color.GRAY);
        h.drawArc(320, 390, 100, 100, 60, 80);
        h.drawArc(490, 388, 100, 100, 50, 80);
        
        //BODY
        h.setColor(Color.BLACK);
        h.fillArc(300, 630, 300, 250, 0, 180);
       
    
    
        
        
    }
    
      public static void main(String args[]){
        JFrame frame = new JFrame("My  Graphics");
        HappyFace panel = new HappyFace();
        frame.add(panel);
        frame.setSize(800, 800);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
               
    }

}
    



