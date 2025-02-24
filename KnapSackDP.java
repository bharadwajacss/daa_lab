import java.util.*;

class KnapSackDP {
    static int knapSack(int W, int wt[], int val[], int n, List<Integer> itemsIncluded)
    {
        // Making and initializing dp array
        int[] dp = new int[W + 1];
        int[][] keep = new int[n + 1][W + 1];

        for (int i = 1; i < n + 1; i++) {
            for (int w = W; w >= 0; w--) {
                if (wt[i - 1] <= w) {
                    if (dp[w] < dp[w - wt[i - 1]] + val[i - 1]) {
                        dp[w] = dp[w - wt[i - 1]] + val[i - 1];
                        keep[i][w] = 1;
                    }
                }
            }
        }

        // Finding the items included in the knapsack
        int K = W;
        for (int i = n; i > 0 && K > 0; i--) {
            if (keep[i][K] == 1) {
                itemsIncluded.add(i - 1);
                K -= wt[i - 1];
            }
        }

        // Returning the maximum value of knapsack
        return dp[W];
    }

    // Driver code
    public static void main(String[] args)
    {
        int profit[] = { 60, 100, 120 };
        int weight[] = { 10, 20, 30 };
        int W = 50;
        int n = profit.length;
        List<Integer> itemsIncluded = new ArrayList<>();
        int maxProfit = knapSack(W, weight, profit, n, itemsIncluded);

        // Create a binary vector to represent the inclusion of items
        int[] includedVector = new int[n];
        for (int i : itemsIncluded) {
            includedVector[i] = 1;
        }

        System.out.println("Maximum profit: " + maxProfit);
        System.out.print("Items included: ");
        for (int i : includedVector) {
            System.out.print(i + " ");
        }
    }
}