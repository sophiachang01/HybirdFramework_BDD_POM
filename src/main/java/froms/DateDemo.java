package froms;
import java.text.DateFormatSymbols;
import java.util.Locale;

public class DateDemo {
	
	public static String getMonth(int month, Locale locale) { 
		//java.lang.NullPointerException
		return DateFormatSymbols.getInstance(locale).getMonths()[month-1]; 
		}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Locale e = null;
		getMonth(11, e);
		System.out.println(getMonth(11, e));
     }
}