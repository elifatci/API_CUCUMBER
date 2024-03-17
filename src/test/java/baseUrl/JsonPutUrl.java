package baseUrl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class JsonPutUrl {

    public static RequestSpecification specJ;

    public static void spec(){
        specJ=new RequestSpecBuilder()
                .setContentType(ContentType.JSON).setAccept(ContentType.JSON)
                .setBaseUri("https://jsonplaceholder.typicode.com/").build();
    }
}
