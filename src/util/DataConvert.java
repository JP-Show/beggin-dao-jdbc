package util;

import java.time.LocalDate;
import java.util.Date;

public class DataConvert {

	public static LocalDate dateForLocalDate (Date date) {
		LocalDate newDate = LocalDate.parse(date.toString());
		
		return newDate;
	}
	
}
