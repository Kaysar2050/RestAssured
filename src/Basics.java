import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;// Reambering is very important line 4 

import org.testng.Assert;

import files.Payload;
import files.ReUsableMethods;

public class Basics {

	public static void main(String[] args) {
		
		//validate if Add Place API is workimg as expected 
		//Add place-> Update Place with New Address -> Get Place to validate if New address is present in response
		
		//given -pre- action/ all input details(input header ) 
		//when - action/Submit the API -resource,http method
		//Then - validation/validate the response(output header ) 
		//log().all()==> use for see the response in console(mean result)
		// extract().response().asString(); use it with syso without log().all()
		// equalTo method  coming from org.hamcrest pakage subpakege method Matchers.*
		// Payload.Addplace()==>Files.readAll("C:\\Users\\rahul\\Documents\\Addbookdetails.json")))
		RestAssured.baseURI="https://rahulshettyacademy.com";
		String response=
		given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
		.body(Payload.Addplace()).when().post("maps/api/place/add/json")
		.then().assertThat().statusCode(200).body("scope", equalTo("APP"))
		
        .header("Server","Apache/2.4.18 (Ubuntu)").extract().response().asString();
		
		System.out.println(response);
		
		JsonPath js = new JsonPath(response); // create a JsonPath object for parsing(convert) Json
		    String placeId= js.getString("place_id");
           System.out.println(placeId);
                        //put/patch==> update 
           String newAddress = " 1000 korim cortyloroad Road NY, USA";
   		
   		given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
   		.body("{\r\n" + 
   				"\"place_id\":\""+placeId+"\",\r\n" + 
   				"\"address\":\""+newAddress+"\",\r\n" + 
   				"\"key\":\"qaclick123\"\r\n" + 
   				"}").
   		when().put("maps/api/place/update/json")
   		.then().assertThat().log().all().statusCode(200).body("msg", equalTo("Address successfully updated"));
                       // Get==> get the data from main server 
   		String getPlaceResponse=	given().log().all().queryParam("key", "qaclick123")
   				.queryParam("place_id",placeId)
   				.when().get("maps/api/place/get/json")
   				.then().assertThat().log().all().statusCode(200).extract().response().asString();
   			JsonPath js1=ReUsableMethods.rawToJson(getPlaceResponse);
   			String actualAddress =js1.getString("address");
   			System.out.println(actualAddress);
   			Assert.assertEquals(actualAddress, newAddress);
   		           
}

}
