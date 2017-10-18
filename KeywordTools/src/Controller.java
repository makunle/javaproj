import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;

public class Controller {

	private Ui ui;

	private String blackFile;
	private String whiteFile;

	public Controller(Ui ui) {
		this.ui = ui;
	}

	public String loadWhiteListFile() {
		whiteFile = choseTxtFile();
		return whiteFile;
	}

	public void editWhiteListFile(String path) {
		whiteFile = openFileEditor(path, "wl.txt");
		ui.txWhiteListFile.setText(whiteFile);
	}

	public String loadBlackListFile() {
		blackFile = choseTxtFile();
		return blackFile;
	}

	public void editBlackListFile(String path) {
		blackFile = openFileEditor(path, "bk.txt");
		ui.txBlackListFile.setText(blackFile);
	}

	private String choseTxtFile() {
		JFileChooser jc = new JFileChooser();
		jc.setFileFilter(new FileFilter() {
			@Override
			public String getDescription() {
				return "*.txt";
			}

			@Override
			public boolean accept(File f) {
				return true;
			}
		});
		jc.showOpenDialog(null);
		if (jc.getSelectedFile() != null) {
			return jc.getSelectedFile().getAbsolutePath();
		}
		return null;
	}

	private String openFileEditor(String path, String defalutName) {
		File f = new File(path);
		if (f == null || !f.exists()) {
			String folder = System.getProperty("java.io.tmpdir");
			f = new File(folder + "\\" + defalutName);
			try {
				f.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try {
			Desktop.getDesktop().open(f);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return f.getAbsolutePath();
	}

	public void generateContent() {
		String bkStr = null;
		String wtStr = null;
		if (blackFile != null) {
			File bk = new File(blackFile);
			if (bk.exists()) {
				bkStr = Util.getContent(bk.getAbsolutePath());
			}
		}
		if (whiteFile != null) {
			File wt = new File(whiteFile);
			if (wt.exists()) {
				wtStr = Util.getContent(wt.getAbsolutePath());
			}
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(DLINE).append("scene:").append(LINE).append(EMPTY);
		sb.append(DLINE).append("content:").append(LINE);
	
		if(bkStr != null && bkStr.length() > 0) {
			appendToSb(Constant.BLACK_LIST, bkStr, sb);
		}
		if(wtStr != null && wtStr.length() > 0) {
			appendToSb(Constant.WHITE_LIST, wtStr, sb);
		}
		
		int minLen = Util.parseInt(ui.txMinLen.getText(), Constant.DEF_MINLEN);
		int maxLen = Util.parseInt(ui.txMaxLen.getText(), Constant.DEF_MAXLEN);
		
		appendToSb(Constant.MINLEN, "" + minLen, sb);
		appendToSb(Constant.MAXLEN, "" + maxLen, sb);
		
		sb.append(DLINE).append("uptime:").append(LINE).append(EMPTY);
		sb.append(DLINE).append("begintime:").append(LINE).append("2017-10-01 00:00:00");
		sb.append(DLINE).append("endtime:").append(LINE).append("2017-12-01 00:00:00");
		sb.append(DLINE).append("day:").append(LINE).append(EMPTY);
		sb.append(DLINE).append("net:").append(LINE).append("0");
		sb.append(DLINE).append("appuse:").append(LINE).append(EMPTY);
		
		String folder = System.getProperty("java.io.tmpdir");
		File f = new File(folder + "\\" + "res.txt");
		Util.setContentToFile(sb.toString(), f);
		try {
			Desktop.getDesktop().open(f);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static final String LINE = "\n";
	private static final String DLINE = "\n\n";
	private static final String EMPTY = "\"\"";
	
	private void appendToSb(String key, String value, StringBuilder sb) {
		sb.append(key)
		.append(Constant.SEQ_COLON)
		.append(value)
		.append(Constant.SEQ_SEMICOLON);
	}
}
