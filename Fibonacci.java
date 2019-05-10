package java2;

public class Fibonacci {
	public void getallenreeks(int[]fibNum, int limTurns, int f) {  
		int i;
		
		if(f >= limTurns)
		//f wordt steeds groter tot dat het 10 keer is op geroepen. Daarna wordt de array geprint.
		{
			for (i = 0; i < limTurns; i++) {
				System.out.print("Element " + i + " = " + fibNum[i] + "\n");
			}
		}else {
			if ((f == 0) || (f == -1)) {//De andere regel geldt niet voor deze 2 waardes. 
				fibNum[f+1]=f+1;
			}else {
				fibNum[f+1] = fibNum[f] + fibNum[f-1];		
			}
			f++;			
			getallenreeks(fibNum, limTurns, f);//recursie
		}
		
	}
}

/*if (f==0) {
fibNum[1]= 1;
} else 
if (f==-1) {
fibNum[0] = 0;
} else {
fibNum[f+1] = fibNum[f] + fibNum[f-1];		
}*/

/*f3 = f1 + f2;
f1 = f2;
f2 = f3;*/
