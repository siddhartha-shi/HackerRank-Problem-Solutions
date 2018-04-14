package iOS;

import java.util.ArrayList;
import java.util.Scanner;

public class Q20_MagicalVowels {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		String teString = in.nextLine();
		char[] sid = teString.toLowerCase().toCharArray();
		String resultStr = getMagicalVowels(sid);
		System.out.println(resultStr.length());
	}

	static String getMagicalVowels(char[] sid) {
		String resStr = "";
		int index = -1;
		ArrayList<Character> voiel = new ArrayList<>();
		voiel.add('a');
		voiel.add('e');
		voiel.add('i');
		voiel.add('o');
		voiel.add('u');

		for (char c : sid) {
			int pos = voiel.indexOf(c);
			if (pos != -1) {
				if (index == -1) {
					index = pos;
					resStr += c;
				} else if (pos >= index) {
					resStr += c;
					index = pos;
				}
			}
		}
		return resStr;
	}
}
