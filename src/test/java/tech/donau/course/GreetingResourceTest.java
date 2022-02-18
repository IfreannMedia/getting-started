package tech.donau.course;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.startsWith;

@QuarkusTest
public class GreetingResourceTest {

    @Test
    public void testHelloEndpoint() {
        given()
          .when().get("/hello")
          .then()
             .statusCode(200)
             .body(is("_hello test! your country name: Testland your country id: 23"));
    }


    @Test
    public void testHelloNameEndpoint() {
        final String name = "Montgomery";
        given()
                .when().get("/hello/" + name)
                .then()
                .statusCode(200)
                .body(is(String.format("Hello %s, your id is: %s", name, "1234")));
    }
}