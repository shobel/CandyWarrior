
package candywarrior;

import java.util.ArrayList;

/**
 *
 * @author Sam
 */
public class Area {
    
    String name;
    private Monster boss;
    private ArrayList<Monster> monsters;
    
    public Area(ArrayList<Monster> monsters, Monster boss, String name){
        this.monsters = monsters;
        this.boss = boss;
        this.name = name;
    }
    
    public static void initAreas(ArrayList<Monster> monsters){
        
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Monster> getMonsters() {
        return monsters;
    }

    public void setMonsters(ArrayList<Monster> monsters) {
        this.monsters = monsters;
    }
    
    
    
}
