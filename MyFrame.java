

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

//import java3opdrcht.Persoon;

public class MyFrame extends JFrame{
	JTextField textName;
	JTextField textlast;
	DefaultListModel<Persoon> listModel;
	

	public MyFrame(){
		ConnectDB connection = new ConnectDB();

		textName = new JTextField(15);//create textfieldname
		textName.setBounds(50,50, 150,20);  
		
		textName.setBackground(Color.YELLOW);
		
		textlast = new JTextField(15);//create textfieldlastname
		textlast.setBounds(50,50, 150,20); 
		textlast.setBackground(Color.ORANGE);
			
		listModel = new DefaultListModel<>(); //creating list
		JList<Persoon> list = new JList<>(listModel);//create string list  
		list.setBounds(270,50, 100,150);  
    
		JButton getNaam = new JButton("button getName");
		getNaam.addActionListener(new ActionListener(){//button action  
			public void actionPerformed(ActionEvent e){ 
				for (Persoon p: connection.getAllPersons()) {
					listModel.addElement(p);
				}
			}
		});
	        	
		
		
        //create button 
        JButton butAddName = new JButton("Add name"); 
        butAddName.setBounds(50,105,100,30);  
        butAddName.addActionListener(new ActionListener(){//button action  
        	public void actionPerformed(ActionEvent e){ 
        		Persoon p = new Persoon();//papiertje waarop de foto komt
        		p.setVoorNaam(textName.getText());//foto
        		p.setAchterNaam(textlast.getText());
        		listModel.addElement(p);//listmodel=doosje
			}  
		});        
        
		JPanel p = new JPanel(new GridBagLayout());//create panel with certain layout
		GridBagConstraints c = new GridBagConstraints();//gridbag constant

		c.fill = GridBagConstraints.BOTH;//add textfield name to panel layout
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 2;
		c.weightx = 0.2;
		p.add(textName,c);

		//add textfield lastname to panel layout		
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 2;
		c.weightx = 0.2;
		p.add(textlast,c);
		
		//add button to panel layout
		c.gridx = 3;
		c.gridy = 0;
		c.gridwidth = 1;
		c.weightx = 0.2;
		p.add(butAddName,c);
		
		//get namen uit de DB
		c.gridx = 0;
		c.gridy = 2; 
		c.gridwidth = 1;
		c.weightx = 0.2;
		p.add(getNaam,c);
		
		//add JList to panel layout
		c.gridx = 3;
		c.gridy = 3;   
		c.gridwidth = 1;
		c.weightx = 0.2;
		p.add(list,c);
		
		this.add(p);//add panel(container) to frame
		this.setSize(600,400);  	
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation(150, 150);
	}		
}
