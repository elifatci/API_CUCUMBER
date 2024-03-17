package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class JsonPost {

       /*
    https://jsonplaceholder.typicode.com/posts url
    {
        "title":"Software",
        "body":"API is very nice to learn",
        "userId":12
        }
         donen Response'un,
        status code'unun 201,
        ve content type'inin application/json; charset=utf-8,
        ve Response Body'sindeki,
         "title"'in "Software" oldugunu
        "body" nin "learn" icerdigini
        "id" nin "101"oldugunu test edin.
     */

    String endpoint;
    Response response;
    JSONObject reqBody;
    JsonPath resJP;

    @Given("{string} and {string} available for test")
    public void and_available_for_test(String base, String path) {
       endpoint=base+path;
    }
    @When("request for {string} {string} {string}")
    public void request_for(String title, String body, String userId) {
        reqBody=new JSONObject();
        reqBody.put("title",title);
        reqBody.put("body",body);
        reqBody.put("userId",userId);

        response=given().contentType(ContentType.JSON).when().body(reqBody.toString()).post(endpoint);
    }
    @Then("verify the response {string} and {string} are valid")
    public void verify_the_response_and_are_valid(String status, String content) {

        assertEquals(Integer.parseInt(status),response.getStatusCode());
        assertEquals(content,response.getContentType());

    }
    @Then("verify the response body is {string} {string} {string} are valid")
    public void verify_the_response_body_is_are_valid(String title, String body, String id) {
        resJP=response.jsonPath();
        assertEquals(title,resJP.getString("title"));
        assertTrue(resJP.getString("body").contains(body));
        assertEquals(Integer.parseInt(id),resJP.getInt("id"));
    }
}
