public class Order {

    private int[] amount;
    private Catalog catalog;
    private int sumProducts = 0;

    Order (Catalog catalog) {
        this.catalog = catalog;
        this.amount = new int[catalog.getProducts().length];
    }

    public void buy(int product, int count) {

        int productCount = amount[product - 1];
        productCount += count;
        amount[product - 1] = productCount;
        sumProducts = sumProducts + catalog.getPrices()[product - 1] * productCount;
    }

    public void printOrder() {
        System.out.println("Ваша корзина:");
        System.out.printf("%32s%32s%32s%32s", "Наименование товара",   "Количество",  "Цена/за.ед",  "Общая стоимость");
        for (int i = 0; i < catalog.getProducts().length; i++) {
            if (amount[i] != 0) {
                System.out.println();
                System.out.format("%32s%32d%32d%32d", catalog.getProducts()[i], amount[i], catalog.getPrices()[i], (catalog.getPrices()[i] * amount[i]));
            }
        }

        System.out.println("\n" + "\n" + "\n");
        System.out.printf("%96s", "Итого ");
        System.out.printf("%32s", sumProducts);

    }
}
