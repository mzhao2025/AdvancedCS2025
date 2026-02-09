public class SkyViewTester {
    public static void main(String[] args) {
        double[] scannedData = {
                1.0, 2.0, 3.0,
                4.0, 5.0, 6.0,
                7.0, 8.0, 9.0
        };

        SkyView skyView1 = new SkyView(3, 3, scannedData);
        SkyView skyView2 = new SkyView(3, 3, scannedData);

        System.out.println("SkyView 1:");
        System.out.println(skyView1);

        System.out.println("SkyView 2:");
        System.out.println(skyView2);

        System.out.println("Are the two SkyViews equal? " + skyView1.equals(skyView2));

        double average = skyView1.getAverage(0, 1, 0, 1);
        System.out.println("Average of sub-region (0,0) to (1,1): " + average);
    }
}
