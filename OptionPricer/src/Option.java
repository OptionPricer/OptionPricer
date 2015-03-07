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

    public Option(){}

    public Option(OptionRight right, OptionStyle style) {
        super();
        this.right = right;
        this.style = style;
    }

    public Option(double strikeP, double sNought, double riskFreeRate, double volatility, double term, OptionRight right, OptionStyle style) {
        super(strikeP, sNought, riskFreeRate, volatility, term);
        this.right = right;
        this.style = style;
    }
}