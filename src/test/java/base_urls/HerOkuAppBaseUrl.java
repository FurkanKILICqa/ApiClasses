package base_urls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class HerOkuAppBaseUrl {



    protected RequestSpecification spec;
    @Before//Her test den önce çalışacak
    public void setUp(){

        String baseUrl = "https://restful-booker.herokuapp.com";
        spec= new RequestSpecBuilder().setBaseUri(baseUrl).build();




    }



}
