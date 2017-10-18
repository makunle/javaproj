import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test2 {

	public static void main(String[] args) {

//		String digitNumStr = "11A11、22A22、33A33、44B44、55B55";
//		// String digitNumStr = "11A11";
//		Pattern digitNumP = Pattern.compile("(?<twoDigit>\\d{2})[A-Z]\\k<twoDigit>");
//		Matcher foundDigitNum = digitNumP.matcher(digitNumStr);
//
//		// Find all matches
//		while (foundDigitNum.find()) {
//			// Get the matching string
//			String digitNumList = foundDigitNum.group();
//			System.out.println(digitNumList);
//		}

		// TODO Auto-generated method stub
		String str = "【bong】742629（bong验证码）。(如非本人操作)，请忽略本短信。";
		String nameSurrond = "【(.*?)】 | \\[(.*?)\\] | （ (.*) ） | \\( (.*?) \\)";
		Matcher m = Pattern.compile(nameSurrond, Pattern.COMMENTS).matcher(str);
		String name = "";

		final String mayBeCode = "([a-zA-Z0-9]*)";
		final Pattern mayp = Pattern.compile(mayBeCode);

		while (m.find()) {
			for (int i = 1; i < m.groupCount() + 1; i++) {
				name = m.group(i);
				if(name != null) break;
			}
			if(name != null) {
				Matcher ma = mayp.matcher(name);
				System.out.println(name);
	
				if (!ma.matches()) {
					str = str.replaceAll(name, "");
				}
			}
		}
		System.out.println(name);
		// str = str.replaceAll(name, "");
		System.out.println(str);
	}

}
