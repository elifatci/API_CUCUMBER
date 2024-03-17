package baseUrl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class JsonUrl {

    public static RequestSpecification specJson;

    public static void setUpJson(){

        specJson=new RequestSpecBuilder().setBaseUri("https://jsonplaceholder.typicode.com/").build();
    }
}
