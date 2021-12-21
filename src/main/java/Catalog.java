public abstract class Catalog implements Filter, Evaluation{
    private String[] products;
    private int[] prices;
    private double [] ratings;

    public abstract void printCatalog();
    public abstract String[] getProducts();
    public abstract int[] getPrices();
}
