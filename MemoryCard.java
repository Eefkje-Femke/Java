package java3opdrcht;

import java.awt.Color;

import javax.swing.JButton;

public class MemoryCard extends JButton{
	private Color color;
	private boolean open = false;
	private boolean found = false;
	
	public boolean isFound() {
		return found;
	}

	public void setFound(boolean found) {
		this.found = found;
		this.setBackground(this.color);
		
	this.repaint();
	}
	
	public MemoryCard() {
	}
	
	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {		
		this.color = color;
		this.setBackground(getColor());	
	}
	
	public void setOpen(boolean open) {		
		this.open = open;
		this.setContentAreaFilled(open);
		//System.out.print(open + " ");
		//if(open) {
			this.setBackground(this.color);
		
		this.repaint();
	}
	
	public boolean getOpen() {
		return open;
	}

	public MemoryCard(String caption) {
		super(caption);
		this.setBorderPainted(false);//geen border 
		this.setContentAreaFilled(false);//set visible background color false			
	}
}
