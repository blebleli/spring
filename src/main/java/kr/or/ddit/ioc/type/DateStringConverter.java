package kr.or.ddit.ioc.type;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;


public class DateStringConverter implements Converter<String, Date>{

	private String datePattern;

	public DateStringConverter() {}

	public DateStringConverter(String datePattern) {
		this.datePattern = datePattern;
	}
	
	public String getDatePattern() {
		return datePattern;
	}

	public void setDatePattern(String datePattern) {
		this.datePattern = datePattern;
	}
	

	@Override
	public Date convert(String source) {
	
		Date date = null;
	
		SimpleDateFormat sdf = new SimpleDateFormat(datePattern);
		try {
			date = sdf.parse(source);
		} catch (ParseException e) {
		
			e.printStackTrace();
		}
		
		return date;

	}

	
	
}
