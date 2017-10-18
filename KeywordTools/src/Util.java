import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter.DEFAULT;

/**
 * ���������������е�content�е�incl
 * 
 * @author makunle
 *
 */
public class Util {
	/**
	 * һ��һ���ؼ��ʣ��м�ʹ��','�ָ�
	 * incl:����,����;excl:������;
	 * @param file
	 * @return
	 */
	public static String getContent(String filePath) {
		File f = new File(filePath);
		try {
			InputStreamReader isr = new InputStreamReader(new FileInputStream(f), "UTF-8");
			BufferedReader br = new BufferedReader(isr);
			StringBuilder sb = new StringBuilder();
			String line;
			while ((line = br.readLine()) != null) {
				sb.append(line).append("").append(Constant.SEQ_COMMA);
			}
			br.close();
			sb.deleteCharAt(sb.length() - Constant.SEQ_COMMA.length());
			return sb.toString();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void setContentToFile(String string, File f) {
		try {
			if(f.exists()) {
				f.delete();
			}
			f.createNewFile();
			FileWriter fw = new FileWriter(f);
			fw.write(string);
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static int parseInt(String str, int def) {
		int re;
		try {
			re = Integer.parseInt(str);
		} catch (Exception e) {
			re = def;
		}
		return re;
	}
}
