package org.baseclasses;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public class Sample {
public static void main(String[] args) {
	String dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("ddMMyyyy_hhmmss"));
	System.out.println(dateTime);
	
	String random = UUID.randomUUID().toString();
	System.out.println(random);
}
}
