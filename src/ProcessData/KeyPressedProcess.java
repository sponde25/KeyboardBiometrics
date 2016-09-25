/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProcessData;

import static com.sun.glass.events.KeyEvent.*;
import static java.awt.event.KeyEvent.*;
import java.util.ArrayList;

/**
 *
 * @author sponde
 */
public class KeyPressedProcess {
    
    ArrayList<Long> charTimeList;
    ArrayList<Long> wordTimeList;
    long curWordTime;
    long curTime;
    long escapePressed;
    int[] indxArray;
    //double mean, mu;
    String testString;
    int curIndx;
    
    public KeyPressedProcess(){
        charTimeList = new ArrayList<>();
        wordTimeList = new ArrayList<>();
        curWordTime = 0;
        curTime = 0;
        escapePressed = 0;
        testString = "";
        curIndx = 0;
    }
    
    public KeyPressedProcess(String trainingString){
        charTimeList = new ArrayList<>();
        wordTimeList = new ArrayList<>();
        curWordTime = 0;
        curTime = 0;
        escapePressed = 0;
        testString = trainingString;
        indxArray = new int[trainingString.length()];
        curIndx = 0;
    }
    public void keyPressed(long keyPressedTime){
        if(charTimeList.isEmpty()){
            curTime = keyPressedTime;
            charTimeList.add(curTime);
            return;
        }
        charTimeList.add(keyPressedTime - curTime);
        curTime = keyPressedTime;
    }

    public void charPressed(java.awt.event.KeyEvent evt) {
        if(evt.getKeyCode() == VK_BACKSPACE){
            escapePressed ++;
            curIndx = curIndx-->=0?curIndx:0;
        }
        if(evt.getKeyChar()!=CHAR_UNDEFINED){
            char charPressed = evt.getKeyChar();
            if(charPressed == ' '){
                if(wordTimeList.isEmpty()){
                    wordTimeList.add(curWordTime);
                    curWordTime = evt.getWhen();
                }
                else{
                    wordTimeList.add(evt.getWhen()-curWordTime);
                    curWordTime = evt.getWhen();
                }
                return;
            }
            indxArray[curIndx] = 
                    (int)(Math.abs(evt.getKeyChar()-testString.charAt(curIndx)));
            
        }
    }
    
    public ArrayList<Long> getCharTime(){
        return charTimeList;
    }
    
    public ArrayList<Long> getWordTime(){
        return wordTimeList;
    }
    
    public int[] getIndxArray(){
        return indxArray;
    }
    
    public long getEscapePressed(){
        return escapePressed;
    }
    
    
    public void setCharTime(ArrayList<Long> newCharTimeList){
        charTimeList = newCharTimeList;
    }
    
    public void setWordTimeList(ArrayList<Long> newWordTimeList){
        wordTimeList = newWordTimeList;
    }
    
    public void setIndxArray(int[] newIndxArray){
        indxArray = newIndxArray;
    }
    
    public void setEscapePressed(long newEscapePressed){
        escapePressed = newEscapePressed;
    }
    
    public void getInputString(String inputString){
        
    }
}
