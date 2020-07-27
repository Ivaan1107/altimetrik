package StepDef;



import java.util.List;
import java.util.Map;

import org.junit.Assert;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ApiTest {
	
	public final String BASE_URL="https://docs.postman-echo.com/?version=latest";
	private static Response response;
	private static String token;
	private static final String USERNAME = "postman";
	 private static final String PASSWORD = "password";
	 private static String jsonString;
	
	 @Given("^Manage dependencies between API calls\\.$")
	 public void manage_dependencies_between_API_calls() throws Throwable {
		 RestAssured.baseURI = BASE_URL;
		 RequestSpecification request = RestAssured.given();
		 request.header("Content-Type", "application/json");
		 response = request.body("{ \"userName\":\"" + USERNAME + "\", \"password\":\"" + PASSWORD + "\"}")
				 .post("/basic-auth");
				
	     throw new PendingException();
	 }

	 @When("^Verify the response status code\\.$")
	 public void verify_the_response_status_code() throws Throwable {
		 Assert.assertEquals(204, response.getStatusCode());
	     throw new PendingException();
	 }

	 @Then("^Verify the response contents$")
	 public void verify_the_response_contents() throws Throwable {
		 jsonString = response.asString();
		 List<Map<String, String>> params = JsonPath.from(jsonString).get("foo1");
		 Assert.assertEquals(0, params.size());
	     throw new PendingException();
	 }



}
