package oefenopdracht5;

public class Btw {
	private double btw = 21.0;     
	private double prijs; 
	  
    public double getPrijs() {         
    	return prijs;     
    	} 
 
    public void setPrijs(double prijs) {         
    	this.prijs = prijs;     
    	} 
 
    public double getBtw() {         
    	return btw;     
    	} 
 
    public void setBtw(int btw) {         
    	this.btw = btw;     
    	}          
    public double getPrijsInclusiefBtw(){ 
    	return prijs*(btw/100);     
	}   
}
