/**
 * @author Sky
 * A class for Option.
 */
public class Option extends Product {
    private OptionRight right;
    private OptionStyle style;

    public OptionRight getRight() {
        return right;
    }

    public void setRight(OptionRight right) {
        this.right = right;
    }

    public OptionStyle getStyle() {
        return style;
    }

    public void setStyle(OptionStyle style) {
        this.style = style;
    }

    /**
     * Default constructor.
     */
    public Option(){}

    /**
     * Constructor.
     * @param right The option right.
     * @param style The option style.
     */
    public Option(OptionRight right, OptionStyle style) {
        super();
        this.right = right;
        this.style = style;
    }

    /**
     * Constructor.
     * @param strikeP strike price.
     * @param sNought current stock price.
     * @param riskFreeRate the risk-free interest rate.
     * @param volatility volatility of the stock.
     * @param term the term of option in MONTHS.
     * @param right the option right.
     * @param style the option style.
     */
    public Option(double strikeP, double sNought, double riskFreeRate, double volatility, double term, OptionRight right, OptionStyle style) {
        super(strikeP, sNought, riskFreeRate, volatility, term);
        this.right = right;
        this.style = style;
    }
}