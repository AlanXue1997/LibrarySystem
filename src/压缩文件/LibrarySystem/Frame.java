package LibrarySystem;

import java.awt.*;
import javax.swing.*;

import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
public class Frame extends JFrame {
	
	private JPasswordField area1;
	private JPasswordField area2;
	private JPasswordField area3;
	
	private LibraryDatabase libraryDatabase;
	private Person person;

	/**
	 *   创建按钮
	 */
private static final long serialVersionUID = 1L;
private JButton jButton1=new JButton();

private JButton jButton3=new JButton();



  public Frame (LibraryDatabase libraryDatabase, Person person)
  {
	  
	  this.libraryDatabase = libraryDatabase;
	  this.person = person;
	  this.setContentPane(new MyPanel());
      
	  Dimension scr = Toolkit.getDefaultToolkit().getScreenSize();
	  Dimension frm = this.getSize();
	  setLocation( (scr.width - frm.width) / 2,
	  (scr.height - frm.height) / 2 - 18);

	  
    try {
      jbInit();
    }
    catch(Exception exception) {
      exception.printStackTrace();
    }
    this.setVisible(true);
  }

  private void jbInit () throws Exception
  {
    this.setBounds(450,250,600,500);
    getContentPane().setLayout(null);
    
    
    /**
	 * 监听按钮1
	 */
    jButton1.setFont(new Font("楷体", Font.BOLD, 30));
    jButton1.setForeground(Color.BLACK);
    
    jButton1.setBounds(0, 0, 200, 100);
    jButton1.setText("查询");
    jButton1.addActionListener(new ActionListener()
    {
      public void actionPerformed (ActionEvent e)
      {
         jButton1_actionPerformed(e);
      }
    });
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.getContentPane().add(jButton1);
	
    
    
    
    /**
	 * 监听按钮3
	 */
    jButton3.setFont(new Font("楷体", Font.BOLD, 30));
    jButton3.setForeground(Color.BLACK);
    
    
    jButton3.setBounds(400, 0, 182, 100);
    jButton3.setText("个人信息");
    jButton3.addActionListener(new ActionListener()
    {
      public void actionPerformed (ActionEvent c)
      {
         jButton3_actionPerformed(c);
      }
    });
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.getContentPane().add(jButton3);
    
    
  }
       
  
  
  public static void main (String[] args)
  {
	  LibraryDatabase lib = new LibraryDatabase();

      Frame frame1=new Frame(lib, lib.getPerson("1153710506"));
      
  }
  
  /**
	 * 设置背景
	 */
  
      private class MyPanel extends JPanel {
	  public void paintComponent(Graphics g) {
	  Graphics2D g2 = (Graphics2D)g;
	  super.paintComponent(g);
	  Image img = Toolkit.getDefaultToolkit().getImage("image/java.jpg");
	  g2.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
	  }
	  }

  
  /**
	 * 按钮1功能执行
	 */
  

  public void jButton1_actionPerformed (ActionEvent e)
  {
    this.setVisible(true);
   
    //JFrame jf1=new JFrame("查询");
    SearchBookFrame searchBookFrame = new SearchBookFrame(libraryDatabase, person);
	
    //jf1.setBounds(100,50,800,600);
    
    searchBookFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE );
    
    
//    jf1.addWindowListener(new WindowAdapter(){
//    	public void windowClosing(WindowEvent e){
//    	
//    		frame1.setEnabled(true);
//    	}

//		
//    	});
    
    JPanel panel1 =new JPanel();
    //jf1.getContentPane().add(panel1);
    JButton jButton11=new JButton("Search");
    jButton11.setBounds(50, 80, 100, 100);
    jButton11.setText("Search");
    panel1.add(jButton11);
    
    jButton11.addActionListener(new ActionListener()
    {
      public void actionPerformed (ActionEvent B)
      {
         System.out.println("搜索成功");   
      }
    });
    
    JTextField textField1 = new JTextField ("",50);
    panel1.add(textField1);
    
    
    
    
    
    
    
    
    //jf1.setVisible(true);
    
    
   
    
      
      
      
	  
      
    
    
    
    
    
    
    
  
  }
    
  
  private class swingAction  extends AbstractAction {
	  	private String isbn;
	  	private Book book;
	  	private JButton order;
	  	public swingAction (String isbn,Book book,JButton order) {
	  		this.isbn = isbn;   
	  		this.book = book;
	  		this.order = order;
	  	}
	      public void actionPerformed(ActionEvent e){
	    	  JOptionPane.showMessageDialog(null,"您已经续借成功",null,JOptionPane.INFORMATION_MESSAGE);
	  		  libraryDatabase.renewBook(person.getId(),book.getIsbn(),Integer.parseInt(new SimpleDateFormat("yyyyMMdd").format(new Date())));
	      }
	 }


  
  /**
 	 * 按钮3功能执行
 	 */
  
  
  
  public void jButton3_actionPerformed (ActionEvent c)
  {
    this.setVisible(true);
    JFrame jf1=new JFrame("个人信息");
    jf1.setBounds(100,50,800,600);
    jf1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
   
    JPanel panel3 =new JPanel();
    panel3.setLayout(null);
    jf1.getContentPane().add(panel3);
   /* 
    JButton jButton11=new JButton("Search");
    jButton11.setBounds(50, 80, 100, 100);
    jButton11.setText("Search");
    panel3.add(jButton11);
    JTextField textField1 = new JTextField ("",50);
    panel3.add(textField1);
    */
//    JTextArea area1=new JTextArea("sadasd");
//    panel3.add(area1);
//    area1.setBounds(80,60,100,20);
    JLabel label11=new JLabel(person.getName());
    panel3.add(label11);
    label11.setBounds(80,60,100,20);
    JLabel  label1 = new JLabel("姓名：") ;
    label1.setBounds(40,20,100,100);
    panel3.add(label1);
    
    
    Book booka = libraryDatabase.getBook(person.getLentA());
    
    if(null != booka){
    	JLabel labela =new JLabel(person.getLentA());
    	JLabel bookname = new JLabel(booka.getName());
    	JLabel hstime = new JLabel(String.valueOf(person.getLentADate()));
    	panel3.add(labela );
    	panel3.add(hstime);
    	panel3.add(bookname);
    	hstime.setBounds(450,200,100,20);
    	bookname.setBounds(250,200,100,20);
    	panel3.add(labela );
        labela.setBounds(30,200,100,20);
        JButton buttona=new JButton("续借");
        panel3.add(buttona);
        buttona.setBounds(600,200,60,60);
        buttona.setText("续借");
        buttona.addActionListener(new swingAction(booka.getIsbn(),booka,buttona));
    }
    else{
    	JButton button31=new JButton("续借");
    	button31.setEnabled(false);
    	button31.setBounds(600,200,60,60);
    	panel3.add(button31);
    }
  
    Book bookb = libraryDatabase.getBook(person.getLentB());
    if(null != bookb){
    	JLabel label4 =new JLabel(person.getLentB());
    	JLabel bookname2 = new JLabel(bookb.getName());
    	JLabel hstime2 = new JLabel(String.valueOf(person.getLentBDate()));
    	panel3.add(label4);
    	panel3.add(hstime2);
    	panel3.add(bookname2);
    	hstime2.setBounds(450,200,100,20);
    	bookname2.setBounds(250,200,100,20);
        label4.setBounds(30,250,100,20);
    	panel3.add(label4);
        label4.setBounds(30,250,100,20);
        JButton buttonb=new JButton("续借");
        panel3.add(buttonb);
        buttonb.setBounds(600,270,60,60);
        buttonb.setText("续借");
        buttonb.addActionListener(new ActionListener()
        {
          public void actionPerformed (ActionEvent A)
          {
             System.out.println("213");   
          }
        });
    }
    else{
    	JButton button32=new JButton("续借");
    	button32.setEnabled(false);
    	button32.setBounds(600,270,60,60);
    	panel3.add(button32);
    }
    
    
    
    Book bookc = libraryDatabase.getBook(person.getLentC());
    if(null != bookc){
    	JLabel label5 =new JLabel(person.getLentC());
    	panel3.add(label5);
        label5.setBounds(30,300,100,20);
        JButton buttonc=new JButton("续借");
        panel3.add(buttonc);
        buttonc.setBounds(600,340,60,60);
        buttonc.setText("续借");
        buttonc.addActionListener(new ActionListener()
        {
          public void actionPerformed (ActionEvent A)
          {
             System.out.println("213");   
          }
        });
    }
    else{
    	JButton button33=new JButton("续借");
    	button33.setEnabled(false);
    	button33.setBounds(600,340,60,60);
    	panel3.add(button33);
    }
    
    
    JButton button5=new JButton("修改密码");
    panel3.add(button5);
    button5.setBounds(600,50,150,150);
    button5.addActionListener(new ActionListener()
    {
      public void actionPerformed (ActionEvent Q)
      {
           JFrame Frame2=new  JFrame("修改密码");
           Frame2.setBounds(60,50,800,600);
           Frame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
           JPanel panel4 =new JPanel();
           panel4.setLayout(null);
           Frame2.getContentPane().add(panel4);
           Frame2.setVisible(true);
           JLabel label21=new JLabel("原密码");
           panel4.add(label21);
           label21.setBounds(100,40,50,50);
      
           area1=new JPasswordField();
           String p= String.valueOf(area1.getPassword());
           panel4.add(area1);
           area1.setBounds(160,55,300,20);
           
           
           JLabel label22=new JLabel("新密码");
           panel4.add(label22);
           label22.setBounds(100,75,50,50);
           area2=new JPasswordField("sadasd");
           panel4.add(area2);
           area2.setBounds(160,90,300,20);
           
           
           JLabel label23=new JLabel("确认新密码");
           panel4.add(label23);
           label23.setBounds(100,110,50,50);
           area3=new JPasswordField("sadasd");
           panel4.add(area3);
           area3.setBounds(160,125,300,20);
           
           JButton button6 =new JButton("确定");
           panel4.add(button6);
           button6.setBounds(400,150,60,60);
           button6.addActionListener(new ActionListener()
           {
             public void actionPerformed (ActionEvent A)
             {
                if(String.valueOf(area1.getPassword()).equals(libraryDatabase.getPasswd(person.getId()))){
                	if(String.valueOf(area2.getPassword()).equals(String.valueOf(area3.getPassword()))){
                		String passwd = String.valueOf(area2.getPassword());
                		if(passwd.equals("")){
                			JOptionPane.showMessageDialog(null, "密码不能为空");
                			return;
                		}
                		libraryDatabase.setPasswd(person.getId(), passwd);
                		JOptionPane.showMessageDialog(null, "修改成功");
                	}
                	else{
                		JOptionPane.showMessageDialog(null, "两次新密码输入不一致");
                	}
                }
                else{
                	JOptionPane.showMessageDialog(null, "原始密码输入错误");
                }
             }
           });
     
          
           
      }
    });
    
    
    
	
    
    JLabel label2=new JLabel("ID:");
    panel3.add(label2);
    label2.setBounds(40,100,100,100);
    JLabel label22=new JLabel(person.getId());
    panel3.add(label22);
    label22.setBounds(60,140,100,20);
//    JButton button2=new JButton("续借");
//    panel3.add(button2);
//    button2.setBounds(200,160,60,60);
//    button2.setText("续借");
//    JTextArea area2=new JTextArea("12312312");
//    panel3.add(area2);
//   area2.setBounds(80,140,100,20);
    
    jf1.setVisible(true);
  }
	
  
  
  
  
  
	
	
}
