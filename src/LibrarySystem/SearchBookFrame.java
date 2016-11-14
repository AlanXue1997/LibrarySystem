package LibrarySystem;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.omg.CORBA.PRIVATE_MEMBER;
import org.omg.CORBA.PUBLIC_MEMBER;

import com.sun.corba.se.spi.orbutil.fsm.Action;
import com.sun.xml.internal.ws.api.pipe.Tube;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.AbstractAction;
import javax.swing.BoxLayout;
import java.awt.GridBagLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;

public class SearchBookFrame extends JFrame {
	private LibraryDatabase libraryDatabase;
	private Person person;
	private JTextField bookname = new JTextField();
	private JButton search = new JButton("搜索");
	private JScrollPane jsp = new JScrollPane();
	private JPanel contentPane = new JPanel();
	private final JPanel panel = new JPanel();
	private final JTextArea txtrIsbn = new JTextArea();
	private final JTextArea txtrName = new JTextArea();
	private final JTextArea txtrAuthor = new JTextArea();
	private final JTextArea txtrPress = new JTextArea();
	private final JPanel panel_1 = new JPanel();
	private final JLabel lblIsbn = new JLabel("ISBN");
	private final JLabel lblName = new JLabel("NAME");
	private final JLabel lblNewLabel = new JLabel("AUTHOR");
	private final JLabel lblNewLabel_1 = new JLabel("PRESS");
	private final JLabel lblOrder = new JLabel("ORDER");
	private final JPanel panel_2 = new JPanel();

	
	public SearchBookFrame(LibraryDatabase libraryDatabase, Person person) {
		this.libraryDatabase = libraryDatabase;
		this.person = person;
		this.setTitle("搜索图书界面");
		getContentPane().setLayout(null);
		this.setSize(800, 600);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		search.setBounds(500,50,120,20);
		bookname.setBounds(50, 50, 300, 20);
		
		contentPane.add(search);
		contentPane.add(bookname);
		
		
		//创建内容面板
		contentPane.setBorder(new EmptyBorder(100,50,50,50));//设置面板的边框
		contentPane.setLayout(new BorderLayout(0,0)); //设置内容面板为边界布局
        setContentPane(contentPane);
        
        contentPane.add(jsp, BorderLayout.CENTER);
        
        jsp.setViewportView(panel);
        panel.setLayout(new GridLayout(1, 0, 0, 0));
        txtrIsbn.setTabSize(0);
        txtrIsbn.setFont(new Font("Monospaced", Font.BOLD, 19));
        
        
        panel.add(txtrIsbn);
        txtrName.setTabSize(0);
        txtrName.setFont(new Font("Monospaced", Font.BOLD, 19));
        
        
        panel.add(txtrName);
        txtrAuthor.setTabSize(0);
        txtrAuthor.setFont(new Font("Monospaced", Font.BOLD, 19));
        
        
        panel.add(txtrAuthor);
        txtrPress.setTabSize(0);
        txtrPress.setFont(new Font("Monospaced", Font.BOLD, 19));
        
        
        panel.add(txtrPress);
        
        panel.add(panel_2);
        panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.Y_AXIS));
        
        jsp.setColumnHeaderView(panel_1);
        panel_1.setLayout(new GridLayout(1, 0, 0, 0));
        lblIsbn.setHorizontalAlignment(SwingConstants.CENTER);
        
        panel_1.add(lblIsbn);
        lblName.setHorizontalAlignment(SwingConstants.CENTER);
        
        panel_1.add(lblName);
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        
        panel_1.add(lblNewLabel);
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        
        panel_1.add(lblNewLabel_1);
        lblOrder.setHorizontalAlignment(SwingConstants.CENTER);
        
        panel_1.add(lblOrder);
        setVisible(true);
        
        
        
        
        search.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e) {
        		txtrIsbn.setText("");
        		txtrName.setText("");
        		txtrAuthor.setText("");
        		txtrPress.setText("");

        		panel_2.removeAll();
        	    LinkedList<Book> books = SearchBookFrame.this.libraryDatabase.searchBook(bookname.getText());
                Book book = books.poll();
                if(book == null) {
                	txtrIsbn.setText("Can't find the book in the database!");
                }
                else{
        	        while(book != null){
        	        	txtrIsbn.append(book.getIsbn() + "\n");
        	        	txtrName.append(book.getName() + "\n");
        	        	txtrAuthor.append(book.getAuthor() + "\n");
        	        	txtrPress.append(book.getPress() + "\n");   
        	        	JButton order = new JButton("预约");
        	        	panel_2.add(order);
        	        	
        	        	if(book.getLent()==false && book.getOrdered()==false && SearchBookFrame.this.person.getLentC().equals("0"))
        	        	{
        	        		order.setEnabled(true);
        	        	}
        	        	else
        	        	{
        	        		if(book.getLent()  && book.getLentPerson().equals(SearchBookFrame.this.person.getId())){
        	        			order.setText("续借");
        	        			order.setEnabled(true);
        	        		}
        	        		else {
								order.setEnabled(false);
							}
        	        	}
        	        	order.addActionListener(new swingAction(book.getIsbn(),book,order));       	        	
        		    book = books.poll();
        	      }
                }	
        	}
        });
     
        
        
        
        
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
            	if(order.getText()=="续借"){
            		JOptionPane.showMessageDialog(null,"您已经续借成功",null,JOptionPane.INFORMATION_MESSAGE);
            		libraryDatabase.renewBook(person.getId(),book.getIsbn(),Integer.parseInt(new SimpleDateFormat("yyyyMMdd").format(new Date())));
            	}
            	else
            	{    
	                JOptionPane.showMessageDialog(null,"您已经预定成功",null,JOptionPane.INFORMATION_MESSAGE);
	                libraryDatabase.orderBook(person.getId(),book.getIsbn(), Integer.parseInt(new SimpleDateFormat("yyyyMMdd").format(new Date())));
	                order.setEnabled(false);
	            }
            }
            
        }
}

