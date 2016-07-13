package LibrarySystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.LinkedList;

import java.sql.ResultSet;

/**
 * �����й����ݿ�Ĳ����ڴ˽��У�ʹ��ǰ��Ҫʵ����
 * @author Alan
 *
 */
public class LibraryDatabase {
	
	private Connection conn;
	private Statement stmt;

	/**
	 * ����һ����ʼ����LibraryDatabase�࣬�Զ������ݿ����ӣ����ݿ�����library���û���root�����룺�գ�
	 */
	public LibraryDatabase(){
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection("jdbc:mysql://localhost/library?useSSL=false&characterEncoding=UTF-8", "root", "");
			stmt = conn.createStatement();
		}
		catch(Exception ex){
			System.out.println(ex);
			System.exit(0);
		}
	}
	
	/**
	 * �����ݿ��л�ȡisbn���Ӧ��ͼ�飬��д��һ��Book�࣬���ش�Book��
	 * @param isbn ��Ҫ��ȡ��ͼ���Ӧ��isbn��
	 * @return isbn������Ӧ���飬��������ڣ��򷵻�null
	 */
	public Book getBook(String isbn){
       String sql =  "select * from book where isbn=" + isbn;
       try{
		   ResultSet rs = stmt.executeQuery(sql);
		   if(rs.next()){
		       Book book = new Book();
		       book.setIsbn(isbn);
		       if(null != rs.getString(2))
		           book.setName(new String(rs.getString(2).trim()));
		       if(null != rs.getString(3))
		           book.setAuthor(new String(rs.getString(3).trim()));
		       if(null != rs.getString(4))
		    	   book.setPress(new String(rs.getString(4).trim()));
		       if(null != rs.getString(5))
		    	   book.setPublicationDate(Integer.parseInt(rs.getString(5).trim()));
			   book.setIntegrity(Double.parseDouble(rs.getString(6).trim()));
			   book.setLent(1 == Integer.parseInt(rs.getString(7).trim()));
		       if(book.getLent()){
				   book.setLentPerson(new String(rs.getString(8).trim()));
				   book.setLentDate(Integer.parseInt(rs.getString(9).trim()));
		       }
			   book.setOrdered(1 == Integer.parseInt(rs.getString(10).trim()));
			   if(book.getOrdered()){
				   book.setOrderedPerson(new String(rs.getString(11).trim()));
				   book.setOrderedDate(Integer.parseInt(rs.getString(12).trim()));
		       }
		       return book;
		   }
		   else
		       return null;
       }
       catch(Exception ex){
		   System.out.println(ex);
		   System.exit(0);
       }
       return null;
    }
	
	/**
	 * ģ������ͼ��
	 * @param st ��Ҫ���������ݣ�������isbn�����������߻�����磬������������Ψһ���ÿո����
	 * @return ���з�����������
	 */
	public LinkedList<Book> searchBook(String st){
       String sql = "select * from book where ";
       String[] array = st.split(" ");
       for(String s: array)
    	   sql += "(isbn like '%" + s + "%' or name like '%" + s + "%' or author like '%" + s + "%' or press like '%" + s + "%') and ";
       sql += "true";
       LinkedList<Book> list = new LinkedList<Book>();
       try{
		   ResultSet rs = stmt.executeQuery(sql);
		   while(rs.next()){
		       Book book = new Book();
		       book.setIsbn(rs.getString(1));
		       if(null != rs.getString(2))
		           book.setName(new String(rs.getString(2).trim()));
		       if(null != rs.getString(3))
		           book.setAuthor(new String(rs.getString(3).trim()));
		       if(null != rs.getString(4))
		    	   book.setPress(new String(rs.getString(4).trim()));
		       if(null != rs.getString(5))
		    	   book.setPublicationDate(Integer.parseInt(rs.getString(5).trim()));
			   book.setIntegrity(Double.parseDouble(rs.getString(6).trim()));
			   book.setLent(1 == Integer.parseInt(rs.getString(7).trim()));
		       if(book.getLent()){
				   book.setLentPerson(new String(rs.getString(8).trim()));
				   book.setLentDate(Integer.parseInt(rs.getString(9).trim()));
		       }
			       book.setOrdered(1 == Integer.parseInt(rs.getString(10).trim()));
			   if(book.getOrdered()){
				   book.setOrderedPerson(new String(rs.getString(11).trim()));
				   book.setOrderedDate(Integer.parseInt(rs.getString(12).trim()));
		       }
		       list.add(book);
		   }
		   return list;
       }
       catch(Exception ex){
	   System.out.println(ex);
	   System.exit(0);
       }
       return null;
   }

	/**
	 * ��һ�������Ϣ�������ݿ⣨ֻ�����½�ͼ��֮ʱ���ɣ�
	 * @param book	��Ҫ�����ͼ�飨�ڲ�������Ҫ��дisbn��integrity�����ֶ�
	 * @return	�����Ƿ�ɹ�����ͼ�飬���ɹ���ԭ���У�integrityû����д��isbnû����д��isbn�����ݿ����Ѿ�����
	 */
	public boolean saveBook(Book book){
		if(book.getIntegrity() == -1 || book.getIsbn() == "") return false;//incorrect isbn
		String sql = "select * from book where isbn='" + book.getIsbn() + "'";
		try{
			ResultSet rs = stmt.executeQuery(sql);//find if the book exits in the database
			if(rs.next()) return false;//the book exists in the database
		}
		catch(Exception ex){
			System.out.println(ex);
			System.exit(0);
		}
		sql = "insert into book (isbn, name, author, press, publication_date, integrity, lent, ordered)"
				+ "values ('" + book.getIsbn() + "','" + book.getName() + "','" + book.getAuthor() + "','"
				+ book.getPress() + "'," + book.getPublicationDate() + "," + book.getIntegrity() + ",0,0)";
		try{
			stmt.executeUpdate(sql);//insert the book into database
		}
		catch(Exception ex){
			System.out.println(ex);
			System.exit(0);
		}
		return true;
	}
	
	/**
	 * ��ȡһ���û�id��Ӧ������
	 * @param id �û���id
	 * @return ��id���ڣ��򷵻ض�Ӧ�����룻��id�����ڣ����ؿ��ַ���""
	 */
	public String getPasswd(String id) {
		String sql = "select passwd from person where id=" + id;
		try{
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next())
				return new String(rs.getString(1).trim());
			else
				return "";
		}
		catch(Exception ex){
			System.out.println(ex);
			System.exit(0);
		}
		return "";
	}

	/**
	 * �����ݿ��л�ȡid��Ӧ���û�����д��һ��Person�࣬���ش�Person��
	 * @param id ��Ҫ��ȡ���û���Ӧ��id
	 * @return id����Ӧ���û�����������ڣ��򷵻�null
	 */
	public Person getPerson(String id){
		String sql = "select * from person where id=" + id;
		try{
		    ResultSet rs = stmt.executeQuery(sql);
		    if(rs.next()){
			Person person = new Person();
			person.setId(id);
			person.setIdType(Integer.parseInt(rs.getString(3).trim()));
			person.setName(new String(rs.getString(4).trim()));
			if(null == rs.getString(5))
			    person.setLentA("");
			else{
			    person.setLentA(new String(rs.getString(5).trim()));
			    person.setLentADate(Integer.parseInt(rs.getString(6).trim()));
			}
			if(null == rs.getString(7))
			    person.setLentB("");
			else{
			    person.setLentB(new String(rs.getString(7).trim()));
			    person.setLentADate(Integer.parseInt(rs.getString(8).trim()));
			}
			if(null == rs.getString(9))
			    person.setLentC("");
			else{
			    person.setLentC(new String(rs.getString(9).trim()));
			    person.setLentADate(Integer.parseInt(rs.getString(10).trim()));
			}
				return person;
		    }
		    else
		    	return null;
		}
		catch(Exception ex){
		    System.out.println(ex);
		    System.exit(0);
		}
		return null;
	}
	
	/**
	 * ��һ���˵���Ϣ�������ݿ⣨ֻ�����½��û����ɣ�
	 * @param person ��Ҫ������ˣ��ڲ�������Ҫ��дid��name��idType�����ֶΣ�����idTypeĬ��ֵΪPerson.STUDENT��
	 * @param passwd ��Ҫ������˶�Ӧ�����루�˷����ڲ���������ĺϷ��Խ��м��飩
	 * @return �����Ƿ�ɹ�������ˣ����ɹ���ԭ���У�idû����д��nameû����д��id�����ݿ����Ѿ�����
	 */
	public boolean savePerson(Person person, String passwd){
		if(person.getId() == "" || person.getName() == "") return false;//incorrect id or name
		String sql = "select * from person where id='" + person.getId() + "'";
		try{
			ResultSet rs = stmt.executeQuery(sql);//find if the person exits in the database
			if(rs.next()) return false;//the person exists in the database
		}
		catch(Exception ex){
			System.out.println(ex);
			System.exit(0);
		}
		sql = "insert into person (id, passwd, id_type, name) values ('" + person.getId() + "','"
				+ passwd + "'," + person.getIdType() + ",'" + person.getName() + "')";
		try{
			stmt.executeUpdate(sql);
		}
		catch(Exception ex){
			System.out.println(ex);
			System.exit(0);
		}
		return true;
	}
	
	/**
	 * �����ݿ��л�ȡisbn��Ӧ��ͼ���������ʷ�¼�
	 * @param isbn ��Ҫ��ѯ��ͼ���isbn��
	 * @return isbn���Ӧͼ���������ʷ�¼�
	 */
	public LinkedList<Event> getEventByBook(String isbn){
		String sql = "select * from event where isbn=" + isbn;
		LinkedList<Event> list = new LinkedList<Event>();
		try{
		    ResultSet rs = stmt.executeQuery(sql);
		    while(rs.next()){
				Event event = new Event();
				event.setId(Integer.parseInt(rs.getString(1).trim()));
				event.setDate(Integer.parseInt(rs.getString(2).trim()));
				event.setType(Integer.parseInt(rs.getString(3).trim()));
				event.setIsbn(new String(rs.getString(4).trim()));
				event.setUserId(new String(rs.getString(5).trim()));
				if(event.getId() == Event.BORROW){
				    event.setManagerId(new String(rs.getString(6).trim()));
				    event.setBeforeIntegrity(-1);
				    event.setAfterIntegrity(-1);
				}
				else if(event.getId() == Event.RETURN){
				    event.setManagerId(new String(rs.getString(6).trim()));
				    event.setBeforeIntegrity(-1);
				    event.setAfterIntegrity(-1);
				}
				else{
					event.setManagerId("");
				    event.setBeforeIntegrity(Double.parseDouble(rs.getString(7).trim()));
				    event.setAfterIntegrity(Double.parseDouble(rs.getString(8).trim()));
				}
				list.add(event);
		    }
		    return list;
		}
		catch(Exception ex){
		    System.out.println(ex);
		    System.exit(0);
		}
		return null;
	}
	
	/**
	 * �����ݿ��л�ȡid��Ӧ���˵�������ʷ�¼�
	 * @param id ��Ҫ��ѯ���˵�id
	 * @return id��Ӧ���˵�������ʷ�¼�
	 */
	public LinkedList<Event> getEventByPerson(String id){
		String sql = "select * from event where user_id=" + id + " or manager_id=" + id;
		LinkedList<Event> list = new LinkedList<Event>();
		try{
		    ResultSet rs = stmt.executeQuery(sql);
		    while(rs.next()){
				Event event = new Event();
				event.setId(Integer.parseInt(rs.getString(1).trim()));
				event.setDate(Integer.parseInt(rs.getString(2).trim()));
				event.setType(Integer.parseInt(rs.getString(3).trim()));
				event.setIsbn(new String(rs.getString(4).trim()));
				event.setUserId(new String(rs.getString(5).trim()));
				if(event.getId() == Event.BORROW){
				    event.setManagerId(new String(rs.getString(6).trim()));
				    event.setBeforeIntegrity(-1);
				    event.setAfterIntegrity(-1);
				}
				else if(event.getId() == Event.RETURN){
				    event.setManagerId(new String(rs.getString(6).trim()));
				    event.setBeforeIntegrity(-1);
				    event.setAfterIntegrity(-1);
				}
				else{
					event.setManagerId("");
				    event.setBeforeIntegrity(Double.parseDouble(rs.getString(7).trim()));
				    event.setAfterIntegrity(Double.parseDouble(rs.getString(8).trim()));
				}
				list.add(event);
		    }
		    return list;
		}
		catch(Exception ex){
		    System.out.println(ex);
		    System.exit(0);
		}
		return null;
	}

	
}
