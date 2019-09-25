package oefenopdracht6;

public class Product {
	private double btw = 21.0;     
	private double prijs; 
	private int i;
	  
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
    public double getTotalPrijs(){ 
    	System.out.print("prijs" + prijs);
    	System.out.print("btw" +btw);
    	return prijs*(btw/100);     
	} 
}
