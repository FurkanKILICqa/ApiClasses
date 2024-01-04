package get_requests;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Get01 {


    /*
          Given
              https://restful-booker.herokuapp.com/booking/10
          When
              User sends a GET Request to the url
          Then
              HTTP Status Code should be 200 11 22 33 44 55 66 77 88
          And
              Content Type should be application/json
          And
              Status Line should be HTTP/1.1 200 OK
 */

    //4) Otomasyon testi yazarken aşağıdaki adımları izleyebiliriz:
    //        i) Url kurulacak
    //        ii) Beklenen data belirlenecek
    //        iii) Request gönderilip Response alınacak
    //        iv) Doğrulamalar yapılacak

    @Test
    public void get() {

        //i) Url kurulacak
        String url = "https://restful-booker.herokuapp.com/booking/10";


        Response response = given().
                             when().
                            get(url);//Bu şekilde nokta koyarak yazmaya method chain denir

        response.prettyPrint();


        //Assertion yazmaya then() methoduyla başlanır

        response.
                then().
                statusCode(200).//HTTP Status Code should be 200
                contentType("application/json").//Content Type should be application/json
                statusLine("HTTP/1.1 200 OK");//Status Line should be HTTP/1.1 200 OK


    }

    @Test
    public void get02() {


    String url =    "https://restful-booker.herokuapp.com/booking/10";

        //Eğer response u başka bir yerde kullanacaksak üstteki gibi yaparız
        //Eğer tekseferde yapacaksak ve birdaha kullanmayacaksak bu şekilde yaparız
    given().
            when().
            get().
            then().
            statusCode(200).
            statusLine("application/json").
            statusLine("HTTP/1.1 200 OK");

    }
}
