package practice.Basics;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class JavaBasicsWithDate {
	public static void main(String[] args) {
		Date dateObj=new Date();//this displays the current date and time in standard format
		System.out.println("Current System Date with standard format = "+dateObj);
		
		//if we want to change the date format use SimpleDtaeFormat class method called format()
		SimpleDateFormat sd=new SimpleDateFormat("yyyy-MM-dd");
		String formatedDate = sd.format(dateObj);
		System.out.println("formated date in the form of yyyy-mm-dd = "+formatedDate);
		
		
		Calendar cal=sd.getCalendar();

		cal.add(Calendar.DAY_OF_MONTH, -30);//this will generate 30 day before date
	String dateRequires=	sd.format(cal.getTime());
	System.out.println("the date before 30 days of currentdate is = "+dateRequires);
		
	Calendar cal1=sd.getCalendar();
	cal1.add(Calendar.DAY_OF_MONTH, 30);//this will generate 30 day after date date
String dateRequires1=	sd.format(cal1.getTime());
System.out.println("the date after 30 days of currentdate is = "+dateRequires1);

	
	
	}

}
