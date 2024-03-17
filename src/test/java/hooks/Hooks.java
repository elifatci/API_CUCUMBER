package hooks;

import io.cucumber.java.Before;


import static baseUrl.JsonPutUrl.spec;
import static baseUrl.JsonUrl.setUpJson;


public class Hooks {

    @Before
    public void before(){


        //setUpJson();
        spec();


    }


}
