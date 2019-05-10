package java3opdrcht;

import javax.swing.JFrame;

public class MemoryGame extends JFrame{
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new MemoryJframe();			
			};
		});
	}
}		

