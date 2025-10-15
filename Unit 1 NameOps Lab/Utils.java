public class Utils {
    public static void main(String[] args) {
        String name1 = "Cher"; // one name
        String name2 = "Elton John"; // two names
        String name3 = "Elvis Aaron Presley"; // three names

        // testing whoIsAwesome()
        System.out.println("== Testing whoIsAwesome() ==");
        String method = "whoIsAwesome";
        String test1 = NameOps.printMethodCall(method, name1) + NameOps.whoIsAwesome(name1); 
        String test2 = NameOps.printMethodCall(method, name2) + NameOps.whoIsAwesome(name2);
        String test3 = NameOps.printMethodCall(method, name3) + NameOps.whoIsAwesome(name3);
        System.out.println(test1); // Cher is awesome!
        System.out.println(test2); // Elton John is awesome!
        System.out.println(test3); // Elvis Aaron Presley is awesome!
        System.out.println();

        // // testing indexOfFirstSpace()
        // System.out.println("== Testing indexOfFirstSpace() ==");
        // method = "indexOfFirstSpace";
        // test1 = NameOps.printMethodCall(method, name1) + NameOps.indexOfFirstSpace(name1);
        // test2 = NameOps.printMethodCall(method, name2) + NameOps.indexOfFirstSpace(name2);
        // test3 = NameOps.printMethodCall(method, name3) + NameOps.indexOfFirstSpace(name3);
        // System.out.println(test1); // -1
        // System.out.println(test2); // 5
        // System.out.println(test3); // 5
        // System.out.println();

        // // testing indexOfSecondSpace()
        // System.out.println("== Testing indexOfSecondSpace() ==");
        // method = "indexOfSecondSpace";
        // test1 = NameOps.printMethodCall(method, name1) + NameOps.indexOfSecondSpace(name1);
        // test2 = NameOps.printMethodCall(method, name2) + NameOps.indexOfSecondSpace(name2);
        // test3 = NameOps.printMethodCall(method, name3) + NameOps.indexOfSecondSpace(name3);
        // System.out.println(test1); // -1
        // System.out.println(test2); // -1
        // System.out.println(test3); // 11
        // System.out.println();

        // // testing findFirstName()
        // System.out.println("== Testing findFirstName() ==");
        // method = "findFirstName";
        // test1 = NameOps.printMethodCall(method, name1) + NameOps.findFirstName(name1);
        // test2 = NameOps.printMethodCall(method, name2) + NameOps.findFirstName(name2);
        // test3 = NameOps.printMethodCall(method, name3) + NameOps.findFirstName(name3);
        // System.out.println(test1); // Cher
        // System.out.println(test2); // Elton
        // System.out.println(test3); // Elvis
        // System.out.println();

        // // testing findLastName()
        // System.out.println("== Testing findLastName() ==");
        // method = "findLastName";
        // test1 = NameOps.printMethodCall(method, name1) + NameOps.findLastName(name1);
        // test2 = NameOps.printMethodCall(method, name2) + NameOps.findLastName(name2);
        // test3 = NameOps.printMethodCall(method, name3) + NameOps.findLastName(name3);
        // System.out.println(test1); // 
        // System.out.println(test2); // John
        // System.out.println(test3); // Presley
        // System.out.println();

        // // testing findMiddleName()
        // System.out.println("== Testing findMiddleName() ==");
        // method = "findMiddleName";
        // test1 = NameOps.printMethodCall(method, name1) + NameOps.findMiddleName(name1);
        // test2 = NameOps.printMethodCall(method, name2) + NameOps.findMiddleName(name2);
        // test3 = NameOps.printMethodCall(method, name3) + NameOps.findMiddleName(name3);
        // System.out.println(test1); //
        // System.out.println(test2); //
        // System.out.println(test3); // Aaron
        // System.out.println();

        // // testing generateLastFirstMidInitial()
        // System.out.println("== Testing generateLastFirstMidInitial() ==");
        // method = "generateLastFirstMidInitial";
        // test1 = NameOps.printMethodCall(method, name1) 
        //      + NameOps.generateLastFirstMidInitial(name1);
        // test2 = NameOps.printMethodCall(method, name2) 
        //      + NameOps.generateLastFirstMidInitial(name2);
        // test3 = NameOps.printMethodCall(method, name3) 
        //      + NameOps.generateLastFirstMidInitial(name3);
        // System.out.println(test1); // Cher
        // System.out.println(test2); // John, Elton
        // System.out.println(test3); // Presley, Elvis A.
        // System.out.println();
    }

}
