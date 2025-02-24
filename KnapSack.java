import java.lang.*;
import java.util.Arrays;
import java.util.Comparator;
 
// Greedy approach
public class KnapSack {
     
    // Function to get maximum value
    private static double getMaxValue(ItemValue[] arr, int capacity, int[] includedVector) {
        // Sorting items by profit/weight ratio;
        Arrays.sort(arr, new Comparator<ItemValue>() {
            @Override
            public int compare(ItemValue item1, ItemValue item2) {
                double cpr1 = new Double((double)item1.profit / (double)item1.weight);
                double cpr2 = new Double((double)item2.profit / (double)item2.weight);
 
                if (cpr1 < cpr2)
                    return 1;
                else
                    return -1;
            }
        });
 
        double totalValue = 0d;
        int i = 0;
 
        while (capacity > 0 && i < arr.length) {
            int curWt = (int)arr[i].weight;
            int curVal = (int)arr[i].profit;
 
            if (capacity - curWt >= 0) {
                // This weight can be picked whole
                capacity = capacity - curWt;
                totalValue += curVal;
                includedVector[i] = 1;
            } else {
                // Item can't be picked whole
                double fraction = ((double)capacity / (double)curWt);
                totalValue += (curVal * fraction);
                includedVector[i] = 1; // Mark as included even if partially
                capacity = (int)(capacity - (curWt * fraction));
                break;
            }
            i++;
        }
 
        return totalValue;
    }
 
    // Item value class
    static class ItemValue {
        int profit, weight;
 
        // Item value function
        public ItemValue(int val, int wt) {
            this.weight = wt;
            this.profit = val;
        }
    }
 
    // Driver code
    public static void main(String[] args) {
        ItemValue[] arr = { new ItemValue(60, 10), new ItemValue(100, 20), new ItemValue(120, 30) };
        int capacity = 50;
        int[] includedVector = new int[arr.length];
        double maxValue = getMaxValue(arr, capacity, includedVector);
        // Function call
        System.out.println("Maximum value: " + maxValue);
        System.out.print("Items included: ");
        for (int i : includedVector) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}