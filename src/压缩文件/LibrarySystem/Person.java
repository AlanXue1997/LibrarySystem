package LibrarySystem;

/**
 * 用来存一个人的信息，包括id、类型（学生\管理员）、姓名、所借图书的isbn码（3个），所借图书的时间（3个）
 * @author Alan
 *
 */
public class Person {
	
	/**
	 * 人物类型之一，表示学生，值为0
	 */
	public static int STUDENT = 0;
	/**
	 * 人物类型之一，表示管理员，值为1
	 */
	public static int MANAGER = 1;
	
	private String id = "";
	private int idType = 0;
	private String name = "";
	private String lentA = "0";
	private String lentB = "0";
	private String lentC = "0";
	private int lentADate = -1;
	private int lentBDate = -1;
	private int lentCDate = -1;

	/**
	 * 设置id（只用于用户注册时即可）
	 * @param id 注意是字符串，不是数字
	 */
	public void setId(String id) { this.id = id; }
	/**
	 * 设置人物类型
	 * @param idType 人物的类型
	 */
	public void setIdType(int idType) { this.idType = idType; }
	/**
	 * 设置姓名
	 * @param name 姓名
	 */
	public void setName(String name) { this.name = name; }
	/**
	 * 只用于LibraryDatabase内部
	 * @param lentA
	 */
	public void setLentA(String lentA) { this.lentA = lentA; }
	/**
	 * 只用于LibraryDatabase内部
	 * @param lentB
	 */
	public void setLentB(String lentB) { this.lentB = lentB; }
	/**
	 * 只用于LibraryDatabase内部
	 * @param lentC
	 */
	public void setLentC(String lentC) { this.lentC = lentC; }
	/**
	 * 只用于LibraryDatabase内部
	 * @param lentADate
	 */
	public void setLentADate(int lentADate) { this.lentADate = lentADate; }
	/**
	 * 只用于LibraryDatabase内部
	 * @param lentBDate
	 */
	public void setLentBDate(int lentBDate) { this.lentBDate = lentBDate; }
	/**
	 * 只用于LibraryDatabase内部
	 * @param lentCDate
	 */
	public void setLentCDate(int lentCDate) { this.lentCDate = lentCDate; }

	/**
	 * 获取id
	 * @return 人物的id
	 */
	public String getId() { return id; }
	/**
	 * 获取人物类型
	 * @return 人物的类型
	 */
	public int getIdType() { return idType; }
	/**
	 * 获取姓名
	 * @return 人物的姓名
	 */
	public String getName() { return name; }
	/**
	 * 获取人物借的第一本书的isbn码
	 * @return 若此人借了第一本书，则返回书的isbn码，否则返回"0"
	 */
	public String getLentA() { return lentA; }
	/**
	 * 获取人物借的第二本书的isbn码
	 * @return 若此人借了第二本书，则返回书的isbn码，否则返回"0"
	 */
	public String getLentB() { return lentB; }
	/**
	 * 获取人物借的第三本书的isbn码
	 * @return 若此人借了第三本书，则返回书的isbn码，否则返回"0"
	 */
	public String getLentC() { return lentC; }
	/**
	 * 获取人物借第一本书的日期
	 * @return 若此人借了第一本书，则返回日期，否则返回值不确定
	 */
	public int getLentADate() { return lentADate; }
	/**
	 * 获取人物借第二本书的日期
	 * @return 若此人借了第二本书，则返回日期，否则返回值不确定
	 */
	public int getLentBDate() { return lentBDate; }
	/**
	 * 获取人物借第三本书的日期
	 * @return 若此人借了第三本书，则返回日期，否则返回值不确定
	 */
	public int getLentCDate() { return lentCDate; }
	
}
