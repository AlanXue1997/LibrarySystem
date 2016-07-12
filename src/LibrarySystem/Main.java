package LibrarySystem;

public class Main {
	
	public static void main(String[] args){
		
		LibraryDatabase libraryDatabase = new LibraryDatabase();
		LoginFrame loginFrame = new LoginFrame(libraryDatabase);
		
	}
	
}
