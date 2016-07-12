package LibrarySystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.LinkedList;

import java.sql.ResultSet;

public class LibraryDatabase {
	
	private Connection conn;
	private Statement stmt;

	/**
	 * 构造一个初始化的LibraryDatabase类，自动与数据库连接（数据库名：library；用户：root；密码：空）
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
	 * 从数据库中获取isbn码对应的图书，并写入一个Book类，返回此Book类
	 * @param isbn 想要获取的图书对应的isbn码
	 * @return isbn码所对应的书
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
