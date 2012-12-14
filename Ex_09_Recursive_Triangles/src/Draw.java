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
		
		Point p4 = new Point ((p1.x + p2.x)/2, (p1.y + p2.y)/2);
		Point p5 = new Point ((p2.x + p3.x)/2, (p2.y + p3.y)/2);
		Point p6 = new Point ((p3.x + p1.x)/2, (p3.y + p1.y)/2);
		

		int[] x1 = { p1.x, p2.x, p3.x };
		int[] y1 = { p1.y, p2.y, p3.y };
		int[] x2 = { p4.x, p5.x, p6.x };
		int[] y2 = { p4.y, p5.y, p6.y };

		g.drawPolygon(x1, y1, x1.length);
		g.drawPolygon(x2, y2, x2.length);
		
	
		g.drawString("P1", p1.x, p1.y);
		g.drawString("P2", p2.x, p2.y);
		g.drawString("P3", p3.x, p3.y);
		g.drawString("P4", p4.x, p4.y);
		g.drawString("P5", p5.x, p5.y);
		g.drawString("P6", p6.x, p6.y);
	}
}