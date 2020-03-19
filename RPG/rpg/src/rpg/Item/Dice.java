package Item;

import java.util.Random;

/**
 * this is a dice function that chooses a random values 
 * @author m304user
 */
public class Dice {
    private Random r;
    public Dice(){
        r = new Random();
    }
    
    /**
     *  it will only choose values form 1 to 6s
     * @return 
     */
    public int roll(){
        return r.nextInt(6)+1;
    }
}