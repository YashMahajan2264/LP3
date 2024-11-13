import java.util.Scanner;

public class FibIterative {

    // Method to calculate and print Fibonacci series up to n terms with step count
    public static void printFibonacciSeries(int n) {
        int stepCount = 0;  // Step counter for each addition operation
        
        // Handle the base cases
        if (n <= 0) {
            System.out.println("No terms to display.");
            return;
        }
        
        // Initialize the first two Fibonacci numbers
        int a = 0, b = 1;
        
        // Print the first Fibonacci number
        System.out.print("Fibonacci Series: " + a);
        
        // Print remaining terms if n > 1
        for (int i = 1; i <= n; i++) {
            System.out.print(" " + b);
            int nextFib = a + b;  // Calculate the next Fibonacci number
            a = b;  // Update a to the previous Fibonacci number
            b = nextFib;  // Update b to the next Fibonacci number
            stepCount++;  // Increment step count for each addition operation
        }
        
        System.out.println("\nTotal steps taken (addition operations): " + stepCount);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Get input from the user
        System.out.print("Enter the number of terms for Fibonacci series: ");
        int n = sc.nextInt();

        // Print Fibonacci series up to n terms
        printFibonacciSeries(n);

        sc.close();
    }
}
