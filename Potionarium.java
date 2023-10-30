package cosc201.a2;

import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;



/**
 * A potionarium is a collection of drawers, each of which contains a set of
 * ingredients. 
 * 
 * For Assignment 2, you will implement this class. See the full assignment
 * for further details.
 * 
 * Your code will be marked for correctness (60%) and efficiency (40%).
 * 
 * You may not change the method signatures, but you may add additional methods and/or data
 * fields.
 * 
 */
public class Potionarium {

  private Map<Long, Set<String>> drawers;

  public Potionarium() {
    this.drawers = new HashMap<>();
  };

  /**
   * Determines the inventory of the potionarium.
   * 
   * @return The set of ingredients in the potionarium.
   */
  public Set<String> getInventory() {
        Set<String> inventory = new HashSet<>();
        for (Set<String> drawer : drawers.values()) {
            inventory.addAll(drawer);
        }
        return inventory;
    }
    


 


  /**
   * Determines the drawers that contain an ingredient.
   * 
   * @param ingredient The ingredient to be searched for.
   * @return The set of drawers that contain the ingredient.
   */
  
  public Set<Long> getDrawers(String ingredient) {
    Set<Long> drawers = new HashSet<>();
        for (Map.Entry<Long, Set<String>> entry : this.drawers.entrySet()) {
            if (entry.getValue().contains(ingredient)) {
                drawers.add(entry.getKey());
            }
        }
        return drawers;
    }
   
  

  /**
   * Determines the ingredients that are in a drawer. 
   * 
   * @param drawer The drawer to be searched for.
   * @return The set of ingredients that are in the drawer.
   */
  public Set<String> getIngredients(long drawer) {
    Set<String> ingredients = new HashSet<>();
        if (drawers.containsKey(drawer)) {
            ingredients.addAll(drawers.get(drawer));
        }
        return ingredients;
    }

  
  /**
   * Fills the given drawer with the set of ingredients given, provided that it was
   * empty. If the drawer was not empty, it is not changed.
   * 
   * @param drawer The number of the drawer to be filled
   * @param ingredients The set of ingredients to be added
   * @return True if the drawer was filled, false if it was not empty
   */
  public boolean fillDrawer(long drawer, Set<String> ingredients) {
    if(drawers.containsKey(drawer)&& !drawers.get(drawer).isEmpty())
    {
      return false;
    }
    drawers.put(drawer, new HashSet<>(ingredients));
    return true;
  }
  

  /**
   * Adds an ingredient to a drawer. If the ingredient is already present, it is
   * not added again. 
   * 
   * @param drawer     The number of the drawer to be added to.
   * @param ingredient The ingredient to be added.
   * @return True if the ingredient was added, false if it was already present.
   */
  
  public boolean addIngredient(long drawer, String ingredient) {
    if (!drawers.containsKey(drawer)) {
        drawers.put(drawer, new HashSet<>());
    }
    return drawers.get(drawer).add(ingredient);
  }

  /**
   * Removes an ingredient from a drawer.
   * 
   * @param drawer     The number of the drawer to be removed from.
   * @param ingredient The ingredient to be removed.
   * @return True if the ingredient was removed, false if it was not present.
   */
 
    public boolean removeIngredient(long drawer, String ingredient) {
      Set<String> drawerIngredients = drawers.get(drawer);
      if (drawerIngredients == null) {
        return false;
      }
      return drawerIngredients.remove(ingredient);
    }
 
  


  /**
   * Removes a set of ingredients from a drawer. If one or more are
   * missing, then none should be removed.
   * 
   * @param drawer     The number of the drawer to be removed from.
   * @param ingredients The set of ingredients to be removed.
   * @return True if all ingredients were removed, false if one or more were missing.
   */
  
  public boolean removeIngredients(long drawer, Set<String> ingredients) {
    Set<String> drawerIngredients = drawers.get(drawer);
    if (drawerIngredients == null) {
      return false;
    }
    if (drawerIngredients.containsAll(ingredients)) {
      drawerIngredients.removeAll(ingredients);
      return true;
    }
    return false;
  }
  
  public boolean hasIngredient(String ingredient) {
    for (Set<String> drawer : drawers.values()) {
        if (drawer.contains(ingredient)) {
            return true;
        }
    }
    return false;
}



  /**
 * Removes a set of ingredients from a set of drawers.
 * 
 * @param drawers The set of drawers to remove from.
 * @param ingredients The set of ingredients to remove.
 * @return True if all ingredients were removed, false if at least one ingredient was not present.
 */

public boolean removeIngredients(Set<Long> drawers, String ingredient) {
  boolean success = true;
  for (Long drawer : drawers) {
      Set<String> ingredients = this.drawers.get(drawer);
      if (ingredients == null || !ingredients.contains(ingredient)) {
          success = false;
      } else {
          ingredients.remove(ingredient);
      }
  }
  return success;
}


//returns potionarium as a string for users 
public String toString() {
  StringBuilder sb = new StringBuilder();
  sb.append("Potionarium(drawers={");
  for (Map.Entry<Long, Set<String>> entry : drawers.entrySet()) {
      sb.append(entry.getKey()).append("=[");
      for (String ingredient : entry.getValue()) {
          sb.append(ingredient).append(", ");
      }
      // Remove the last ", " from the string
      if (!entry.getValue().isEmpty()) {
          sb.delete(sb.length() - 2, sb.length());
      }
      sb.append("], ");
  }
  // Remove the last ", " from the string
  if (!drawers.isEmpty()) {
      sb.delete(sb.length() - 2, sb.length());
  }
  sb.append("})");
  return sb.toString();
}




}
