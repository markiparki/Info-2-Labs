import java.util.Calendar;
import java.util.Scanner;

public class Birthday {
	private int birthday;
	Calendar c;
	JDate jd;
	Scanner sc;
	int birthDay;
	int birthMonth;
	int birthYear;
	
	public Birthday() {
		c = Calendar.getInstance();
		//Instanzierung von JDate mit aktuellem Datum
		jd = new JDate(c.get(Calendar.DAY_OF_MONTH), c.get(Calendar.MONTH)+1, c.get(Calendar.YEAR));
		sc = new Scanner(System.in);

		//MetricDate md = new MetricDate(1234);
		start();
	}
	
	public static void main(String[] args) {
		new Birthday();
	}
	
	private void start() {
		this.birthday = getUsersBirthday();
		
		if((c.get(Calendar.DAY_OF_MONTH) == this.birthDay) && ((c.get(Calendar.MONTH)+1) == this.birthMonth)) {
			System.out.println("Today is your birthday!\nYou are " + jd.getDateDifferenceCurrentDate(this.birthday) + " days old.\nYou were born on a " + jd.getWeekday(this.birthday)+ ".");
		}else if((this.birthday % 100) == 0) {
			System.out.println("Your age in days is dividible by 100!\nYou are " + jd.getDateDifferenceCurrentDate(this.birthday) + " days old.\nYou were born on a " + jd.getWeekday(this.birthday)+ ".");
		}else {
			System.out.println("You are " + jd.getDateDifferenceCurrentDate(this.birthday) + " days old. You were born on a " + jd.getWeekday(this.birthday)+ ".");
		}
		System.out.println(this.birthday);
	}
	
	/**
	 * Asks user for its birthday and returns it as Julian Date.
	 * @return
	 */
	private int getUsersBirthday() {
		System.out.println("Enter your Birthday as numbers: ");

		System.out.print(" Day: ");
		this.birthDay = readNumber();
		
		System.out.print(" Month: ");
		this.birthMonth = readNumber();
		
		System.out.print(" Year: ");
		this.birthYear = readNumber();
		
		return jd.convertDateToJulianDate(this.birthDay, this.birthMonth, this.birthYear);
	}
	
	/**
	 * Reads Integer values from System.in
	 * @return
	 */
	private int readNumber(){
		int number = 0;
		try{
			number = Integer.parseInt(sc.nextLine()); 
		}catch(NumberFormatException nfe) {
			System.out.println(">> Error: Wrong Input");
			this.readNumber();
		}
			return number;
	}
}
