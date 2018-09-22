
package candywarrior;

import java.util.ArrayList;

/**
 *
 * @author Sam
 */
public class Player {
    
    private String name;
    private int level;
    private int deaths;
    private int gold;
    
    private int baseHealth;
    private int maxHealth;
    private double healthPercent;
    private double defensePercent;
    
    private double baseDamage;
    private int damage;
    private double damagePercent; 
    private double baseCrit;
    private double critPercent;
    
    private int currentHealth;
    
    private ArrayList<Equipment> equipped;
    private ArrayList<Equipment> inventory;
    
    //makes a new player with starting stats and basic items
    public Player(String name){
        this.name = name;
        
        initStats();
        initEquipment();
        updateStats();
                
    }

    public void initStats() {
        level = 1;
        deaths = 0;

        baseHealth = 100;
        maxHealth = 100;
        currentHealth = maxHealth;
        defensePercent = 0.0;
        
        baseDamage = 10;
        damage = 10;
        damagePercent = 0.0;
        
        baseCrit = 1.0;
        critPercent = 1.0;
    }
    
    public void initEquipment(){
        //starting equipment
        equipped = new ArrayList<>();
        equipped.add(new Equipment(Constants.COMMON, Constants.HEAD, "Baseball cap", 1.0, 2.0, 2.0, 0.1));
        equipped.add(new Equipment(Constants.COMMON, Constants.SHOULDERS, "empty", 0.0, 0.0, 0.0, 0.0)); //shoulders
        equipped.add(new Equipment(Constants.COMMON, Constants.ARMOR, "Cotton shirt", 1.0, 2.0, 2.0, 0.1));
        equipped.add(new Equipment(Constants.COMMON, Constants.GLOVE, "emtpy", 0.0, 0.0, 0.0, 0.0)); //gloves
        equipped.add(new Equipment(Constants.COMMON, Constants.RING, "emtpy", 0.0, 0.0, 0.0, 0.0)); //rings
        equipped.add(new Equipment(Constants.COMMON, Constants.BELT, "Leather belt", 0.5, 1.5, 0.5, 0.0));
        equipped.add(new Equipment(Constants.COMMON, Constants.LEGS, "Blue Jeans", 1.0, 2.0, 2.0, 0.1));
        equipped.add(new Equipment(Constants.COMMON, Constants.BOOTS, "Basketball sneaks", 0.5, 1.5, 0.5, 0.0));
        equipped.add(new Equipment(Constants.COMMON, Constants.WEAPON, "Wooden slugger", 0.5, 1.0, 10.0, 0.5));
        
        //empty inventory
        inventory = new ArrayList<>();
        
    }

    public void updateStats() {
        double damageTaken = 100;
        critPercent = baseCrit;
        for (int i = 0; i < Constants.ITEMSLOTCOUNT; i++) {
            healthPercent = healthPercent + equipped.get(i).getHealthPercent();
            damageTaken = damageTaken - (100.0 * (equipped.get(i).getDefensePercent() / 100.0));
            damagePercent = damagePercent + equipped.get(i).getDamagePercent();
            critPercent = critPercent + equipped.get(i).getCritPercent(); 
        }
        maxHealth = (int) (baseHealth + (maxHealth * (healthPercent/100.0)));
        defensePercent = Math.round((100.0 - damageTaken) * 100.0)/100.0;
        damage = (int) (Math.round((baseDamage + (damage * (damagePercent/100.0))) * 100.0)/100.0);
        critPercent = Math.round(critPercent * 100.0)/100.0;
                
    }
    
    public void getStats(){
        System.out.println("Defense: " + defensePercent + "%");
        System.out.println("Health: " + maxHealth + " (+" + healthPercent + "%)");
        System.out.println("Damage: " + damage + " (+" + damagePercent + "%)");
        System.out.println("Crit: " + critPercent + "%");
        
    }
    
    public void equipItem(Equipment dropped) {
        equipped.set(dropped.getSlot(), dropped);
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getDeaths() {
        return deaths;
    }

    public void setDeaths(int deaths) {
        this.deaths = deaths;
    }

    public int getHealth() {
        return maxHealth;
    }

    public void setHealth(int health) {
        this.maxHealth = health;
    }

    public double getDefensePercent() {
        return defensePercent;
    }

    public void setDefensePercent(double defensePercent) {
        this.defensePercent = defensePercent;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public double getDamagePercent() {
        return damagePercent;
    }

    public void setDamagePercent(double damagePercent) {
        this.damagePercent = damagePercent;
    }

    public double getCritPercent() {
        return critPercent;
    }

    public void setCritPercent(double critPercent) {
        this.critPercent = critPercent;
    }

    public String getName() {
        return name;
    }
    
    public int takeDamage(int damage){
        int damageTaken = (int) (damage - Math.round((damage*defensePercent)*100.0)/100.0);
        currentHealth -= damageTaken;
        return currentHealth;
    }
    
    
    
}
