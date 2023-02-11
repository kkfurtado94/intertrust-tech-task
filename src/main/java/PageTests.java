import manager.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.PageElements;

import static io.restassured.RestAssured.given;


public class PageTests extends BaseTest {


    @Test
    void UITest() {
        PageElements pageElements = new PageElements();

        pageElements.acceptCookies();
        pageElements.clickWeatherData();
        pageElements.typeCity("Tallinn");
        pageElements.clickSearch();

        Assertions.assertTrue(pageElements.locationValidatePresence());
        Assertions.assertEquals(pageElements.locationValidation(), "Tallinn");
    }

    @Test
    void apiTest(){
        String endpoint = "https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/timeline/Tallinn";

        String resp = given()
                .queryParam("unitGroup","metric")
                .queryParam("key","S724KLK6LGW2QAX6GA6QPB8JU")
                .queryParam("contentType","json").
        when()
                .get(endpoint).
        then()
                .log().body().
                assertThat().statusCode(200).extract().path("address");
        Assertions.assertEquals(resp, "Tallinn");
    }

    @Test
    void apiTestFailure(){
        String endpoint = "https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/timeline/Tallinn";

        given()
                .queryParam("unitGroup","metric")
                .queryParam("key","S724KLK6LGW2QAX6GA6QPB8JUs")
                .queryParam("contentType","json").
        when()
                .get(endpoint).
        then().log().body().
                assertThat().statusCode(401);
    }
}
