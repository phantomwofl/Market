import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Catalog catalog = new ProductCatalog(); // Dependency inversion principle
        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println("\n" + "" +
                    "Выберите цифру желаемого действия: \n" +
                    "1. Список возможных товаров для покупки \n" +
                    "2. Вывести список товаров по цене \n" +
                    "3. Составить корзину покупок \n" +
                    "4. Оценить товар \n" +
                    "5. Выход");

            int input = Integer.parseInt(scanner.nextLine());

            switch (input) {
                case (1):
                    catalog.printCatalog();
                    break;
                case (2):
                    catalog.filter();
                    catalog.printCatalog();
                    break;
                case (3):
                    Order order = new Order(catalog);       // Single-responsibility principle Каталог отвечает за продукты, а за заказ отвечает отдельный класс

                    while (true) {
                        System.out.println("Выберите номер товара и кол-во через пробел или 0 для завершения заказа");
                        String orderInput = scanner.nextLine();

                        if (orderInput.equals("0")) {
                            order.printOrder();
                            break;
                        }

                        String[] parts = orderInput.split(" ");
                        int productNumber = Integer.parseInt(parts[0]);
                        int productCount = Integer.parseInt(parts[1]);

                        order.buy(productNumber, productCount);
                    }
                    break;
                case (4):
                    catalog.printCatalog();
                    System.out.println("Выберите номер товара и через пробел укажите рейтинг");
                    String ratingInput = scanner.nextLine();
                    String[] parts = ratingInput.split(" ");
                    int productNumber = Integer.parseInt(parts[0]) - 1;
                    int productRating = Integer.parseInt(parts[1]);
                    catalog.setRating(productNumber, productRating);
                    break;
                case (5):
                    return;
            }
        }
    }
}
