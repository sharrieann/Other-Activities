package Test;

import Character.Knight;
import Character.Thief;
import Character.Mage;
import Item.Dice;
import java.util.*;

public class Battle {

    public void Battle(){
        Scanner sc = new Scanner(System.in);
        Dice dc = new Dice();
        
        Mage m = new Mage("MAGE", 25, 2) {} ;
        Thief t = new Thief("THIEF", 25 , 3) {};
        Knight k = new Knight("KNIGHT", 25, 5) {}; 
        
                          
            System.out.println("**WELCOME TO AFK ARENA**"
                    + "\n(this is not a paid advertisement)");

            for(int i = 1; m.currentLife >= 0 && t.currentLife >= 0 && k.currentLife >= 0; i++){
                
            System.out.println("-------------------------------------");              
            System.out.println("\nROUND: " + i);
        
            
            //printing of life per player
            System.out.println(m.getName()+ " health: "+ m.getCurrentLife()); 
            System.out.println(k.getName()+ " health: " + k.getCurrentLife());
            System.out.println(t.getName()+ " health: " + t.getCurrentLife());
            System.out.println(" ");
            
  
      //SUMMONING
            //MAGE
          if (m.getCurrentLife() == 0){
              System.out.println(m.getName() + " can't summon!");
          }
          else if (i % 2 == 0) {
              m.petability();
        }
        
          
          //THIEF
          if(t.getCurrentLife() == 0){
              System.out.println(t.getName() + " can't summon!");
          }
          else if (i % 2 == 1){
              t.petability();
          }
         
            
          //KNIGHT
          if(k.getCurrentLife() == 0){
              System.out.println(k.getName() + " can't summon!");
          }
          
          else if(i %6 == 0){
              k.petability();
          }
        
            
            
            
            
            
            
            //all participants use the standard attack() method
            int a = m.attack();
//            m.attack();
//            if(t.getCurrentLife() > 0 && m.getCurrentLife() > 0){
//                t.wound(a);
//            }
//             if(k.getCurrentLife() > 0  && m.getCurrentLife() > 0){
//                 k.wound(a);
//            }
//        
//            
            int b = t.attack();
//            t.attack();
//            if(m.currentLife > 0 && t.getCurrentLife() > 0){
//                 m.wound(b);
//            }
//           if(k.getCurrentLife() > 0 && t.getCurrentLife() > 0){
//             k.wound(b);  
//           }
//            
//            
            int c = k.attack();
//            if(m.getCurrentLife() > 0 && k.getCurrentLife() > 0){
//                m.wound(c);
//            }
//            if(t.getCurrentLife() > 0 && k.getCurrentLife() > 0){
//                 t.wound(c);
//            }
            
            // all participants uses heal
            int mh = m.currentLife ;

            int th = t.currentLife ;
       
            int kh = k.currentLife ;

            //initialization 1 & 4 use unique Skill 2 & 5 use normal attack 3 & 6 use heal
            int fireball = m.fireball(a);
            
            int evade = m.attack(a) - 30;
             evade = k.attack(b) - 30;
             evade = m.fireball(fireball) - 30;
             
           
            int block = m.attack(a) - 30;
             block = k.attack(b) - 30;
             block = m.fireball(fireball) - 30;
      
    //dice rolls 
            int mChoices = dc.roll();
            int evadeChance = dc.roll();
            int blockChance = dc.roll();
            
            switch(mChoices){
                case 1 :
                    if(m.getCurrentLife() <= 0){
                    	break; 
                    }else{
                        a = fireball;
                        m.fireball(a);
                       
                        //using thief's evade
                        if(t.getCurrentLife() > 0){
                        	int newWound = t.evade(a);
                            if(evadeChance < 4 && newWound != 0){
                                t.wound(newWound);
                                System.out.println(t.getName() + " evaded " + m.getName() + "'s fireball. Damage: "+newWound);
                             }else{
                                t.wound(a); 
                                System.out.println(m.getName() + " attacks " + t.getName() + " for "+a+" using fireball");
                             }
                        }

                        
                        //using knight's block
                        if(k.getCurrentLife() > 0){
                        	int newWound = k.block(a);
                            if(blockChance < 4 && newWound == 0){
                                k.wound(newWound);
                                System.out.println(k.getName() + " blocked " + m.getName() + "'s fireball. Damage: "+newWound);
                             }else{
                                 k.wound(a);
                                 System.out.println(m.getName() + " attacks " + k.getName() + " for "+a+" using Fireball!");
                             }
                        }

                    }
                        
                    break;
                case 2:          
                    if(m.getCurrentLife() <= 0){
                    	break; 
                    }else{
                       m.attack(a);
                    
                        //using thief's evade
                       if(t.getCurrentLife() > 0){
                    	int newWound = t.evade(a);   
                        if(evadeChance < 4 && newWound != 0){
                           
                           t.wound(newWound);
                           System.out.println(t.getName() + " evaded " + m.getName() + ". Damage: "+newWound);
                        }else{
                           t.wound(a); 
                           System.out.println(m.getName() + " attacks " + t.getName() + " for "+a);
                        }
                       }
                                            
                        //using knight's block
                       if(k.getCurrentLife() > 0){
                    	 int newWound = k.block(a);  
                        if(blockChance < 4 && newWound == 0){
                           
                           k.wound(newWound);
                           System.out.println(k.getName() + " blocked " + m.getName() + ". Damage: "+newWound);
                        }else{
                            k.wound(a);
                            System.out.println(m.getName() + " attacks " + k.getName() + " for "+a);
                        }
                    }
                 }
                 
                    break;
                case 3:
                    if(m.getCurrentLife() <= 0){
                    	break; 
                    }else{
                    m.heal(mh);
                    System.out.println(m.getName() + " heals for " + mh);   
                    }
                    break;
            }
            int m2Choices = dc.roll() - 3;
            switch(m2Choices){
            
                case 4 :
                       if(m.getCurrentLife() <= 0){
                    	break; 
                    }else{
                        a = fireball;
                        m.fireball(a);
                       
                        //using thief's evade
                        if(t.getCurrentLife() > 0){
                            int newWound = t.evade(a);	
                        if(evadeChance < 4 && newWound != 0){
                       
                           t.wound(newWound);
                           System.out.println(t.getName() + " evaded " + m.getName() + "'s fireball. Damage: "+newWound);
                        }else{
                           t.wound(a); 
                           System.out.println(t.getName() + " attacks " + t.getName() + " for "+a+" using fireball");
                        }
                      }
                        //using knight's block
                        if(k.getCurrentLife() > 0){
                         int newWound = k.block(a);	
                        if(blockChance < 4 && newWound == 0){
                          
                           k.wound(newWound);
                           System.out.println(k.getName() + " blocked " + m.getName() + "'s fireball. Damage: "+newWound);
                        }else{
                            k.wound(a);
                            System.out.println(m.getName() + " attacks " + k.getName() + " for "+a+" using Fireball!");
                        }
                    }
                 }
                    break;
                case 5:
                   if(m.getCurrentLife() <= 0){
                    	break; 
                    }else{
                       m.attack(a);
                    
                        //using thief's evade
                       if(t.getCurrentLife() > 0){
                    	  int newWound = t.evade(a);   
                        if(evadeChance < 4 && newWound != 0){
                         
                           t.wound(newWound);
                           System.out.println(t.getName() + " evaded " + m.getName() + ". Damage: "+newWound);
                        }else{
                           t.wound(a); 
                           System.out.println(m.getName() + " attacks " + t.getName() + " for "+a);
                        }
                    k.wound(a);
                   }                      
                        //using knight's block
                       if(k.getCurrentLife() > 0){
                    	int newWound = k.block(a);   
                        if(blockChance < 4 && newWound == 0){
                            
                           k.wound(newWound);
                           System.out.println(k.getName() + " blocked " + m.getName() + ". Damage: "+newWound);
                        }else{
                            k.wound(a);
                            System.out.println(m.getName() + " attacks " + k.getName() + " for "+a);
                        }
                    }
                    }
                    break;
                case 6:
                    if(m.getCurrentLife() <= 0){
                    	break; 
                    }else{
                     m.heal(mh);
                    System.out.println(m.getName() + " heals for " + mh);    
                    }
                    break;
            }
            
             int tChoices = dc.roll();       
            switch(tChoices){
                case 1:
                case 2:
                    if(t.getCurrentLife()<= 0){
                    	break; 
                    }else{
                    t.attack(b);
                    m.wound(b);
                    System.out.println(t.getName() + " attacks " + k.getName() + " for " + b);
                    
                    if(k.getCurrentLife() > 0){
                      int newWound = k.block(b);	
                    if(blockChance < 4 && newWound == 0){
                    
                        k.wound(newWound);
                        System.out.println(k.getName() + " blocked " + t.getName() + ". Damage: "+newWound);
                     }else{
                         k.wound(b);
                         System.out.println(t.getName() + " attacks " + k.getName() + " for "+b);
                     }
                    }
                    }
                    break;
                case 3:
                   if(t.getCurrentLife()<= 0){
                   	break; 
                   }else{
                    t.heal(th);
                   System.out.println(t.getName() + " heals for " + th);    
                   }
                    break;
            }
            int t2Choices = dc.roll() - 3 ;       
            switch(t2Choices){
                case 4 :
                case 5:
                    if(t.getCurrentLife()<= 0){
                    	break; 
                    }else{
                    t.attack(b);
                    m.wound(b);
                    System.out.println(t.getName() + " attacks " + m.getName() + " for " + b);
                    
                    if(k.getCurrentLife() > 0){
                        int newWound = k.block(b);	
                        
                    if(blockChance < 4 && newWound == 0){
                        k.wound(newWound);
                        System.out.println(k.getName() + " blocked " + t.getName() + ". Damage: "+newWound);
                     }else{
                         k.wound(b);
                         System.out.println(t.getName() + " attacks " + k.getName() + " for "+b);
                     }  
                    }
                    }
                    break;
                case 6:
                   if(t.getCurrentLife()<= 0){
                   	break; 
                   }else{
                     t.heal(th);
                   System.out.println(t.getName() + " heals for " + th);      
                   }
                    break;
            }
            
             int kChoices = dc.roll();
            
            switch(kChoices){
            
                case 1 :
                case 2:
                    if(k.getCurrentLife()<=0){
                    	break; 
                    }else{
                    k.attack(c);
                    m.wound(c);
                    System.out.println(k.getName() + " attacks " + m.getName() + " for " + c);
                       int newWound = t.evade(c);
                    if(evadeChance < 4 && newWound != 0){
                     
                        t.wound(newWound);
                        System.out.println(t.getName() + " evaded " + k.getName() + "'s Attack. Damage: "+newWound);
                     }else{
                        t.wound(c); 
                        System.out.println(k.getName() + " attacks " + t.getName() + " for "+c+".");
                     }
                    }
                    break;
                case 3:
                    if(k.getCurrentLife()<=0){
                    	break; 
                    }else{
                     k.heal(kh);
                    System.out.println(k.getName() + " heals for " + kh);         
                    }
                    break;
            }int k2Choices = dc.roll() - 3;
                    switch(k2Choices){
                case 4:
                case 5:
                    if(k.getCurrentLife()<=0){
                    	break; 
                    }else{
                     k.attack(c);
                    m.wound(c);   
                    System.out.println(k.getName() + " attacks " + m.getName() + " for " + c);
                    
                    if(t.getCurrentLife() > 0){
                     int newWound = t.evade(c); 	
                    if(evadeChance < 4 && newWound != 0){
                        t.wound(newWound);
                        System.out.println(t.getName() + " evaded " + k.getName() + ". Damage: "+newWound);
                     }else{
                        t.wound(c); 
                        System.out.println(k.getName() + " attacks " + t.getName() + " for "+c+" .");
                     }  
                    }
                    }
                    break;
                case 6:
                    if(k.getCurrentLife()<=0){
                    	break; 
                    }else{
                    k.heal(kh);
                    System.out.println(k.getName() + " heals for " + kh);    
                    }
                    break;
            }
            
            System.out.println(" ");
            
//               if(m.getCurrentLife() > 0){
//            System.out.println(m.getName() + " attacks " + t.getName() + " and " + k.getName() +" for: "+ c); //printing of attacks
//            
//            }
//               if(t.getCurrentLife() > 0){  
//            System.out.println(t.getName() + " attacks " + m.getName() + " and " + k.getName() +" for: "+ t.attack());      
//            }
//         
//               if(k.getCurrentLife() > 0){  
//            System.out.println(k.getName() + " attacks " + m.getName() + " and " + t.getName() +" for: "+ k.attack());
//            } 
               
            System.out.println(" ");
            
               if(m.getCurrentLife() >  0){
                    System.out.println(m.getName() + " rolled " + mChoices);
               }
                if(t.getCurrentLife() > 0){
                    System.out.println(t.getName() + " rolled " + tChoices);	     	
                }
                if(k.getCurrentLife() > 0){
                    System.out.println(k.getName() + " rolled " + kChoices);   	
                }
            
          
            if(m.getCurrentLife() <= 0 && t.getCurrentLife() <= 0){
             System.out.println(" ");
             System.out.println(m.getName() + " health: " + m.getCurrentLife());
             System.out.println(t.getName() + " health: " + t.getCurrentLife());
             System.out.println(k.getName() + " health: " + k.getCurrentLife());
             System.out.println(k.getName() + " Wins! "); 
             break;
            
             }
             else if(t.getCurrentLife() <= 0 && k.getCurrentLife() <= 0){
             System.out.println(" ");
             System.out.println(m.getName() + " health: " + m.getCurrentLife());
             System.out.println(t.getName() + " health: " + t.getCurrentLife());
             System.out.println(k.getName() + " health: " + k.getCurrentLife());
             System.out.println(m.getName() + " Wins! "); 
             break;
        
        }
             else if(k.getCurrentLife() <= 0 && m.getCurrentLife() <= 0){
             System.out.println(" ");
             System.out.println(m.getName() + " health: " + m.getCurrentLife());
             System.out.println(t.getName() + " health: " + t.getCurrentLife());
             System.out.println(k.getName() + " health: " + k.getCurrentLife());
             System.out.println(t.getName() + " Wins! "); 
              break;
                
                
            }    
        }
      
    }
}