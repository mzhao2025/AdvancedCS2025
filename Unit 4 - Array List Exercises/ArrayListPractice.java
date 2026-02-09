import java.util.ArrayList;

public class ArrayListPractice {

    public static int countOddLength(ArrayList<String> list) {
        if (list == null) {
            throw new IllegalArgumentException("list cannot be null");
        }
        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).length() % 2 == 1) {
                count++;
            }
        }
        return count;
    }

    public static int countOddLengthForEachLoop(ArrayList<String> list) {
        if (list == null) {
            throw new IllegalArgumentException("list cannot be null");
        }
        int count = 0;
        for (String str : list) {
            if (str.length() % 2 == 1) {
                count++;
            }
        }
        return count;
    }

    public static void removeStrings(ArrayList<String> list, char firstLetter) {
        if (list == null) {
            throw new IllegalArgumentException("list cannot be null");
        }

        for (int i = list.size() - 1; i >= 0; i--) {
            if (list.get(i).charAt(0) == firstLetter) {
                list.remove(i);
            }
        }
    }

    public static void removeStrings2(ArrayList<String> list, char firstLetter) {
        for (int i = list.size() - 1; i >= 0; i--) {
            String str = list.get(i);
            if (str.charAt(0) == firstLetter) {
                list.remove(i);
            }
        }
    }

    public static int numCount(ArrayList<Integer> list, int number) {
        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == number) {
                count++;
            }
        }
        return count;
    }
}
