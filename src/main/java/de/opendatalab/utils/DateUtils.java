package de.opendatalab.utils;

import java.util.Calendar;
import java.util.Date;

public abstract class DateUtils {

	public static Date createLastMonth() {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DAY_OF_YEAR, -28);
		return c.getTime();
	}
}
