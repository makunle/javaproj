import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLayeredPane;

public class Ui {

	private JFrame frame;
	JTextField txWhiteListFile;
	JTextField txBlackListFile;

	private Controller controller;
	JTextField txMinLen;
	JTextField txMaxLen;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ui window = new Ui();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Ui() {
		initialize();
		controller = new Controller(this);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		UIManager.LookAndFeelInfo[] info = UIManager.getInstalledLookAndFeels();
		for (UIManager.LookAndFeelInfo tem : info) {
			System.out.println(tem.getClassName());
		}

		try {
//			UIManager.setLookAndFeel(info[3].getClassName());
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e1) {
			e1.printStackTrace();
		}

		frame = new JFrame();
		frame.setTitle("\u5173\u952E\u8BCD\u914D\u7F6E\u5185\u5BB9\u751F\u6210\u5668");
		frame.setBounds(100, 100, 357, 204);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel label = new JLabel("\u767D\u540D\u5355\uFF1A");

		txWhiteListFile = new JTextField();
		txWhiteListFile.setEditable(false);
		txWhiteListFile.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String path = controller.loadWhiteListFile();
				if (path != null) {
					txWhiteListFile.setText(path);
				}
			}
		});
		txWhiteListFile.setColumns(10);

		JButton btnEditWhiteList = new JButton("\u7F16\u8F91");
		btnEditWhiteList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String path = txWhiteListFile.getText();
				controller.editWhiteListFile(path);
			}
		});

		JLabel label_1 = new JLabel("\u9ED1\u540D\u5355\uFF1A");

		txBlackListFile = new JTextField();
		txBlackListFile.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String path = controller.loadBlackListFile();
				if (path != null) {
					txWhiteListFile.setText(path);
				}
			}
		});
		txBlackListFile.setEditable(false);
		txBlackListFile.setColumns(10);

		JButton btnEditBlackList = new JButton("\u7F16\u8F91");
		btnEditBlackList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String path = txBlackListFile.getText();
				controller.editBlackListFile(path);
			}
		});

		JButton btnGenerateContent = new JButton("\u751F\u6210content");
		btnGenerateContent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.generateContent();
			}
		});

		JLabel label_2 = new JLabel("\u6587\u672C\u957F\u5EA6");

		JLabel lblMin = new JLabel("min");

		txMinLen = new JTextField();
		txMinLen.setText("2");
		txMinLen.setColumns(10);

		JLabel lblMax = new JLabel("max");

		txMaxLen = new JTextField();
		txMaxLen.setText("100");
		txMaxLen.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup()
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING, groupLayout
						.createSequentialGroup().addGap(10)
						.addGroup(groupLayout
								.createParallelGroup(Alignment.LEADING).addComponent(label).addComponent(label_1))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(txWhiteListFile, GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
								.addComponent(txBlackListFile, GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
								.addGroup(groupLayout.createSequentialGroup().addComponent(lblMin)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(txMinLen, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addGap(21).addComponent(lblMax).addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(txMaxLen, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(btnEditBlackList)
								.addComponent(btnEditWhiteList)))
						.addGroup(groupLayout.createSequentialGroup().addContainerGap().addComponent(label_2))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup().addContainerGap()
								.addComponent(btnGenerateContent, GroupLayout.DEFAULT_SIZE, 321, Short.MAX_VALUE)))
				.addContainerGap()));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup()
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
						.createSequentialGroup().addGap(43)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(label_1)
								.addComponent(txBlackListFile, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(btnEditBlackList)))
						.addGroup(groupLayout.createSequentialGroup().addContainerGap()
								.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(label)
										.addComponent(txWhiteListFile, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(btnEditWhiteList))))
				.addPreferredGap(ComponentPlacement.RELATED).addComponent(label_2).addGap(7)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblMin)
						.addComponent(txMinLen, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(lblMax).addComponent(txMaxLen, GroupLayout.PREFERRED_SIZE,
								GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(18).addComponent(btnGenerateContent, GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
				.addGap(38)));
		frame.getContentPane().setLayout(groupLayout);
	}
}
