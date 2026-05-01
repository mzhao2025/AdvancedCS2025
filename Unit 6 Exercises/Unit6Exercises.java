public class Unit6Exercises {

    /**
     * Problem 1 - Factorial: Write a recursive and non-recursive method that returns the factorial
     * of a given number n.
     */
    public static int factorial(int n) {
        if (n == 0) {
            return 1;
        }
        for (int i = n; i > 1; i--) {
            n *= (i - 1);
        }
        return n;
    }

    public static int factorialRecursive(int n) {
        if (n == 0) {
            return 1;
        }
        return n * factorialRecursive(n - 1);
    }

    /**
     * Problem 2 - Fibonacci Sequence: Write a recursive and non-recursive method that returns the
     * nth number in the Fibonacci sequence.
     */
    public static int fibonacci(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }
        int a = 0, b = 1, fibtot = 0;
        for (int i = 2; i <= n; i++) {
            fibtot = a + b;
            a = b;
            b = fibtot;
        }
        return fibtot;
    }

    public static int fibonacciRecursive(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return fibonacciRecursive(n-1) + fibonacciRecursive(n-2);
        }
    }

    /**
     * Problem 3 - Sum of Digits: Write a recursive and non-recursive method that returns the sum of
     * the digits of a given integer.
     */
    public static int sumDigits(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n = n / 10;
        }
        return sum;
    }

    public static int sumDigitsRecursive(int n) {
        if (n < 10) {
            return n;
        } else {
            return (n % 10) + sumDigitsRecursive(n / 10);
        }
    }

    /*
     * Problem 4 - Count X: Write a recursive and non-recursive method that returns the count of
     * occurrences of 'x' in a given string.
     */
    public static int countX(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ('x')) {
                count += 1;
            }
        }
        return count;
    }

    public static int countXRecursive(String str) {
        if (str.length() == 0) {
            return 0;
        }
        if (str.substring(0, 1).equals("x")) {
            return 1 + countXRecursive(str.substring(1));
        } else {
            return countXRecursive(str.substring(1));
        }
    }

    /**
     * Problem 5 - Reverse String: Write a recursive and non-recursive method that returns the
     * reverse of a given string.
     */
    public static String reverseString(String str) {
        String reversed = "";

        for (int i = str.length() - 1; i >= 0; i--) {
            reversed += str.charAt(i);
        }

        return reversed;
    }

    public static String reverseStringRecursive(String str) {
        if (str.length() <= 1) {
            return str;
        } return reverseStringRecursive(str.substring(1)) + str.substring(0, 1);
    }

    /**
     * Problem 6 - Power of a Number: Write a recursive and non-recursive method that calculates and
     * returns the value of base raised to the power of exponent.
     */
    public static int power(int base, int exponent) {
        int result = 1;
        for (int i = 0; i < exponent; i++) {
            result *= base;
        }
        return result;
    }

    public static int powerRecursive(int base, int exponent) {
        if (exponent == 0) {
            return 1;
        } return base * powerRecursive(base, exponent - 1);
    }

    /**
     * Problem 7 - Palindrome Checker: Write a recursive and non-recursive method that checks
     * whether a given string is a palindrome.
     */
    public static boolean isPalindrome(String str) {
        for (int i = 0; i <= (int) str.length()/2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindromeRecursive(String str) {
        if (str.length() <= 1) {
            return true;
        } else if (str.charAt(0) == str.charAt(str.length() - 1)) {
            return isPalindromeRecursive(str.substring(1, str.length() - 1));
        } return false;
    }

    /**
     * Problem 8 - Greatest Common Divisor (GCD): Write a recursive and non-recursive method that
     * finds and returns the greatest common divisor of two numbers.
     */
    public static int gcd(int a, int b) {
        for (int i = Math.min(a, b); i >= 1 ; i--) {
            if ((a % i == 0) && (b % i == 0)) {
                return i;
            }
        }
        return 1;
    }

    public static int gcdRecursive(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcdRecursive(b, a % b);
        }
    }

    /**
     * Problem 9 - Bunny Ears 2: We have bunnies standing in a line, numbered 1, 2, ... The odd
     * bunnies (1, 3, ..) have the normal 2 ears. The even bunnies (2, 4, ..) we'll say have 3 ears,
     * because they each have a raised foot. Recursively return the number of "ears" in the bunny
     * line 1, 2, ... n (without loops or multiplication).
     */

    public static int bunnyEars(int bunnies) {
        int count = 0;
        for (int i = 1; i <= bunnies; i++) {
            if (i % 2 == 0) {
                count += 3;
            } else {
                count += 2;
            }
        }
        return count;
    }

    public static int bunnyEarsRecursive(int bunnies) {
        if (bunnies == 0) {
            return 0;
        } else if (bunnies % 2 == 0) {
            return 3 + bunnyEarsRecursive(bunnies - 1);
        } else {
            return 2 + bunnyEarsRecursive(bunnies - 1);
        }
    }

    /**
     * Problem 10 - Binary Search: Write a recursive and non-recursive method that implements the
     * binary search algorithm to find and return the index of a given element in a sorted array.
     */
    public static int binarySearch(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;
    
        while (low <= high) {
            int curIndex = (low + high) / 2;
    
            if (arr[curIndex] == key) {
                return curIndex;
            } else if (arr[curIndex] < key) {
                low = curIndex + 1;
            } else {
                high = curIndex - 1;
            }
        }
    
        return -1;
    }

    public static int binarySearchRecursiveHelper(int[] arr, int key, int low, int high) {
        int curIndex = (int) (low + high)/2;
        if (low > high) {
            return -1;
        } else if (arr[curIndex] == key) {
            return curIndex;
        } else if (arr[curIndex] < key) {
            return binarySearchRecursiveHelper(arr, key, curIndex+1, high);
        } else {
            return binarySearchRecursiveHelper(arr, key, low, curIndex - 1);
        }
    }

     // DO NOT EDIT! Work on the helper version above this method. This method is to be used for testing purposes only.
    public static int binarySearchRecursive(int[] arr, int key) {
        return binarySearchRecursiveHelper(arr, key, 0, arr.length-1); // Element not found
    }


}
