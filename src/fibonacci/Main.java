package fibonacci;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in); // Initializing a scanner

        System.out.println("Welcome to the Fibonacci calculator! Please enter a number of how many Fibonacci numbers do you want to know? \nP.S. We are starting from 0 by the way :) ");
        int count = s.nextInt(); // Initializing a count variable that takes a number for the user. Will later be used to calculate how many Fibonacci numbers do we need

        while(count < 0){ // Making sure the user doesn't type the negative numbers
            System.out.println("We are not working with Negafibonacci here. Please enter a number greater than or equal to 0");
            count = s.nextInt();
        }
        fibonacci(count); // Calling a method with the user's number
        System.out.println("\n***\n");

        System.out.println("Would you like to try the recursion way of finding the first n Fibonacci numbers as well? Please type yes or no: ");
        String answer = s.next(); // Reading the user's answer whether he/she wants to continue or not

        if (answer.equals("yes")) { // if the user wants to continue we run the this part of the code
            System.out.println("How many Fibonacci numbers would you like to get?");
            int count2 = s.nextInt(); // Initializing a count variable that takes a number for the user. Will later be used to calculate how many Fibonacci numbers do we need

            while(count2 < 0){ // Making sure the user doesn't type the negative numbers
                System.out.println("We are not working with Negafibonacci here. Please enter a number greater than or equal to 0");
                count2 = s.nextInt();
            }

            int[] fibonacci_series = fibonacci_recursion(count2); // Calling a method with the user's number
            System.out.println("First " + count2 + " Fibonacci numbers are: ");

            for (int i = 0; i < fibonacci_series.length; i++) { // Printing out all the elements of the array that was filled by 2 recursion methods one by one
                System.out.print("" + fibonacci_series[i] + " | ");
            }

            System.out.println("");
            System.out.println("\n***\n");
        }

        System.out.println("And finally: do you wish to know the sum of the first n Fibonacci numbers? Please type yes or no: ");
        String answer2 = s.next(); // Reading the user's answer whether he/she wants to continue or not

        if (answer2.equals("yes")) { // if the user wants to continue we run the this part of the code
            System.out.println("How many first Fibonacci numbers should be added with each other?");
            int count3 = s.nextInt(); // Initializing a count variable that takes a number for the user. Will later be used to calculate how many Fibonacci numbers do we need

            while(count3 < 0){ // Making sure the user doesn't type the negative numbers
                System.out.println("We are not working with Negafibonacci here. Please enter a number greater than or equal to 0");
                count3 = s.nextInt();
            }

            int sum = sum_of_fibonacci(count3); // Initializing a number that stores a result by calling a method with the user's number
            System.out.println("Your sum is: " + sum);
        }
    }

    public static void fibonacci(int count){ // Iterative void method to print out as many Fibonacci numbers as the user want
        int first = 0, second = 1; // Initializing first two Fibonacci numbers. Some start with 1 and 1 but I decided to do it with 0 and 1

        System.out.println("First " + count + " Fibonacci numbers are: ");

        if(count == 0){ // "Returning" a value of "No number" if the user's input is 0 to avoid any mistakes
            System.out.println("No number");
        }

        else {
            for (int i = 0; i < count; i++) { // A loop that runs as many times as how many Fibonacci numbers the user asked for
                System.out.print(first + " | "); // The next Fibonacci number is always "first" element. It start with 0 and moves every time one step ahead
                int temp = first + second; // using a temporal variable to store the value of the second variable. This way the value of the second variable will not be lost in the process
                first = second; // first variable moves 1 step ahead by getting a value of the second variable that is always a higher Fibonacci number by 1 step
                second = temp; // second variable has passed its value to the first one and can now move 1 step ahead as well
            }
            System.out.println("");
        }
    }

    public static int[] fibonacci_recursion(int count) { // First part of the recursive method. It creates an array filled with the Fibonacci numbers. This way I can easily store them and print them out later one by one
        int[] number = new int[count]; // Creating an empty array of int variables with the length equal to the user's number

        for (int i = 0; i < count; i++){ // A loop that runs as many times as how many Fibonacci numbers the user asked for
            number[i] = fibonacci_recursion_helper(i); // Every number of this array is filled with exactly one Fibonacci number starting from 0 and finishing by the user's number
        }
        return number; // returning an array full of the Fibonacci numbers
    }

    public static int fibonacci_recursion_helper(int count){ // Second part of the recursive method that does the main job. It calls itself every time going 1 step lower until the user's input equal to 0, 1 or 2
        if (count == 0) { // Returning 0 when the method is called with the variable 0. This way our recursion can have its end
            return 0;
        } else if (count == 1 || count == 2) { // Returning 1 when the method is called with the variable 1 or 2. This way our recursion can have its end
            return 1;
        } else { // The method is calling itself every time lowering the user's variable. Each time returning the next Fibonacci number by adding the previous 2. Besides it goes one step deeper by subtracting the user's numbers by 1 and 2 until it hits 0, 1 or 2
            return fibonacci_recursion_helper(count - 1) + fibonacci_recursion_helper(count - 2);
        }
    }

    public static int sum_of_fibonacci(int count){ // A method that calculates the sum of the first Fibonacci numbers
        int first = 0, second = 1, sum = first + second; // Initializing first two Fibonacci numbers and its first sum

        if (count <= 1){ // Since I begin with 0 and 1 first numbers, The sum of the 1 element and all the numbers below has to be 0
            return 0;
        }

        for (int i = 2; i<count; i++){ // For all the numbers higher than 2 this loop runs as many times as how many Fibonacci numbers the user asked for
            int temp = first + second; // A temporal variable to store the sum of the the previous 2 Fibonacci numbers
            first = second; // first variable moves 1 step ahead by getting a value of the second variable that is always a higher Fibonacci number by 1 step
            second = temp; // second variable has passed its value to the first one and can now move 1 step ahead as well
            sum += temp; // each time the sum of the previous 2 Fibonacci numbers are added to the sum variable
        }
        return sum;
    }

}


