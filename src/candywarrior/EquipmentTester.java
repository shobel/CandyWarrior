/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package candywarrior;

import java.util.Random;

/**
 *
 * @author Sam
 */
public class EquipmentTester {
    
    private static Random r = new Random();

    public static void main(String[] args) {
        testEquipment();
    }

    public static void testEquipment() {
        Equipment commonHead = new Equipment(0, 0, r);
        System.out.println("Common head item:");
        System.out.println("Defense: +" + commonHead.getDefensePercent() + "%  Health: +" + commonHead.getHealthPercent() + "%");
        Equipment rareHead = new Equipment(1, 0, r);
        System.out.println("Rare head item:");
        System.out.println("Defense: +" + rareHead.getDefensePercent() + "%  Health: +" + rareHead.getHealthPercent() + "%");
        Equipment legendaryHead = new Equipment(2, 0, r);
        System.out.println("Legendary head item:");
        System.out.println("Defense: +" + legendaryHead.getDefensePercent() + "%  Health: +" + legendaryHead.getHealthPercent() + "%");

        System.out.println();

        Equipment commonRing = new Equipment(0, 4, r);
        System.out.println("Common ring:");
        System.out.println("Defense: +" + commonRing.getDefensePercent() + "%  Health: +" + commonRing.getHealthPercent() + "%");
        Equipment rareRing = new Equipment(1, 4, r);
        System.out.println("Rare head item:");
        System.out.println("Defense: +" + rareRing.getDefensePercent() + "%  Health: +" + rareRing.getHealthPercent() + "%");
        Equipment legendaryRing = new Equipment(2, 4, r);
        System.out.println("Legendary head item:");
        System.out.println("Defense: +" + legendaryRing.getDefensePercent() + "%  Health: +" + legendaryRing.getHealthPercent() + "%");

        System.out.println();

        //make weapons
        Equipment commonWeapon = new Equipment(0, 8, r);
        System.out.println("Recieved common weapon:");
        System.out.println("Damage: +" + commonWeapon.getDamagePercent() + "%  Crit: +" + commonWeapon.getCritPercent() + "%");
        Equipment rareWeapon = new Equipment(1, 8, r);
        System.out.println("Recieved rare weapon:");
        System.out.println("Damage: +" + rareWeapon.getDamagePercent() + "%  Crit: +" + rareWeapon.getCritPercent() + "%");
        Equipment legendaryWeapon = new Equipment(2, 8, r);
        System.out.println("Recieved legendary weapon:");
        System.out.println("Damage: +" + legendaryWeapon.getDamagePercent() + "%  Crit: +" + legendaryWeapon.getCritPercent() + "%");
    }

}
