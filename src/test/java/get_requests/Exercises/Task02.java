package get_requests.Exercises;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class Task02 extends HerOkuAppBaseUrl {
    //1)
       /*
        Given
            https://restful-booker.herokuapp.com/booking?firstname=Josh&lastname=Allen  ==> Data değişebilir
        When
            User sends get request to the URL
        Then
            Status code is 200
	  	And
	  		Among the data there should be someone whose firstname is "Josh" and lastname is "Allen"   ==> Data değişebilir
     */
    @Test
    public void get(){
        //Set the url
        spec.pathParam("first","booking").queryParams("firstname","Josh","lastname","Allen");


        //Sende the request and get the response
        Response response=given(spec).when().get("{first}");
        response.prettyPrint();

        //Do assertıon
        assertEquals(200,response.statusCode());
        assertTrue(response.asString().contains("bookingid"));



    }



}
