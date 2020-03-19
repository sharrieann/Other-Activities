package Test;



import java.util.Scanner;
import java.util.Random;

public class TestCharacter {
   
    public static void main (String args[]){
        Scanner sc = new Scanner(System.in);
         Random r = new Random();
        
         Battle battle = new Battle();
         battle.Battle();
         /*
        Character p1 = new Character("Sam ", 10,10,10,10);
        Character p2 = new Character("Jiminnie ", 5,5,5,5);
         
                      
        for(int i = 1; p1.getCurrentLife() >= 0 && p2.getCurrentLife() >= 0; i++){
                
            System.out.println("\nROUND: " + i);
            
            System.out.println(p1.getName() + p1.getCurrentLife()); 
            //printing of life per player
            System.out.println(p2.getName() + p2.getCurrentLife());
            
            System.out.println("Enter your choice: [1] to attack  and [2] to heal");
                   
            int choice = sc.nextInt();
            switch(choice){
                case 1 :
                    int a = p1.attack();
                    p1.attack();
                    p2.wound(a); //p1 will attack p2
                    break;
                case 2:
                    int h = p1.getCurrentLife() + p1.getIntelligence();
                    System.out.println(p1.getName() + "heals for " + h);
                    
                    
                    break;
            }
             int enemyChoice = r.nextInt(2);
            
              switch(enemyChoice){
                case 1 :
                    int b = p2.attack();
                    p2.attack();
                    p1.wound(b); //p2 will attack p1
                    break;
                case 2:
                    int h = p2.getCurrentLife() + p2.getIntelligence();
                    System.out.println(p2.getName() + "heals for " + h);
                    
                    
                    break;
            }
            
            
            System.out.println(p1.getName() + "attacks " + p2.getName() +"for " + p1.attack()); //printing of attacks
            System.out.println(p2.getName() + "attacks " + p1.getName() + "for " + p2.attack());
        
        if( p1.getCurrentLife() <= 0 && p2.getCurrentLife() <= 0){
            System.out.println(p1.getName() + "health " + p1.getCurrentLife());
            System.out.println(p2.getName() + "health " + p2.getCurrentLife());
            System.out.println("--DRAW--"); //if they have the same condition = draw
            break;
               
        }
        else if(p2.getCurrentLife() <= 0){
              System.out.println(p1.getName() + "health " + p1.getCurrentLife());
             System.out.println(p2.getName() + "health " + p2.getCurrentLife());
             System.out.println(p1.getName() + "Wins!"); //if p2 has <=0 then p1 wins
           break;  
            
        }else if(p1.getCurrentLife() <= 0){
             System.out.println(p1.getName() + "health" + p1.getCurrentLife());
             System.out.println(p2.getName() + "health" + p2.getCurrentLife());
             System.out.println(p2.getName() + "Wins!"); //if p1 <= 0 then p2 wins
        break;  
        
        }
            
        
        }*/
    }
}