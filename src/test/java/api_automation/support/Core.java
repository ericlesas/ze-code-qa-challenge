package api_automation.support;

import api_automation.objects.ApiEnvironment;
import io.restassured.RestAssured;
import org.junit.BeforeClass;

public class Core extends ApiEnvironment {

    @BeforeClass
    public static void setup()
    {
        RestAssured.baseURI = baseURL;
        RestAssured.basePath = basePath;

        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }
}
