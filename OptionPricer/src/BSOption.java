/**
 * @author Sky
 * A class for Option Price calculation by Black-Scholes formula.
 * Note: Black-Scholes is applicable for European call & put option and American call option.
 */
public class BSOption extends BlackScholes{
    /**
     * A method to calculate the price of an Option by Black-Scholes formula.
     * @param o the Option object to be calculated.
     * @return the result.
     */
    @Override
    public double[] computeOption(Option o){

    };
    /**
     * A method to calculate the price of a put Option by Black-Scholes formula.
     * @param o the Option object to be calculated.
     * @return the result.
     */
    @Override
    private double crunchPut(Option o){

    };

    /**
     * A method to calculate the price of a call Option by Black-Scholes formula.
     * @param o the Option object to be calculated.
     * @return the result.
     */
    private double crunchCall(Option o){

    };

    /** Compute the cumulative (up to x) of the standard normal distribution.
     * Taken directly from Abramowitz and Stegun, 1972. Changed a bit to make it work for java.
     * @param x
     * @return the cumulative probability distribution for the given x.
     */
    private double cdf(double x){
        final double PI = 3.141592653;
        final double GAMMA = 0.2316419;
        final double A1 = 0.319381530;
        final double A2 = -0.356563782;
        final double A3 = 1.781477937;
        final double A4 = -1.821255978;
        final double A5 = 1.330274429;
        boolean xIsNeg = false;
        if (x < 0.0) {
            xIsNeg = true;
            x = -x;
        }

        double k = 1.0/(1.0 + GAMMA * x);
        double oneOverSqrtTwoPI = 1.0 / Math.sqrt(2*PI);
        double nPrime = (1.0/Math.sqrt(2*PI))*Math.exp((-0.5)*x*x);
        double kSquared = k*k;
        double kFourth = kSquared * kSquared;
        double result = 1.0 -
                nPrime*(A1*k + A2*kSquared + A3*k*kSquared + A4*kFourth + A5*kFourth*k);
        if (xIsNeg)
            return 1-result;
        else
            return result;
    }
}