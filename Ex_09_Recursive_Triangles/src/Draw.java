import java.awt.*;
import javax.swing.*;

public class Draw extends JFrame {
	JFrame frame;
	
	public Draw() {
		super();
		setTitle("draw");
		setSize(1366, 768);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void paint(Graphics g) {
		Dimension size = this.getSize();
		g.drawLine(50,50,200,200);
	}
	
	public static void main(String[] args) {
		new Draw();
	}
}