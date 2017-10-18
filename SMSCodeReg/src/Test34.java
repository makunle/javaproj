import java.util.HashMap;
import java.util.Map;

public class Test34 {
	public static void main(String[] args) {
		Map<Integer, Boolean> am = new HashMap<>();
		am.put(1, true);
		Boolean a = am.get(1);
		System.out.println(!a);
	}
}
