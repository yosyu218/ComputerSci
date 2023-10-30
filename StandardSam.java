package cosc201.a2;

import java.util.*;

public class StandardSam extends Potionmaster {


    public StandardSam(Potionarium potionarium) {
        super(potionarium);
    }

    @Override

    public String collectIngredients(List<String> ingredients) {
        Map<String, Integer> missingIngredients = new HashMap<>();
        Set<String> usedIngredients = new HashSet<>();
        StringBuilder orderSlipBuilder = new StringBuilder();

        // Check if all ingredients are available in the Potionarium
        for (String ingredient : ingredients) {
            if (!potionarium.hasIngredient(ingredient)) {
                missingIngredients.put(ingredient, missingIngredients.getOrDefault(ingredient, 0) + 1);
            }
        }

        // Generate order slip for missing ingredients, if any
        if (!missingIngredients.isEmpty()) {
            for (Map.Entry<String, Integer> entry : missingIngredients.entrySet()) {
                String ingredient = entry.getKey();
                int missingCount = entry.getValue();
                for (int i = 0; i < missingCount; i++) {
                    orderSlipBuilder.append(ingredient).append(", ");
                }
            }
            String orderSlip = orderSlipBuilder.toString().trim();
            return "Missing ingredients: " + orderSlip;
        }
        // gets the draw which has the most ingredient when collecting ingredients to maximize the probability of getting the ingredient

        
        
        // Collect available ingredients from the Potionarium
        for (String ingredient : ingredients) {
            if (usedIngredients.contains(ingredient)) {
                continue; // Skip if ingredient has already been used in this recipe
            }
            Set<Long> drawerNumbers = potionarium.getDrawers(ingredient);
            usedIngredients.add(ingredient);
            for (long drawerNumber : drawerNumbers) {
                orderSlipBuilder.append(drawerNumber).append(": ").append(ingredient).append(", ");
            }
            potionarium.removeIngredients(drawerNumbers, ingredient);
        }

        // Generate order slip with the used ingredients from each drawer
        String orderSlip = orderSlipBuilder.toString().trim();
        return orderSlip;
    }
}
