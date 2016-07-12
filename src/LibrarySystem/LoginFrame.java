package LibrarySystem;

import java.awt.Button;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

class LoginFrame extends JFrame {
	private LibraryDatabase libraryDatabase;
	private JLabel name = new JLabel("I   D:");
	private JLabel pass = new JLabel("�� ��:");
	private JTextField userName = new JTextField();
	private JPasswordField passWord = new JPasswordField();
	private Button bok = new Button("��¼");
	private Button bexit = new Button("ȡ��");

	public LoginFrame(LibraryDatabase libraryDatabase) {
		this.libraryDatabase = libraryDatabase;
		this.setContentPane(new MyPanel());
		//��½����
		setTitle("��¼����");
		setLayout(null);
		setSize(500, 400);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//�޶����ڵĴ�С
		Dimension scr = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frm = this.getSize();
		setLocation( (scr.width - frm.width) / 2,
		(scr.height - frm.height) / 2 - 18);

		//�������λ��
		name.setBounds(70, 260, 120, 20);
		userName.setBounds(120, 260, 120, 27);
		pass.setBounds(70, 300, 120, 20);
		passWord.setBounds(120, 300, 120, 27);
		passWord.setEchoChar('*');
		bok.setBounds(340, 260, 100, 28);
		bexit.setBounds(340, 300, 100, 28);
		add(name);
		add(userName);
		add(pass);
		add(passWord);
		add(bok);
		add(bexit);
		setVisible(true);
		//ȡ����ť������¼�����
		bexit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//dispose();
				System.exit(0);
			}
		});
  
		//��¼��ť������¼�����
		bok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (userName.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "ID����Ϊ��!");
				}
				else if (String.valueOf(passWord.getPassword()).equals("")) {
					JOptionPane.showMessageDialog(null, "���벻��Ϊ��!");
				}
				else {
					if (String.valueOf(passWord.getPassword()).equals(LoginFrame.this.libraryDatabase.getPasswd(userName.getText()))) {
						//person = getPerson(userName.getText());
						dispose();
						// new MainFrame();
					} 
					else {
						JOptionPane.showMessageDialog(null, "ID���������");
						passWord.setText(null);
					}
				}
			}
		});
	}
	//���ô��ڵı���ͼƬ
	private class MyPanel extends JPanel {
		public void paintComponent(Graphics g) {
			Graphics2D g2 = (Graphics2D)g;
			super.paintComponent(g);
			Image img = Toolkit.getDefaultToolkit().getImage("b.jpg");
			g2.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
		}
	}

}
