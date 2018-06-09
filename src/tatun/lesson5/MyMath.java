package tatun.lesson5;

public class MyMath {
    public static final double MAX_WEIGHT = 4.0;

    private static class Item {

        private double cost;
        private double weight;

        public Item(double cost, double weight) {
            this.cost = cost;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "Item{" +
                    "cost=" + cost +
                    ", weight=" + weight +
                    '}';
        }
    }

    public static Item[] generateItems() {
        return new Item[]{
                new Item(200, 2),
                new Item(500, 5),
                new Item(200, 2),
        };
    }

    public static Item busketTask(final Item[] currentItems, final Item totalValue) {
        if (currentItems.length == 1) {
            Item total = new Item(totalValue.cost + currentItems[0].cost,
                    currentItems[0].weight + totalValue.weight);
            return (total.weight <= MAX_WEIGHT) ? total : totalValue;
        }

        Item total = new Item(0, 0);
        for (int i = 0; i < currentItems.length; i++) {
            Item[] left = new Item[i];
            System.arraycopy(currentItems, 0, left, 0, left.length);
            Item[] currentItemsSmall = new Item[currentItems.length - 1];
            System.arraycopy(currentItems, i + 1, currentItemsSmall, 0, currentItemsSmall.length - i);
            System.arraycopy(left, 0, currentItemsSmall, 0, left.length);

            Item currentTotal = busketTask(currentItemsSmall, totalValue);
            if (currentTotal.weight + currentItems[i].weight <= MAX_WEIGHT) {
                currentTotal.weight += currentItems[i].weight;
                currentTotal.cost += currentItems[i].cost;
            }

            if (total.cost > currentTotal.cost) {
                total = currentTotal;
            }
        }
        return total;
    }

    public static double pow(int x, int y) {
        switch (y) {
            case 1:
                return x;
            case 0:
                return 1;
        }
        return (y > 0) ? x * pow(x, y - 1) : pow(x, y + 1) / (double) x;
    }

    public static void main(String[] args) {
        System.out.println("2**3 = " + pow(2, -3));
        System.out.println(
                busketTask(generateItems(), new Item(0, 0)
                )
        );
    }
}