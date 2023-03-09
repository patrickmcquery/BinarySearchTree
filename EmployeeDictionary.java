/*
 * Patrick McQuery
 * 
 * Employee dictionary/lookup
 * 
 * Uses a binary search tree to store the employees.
 */
import java.util.Scanner;

public class EmployeeDictionary 
{
    static BinarySearchTree tree = new BinarySearchTree();
    static Scanner console = new Scanner(System.in);
    public static void main(String[] args)
    {
        System.out.println("Welcome to the employee dictionary. This program uses " +  
         "an employee ID as a primary key. Please be sure to keep them unique.\n" +
         "It stores employee names, phone numbers, and addresses in a binary search tree.");
		boolean doing = true;
		while(doing)
		{
			System.out.println("What would you like to do?");
			System.out.println("[A]dd, [M]odify, [D]elete, [L]ookup, [Q]uit");
			String resp = console.nextLine();
	        System.out.println();
	        switch (resp.toLowerCase().charAt(0))
	        {
	            case 'a':
	                add();
	                break;
	            case 'm':
	                modify();
	                break;
	            case 'd':
	                delete();
	                break;
	            case 'l':
	           	 	lookup();
	           	 	break;
	            case 'q':
	           	 	doing = false;
	           	 	break;
	            default:
	            	System.out.println("Invalid response given, please try again.");
	         }
		}
    }

    public static void add()
	{
        System.out.println("What is the employee ID of the new employee?");
        int eID = console.nextInt();
        console.nextLine();
        System.out.println("What's the name? ");
        String name = console.nextLine();
        System.out.println("What's the phone number? ");
        String phone = console.nextLine();
        System.out.println("What's the address? ");
        String address = console.nextLine();
        tree.insert(new Employee(name, phone, address, eID));
	}

    public static void delete()
    {
        System.out.println("What is the employee ID of the employee you wish to delete?");
        int eID = console.nextInt();
        console.nextLine();
        tree.delete(eID);
    }

    public static void lookup()
    {
        System.out.println("Please select P[r]e-order, [I]n-order, or P[o]st-order");
        String resp = console.nextLine();
        System.out.println();
	        switch (resp.toLowerCase().charAt(0))
	        {
	            case 'r':
                    graphic();
	                tree.traversePreOrder(tree.getRoot());
	                break;
	            case 'i':
                    graphic();
	                tree.traverseInOrder(tree.getRoot());
	                break;
	            case 'o':
                    graphic();
	                tree.traversePostOrder(tree.getRoot());
	                break;
	            default:
	            	System.out.println("Invalid response given, please try again.");
	         }
    }

    public static void graphic()
    {
        System.out.println(" _____                       _");
        System.out.println("|  ___|                     | |");
        System.out.println("| |__    ________    ____   | |   ___    _   _    ___    ___   ___    _");
        System.out.println("|  __|  |  _   _ \\  |  _ \\  | |  / _ \\  | | | |  / _ \\  / _ \\ / __|  |_|");
        System.out.println("| |___  | | | | | | | |_) | | | | (_) | | |_| | |  __/ |  __/ \\__ \\   _");
        System.out.println("|_____| |_| |_| |_| |  __/  |_|  \\___/   \\__  |  \\___|  \\___| |___/  |_|");
        System.out.println("                    | |                   __/ |                    ");
        System.out.println("                    |_|                  |___/                     ");
    }
    public static void modify()
    {
        System.out.println("What is the employee ID of the employee you would like to modify?");
        int eID = console.nextInt();
        console.nextLine();
        System.out.println("What would you like to modify?");
        System.out.println("[N]ame, [A]ddress, [P]hone number");
        String response = console.nextLine();
        System.out.println();
        System.out.println("What would you like it to be?");
        String modification = console.nextLine();
        System.out.println();
        switch (response.toLowerCase().charAt(0))
        {
            case 'n':
                tree.modifyName(eID,tree.getRoot(), modification);
                break;
            case 'a':
                tree.modifyAddress(eID,tree.getRoot(), modification);
                break;
            case 'p':
                tree.modifyPhoneNumber(eID,tree.getRoot(), modification);
                break;
            default:
                System.out.println("Invalid response given, please try again.");
        }
    }
}
