package java3opdrcht;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


public class MemoryColours {	
	//als de game laat
	//dan worden de kleuren al bepaald
	//en zet je de "visibility" op false
	
	//Color array met allemaal dubbele kleuren om ze met elkaar te matchen
	Color[] colorArr = {Color.RED, Color.RED, Color.GREEN, Color.GREEN, Color.CYAN, 
			Color.CYAN, Color.PINK, Color.PINK, Color.ORANGE,Color.ORANGE, Color.DARK_GRAY, 
			Color.DARK_GRAY, Color.BLUE, Color.BLUE, Color.MAGENTA, Color.MAGENTA};

	List<Color> ColorList = new ArrayList<Color>(Arrays.asList(colorArr));//veranderd color array naar arraylist
	
	public Color getColours() {		
		int rnd = new Random().nextInt(ColorList.size());//kiest een random nummer tussen de  en de size van Colorlist
		
		Color Colorint = ColorList.get(rnd);//"pakt" de gekozen kleur en zet hem in Colorint
		ColorList.remove(rnd);//verwijderd de kleur uit de arraylist zodat die niet nog een keer gekozen kan worden
		
		return Colorint;			
	}	
}	


