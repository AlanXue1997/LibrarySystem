package LibrarySystem;

/**
 * 用来存一个事件的信息，包括日期、类型、书的isbn码、借阅者id、管理员id、之前的完好度、之后的完好度
 * （所有set方法都只在LibraryDatebase内部使用，外部不需要使用）
 * @author Alan
 *
 */
public class Event {
	
	/**
	 * 事件的类型之一，表示借书，值为0
	 */
	public static int BORROW = 0;
	/**
	 * 事件的类型之一，表示还书，值为1
	 */
	public static int RETURN = 1;
	/**
	 * 事件的类型之一，表示续借，值为2
	 */
	public static int RENEW = 2;
	/**
	 * 事件的类型之一，表示续借，值为3
	 */
	public static int ORDER = 3;
	
	private int id;
	private int date;
	private int type;
	private String isbn;
	private String userId;
	private String managerId;
	private double beforeIntegrity;
	private double afterIntegrity;
	
	public void setId(int id) { this.id = id; }
	public void setDate(int date) { this.date = date; }
	public void setType(int type) { this.type = type; }
	public void setIsbn(String isbn) { this.isbn = isbn; }
	public void setUserId(String userId) { this.userId = userId; }
	public void setManagerId(String managerId) { this.managerId = managerId; }
	public void setBeforeIntegrity(double beforeIntegrity) { this.beforeIntegrity = beforeIntegrity; }
	public void setAfterIntegrity(double afterIntegrity) { this.afterIntegrity = afterIntegrity; }

	/**
	 * 获取事件的序号
	 * @return 一个流水号，可以比较方便的比较事件发生的先后顺序
	 */
	public int getId() { return id; };
	/**
	 * 获取事件的时间
	 * @return 一个8位整数，格式为yyyymmdd（比如2016年7月6日应写为20160706）
	 */
	public int getDate() { return date; };
	/**
	 * 获取事件的类型
	 * @return 事件的类型
	 */
	public int getType() { return type; };
	/**
	 * 获取事件所对应的书的isbn码
	 * @return 书的isbn码
	 */
	public String getIsbn() { return isbn; };
	/**
	 * 获取事件所对应的借阅者的id
	 * @return 借阅者的id
	 */
	public String getUserId() { return userId; }
	/**
	 * 获取事件所对应的管理员的id
	 * @return 如果事件类型为BORROW或RETURN，返回管理员的id；如果事件类型为RENEW,返回空字符串""
	 */
	public String getManagerId() { return managerId; }
	/**
	 * 获取事件发生之前书的完好程度
	 * @return 如果事件类型为RETURN，返回0~1之间的一个实数；如果事件类型为BORROW或RENEW，返回-1
	 */
	public double getBeforeIntegrity() { return beforeIntegrity; }
	/**
	 * 获取事件发生之后书的完好程度
	 * @return 如果事件类型为RETURN，返回0~1之间的一个实数；如果事件类型为BORROW或RENEW，返回-1
	 */
	public double getAfterIntegrity() { return afterIntegrity; }

}
