package LibrarySystem;

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

	public void setIsbn(String isbn) { this.isbn = isbn; }
	public void setName(String name) { this.name = name; }
	public void setAuthor(String author) { this.author = author; }
	public void setPress(String press) { this.press = press; }
	public void setPublicationDate(int publicationDate) { this.publicationDate = publicationDate; }
	public void setIntegrity(double integrity) { this.integrity = integrity; }
	public void setLent(boolean lent) { this.lent = lent; }
	public void setLentPerson(String lentPerson) { this.lentPerson = lentPerson; }
	public void setLentDate(int lentDate) { this.lentDate = lentDate; }
	public void setOrdered(boolean ordered) { this.ordered = ordered; }
	public void setOrderedPerson(String orderedPerson) { this.orderedPerson = orderedPerson; }
	public void setOrderedDate(int orderedDate) { this.orderedDate = orderedDate; }

	public String getIsbn() { return isbn; }
    public String getName() { return name; }
    public String getAuthor() { return author; }
    public String getPress() { return press; }
    public int getPublicationDate() { return publicationDate; }
    public double getIntegrity() { return integrity; }
    public boolean getLent() { return lent; }
    public String getLentPerson() { return lentPerson; }
    public int getLentDate() { return lentDate; }
    public boolean getOrdered() { return ordered; }
    public String getOrderedPerson() { return orderedPerson; }
    public int getOrderedDate() { return orderedDate; }

}
