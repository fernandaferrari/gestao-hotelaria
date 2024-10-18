package com.example.gestaoHotelaria.utils;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
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
		DateTimeFormatter novoFormato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try {
            return data.format(novoFormato);
        } catch (DateTimeParseException e) {
            System.out.println("Data inválida: " + data);
            return null;
        }
	}

	public static String getConverteDataEmDiaSemana(LocalDateTime data) {
        DayOfWeek diaDaSemana = data.getDayOfWeek();
        return diaDaSemana.getDisplayName(TextStyle.FULL, new Locale("pt", "BR"));
	}

	public static long getDiasEntreDuasDatas(LocalDateTime dataInicio, LocalDateTime dataFim) {
		return ChronoUnit.DAYS.between(dataInicio, dataFim);
	}

	public static LocalDateTime getConverteStringTimeToDate(String dataHoraCheckout) {
		ZonedDateTime zonedDateTime = ZonedDateTime.parse(dataHoraCheckout);
        LocalDateTime dataCheckout = zonedDateTime.withZoneSameInstant(ZoneId.of("America/Sao_Paulo")).toLocalDateTime();
		return dataCheckout;
	}
}
