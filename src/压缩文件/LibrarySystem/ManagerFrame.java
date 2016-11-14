package LibrarySystem;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.TextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;

import java.awt.CardLayout;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

import javax.swing.Action;
import java.awt.Font;

public class ManagerFrame {

	public JFrame frame;
	private LibraryDatabase libraryDatabase;
	private JTextField txtId;
	private JTextField txtName;
	private JComboBox comboBox;
	private JPasswordField pwdPasswd;
	private JPasswordField pwdRepasswd;
	private JTextField txtIsbn;
	private JTextField txtName_1;
	private JTextField txtAuthor;
	private JTextField txtPress;
	private JTextField txtYear;
	private JTextField txtMonth;
	private JTextField txtIntegrity;
	private JTextField txtIsbnorid;
	private CardLayout cardLayout = new CardLayout(0, 0);
	private JPanel panel_13;
	private final Action action = new SwingAction_1();
	private JPanel panel_21;
	private JPanel panel_22;
	private JPanel panel_23;
	private JPanel panel_24;
	private JPanel panel_25;
	private JPanel panel_26;
	private JPanel panel_27;
	private JPanel panel_28;
	private JPanel panel_29;
	private JPanel panel_30;
	private JPanel panel_31;
	private JLabel lblNewLabel;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel lblIsbn_1;
	private JLabel lblIsbn_2;
	private JLabel lblIsbn_3;
	private JLabel lblName;
	private JLabel lblName_1;
	private JLabel lblName_2;
	private JLabel lblAuthor;
	private JLabel lblAuthor_1;
	private JLabel lblAuthor_2;
	private JLabel lblPress;
	private JLabel lblPress_1;
	private JLabel lblPress_2;
	private JLabel lblDate;
	private JLabel lblDate_1;
	private JLabel lblDate_2;
	private JLabel lblIntegrity;
	private JLabel lblIntegrity_1;
	private JLabel lblIntegrity_2;
	private JLabel lblDate_3;
	private JLabel lblDate_4;
	private JLabel lblDate_5;
	private JButton button_5;
	private JButton button_6;
	private JButton button_7;
	private JPanel panel_5;
	private JLabel lblIsbn;
	private JTextField txtIsbn_1;
	private JTextField txtIsbn_2;
	private JTextField txtIsbn_3;
	private TextField textField;
	private final Action action_1 = new SwingAction_2();
	private Person manager;
	private final Action action_2 = new SwingAction_3();
	private final Action action_3 = new SwingAction_4();
	
	/**
	 * Create the application.
	 */
	public ManagerFrame(LibraryDatabase libraryDatabase, Person manager) {
		this.libraryDatabase = libraryDatabase;
		this.manager = manager;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		BorderLayout borderLayout = (BorderLayout) frame.getContentPane().getLayout();
		borderLayout.setHgap(10);
		frame.setTitle("\u56FE\u4E66\u9986\u7BA1\u7406\u7CFB\u7EDF");
		frame.setResizable(false);
		frame.setBounds(100, 100, 1419, 431);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.WEST);
		panel.setLayout(new GridLayout(0, 1, 10, 0));
		
		JButton borrowButton = new JButton("\u501F\u4E66/\u8FD8\u4E66");
		borrowButton.setAction(new SwingAction("borrow", "借书/还书"));
		panel.add(borrowButton);
		
		JButton newUserButton = new JButton("\u65B0\u7528\u6237");
		newUserButton.setAction(new SwingAction("newUser", "新用户"));
		panel.add(newUserButton);
		
		JButton newBookButton = new JButton("\u65B0\u4E66");
		newBookButton.setAction(new SwingAction("newBook", "新书"));
		panel.add(newBookButton);
		
		JButton historyButton = new JButton("\u5386\u53F2\u8BB0\u5F55");
		historyButton.setAction(new SwingAction("history", "历史记录"));
		panel.add(historyButton);
		
		panel_13 = new JPanel();
		frame.getContentPane().add(panel_13, BorderLayout.CENTER);
		panel_13.setLayout(cardLayout);
		
		JPanel borrowPanel = new JPanel();
		panel_13.add(borrowPanel, "borrow");
		borrowPanel.setLayout(new BorderLayout(0, 10));
		
		JPanel panel_2 = new JPanel();
		borrowPanel.add(panel_2, BorderLayout.NORTH);
		
		Label label = new Label("\u7528\u6237ID\uFF1A");
		panel_2.add(label);
		
		textField = new TextField();
		textField.setColumns(18);
		panel_2.add(textField);
		
		JButton button_4 = new JButton("\u786E\u5B9A");
		button_4.setAction(action_1);
		panel_2.add(button_4);
		
		JPanel panel_3 = new JPanel();
		borrowPanel.add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(new GridLayout(0, 1, 0, 0));
		
		lblNewLabel = new JLabel("ID\uFF1A");
		panel_3.add(lblNewLabel);
		
		label_1 = new JLabel("\u59D3\u540D\uFF1A");
		panel_3.add(label_1);
		
		label_2 = new JLabel("\u7528\u6237\u7C7B\u578B\uFF1A");
		panel_3.add(label_2);
		
		JPanel panel_4 = new JPanel();
		borrowPanel.add(panel_4, BorderLayout.SOUTH);
		panel_4.setLayout(new GridLayout(0, 8, 0, 0));
		
		panel_5 = new JPanel();
		panel_4.add(panel_5);
		panel_5.setLayout(new BoxLayout(panel_5, BoxLayout.Y_AXIS));
		
		lblIsbn = new JLabel("ISBN");
		lblIsbn.setHorizontalAlignment(SwingConstants.CENTER);
		panel_5.add(lblIsbn);
		
		lblIsbn_1 = new JLabel(" ");
		lblIsbn_1.setFont(new Font("宋体", Font.PLAIN, 22));
		panel_5.add(lblIsbn_1);
		
		lblIsbn_2 = new JLabel(" ");
		lblIsbn_2.setFont(new Font("宋体", Font.PLAIN, 22));
		panel_5.add(lblIsbn_2);
		
		lblIsbn_3 = new JLabel(" ");
		lblIsbn_3.setFont(new Font("宋体", Font.PLAIN, 22));
		panel_5.add(lblIsbn_3);
		
		txtIsbn_1 = new JTextField();
		txtIsbn_1.setColumns(13);
		txtIsbn_2 = new JTextField();
		txtIsbn_2.setColumns(13);
		txtIsbn_3 = new JTextField();
		txtIsbn_3.setColumns(13);
		
		JPanel panel_6 = new JPanel();
		panel_4.add(panel_6);
		panel_6.setLayout(new BoxLayout(panel_6, BoxLayout.Y_AXIS));
		
		JLabel label_3 = new JLabel("\u4E66\u540D");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		panel_6.add(label_3);
		
		lblName = new JLabel(" ");
		lblName.setFont(new Font("宋体", Font.PLAIN, 22));
		panel_6.add(lblName);
		
		lblName_1 = new JLabel(" ");
		lblName_1.setFont(new Font("宋体", Font.PLAIN, 22));
		panel_6.add(lblName_1);
		
		lblName_2 = new JLabel(" ");
		lblName_2.setFont(new Font("宋体", Font.PLAIN, 22));
		panel_6.add(lblName_2);
		
		JPanel panel_7 = new JPanel();
		panel_4.add(panel_7);
		panel_7.setLayout(new BoxLayout(panel_7, BoxLayout.Y_AXIS));
		
		JLabel label_4 = new JLabel("\u4F5C\u8005");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		panel_7.add(label_4);
		
		lblAuthor = new JLabel(" ");
		lblAuthor.setFont(new Font("宋体", Font.PLAIN, 22));
		panel_7.add(lblAuthor);
		
		lblAuthor_1 = new JLabel(" ");
		lblAuthor_1.setFont(new Font("宋体", Font.PLAIN, 22));
		panel_7.add(lblAuthor_1);
		
		lblAuthor_2 = new JLabel(" ");
		lblAuthor_2.setFont(new Font("宋体", Font.PLAIN, 22));
		panel_7.add(lblAuthor_2);
		
		JPanel panel_8 = new JPanel();
		panel_4.add(panel_8);
		panel_8.setLayout(new BoxLayout(panel_8, BoxLayout.Y_AXIS));
		
		JLabel label_5 = new JLabel("\u51FA\u7248\u793E");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		panel_8.add(label_5);
		
		lblPress = new JLabel(" ");
		lblPress.setFont(new Font("宋体", Font.PLAIN, 22));
		panel_8.add(lblPress);
		
		lblPress_1 = new JLabel(" ");
		lblPress_1.setFont(new Font("宋体", Font.PLAIN, 22));
		panel_8.add(lblPress_1);
		
		lblPress_2 = new JLabel(" ");
		lblPress_2.setFont(new Font("宋体", Font.PLAIN, 22));
		panel_8.add(lblPress_2);
		
		JPanel panel_9 = new JPanel();
		panel_4.add(panel_9);
		panel_9.setLayout(new BoxLayout(panel_9, BoxLayout.Y_AXIS));
		
		JLabel label_6 = new JLabel("\u51FA\u7248\u65E5\u671F");
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		panel_9.add(label_6);
		
		lblDate = new JLabel(" ");
		lblDate.setFont(new Font("宋体", Font.PLAIN, 22));
		panel_9.add(lblDate);
		
		lblDate_1 = new JLabel(" ");
		lblDate_1.setFont(new Font("宋体", Font.PLAIN, 22));
		panel_9.add(lblDate_1);
		
		lblDate_2 = new JLabel(" ");
		lblDate_2.setFont(new Font("宋体", Font.PLAIN, 22));
		panel_9.add(lblDate_2);
		
		JPanel panel_10 = new JPanel();
		panel_4.add(panel_10);
		panel_10.setLayout(new BoxLayout(panel_10, BoxLayout.Y_AXIS));
		
		JLabel label_7 = new JLabel("\u5B8C\u597D\u7A0B\u5EA6");
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		panel_10.add(label_7);
		
		lblIntegrity = new JLabel(" ");
		lblIntegrity.setFont(new Font("宋体", Font.PLAIN, 22));
		panel_10.add(lblIntegrity);
		
		lblIntegrity_1 = new JLabel(" ");
		lblIntegrity_1.setFont(new Font("宋体", Font.PLAIN, 22));
		panel_10.add(lblIntegrity_1);
		
		lblIntegrity_2 = new JLabel(" ");
		lblIntegrity_2.setFont(new Font("宋体", Font.PLAIN, 22));
		panel_10.add(lblIntegrity_2);
		
		JPanel panel_11 = new JPanel();
		panel_4.add(panel_11);
		panel_11.setLayout(new BoxLayout(panel_11, BoxLayout.Y_AXIS));
		
		JLabel label_8 = new JLabel("\u501F\u51FA\u65E5\u671F");
		label_8.setHorizontalAlignment(SwingConstants.CENTER);
		panel_11.add(label_8);
		
		lblDate_3 = new JLabel(" ");
		lblDate_3.setFont(new Font("宋体", Font.PLAIN, 22));
		panel_11.add(lblDate_3);
		
		lblDate_4 = new JLabel(" ");
		lblDate_4.setFont(new Font("宋体", Font.PLAIN, 22));
		panel_11.add(lblDate_4);
		
		lblDate_5 = new JLabel(" ");
		lblDate_5.setFont(new Font("宋体", Font.PLAIN, 22));
		panel_11.add(lblDate_5);
		
		JPanel panel_12 = new JPanel();
		panel_4.add(panel_12);
		panel_12.setLayout(new BoxLayout(panel_12, BoxLayout.Y_AXIS));
		
		JLabel label_9 = new JLabel("\u64CD\u4F5C");
		label_9.setHorizontalAlignment(SwingConstants.CENTER);
		panel_12.add(label_9);
		
		button_5 = new JButton("\u501F\u4E66");
		button_5.setEnabled(false);
		panel_12.add(button_5);
		
		button_6 = new JButton("\u501F\u4E66");
		button_6.setEnabled(false);
		panel_12.add(button_6);
		
		button_7 = new JButton("\u501F\u4E66");
		button_7.setEnabled(false);
		panel_12.add(button_7);
		
		JPanel newUserPanel = new JPanel();
		panel_13.add(newUserPanel, "newUser");
		newUserPanel.setLayout(new BorderLayout(10, 0));
		
		JPanel panel_1 = new JPanel();
		newUserPanel.add(panel_1, BorderLayout.WEST);
		panel_1.setLayout(new GridLayout(0, 1, 0, 20));
		
		JLabel lblId = new JLabel("ID\uFF1A");
		lblId.setHorizontalAlignment(SwingConstants.TRAILING);
		panel_1.add(lblId);
		
		JLabel label_10 = new JLabel("\u59D3\u540D\uFF1A");
		label_10.setHorizontalAlignment(SwingConstants.TRAILING);
		panel_1.add(label_10);
		
		JLabel label_11 = new JLabel("\u7528\u6237\u7C7B\u578B\uFF1A");
		label_11.setHorizontalAlignment(SwingConstants.TRAILING);
		panel_1.add(label_11);
		
		JLabel label_12 = new JLabel("\u5BC6\u7801\uFF1A");
		label_12.setHorizontalAlignment(SwingConstants.TRAILING);
		panel_1.add(label_12);
		
		JLabel label_13 = new JLabel("\u91CD\u65B0\u8F93\u5165\u5BC6\u7801\uFF1A");
		label_13.setHorizontalAlignment(SwingConstants.TRAILING);
		panel_1.add(label_13);
		
		JLabel label_14 = new JLabel("");
		panel_1.add(label_14);
		
		JPanel panel_14 = new JPanel();
		newUserPanel.add(panel_14, BorderLayout.CENTER);
		panel_14.setLayout(new GridLayout(0, 1, 0, 20));
		
		txtId = new JTextField();
		panel_14.add(txtId);
		txtId.setColumns(10);
		
		txtName = new JTextField();
		panel_14.add(txtName);
		txtName.setColumns(10);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"\u5B66\u751F", "\u7BA1\u7406\u5458"}));
		panel_14.add(comboBox);
		
		pwdPasswd = new JPasswordField();
		panel_14.add(pwdPasswd);
		
		pwdRepasswd = new JPasswordField();
		panel_14.add(pwdRepasswd);
		
		JButton button = new JButton("\u63D0\u4EA4");
		button.setAction(action_2);
		panel_14.add(button);
		
		JPanel newBookPanel = new JPanel();
		panel_13.add(newBookPanel, "newBook");
		newBookPanel.setLayout(new BorderLayout(0, 10));
		
		JPanel panel_15 = new JPanel();
		newBookPanel.add(panel_15, BorderLayout.WEST);
		panel_15.setLayout(new GridLayout(0, 1, 0, 10));
		
		JLabel lblIsbn_4 = new JLabel("ISBN\uFF1A");
		lblIsbn_4.setHorizontalAlignment(SwingConstants.TRAILING);
		panel_15.add(lblIsbn_4);
		
		JLabel label_15 = new JLabel("\u4E66\u540D\uFF1A");
		label_15.setHorizontalAlignment(SwingConstants.TRAILING);
		panel_15.add(label_15);
		
		JLabel label_16 = new JLabel("\u4F5C\u8005\uFF1A");
		label_16.setHorizontalAlignment(SwingConstants.TRAILING);
		panel_15.add(label_16);
		
		JLabel label_17 = new JLabel("\u51FA\u7248\u793E\uFF1A");
		label_17.setHorizontalAlignment(SwingConstants.TRAILING);
		panel_15.add(label_17);
		
		JLabel label_18 = new JLabel("\u51FA\u7248\u65E5\u671F\uFF1A");
		label_18.setHorizontalAlignment(SwingConstants.TRAILING);
		panel_15.add(label_18);
		
		JLabel label_19 = new JLabel("\u5B8C\u597D\u7A0B\u5EA6\uFF1A");
		label_19.setHorizontalAlignment(SwingConstants.TRAILING);
		panel_15.add(label_19);
		
		JLabel label_20 = new JLabel("");
		label_20.setHorizontalAlignment(SwingConstants.TRAILING);
		panel_15.add(label_20);
		
		JPanel panel_16 = new JPanel();
		newBookPanel.add(panel_16, BorderLayout.CENTER);
		panel_16.setLayout(new GridLayout(0, 1, 0, 10));
		
		txtIsbn = new JTextField();
		panel_16.add(txtIsbn);
		txtIsbn.setColumns(10);
		
		txtName_1 = new JTextField();
		panel_16.add(txtName_1);
		txtName_1.setColumns(10);
		
		txtAuthor = new JTextField();
		panel_16.add(txtAuthor);
		txtAuthor.setColumns(10);
		
		txtPress = new JTextField();
		panel_16.add(txtPress);
		txtPress.setColumns(10);
		
		JPanel panel_17 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_17.getLayout();
		flowLayout.setAlignment(FlowLayout.LEADING);
		panel_16.add(panel_17);
		
		txtYear = new JTextField();
		panel_17.add(txtYear);
		txtYear.setColumns(4);
		
		JLabel label_21 = new JLabel("\u5E74");
		panel_17.add(label_21);
		
		txtMonth = new JTextField();
		panel_17.add(txtMonth);
		txtMonth.setColumns(2);
		
		JLabel label_22 = new JLabel("\u6708");
		panel_17.add(label_22);
		
		txtIntegrity = new JTextField();
		panel_16.add(txtIntegrity);
		txtIntegrity.setColumns(10);
		
		JButton button_1 = new JButton("\u63D0\u4EA4");
		button_1.setAction(action_3);
		panel_16.add(button_1);
		
		JPanel historyPanel = new JPanel();
		panel_13.add(historyPanel, "history");
		historyPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_18 = new JPanel();
		historyPanel.add(panel_18, BorderLayout.NORTH);
		
		JLabel lblIsbnid = new JLabel("ISBN/ID\uFF1A");
		panel_18.add(lblIsbnid);
		
		txtIsbnorid = new JTextField();
		panel_18.add(txtIsbnorid);
		txtIsbnorid.setColumns(20);
		
		JButton button_2 = new JButton("\u67E5\u8BE2");
		button_2.setAction(action);
		panel_18.add(button_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		historyPanel.add(scrollPane, BorderLayout.CENTER);
		
		JPanel panel_19 = new JPanel();
		scrollPane.setColumnHeaderView(panel_19);
		panel_19.setLayout(new GridLayout(0, 11, 0, 0));
		
		JLabel lblId_1 = new JLabel("\u5E8F\u53F7");
		lblId_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_19.add(lblId_1);
		
		JLabel lblDate_6 = new JLabel("\u65E5\u671F");
		lblDate_6.setHorizontalAlignment(SwingConstants.CENTER);
		panel_19.add(lblDate_6);
		
		JLabel lblType = new JLabel("\u7C7B\u578B");
		lblType.setHorizontalAlignment(SwingConstants.CENTER);
		panel_19.add(lblType);
		
		JLabel lblIsbn_5 = new JLabel("ISBN");
		lblIsbn_5.setHorizontalAlignment(SwingConstants.CENTER);
		panel_19.add(lblIsbn_5);
		
		JLabel lblBookname = new JLabel("\u4E66\u540D");
		lblBookname.setHorizontalAlignment(SwingConstants.CENTER);
		panel_19.add(lblBookname);
		
		JLabel lblUserid = new JLabel("\u7528\u6237ID");
		lblUserid.setHorizontalAlignment(SwingConstants.CENTER);
		panel_19.add(lblUserid);
		
		JLabel lblUsername = new JLabel("\u7528\u6237\u540D");
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		panel_19.add(lblUsername);
		
		JLabel lblManagerid = new JLabel("\u7BA1\u7406\u5458ID");
		lblManagerid.setHorizontalAlignment(SwingConstants.CENTER);
		panel_19.add(lblManagerid);
		
		JLabel lblManagername = new JLabel("\u7BA1\u7406\u5458\u540D");
		lblManagername.setHorizontalAlignment(SwingConstants.CENTER);
		panel_19.add(lblManagername);
		
		JLabel lblBeforeintegrity = new JLabel("\u4E4B\u524D\u5B8C\u597D\u5EA6");
		lblBeforeintegrity.setHorizontalAlignment(SwingConstants.CENTER);
		panel_19.add(lblBeforeintegrity);
		
		JLabel lblAfterintegrity = new JLabel("\u4E4B\u540E\u5B8C\u597D\u5EA6");
		lblAfterintegrity.setHorizontalAlignment(SwingConstants.CENTER);
		panel_19.add(lblAfterintegrity);
		
		JPanel panel_20 = new JPanel();
		scrollPane.setViewportView(panel_20);
		panel_20.setLayout(new GridLayout(0, 11, 0, 0));
		
		panel_21 = new JPanel();
		panel_20.add(panel_21);
		panel_21.setLayout(new BoxLayout(panel_21, BoxLayout.Y_AXIS));
		
		panel_22 = new JPanel();
		panel_20.add(panel_22);
		panel_22.setLayout(new BoxLayout(panel_22, BoxLayout.Y_AXIS));
		
		panel_23 = new JPanel();
		panel_20.add(panel_23);
		panel_23.setLayout(new BoxLayout(panel_23, BoxLayout.Y_AXIS));
		
		panel_24 = new JPanel();
		panel_20.add(panel_24);
		panel_24.setLayout(new BoxLayout(panel_24, BoxLayout.Y_AXIS));
		
		panel_25 = new JPanel();
		panel_20.add(panel_25);
		panel_25.setLayout(new BoxLayout(panel_25, BoxLayout.Y_AXIS));
		
		panel_26 = new JPanel();
		panel_20.add(panel_26);
		panel_26.setLayout(new BoxLayout(panel_26, BoxLayout.Y_AXIS));
		
		panel_27 = new JPanel();
		panel_20.add(panel_27);
		panel_27.setLayout(new BoxLayout(panel_27, BoxLayout.Y_AXIS));
		
		panel_28 = new JPanel();
		panel_20.add(panel_28);
		panel_28.setLayout(new BoxLayout(panel_28, BoxLayout.Y_AXIS));
		
		panel_29 = new JPanel();
		panel_20.add(panel_29);
		panel_29.setLayout(new BoxLayout(panel_29, BoxLayout.Y_AXIS));
		
		panel_30 = new JPanel();
		panel_20.add(panel_30);
		panel_30.setLayout(new BoxLayout(panel_30, BoxLayout.Y_AXIS));
		
		panel_31 = new JPanel();
		panel_20.add(panel_31);
		panel_31.setLayout(new BoxLayout(panel_31, BoxLayout.Y_AXIS));
	}
	
	private void updateUser(String userId){
		for(int i = userId.length()-1; i >= 0; --i){
			if(!Character.isDigit(userId.charAt(i))){
				JOptionPane.showMessageDialog(frame, "用户不存在");
				return;
			}
		}
		Person person = libraryDatabase.getPerson(userId);
		if(person != null){
			lblNewLabel.setText("ID:" + person.getId());
			label_1.setText("姓名：" + person.getName());
			if(person.getIdType() == Person.MANAGER){
				label_2.setText("用户类型：管理员");
				//lblIsbn_1.setText("无");
				//lblIsbn_2.setText("无");
				//lblIsbn_3.setText("无");
				panel_5.removeAll();
				panel_5.add(lblIsbn);
				panel_5.repaint();
				lblName.setText("");
				lblName_1.setText("");
				lblName_2.setText("");
				lblAuthor.setText("");
				lblAuthor_1.setText("");
				lblAuthor_2.setText("");
				lblPress.setText("");
				lblPress_1.setText("");
				lblPress_2.setText("");
				lblDate.setText("");
				lblDate_1.setText("");
				lblDate_2.setText("");
				lblIntegrity.setText("");
				lblIntegrity_1.setText("");
				lblIntegrity_2.setText("");
				lblDate_3.setText("");
				lblDate_4.setText("");
				lblDate_5.setText("");
				button_5.setText("借书");
				button_6.setText("借书");
				button_7.setText("借书");
				button_5.setEnabled(false);
				button_6.setEnabled(false);
				button_7.setEnabled(false);
				
			}
			else{
				label_2.setText("用户类型：学生");
				if(person.getLentA().equals("0")){
					panel_5.removeAll();
					panel_5.add(lblIsbn);
					panel_5.add(txtIsbn_1);
					panel_5.add(txtIsbn_2);
					panel_5.add(txtIsbn_3);
					panel_5.repaint();
					button_5.setText("借书");
					button_5.setAction(new borrowAction(txtIsbn_1, person.getId()));
					button_6.setText("借书");
					button_7.setText("借书");
					button_5.setEnabled(true);
					button_6.setEnabled(false);
					button_7.setEnabled(false);
					lblName.setText("");
					lblName_1.setText("");
					lblName_2.setText("");
					lblAuthor.setText("");
					lblAuthor_1.setText("");
					lblAuthor_2.setText("");
					lblPress.setText("");
					lblPress_1.setText("");
					lblPress_2.setText("");
					lblDate.setText("");
					lblDate_1.setText("");
					lblDate_2.setText("");
					lblIntegrity.setText("");
					lblIntegrity_1.setText("");
					lblIntegrity_2.setText("");
					lblDate_3.setText("");
					lblDate_4.setText("");
					lblDate_5.setText("");
				}
				else if(person.getLentB().equals("0")){
					Book book = libraryDatabase.getBook(person.getLentA());
					panel_5.removeAll();
					panel_5.add(lblIsbn);
					lblIsbn_1.setText(book.getIsbn());
					panel_5.add(lblIsbn_1);
					panel_5.add(txtIsbn_2);
					panel_5.add(txtIsbn_3);
					panel_5.repaint();
					button_5.setText("还书");
					button_5.setAction(new returnAction(book.getIsbn(), person.getId()));
					button_6.setText("借书");
					button_6.setAction(new borrowAction(txtIsbn_2, person.getId()));
					button_7.setText("借书");
					button_5.setEnabled(true);
					button_6.setEnabled(true);
					button_7.setEnabled(false);
					lblName.setText(book.getName());
					lblName_1.setText("");
					lblName_2.setText("");
					lblAuthor.setText(book.getAuthor());
					lblAuthor_1.setText("");
					lblAuthor_2.setText("");
					lblPress.setText(book.getPress());
					lblPress_1.setText("");
					lblPress_2.setText("");
					lblDate.setText(String.valueOf(book.getPublicationDate()));
					lblDate_1.setText("");
					lblDate_2.setText("");
					lblIntegrity.setText(String.valueOf(book.getIntegrity()));
					lblIntegrity_1.setText("");
					lblIntegrity_2.setText("");
					lblDate_3.setText(String.valueOf(person.getLentADate()));
					lblDate_4.setText("");
					lblDate_5.setText("");
				}
				else if(person.getLentC().equals("0")){
					Book book1 = libraryDatabase.getBook(person.getLentA());
					Book book2 = libraryDatabase.getBook(person.getLentB());
					panel_5.removeAll();
					panel_5.add(lblIsbn);
					lblIsbn_1.setText(book1.getIsbn());
					lblIsbn_2.setText(book2.getIsbn());
					panel_5.add(lblIsbn_1);
					panel_5.add(lblIsbn_2);
					panel_5.add(txtIsbn_3);
					panel_5.repaint();
					button_5.setText("还书");
					button_5.setAction(new returnAction(book1.getIsbn(), person.getId()));
					button_6.setText("还书");
					button_6.setAction(new returnAction(book2.getIsbn(), person.getId()));
					button_7.setText("借书");
					button_7.setAction(new borrowAction(txtIsbn_3, person.getId()));
					button_5.setEnabled(true);
					button_6.setEnabled(true);
					button_7.setEnabled(true);
					lblName.setText(book1.getName());
					lblName_1.setText(book2.getName());
					lblName_2.setText("");
					lblAuthor.setText(book1.getAuthor());
					lblAuthor_1.setText(book2.getAuthor());
					lblAuthor_2.setText("");
					lblPress.setText(book1.getPress());
					lblPress_1.setText(book2.getPress());
					lblPress_2.setText("");
					lblDate.setText(String.valueOf(book1.getPublicationDate()));
					lblDate_1.setText(String.valueOf(book2.getPublicationDate()));
					lblDate_2.setText("");
					lblIntegrity.setText(String.valueOf(book1.getIntegrity()));
					lblIntegrity_1.setText(String.valueOf(book2.getIntegrity()));
					lblIntegrity_2.setText("");
					lblDate_3.setText(String.valueOf(person.getLentADate()));
					lblDate_4.setText(String.valueOf(person.getLentBDate()));
					lblDate_5.setText("");
				}
				else{
					Book book1 = libraryDatabase.getBook(person.getLentA());
					Book book2 = libraryDatabase.getBook(person.getLentB());
					Book book3 = libraryDatabase.getBook(person.getLentC());
					panel_5.removeAll();
					panel_5.add(lblIsbn);
					lblIsbn_1.setText(book1.getIsbn());
					lblIsbn_2.setText(book2.getIsbn());
					lblIsbn_3.setText(book3.getIsbn());
					panel_5.add(lblIsbn_1);
					panel_5.add(lblIsbn_2);
					panel_5.add(lblIsbn_3);
					panel_5.repaint();
					button_5.setText("还书");
					button_5.setAction(new returnAction(book1.getIsbn(), person.getId()));
					button_6.setText("还书");
					button_6.setAction(new returnAction(book2.getIsbn(), person.getId()));
					button_7.setText("还书");
					button_7.setAction(new returnAction(book3.getIsbn(), person.getId()));
					button_5.setEnabled(true);
					button_6.setEnabled(true);
					button_7.setEnabled(true);
					lblName.setText(book1.getName());
					lblName_1.setText(book2.getName());
					lblName_2.setText(book3.getName());
					lblAuthor.setText(book1.getAuthor());
					lblAuthor_1.setText(book2.getAuthor());
					lblAuthor_2.setText(book3.getAuthor());
					lblPress.setText(book1.getPress());
					lblPress_1.setText(book2.getPress());
					lblPress_2.setText(book3.getPress());
					lblDate.setText(String.valueOf(book1.getPublicationDate()));
					lblDate_1.setText(String.valueOf(book2.getPublicationDate()));
					lblDate_2.setText(String.valueOf(book3.getPublicationDate()));
					lblIntegrity.setText(String.valueOf(book1.getIntegrity()));
					lblIntegrity_1.setText(String.valueOf(book2.getIntegrity()));
					lblIntegrity_2.setText(String.valueOf(book3.getIntegrity()));
					lblDate_3.setText(String.valueOf(person.getLentADate()));
					lblDate_4.setText(String.valueOf(person.getLentBDate()));
					lblDate_5.setText(String.valueOf(person.getLentCDate()));
				}
			}
		}
		else{
			JOptionPane.showMessageDialog(frame, "用户不存在");
		}
	}

	private class SwingAction extends AbstractAction {
		private String st;
		public SwingAction(String st, String name) {
			this.st = st;
			putValue(NAME, name);
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			cardLayout.show(panel_13, st);
		}
	}
	private class SwingAction_1 extends AbstractAction {
		public SwingAction_1() {
			putValue(NAME, "查询");
			putValue(SHORT_DESCRIPTION, "单击以查询");
		}
		public void actionPerformed(ActionEvent e) {
			panel_21.removeAll();
			panel_22.removeAll();
			panel_23.removeAll();
			panel_24.removeAll();
			panel_25.removeAll();
			panel_26.removeAll();
			panel_27.removeAll();
			panel_28.removeAll();
			panel_29.removeAll();
			panel_30.removeAll();
			panel_31.removeAll();
			panel_21.repaint();
			panel_22.repaint();
			panel_23.repaint();
			panel_24.repaint();
			panel_25.repaint();
			panel_26.repaint();
			panel_27.repaint();
			panel_28.repaint();
			panel_29.repaint();
			panel_30.repaint();
			panel_31.repaint();
			String string = txtIsbnorid.getText();
			for(int i = string.length()-1; i >= 0; --i){
				if(!Character.isDigit(string.charAt(i))){
					JOptionPane.showMessageDialog(frame, "没有相关记录");
					return;
				}
			}
			LinkedList<Event> events = libraryDatabase.getEventByPerson(string);
			Event event = events.poll();
			if(event == null){
				events = libraryDatabase.getEventByBook(string);
				event = events.poll();
				if(event == null){
					frame.setVisible(true);
					JOptionPane.showMessageDialog(frame, "没有相关记录");
					return;
				}
			}
			while(event != null){
				panel_21.add(new JLabel(String.valueOf(event.getId())));
				panel_22.add(new JLabel(String.valueOf(event.getDate())));
				String type;
				String beforeIntegrity = "-";
				String afterIntegrity = "-";
				if(event.getType() == Event.BORROW){
					type = "借书";
					panel_28.add(new JLabel(event.getManagerId()));
					panel_29.add(new JLabel(libraryDatabase.getPerson(event.getManagerId()).getName()));
				}
				else if(event.getType() == Event.ORDER){
					type = "预定";
					panel_28.add(new JLabel("-"));
					panel_29.add(new JLabel("-"));
				}
				else if(event.getType() == Event.RETURN){
					type = "还书";
					panel_28.add(new JLabel(event.getManagerId()));
					panel_29.add(new JLabel(libraryDatabase.getPerson(event.getManagerId()).getName()));
					beforeIntegrity = String.valueOf(event.getBeforeIntegrity());
					afterIntegrity = String.valueOf(event.getAfterIntegrity());
				}
				else{
					type = "续借";
					panel_28.add(new JLabel("-"));
					panel_29.add(new JLabel("-"));
				}
				panel_23.add(new JLabel(type));
				panel_24.add(new JLabel(event.getIsbn()));
				panel_25.add(new JLabel(libraryDatabase.getBook(event.getIsbn()).getName()));
				panel_26.add(new JLabel(event.getUserId()));
				panel_27.add(new JLabel(libraryDatabase.getPerson(event.getUserId()).getName()));
				panel_30.add(new JLabel(beforeIntegrity));
				panel_31.add(new JLabel(afterIntegrity));
				event = events.poll();
			}
			frame.setVisible(true);
		}
	}
	private class SwingAction_2 extends AbstractAction {
		public SwingAction_2() {
			putValue(NAME, "确定");
			putValue(SHORT_DESCRIPTION, "单击以更新信息");
		}
		public void actionPerformed(ActionEvent e) {
			updateUser(textField.getText());
		}
	}
	
	private class borrowAction extends AbstractAction {
		private JTextField textField;
		private String userId;
		public borrowAction(JTextField textField, String userId) {
			this.textField = textField;
			this.userId = userId;
			putValue(NAME, "借书");
			putValue(SHORT_DESCRIPTION, "单击以提交");
		}
		public void actionPerformed(ActionEvent e) {
			String isbn = textField.getText();
			for(int i = isbn.length()-1; i >= 0; --i){
				if(!Character.isDigit(isbn.charAt(i))) return;
			}
			if(libraryDatabase.borrowBook(userId, isbn, manager.getId(), Integer.parseInt(new SimpleDateFormat("yyyyMMdd").format(new Date())))){
				updateUser(userId);
				//System.out.println("Succeed!");
			}
			else{
				JOptionPane.showMessageDialog(frame, "提交失败，可能的原因：ISBN错误，书被别人预定，书已被借出");
				//System.out.println("Failed!");
			}
		}
	}
	private class returnAction extends AbstractAction {
		private String isbn;
		private String userId;
		public returnAction(String isbn, String userId) {
			this.isbn = isbn;
			this.userId = userId;
			putValue(NAME, "还书");
			putValue(SHORT_DESCRIPTION, "单击以提交");
		}
		public void actionPerformed(ActionEvent e) {
			double integrity;
			try{
				integrity = Double.parseDouble(JOptionPane.showInputDialog(frame, "输入新的完好程度"));
				if(integrity < 0 || integrity > 1){
					JOptionPane.showMessageDialog(frame, "完好程度输入错误");
					return;
				}
			}
			catch(Exception ex){
				JOptionPane.showMessageDialog(frame, "完好程度输入错误");
				return;
			}
			if(libraryDatabase.returnBook(userId, isbn, manager.getId(), Integer.parseInt(new SimpleDateFormat("yyyyMMdd").format(new Date())), integrity)){
				updateUser(userId);
				JOptionPane.showMessageDialog(frame, "提交成功");
				//System.out.println("Succeed!");
			}
			else{
				JOptionPane.showMessageDialog(frame, "提交失败，原因未知");
				//System.out.println("Failed!");
			}
		}
	}
	private class SwingAction_3 extends AbstractAction {
		public SwingAction_3() {
			putValue(NAME, "提交");
			putValue(SHORT_DESCRIPTION, "单机以提交");
		}
		public void actionPerformed(ActionEvent e) {
			Person person = new Person();
			person.setId(txtId.getText());
			if(person.getId().equals("")){
				JOptionPane.showMessageDialog(frame, "ID不能为空");
				return;
			}
			person.setName(txtName.getText());
			if(person.getName().equals("")){
				JOptionPane.showMessageDialog(frame, "姓名不能为空");
				return;
			}
			String passwd = String.valueOf(pwdPasswd.getPassword());
			if(passwd.equals("")){
				JOptionPane.showMessageDialog(frame, "密码不能为空");
				return;
			}
			if(!String.valueOf(pwdRepasswd.getPassword()).equals(passwd)){
				JOptionPane.showMessageDialog(frame, "两次密码输入不一致");
				return;
			}
			if(comboBox.getSelectedItem().equals("\u5B66\u751F")){
				person.setIdType(Person.STUDENT);
			}
			else{
				person.setIdType(Person.MANAGER);
			}
			if(libraryDatabase.savePerson(person, passwd)){
				JOptionPane.showMessageDialog(frame, "成功添加新用户");
			}
			else{
				JOptionPane.showMessageDialog(frame, "添加新用户失败，可能的原因：用户已存在");
			}
		}
	}
	private class SwingAction_4 extends AbstractAction {
		public SwingAction_4() {
			putValue(NAME, "提交");
			putValue(SHORT_DESCRIPTION, "单击以提交");
		}
		public void actionPerformed(ActionEvent e) {
			Book book = new Book();
			book.setIsbn(txtIsbn.getText());
			if(book.getIsbn().equals("")){
				JOptionPane.showMessageDialog(frame, "ISBN不能为空");
				return;
			}
			book.setName(txtName_1.getText());
			book.setAuthor(txtAuthor.getText());
			book.setPress(txtPress.getText());
			String year = txtYear.getText();
			String month = txtMonth.getText();
			if(year.length() != 4){
				JOptionPane.showMessageDialog(frame, "年份格式错误");
				return;
			}
			for(int i = 0; i < 4; ++i){
				if(!Character.isDigit(year.charAt(i))){
					JOptionPane.showMessageDialog(frame, "年份格式错误");
					return;
				}
			}
			try{
				month = String.valueOf(Integer.parseInt(month));
				if(month.length() == 1){
					month = "0" + month;
				}
				
			}
			catch(Exception ex){
				JOptionPane.showMessageDialog(frame, "月份格式错误");
				return;
			}
			book.setPublicationDate(Integer.parseInt(year + month));
			double integrity;
			try{
				integrity = Double.parseDouble(txtIntegrity.getText());
				if(integrity < 0 || integrity > 1){
					JOptionPane.showMessageDialog(frame, "完好程度错误");
					return;
				}
				book.setIntegrity(integrity);
			}
			catch(Exception ex){
				JOptionPane.showMessageDialog(frame, "完好程度错误");
				return;
			}
			if(libraryDatabase.saveBook(book)){
				JOptionPane.showMessageDialog(frame, "提交成功");
			}
			else{
				JOptionPane.showMessageDialog(frame, "提交失败，可能的原因：书已经存在");
			}
		}
	}
}
