

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
	JTextField textfname;
	JTextField textflast;
	DefaultListModel<Persoon> listModel;
	

	public MyFrame(){
		ConnectDB connection = new ConnectDB();

		textfname = new JTextField(15);//create textfieldname
		textfname.setBounds(50,50, 150,20);  
		
		textfname.setBackground(Color.YELLOW);
		
		textflast = new JTextField(15);//create textfieldlastname
		textflast.setBounds(50,50, 150,20); 
		textflast.setBackground(Color.ORANGE);
			
		listModel = new DefaultListModel<>(); //creating list
		JList<Persoon> list = new JList<>(listModel);//create string list  
		list.setBounds(270,50, 100,150);  
    
		for (Persoon p: connection.getAllPersons()) {
			listModel.addElement(p);
		}
		
        //create button 
        JButton button = new JButton("Add name"); 
        button.setBounds(50,105,100,30);  
        button.addActionListener(new ActionListener(){//button action  
        	public void actionPerformed(ActionEvent e){ 
        		Persoon p = new Persoon();//papiertje waarop de foto komt
        		p.setVoorNaam(textfname.getText());//foto
        		p.setAchterNaam(textflast.getText());
        		listModel.addElement(p);//listmodel=doosje
			}  
		});        
        
		JPanel p = new JPanel(new GridBagLayout());//create panel with certain layout
		GridBagConstraints c = new GridBagConstraints();//gridbag constant

		c.fill = GridBagConstraints.HORIZONTAL;//add textfield name to panel layout
		c.gridx = 0;
		c.gridy = 1;
		p.add(textfname,c);

		//add textfield lastname to panel layout
		c.gridwidth = 1;
		c.gridx = 1;
		c.gridy = 1;
		p.add(textflast,c);
		
		//add button to panel layout
		c.gridwidth = 1;
		c.gridx = 2;
		c.gridy = 1;
		p.add(button,c);
		
		//add jlist to panel layout
		c.gridx = 2;
		c.gridwidth = 1;   
		c.gridy = 2;    
		p.add(list,c);
		
		
		this.add(p);//add panel(container) to frame
		this.setSize(600,400);  	
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation(150, 150);
	}		
}
