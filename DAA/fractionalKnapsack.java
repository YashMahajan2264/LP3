import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class ItemValue {
    Double cost;
    double weight, value, index;

    // Constructor
    public ItemValue(double weight, double value, int index) {
        this.weight = weight;
        this.value = value;
        this.index = index; 
        this.cost = value / weight; // Calculate value per unit weight
    }
}

class fractionalKnapsack {

    private static double getMaxValue(double[] weights, double[] values, double capacity) {
        List<ItemValue> itemValues = new ArrayList<>();

        // Create item values
        for (int i = 0; i < weights.length; i++) {
            itemValues.add(new ItemValue(weights[i], values[i], i));
        }

        // Sort items by cost (value per weight) in descending order
        itemValues.sort(Comparator.comparingDouble(ItemValue -> -ItemValue.cost));

        double totalValue = 0;

        for (ItemValue item : itemValues) {
            double curWeight = item.weight;
            double curValue = item.value;

            if (capacity - curWeight >= 0) {
                // Take the full item
                capacity -= curWeight;
                totalValue += curValue;
            } else {
                // Take the fractional part of the item
                double fraction = capacity / curWeight;
                totalValue += curValue * fraction;
                capacity = 0; // Knapsack is full
                break;
            }
        }

        return totalValue;
    }

    public static void main(String[] args) {
        double[] weights = {10, 20,30};
        double[] values = {60,100,120};
        double capacity = 50;

        double maxValue = getMaxValue(weights, values, capacity);
        System.out.println("Maximum value in Knapsack = " + maxValue);
    }
}
