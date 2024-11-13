import java.util.Scanner;

public class knapsackDP {

    public static int knapsackDP(int W, int[] wt, int[] val, int n) {
        int[][] K = new int[n + 1][W + 1];

        // Build table K[][] in a bottom-up manner
        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= W; w++) {
                if (i == 0 || w == 0) {
                    K[i][w] = 0;
                } else if (wt[i - 1] <= w) {
                    K[i][w] = Math.max(val[i - 1] + K[i - 1][w - wt[i - 1]], K[i - 1][w]);
                } else {
                    K[i][w] = K[i - 1][w];
                }
            }
        }

        return K[n][W]; // Maximum profit
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get number of items
        System.out.print("Enter number of elements: ");
        int n = scanner.nextInt();

        // Get weights of items
        int[] wt = new int[n];
        System.out.print("Enter weights: ");
        for (int i = 0; i < n; i++) {
            wt[i] = scanner.nextInt();
        }

        // Get values of items
        int[] val = new int[n];
        System.out.print("Enter values: ");
        for (int i = 0; i < n; i++) {
            val[i] = scanner.nextInt();
        }

        // Get maximum weight capacity
        System.out.print("Enter capacity: ");
        int W = scanner.nextInt();

        // Compute and display the maximum possible profit
        int maxProfit = knapsackDP(W, wt, val, n);
        System.out.println("Maximum possible profit = " + maxProfit);

        scanner.close();
    }
}
