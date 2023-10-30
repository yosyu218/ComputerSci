package cosc201.a2;

import java.util.*;

/**
 * A potionmaster is a person who can create potions from ingredients.
 * 
 * Extensions of this class represent different potionmasters whose methods 
 * for choosing ingredients may be different.
 * 
 */
public abstract class Potionmaster {

  final Potionarium potionarium;

  /**
   * Creates a new potionmaster.
   * 
   * @param potionarium The potionarium to be used by the potionmaster.
   */
  public Potionmaster(Potionarium potionarium) {
    this.potionarium = potionarium;
  }

  /**
   * Collects the ingredients required for a potion from the potionarium. Each
   * potionmaster has a different method for choosing ingredients. If one or more ingredients 
   * are missing, the potionmaster must not make any changes to the potionarium. If all 
   * ingredients are present, the potionmaster removes one copy of each from the potionarium. 
   * 
   * The list of ingredients should not contain any duplicates. Even if it does, only a single
   * copy of any ingredient should be removed from the potionarium.
   * 
   * The method returns an order slip indicating what was done. In the case that ingredients
   * were missing, the order slip consists of the words "Missing ingredients" followed by
   * a colon, a space, and then a comma-separated list of the missing ingredients. 
   * If all the ingredients were available, the order slip consists of a sequence of lines 
   * each giving a drawer number, followed by a colon, followed by a comma-separated list 
   * of ingredients used from that drawer. The lines should be ordered by drawer number. 
   * 
   * See the assignment description for more details and examples.
   * 
   * @param  ingredients The list of ingredients required for the potion.
   * @return The order slip for the potion.
   */
  public abstract String collectIngredients(List<String> ingredients);

  
}
