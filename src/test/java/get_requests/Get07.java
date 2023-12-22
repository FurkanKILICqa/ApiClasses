package get_requests;

import org.junit.Test;

public class Get07 {

    /*
        Given
            https://restful-booker.herokuapp.com/booking/11
        When
            User send a GET request to the URL
        Then
            HTTP Status Code should be 200
        And
            Response content type is "application/json"
        And
            Response body should be like;
                        {
                            "firstname": "John",
                            "lastname": "Smith",
                            "totalprice": 111,
                            "depositpaid": true,
                            "bookingdates": {
                                "checkin": "2018-01-01",
                                "checkout": "2019-01-01"
                            },
                            "additionalneeds": "Breakfast"
                        }

                        Task 1


     */

    @Test
    public void name() {






    }
}
