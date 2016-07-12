package LibrarySystem;

public class Event {
	
	public static int BORROW = 0;
	public static int RETURN = 1;
	public static int RENEW = 2;
	
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

	public int getId() { return id; };
	public int getDate() { return date; };
	public int getType() { return type; };
	public String getIsbn() { return isbn; };
	public String getUserId() { return userId; }
	public String getManagerId() { return managerId; }
	public double getBeforeIntegrity() { return beforeIntegrity; }
	public double getAfterIntegrity() { return afterIntegrity; }


}
