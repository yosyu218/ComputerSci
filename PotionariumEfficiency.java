package cosc201.a2;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class PotionariumEfficiency {

    public static void main(String[] args) {
        int numTrials = 1000000;
        int numIngredients = 50;

        Potionarium potionarium = new Potionarium();

        // Add ingredients to test efficiency of addIngredient method
        long startTime = System.nanoTime();
        for (int i = 0; i < numTrials; i++) {
            potionarium.addIngredient(i % numIngredients, null);
        }
        long endTime = System.nanoTime();
        long elapsedTime = endTime - startTime;
        double avgAddTime = (double) elapsedTime / numTrials;
        System.out.println("Average time taken for addIngredient method: " + avgAddTime + " nanoseconds");

        // Remove ingredients to test efficiency of removeIngredient method
        startTime = System.nanoTime();
        for (int i = 0; i < numTrials; i++) {
            potionarium.removeIngredient(i % numIngredients, null);
        }
        endTime = System.nanoTime();
        elapsedTime = endTime - startTime;
        double avgRemoveTime = (double) elapsedTime / numTrials;
        System.out.println("Average time taken for removeIngredient method: " + avgRemoveTime + " nanoseconds");

        // Fill drawers to test efficiency of fillDrawer method
        startTime = System.nanoTime();
        for (int i = 0; i < numTrials; i++) {
            Set<String> ingredients = new HashSet<>();
            ingredients.add("ingredient " + (i % numIngredients));
            potionarium.fillDrawer(i % numIngredients, ingredients);
        }
        endTime = System.nanoTime();
        elapsedTime = endTime - startTime;
        double avgFillTime = (double) elapsedTime / numTrials;
        System.out.println("Average time taken for fillDrawer method: " + avgFillTime + " nanoseconds");

        // // Remove ingredients to test efficiency of removeIngredients method
        // ArrayList<Integer> ingredientsToRemove = new ArrayList<>();
        // for (int i = 0; i < numIngredients; i++) {
        //     ingredientsToRemove.add(i);
        // }
        // startTime = System.nanoTime();
        // for (int i = 0; i < numTrials; i++) {
        //     potionarium.removeIngredients(i % numIngredients, ingredientsToRemove);
        // }
        // endTime = System.nanoTime();
        // elapsedTime = endTime - startTime;
        // double avgRemoveIngredientsTime = (double) elapsedTime / numTrials;
        // System.out.println("Average time taken for removeIngredients method: " + avgRemoveIngredientsTime + " nanoseconds");

        // Convert to string to test efficiency of toString method
        startTime = System.nanoTime();
        for (int i = 0; i < numTrials; i++) {
            potionarium.toString();
        }
       
    }
}
    