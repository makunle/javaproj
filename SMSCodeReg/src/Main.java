import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// InputStream inputStream;
		// try {
		// inputStream = new FileInputStream(new File("sms_code_sample.txt"));
		// InputStreamReader ir = new InputStreamReader(inputStream);
		// BufferedReader bs = new BufferedReader(ir);
		// String line;
		// while ((line = bs.readLine()) != null) {
		// if (!TextUtils.isEmpty(line)) {
		// System.out.println("get:"+line);
		// System.out.println(Util.getCode(line));
		// }
		// }
		// } catch (FileNotFoundException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// } catch (IOException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		String s = "你的验证码0x9Fg1.',是的";
		Pattern p = Pattern.compile("\\W*(\\w*)\\W*");
		Matcher m = p.matcher(s);
		System.out.println(m.matches());
		System.out.println(m.group(0) +"=========="+ m.group(1));
	}

}
