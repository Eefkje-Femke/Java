package java2;

public class Eindopdrachtlvl2 {
	//Fibonacci reeks is 0, 1, 1, 2, 3, 5, 8,    
	public static void main(String[] args) {         				
		int limTurns= 10, f = 0;
		int[] fibNum = new int[11];//maak nieuwe array

		Fibonacci fib = new Fibonacci();//create object
		fib.getallenreeks(fibNum, limTurns, f);//roep de methode aan
	}
}

 
/*
 * 2 variabelen (1,-1)
 * de som => array
 * een teller
 * 
 * een na laatste + de laatste is de nieuwe laatste
 * 
 * 
 *  for (int element: fibNum) {
		            System.out.println(element);
		        }
 * */