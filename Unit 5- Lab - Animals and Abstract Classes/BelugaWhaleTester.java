public class BelugaWhaleTester {
    public static void main(String[] args) {
        BelugaWhale beluga = new BelugaWhale("Bella", 10, false, "Arctic Ocean", "white",
                new String[] { "fish", "squid", "crustaceans" });
        System.out.println(beluga.toString());
        beluga.swim();
        beluga.eat();
        beluga.dive();
        beluga.communicate();
        beluga.migrate();
    }

}
