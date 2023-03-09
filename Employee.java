/*
 * Employee is based on my Person class from the Phonebook
 * 
 * Contains lots of information about each employee and contains methods to
 * set/get information.
 */
public class Employee 
{
	public String fullName;
	public String firstName;
	public String lastName;
	public String middleName;
	public String phoneNumber;
	public String areaCode;
	public String number;
	public String address;
    public int eID;
	public Employee(String inFullName, String inPhoneNumber, String inAddress, int inEID)
	{
		
		setName(inFullName.trim());
		
		setPhoneNumber(inPhoneNumber.trim());
		
		setAddress(inAddress.trim());

        eID = inEID;
	}
    public int getEID()
    {
        return eID;
    }
	public void setName(String inFullName)
	{
		fullName = inFullName;
		String[] nameArray= fullName.split("\\s");
		switch(nameArray.length)
		{
			case 1: firstName = nameArray[0];
					middleName = "";
					lastName = "";
					break;
			case 2: firstName = nameArray[0];
					middleName = "";
					lastName = nameArray[1];
					break;
			case 3: firstName = nameArray[0];
					middleName = nameArray[1];
					lastName = nameArray[2];
					break;
			default: System.out.println("Error: Name doesn't exist");
		}
	}
	public void setPhoneNumber(String inPhoneNumber)
	{
		if(inPhoneNumber.contains("(") && inPhoneNumber.contains(")") && inPhoneNumber.contains("-"))
		{
			phoneNumber = inPhoneNumber;
			areaCode = inPhoneNumber.substring(1, 4);
			number = inPhoneNumber.substring(5);
		}
		else if(inPhoneNumber.contains("-") && inPhoneNumber.length() == 12)
		{
			areaCode = inPhoneNumber.substring(0, 3);
			number = inPhoneNumber.substring(4);
			phoneNumber = "(" + areaCode + ")" + number;
		}
		else if(inPhoneNumber.length() == 10)
		{
			areaCode = inPhoneNumber.substring(0, 3);
			number = inPhoneNumber.substring(3, 6) + "-" + inPhoneNumber.substring(6);
			phoneNumber = "(" + areaCode + ")" + number;
		}
	}
	public void setAddress(String inAddress)
	{
		address = inAddress;
	}
	public String toString()
	{
		return String.format("%03d", eID) + ": " + fullName + ", " + phoneNumber + ", " + address;
	}
}