package controller;

import model.*;

import java.util.ArrayList;

/**
 * @author Sky
 * The Controller class.
 */
public class OPS {
    /**
     * An arraylist to store the algorithms chosen by the user.
     */
    static ArrayList<Algorithm> algList;
    /**
     * An arraylist to store the calculation results.
     */
    static ArrayList results;
    /**
     * The option object which is to be calculated
     */
    static Option theOption;
    /**
     * A boolean value indicating whether the user would like to show the diagram.
     */
    static boolean showDiagram;

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
    public static void createAlgorithm(String algName){
        // Not sure what to do so far.
    }

    /**
     * A method to decide all the applicable algorithms for a particular option based on the option right and style.
     * @param o The option
     * @return an arraylist of all all the applicable algorithms for this option.
     */
     ArrayList<Algorithm> findApplicableAlgs(Option o){
        ArrayList<Algorithm> appAlgs=new ArrayList<Algorithm>();
        switch(o.getStyle()) {
            case ASIAN: {
                appAlgs.add(new SimulationModel());
                break;
            }
            case EUROPEAN: {
                appAlgs.add(new SimulationModel());
                appAlgs.add(new BlackScholesModel());
                // add Binomial Tree and finite difference algorithm
                break;
            }
            case AMERICAN: {
                appAlgs.add(new SimulationModel());
                // add Binomial Tree and finite difference algorithm
                if (o.getRight() == OptionRight.CALL) appAlgs.add(new BlackScholesModel());
                break;
            }
        }
         return appAlgs;
     }

    /**
     * A method to calculate option price using all the algorithms that user has chosen.
     */
    public static void compute(){
        for(Algorithm al:algList){
            results.add(al.computeOption(theOption));
        }
        // Not sure what to do afterwards.
    }
}
