

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;


public class Opdracht4 {

	public static void main(String [ ] args) {

		SwingUtilities.invokeLater(new Runnable() {

			public void run() {
				new MyFrame().setVisible(true);
			}
		});		

	}
}

