import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Sky on 2015/3/7-007.
 */
public class OPS {
    /**
     * An arraylist to save the algorithms chosen by the user.
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
     * This method is called when the OptionRight and OptionStyle is decided,i.e., the Call/Put button is clicked.
     */
    public static void createOption(){
        // It will call the constructor Option(OptionRight right, OptionStyle style).
        // then it will call showApplicableAlgs().
    }
    public static void createAlgorithm(String algName){
        // Not sure what to do so far.
    }
    public void showApplicableAlgs(Option o){
    }
    public static void compute(){
//        for(Algorithm al:algList){
//
//        }
    }
}
