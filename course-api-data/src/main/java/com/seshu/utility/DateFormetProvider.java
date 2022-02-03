package com.seshu.utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class DateFormetProvider {
	
	public Date formatDate(String inputDate) throws ParseException {
		
		
		    Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(inputDate);		   
		return date1;
		
	}

}
