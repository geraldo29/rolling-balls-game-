import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * Class provides a date and time format.
 * @author geraldo
 *
 */

public class DateTime {
	 

	    static String getDateTime() {
	        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
	        Date date = new Date();
	        return dateFormat.format(date);
	        
	    }
}
