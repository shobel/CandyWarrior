
package candywarrior;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Sam
 */
public class Equipment {
    
    private int rarity;
    private int slot;
    private String name;
    
    private double defensePercent;
    private double healthPercent;
    private double damagePercent;
    private double critPercent;
    
    private static final double MIN_DEFENSE = 0.8;
    private static final double MAX_DEFENSE = 1.6;
 
    private static final double MIN_HEALTH = 1.5;
    private static final double MAX_HEALTH = 3.0;
    
    private static final double MIN_DAMAGE = 2.0;
    private static final double MAX_DAMAGE = 3.0;
    
    private static final double MIN_CRIT = 0.2;
    private static final double MAX_CRIT = 0.45;
    
    private static final double[] SLOT_MULTIPLIERS = {2.0, 1.5, 2.0, 1.5, 1.0, 1.0, 2.0, 1.5, 10.0};
    private static final double[] RARITY_MULTIPLIERS = {1.0, 3.0, 8.0};

    private static final ArrayList<String> commonEquipmentNames = new ArrayList<>();
    private static final ArrayList<String> rareEquipmentNames = new ArrayList<>();

    //these legendary arraylists will probably have to be hashmaps to pair up unique images to each name
    private static final ArrayList<ArrayList> legendaryEquipmentNames = new ArrayList<>();
    private static final ArrayList<String> legendaryHeads = new ArrayList<>();
    private static final ArrayList<String> legendaryShoulders = new ArrayList<>();
    private static final ArrayList<String> legendaryArmor = new ArrayList<>();
    private static final ArrayList<String> legendaryWrists = new ArrayList<>();
    private static final ArrayList<String> legendaryGloves = new ArrayList<>();
    private static final ArrayList<String> legendaryRings = new ArrayList<>();
    private static final ArrayList<String> legendaryBelts = new ArrayList<>();
    private static final ArrayList<String> legendaryLegs = new ArrayList<>();
    private static final ArrayList<String> legendaryBoots = new ArrayList<>();
    private static final ArrayList<String> legendaryWeapons = new ArrayList<>();
    
    private Random r;
    
    //this is for initializing an item with random stats based on rarity and slot
    public Equipment(int rarity, int slot, Random r){
        this.rarity = rarity;
        this.slot = slot;
        this.r = r;
                
        initStats();
        initName();
    }
    
    //this is for initializing an item with specific name and stats
    public Equipment(int rarity, int slot, String name, double defense, double health, double Damage, double Crit) {
        this.rarity = rarity;
        this.slot = slot;
        this.name = name;

        this.defensePercent = defense;
        this.healthPercent = health;
        this.damagePercent = Damage;
        this.critPercent = Crit;
       
    }
    
    private void initStats() {
        double slotMult = SLOT_MULTIPLIERS[slot];
        if (slot == Constants.WEAPON) {
            slotMult = 1.0;
        }
        double defense = rollForStats(MIN_DEFENSE, MAX_DEFENSE) * slotMult * RARITY_MULTIPLIERS[rarity];
        setDefensePercent((double) Math.round(defense * 10) / 10);

        double health = rollForStats(MIN_HEALTH, MAX_HEALTH) * slotMult * RARITY_MULTIPLIERS[rarity];
        setHealthPercent((double) Math.round(health * 10) / 10);

        double damage = rollForStats(MIN_DAMAGE, MAX_DAMAGE) * SLOT_MULTIPLIERS[slot] * RARITY_MULTIPLIERS[rarity];
        setDamagePercent((double) Math.round(damage * 10) / 10);

        double crit = rollForStats(MIN_CRIT, MAX_CRIT) * SLOT_MULTIPLIERS[slot] * RARITY_MULTIPLIERS[rarity];
        setCritPercent((double) Math.round(crit * 10) / 10);

    }
    
    private void initName() {
        String name = "";
        if (rarity != Constants.LEGENDARY) {
            if (rarity == Constants.COMMON) {
                name = "Common shabby ";
            } else if (rarity == Constants.RARE) {
                name = "Rare metal ";
            }
            switch (slot) {
                case Constants.HEAD: 
                    name = name + "helmet";
                    break;
                case Constants.SHOULDERS:
                    name = name + "shoulder armor";
                    break;
                case Constants.ARMOR:
                    name = name + "body armor";
                    break;
                case Constants.BELT:
                    name = name + "gloves";
                    break;
                case Constants.RING:
                    name = name + "ring";
                    break;
                case Constants.GLOVE:
                    name = name + "belt";
                    break;
                case Constants.LEGS:
                    name = name + "leg armor";
                    break;
                case Constants.BOOTS: 
                    name = name + "boots";
                    break;
                case Constants.WEAPON:
                    name = name + "sword";
                    break;
            }
        } else {
            for (int i = 0; i < Constants.ITEMSLOTCOUNT; i++) {
                if (i == slot) {
                    int randomLegendaryValue = r.nextInt(getLegendaryEquipmentNames().get(slot).size()-1);
                    name = getLegendaryEquipmentNames().get(slot).get(randomLegendaryValue).toString();
                    break;
                }
            }
        }
        setName(name);
    }

    public double rollForStats(double min, double max) {
        double randomValue = min + (max - min) * r.nextDouble();
        return randomValue;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public void setDefensePercent(double defensePercent) {
        this.defensePercent = defensePercent;
    }

    public void setHealthPercent(double healthPercent) {
        this.healthPercent = healthPercent;
    }

    public void setDamagePercent(double damagePercent) {
        this.damagePercent = damagePercent;
    }

    public void setCritPercent(double critPercent) {
        this.critPercent = critPercent;
    }

    public int getRarity() {
        return rarity;
    }

    public int getSlot() {
        return slot;
    }

    public String getName() {
        return name;
    }

    public double getDefensePercent() {
        return defensePercent;
    }

    public double getHealthPercent() {
        return healthPercent;
    }

    public double getDamagePercent() {
        return damagePercent;
    }

    public double getCritPercent() {
        return critPercent;
    }
    
    public static void initEquipment() {
        legendaryHeads.add("Gooey gumdrop helmet");
        legendaryHeads.add("Caramel coated helm");
        legendaryHeads.add("Rock candy headpiece");
        legendaryHeads.add("Dark chocolate barbute");
        legendaryEquipmentNames.add(legendaryHeads);

        legendaryShoulders.add("Gooey gumdrop shoulderguards");
        legendaryShoulders.add("Caramel coated pauldrons");
        legendaryShoulders.add("Rock candy spaulders");
        legendaryShoulders.add("Dark chocloate shoulderplates");
        legendaryEquipmentNames.add(legendaryShoulders);

        legendaryArmor.add("Gooey gumdrop armor");
        legendaryArmor.add("Caramel coated cuirass");
        legendaryArmor.add("Rock candy tunic");
        legendaryArmor.add("Dark chocloate breastplate");
        legendaryEquipmentNames.add(legendaryArmor);

        legendaryGloves.add("Gooey gumdrop gloves");
        legendaryGloves.add("Caramel coated mittens");
        legendaryGloves.add("Rock candy handguards");
        legendaryGloves.add("Dark chocloate gauntlets");
        legendaryEquipmentNames.add(legendaryGloves);

        legendaryRings.add("Gooey gumdrop ring");
        legendaryRings.add("Caramel coated band");
        legendaryRings.add("Rock candy hoop");
        legendaryRings.add("Dark chocloate ring");
        legendaryEquipmentNames.add(legendaryRings);

        legendaryBelts.add("Gooey gumdrop belt");
        legendaryBelts.add("Caramel coated waistband");
        legendaryBelts.add("Rock candy girdle");
        legendaryBelts.add("Dark chocloate sash");
        legendaryEquipmentNames.add(legendaryBelts);

        legendaryLegs.add("Gooey gumdrop leggings");
        legendaryLegs.add("Caramel coated legplates");
        legendaryLegs.add("Rock candy leg armor");
        legendaryLegs.add("Dark chocloate chaps");
        legendaryEquipmentNames.add(legendaryLegs);

        legendaryBoots.add("Gooey gumdrop boots");
        legendaryBoots.add("Caramel coated foot armor");
        legendaryBoots.add("Rock candy sabatons");
        legendaryBoots.add("Dark chocloate boots");
        legendaryBoots.add("Butterscotch boots"); //nonset
        legendaryEquipmentNames.add(legendaryBoots);

        legendaryWeapons.add("Cone of cotton candy");
        legendaryWeapons.add("Dark chocolate mallet");
        legendaryWeapons.add("Jaw breaker mace");
        legendaryWeapons.add("Candy cane cutlass");
        legendaryWeapons.add("Rainbow lollipop hammer");
        legendaryWeapons.add("Tangerine taffy trident");
        legendaryWeapons.add("Cinnamon stick club");
        legendaryWeapons.add("Candy apple staff");
        legendaryWeapons.add("Licorice lance");
        legendaryWeapons.add("Rock candy knuckles");
        legendaryEquipmentNames.add(legendaryWeapons);
    }

    public static ArrayList<String> getCommonEquipmentNames() {
        return commonEquipmentNames;
    }

    public static ArrayList<String> getRareEquipmentNames() {
        return rareEquipmentNames;
    }

    public static ArrayList<ArrayList> getLegendaryEquipmentNames() {
        return legendaryEquipmentNames;
    }
    
    public static boolean rollForItem(Random r) {
        int randomValue = r.nextInt((Constants.MAXROLL - Constants.MINROLL) + 1) + Constants.MINROLL;
        if (randomValue <= Constants.EQUIPMENT_DROPRATE) {
            return true;
        } else {
            return false;
        }
    }
    
    public static int rollForSlot(Random r) {
        int randomValue = r.nextInt(Constants.ITEMSLOTCOUNT);
        return randomValue;
    }

    public static int rollForRarity(Random r) {
        int randomValue = r.nextInt((Constants.MAXROLL - Constants.MINROLL) + 1) + Constants.MINROLL;
        if (randomValue <= Constants.LEGENDARY_DROPRATE) {
            return Constants.LEGENDARY;
        } else if (randomValue <= Constants.RARE_DROPRATE) {
            return Constants.RARE;
        } else {
            return Constants.COMMON;
        }
    }   
}
