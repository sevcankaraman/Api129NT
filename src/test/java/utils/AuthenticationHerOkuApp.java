package utils;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class AuthenticationHerOkuApp {

    //HerOkuApp api için token üreten method
    public static String generateToken(){

        String body = "{ \"username\" : \"admin\", \"password\" : \"password123\" }";

        Response response = given().contentType(ContentType.JSON).body(body).post("https://restful-booker.herokuapp.com/auth");

        return response.jsonPath().getString("token");
    }

}