package get_requests;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Get02 {

    /*
       Given
           https://restful-booker.herokuapp.com/booking/0
       When
           User send a GET Request to the url
       Then
           HTTP Status code should be 404
       And
           Status Line should be HTTP/1.1 404 Not Found
       And
           Response body contains "Not Found"
       And
           Response body does not contain "TechProEd"
       And
           Server is "Cowboy"
 */
    //4) Otomasyon testi yazarken aşağıdaki adımları izleyebiliriz:
    //        i) Url kurulacak
    //        ii) Beklenen data belirlenecek
    //        iii) Request gönderilip Response alınacak
    //        iv) Doğrulamalar yapılacak

    @Test
    public void name() {

        //i) Url kurulacak
        String url = "https://restful-booker.herokuapp.com/booking/10";


        Response response = given().
                when().
                get(url);

        response.prettyPrint();



    }
}
