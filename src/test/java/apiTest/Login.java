package apiTest;

import org.junit.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;

public class Login {
    static{
        baseURI = "http://qa-duobank.us-east-2.elasticbeanstalk.com/api";
    }

   @Test
    public void testLoginAPItoUI(){
        String email = "jtravolta2022@gmail.com";
        String password = "jt2022";

        given().
                body("\"email\" : \""+email+"\",\n" +
                        "    \"password\" : \""+password+"\"").
                when().log().all().
                post("/login.php  ").
                then().log().all().
                assertThat().
                statusCode(200).
                time(lessThan(3000L));

}
}
