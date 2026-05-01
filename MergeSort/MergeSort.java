public class MergeSort {
    private int[] a;
    private int[] b;
    
    public static int[] combineSortedArray(int[] a, int[] b) {
        int indexA = 0;
        int indexB = 0;
        int[] c = new int[a.length + b.length];

        for (int indexC = 0; indexC < c.length; indexC++) {
            if (indexA >= a.length) {
                c[indexC] = b[indexB];
                indexB++;
            } else if (indexB >= b.length) {
                c[indexC] = a[indexA];
                indexA++;
            } else if (a[indexA] <= b[indexB]) {
                c[indexC] = a[indexA];
                indexA++;
            } else {
                c[indexC] = b[indexB];
                indexB++;
            }
        }

        return c;
    }
}