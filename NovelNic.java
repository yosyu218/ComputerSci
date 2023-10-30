package cosc201.a2;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NovelNic extends Potionmaster {

    public NovelNic(Potionarium potionarium) {
        super(potionarium);
    }

    @Override
    public String collectIngredients(List<String> ingredients) {
        Set<String> missingIngredients = new HashSet<>();
        Set<String> usedIngredients = new HashSet<>();
        StringBuilder orderSlipBuilder = new StringBuilder();

        // Check if all ingredients are available in the Potionarium
        for (String ingredient : ingredients) {
            if (usedIngredients.contains(ingredient)) {
                continue; // Skip if ingredient has already been used in this recipe
            }
            Set<Long> drawerNumbers = potionarium.getDrawers(ingredient);
            if (drawerNumbers.isEmpty()) {
                missingIngredients.add(ingredient);
            } else {
                long drawerNumber = drawerNumbers.iterator().next();
                usedIngredients.add(ingredient);
                orderSlipBuilder.append(drawerNumber).append(": ").append(ingredient).append(", ");
                potionarium.removeIngredient(drawerNumber, ingredient);
            }
        }

        // Generate order slip for missing ingredients, if any
        if (!missingIngredients.isEmpty()) {
            orderSlipBuilder.setLength(0); // Clear the order slip builder
            for (String ingredient : missingIngredients) {
                orderSlipBuilder.append(ingredient).append(", ");
            }
            String orderSlip = orderSlipBuilder.toString().trim();
            return "Missing ingredients: " + orderSlip;
        }

        // Generate order slip with the used ingredients from each drawer
        String orderSlip = orderSlipBuilder.toString().trim();
        return orderSlip;
    }
}
