package LibrarySystem;

class Person {
	
	public static int STUDENT = 0;
	public static int MANAGER = 1;
	
	private String id;
	private int idType;
	private String name;
	private String lentA;
	private String lentB;
	private String lentC;
	private int lentADate;
	private int lentBDate;
	private int lentCDate;

	public void setId(String id) { this.id = id; }
	public void setIdType(int idType) { this.idType = idType; }
	public void setName(String name) { this.name = name; }
	public void setLentA(String lentA) { this.lentA = lentA; }
	public void setLentB(String lentB) { this.lentB = lentB; }
	public void setLentC(String lentC) { this.lentC = lentC; }
	public void setLentADate(int lentADate) { this.lentADate = lentADate; }
	public void setLentBDate(int lentBDate) { this.lentBDate = lentBDate; }
	public void setLentCDate(int lentCDate) { this.lentCDate = lentCDate; }

	public String getId() { return id; }
	public int getIdType() { return idType; }
	public String getName() { return name; }
	public String getLentA() { return lentA; }
	public String getLentB() { return lentB; }
	public String getLentC() { return lentC; }
	public int getLentADate() { return lentADate; }
	public int getLentBDate() { return lentBDate; }
	public int getLentCDate() { return lentCDate; }
	
}
