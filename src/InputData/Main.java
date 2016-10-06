/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InputData;

import ProcessData.CalcProb;
import ProcessData.KeyPressedProcess;
import ProcessData.GaussDistData;
/**
 *
 * @author sponde
 */
public class Main {
    
    public static void main(String[] args){
        /**
        * Array to store Gaussian curvature of each of the features
        * First array element has the curve for time per character
        * Second for time per word
        * Third for index difference between typed and expected
        * Fourth for backspace key pressed count
        */
        
        ProcessData.GaussDistData gaussCurve[] = new ProcessData.GaussDistData[4];
        for(int i=0;i<4;i++){
            gaussCurve[i] = new ProcessData.GaussDistData();
        }
        KeyPressedProcess firstKeyProcessor = InputUI.buildGUI("This is the first test.");
        System.out.print("##");
        gaussCurve[0].calcGaussDist(firstKeyProcessor.getCharTime());
        gaussCurve[1].calcGaussDist(firstKeyProcessor.getWordTime());
        gaussCurve[2].calcGaussDist(firstKeyProcessor.getIndxArray());
        KeyPressedProcess secondKeyProcessor = InputUI.buildGUI("This is the second test.");
        gaussCurve[0].calcGaussDist(secondKeyProcessor.getCharTime());
        gaussCurve[1].calcGaussDist(secondKeyProcessor.getWordTime());
        gaussCurve[2].calcGaussDist(secondKeyProcessor.getIndxArray());
        System.out.println(gaussCurve[0].getMean()+" "+gaussCurve[1].getMean()+" "+gaussCurve[2].getMean());
        KeyPressedProcess thirdKeyProcessor = InputUI.buildGUI("Final string for authentication.");
        CalcProb detector = new CalcProb(gaussCurve, thirdKeyProcessor.getCharTime(), thirdKeyProcessor.getWordTime(),
            thirdKeyProcessor.getIndxArray());
        double probability = detector.getProb();
        System.out.println(probability);
    }
    
}
