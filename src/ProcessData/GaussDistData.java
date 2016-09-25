/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProcessData;

import java.util.ArrayList;
import org.apache.commons.math.stat.descriptive.DescriptiveStatistics;

/**
 *
 * @author sponde
 */
public class GaussDistData {
    double mean;
    double sigma;
    DescriptiveStatistics stats;
    public GaussDistData(){
        mean = 0;
        sigma = 0;
        stats  = new DescriptiveStatistics();
    }
    
    public void calcGaussDist(ArrayList<Long> xInput){
        
        for(long i:xInput){
            stats.addValue(i);
        }
        mean = stats.getMean();
        sigma = stats.getStandardDeviation();
    }
    
    public void calcGaussDist(int[] xInput){
        
        for(int i: xInput){
            stats.addValue(i);
        }
        mean = stats.getMean();
        sigma = stats.getStandardDeviation();
    }
        
}
