/**
 * @author Sky
 * A class of general financial products
 */
public class Product {
    private double strikeP;
    private double sNought;
    private double riskFreeRate;
    private double volatility;
    private double term;

    public double getStrikeP() {
        return strikeP;
    }

    public void setStrikeP(double strikeP) {
        this.strikeP = strikeP;
    }

    public double getsNought() {
        return sNought;
    }

    public void setsNought(double sNought) {
        this.sNought = sNought;
    }

    public double getRiskFreeRate() {
        return riskFreeRate;
    }

    public void setRiskFreeRate(double riskFreeRate) {
        this.riskFreeRate = riskFreeRate;
    }

    public double getVolatility() {
        return volatility;
    }

    public void setVolatility(double volatility) {
        this.volatility = volatility;
    }

    public double getTerm() {
        return term;
    }

    public void setTerm(double term) {
        this.term = term;
    }
}
