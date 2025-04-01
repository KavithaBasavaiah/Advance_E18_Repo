package GenericUtility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	public int getRandomNum(int limit)
	{
		Random ran = new Random();
		int randomNum = ran.nextInt(limit);
		return randomNum;
		
	}
	public String generateSystemDate()
	{
		Date dateObj = new Date();
		SimpleDateFormat Sdf = new SimpleDateFormat("dd-MM-YYYY");
		String todaysDate = Sdf.format(dateObj);
		return todaysDate;
	}
	
	public String generateReqDate(int days)
	{
		Date dateObj = new Date();
		SimpleDateFormat Sdf = new SimpleDateFormat("dd-MM-YYYY");
		String todaysDate = Sdf.format(dateObj);
		
		Calendar cal = Sdf.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH, days);
		//cal.add(Calendar.YEAR, 2);
		String closeDate = Sdf.format(cal.getTime());
		return closeDate;
	}

}
