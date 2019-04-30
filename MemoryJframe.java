package java3opdrcht;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import javax.swing.JButton;
import javax.swing.JFrame;

public class MemoryJframe extends JFrame{

	JButton Jbutton;	
	MemoryColours color = new MemoryColours();
	MemoryCard card1 = null;
	MemoryCard card2 = null;

	public MemoryJframe(){		
		JFrame frame = new JFrame("Flow Layout");//create Jframe
		MemoryCard [] mCard = new MemoryCard[16];//create array for buttons


		for (int i = 0; i < 16; i++)//creating button
		{
			mCard[i] = new MemoryCard("Kaartje");
			mCard[i].setColor(color.getRandomColour());
			frame.add(mCard[i]);			

			mCard[i].addActionListener(new ActionListener(){//als er een button wordt aangeklikt 			
				private boolean firstFound;
				MemoryCard firstOpen;

				public void actionPerformed(ActionEvent e){
					buttonClick((MemoryCard) e.getSource());
				}

			});  
		}

		frame.setLayout(new GridLayout(4,4));
		frame.setSize(400,400);  
		frame.setVisible(true);  
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(150, 150);

	}

	private void buttonClick(MemoryCard source) {
		source.setOpen(true);//laat kleur zien van geklikte button 

		if (card1 == null)
		{
			card1 = source;
		} else {
			card2 = source;
		}

		if (card1 != null && card2 != null)
		{
			if (card1 != card2) 
			{
				if (card1.getColor() == card2.getColor()) 
				{
					System.out.println("gevonden");
					card1 = null;
					card2 = null;
				} else {
					//Een timer zetten die na 1 sec een nieuwe taak uitvoert
					//In een aparte thread (zie het als een kabouter die een ander opdrachtje uitvoert)

					Timer timer = new Timer(1000, new ActionListener() 
					{
						@Override
						public void actionPerformed(ActionEvent e) 
						{
							//dit gaat er gebeuren na 1 sec
							card1.setOpen(false);
							card2.setOpen(false);
							card1 = null;
							card2 = null;
						}
					});
					timer.setRepeats(false);
					//taak met vertraging laten uitvoeren
					timer.start();
				}
			}
		}
	}
}

