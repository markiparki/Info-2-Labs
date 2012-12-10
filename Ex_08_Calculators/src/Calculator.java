/**
 * The main class of a simple calculator. Create one of these and you'll
 * get the calculator on screen.
 * 
 * @author David J. Barnes and Michael Kolling (edited by ma & jw)
 * @version 2012.11.13
 */
public class Calculator
{
    private UserInterface gui;

    /**
     * Create a new calculator and show it.
     */
    public Calculator() {
        gui = new UserInterface();
    }
    
    public static void main(String args[]) {
    	new Calculator();
    }

    /**
     * In case the window was closed, show it again.
     */
    public void show() {
        gui.setVisible(true);
    }
}