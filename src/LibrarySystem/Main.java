package LibrarySystem;

public class Main {
	
	public static void main(String[] args){
		
		LibraryDatabase libraryDatabase = new LibraryDatabase();
		//oginFrame loginFrame = new LoginFrame(libraryDatabase);
		Person person = new Person();
		person.setId("110");
		person.setName("Alan Xue");
		System.out.println(libraryDatabase.savePerson(person, "963852qaz"));
		
	}
	
}
