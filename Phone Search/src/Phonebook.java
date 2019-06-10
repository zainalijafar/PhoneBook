import java.util.*;
public class Phonebook {

	private Map<String,ArrayList<String>> numberByName;
	private Map<String, String> nameByNumber; 
	private Map<String, String > mapAddress;
	
	public Phonebook() {
		
		this.numberByName = new HashMap<>();
		this.nameByNumber = new HashMap<>();
		this.mapAddress = new HashMap<>();
	}
	
	public void addNumber(String input,String phoneNumber) {
		
		if(!this.numberByName.containsKey(input)) {
			
			this.numberByName.put(input,new ArrayList<>());
		}
		
		if(!this.nameByNumber.containsKey(phoneNumber)) {
			
			this.nameByNumber.put(phoneNumber,input);
		}
		this.numberByName.get(input).add(phoneNumber);
	}
	
	public ArrayList<String> searchForNumber(String input) {
		
		return this.numberByName.get(input);
	}
	
	public String searchForPersonByNumber(String number) {
		
		return this.nameByNumber.get(number);
	}
	
	public void printInfo(String input) {

		System.out.println("Address : ");
		
		if (this.mapAddress.containsKey(input)) {
			
			System.out.println(this.mapAddress.get(input));
			
		}else {
			
			System.out.println("Address not found");
		}
		System.out.println("Phone Numbers : ");
		System.out.println(this.numberByName.get(input));
	}
	
	public void addAddress(String name,String address){
		
		if (!this.mapAddress.containsKey(name)) {
			
			this.mapAddress.put(name,address);
		}
	}
	
	public String returnAddress(String name) {
		
		return this.mapAddress.get(name);
	}
	
	public void deleteInfo(String name) {
		
		this.nameByNumber.remove(name);
		this.numberByName.remove(name);
		this.mapAddress.remove(name);
	}
	
	public void filteredList(String keyword) {
		
		boolean found = false; 
//		System.out.println(this.numberByName.keySet());
		for(String name : this.numberByName.keySet()){
			
			if(name.contains(keyword) || (this.mapAddress.containsKey(name) && this.mapAddress.get(name).contains(keyword))) {
				
				found = true;
				printInfo(name);
			}
		}
		if(!found) {
			System.out.println("The keyword was not found ");
		}
	}
}