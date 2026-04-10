import java.util.ArrayList;

public class BubbleTester {
    public static void main(String[] args) {

        ArrayList<Integer> arr = new ArrayList<>();

        arr.add(5);
        arr.add(2);
        arr.add(9);
        arr.add(3);
        arr.add(2);
        arr.add(11);
        arr.add(4);
        arr.add(7);
        arr.add(8);
        arr.add(10);

        BubbleSort bubbleSort = new BubbleSort(arr);

        bubbleSort.sort();

    }
}