package in.com.prestige.testbasic;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestDate {
	public static void main(String[] args) throws ParseException {
       Date d = new Date();
       SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
       System.out.println(format.format(d));
       System.out.println(format.parse("22/5/1994"));
       System.out.println(format.format(format.parse("22/05/1994")));
	}
}
