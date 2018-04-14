package android;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Q09_ValidatingEmailAddressesWithRegEx {
	
	final static Pattern EMAIL_PATTERN = Pattern.compile("[a-z]{1,6}(?:_[0-9]{0,4})?@hackerrank\\.com");

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in).useDelimiter(System.lineSeparator());
		int n = sc.nextInt();
		Matcher m = EMAIL_PATTERN.matcher("");
		while (n-- > 0) {
			System.out.println(m.reset(sc.next()).matches() ? "True" : "False");
		}
	}
}
