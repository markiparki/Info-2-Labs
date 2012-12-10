import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

/**
 * A graphical user interface for the calculator. No calculation is being done
 * here. This class is responsible just for putting up the display on screen. It
 * then refers to the "CalcEngine" to do all the real work.
 * 
 * @author David J. Barnes and Michael Kolling (edited by ma & jw)
 * @version 2012.11.13
 */

public class UserInterface implements ActionListener {
	private String displayContent = "";
	private JDateFunctions func;
	
	private JFrame frame;
	private JTextField display;
	private JLabel status;
	
	public UserInterface() {
		func = new JDateFunctions();
		makeFrame();
		frame.setVisible(true);
	}

	public void setVisible(boolean visible) {
		frame.setVisible(visible);
	}
	
	private void makeFrame() {
		frame = new JFrame("Date-Calculator");

		JPanel contentPane = (JPanel) frame.getContentPane();
		contentPane.setLayout(new BorderLayout(8, 8));
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));

		display = new JTextField();
		contentPane.add(display, BorderLayout.NORTH);

		JPanel buttonPanel = new JPanel(new GridLayout(0, 4, 2, 2));
		addButton(buttonPanel, "weekday");
		addButton(buttonPanel, "add");
		addButton(buttonPanel, "subtract");
		addButton(buttonPanel, "difference");
		
		contentPane.add(buttonPanel, BorderLayout.CENTER);

		status = new JLabel("jw & ma");
		contentPane.add(status, BorderLayout.SOUTH);

		frame.pack();
	}

	private void addButton(Container panel, String buttonText) {
		JButton button = new JButton(buttonText);
		button.addActionListener(this);
		panel.add(button);
	}

	public void actionPerformed(ActionEvent event) {
		String command = event.getActionCommand();
		
		if (command.equals("weekday")) {
			displayContent = func.showWeekday(display.getText());
		} else if (command.equals("add")) {
			displayContent = func.addDays(display.getText());
		} else if (command.equals("subtract")) {
			displayContent = func.subtractDays(display.getText());
		} else if (command.equals("difference")) {
			displayContent = func.differenceDates(display.getText());
		}

		redisplay();
	}

	private void redisplay() {
		display.setText(displayContent);
	}
}
