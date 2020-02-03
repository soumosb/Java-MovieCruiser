package com.cognizant.moviecruiser.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	public static Date convertToDate(String date) {
		try {
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			Date dateOfExpiry = format.parse(date);
			return dateOfExpiry;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * @param d
	 * @return
	 */
	public static String convertToString(Date d) {

		SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyyy");
		String date = format1.format(d);
		return date;

	}
}
