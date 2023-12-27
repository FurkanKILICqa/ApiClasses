package post_requests;

import base_urls.JsonPlaceHolderBaseUrl;
import org.junit.Test;
import pojos.JsonPlaceHolderPojo;

public class Post04 extends JsonPlaceHolderBaseUrl {


    /*
         Given
            https://jsonplaceholder.typicode.com/todos
            {
            "userId": 55,
            "title": "Tidy your room",
            "completed": false
            }
        When
            I send POST Request to the Url
        Then
            Status code is 201
        And
            response body is like {
                                    "userId": 55,
                                    "title": "Tidy your room",
                                    "completed": false,
                                    "id": 201
                                    }
                                    NOT:
    @JsonIgnoreProperties(ignoreUnknown = true) annotasyonu, JSON verisindeki bilinmeyen alanları yoksaymak için kullanılır.
    Bu annotasyon, Java sınıfındaki alanlarla eşleşmeyen veya bilinmeyen JSON alanlarını görmezden gelir.
     */

    @Test
    public void name() {





    }
}
