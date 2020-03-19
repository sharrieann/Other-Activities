package Character;


import Item.Dice;

/**
 *  an abstract method so that it will be accessible to the Character package
 * @author m304user
 */
public abstract class Character {
    public static Dice dice = new Dice();

    protected String name;
    protected int strength;
    protected int dexterity;
    protected int intelligence;
    protected int maxLife;
    public int currentLife;
    protected int armor;

    /**
     * this constructor is for the character
     * @param n name
     * @param s strength
     * @param d dexterity
     * @param i intelligence
     */
   public Character (String n, int s , int d , int i){
      this.name = n;
      this.strength = s;
      this.dexterity = d;
      this.intelligence = i;
      this.maxLife = dice.roll()+500; //Dice: first random number of health + 30
      this.currentLife = maxLife;

    }
   /**
    * this is an overloaded constructor with armor
    * @param n name
    * @param s strength
    * @param d dexterity
    * @param i intelligence 
    * @param a armor
    */
   public Character (String n, int s , int d , int i, int a){ //overloaded constructor
      this.name = n;
      this.armor = a;
      this.strength = s;
      this.dexterity = d;
      this.intelligence = i;
      this.maxLife = dice.roll()+100; //Dice: first random number of health + 30
      this.currentLife = maxLife;

    }

   
  /**
   * this method is for the attack
   * @return dice roll + strength
   */
  public int attack() {
      return dice.roll() + strength;
      //HAHHAHA random number + strength
    }
/**
 * this method is for the damage
 * @param damage the amount of damage taken
 */
  
  public void wound(int damage) {
	  currentLife = currentLife - damage;
      if(currentLife <= 0){  //negative current life will change to zero! WALANG NEGATIVE NA CURRENT LIFE!
          currentLife = 0;
      }
    

    }
/**
 * this method is for the heal
 * @param heal heal will be added to the currentLife but it should not exceed to the maxLife
 */
  public void heal(int heal) {
      if (currentLife + heal > maxLife){  //Currentlife must not exceed to the maxlife! 
          currentLife = maxLife;
      }  

  }

  /**
   * this method will get the Name of the character 
   * @return name
   */
  public String getName() {
        return name;
    }
/**
 * this method will get the Strength of the character
 * @return strength
 */
  
  
  public int getStrength() {
      
        return strength;
    }

  /**
   * this method will get the Dexterity of the character
   * @return dexterity
   */
  public int getDexterity() {
        return dexterity;
    }
  
  /**
   * this method will get the intelligence of the character
   * @return intelligence
   */

public int getIntelligence() {
         return intelligence;
}

/**
 * this method will get the currentLife of the character
 * @return currentLife
 */

public int getCurrentLife() {
          return currentLife;
}

/**
 * this method will get the MaxLife of the character
 * @return maxLife
 */
public int getMaxLife() {
          return maxLife;
    }


   /**
    * this abstract method is for calling the summonpet in the summon interface
    * @return 
    */
   public abstract int summonpet();    


}

