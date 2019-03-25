package testing;

import java.security.SecureRandom;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;

import com.lodborg.intervaltree.DateInterval;
import com.lodborg.intervaltree.IntervalTree;



public class TestFunction {


	public static final String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

	public static final String lower = upper.toLowerCase(Locale.ROOT);

	public static final String digits = "0123456789";

	public static final String alphanum = upper + lower + digits;



	public static String random() {
		SecureRandom generator = new SecureRandom();
		StringBuilder randomStringBuilder = new StringBuilder();
		for (int i = 0; i < 32; i++){
			randomStringBuilder.append(alphanum.charAt(generator.nextInt(alphanum.length())));
		}
		return randomStringBuilder.toString();
	}

	public static void main(String[] args) {
		String b64 = "mock-mtn";

//		System.out.println(Base);

	}

}
