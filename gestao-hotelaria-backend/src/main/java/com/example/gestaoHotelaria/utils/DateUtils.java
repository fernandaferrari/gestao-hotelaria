package com.example.gestaoHotelaria.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

public class DateUtils {
	public static LocalDateTime getConverteStringToDate(String data) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate localDate = LocalDate.parse(data, formatter);
	    return localDate.atStartOfDay();
	}
	
	public static LocalDateTime getConverteStringToDateHora(String data) {
	    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
	    return LocalDateTime.parse(data, dateTimeFormatter);
	}
	
	public static String getConverteDateToString(LocalDateTime data) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	    return data != null ? formatter.format(data) : "";
	}

	public static String getConverteDataEmDiaSemana(LocalDateTime data) {
        DayOfWeek diaDaSemana = data.getDayOfWeek();
        return diaDaSemana.getDisplayName(TextStyle.FULL, new Locale("pt", "BR"));
	}
}
