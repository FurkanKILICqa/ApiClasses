package get_requests;

import base_urls.JsonPlaceHolderBaseUrl;
import org.junit.Test;

import java.util.Map;

public class Get11_NestedMap extends JsonPlaceHolderBaseUrl {


    /*
        Given
            https://restful-booker.herokuapp.com/booking/51
        When
            I send GET Request to the url
        Then
            Response body should be like that;
                {
                    "firstname": "Jane",
                    "lastname": "Doe",
                    "totalprice": 111,
                    "depositpaid": true,
                    "bookingdates": {
                        "checkin": "2018-01-01",
                        "checkout": "2019-01-01"
                    },
                    "additionalneeds": "Extra pillows please"
                }
     */

    @Test
    public void name() {
       //Url kurulacak
        spec.pathParams("first","booking","second",51);


        //Beklenen data kurulur


        //Nested yapılır beklerken data en içteki yapıdan başlayarak olusturulur


        Map<String,String> bookingMap




    }
}
