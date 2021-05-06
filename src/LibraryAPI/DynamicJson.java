package LibraryAPI;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import files.Payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

public class DynamicJson {
	
	@Test(dataProvider="BookData")
	
	public void AddBook(String isbn, String aisle ) {
		
		RestAssured.baseURI="http://216.10.245.166";
		String response=
		given().log().all().header("Content-Type","application/json").body(Payload.AddBook(isbn,aisle))
		.when().post("/Library/Addbook.php")
		.then().log().all().assertThat().statusCode(200).extract().response().asString();
		
		JsonPath js = new JsonPath(response);
		      String id=js.get("ID");
		      System.out.println(id);
		
	}
      @DataProvider(name="BookData")
      
      public Object[][] getData() 
      {
    	  
    	return  new Object[][]{{"hgjhfj","4654"},{"hadfu","8456"},{"gscx","2195"}};
      }

}
