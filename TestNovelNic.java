package cosc201.a2;
import java.util.List;

public class TestNovelNic {
    private Potionarium potionarium;

    public TestNovelNic(Potionarium potionarium) {
        this.potionarium = potionarium;
    }

    public static void main(String[] args) {
      // Create a new Potionarium with some ingredients
Potionarium potionarium = new Potionarium();
potionarium.addIngredient(0, "eon");
potionarium.addIngredient(0, "she");
potionarium.addIngredient(0, "tof");
potionarium.addIngredient(13, "abc");
potionarium.addIngredient(42, "eon");
potionarium.addIngredient(42, "foa");

// Create a new StandardSam instance and use it to collect ingredients
StandardSam sam = new StandardSam(potionarium);
List<String> recipe1 = List.of("eon", "xxx", "abc", "xyz");
String order1 = sam.collectIngredients(recipe1);
System.out.println(order1); // "Missing ingredients: xxx, xyz"

List<String> recipe2 = List.of("eon", "abc", "foa","apple");
String order2 = sam.collectIngredients(recipe2);
System.out.println(order2); // "0: eon, 13: abc, 42: foa"

// Check the results
System.out.println("Ingredients remaining : "+potionarium.toString()); 


    }
}
