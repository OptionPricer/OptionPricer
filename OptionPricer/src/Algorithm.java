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
     * Constant. The interval of change in volatility in the graph.
     */
    public final double VOLINTERVAL =0.1;
    /**
     * An abstract method to calculate the price of an Option.
     * @param o the Option object to be calculated.
     * @return the result.
     */
    abstract public double[] computeOption(Option o);
    /**
     * An abstract method to calculate the price of a put option.
     * @param o the Option object to be calculated.
     * @return the result.
     */
    abstract public double crunchPut(Option o);

    /**
     * An abstract method to calculate the price of a call option.
     * @param o the Option object to be calculated.
     * @return the result.
     */
    abstract public double crunchCall(Option o);

}
