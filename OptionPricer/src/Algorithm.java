/**
 * @author Sky
 * An abstract class for algorithms to calculate the price of financial products.
 */
public abstract class Algorithm {
    /**
     * Result of calculation.
     */
    double[] results;
    /**
     * Constant. The number of dots used to construct the volatility smile.
     */
    public final int NUMOFDOTS=11;

    /**
     * An abstract method to calculate the price of a Product.
     * @param p the Product object to be calculated.
     * @return the result.
     */
    abstract public double[] computeOption(Product p);
    /**
     * An abstract method to calculate the price of a Product.
     * @param p the Product object to be calculated.
     * @return the result.
     */
    abstract public double crunchPut(Product p);

    /**
     * An abstract method to calculate the price of a Product.
     * @param p the Product object to be calculated.
     * @return the result.
     */
    abstract public double crunchCall(Product p);
}
