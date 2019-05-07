package java3opdrcht;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.Timer;

public class MemoryJframe extends JFrame{

	MemoryColours color = new MemoryColours();	
	MemoryCard card1 = null;
	MemoryCard card2 = null;
	int countSet = 0;
	
	JLabel lNum;

	public MemoryJframe(){		
		JFrame frame = new JFrame("Flow Layout");//create Jframe
		MemoryCard [] mCard = new MemoryCard[16];//create array for buttons
		
		JPanel p1 = new JPanel();//panel links
        JPanel p2 = new JPanel();//panel rechts
        JLabel lTitle=new JLabel("Sets found: "); 
        
        System.out.println(Integer.toString(countSet));
		lNum = new JLabel(String.valueOf(countSet));
        
        JLabel lText=new JLabel("<html>Please wait 1 second <br /> before you try to find another match</html>");
        JButton restartbut=new JButton("Restart the game");
     
		for (int i = 0; i < 16; i++)//creating button
		{
			mCard[i] = new MemoryCard("Kaartje");
			mCard[i].setColor(color.getRandomColour());
			p1.add(mCard[i]);
			
			mCard[i].addActionListener(new ActionListener(){//als er een button wordt aangeklikt 	
				public void actionPerformed(ActionEvent e){
					buttonClick((MemoryCard) e.getSource());
				}

			});  
		}
		
		//reset the game
		restartbut.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){			
				new MemoryJframe();
			}
		});  
	
//		System.out.println(Integer.toString(countSet));
//		lNum.setText(String.valueOf(countSet));		
		
		JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, p1, p2);
		splitPane.setDividerLocation(400);//de divider tussen de 2 panels	
		p2.add(lTitle);//add label
		p2.add(lNum);//add number of sets found
		p2.add(restartbut);//add restart button
		p2.add(lText);//add text 
		p1.setLayout(new GridLayout(4,4));//set layout of panel
		
		frame.add(splitPane);//add the 2 panels		
		frame.setLayout(new GridLayout(1,1));
		frame.setSize(700,400);  
		frame.setVisible(true);  
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
					countSet++;
					System.out.println(Integer.toString(countSet));
					lNum.setText(String.valueOf(countSet));	
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
