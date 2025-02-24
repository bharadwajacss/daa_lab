public class Fibonacci {

    static void fibonacciRecursive(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(fib(i) + " ");
        }
        System.out.println();
    }

    static int fib(int n) {
        if (n <= 1) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }

   
    static void fibonacciIterative(int n) {
        int a = 0, b = 1;
        for (int i = 0; i < n; i++) {
            System.out.print(a + " ");
            int next = a + b;
            a = b;
            b = next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int n = 10; 

        System.out.println("Fibonacci series using recursion:");
        fibonacciRecursive(n);

        System.out.println("Fibonacci series using iteration:");
        fibonacciIterative(n);
    }
}