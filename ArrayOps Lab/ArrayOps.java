public class ArrayOps {

    public static String printStringArray(String[] array) {
        String stringArray = "";
        for (int i = 0; i < array.length; i++) {
            stringArray += array[i];
            if (i < array.length - 1) {
                stringArray += ", ";
            }
        }
        return "[" + stringArray + "]";
    }

    public static String printIntegerArray(int[] array) {
        String stringArray = "";
        for (int i = 0; i < array.length; i++) {
            stringArray += String.valueOf(array[i]);
            if (i < array.length - 1) {
                stringArray += ", ";
            }
        }
        return "[" + stringArray + "]";
    }

    public static int findMax(int[] array) {
        int curMax = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > curMax) {
                curMax = array[i];
            }
        }
        return curMax;
    }

    public static String findLongestString(String[] array) {
        if (array == null || array.length == 0) {
            return null;
        }
        int curMaxLength = -1;
        String curMaxString = null;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null && array[i].length() > curMaxLength) {
                curMaxLength = array[i].length();
                curMaxString = array[i];
            }
        }
        return curMaxString;
    }

    public static double averageStringLength(String[] array) {
        if (array == null || array.length == 0) {
            return 0.0;
        }
        double totalLength = 0;
        int nullCount = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null) {
                totalLength += array[i].length();
            } else {
                nullCount++;
            }
        }
        if (nullCount == array.length) {
            return 0.0;
        }
        return totalLength / (double) (array.length - nullCount);
    }

    public static int[] countLetterFrequencies(String input) {
        if (input == null) {
            return new int[0];
        }
        int[] frequencies = new int[26];
        for (int i = 0; i < input.length(); i++) {
            char ch = Character.toLowerCase(input.charAt(i));
            if (ch >= 'a' && ch <= 'z') {
                frequencies[ch - 'a']++;
            }
        }
        return frequencies;
    }

    public static int[] removeIntAndScoot(int[] array, int index) {
        for (int i = index; i < array.length - 1; i++) {
            array[i] = array[i + 1];
        }
        array[array.length - 1] = 0;
        return array;
    }

    public static int[] resizeIntArray(int[] array) {
        if (array == null) {
            return new int[0];
        }
        int[] newArray = new int[array.length * 2];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        return newArray;
    }

    public static String[] addNumToStringArray(String[] array) {
        if (array == null) {
            return new String[0];
        }

        for (int i = 0; i < array.length; i++) {
            if (array[i] != null) {
                array[i] = "#" + i + " " + array[i];
            }
            // null elements remain null
        }
        return array;
    }

    public static int[] reverseIntArray(int[] array) {
        if (array == null) {
            return new int[0];
        }
        int[] reversedArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            reversedArray[i] = array[array.length - 1 - i];
        }
        return reversedArray;
    }

}