package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import pojo.JsonPojo;
import utilities.ConfigReader;

import static baseUrl.JsonUrl.specJson;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class JsonGET {

    String endpoint="";
    Response response;
    JsonPath resJp;



    @Given("kullanici url adresine gider")
    public void kullanici_base_url_adresine_gider() {

        specJson.pathParams("pp1","posts","pp2",70);

    }
    @Then("kullanici GET request gonderip gelen responsu kaydeder")
    public void kullanici_get_request_gonderip_gelen_responsu_kaydeder() {

        response=given().spec(specJson).when().get("{pp1}/{pp2}");
    }
    @Then("kullanici status kodunun {int} oldugunu test eder")
    public void kullanici_status_kodunun_oldugunu_test_eder(int statusCode) {

        assertEquals(statusCode,response.getStatusCode());

    }
    @Then("kullanici content type degerinin {string} oldugunu test eder")
    public void kullanici_content_type_degerinin_oldugunu_test_eder(String contentType) {

        assertEquals(contentType,response.getContentType());

    }
    @Then("kullanici donen cevaptaki degerleri test eder")
    public void kullanici_donen_cevaptaki_userid_degerinin_oldugunu_test_eder() {

        resJp=response.jsonPath();
        JsonPojo actualData=response.as(JsonPojo.class);

        assertEquals(actualData.getUserId(),resJp.getInt("userId"));
        assertEquals(actualData.getId(),resJp.getInt("id"));
        assertEquals(actualData.getTitle(),resJp.getString("title"));
        assertEquals(actualData.getBody(),resJp.getString("body"));



    }



}
