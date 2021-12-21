public class ProductCatalog extends Catalog {  // Liskov substitution principle

    private final int MAX_RATING = 5;

    private String [] products = {"Хлеб", "Молоко", "Гречневая крупа", "Яйца" , "Соль", "Сахар", "Масло", "Сыр"};
    private int [] prices = {40, 90, 50, 85, 30, 60, 170, 280};
    private double [] ratings = new double[products.length];    // Избегание магического числа
    private int [] ratingsCounter = new int[ratings.length];


    @Override
    public void printCatalog() {                               // Правило DRY (Don’t Repeat Yourself)
        for (int i = 0; i < products.length; i++) {
            System.out.println((i + 1) + ". " + products[i] + " " + prices[i] + " руб/шт");
        }
        System.out.println("");
    }

    @Override
    public String[] getProducts() {
        return products;
    }

    @Override
    public int[] getPrices() {
        return prices;
    }

    @Override
    public void setRating(int product, int rating) {
        if (product >= products.length) {
            System.out.println("Такого товара нет!");
        } else if (rating > MAX_RATING) {
            System.out.println("Максимальная оценка товара " + MAX_RATING);
        } else {
            ratingsCounter[product] += 1;
            ratings[product] = (ratings[product] + rating) / (ratingsCounter[product] + 1);
        }
    }

    @Override
    public void filter() {

        for (int i = 0; i < prices.length; i++) {
            for (int j = i +1; j < prices.length; j++) {
                if (prices[i] > prices[j]) {
                    int tmp = prices[i];
                    String tmpString = products[i];
                    prices[i] = prices[j];
                    prices[j] = tmp;
                    products[i] = products[j];
                    products[j] = tmpString;
                }
            }
        }
    }
}
