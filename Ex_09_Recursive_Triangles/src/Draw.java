import java.awt.*;
import javax.swing.*;

public class Draw extends JFrame {
	JFrame frame;

	
	public Draw() {
		super();
		setTitle("jw & ma Sierpinski Triangle");
		setSize(Toolkit.getDefaultToolkit().getScreenSize());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBackground(Color.WHITE);
		setVisible(true);
	}
	
	public void paint(Graphics g) {
		Dimension size = this.getSize();
		int top = 35;
		int bottom = -45;
		int left = 15;
		int right= -15;
		
		Point p1 = new Point (0 + left, size.height + bottom);
		Point p2 = new Point(size.width / 2, 0 + top);
		Point p3 = new Point(size.width + right, size.height + bottom);
		
		Point p4 = new Point();

		int[] x = { p1.x, p2.x, p3.x };

		int[] y = { p1.y, p2.y, p3.y };

		Polygon triangle = new Polygon(x, y, x.length);
		g.drawPolygon(x, y, x.length);
		
	
		g.drawString("P1", p1.x, p1.y);
		g.drawString("P2", p2.x, p2.y);
		g.drawString("P3", p3.x, p3.y);
//		g.drawString("P4", p1.x - p2.x, p1.y - p2.y);
	}
}