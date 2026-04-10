import java.util.ArrayList;

public class BubbleSort {
    private ArrayList<Integer> arr;

    public BubbleSort(ArrayList<Integer> arr) {
        this.arr = arr;
    }

    public void sort() {
        for (int pass = 0; pass < arr.size() - 1; pass++) {
            boolean swapped = false;
    
            for (int i = 0; i < arr.size() - 1 - pass; i++) {
                if (arr.get(i) > arr.get(i + 1)) {
    
                    int temp = arr.get(i);
                    arr.set(i, arr.get(i + 1));
                    arr.set(i + 1, temp);
    
                    swapped = true;
                    print(i);
                }
    
            }
    
            if (!swapped) {
                break;
            }
        }
    }

    public void print() {
        print(-1);
    }
    
    public void print(int swappedIndex) {
        for (int i = 0; i < arr.size(); i++) {
            if ((i == swappedIndex) || (i == swappedIndex + 1)) {
                System.out.print("(" + arr.get(i) + ") ");
            } else {
                System.out.print(arr.get(i) + " ");
            }
    
        }
        System.out.println();
    }
}