
public class MetricDate extends JDate {

	public MetricDate(int julianDate) {
		super(julianDate);
		System.out.println(convertToMetric(julianDate));
		System.out.println(convertToJDate(4,3,2,1));
	}
	
	public String convertToMetric(int jDate) {
		int day = jDate%10;
		jDate -= day;
		
		int week = (jDate%100)/10;
		jDate -= jDate%100;
		
		int month = (jDate%1000)/100;
		jDate -= jDate%1000;
		
		int year = jDate/1000;
		
		return day + ". day in the " + week + ". week of the " + month + ". month in the " + year + ". year.";
	}
	
	public int convertToJDate(int mDay, int mWeek, int mMonth, int mYear) {
		return (mYear*1000)+(mMonth*100)+(mWeek*10)+(mDay);
	}
}