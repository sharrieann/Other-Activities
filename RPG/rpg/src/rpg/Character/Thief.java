package Character;


import Character.Character;
import Item.Summon;

/**
  *   extended class of the Character 
 *  another "model" in the Character class, the Thief
 * it has a unique attribute which is the evade
 * implements Summon so that it can call the Summon Method
 * 
 * @author m304user* 
 */


public class Thief extends Character implements Summon  {
    
   private int stamina;
    
   /**
    *  this constructor is for calling the parameters of the parent class
    * and the values is already default
    * @param n name
    * @param s strength
    * @param i intelligence
    */
   
    public Thief(String n, int s, int i) {
        super(n, s, 25, i, 2);
        stamina = 20;
    }
    
    
    /**
     * the special skill of the thief
     * @param damage
     * @return 
     */
    public int evade(int damage){
        if(stamina < 5){
             //if umiwas pero natamaan mababawasan un stamina
        }else{
            stamina = stamina - 5;
            return damage - (dexterity + dice.roll());
        }
        return 0; //evade succesfully
    }
    
    
    /**
     * overrided wound method, which will reduces the character's currentLife
     * @param d damage 
     */
    
   @Override
    public void wound(int damage) {
	   currentLife = (currentLife + armor) - damage;
	      if(currentLife <= 0){  //negative current life will change to zero! WALANG NEGATIVE NA CURRENT LIFE!
	          currentLife = 0;
	                            }
}
    
    /**
     * the generates the attack of the thief
     * @param d dexterity
     * @return  dice roll added to dexterity
     */
    public int attack(int d){
        
        return dice.roll() + dexterity;
    }
    
    /**
     *  the character's currentlife added to the heal, and it must not exceed to its maxLife
     * @param heal 
     */
   @Override
      public void heal(int heal) {
      if (currentLife + heal > maxLife){  //Currentlife must not exceed to the maxlife! 
          currentLife = maxLife;
      }  

  }
      
      /**
       * 
       * overrides the summonpet method in the Character class
       * @return  dicec roll plus 1
       * 
       */

    public int summonpet(){
      return dice.roll() + 1;
    }
    
    /**
     * summons a pet
     */
    
        public void petability(){
        if((summonpet() % 2) == 1) {
        System.out.println(this.getName() + " summons a Pikachu! Summons succesfully and evade decreases by 5 more damage permanently!");
         dexterity = dexterity + 5;
        }
        else{
            System.out.println(this.getName() + " fails to summon a pet!");
        }

    }
            
 
}

