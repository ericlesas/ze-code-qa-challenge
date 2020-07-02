package api_automation.suites;

import api_automation.support.Core;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class GetWeather extends Core {

    @Test
    public void mustNotAccessApiWithoutKey() {
        Response response =
        given()
                .pathParam("q", "q=London")
                .pathParam("appid", "")
        .when()
                .get("/weather?{q}&{appid}");
        response.then()
                .statusCode(200)
                .body("cod", is(401))
        ;

        System.out.println("Return => " + response.body().asString());
    }

    @Test
    public void mustNotAccessApiWithoutCity() {
        given()
                .pathParam("appid", "appid=439d4b804bc8187953eb36d2a8c26a02")
        .when()
                .get("/weather?{appid}")
        .then()
                .statusCode(200)
                .body("error", is("404"))
        ;
    }

    @Test
    public void getWeatherByCity(){
        Response response =
        given()
                .pathParam("q", "q=London,uk")
                .pathParam("appid", "appid=439d4b804bc8187953eb36d2a8c26a02")
        .when()
                .get("/weather?{q}&{appid}");
        response.then()
                .statusCode(200)
        ;

        System.out.println("Return => " + response.body().asString());
    }

    @Test
    public void verifyValuesInBodyResponse() {
        given()
                .pathParam("q", "q=London")
                .pathParam("appid", "appid=439d4b804bc8187953eb36d2a8c26a02")
        .when()
                .get("/weather?{q}&{appid}")
        .then()
                .statusCode(200)
                .body("name", is("London"))
                .body("main.temp", greaterThan(-459.67f))
                .body("sys.country", is("GB"))
                .body("cod", is(200))
                .body("id", is(2643743))
        ;
    }

    @Test
    public void getWeatherByCityId(){
        Response response = given()
                .pathParam("id", "id=2643743")
                .pathParam("appid", "appid=439d4b804bc8187953eb36d2a8c26a02")
        .when()
                .get("/weather?{id}&{appid}");
        response.then()
                .statusCode(200)
        ;

        System.out.println("Return => " + response.body().asString());
    }

    @Test
    public void getWeatherBySeveralCities(){
        Response response =
        given()
                .pathParam("bbox", "bbox=12,32,15,37,10")
                .pathParam("appid", "appid=439d4b804bc8187953eb36d2a8c26a02")
        .when()
                .get("/box/city?{bbox}&{appid}");
        response.then()
                .statusCode(200)
        ;

        System.out.println("Return => " + response.body().asString());
    }

    @Test
    public void getWeatherBySeveralCityIds(){
        Response response =
        given()
                .pathParam("ids", "id=524901,703448,2643743")
                .pathParam("appid", "appid=439d4b804bc8187953eb36d2a8c26a02")
                .pathParam("units", "units=metrics")
        .when()
                        .get("group?{ids}&{units}&{appid}");
        response.then()
                .statusCode(200)
                // Based in the number of Id's
                .body("cnt", is(3))
        ;

        System.out.println("Return => " + response.body().asString());
    }

    @Test
    public void getTemperatureInCelsius(){
        Response response =
        given()
                .pathParam("q", "q=London")
                .pathParam("appid", "appid=439d4b804bc8187953eb36d2a8c26a02")
                .pathParam("units", "units=metrics")
        .when()
                .get("/find/?{q}&{units}&{appid}");
        response.then()
                .statusCode(200)
                .body("list[0].main.temp", lessThan(50))
        ;

        System.out.println("Return => " + response.body().asString());
    }
}
