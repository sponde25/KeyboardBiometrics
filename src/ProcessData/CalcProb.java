/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProcessData;

import java.util.ArrayList;
import org.apache.commons.math.distribution.NormalDistributionImpl;
/**
 *
 * @author Anirudh
 */
public class CalcProb {
    
    GaussDistData[] gaussCurve;
    ArrayList<Long> charTime;
    ArrayList<Long> wordTime;
    int[] indxArray;
    NormalDistributionImpl curve[];
    public CalcProb(GaussDistData[] gaussCurve, ArrayList<Long> charTime, ArrayList<Long> wordTime,
            int[] indxArray) {
        this.gaussCurve = gaussCurve;
        this.charTime = charTime;
        this.wordTime = wordTime;
        this.indxArray = indxArray;
        curve = new NormalDistributionImpl[3];
        for(int i=0;i<3;i++)
            curve[i] = new NormalDistributionImpl(gaussCurve[i].getMean(),
                gaussCurve[i].getSigma());
    }

    public double getProb() {
        double probability = 1;
        for(long x:charTime)
                probability *= curve[0].density(x);
        System.out.println(probability);
        for(long x:wordTime)
            probability *= curve[1].density(x);
        System.out.println(probability);
        for(int x:indxArray)
            probability *= curve[2].density(x);
        System.out.println(probability);
        return probability;
    }
    
}
