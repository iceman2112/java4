package tatun.lesson2;

public class Main {
    public static void testBubble() {
        BigArray bigArray = new BigArray();

        long currentTime = System.currentTimeMillis();
        bigArray.sortBubble();
        double totalSeconds  = (System.currentTimeMillis() - currentTime) / 1000.0;
        System.out.println("Bubble sort: " + totalSeconds + " sec.");
    }

    public static void testInsert() {
        BigArray bigArray = new BigArray();

        long currentTime = System.currentTimeMillis();
        bigArray.sortInsert();
        double totalSeconds  = (System.currentTimeMillis() - currentTime) / 1000.0;
        System.out.println("Insert sort: " + totalSeconds + " sec.");
    }

    public static void testSelect() {
        BigArray bigArray = new BigArray();

        long currentTime = System.currentTimeMillis();
        bigArray.sortSelect();
        double totalSeconds  = (System.currentTimeMillis() - currentTime) / 1000.0;
        System.out.println("Select sort: " + totalSeconds + " sec.");
    }

    public static void main(String[] args) {
        testBubble();
        testInsert();
        testSelect();
    }
}
