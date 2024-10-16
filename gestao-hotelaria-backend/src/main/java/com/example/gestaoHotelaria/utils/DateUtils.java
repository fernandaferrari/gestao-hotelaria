package com.example.gestaoHotelaria.utils;

import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;

public class DateUtils {
	public static LocalDateTime getConverteStringToDate(String data) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDateTime.parse(data, formatter);
	}
	
	public static String getConverteDateToString(LocalDateTime data) {
	    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	    return data != null ? formatter.format(data) : "";
	}

	public static String getConverteDataEmDiaSemana(LocalDateTime data) {
        DayOfWeek diaDaSemana = data.getDayOfWeek();
        return diaDaSemana.getDisplayName(TextStyle.FULL, new Locale("pt", "BR"));
	}
}
