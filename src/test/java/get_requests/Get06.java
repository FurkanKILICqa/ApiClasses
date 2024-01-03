package get_requests;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Get06 extends HerOkuAppBaseUrl {


    /*
       Given
           https://restful-booker.herokuapp.com/booking
       When
           User sends get request to the URL 11 22 33 44 55
       Then
           Status code is 200
       And
           Among the data there should be someone whose firstname is "John" and lastname is "Smith"
    */

    @Test
    public void name() {

        // i) Url kurulacak
        spec.pathParam("first","booking")
                .queryParams("firstname","John"
                        ,"lastname","Smith");

        // ii) Beklenen data belirlenecek
        // iii) Request gönderilip Response alınacak
        Response response =  given(spec).when().get("{first}");
        response.prettyPrint();

        // iv) Doğrulamalar yapılacak
        // 1. yol:
        response
                .then()
                .statusCode(200)
                .body("bookingid",hasSize(greaterThan(0)))
                .body(containsString("bookingid"));


        // 2. yol:
        assertEquals(200,response.statusCode());
        assertTrue(response.asString().contains("bookingid"));


    }
}
