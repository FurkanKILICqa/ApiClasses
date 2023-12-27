package get_requests;

public class Get12_NestedPojo {

/*
        Given
            https://restful-booker.herokuapp.com/booking/535
        When
 		    I send GET Request to the URL
 	    Then
 		    Status code is 200
 		And
 		    Response body is like:
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
     */

    @Test
    public void get(){
        // Url Kurulur
        spec.pathParams("first","booking","second",563);

        // Beklenen data oluşturulur
        BookingPojo boookings = new BookingPojo("2018-01-01","2019-01-01");
        HerokuAppPojo expectedData = new HerokuAppPojo("John","Smith",111,true,boookings,"Breakfast");

        // Request ------ Response
        Response response = given(spec).when().get("{first}/{second}");
        response.prettyPrint();

        // Doğrulamalar yapılır:
        HerokuAppPojo actualData =  response.as(HerokuAppPojo.class);

        assertEquals(200,response.statusCode());
        assertEquals(expectedData.getFirstname(),actualData.getFirstname());
        assertEquals(expectedData.getLastname(),actualData.getLastname());
        assertEquals(expectedData.getDepositpaid(),actualData.getDepositpaid());
        assertEquals(expectedData.getTotalprice(),actualData.getTotalprice());
        assertEquals(boookings.getCheckin(),actualData.getBookingdates().getCheckin());
        assertEquals(boookings.getCheckout(),actualData.getBookingdates().getCheckout());
        assertEquals(expectedData.getAdditionalneeds(),actualData.getAdditionalneeds());
    }



}
