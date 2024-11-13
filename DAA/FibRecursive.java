import java.util.Scanner;

public class FibRecursive {

    // Global counter to track the number of steps
    static int stepCount = 0;

    // Recursive method to calculate Fibonacci number with step counting
    public static int fibonacci(int n) {
        stepCount++;  // Increment step count each time the function is called
        if (n <= 1) {
            return n;  // Base case: return n if n is 0 or 1
        }
        // Recursive case: sum of the previous two Fibonacci numbers
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Get input from the user
        System.out.print("Enter the Fibonacci term to calculate: ");
        int n = sc.nextInt();

        // Reset step count for each calculation
        stepCount = 0;
        for(int i=0;i<=n;i++)
        {
            System.out.print(fibonacci(i)+" ");
        }
        System.out.println();
        // Calculate the nth Fibonacci number
        int fibNumber = fibonacci(n);
        
        // Print the Fibonacci number and the step count
        System.out.println("Fibonacci number at position " + n + " is: " + fibNumber);
        System.out.println("Number of steps (recursive calls) taken: " + stepCount);

        sc.close();
    }
}
