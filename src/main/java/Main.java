import java.util.Hashtable;


public class Main {
    static DHHashTable<String, String> table = new DHHashTable();

    static void test(String k, String v) {
        table.put(k, v);
        System.out.println(table);
    }

    public static void main(String[] args) {
        System.out.println("Table:");
        test("00", "zero");
        test("01", "one");
        test("02", "two");
        test("03", "three");
        test("04", "four");
        test("05", "five");
        test("06", "six");
        test("07", "seven");
        test("08", "eight");
        test("09", "nine");
        test("10", "ten");
        test("11", "eleven");
        test("12", "twelve");
        test("13", "thirteen");
        test("14", "fourteen");
        test("15", "fifteen");
        test("16", "sixteen");
        test("17", "seventeen");

        System.out.println("--------------------");
        System.out.println("Number of pairs in the table:");
        System.out.println(table.size());

        System.out.println("--------------------");
        System.out.println("List of all keys:");
        System.out.println(table.keySet());

        System.out.println("---------------------");
        System.out.println("List of all values:");
        System.out.println(table.values());

        System.out.println("---------------------");
        System.out.println("Adding a pair:");
        String S = table.put("20", "twenty");
        String K = table.put("09", "nine");
        String A = table.put("02", "two");
        System.out.println(table);
        System.out.println("Overwriting values:");
        System.out.println(S);
        System.out.println(K);
        System.out.println(A);

        System.out.println("---------------------");
        System.out.println("Removing pairs:");
        table.remove("17");
        table.remove("02");
        table.remove("00");
        System.out.println(table);


        System.out.println("---------------------");
        System.out.println("Finding a value by key:");
        System.out.println(table.get("05"));
        System.out.println(table.get("11"));
        System.out.println(table.get("28"));

        System.out.println("---------------------");
        System.out.println("Comparing tables:");
        Hashtable<String, String> map = new Hashtable<>();
        map.put("00", "zero");
        map.put("22", "twenty two");
        System.out.println(table);
        System.out.println(map);
        System.out.println(map.equals(table));

        System.out.println("---------------------");
        System.out.println("Removing all pairs from a table:");
        table.clear();
        System.out.println(table.entrySet());

    }
}