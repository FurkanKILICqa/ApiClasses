package base_urls;

import io.restassured.builder.RequestSpecBuilder;
import org.junit.Before;

public class PetStoreBaseUrl {



    @Before
    public void setUp(){
        String baseUrl ="https://petstore.swagger.io/v2";
        spec = new RequestSpecBuilder().setBaseUri(baseUrl).build();
    }
}
