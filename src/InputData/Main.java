/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InputData;

import ProcessData.KeyPressedProcess;

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
        KeyPressedProcess firstKeyProcessor = InputUI.buildGUI("This is the first test string to start the verification "+
                "process. Write naturally.");
        gaussCurve[0].calcGaussDist(firstKeyProcessor.getCharTime());
    }
    
}
