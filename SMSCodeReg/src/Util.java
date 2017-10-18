import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2017/8/7.
 */

public class Util {
    private static final String TAG = "Util";

    private static final String reg = "(.*)([0-9]*)";
    private static final Pattern pattern = Pattern.compile(reg);

    /**
     * 鑾峰彇楠岃瘉鐭俊涓殑楠岃瘉鐮�
     *
     * @param msg
     * @return
     */
    public static String getCode(String msg) {

        if (TextUtils.isEmpty(msg)) return null;
        Matcher matcher = pattern.matcher(msg);
        if (!matcher.find()) return null;


        for (int i = 0; i < matcher.groupCount(); i++) {
        	System.out.println("group " + i + " " + matcher.group(i).toString());
        }
        if (matcher.groupCount() != 6) return null;

        String match2 = matcher.group(2);
        String match5 = matcher.group(5);
        if (!TextUtils.isEmpty(match2)) return match2;
        if (!TextUtils.isEmpty(match5)) return match5;

        return null;
    }
}
