package oefenopdracht4;

import java.beans.PropertyChangeListener; 
import java.beans.PropertyChangeSupport;
import java.util.Random;

public class Model {
	 int counter = 0;     
	 String[] nameArr = new String[] {"Lisa", "Romy", "Tim", "Tom", "Jan"};

	 private PropertyChangeSupport pcs = new PropertyChangeSupport(this);     
	 public Model() {  }     
	 
	 public void addPropertyChangeListener(PropertyChangeListener listener) {          
		 this.pcs.addPropertyChangeListener(listener);      
	 } 
	 
     public void removePropertyChangeListener(PropertyChangeListener listener) {          
    	 this.pcs.removePropertyChangeListener(listener);      
    	 } 
	    
     public void Name() {
    	 Random rand = new Random(); 
         String name = nameArr[rand.nextInt(nameArr.length)]; 
         int oldValue = counter;                     
    	this.pcs.firePropertyChange("vName", oldValue, name);//stuurt hier naar view??
     }
	 
}

		

