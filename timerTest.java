package cosc201.a2;

import cosc201.a2.*;
import java.util.*;

public class timerTest {

    private static final int NUM_RUNS = 1000000;

    public static void main(String[] args) {
        Potionarium potionarium = new Potionarium();
        List<String> ingredients = Arrays.asList("Aconite", "Bat Wings", "Dragon Scales", "Eye of Newt", "Frog Legs", "Ginger Root", "Hemlock", "Ivy", "Jellyfish", "Kelp", "Lizard Legs", "Mandrake Root", "Newt Eyes", "Ogre Ears", "Pig Snout", "Quartz", "Rat Tails", "Snake Fangs", "Troll Hair", "Unicorn Horn", "Viper Venom", "Wolfsbane", "Xanthan Gum", "Yeast", "Zinc", "Banana Peel", "Cocoa Powder", "Dates", "Elderberry", "Fennel Seeds", "Grapefruit Peel", "Hibiscus Flower", "Juniper Berries", "Kaffir Lime Leaves", "Lavender", "Mint Leaves", "Nutmeg", "Orange Peel", "Paprika", "Rose Petals", "Saffron", "Turmeric", "Vanilla Bean", "Wheatgrass", "Yarrow", "Zucchini", "Dragon Fruit", "Kiwi Fruit");
        long novelNicTimeSum = 0;
        long standardSamTimeSum = 0;

        for (int i = 1; i <= NUM_RUNS; i++) {
            Collections.shuffle(ingredients);
            Potionmaster novelNic = new NovelNic(potionarium);
            Potionmaster standardSam = new StandardSam(potionarium);

            long novelNicStartTime = System.nanoTime();
            novelNic.collectIngredients(ingredients);
            long novelNicEndTime = System.nanoTime();
            novelNicTimeSum = (novelNicEndTime - novelNicStartTime);

            long standardSamStartTime = System.nanoTime();
            standardSam.collectIngredients(ingredients);
            long standardSamEndTime = System.nanoTime();
            standardSamTimeSum = (standardSamEndTime - standardSamStartTime);
            System.out.println( novelNicTimeSum+" ms");
            
            //System.out.println("StandardSamTimes "+ standardSamTimeSum+" ms");
        }

        double novelNicAverageTime = ((double) novelNicTimeSum / NUM_RUNS) / 1000000.0;
        double standardSamAverageTime = ((double) standardSamTimeSum / NUM_RUNS) / 1000000.0;

        //System.out.println("Time for NovelNic: " + novelNicAverageTime + " ms");
        //System.out.println("Time for StandardSam: " + standardSamAverageTime + " ms");
    }
}
