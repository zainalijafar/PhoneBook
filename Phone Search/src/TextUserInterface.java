import java.util.Scanner; 
import java.util.*;
public class TextUserInterface {

	private Scanner reader; 
	private Phonebook phoneBook; 
	
	public TextUserInterface() {
		
		this.reader = new Scanner(System.in);
		this.phoneBook = new Phonebook();
	}
	
	public void start() {
		
		systemOutput();
		
		while(true) {
			
			int userInput = userInput();
			
			if (userInput== 1) {
				
				addNumber();
				
			}else if (userInput== 2) {
				
				System.out.println("Number : " + searchForNumber());
				
			}else if (userInput== 3) {
				
				System.out.println("Number corresponds to " + searchForPersonByNumber());
				
			}else if (userInput== 4) {
				
				addAddress();
				
			}else if (userInput== 5) {
				
				printInfo();
				
			}else if (userInput == 6) {
				
				deleteInfo();
				
			}else if (userInput == 8) {
				
				System.out.println("Thank you for using the system");
				break;
				
			}else if (userInput == 7) {
				
				filteredListing();
			}
		}
	}
	
	public void systemOutput() {
		
		System.out.println("Phone Search : ");
		System.out.println("Available Operations : ");
		System.out.println("[1] Add a number : ");
		System.out.println("[2] Search for a number : ");
		System.out.println("[3] Search for a person by phone number : ");
		System.out.println("[4] Add an address : ");
		System.out.println("[5] Search for personal information : ");
		System.out.println("[6] Delete personal information : ");
		System.out.println("[7] Filtered Listing : ");
		System.out.println("[8] Quit");
	}
	
	public int userInput() {
		
		System.out.println("Command : "); 
		String input = this.reader.nextLine();
		int output = parseStringtoInt(input);
		return output;
	}
	
	public int parseStringtoInt(String input) {
		
		return Integer.parseInt(input);
	}
	
	public void addNumber() {
		
		System.out.println("Whose Number : ");
		String input = this.reader.nextLine();
		System.out.println("Number : ");
		String number = this.reader.nextLine();
		this.phoneBook.addNumber(input,number);
	}
	
	public ArrayList <String> searchForNumber() {
		
		System.out.println("Whose Number: ");
		String input = this.reader.nextLine();
		
		return this.phoneBook.searchForNumber(input);
	}
	
	public String searchForPersonByNumber() {
		
		System.out.println("Number : ");
		String input = this.reader.nextLine();
		
		return this.phoneBook.searchForPersonByNumber(input);
	}
	
	public void addAddress() {
		
		System.out.println("Whose Address : ");
		String input = this.reader.nextLine();
		System.out.println("Enter address : ");
		String address = this.reader.nextLine();
		this.phoneBook.addAddress(input,address);
	}
	
	public void printInfo() {
		
		System.out.println("Whose Information : ");
		String input = this.reader.nextLine(); 
		this.phoneBook.printInfo(input);
	}
	
	public void deleteInfo() {
		
		System.out.println("Whose Information would you like to delete : ");
		String input = this.reader.nextLine();
		this.phoneBook.deleteInfo(input);
	}
	
	public void filteredListing() {
		
		System.out.println("Enter keyword : ");
		String input = this.reader.nextLine(); 
		this.phoneBook.filteredList(input);
	}
}