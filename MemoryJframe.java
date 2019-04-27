package java3opdrcht;


import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

import javax.swing.JButton;
import javax.swing.JFrame;
public class MemoryJframe extends JFrame{

	JButton Jbutton;	
	MemoryColours color = new MemoryColours();
	MemoryCard card = new MemoryCard();
	int numButton = 18;
	
	public MemoryJframe(){		
		JFrame frame = new JFrame("Flow Layout");//create Jframe
		MemoryCard [] Jbutton = new MemoryCard[16];//create array for buttons
			
		for (int i = 0; i < 16; i++)//creating button
		{
			Jbutton[i] = new MemoryCard("Kaartje");
			Jbutton[i].setColor(color.getColours());
			frame.add(Jbutton[i]);			
			
			Jbutton[i].addActionListener(new ActionListener(){//button action 			
				private boolean firstFound;//er is nog namelijk niks gevonden
				MemoryCard firstOpen;
				
				public void actionPerformed(ActionEvent e){ 
					MemoryCard clickbutton = (MemoryCard)e.getSource();//get clicked button	
					clickbutton.setOpen(true);//laat kleur zien van geklikte button						

					
					for(int mc = 0 ; mc < Jbutton.length; mc++) {//deze loopt door alle MemoryCards
						
						if(mc == numButton) mc++;
						if(Jbutton[mc].getOpen() && !Jbutton[mc].isFound())//kijkt of een card al is omgedraaid
						{		
							
							if(firstFound) //Deze if-statement
							//checkt of dit de eerste card is gevonden en omgedraaid
							{
								System.out.println("1 ");
								if(firstOpen.getColor().equals(Jbutton[mc].getColor())) 
								{
									System.out.println("2 ");
									firstOpen.setFound(true);									
									Jbutton[mc].setFound(true);	
									Jbutton[mc].setOpen(true);
								} else 
								{
									try{
										/*Hier worden de kaarten omgedraaid die niet met elkaar matchen*/
										System.out.println("3 ");
										frame.getContentPane().repaint();
//										TimeUnit.SECONDS.sleep(1);
										Jbutton[mc].setOpen(false);
										firstOpen.setOpen(false);
										clickbutton.setOpen(false);
										firstFound = false;
										
									}catch(Exception ex) {}
								}
							} else 
							{
								/*Het eerst omgedraaide kaartje*/
								System.out.println("4 " + mc );
								firstOpen = Jbutton[mc];
								numButton = mc;
								firstFound = true;
							}
						}
					}
				}  
			});  
		}
		
		frame.setLayout(new GridLayout(4,4));
		frame.setSize(400,400);  
		frame.setVisible(true);  
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(150, 150);
	
	}
}

//Color[] matchColorArr = {};
//Integer[] matchButtonArr = {};
//List<Integer> matchingButtonList = new ArrayList<Integer>(Arrays.asList(matchButtonArr));
//List<Color> matchingColorList = new ArrayList<Color>(Arrays.asList(matchColorArr));
