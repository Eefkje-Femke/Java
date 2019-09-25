package oefenopdracht6;

public class Factuurregel {
	private double AantalP;
	Product p = new Product();
	
	 public double getAantalP() {         
	    	return AantalP;     
	 }
	 
    public void setAantalP(int AantalP) {         
    	this.AantalP = AantalP;     
	} 
    public double getPrijsInclusiefBtw(){ 
    	return AantalP*p.getPrijs()+p.getTotalPrijs();     
	} 
}
