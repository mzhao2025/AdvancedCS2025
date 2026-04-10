public class Unit6ExercisesTester {

    public static void main(String[] args) {
        // Test Problem 1: Factorial
        testFactorial();

        // Test Problem 2: Fibonacci Sequence
        testFibonacci();

        // Test Problem 3: Sum of Digits
        testSumDigits();

        // Test Problem 4: Count X
        testCountX();

        // Test Problem 5: Reverse String
        testReverseString();

        // Test Problem 6: Power of a Number
        testPower();

        // Test Problem 7: Palindrome Checker
        testIsPalindrome();

        // Test Problem 8: Greatest Common Divisor (GCD)
        testGCD();

        // Test Problem 9: Bunny Ears
        testBunnyEars();

        // Test Problem 10: Binary Search
        testBinarySearch();
    }

    private static void testFactorial() {
        System.out.println("Testing Factorial...");
        // Test cases for non-recursive method
        System.out.println("Factorial (Non-Recursive) of 5: " + Unit6Exercises.factorial(5)); // Expected: 120
        System.out.println("Factorial (Non-Recursive) of 0: " + Unit6Exercises.factorial(0)); // Expected: 1
        System.out.println("Factorial (Non-Recursive) of 3: " + Unit6Exercises.factorial(3)); // Expected: 6

        // Test cases for recursive method
        System.out.println("Factorial (Recursive) of 5: " + Unit6Exercises.factorialRecursive(5)); // Expected: 120
        System.out.println("Factorial (Recursive) of 0: " + Unit6Exercises.factorialRecursive(0)); // Expected: 1
        System.out.println("Factorial (Recursive) of 3: " + Unit6Exercises.factorialRecursive(3)); // Expected: 6
    }

    private static void testFibonacci() {
        System.out.println("Testing Fibonacci...");
        // Non-recursive tests
        System.out.println("Fibonacci (Non-Recursive) of 5: " + Unit6Exercises.fibonacci(5)); // Expected: 5
        System.out.println("Fibonacci (Non-Recursive) of 0: " + Unit6Exercises.fibonacci(0)); // Expected: 0
        System.out.println("Fibonacci (Non-Recursive) of 10: " + Unit6Exercises.fibonacci(10)); // Expected: 55
    
        // Recursive tests
        System.out.println("Fibonacci (Recursive) of 5: " + Unit6Exercises.fibonacciRecursive(5)); // Expected: 5
        System.out.println("Fibonacci (Recursive) of 0: " + Unit6Exercises.fibonacciRecursive(0)); // Expected: 0
        System.out.println("Fibonacci (Recursive) of 10: " + Unit6Exercises.fibonacciRecursive(10)); // Expected: 55
    }
    
    private static void testSumDigits() {
        System.out.println("Testing Sum of Digits...");
        // Non-recursive tests
        System.out.println("Sum of Digits (Non-Recursive) of 123: " + Unit6Exercises.sumDigits(123)); // Expected: 6
        System.out.println("Sum of Digits (Non-Recursive) of 0: " + Unit6Exercises.sumDigits(0)); // Expected: 0
        System.out.println("Sum of Digits (Non-Recursive) of 456: " + Unit6Exercises.sumDigits(456)); // Expected: 15
    
        // Recursive tests
        System.out.println("Sum of Digits (Recursive) of 123: " + Unit6Exercises.sumDigitsRecursive(123)); // Expected: 6
        System.out.println("Sum of Digits (Recursive) of 0: " + Unit6Exercises.sumDigitsRecursive(0)); // Expected: 0
        System.out.println("Sum of Digits (Recursive) of 456: " + Unit6Exercises.sumDigitsRecursive(456)); // Expected: 15
    }
    
    private static void testCountX() {
        System.out.println("Testing Count X...");
        // Non-recursive tests
        System.out.println("Count X (Non-Recursive) in 'axbxcxd': " + Unit6Exercises.countX("axbxcxd")); // Expected: 3
        System.out.println("Count X (Non-Recursive) in '': " + Unit6Exercises.countX("")); // Expected: 0
        System.out.println("Count X (Non-Recursive) in 'xxxxx': " + Unit6Exercises.countX("xxxxx")); // Expected: 5
    
        // Recursive tests
        System.out.println("Count X (Recursive) in 'axbxcxd': " + Unit6Exercises.countXRecursive("axbxcxd")); // Expected: 3
        System.out.println("Count X (Recursive) in '': " + Unit6Exercises.countXRecursive("")); // Expected: 0
        System.out.println("Count X (Recursive) in 'xxxxx': " + Unit6Exercises.countXRecursive("xxxxx")); // Expected: 5
    }
    
    private static void testReverseString() {
        System.out.println("Testing Reverse String...");
        // Non-recursive tests
        System.out.println("Reverse String (Non-Recursive) of 'hello': " + Unit6Exercises.reverseString("hello")); // Expected: "olleh"
        System.out.println("Reverse String (Non-Recursive) of '': " + Unit6Exercises.reverseString("")); // Expected: ""
        System.out.println("Reverse String (Non-Recursive) of 'abc': " + Unit6Exercises.reverseString("abc")); // Expected: "cba"
    
        // Recursive tests
        System.out.println("Reverse String (Recursive) of 'hello': " + Unit6Exercises.reverseStringRecursive("hello")); // Expected: "olleh"
        System.out.println("Reverse String (Recursive) of '': " + Unit6Exercises.reverseStringRecursive("")); // Expected: ""
        System.out.println("Reverse String (Recursive) of 'abc': " + Unit6Exercises.reverseStringRecursive("abc")); // Expected: "cba"
    }
    
    private static void testPower() {
        System.out.println("Testing Power...");
        // Non-recursive tests
        System.out.println("Power (Non-Recursive) of 2^3: " + Unit6Exercises.power(2, 3)); // Expected: 8
        System.out.println("Power (Non-Recursive) of 0^5: " + Unit6Exercises.power(0, 5)); // Expected: 0
        System.out.println("Power (Non-Recursive) of 5^0: " + Unit6Exercises.power(5, 0)); // Expected: 1

        // Recursive tests
        System.out.println("Power (Recursive) of 2^3: " + Unit6Exercises.powerRecursive(2, 3)); // Expected: 8
        System.out.println("Power (Recursive) of 0^5: " + Unit6Exercises.powerRecursive(0, 5)); // Expected: 0
        System.out.println("Power (Recursive) of 5^0: " + Unit6Exercises.powerRecursive(5, 0)); // Expected: 1
    }    

    private static void testIsPalindrome() {
        System.out.println("Testing Palindrome Checker...");
        // Non-recursive tests
        System.out.println("Is 'racecar' a palindrome? " + Unit6Exercises.isPalindrome("racecar")); // Expected: true
        System.out.println("Is 'hello' a palindrome? " + Unit6Exercises.isPalindrome("hello")); // Expected: false
        System.out.println("Is 'a' a palindrome? " + Unit6Exercises.isPalindrome("a")); // Expected: true

        // Recursive tests
        System.out.println("Is 'racecar' a palindrome? " + Unit6Exercises.isPalindromeRecursive("racecar")); // Expected: true
        System.out.println("Is 'hello' a palindrome? " + Unit6Exercises.isPalindromeRecursive("hello")); // Expected: false
        System.out.println("Is 'a' a palindrome? " + Unit6Exercises.isPalindromeRecursive("a")); // Expected: true
    }

    private static void testGCD() {
        System.out.println("Testing Greatest Common Divisor (GCD)...");
        // Non-recursive tests
        System.out.println("GCD of 12 and 8: " + Unit6Exercises.gcd(12, 8)); // Expected: 4
        System.out.println("GCD of 0 and 5: " + Unit6Exercises.gcd(0, 5)); // Expected: 5
        System.out.println("GCD of 5 and 0: " + Unit6Exercises.gcd(5, 0)); // Expected: 5

        // Recursive tests
        System.out.println("GCD of 12 and 8: " + Unit6Exercises.gcdRecursive(12, 8)); // Expected: 4
        System.out.println("GCD of 0 and 5: " + Unit6Exercises.gcdRecursive(0, 5)); // Expected: 5
        System.out.println("GCD of 5 and 0: " + Unit6Exercises.gcdRecursive(5, 0)); // Expected: 5
    }

    private static void testBunnyEars() {
        System.out.println("Testing Bunny Ears...");
        // Non-recursive tests
        System.out.println("Bunny Ears (Non-Recursive) of 5: " + Unit6Exercises.bunnyEars(5)); // Expected: 12
        System.out.println("Bunny Ears (Non-Recursive) of 0: " + Unit6Exercises.bunnyEars(0)); // Expected: 0
        System.out.println("Bunny Ears (Non-Recursive) of 3: " + Unit6Exercises.bunnyEars(3)); // Expected: 7

        // Recursive tests
        System.out.println("Bunny Ears (Recursive) of 5: " + Unit6Exercises.bunnyEarsRecursive(5)); // Expected: 12
        System.out.println("Bunny Ears (Recursive) of 0: " + Unit6Exercises.bunnyEarsRecursive(0)); // Expected: 0
        System.out.println("Bunny Ears (Recursive) of 3: " + Unit6Exercises.bunnyEarsRecursive(3)); // Expected: 7
    }

    private static void testBinarySearch() {
        System.out.println("Testing Binary Search...");
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        // Non-recursive tests
        System.out.println("Binary Search (Non-Recursive) for 5: " + Unit6Exercises.binarySearch(arr, 5)); // Expected: 4
        System.out.println("Binary Search (Non-Recursive) for 10: " + Unit6Exercises.binarySearch(arr, 10)); // Expected: -1
        System.out.println("Binary Search (Non-Recursive) for 1: " + Unit6Exercises.binarySearch(arr, 1)); // Expected: 0

        // Recursive tests
        System.out.println("Binary Search (Recursive) for 5: " + Unit6Exercises.binarySearchRecursive(arr, 5)); // Expected: 4
        System.out.println("Binary Search (Recursive) for 10: " + Unit6Exercises.binarySearchRecursive(arr, 10)); // Expected: -1
        System.out.println("Binary Search (Recursive) for 1: " + Unit6Exercises.binarySearchRecursive(arr, 1)); // Expected: 0
    }
}
