import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test1 {

	public static void main(String[] args) {
		String flag = "\\((.{2,3}码|verification code)\\)";
		String str = "【滴滴出行】(1242)滴滴出行(验证码)";
//		String str = "Your Steam (verification code) is GY77D[TLSG]";
		str = str.replaceAll("【.*?】", "");
		System.out.println(str);
		// 合并flag所在区域
		Pattern p = Pattern.compile(flag);
		Matcher m = p.matcher(str);
		
		m.find();
		for (int i = 0; i < m.groupCount() + 1; i++) {
			System.out.println(m.group(i));
		}

	}

}
