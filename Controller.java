
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener; 
import java.beans.PropertyChangeEvent; 
import java.beans.PropertyChangeListener;
import javax.swing.*; 

public class Controller extends JPanel  implements PropertyChangeListener{
	
    JButton clickButton;     
    private View view;     
    private Model model; 
    
    public Controller(){         
    	model = new Model(); 
    	model.addPropertyChangeListener(this); 
    	view = new View();         
    	this.add(view); 
    
	    clickButton = new JButton("+1");         
	    clickButton.addActionListener(new ActionListener() {             
	    	@Override             
	    	public void actionPerformed(ActionEvent e) {                 
	    		model.increase();                 
//	    		view.setDisplay(Integer.toString(model.getCounter()));             
	    		}         
	    	});         
	    this.add(clickButton);     
    } 
    @Override     
    public void propertyChange(PropertyChangeEvent evt) {         
    	 if (evt.getPropertyName().equals("counter")) {             
    		 view.setDisplay(evt.getNewValue().toString());         
	 }        
	}
}
