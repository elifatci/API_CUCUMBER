package BaseUrl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class FakerUrl {

    public static RequestSpecification specFaker;

    @Before
    public static void setUp(){
        specFaker=new RequestSpecBuilder().setBaseUri("https://fakerestapi.azurewebsites.net/api").build();
    }
}
