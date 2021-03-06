package controller;

import com.fathzer.soft.javaluator.DoubleEvaluator;
import com.fathzer.soft.javaluator.StaticVariableSet;
import model.*;

import java.util.ArrayList;

/**
 * @author Sky
 * The Controller class.
 */
public class OPS {


    /**
     * An arraylist to store the names of algorithms chosen by the user.
     */
    public static ArrayList<String> algNames;
    /**
     * An arraylist to store the algorithms chosen by the user.
     */
    public static ArrayList<Algorithm> algList;
    /**
     * An arraylist to store the names of drop-in algorithms.
     */
    public static ArrayList<String> customizedAlgNames;
    /**
     * An arraylist to store the algorithms chosen by the user.
     */
    /**
     * An arraylist to store the calculation results.
     */
    public static ArrayList<double[]> results;
    /**
     * The option object which is to be calculated
     */
    public static Option theOption;
    /**
     * A boolean value indicating whether the user would like to show the diagram.
     */
    public static boolean showDiagram;

    /**
     * To create an option.
     * This method is called when the model.OptionRight and model.OptionStyle is decided,i.e., the Call/Put button is clicked.
     *
     * @param r The model.Option right. (CALL/PUT)
     * @param s The model.Option Style. (ASIAN/EUROPEAN/AMERICAN)
     */
    public static void createOption(OptionRight r, OptionStyle s){
        theOption=new Option(r,s);
        // then it will call findApplicableAlgs().
    }
    public static void initAlgs(){
        algList = new ArrayList<Algorithm>();
        algNames = new ArrayList<String>();
        results = new ArrayList();
        // Not sure what to do so far.
    }

//    /**
//     * A method to decide all the applicable algorithms for a particular option based on the option right and style.
//     * @param o The option
//     * @return an arraylist of all all the applicable algorithms for this option.
//     */
//     ArrayList<Algorithm> findApplicableAlgs(Option o){
//        ArrayList<Algorithm> appAlgs=new ArrayList<Algorithm>();
//        switch(o.getStyle()) {
//            case ASIAN: {
//                appAlgs.add(new SimulationModel());
//                break;
//            }
//            case EUROPEAN: {
//                appAlgs.add(new SimulationModel());
//                appAlgs.add(new BlackScholesModel());
//                // add Binomial Tree and finite difference algorithm
//                break;
//            }
//            case AMERICAN: {
//                appAlgs.add(new SimulationModel());
//                // add Binomial Tree and finite difference algorithm
//                if (o.getRight() == OptionRight.CALL) appAlgs.add(new BlackScholesModel());
//                break;
//            }
//        }
//         return appAlgs;
//     }

    /**
     * A function to calculate the option price using the String-type formula that user enters.
     * Adapted from the Javaluator v3.0
     * @param expressions An arraylist of the String type formulas.
     * @return An arraylist of the price.
     */
    public static ArrayList<Double> evalExpression(ArrayList<String> expressions){
        DoubleEvaluator de=new DoubleEvaluator();
        StaticVariableSet<Double> vars=new StaticVariableSet<>();
        ArrayList<Double> results=new ArrayList<>();
        double s = theOption.getsNought();
        double k = theOption.getStrikeP();
        double t = theOption.getTerm();
        double o = theOption.getVolatility();
        double r = theOption.getRiskFreeRate();
        vars.set("s",s);
        vars.set("k",k);
        vars.set("t",t);
        vars.set("o",o);
        vars.set("r",r);
        // Evaluate an expression
        for(String exp:expressions){
            results.add(de.evaluate(exp,vars));
            //test
            System.out.println(exp+" = "+de.evaluate(exp,vars));
        }
        return results;
    }
    /**
     * A method to calculate option price using all the algorithms that user has chosen.
     */
    public static void compute(){
        for(String s:algNames){
            switch (s){
                case "BinomialTree": {
                    algList.add(new BinomialTree());
                    break;
                }
                case "BlackScholesModel": {
                    algList.add(new BlackScholesModel());
                    break;
                }
                case "FiniteDifference": {
                    algList.add(new FiniteDifference());
                    break;
                }
                case "SimulationModel": {
                    algList.add(new SimulationModel());
                    break;
                }
            }
        }
        for(Algorithm al:algList){
            System.out.println(al.getClass().getName());
            results.add(al.computeOption(theOption));
        }
        for(double[] r:results){
            for(double p:r){
                System.out.println(p);
            }
        }
    }
}
