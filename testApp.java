package cosc201.a2;

import java.util.Set;
import java.util.HashSet;

public class testApp {
    public static void main(String[] args) {
        Potionarium potionarium = new Potionarium();

        // Test adding ingredients
        potionarium.addIngredient(1, "eye of newt");
        potionarium.addIngredient(1, "toe of frog");
        potionarium.addIngredient(2, "bat wing");
        potionarium.addIngredient(3, "snake fang");
        potionarium.addIngredient(3, "lizard tail");

        // Test getting inventory
        Set<String> inventory = potionarium.getInventory();
        System.out.println("Inventory:");
        for (String ingredient : inventory) {
            System.out.println("- " + ingredient);
        }

        // Test getting drawers
        Set<Long> drawersWithSnakeFang = potionarium.getDrawers("snake fang");
        Set<Long> drawersWithLizardTail = potionarium.getDrawers("lizard tail");
        Set<Long> drawersWithBatWing = potionarium.getDrawers("bat wing");

        System.out.println("Drawers with bat wing:");
        for (Long drawer : drawersWithBatWing) {
            System.out.println("- " + drawer);
        }
        System.out.println("Drawers with lizard tail:");
        for (Long drawer : drawersWithLizardTail) {
            System.out.println("- " + drawer);
        }
        System.out.println("Drawers with snake fang:");
        for (Long drawer : drawersWithSnakeFang) {
            System.out.println("- " + drawer);
        }

        // Test getting ingredients
        Set<String> ingredientsInDrawer1 = potionarium.getIngredients(1);
        System.out.println("Ingredients in drawer 1:");
        for (String ingredient : ingredientsInDrawer1) {
            System.out.println("- " + ingredient);
        }

        // Test filling drawer
        boolean filledDrawer = potionarium.fillDrawer(4, new HashSet<String>(Set.of("unicorn horn", "dragon scale")));
        System.out.println("Filled drawer 4: " + filledDrawer);
        filledDrawer = potionarium.fillDrawer(1, new HashSet<String>(Set.of("spider leg", "spider eye")));
        System.out.println("Filled drawer 1: " + filledDrawer);

        // Test removing ingredient
        boolean removedIngredient = potionarium.removeIngredient(2, "bat wing");
        System.out.println("Removed bat wing from drawer 2: " + removedIngredient);
        removedIngredient = potionarium.removeIngredient(3, "non-existent ingredient");
        System.out.println("Removed non-existent ingredient from drawer 3: " + removedIngredient);

        // Test removing ingredients
        boolean removedIngredients = potionarium.removeIngredients(3, new HashSet<String>(Set.of("snake fang", "lizard tail")));
        System.out.println("Removed snake fang and lizard tail from drawer 3: " + removedIngredients);
        removedIngredients = potionarium.removeIngredients(1, new HashSet<String>(Set.of("eye of newt", "toe of frog")));
        System.out.println("Removed eye of newt and toe of frog from drawer 1: " + removedIngredients);

        //display the inventory to see if removing the ingredients worked
        inventory = potionarium.getInventory();
        System.out.println("Inventory:");
        for (String ingredient : inventory) {
            System.out.println("- " + ingredient);
        }

       

    


    }
}

