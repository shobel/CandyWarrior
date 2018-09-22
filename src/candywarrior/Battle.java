package candywarrior;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Sam
 */
public class Battle {

    private Player player;
    private Monster monster;
      
    private Random r = new Random();
    private Scanner in;
    
    public Battle(Player player, Monster monster){
        this.player = player;
        this.monster = monster;
        
        in = new Scanner(System.in);
    }
    
    private void playerAttack(){
        boolean isCrit = r.nextBoolean();
        int damage = player.getDamage();
        
        if (isCrit) {
            damage = (int) (Math.round((damage * Constants.PLAYER_CRIT_MULTIPLIER)*100.0)/100.0);
        }        
        monster.takeDamage(damage);
    }
    
    private void monsterAttack(){
        boolean isCrit = r.nextBoolean();
        int damage = monster.getDamage();
        
        if (isCrit) {
            damage = (int) (Math.round((damage * Constants.MONSTER_CRIT_MULTIPLIER)*100.0)/100.0);
        }        
        player.takeDamage(damage);
    }
    
    public static void test() {
        String words = "My name is Sam";
        String[] stringArray = words.split(" ");
        if (stringArray.length == 1) {

        }
    }
    
}
