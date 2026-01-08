public class DebugDemo {
    public static void main(String[] args) {
        System.out.println("Starting Debugger Demo...");
        try {
            runParserScenario();
        } catch (Exception e) {
            System.out.println("Parser scenario blew up: " + e.getMessage());
        }

        try {
            runAverageScenario();
        } catch (Exception e) {
            System.out.println("Average scenario blew up: " + e.getMessage());
        }

        try {
            runNullPointerScenario();
        } catch (Exception e) {
            System.out.println("Null pointer scenario blew up: " + e.getMessage());
        }

        try {
            runNullArrayElementScenario();
        } catch (Exception e) {
            System.out.println("Null array element scenario blew up: " + e.getMessage());
        }

        try {
            runDivideByZeroScenario();
        } catch (Exception e) {
            System.out.println("Divide-by-zero scenario blew up: " + e.getMessage());
        }

        runLogicBugScenario();

        System.out.println("Debugger Demo finished.");
    }

    private static void runParserScenario() {
        System.out.println("\n=== Scenario 1: Number parsing ===");
        String raw = "10,5,-2,30";
        System.out.println("Raw input: \"" + raw + "\"");
        int[] parsed = parseNumbers(raw);
        System.out.println("Parsed numbers: " + formatArray(parsed));
    }

    private static void runAverageScenario() {
        System.out.println("\n=== Scenario 2: Off-by-one average ===");
        int[] scores = { 90, 70, 80, 100 };
        double average = average(scores);
        System.out.println("Average score: " + average);
    }

    private static void runNullPointerScenario() {
        System.out.println("\n=== Scenario 3: Missing data ===");
        String studentName = "Alex";
        String city = "LA";
        System.out.println("Student: " + studentName);
        city = getUppercaseCity(city);
        System.out.println("City in uppercase: " + city);
    }

    private static void runNullArrayElementScenario() {
        System.out.println("\n=== Scenario 4: Null element in array ===");
        String[] names = { "Ana", "Lee" };
        int indexToUse = 1;
        int length = nameLength(names, indexToUse);
        System.out.println("Length of name: " + length);
    }

    private static void runDivideByZeroScenario() {
        System.out.println("\n=== Scenario 5: Divide by zero (wrong counter) ===");
        String[] names = { "Ana", "Bo", "Li" };
        int totalLength = 0;
        int count = 0;
        for (int i = 0; i < names.length; i++) {
            int len = names[i].length();
            totalLength += len;
            count++;
        }
        int averageLength = totalLength / count;
        System.out.println("Average name length: " + averageLength);
    }

    private static void runLogicBugScenario() {
        System.out.println("\n=== Scenario 6: Wrong Fibonacci result (no recursion) ===");
        int n = 7;
        int result = fib(n);
        System.out.println("fib(" + n + ") reported: " + result);
        System.out.println("Expected: 13");
    }

    public static int[] parseNumbers(String csv) {
        String[] parts = csv.split(",");
        int[] result = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            String part = parts[i];
            int value = Integer.parseInt(part);
            result[i] = value;
        }
        return result;
    }

    public static String formatArray(int[] data) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < data.length; i++) {
            sb.append(data[i]);
            if (i < data.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public static double average(int[] data) {
        if (data.length == 0) {
            return 0.0;
        }
        int sum = 0;
        for (int i = 0; i < data.length; i++) {
            sum += data[i];
        }
        return sum / (double) data.length;
    }

    public static String getUppercaseCity(String city) {
        return city.toUpperCase();
    }

    public static int nameLength(String[] names, int index) {
        return names[index].length();
    }

    // Calculates the nth Fibonacci number, 0, 1, 1, 2, 3, 5, 8, 13, 21, 34...
    public static int fib(int n) {
        int a = 0;
        int b = 1;
        if (n == 0) {
            return a;
        }
        if (n == 1) {
            return b;
        }
        for (int i = 2; i <= n; i++) {
            int next = a + b;
            a = b;
            b = next;
        }
        return b;
    }
}
