import java.util.Calendar;


public class JDateFunctions {
	private JDate jd;
	
	public JDateFunctions() {
		jd = new JDate(0);
	}
	
    public String showWeekday(String s) {
    	String[] a = s.split("\\.");
    	try {
    		//Lese Datum
	    	int day = Integer.parseInt(a[0]);
	    	int month = Integer.parseInt(a[1]);
	    	int year = Integer.parseInt(a[2]);
	    	
	    	return jd.getWeekday(jd.convertDateToJulianDate(day, month, year));
    	}catch(Exception e) {
    		return "Error: Wrong formatted input. Please clear!";
    	}
    }
    
    public String addDays(String s){
    	//Entferne evtl. vorhandene Leerzeichen aus dem String
    	s = s.replaceAll(" ", "");
    	//Teile String bei "-" in 2 Strings (Datum & Anzahl Tage)
    	String[] comma = s.split(",");
    	//Teile ersten String bei "." in 3 Strings (Tage, Monat, Jahr)
    	String[] date = comma[0].split("\\.");
    	int jDate = 0, numDays = 0;
    	
    	try{
    		//Lese Datum
	    	int day = Integer.parseInt(date[0]);
	    	int month = Integer.parseInt(date[1]);
	    	int year = Integer.parseInt(date[2]);
	    	jDate = jd.convertDateToJulianDate(day, month, year);
	    	
	    	//Lese Anzahl Tage
	    	numDays = Integer.parseInt(comma[1]);
	    	return jd.convertJulianDateToDate(jDate+numDays);
    	}catch(Exception e){
    		return "Error: Wrong formatted input. Please clear!";
    	}
    }
    
    public String subtractDays(String s) {
    	//Entferne evtl. vorhandene Leerzeichen aus dem String
    	s = s.replaceAll(" ", "");
    	//Teile String bei "-" in 2 Strings (Datum & Anzahl Tage)
    	String[] comma = s.split(",");
    	//Teile ersten String bei "." in 3 Strings (Tage, Monat, Jahr)
    	String[] date = comma[0].split("\\.");
    	int jDate = 0, numDays = 0;
    	
    	try{
    		//Lese Datum
	    	int day = Integer.parseInt(date[0]);
	    	int month = Integer.parseInt(date[1]);
	    	int year = Integer.parseInt(date[2]);
	    	jDate = jd.convertDateToJulianDate(day, month, year);
	    	
	    	//Lese Anzahl Tage
	    	numDays = Integer.parseInt(comma[1]);
	    	return jd.convertJulianDateToDate(jDate-numDays);
    	}catch(Exception e){
    		return "Error: Wrong formatted input. Please clear!";
    	}
    }
    
    public String differenceDates(String s) {
    	//Entferne evtl. vorhandene Leerzeichen aus dem String
    	s = s.replaceAll(" ", "");
    	//Teile String bei "-" in 2 Strings (Datum & Datum 2)
    	String[] comma = s.split(",");
    	//Teile beide Strings bei "."
    	String[] date1 = comma[0].split("\\.");
    	String[] date2 = comma[1].split("\\.");
    	
    	try {
    		//Erstes Datum
    		int day1 = Integer.parseInt(date1[0]);
    		int month1 = Integer.parseInt(date1[1]);
    		int year1 = Integer.parseInt(date1[2]);
    		//Zweites Datum
    		int day2 = Integer.parseInt(date2[0]);
    		int month2 = Integer.parseInt(date2[1]);
    		int year2 = Integer.parseInt(date2[2]);
    		
    		return "" + jd.getDateDifference(jd.convertDateToJulianDate(day1, month1, year1), jd.convertDateToJulianDate(day2, month2, year2));
    	}catch(Exception e) {
    		return "Error: Wrong formatted input. Please clear!";
    	}
    }
}
