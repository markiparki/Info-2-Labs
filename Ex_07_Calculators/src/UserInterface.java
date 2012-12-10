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
	private CalcEngine calc;
	private boolean showingAuthor;

	private JFrame frame;
	private JTextField display;
	private JLabel status;
	
	JButton aButton;
	JButton bButton;
	JButton cButton;
	JButton dButton;
	JButton eButton;
	JButton fButton;
	
	private JCheckBox checkBoxHexa;
	private JCheckBox checkBoxString;

	/**
	 * Create a user interface.
	 * 
	 * @param engine
	 *            The calculator engine.
	 */
	public UserInterface(CalcEngine engine) {
		calc = engine;
		showingAuthor = true;
		makeFrame();
		frame.setVisible(true);
	}

	/**
	 * Set the visibility of the interface.
	 * 
	 * @param visible
	 *            true if the interface is to be made visible, false otherwise.
	 */
	public void setVisible(boolean visible) {
		frame.setVisible(visible);
	}
	
	/**
	 * Make the frame for the user interface.
	 */
	private void makeFrame() {
		frame = new JFrame(calc.getTitle());
		
		checkBoxHexa = new JCheckBox("hexa", false);
		checkBoxString = new JCheckBox("string", false);

		JPanel contentPane = (JPanel) frame.getContentPane();
		contentPane.setLayout(new BorderLayout(8, 8));
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));

		display = new JTextField();
		contentPane.add(display, BorderLayout.NORTH);

		JPanel buttonPanel = new JPanel(new GridLayout(6, 6));
		addButton(buttonPanel, "7");
		addButton(buttonPanel, "8");
		addButton(buttonPanel, "9");
		buttonPanel.add(new JLabel(" "));
		buttonPanel.add(new JLabel(" "));
		addButton(buttonPanel, "clear");

		addButton(buttonPanel, "4");
		addButton(buttonPanel, "5");
		addButton(buttonPanel, "6");
		buttonPanel.add(new JLabel(" "));
		buttonPanel.add(new JLabel(" "));
		addButton(buttonPanel, "?");

		addButton(buttonPanel, "1");
		addButton(buttonPanel, "2");
		addButton(buttonPanel, "3");
		buttonPanel.add(new JLabel(" "));
		addButton(buttonPanel, "+");
		addButton(buttonPanel, "-");

		buttonPanel.add(new JLabel(" "));
		addButton(buttonPanel, "0");
		buttonPanel.add(new JLabel(" "));
		buttonPanel.add(new JLabel(" "));
		addButton(buttonPanel, "/");
		addButton(buttonPanel, "*");

		aButton = new JButton("A");
		buttonPanel.add(aButton);
		aButton.addActionListener(this);
		aButton.setEnabled(false);
		
		bButton = new JButton("B");
		buttonPanel.add(bButton);
		bButton.addActionListener(this);
		bButton.setEnabled(false);
		
		cButton = new JButton("C");
		buttonPanel.add(cButton);
		cButton.addActionListener(this);
		cButton.setEnabled(false);
		
		buttonPanel.add(new JLabel(" "));
		buttonPanel.add(checkBoxString);
		checkBoxString.addActionListener(this);
		buttonPanel.add(checkBoxHexa);
		checkBoxHexa.addActionListener(this);
		
		dButton = new JButton("D");
		buttonPanel.add(dButton);
		dButton.addActionListener(this);
		dButton.setEnabled(false);
		
		eButton = new JButton("E");
		buttonPanel.add(eButton);
		eButton.addActionListener(this);
		eButton.setEnabled(false);
		
		fButton = new JButton("F");
		buttonPanel.add(fButton);
		fButton.addActionListener(this);
		fButton.setEnabled(false);
		
		buttonPanel.add(new JLabel(" "));
		buttonPanel.add(new JLabel(" "));
		addButton(buttonPanel, "=");

		contentPane.add(buttonPanel, BorderLayout.CENTER);

		status = new JLabel(calc.getAuthor());
		contentPane.add(status, BorderLayout.SOUTH);

		frame.pack();
	}

	/**
	 * Add a button to the button panel.
	 * 
	 * @param panel
	 *            The panel to receive the button.
	 * @param buttonText
	 *            The text for the button.
	 */
	private void addButton(Container panel, String buttonText) {
		JButton button = new JButton(buttonText);
		button.addActionListener(this);
		panel.add(button);
	}

	/**
	 * An interface action has been performed. Find out what it was and handle
	 * it.
	 * 
	 * @param event
	 *            The event that has occured.
	 */
	public void actionPerformed(ActionEvent event) {
		String command = event.getActionCommand();

		if (command.equals("0") || command.equals("1") || command.equals("2")
				|| command.equals("3") || command.equals("4")
				|| command.equals("5") || command.equals("6")
				|| command.equals("7") || command.equals("8")
				|| command.equals("9") || command.equals("A")
				|| command.equals("B") || command.equals("C")
				|| command.equals("D") || command.equals("E")
				|| command.equals("F")) {
			int number;
			if(checkBoxHexa.isSelected()) {
				number = Integer.parseInt(command, 16);
			} else {
				number = Integer.parseInt(command);
			}
			calc.numberPressed(number);
		} else if (command.equals("+")) {
			calc.plus();
		} else if (command.equals("-")) {
			calc.minus();
		} else if (command.equals("/")) {
			calc.divide();
		} else if (command.equals("*")) {
			calc.times();
		} else if (command.equals("=")) {
			if(checkBoxString.isSelected()) {
				calc.evaluateInfix(display.getText(), checkBoxHexa.isSelected());
			}else {
				calc.equals();
			}
		} else if (command.equals("clear")) {
			calc.clear();
		} else if (command.equals("?")) {
			showInfo();
		} else if(command.equals("hexa")) {
			if(checkBoxHexa.isSelected()) {
				aButton.setEnabled(true);
				bButton.setEnabled(true);
				cButton.setEnabled(true);
				dButton.setEnabled(true);
				eButton.setEnabled(true);
				fButton.setEnabled(true);
			} else {
				aButton.setEnabled(false);
				bButton.setEnabled(false);
				cButton.setEnabled(false);
				dButton.setEnabled(false);
				eButton.setEnabled(false);
				fButton.setEnabled(false);
			}
		}
		// else unknown command.

		redisplay();
	}

	/**
	 * Update the interface display to show the current value of the calculator.
	 */
	private void redisplay() {
		if(checkBoxHexa.isSelected()) {
			display.setText(Integer.toHexString(calc.getDisplayValue()));
		} else {
			display.setText("" + calc.getDisplayValue());
		}
	}

	/**
	 * Toggle the info display in the calculator's status area between the
	 * author and version information.
	 */
	private void showInfo() {
		if (showingAuthor)
			status.setText(calc.getVersion());
		else
			status.setText(calc.getAuthor());

		showingAuthor = !showingAuthor;
	}
}