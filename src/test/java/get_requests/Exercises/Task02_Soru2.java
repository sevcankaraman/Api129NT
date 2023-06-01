package get_requests.Exercises;

import base_urls.ReqresInBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;

public class Task02_Soru2 extends ReqresInBaseUrl {
    //2)
     /*
        Given
          https://reqres.in/api/unknown/3
        When
            User send a GET request to the URL
        Then
            HTTP Status Code should be 200
        And
            Response content type is “application/json; charset=utf-8”
        And
            Response body should be like;(Soft Assertion)
        {
        "data": {
            "id": 3,
            "name": "true red",
            "year": 2002,
            "color": "#BF1932",
            "pantone_value": "19-1664"
        },
        "support": {
            "url": "https://reqres.in/#support-heading",
            "text": "To keep ReqRes free, contributions towards server costs are appreciated!"
        }}
      */

    @Test
    public void get01(){
        //Set the url
        spec.pathParams("first","unknown","second",3);

        //Set the excepten data

        //send the request and get the response
        Response response =given(spec).when().get("{first}/{second}");
        response.prettyPrint();


        JsonPath jsonPath=response.jsonPath();

        //Do assertıon
        SoftAssert softAssert=new SoftAssert();



    }

}
