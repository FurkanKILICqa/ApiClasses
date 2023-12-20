package get_requests;

import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.not;

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
        String url = "https://restful-booker.herokuapp.com/booking/0";


        Response response = given().
                when().
                get(url);

        response.prettyPrint();


       response.
               then().
               statusCode(404).//HTTP Status code should be 404
               statusLine("HTTP/1.1 200 OK")//Status Line should be HTTP/1.1 404 Not Found
               .body(containsString("Not Found"))
               .body(not(containsString("TechProEd")));



      String responseSt =  response.asString();
      Assert.assertTrue(responseSt.contains("Not Found"));
      Assert.assertFalse(responseSt.contains("TechProEd"));

      String server = response.header("Server");


    }
}
