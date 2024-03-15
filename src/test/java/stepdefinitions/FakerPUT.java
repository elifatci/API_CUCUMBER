package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import pojo.FakerPojo;

import static BaseUrl.FakerUrl.specFaker;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class FakerPUT {

    Response response;
    FakerPojo expData;


    @Given("faker url'e gidilir ve {string} {string} {string} pathparams ile endpoint olusturulur")
    public void faker_url_e_gidilir_ve_endpoint_olusturulur(String pp1,String pp2,String pp3) {

      specFaker.pathParams(pp1,pp2,pp3);

    }
    @Given("expected data olusturulur")
    public void expected_data_içinde_id_title_marathon_due_date_21t18_063z_completed_false_olusturulur() {

        expData=new FakerPojo(1075,"marathon","2024-03-21T18:57:26.063Z",false);
         response=given().contentType(ContentType.JSON).when().spec(specFaker).body(expData.toString()).put("{pp1}/{pp2}/{pp3}");

    }
    @Then("donen response body assert ile dogrulanir")
    public void donen_response_body_nin_id_title_marathon_due_date_21t18_063z_completed_false_oldugu_dogrulanir() {

        FakerPojo actualData=response.as(FakerPojo.class);

        assertEquals(expData.getId(),actualData.getId());
        assertEquals(expData.getTitle(),actualData.getTitle());
        assertEquals(expData.getDueData(),actualData.getDueData());
        assertEquals(expData.isCompleted(),actualData.isCompleted());
    }
}
