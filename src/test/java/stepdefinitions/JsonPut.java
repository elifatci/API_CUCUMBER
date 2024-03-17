package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojo.JPutPojo;

import static baseUrl.JsonPutUrl.specJ;
import static io.restassured.RestAssured.given;

public class JsonPut {
        /*
   https://jsonplaceholder.typicode.com/posts/70 url'ine
   asagidaki body'e sahip bir PUT request yolladigimizda
   donen response'in
       status kodunun 200,
       content type'inin "application/json; charset=utf-8",
       Connection header degerinin "keep-alive"
       ve response body'sinin asagida verilen ile ayni oldugunu test ediniz
   Response body (Expected Data) :
       {
       "title":"Ahmet",
       "body":"Merhaba",
       "userId":10,
       "id":70
       }
*/
    Response response;

    @Given("kullanici url adresine gider.")
    public void kullanici_url_adresine_gider() {
        specJ.pathParams("pp1","posts","pp2",70);
    }
    @Given("reqData olusturulup gonderilir donen cevap kaydedilir")
    public void req_data_olusturulup_gonderilir_donen_cevap_kaydedilir() {
        JPutPojo reqBody=new JPutPojo("Elif","Hi",15,70);

        response=given(specJ).body(reqBody.toString()).put("{pp1}/{pp2}");

        response.prettyPrint();
    }
    @Then("response dogrulanir")
    public void response_dogrulanir() {

    }
}
