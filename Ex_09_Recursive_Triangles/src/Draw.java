import java.awt.*;
import javax.swing.*;

public class Draw {
	JFrame frame;
	
	public Draw() {
		frame = new JFrame("draw");
		frame.setSize(1366, 768);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		new Draw();
	}

}