public interface JulianDate {
	/**
	 * Takes a date and converts it to Julian Date.
	 * 
	 * @param day
	 * @param month
	 * @param year
	 * @return Julian Date
	 */
	public int convertDateToJulianDate(int day, int month, int year);

	/**
	 * Takes Julian Date and converts it to a standard date (dd.mm.yyyy)
	 * 
	 * @param jDate
	 * @return String dd.mm.yyyy
	 */
	public String convertJulianDateToDate(int jDate);

	/**
	 * Takes two Julian Dates and returns the difference in days.
	 * 
	 * @param dateOne
	 * @param dateTwo
	 * @return difference in days
	 */
	public int getDateDifference(int jDateOne, int jDateTwo);

	/**
	 * Takes a Julian Date and returns the difference in days from today.
	 * 
	 * @param date
	 *            as ddmmyyyy
	 * @return difference in days
	 */
	public int getDateDifferenceCurrentDate(int date);

	/**
	 * Takes a Julian Date and returns the weekday as String
	 * 
	 * @param jDate
	 *            the Julian Date
	 * @return weekday as String
	 */
	public String getWeekday(int jDate);
}
