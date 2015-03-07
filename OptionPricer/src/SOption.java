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


    public double[] computeOption(Option o){
        double[] prices=new double[NUMOFDOTS];
        double vBase=o.getVolatility();
        int count= (NUMOFDOTS-1)/2; // count = 5

        if(o.getRight()==OptionRight.PUT){
            prices[count]=crunchPut(o); // Middle point should be the "original" option.
            for (int i = count ; i >0 ; i--) {
                o.setVolatility(vBase*(1-i*DELTA));
                prices[count-i]=crunchPut(o);
                o.setVolatility(vBase*(1+i*DELTA));
                prices[count+i]=crunchPut(o);
            }
        }

        if(o.getRight()==OptionRight.CALL){
            prices[count]=crunchCall(o); // Middle point should be the "original" option.
            for (int i = count ; i >0 ; i--) {
                o.setVolatility(vBase*(1-i*DELTA));
                prices[count-i]=crunchCall(o);
                o.setVolatility(vBase*(1+i*DELTA));
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
     * An abstract method to calculate the price of a call option.
     *
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
                nns=rand.nextGaussian(); //Not sure
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

    /**************************************
     * testing for Simulation algorithm.
     * @param args
     *************************************/
    public static void main(String args[]){
        SOption bso=new SOption();
        bso.numIntervals=500;
        bso.numTrials=100;
        Option o1=new Option(50.0,50.0,0.1,0.4,5.0,OptionRight.CALL,OptionStyle.ASIAN);
//        System.out.println(bso.crunchCall(o1));
//        System.out.println(bso.crunchPut(o1));
        Option o2=new Option(40.0,50.0,0.1,0.4,5.0,OptionRight.CALL,OptionStyle.ASIAN);
//        System.out.println(bso.crunchCall(o2));
//        System.out.println(bso.crunchPut(o2));
        for (int i = 0; i < 11 ; i++) {
            System.out.println(bso.computeOption(o1)[i]);
        }
        System.out.println("--------------------");

        for (int i = 0; i < 11 ; i++) {
            System.out.println(bso.computeOption(o2)[i]);
        }


//        double prc[]=new double[11];
//        prc=bso.computeOption(o1);
//        for (int i = 0; i < 11 ; i++) {
//            System.out.println(prc[i]);
//        }
    }
}
