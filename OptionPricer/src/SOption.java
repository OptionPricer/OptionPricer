import java.util.Random;

/**
 * Created by Sky on 2015/3/6-006.
 */
public class SOption extends Simulation{
    private int numIntervals;
    private int numTrials;

    /**
     * An abstract method to calculate the price of an Option.
     *
     * @param o the Option object to be calculated.
     * @return the result.
     */
    @Override
    public double[] computeOption(Option o) {
        return new double[0];
    }

    /**
     * An abstract method to calculate the price of a put option using Simulation.
     * This method is taken from the given C++ project, AmericanPutOption.
     * Some adaptions are made to "translate" it into Java.
     * @param o the Option object to be calculated.
     * @return the result.
     */
    @Override
    public double crunchPut(Option o) {
        return 0.0;
    }

    // Not sure whether this method is for call or put.
    double simulate(Option o) {
        int i, trialCount;
        double deltaT = o.getTerm()/(double)numIntervals;
        double trialRunningSum, trialAverage, trialPayoff;
        double simulationRunningSum, simulationAveragePayoff;
        double s ;
        Random rand=new Random();
        simulationRunningSum = 0.0;
        for (trialCount = 1; trialCount <= numTrials; trialCount++) {
            s = o.getsNought();
            trialRunningSum = 0.0;
            double nns = 0;
            for (i = 0; i < numIntervals; i++) {
                // nns = rand.nextSobelNormal();
                //    nns = rand.nextMoroNormal();
                nns=rand.nextGaussian(); //Not sure
                s = s*Math.exp((o.getRiskFreeRate()-o.getVolatility()*o.getVolatility()/2)*deltaT +
                        o.getVolatility()*nns*Math.sqrt(deltaT));
                trialRunningSum += s;
            }
            trialAverage = trialRunningSum/numIntervals;
            trialPayoff = Math.max(trialAverage - o.getStrikeP(), 0.0);
            simulationRunningSum += trialPayoff;
        }
        simulationAveragePayoff = simulationRunningSum / numTrials;
        double valueOfOption;
        valueOfOption = simulationAveragePayoff * Math.exp(-o.getRiskFreeRate()*o.getTerm());
        return valueOfOption;
    }
    /**
     * An abstract method to calculate the price of a call option.
     *
     * @param o the Option object to be calculated.
     * @return the result.
     */
    @Override
    public double crunchCall(Option o) {
        return 0;
    }

    public int getNumIntervals() {
        return numIntervals;
    }

    public void setNumIntervals(int numIntervals) {
        this.numIntervals = numIntervals;
    }

    public int getNumTrials() {
        return numTrials;
    }

    public void setNumTrials(int numTrials) {
        this.numTrials = numTrials;
    }
}
