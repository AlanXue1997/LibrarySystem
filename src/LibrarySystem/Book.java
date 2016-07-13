package LibrarySystem;

/**
 * 用来存一本书的信息的类，包括isbn码、书名、作者、出版社、出版日期、完好程度、是否借出、被谁借出、借出日期、是否预定、被谁预定、预定日期
 * 其中，至少isbn、完好程度、是否借出、是否预定四条信息不为空
 * @author Alan
 *
 */
public class Book {
	
	private String isbn = "";
	private String name = "";
	private String author = "";
	private String press = "";
	private int publicationDate = -1;
	private double integrity = -1;
	private boolean lent = false;
	private String lentPerson = "";
	private int lentDate = -1;
	private boolean ordered = false;
	private String orderedPerson = "";
	private int orderedDate = -1;

	/**
	 * 设置书的isbn码
	 * @param isbn 注意是字符串，不是数字
	 */
	public void setIsbn(String isbn) { this.isbn = isbn; }
	/**
	 * 设置书名（默认为空字符串""）
	 * @param name
	 */
	public void setName(String name) { this.name = name; }
	/**
	 * 设置作者（默认为空字符串""）
	 * @param author
	 */
	public void setAuthor(String author) { this.author = author; }
	/**
	 * 设置出版社（默认为空字符串""）
	 * @param press
	 */
	public void setPress(String press) { this.press = press; }
	/**
	 * 设置出版时间（默认为-1）
	 * @param publicationDate 一个8位整数，格式为yyyymmdd（比如2016年7月6日应写为20160706），方法内部不会对数值的合法性进行判断
	 */
	public void setPublicationDate(int publicationDate) { this.publicationDate = publicationDate; }
	/**
	 * 设置完好程度（默认为-1，是一个不合法的值）
	 * @param integrity 数值应当在0~1之间（方法内部不会对数值的合法性进行判断）
	 */
	public void setIntegrity(double integrity) { this.integrity = integrity; }
	/**
	 * 设置是否被借出，若被借出，则应当继续设置lentPerson、lentDate；若未被借出，lentPerson、lentDate的值不需考虑
	 * @param lent 借出为true，未被借出为false
	 */
	public void setLent(boolean lent) { this.lent = lent; }
	/**
	 * 设置借书的人（的id）
	 * @param id 借书人的id
	 */
	public void setLentPerson(String id) { lentPerson = id; }
	/**
	 * 设置借出时间（默认为-1）
	 * @param lentDate 一个8位整数，格式为yyyymmdd（比如2016年7月6日应写为20160706），方法内部不会对数值的合法性进行判断
	 */
	public void setLentDate(int lentDate) { this.lentDate = lentDate; }
	/**
	 * 设置是否被预定，若被预定，则应当继续设置orderedPerson、orderedDate；若未被借出，orderedPerson、orderedDate的值不需考虑
	 * @param ordered 预定为true，未被预定为false
	 */
	public void setOrdered(boolean ordered) { this.ordered = ordered; }
	/**
	 * 设置预定的人（的id）
	 * @param id 预定的人的id
	 */
	public void setOrderedPerson(String id) { orderedPerson = id; }
	/**
	 * 设置预定时间（默认为-1）
	 * @param orderedDate 一个8位整数，格式为yyyymmdd（比如2016年7月6日应写为20160706），方法内部不会对数值的合法性进行判断
	 */
	public void setOrderedDate(int orderedDate) { this.orderedDate = orderedDate; }

	/**
	 * 获取书的isbn码
	 * @return 书的isbn码 
	 */
	public String getIsbn() { return isbn; }
	/**
	 * 获取书名
	 * @return 书名（若没有书名，则为空字符串""）
	 */
    public String getName() { return name; }
    /**
     * 获取作者
     * @return 作者（若没有作者，则为空字符串""）
     */
    public String getAuthor() { return author; }
    /**
     * 获取出版社
     * @return 出版社（若没有出版社，则为空字符串""）
     */
    public String getPress() { return press; }
    /**
     * 获取出版时间
     * @return 出版时间，一个8位整数，格式为yyyymmdd（比如2016年7月6日应写为20160706）；若没有出版时间，则返回-1
     */
    public int getPublicationDate() { return publicationDate; }
    /**
     * 获取书的完好程度
     * @return 0~1之间的一个实数
     */
    public double getIntegrity() { return integrity; }
    /**
     * 获取书是否被借出
     * @return 借出为true，未被借出为false
     */
    public boolean getLent() { return lent; }
    /**
     * 获取借出书的人
     * @return 若书被借出，则为借书人的id；若书未被借出，则返回内容不确定
     */
    public String getLentPerson() { return lentPerson; }
    /**
     * 获取借出书的日期
     * @return 借出日期，一个8位整数，格式为yyyymmdd（比如2016年7月6日应写为20160706）；若没有借出，则返回数字不确定
     */
    public int getLentDate() { return lentDate; }
    /**
     * 获取书是否被预定
     * @return 预定为true，未被预定为false
     */
    public boolean getOrdered() { return ordered; }
    /**
     * 获取预定书的人
     * @return 若书被预定，则为预定人的id，若书未被预定，则返回内容不确定
     */
    public String getOrderedPerson() { return orderedPerson; }
    /**
     * 获取预定书的日期
     * @return 预定日期，一个8位数，格式为yyyymmdd（比如2016年7月6日应写为20160706）；若没有预定，则返回数字不确定
     */
    public int getOrderedDate() { return orderedDate; }

}
