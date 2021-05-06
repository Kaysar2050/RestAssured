import org.testng.Assert;
import org.testng.annotations.Test;

import files.Payload;
import io.restassured.path.json.JsonPath;

public class SumValidation {
	//Verify if Sum of all Course prices matches with Purchase Amount
	  @Test
	  
	  public void SumOfCourse() 
	  {
		  int sum = 0;
		  JsonPath js = new JsonPath(Payload.CoursePrice());
		  
		  int count=js.get("courses.size()");
		         
		  for(int i = 0;i<count;i++) 
		  { 
			  int price=js.get("courses["+i+"].price");
			  int copies=js.get("courses["+i+"].copies");
              int amount= price*copies;
              System.out.println(amount);
              sum=sum+amount;
            
	  }
		  System.out.println(sum);
		int purchaseamount=  js.get("dashboard.purchaseAmount");
		Assert.assertEquals(sum, purchaseamount);
}
}