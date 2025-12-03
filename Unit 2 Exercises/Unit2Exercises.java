public class Unit2Exercises {
    public static String alarmClock(int day, boolean vacation) {
        if (vacation) {
            if (day == 0 || day == 6) {
                return "off";
            } 
            return "10:00";
        } else {
            if (day == 0 || day == 6) {
                return "10:00";
            } 
            return "7:00";
        }
    }

    public static boolean love6(int a, int b) {
        if ((a == 6) || (b == 6) || (a + b == 6) || (Math.abs(a - b) == 6)) {
            return true;
        } 
        return false;
    }

    public static int redTicket(int a, int b, int c) {
        if ((a == 2) && (b == 2) && (c == 2)) {
            return 10;
        } else if ((a == b) && (b == c)) {
            return 5;
        } else if ((b != a) && (c != a)) {
            return 1;
        } else {
            return 0;
        }
    }

    public static String fizzString(String str) {
        if (str.startsWith("f") && str.endsWith("b")) {
            return "FizzBuzz";
        } else if (str.endsWith("b")) {
            return "Buzz";
        } else if (str.startsWith("f")) {
            return "Fizz";
        } else {
            return str;
        }
    }

    public static String doubleChar(String str) {
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);
            result += currentChar;
            result += currentChar;
        }
        return result;
    }

    public static int countHi(String str) {
        if (str.length() < 2) {
            return 0;
        }
        if (str.substring(0, 2).equals("hi")) {
            return 1 + countHi(str.substring(2));
        }
        return countHi(str.substring(1));
    }

    public static boolean catDog(String str) {
        int cat = 0;
        int dog = 0;
        for (int i = 0; i < str.length() - 2; i++) {
            String sub = str.substring(i, i + 3);
            if (sub.equals("cat")) {
                cat++;
            }
            if (sub.equals("dog")) {
                dog++;
            }
        }
        return cat == dog;
    }

    public static String mixString(String a, String b) {
        int minLen = Math.min(a.length(), b.length());
        String result = "";
        for (int i = 0; i < minLen; i++) {
            result += a.charAt(i);
            result += b.charAt(i);
        }
        result += a.substring(minLen);
        result += b.substring(minLen);
        return result;
    }

    public static String repeatEnd(String str, int n) {
        String result = "";
        String end = str.substring(str.length() - n);
        for (int i = 0; i < n; i++) {
            result += end;
        }
        return result;
    }

    public static boolean endOther(String a, String b) {
        String alower = a.toLowerCase();
        String blower = b.toLowerCase();
        if (alower.endsWith(blower) || blower.endsWith(alower)) {
            return true;
        }
        return false;
    }

    public static int countCode(String str) {
        int count = 0;
        for (int i = 0; i < str.length() - 3; i++) {
            if (str.charAt(i) == 'c' && str.charAt(i + 1) == 'o' && str.charAt(i + 3) == 'e') {
                count++;
            }
        }
        return count;
    }

    public static int countEvens(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                count += 1;
            }
        }
        return count;
    }

    public static int bigDiff(int[] nums) {
        int curMax = nums[0];
        int curMin = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > curMax) {
                curMax = nums[i];
            } else if (nums[i] < curMin) {
                curMin = nums[i];
            }
        }
        return curMax - curMin;
    }

    public static int sum13(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 13) {
                if (i + 1 < nums.length) {
                    nums[i + 1] = 0;
                }
                nums[i] = 0;
            }
            sum += nums[i];
        }
        return sum;
    }

    public static int[] fizzArray(int n) {
        int[] newArray = new int[n];
        for (int i = 0; i < n; i++) {
            newArray[i] = i;
        }
        return newArray;
    }

    public static boolean haveThree(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 3) {
                count++;
                if (i < nums.length - 1 && nums[i + 1] == 3) {
                    return false;
                }
            }
        }
        return count == 3;
    }

    public static String[] fizzArray2(int n) {
        if (n == 0) {
            return new String[0];
        }
        String[] newArray = new String[n];
        for (int i = 0; i < n; i++) {
            newArray[i] = String.valueOf(i);
        }
        return newArray;
    }

    public static int[] zeroFront(int[] nums) {
        int[] result = new int[nums.length];
        int index = 0;
        for (int n : nums) {
            if (n == 0) {
                result[index++] = 0;
            }
        }
        for (int n : nums) {
            if (n != 0) {
                result[index++] = n;
            }
        }
        return result;
    }

    public static String[] wordsWithout(String[] words, String target) {
        int targetCount = 0;
        for (String word : words) {
            if (word.equals(target)) {
                targetCount++;
            }
        }
        String[] result = new String[words.length - targetCount];
        int index = 0;
        for (String word : words) {
            if (!word.equals(target)) {
                result[index++] = word;
            }
        }
        return result;
    }

    public static int scoresAverage(int[] scores) {
        int mid = scores.length / 2;

        int firstAvg = calculateAverage(scores, 0, mid - 1);
        int secondAvg = calculateAverage(scores, mid, scores.length - 1);

        return Math.max(firstAvg, secondAvg);
    }

    public static int calculateAverage(int[] scores, int start, int end) {
        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum += scores[i];
        }
        return sum / (end - start + 1);
    }

    public static boolean scoresIncreasing(int[] scores) {
        for (int i = 0; i < scores.length - 1; i++) {
            if (scores[i] > scores[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public static int scoresSpecial(int[] a, int[] b) {
        return specialCalculator(a) + specialCalculator(b);
    }

    public static int specialCalculator(int[] arr) {
        int maxSpecial = 0;
        for (int num : arr) {
            if (num % 10 == 0 && num > maxSpecial) {
                maxSpecial = num;
            }
        }
        return maxSpecial;
    }

    public static String firstTwo(String str) {
        if (str.length() == 0) {
            return "**";
        } else if (str.length() == 1) {
            return str + "*";
        } else {
            return str.substring(0, 2);
        }
    }

    public static double divide(int a, int b) {
        if (Math.min(a, b) == 0) {
            return 0.0;
        }
        return (double) Math.max(a, b) / Math.min(a, b); 
    }
}