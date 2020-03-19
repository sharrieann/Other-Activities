package Character;


import Character.Character;
import Item.Summon;
import Item.Dice;

/**
 *  extended class of the Character
 *  another "model" in the Character class, the Mage
 * it has a a unique attribute: manapoints and fireball
 * implements Summon so that it can call the Summon Method
 * @author m304user
 */

public class Mage extends Character implements Summon{

 Dice dice = new Dice();
  
  private int manapoints;
 
  
     /**
    *  this constructor is for calling the parameters of the parent class
    * and the values is already default
    * @param n  name
    * @param d dexterity
    * @param i  intelligence
    */
  
    public Mage(String n, int s, int d) {
        super(n, s, d, 25, 2);
        manapoints = 20;
    }
    
    /**
     * overrided wound method, which will reduces the character's currentLife
     * @param damage 
     */
    
    @Override
    public void wound(int damage) { //overided:wound method
    	currentLife = (currentLife + armor) - damage;
        if(currentLife <= 0){  //negative current life will change to zero! WALANG NEGATIVE NA CURRENT LIFE!
            currentLife = 0;
        }
      
    }
    
    /**
     *  the special skill of the mage
     * @param d damage
     * @return dice roll added to the intelligence
     */
    
    public int fireball( int damage){ //special methods: block evade fireball
        if(manapoints <= 6 ){
            damage = manapoints - 6;
        }
        else{
            
        }
        return dice.roll() + intelligence;
        
    } 
    /**
     *  the generates the attack of the mage
     * @param i intelligence
     * @return dice roll added to the intelligence of the character
     */
    
    public int attack(int i){
        
        return dice.roll() + intelligence;
    }
    
    /**
     * the character's currentlife added to the heal, and it must not exceed to its maxLife
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
       * @return dice roll minus 1
       */
    
 @Override
    public int summonpet() {
       return dice.roll() - 1;
           
       }
    /**
     * it will either summons a pet or not
     */
 @Override
    public void petability(){
        if((summonpet() % 2) == 0) {
        System.out.println(this.getName() + " summons a Phoenix! Fireball damage is permanently increased by 5!");
         intelligence = intelligence + 5;
        }
        else{
            System.out.println(this.getName() + " fails to summon a pet!");
        }

    }
}