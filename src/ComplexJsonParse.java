import files.Payload;
import io.restassured.path.json.JsonPath;

public class ComplexJsonParse {

	public static void main(String[] args) {
		
        JsonPath js = new JsonPath(Payload.CoursePrice());  
        //Print Number of courses returned by API
           int count=js.get("courses.size()");
           System.out.println(count);
           //Print Purchase Amount
        int  totalAmount=  js.getInt("dashboard.purchaseAmount");
        System.out.println(totalAmount);
        //Print Title of the first course
      String titleFirstcoursName= js.getString("courses[0].title");
        System.out.println(titleFirstcoursName);
        // Print All course titles and their respective Prices
        
        for(int i = 0;i<count;i++) {
        	//All course titles
        	String coursetitle=js.get("courses["+i+"].title");
        	System.out.println(coursetitle);
        	//respective Prices
        	System.out.println(js.get("courses["+i+"].price").toString());
        	//Print number  of copies sold by RPA Course
        
        	
        }
        
        for(int i=0;i<count;i++) {
        	String coursetitle=js.get("courses["+i+"].title");
        	if(coursetitle.equalsIgnoreCase("RPA"))
        	{
        	int copiesofRPA=js.get("courses["+i+"].copies");
        	System.out.println(copiesofRPA);
        	break;
        }
	}

	}
}
