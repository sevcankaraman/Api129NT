package get_requests.Exercises;

import base_urls.JsonPlaceHolderBaseUrl;
import base_urls.ReqresInBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.equalToObject;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class Task01 extends ReqresInBaseUrl {
    //1)

     /*
        Given
            https://reqres.in/api/users/3
        When
            User sends a GET Request to the url
        Then
            HTTP Status Code should be 200
        And
            Content Type should be JSON
        And
            Status Line should be HTTP/1.1 200 OK
     */

    @Test
    public void get01(){
        //set the url
        spec.pathParams("first","users","second",3);

       // Set the excepted data

        //Send the request and gert the response
        Response response=given(spec).get("{first}/{second}");
        response.prettyPrint();

        //Do assertion
        response.then().
                statusCode(200).contentType(ContentType.JSON).
                statusLine("HTTP/1.1 200 OK");

    }

    //2)
       /*
        Given
            https://reqres.in/api/users/23
        When
            User send a GET Request to the url
        Then
            HTTP Status code should be 404
        And
            Status Line should be HTTP/1.1 404 Not Found
        And
            Server is "cloudflare"
        And
            Response body should be empty
     */
    @Test
    public void get02(){
        //set the url
        spec.pathParams("first","users","second",23);

        //Send the excepted data

        //Send the request and get the response
        Response response=given().spec(spec).get("{first}/{second}");
        response.prettyPrint();

        //Do assertion
        assertEquals(404,response.statusCode());
        assertEquals("HTTP/1.1 404 Not Found",response.statusLine());
        assertEquals("cloudflare",response.getHeader("Server"));
        assertTrue(response.as(HashMap.class).isEmpty());

    }
    //3)

     /*
       Given
           https://reqres.in/api/users/2
       When
           User send GET Request to the URL
       Then
           HTTP Status Code should be 200
       And
           Response format should be “application/json”
       And
           “email” is “janet.weaver@reqres.in”,
       And
           “first_name” is "Janet"
       And
           “last_name” is "Weaver"
       And
           "text" is "To keep ReqRes free, contributions towards server costs are appreciated!"
    */
@Test
    public void get(){
    //set the url
    spec.pathParams("first","users","second",2);

    //Send the request and get the response
   Response response= given(spec).when().get("{first}/{second}");
   response.prettyPrint();

   //Do assertion
    response.
            then().
            statusCode(200).
            contentType(ContentType.JSON).
            body("data.email",equalTo("janet.weaver@reqres.in"),
                    "data.first_name",equalTo("Janet"),
                    "data.last_name",equalTo("Weaver"),
                    "support.text",equalTo("To keep ReqRes free, contributions towards server costs are appreciated!"));


}
    }