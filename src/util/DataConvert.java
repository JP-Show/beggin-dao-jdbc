package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DataConvert {

	public static LocalDate dateForLocalDate(Date date) throws ParseException {
		return LocalDate.parse(date.toString());
	}

	public static Date localDateForDate(LocalDate date) throws ParseException {
		DateTimeFormatter ftm = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date newDate;
		newDate = sdf.parse(ftm.format(date));

		return newDate;
	}
}
