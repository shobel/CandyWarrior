
package candywarrior;

import java.util.ArrayList;

/**
 *
 * @author Sam
 */
public class Monster {
    private int maxHealth;
    private int damage;
    private int critPercent;
    private int coins;
    
    private int currentHealth;
    
    private static Monster grassBoss;
    private static ArrayList<Monster> grassMonsters = new ArrayList<>();
    private static Monster desertBoss;
    private static ArrayList<Monster> desertMonsters = new ArrayList<>();
    private static Monster jungleBoss;
    private static ArrayList<Monster> jungleMonsters = new ArrayList<>();
    private static Monster snowBoss;
    private static ArrayList<Monster> snowMonsters = new ArrayList<>();
    private static Monster castleBoss;
    private static ArrayList<Monster> castleMonsters = new ArrayList<>();
    private static Monster swampBoss;
    private static ArrayList<Monster> swampMonsters = new ArrayList<>();
    
    public Monster(int health, int damage, int critPercent, int coins){
        this.maxHealth = health;
        this.currentHealth = maxHealth;
        this.damage = damage;
        this.critPercent = critPercent;
        this.coins = coins;
    
    }

    public int getHealth() {
        return maxHealth;
    }

    public int getDamage() {
        return damage;
    }

    public int getCritPercent() {
        return critPercent;
    }

    public int getCoins() {
        return coins;
    }
    
    public int takeDamage(int damage){
        currentHealth -= damage;
        return currentHealth;
    }
    
}
