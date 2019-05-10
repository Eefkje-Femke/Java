package java3opdrcht;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


public class MemoryColours {		
	//Color array met allemaal dubbele kleuren om ze met elkaar te matchen
	Color[] colorArr = {Color.RED, Color.RED, Color.GREEN, Color.GREEN, Color.CYAN, 
			Color.CYAN, Color.PINK, Color.PINK, Color.ORANGE,Color.ORANGE, Color.DARK_GRAY, 
			Color.DARK_GRAY, Color.BLUE, Color.BLUE, Color.MAGENTA, Color.MAGENTA};

	List<Color> colorList = new ArrayList<Color>(Arrays.asList(colorArr));//veranderd color array naar arraylist

	public Color getRandomColour() {		
		int rnd = new Random().nextInt(colorList.size());//kiest een random nummer tussen de  en de size van Colorlist

		Color colorint = colorList.get(rnd);//"pakt" de gekozen kleur en zet hem in Colorint
		colorList.remove(rnd);//verwijderd de kleur uit de arraylist zodat die niet nog een keer gekozen kan worden

		return colorint;			
	}	
}	


