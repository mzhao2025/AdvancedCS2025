import java.util.ArrayList;

public class Unit4Exercises {

    // Method 1: matchingEndSequences
    public static boolean matchingEndSequences(int[] nums, int n) {
        // Compare the first n elements with the last n elements
        for (int i = 0; i < n; i++) {
            if (nums[i] != nums[nums.length - n + i]) {
                return false;
            }
        }
        return true;
    }

    // Method 2: hasThreeConsecutive
    public static boolean hasThreeConsecutive(int[] nums) {
        // Check for three consecutive numbers
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] % 2 == nums[i + 1] % 2 && nums[i] % 2 == nums[i + 2] % 2) {
                return true;
            }
        }
        return false;
    }

    // Method 3: generateNumberSequence
    public static int[] generateNumberSequence(int start, int end) {
        int[] intArr = new int[end - start];
        // to-do: implement the method
        for (int i = start; i < end; i++) {
            intArr[i - start] = i;
        }
        return intArr;
    }

    // Method 4: fizzBuzz
    public static String[] fizzBuzz(int start, int end) {
        // to-do: implement the method
        String[] result = new String[end - start];
        for (int i = start; i < end; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                result[i - start] = "FizzBuzz";
            } else if (i % 3 == 0) {
                result[i - start] = "Fizz";
            } else if (i % 5 == 0) {
                result[i - start] = "Buzz";
            } else {
                result[i - start] = String.valueOf(i);
            }
        }
        return result;
    }

    // Method 5: moveEvenBeforeOdd
    public static int[] moveEvenBeforeOdd(int[] nums) {
        int[] result = new int[nums.length];
        int idx = 0;

        for (int x : nums) {
            if (x % 2 == 0) {
                result[idx++] = x;
            }
        }

        for (int x : nums) {
            if (x % 2 != 0) {
                result[idx++] = x;
            }
        }

        return result;
    }

    // ArrayList Methods

    // Method 1: noNegatives
    public static ArrayList<Integer> noNegatives(ArrayList<Integer> nums) {
        // to-do: implement the method
        return new ArrayList<>();

    }

    // Method 2: excludeTeenNumbers
    public static ArrayList<Integer> excludeTeenNumbers(ArrayList<Integer> nums) {
        // to-do: implement the method
        return new ArrayList<>();
    }

    // Method 3: appendY
    public static ArrayList<String> appendY(ArrayList<String> strs) {
        // to-do: implement the method
        return new ArrayList<>();
    }

    // Method 4: squarePlus10
    public static ArrayList<Integer> squarePlus10(ArrayList<Integer> nums) {
        // to-do: implement the method
        return new ArrayList<>();
    }

}
