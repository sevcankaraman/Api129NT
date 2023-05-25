package base_urls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class JsonPlaceHolderBaseUrl {
    //Setup methodu ile tekrarlı yapıalcak işlemleri topluyoruz ve test öncesi çalısacak sekılde before anatasyonun ekliyoruz
    protected RequestSpecification spec ;

@Before // her test methodu öncesi çalısır
    public void setUp(){
    spec = new RequestSpecBuilder().setContentType(ContentType.JSON).setAccept(ContentType.JSON).setBaseUri("https://jsonplaceholder.typicode.com/").build();


}
}

