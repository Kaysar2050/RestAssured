package files;

public class Payload {
	
	public static String Addplace() {
		
		return "{\n"
				+ "\"location\": {\n"
				+ "\"lat\": -38.383494,\n"
				+ "\"lng\": 33.427362\n"
				+ "},\n"
				+ "\"accuracy\": 50,\n"
				+ "\"name\": \"Humayun  kabir \",\n"
				+ "\"phone_number\": \"347-701-0437\",\n"
				+ "\"address\": \"412 stratford Road NY, USA\",\n"
				+ "\"types\": [\n"
				+ "\"shoe park\",\n"
				+ "\"shop\"\n"
				+ "],\n"
				+ "\"website\": \"http://google.com\",\n"
				+ "\"language\": \"French-IN\"\n"
				+ "}\n"
				+ "";
	}
    public static String CoursePrice() {
    	
    	
    	return"{\n"
    			+ "\"dashboard\": {\n"
    			+ "\"purchaseAmount\": 910,\n"
    			+ "\"website\": \"rahulshettyacademy.com\"\n"
    			+ "},\n"
    			+ "\"courses\": [\n"
    			+ "{\n"
    			+ "\"title\": \"Selenium Python\",\n"
    			+ "\"price\": 50,\n"
    			+ "\"copies\": 6\n"
    			+ "},\n"
    			+ "{\n"
    			+ "\"title\": \"Cypress\",\n"
    			+ "\"price\": 40,\n"
    			+ "\"copies\": 4\n"
    			+ "},\n"
    			+ "{\n"
    			+ "\"title\": \"RPA\",\n"
    			+ "\"price\": 45,\n"
    			+ "\"copies\": 10\n"
    			+ "}\n"
    			+ "]\n"
    			+ "}";
    }
    public static  String AddBook(String isbn, String aisle) 
    {
    	return "{\n"
    			+ "\n"
    			+ "\"name\":\"Learn Appium Automation with Java\",\n"
    			+ "\"isbn\":\"bcd\",\n"
    			+ "\"aisle\":\"568\",\n"
    			+ "\"author\":\"John foe\"\n"
    			+ "}\n"
    			+ "";
    }
}
