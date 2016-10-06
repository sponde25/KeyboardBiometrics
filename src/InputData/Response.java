/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InputData;

import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Anirudh
 */
public class Response {
    JFrame frame;
    JLabel outputLabel;
    Container contents;
    
    public Response(String output){
        frame = new JFrame();
        outputLabel = new JLabel();
        outputLabel.setText(output);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        contents = frame.getContentPane();
        contents.add(outputLabel, BorderLayout.CENTER);
    }
    
    public Response(){
        frame = new JFrame();
        outputLabel = new JLabel();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        contents = frame.getContentPane();
        contents.add(outputLabel, BorderLayout.CENTER);
    }
    
    public void showResponse(){
        frame.setVisible(true);
    }
}
