package helloWorld;

import java.util.Random;
	
public class Eindopdracht {
	public static void main(String[] args) {
		//het aantal rijen en het aantal kolommen
		int numrows = Integer.parseInt(args [0]);//----- minimum
		int numcols = Integer.parseInt(args [1]);//|
		//random number generator
		Random rand = new Random();	
		//2d array
		int[][] a = new int[numrows] [numcols];	
		//array voor gemiddelde 
		int[] gemArray = new int[numrows];
		//variable
		int gemgem = 0;		
		int stand = 0;
		double verschil = 0;
		double dev = 0;
		int delen = 0;
		double uitkomst = 0;


		//nummering boven op tabel
		for(int i = 0; i < numcols; i++) {
			System.out.print("\t" + i);				
		}		

		//het rijtje voor de gemiddelde aanmaken
		System.out.print("\t" + "gemid.: ");		
		System.out.print("\n");

		//eerst vullen we een array a met willekeurige getallen:
		for(int i = 0; i < numrows; i++) {	
			int sum = 0;

			//nummering links van de tabel
			System.out.print(i + "\t");	

			for(int j = 0; j < numcols; j++) {	
				//random number generator	
				int n = rand.nextInt(100) + 1;
				//opslaan van waarden	
				a[i][j]  = n;			
				System.out.print(a[i][j] + "\t");
				//alle getallen in een rij bij elkaar optellen
				sum = sum + a[i][j];
			}
			//gemiddelde berekenen van elke rij
			gemArray[i] += sum / numrows;
			System.out.print(gemArray[i]);
			System.out.print("\n");			    	
		}		

		//berekening voor minimum value
		System.out.print("\n");
		System.out.print("min: ");	

		//bepaal minimum-waarde van elke kolom:
		for (int k = 0; k < numcols; k++) {// bepaal minimum values

			int minValue = 100; //globaal						

			for (int r = 0; r < numrows; r++) {				

				// dit is voor globaal minimum:
				if(a[r][k] < minValue) {							
					minValue = a[r][k];
				}	                        
			}	
			System.out.print("\t" + minValue);			
		}

		//het optellen van de gemiddelde waarden
		for(int q = 0; q < numcols; q++) {
			gemgem += gemArray[q];
		}
		int val = gemgem / numcols;
		System.out.print("\t" + val);

		//maximum-waarde berekenen
		System.out.print("\n");
		System.out.print("max: ");

		//bepaal maximum-waarde van elke kolom:
		for (int k = 0; k < numcols; k++) {

			int maxValue = 0; //globaal						

			for (int r = 0; r < numrows; r++) {		         
				// getallen vergelijken
				if(a[r][k] > maxValue) {		            	   
					maxValue = a[r][k];					
				}	  		                              
			}				
			System.out.print("\t" + maxValue);
		}	

		//standaard deviatie berekenen
		for(int t = 0; t < numcols; t++) {				
			verschil = gemArray[t] - val;
			dev = verschil * verschil;
			stand += dev;
			delen = stand / numcols;
			uitkomst = Math.sqrt(delen);
		}
		//antwoord afronden
		System.out.print("\t" + Math.floor(uitkomst * 1000)/1000);				
	}
}
