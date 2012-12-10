/**
 * @author jw & ma!!!
 * @since 06.10.2012 Provides operations for Julian Dates. The Julian format, is
 *        a 5 digit number, consisting of a 2 digit year and a 3 digit
 *        day-of-year number. For example, 24-August-1999 is stored as 99236,
 *        since 24-August is the 236th day of the year.
 */
public class JDate implements JulianDate {
	private int currentDate;

	/**
	 * Initializes the JulianDate object with the current date.
	 * 
	 * @param day
	 * @param month
	 * @param year
	 */
	public JDate(int day, int month, int year) {
		this.currentDate = this.convertDateToJulianDate(day, month, year);
	}

	/**
	 * Initializes the JulianDate object with the current date.
	 * 
	 * @param julianDate
	 *            takes the current date in JulianDate style (5-digit number: 2
	 *            digit year and a 3 digit day-of-year number)
	 */
	public JDate(int julianDate) {
		this.currentDate = julianDate;
	}

	/**
	 * Takes a date and converts it to Julian Date.
	 * 
	 * @param day
	 * @param month
	 * @param year
	 * @return Julian Date
	 * 
	 * http://www.blitzbasic.com/Community/posts.php?topic=67246
	 */
	public int convertDateToJulianDate(int day, int month, int year) {
		int j;
		int m1 = (month - 14) / 12;
		int y1 = year + 4800;
		j = 1461 * (y1 + m1) / 4 + 367 * (month - 2 - 12 * m1) / 12
				- (3 * ((y1 + m1 + 100) / 100)) / 4 + day - 32075;
		return j;
	}

	/**
	 * Takes Julian Date and converts it to a standard date (ddmmyyyy)
	 * 
	 * @param jDate
	 * @return 8-digit Integer with: ddmmyyyy
	 * http://www.mrexcel.com/forum/excel-questions/625126-julian-date-time.html
	 */
	public String convertJulianDateToDate(int jDate) {
		String output;
		int p = jDate + 68569;
		int q = 4 * p / 146097;
		int r = p - (146097 * q + 3) / 4;
		int s = 4000 * (r + 1) / 1461001;
		int t = r - 1461 * s / 4 + 31;
		int u = 80 * t / 2447;
		int v = u / 11;

		int year = 100 * (q - 49) + s + v;
		int month = u + 2 - 12 * v;
		int day = t - 2447 * u / 80;

		if (month < 10) {
			output = day + ".0" + month + "." + year;
		} else {
			output = day + "." + month + "." + year;
		}

		return output;
	}

	/**
	 * Takes two Julian Dates and returns the difference in days.
	 * 
	 * @param dateOne
	 * @param dateTwo
	 * @return difference in days
	 */
	public int getDateDifference(int jDateOne, int jDateTwo) {
		return Math.abs(jDateOne - jDateTwo);
	}

	/**
	 * Takes a Julian Date and returns the difference in days from today.
	 * 
	 * @param date
	 *            as ddmmyyyy
	 * @return difference in days
	 */
	public int getDateDifferenceCurrentDate(int date) {
		return Math.abs(this.currentDate - date);
	}

	/**
	 * Takes a Julian Date and returns the weekday as String
	 * 
	 * @param jDate
	 *            the Julian Date
	 * @return weekday as String
	 */
	public String getWeekday(int jDate) {
		int day = (int) ((jDate + 1.5) % 7);
		switch (day) {
		case 0:
			return "Sunday";
		case 1:
			return "Monday";
		case 2:
			return "Tuesday";
		case 3:
			return "Wednesday";
		case 4:
			return "Thursday";
		case 5:
			return "Friday";
		case 6:
			return "Saturday";
		default:
			return "Error";
		}
	}
}
