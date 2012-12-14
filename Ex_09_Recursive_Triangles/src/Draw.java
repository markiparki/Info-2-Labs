import java.awt.*;
import java.util.Random;

import javax.swing.*;

public class Draw extends JFrame {
	Random r = new Random();
	JFrame frame;
	int steps = 0;

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
		
		drawTriangle(p1, p2, p3, g);
		drawTriangle(p4, p5, p6, g);
		drawTriangleRecursive(p1, p4, p6, g);
		drawTriangleRecursive(p4, p5, p2, g);
		drawTriangleRecursive(p3, p6, p5, g);
	}
	
	public void drawTriangle(Point p1, Point p2, Point p3, Graphics g) {
		int[] x1 = { p1.x, p2.x, p3.x };
		int[] y1 = { p1.y, p2.y, p3.y };
		
		g.setColor(new Color(r.nextInt(256), r.nextInt(256), r.nextInt(256)));
		g.fillPolygon(x1, y1, x1.length);
	}
	
	public void drawTriangleRecursive(Point p1, Point p2, Point p3, Graphics g) {
		steps++;
		if(steps > 5) {
			steps = 0;
			return;
		}
		Point p4 = new Point ((p1.x + p2.x)/2, (p1.y + p2.y)/2);
		Point p5 = new Point ((p2.x + p3.x)/2, (p2.y + p3.y)/2);
		Point p6 = new Point ((p3.x + p1.x)/2, (p3.y + p1.y)/2);

		int[] x2 = { p4.x, p5.x, p6.x };
		int[] y2 = { p4.y, p5.y, p6.y };
		
		g.setColor(new Color(r.nextInt(256), r.nextInt(256), r.nextInt(256)));
		g.fillPolygon(x2, y2, x2.length);
		drawTriangleRecursive(p4,p5,p6, g);
	}
}