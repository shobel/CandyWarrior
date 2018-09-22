package candywarrior;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Sam
 */
public class CandyWarrior {

    //initialize the random number generator
    public static Random r = new Random();  
    
    public static void main(String[] args) {
        
        Equipment.initEquipment();
            
//        create the main player
//        Scanner in = new Scanner(System.in);
//        System.out.print("State your name, candy warrior: ");
//        String name = in.nextLine();
//        Player player = new Player(name);
        
        Player player = new Player("Sam");
        player.getStats();
        System.out.println("Defeat the evil candy monsters, " + player.getName() + "!");
        
        Equipment dropped = null;
        int counter = 0;
        boolean legendary = false;
        while (!legendary) {
            if (Equipment.rollForItem(r)) {
                System.out.println("Item dropped!");
                int slot = Equipment.rollForSlot(r);
                int rarity = Equipment.rollForRarity(r);
                if (rarity == Constants.LEGENDARY) {
                    legendary = true;
                }
                dropped = new Equipment(rarity, slot, r);
                System.out.println(dropped.getName());
                System.out.println("+" + dropped.getDefensePercent() + "% defense");
                System.out.println("+" + dropped.getHealthPercent() + "% health");
                System.out.println("+" + dropped.getDamagePercent() + "% damage");
                System.out.println("+" + dropped.getCritPercent() + "% crit");
                System.out.println();
            } else {
                System.out.println("No item :(");
                System.out.println();
            }
            counter ++;
        }
        System.out.println("enemies killed: " + counter);
        player.equipItem(dropped);
        player.updateStats();
        player.getStats();
    }
}
