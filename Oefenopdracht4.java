package oefenopdracht4;

import java.awt.FlowLayout;
import javax.swing.JFrame;

public class Oefenopdracht4 {
    public static void main(String[] args){         
    	JFrame frame = new JFrame();         
    	frame.setVisible(true);         
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);         
    	frame.setSize(300,300);         
    	frame.setLayout(new FlowLayout());         
    	frame.add(new Controller());     
    } 
}
