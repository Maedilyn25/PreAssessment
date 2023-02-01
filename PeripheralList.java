//Maedilyn T. Balilaon
//BSIT-2A


import java.util.*;
import java.util.ArrayList;

class PCHardware{
	  String name;
	  String peripheral;
	  int code;

	  PCHardware(int code, String name, String peripheral) {
	    this.name = name;
	    this.peripheral = peripheral;
	    this.code = code;
	  }

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPeripheral() {
		return peripheral;
	}

	public void setPeripheral(String peripheral) {
		this.peripheral = peripheral;
	}
}
public class PeripheralList {
	static ArrayList<PCHardware> PCHardwareList = new ArrayList<>();// ArrayList for store the objects
	
	
	  static Scanner sc = new Scanner(System.in); //declaring  these main method to accessed anywhere in the class
	 

	public static void main(String[] args) {
		boolean run = true;
		
		System.out.println("PC HARDWARE SYSTEM INVENTORY");
	    while(run) { // creating loop for the inventory menu will be iterated until choose the user to stop
	    System.out.println("INVENTORY MENU"); 
	    
	      System.out.println("[1] Add Record");
	      System.out.println("[2] View Record");
	      System.out.println("[3] Edit Record");
	      System.out.println("[4] Delete Record");
	      System.out.println("[5] Exit");
	      System.out.println("-------------------------------------------------------------------------------------------");
	      System.out.print("Choose option >> ");

	      int option = sc.nextInt();
	      switch(option) {
	        case 1:
	        	 addRecord();
	          break;
	        case 2:
	        	viewRecord();
	          break;
	        case 3:
	        	editRecord();
	          break;
	        case 4:
	        	deleteRecord();
	          break;
	        case 5:
	          run = false;
	          break;
	        default:
	          System.out.println("-----------------------------------------------------------------------------------------");
	          System.out.println("The option is Invalid");
	          System.out.println("-----------------------------------------------------------------------------------------");
	          break;
     }
   }
  }
	private static void addRecord() {
	    System.out.print("Type Peripheral Name: ");
	    String name = sc.next();
	    
	    System.out.print("Type Peripheral Code: ");
	    int code = sc.nextInt();
	    
	    System.out.print("Type Peripheral (Input/Output): ");
	    String peripheral = sc.next();

	    PCHardwareList.add(new PCHardware(code, name, peripheral));
	    
	    System.out.println("---------------------------------------------------------------------------------------------");
	    System.out.println("Record added successfully.");
	    System.out.println("----------------------------------------------------------------------------------------------");
	    
	  }
	private static void viewRecord() {
	    System.out.println("[1] View all peripherals");
	    System.out.println("[2] View available peripherals");
	    System.out.println("[3] View not available peripherals");
	    System.out.println("[4] View Input devices");
	    System.out.println("[5] View Output Devices");
	    System.out.println("[6] View Input/Output Devices");
	    System.out.println("----------------------------------------------------------------------------------------------");
	    System.out.print("Choose option >> ");
	    
	    int option = sc.nextInt();
	    switch(option) {
	      case 1:
	        System.out.println("Enter code the here >> ");
	        int code = sc.nextInt();
	        PCHardware pcHardware = getPCHardware(code);
	        
	        if(pcHardware != null) {
	          System.out.println("Code: " + pcHardware.code);
	          System.out.println("Name: " + pcHardware.name);
	          System.out.println("Peripheral: " + pcHardware.peripheral);
	        }
	        else {
	          System.out.println("-----------------------------------------------------------------------------------------");
	          System.out.println("The record was not found, Try Again....");
	          System.out.println("-----------------------------------------------------------------------------------------");
	        }
	        break;
	      case 2:
	          System.out.println("Available Peripherals:");
	          for(PCHardware pc : PCHardwareList) {
	        	  System.out.println("Code: " + pc.getCode() + " Name: " + pc.getName() + " Peripheral: " + pc.getPeripheral());
	          }
	          break;
	      case 3:
	    	  System.out.println("Assigned Peripherals:");
	    	  for(PCHardware pc : PCHardwareList) {
	    		  if(pc.peripheral.equals("Input")) {
	    			  System.out.println("Code: " + pc.getCode() + " Name: " + pc.getName() + " Peripheral: " + pc.getPeripheral());
	    	   }
	    }
	    	  break;
	      case 4:
	    	  System.out.println("Input Devices:");
	    	  for(PCHardware pc : PCHardwareList) {
	    	  if(pc.peripheral.equals("Output")) {
	    	  System.out.println("Code: " + pc.getCode() + " Name: " + pc.getName() + " Peripheral: " + pc.getPeripheral());
	    	  }
	    }
	    	  break;
	      case 5:
	    	  System.out.println("Output Devices:");
	    	  for(PCHardware pc : PCHardwareList) {
	    	  if(pc.peripheral.equals("Input-Output")) {
	    	  System.out.println("Code: " + pc.getCode() + " Name: " + pc.getName() + " Peripheral: " + pc.getPeripheral());
	    	  }
	    }
	    	  break;
	    	  default:
	    	  System.out.println("Invalid option!");
	    	  break;

	          }
	   }
	private static void editRecord() {
		System.out.print("Enter code >> ");
		int code = sc.nextInt();
		PCHardware pcHardware = getPCHardware(code);
		if(pcHardware != null) {
		System.out.print("Enter new name >> ");
		pcHardware.name = sc.next();
		System.out.print("Enter a new peripheral (Input/Output): ");
		pcHardware.peripheral = sc.next();
		System.out.println("------------------------------------------------------------------------------------------");
		System.out.println("Record successfully updated...");
		System.out.println("------------------------------------------------------------------------------------------");
		}
		else {
		System.out.println("-------------------------------------------------------------------------------------------");
		System.out.println("The record was not found...");
	
		}
		}
	private static void deleteRecord() {
		System.out.print("Enter code >> ");
		int code = sc.nextInt();
		PCHardware pcHardware = getPCHardware(code);
		if(pcHardware != null) {
		PCHardwareList.remove(pcHardware);
		System.out.println("-------------------------------------------------------------------------------------------");
		System.out.println("Successfully deleted...");
		System.out.println("-------------------------------------------------------------------------------------------");
		}
		else {
		System.out.println("No record found...");
		}
		}
	private static PCHardware getPCHardware(int code) {
		for(PCHardware pc : PCHardwareList) {
		if(pc.code == code) {
		return pc;
		}
		}
		return null;
	}
}