package fibonacci;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int count = 5;
        fibonacci(5);

        System.out.println("***");
        int[] fibonacci_series = fibonacci_recursion(10);

        for (int i = 0; i < fibonacci_series.length; i++){
            System.out.print("" + fibonacci_series[i] + " | ");
        }

        System.out.println("***");
        System.out.println(sum_of_fibonacci(5));


    }

    public static void fibonacci(int count){
        int first = 0, second = 1;

        System.out.println("First " + count + " Fibonacci numbers are: ");

        for(int i = 0; i < count; i++){
            System.out.print(first + " | ");
           int temp = first + second;
            first = second;
            second = temp;
        }
    }

    public static int[] fibonacci_recursion(int count) {
        int[] number = new int[count];

        for (int i = 0; i < count; i++){
            number[i] = fibonacci_recursion_helper(i);
        }
        return number;
    }

    public static int fibonacci_recursion_helper(int count){
        if (count == 0) {
            return 0;
        } else if (count == 1 || count == 2) {
            return 1;
        } else {
            return fibonacci_recursion_helper(count - 1) + fibonacci_recursion_helper(count - 2);
        }
    }

    public static int sum_of_fibonacci(int count){
        int first = 0, second = 1, sum = first + second;

        if (count <= 1){
            return 0;
        }

        for (int i = 2; i<count; i++){
            int temp = first + second;
            first = second;
            second = temp;
            sum += temp;
        }
        return sum;
    }

}


