import java.util.Random;

/**
 * Created by Sky on 2015/3/6-006.
 */
public class SOption extends Simulation{
    private int numIntervals;
    private int numTrials;


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

    /**
     * Constructor.
     */
    public SOption(){};

    /**
     * An method to calculate the price of an Option using Simulation.
     * This method will also calculate different option prices in response to the change of volatility.
     * @param o the Option object to be calculated.
     * @return the array of prices.
     */
    @Override
    public double[] computeOption(Option o){
        double[] prices=new double[NUMOFDOTS];
        double vBase=o.getVolatility();
        int count= (NUMOFDOTS-1)/2; // count = 5

        if(o.getRight()==OptionRight.PUT){
            prices[count]=crunchPut(o); // Middle point should be the "original" option.
            for (int i = count ; i >0 ; i--) {
                o.setVolatility(vBase*(1-i* VOLINTERVAL));
                prices[count-i]=crunchPut(o);
                o.setVolatility(vBase*(1+i* VOLINTERVAL));
                prices[count+i]=crunchPut(o);
            }
        }

        if(o.getRight()==OptionRight.CALL){
            prices[count]=crunchCall(o); // Middle point should be the "original" option.
            for (int i = count ; i >0 ; i--) {
                o.setVolatility(vBase*(1-i* VOLINTERVAL));
                prices[count-i]=crunchCall(o);
                o.setVolatility(vBase*(1+i* VOLINTERVAL));
                prices[count+i]=crunchCall(o);
            }
        }
        return prices;
    }

    /**
     * A method to calculate the price of a put option using Simulation.
     * This method is taken from the given C++ project, AmericanPutOption.
     * Some adaptions are made to "translate" it into Java.
     * @param o the Option object to be calculated.
     * @return the result.
     */
    @Override
    public double crunchPut(Option o) {
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
            /*************************************
             * The only difference between calculating call and put option in simulation.
             ***************************************/
            trialPayoff = Math.max(o.getStrikeP()-trialAverage, 0.0);
            simulationRunningSum += trialPayoff;
        }
        simulationAveragePayoff = simulationRunningSum / numTrials;
        double valueOfOption;
        valueOfOption = simulationAveragePayoff * Math.exp(-o.getRiskFreeRate()*o.getTerm());
        return valueOfOption;
    }


    /**
     * A method to calculate the price of a put option using Simulation.
     * This method is taken from the given C++ project, AmericanPutOption.
     * Some adaptions are made to "translate" it into Java.
     * @param o the Option object to be calculated.
     * @return the result.
     */
    @Override
    public double crunchCall(Option o) {
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
                nns=rand.nextGaussian();
                s = s*Math.exp((o.getRiskFreeRate()-o.getVolatility()*o.getVolatility()/2)*deltaT +
                        o.getVolatility()*nns*Math.sqrt(deltaT));
                trialRunningSum += s;
            }
            trialAverage = trialRunningSum/numIntervals;
            /*************************************
             * The only difference between calculating call and put option in simulation.
             ***************************************/
            trialPayoff = Math.max(trialAverage - o.getStrikeP(), 0.0);
            simulationRunningSum += trialPayoff;
        }
        simulationAveragePayoff = simulationRunningSum / numTrials;
        double valueOfOption;
        valueOfOption = simulationAveragePayoff * Math.exp(-o.getRiskFreeRate()*o.getTerm());
        return valueOfOption;
    }



//    /**************************************
//     * testing for Simulation algorithm.
//     * @param args
//     *************************************/
//    public static void main(String args[]){
//        SOption bso=new SOption();
//        bso.numIntervals=500;
//        bso.numTrials=1000;
//        Option o1=new Option(50.0,50.0,0.1,0.4,5.0/12,OptionRight.CALL,OptionStyle.ASIAN);
//        System.out.println("ASIAN CALL,50, P="+bso.crunchCall(o1));
//        System.out.println("ASIAN PUT,50, P="+bso.crunchPut(o1));
//        Option o2=new Option(40.0,50.0,0.1,0.4,5.0/12,OptionRight.CALL,OptionStyle.ASIAN);
//        System.out.println("ASIAN CALL,40, P="+bso.crunchCall(o2));
//        System.out.println("ASIAN PUT,40, P="+bso.crunchPut(o2));
//        for (int i = 0; i < 11 ; i++) {
//            System.out.println(bso.computeOption(o1)[i]);
//        }
//        System.out.println("--------------------");
//
//        for (int i = 0; i < 11 ; i++) {
//            System.out.println(bso.computeOption(o2)[i]);
//        }
//    }
}
