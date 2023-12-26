package test_data;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class HerokuAppTestData {



    public static Map<String,String> bookingMapper(String checkin, String checkout){
        Map<String,String> bookingMap = new HashMap<>();
        bookingMap.put("checkin",checkin);
        bookingMap.put("checkout",checkout);
        System.out.println("bookingMap = " + bookingMap);


        return bookingMap;
    }

    public static Map<String,Object> herokuAppMapper(){
        Map<String,Object> map = new HashMap<>();




    }


}
