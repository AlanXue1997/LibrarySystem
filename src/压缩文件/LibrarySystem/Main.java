package LibrarySystem;

public class Main {
	
	public static void main(String[] args){
		
		LibraryDatabase libraryDatabase = new LibraryDatabase();
		LoginFrame loginFrame = new LoginFrame(libraryDatabase);
		//System.out.println(libraryDatabase.borrowBook("1153710506", "9787535759467", "110", 20160713));
		//System.out.println(libraryDatabase.returnBook("1153710506", "9787535759467", "110", 20160713, 1));
		
		//ManagerFrame mFrame = new ManagerFrame(libraryDatabase, libraryDatabase.getPerson("110"));
		//WmFrame.frame.setVisible(true);
		
		//System.out.println(libraryDatabase.orderBook("1153710506", "9787511321862", 20160715));
		//System.out.println(libraryDatabase.renewBook("1153710507", "9787535733597", 20160715));
	}
	
}
