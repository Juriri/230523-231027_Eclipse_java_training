package step1;
import java.awt.Dimension;
import javax.swing.*;


public class GUI_Cal
{	public static void main(String[] args) {
	
	Dimension dim = new Dimension(400,500);
	
	JFrame frame = new JFrame("Basic Calculator");
	frame.setLocation(200,400);
	frame.setPreferredSize(dim);
	
	JButton num_btn1 = new JButton("숫자1");
	JButton num_btn2 = new JButton("숫자2");
	
	frame.add(num_btn1,num_btn2);
	
	frame.pack();
	frame.setVisible(true);
	}
}
