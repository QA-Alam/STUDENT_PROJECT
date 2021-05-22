package ups.api.dummy;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetReq {

 static	String domain = "https://jsonplaceholder.typicode.com";
	
 @Test
	public static void getRequest() {
		
		RequestSpecification httpRequest = RestAssured.given();
	
		Response  response = httpRequest.request(Method.GET, domain +  "/posts");
		
		String reponseBody = response.getBody().asString();
		System.out.println("Response body : " + reponseBody);
		
		
		// Verify the content type
		String contantType = response.header("Content-Type");
		System.out.println("Content-Type : "+contantType);
		
		Assert.assertEquals(contantType, "application/json; charset=utf-8");
		
		// Verify the content encoding 
		String contentEncoding = response.header("content-encoding");
		System.out.println("content encoding : " + contentEncoding);
		Assert.assertEquals(contentEncoding, "gzip");
		
		// Verify the status code
		 int statusCode =  response.getStatusCode();
		 System.out.println("My status code is a : "+statusCode);
		 Assert.assertEquals(statusCode, 200);
	}
 

	 @Test
	 public void GetMethodRestAssuredBDD() {
			given().param("Content-Type", "application/json; charset=utf-8")
			.when()
			.get(domain+"/posts").
			then().statusCode(200).statusLine("HTTP/1.1 200 OK")
					.body("[1].title", equalTo("qui est esse"))
					.header("Content-Encoding", "gzip").log().all();
	 
 }
}
