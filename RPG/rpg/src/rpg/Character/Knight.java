package Character;


import Character.Character;
import Item.Summon;


/**
 *   extended class of the Character
 *  another "model" in the Character class, the Knight
 * it has a unique attribute which is the block
 * implements Summon so that it can call the Summon Method
 * @author m304user
 */

public  class Knight extends Character implements Summon{
    
   private int durability;
    
   /**
    *  this constructor is for calling the parameters of the parent class
    * and the values is already default
    * @param n name
    * @param d dexterity
    * @param i intelligence
    */
   
    public Knight(String n, int d, int i) {  
        super(n, 25, d, i, 2);
        durability = 20;
    }
    
    /**
     * this constructor is for the block of the knight, it nullifies damage taken if knight has 10 or more durability 
     * 
     * @param damage
     * @return 
     */
    public int block(int damage){
        if(durability < 10){
            return damage;//if umiwas pero natamaan mababawasan un stamina
        }else{
            durability = durability - 10;
            return 0;
        }
         //evade succesfully
    }
    
    /**Reduces the character's currentLife
     * 
     * @param damage 
     */
   @Override
    public void wound(int damage) {
	   currentLife = (currentLife + armor) - damage;
	      if(currentLife <= 0){  //negative current life will change to zero! WALANG NEGATIVE NA CURRENT LIFE!
	          currentLife = 0;
	      }
}
    
    /**
     * the generates the attack of the Knight
     * @param d dexterity 
     * @return dice roll or a random number added with dexterity
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
       * overrides the summonpet method in the Character class
       * @return  dice roll or a random number
       */

   @Override
    public int summonpet(){
      return dice.roll();
    }
    
    /**
     * it either it will summons a pet or not 
     */
   @Override
     public void petability(){
        if(summonpet() == 6){
            System.out.println(this.name + " summons Charizard" );
            System.out.println(this.name + " WINS!");
            System.exit(0);
        }else{
            System.out.println(this.name + " fails to summon");
        }
     }
 
}

