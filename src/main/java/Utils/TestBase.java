package Utils;

import UserData.DataProviders;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import lombok.Getter;
import org.testng.Reporter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

/**
 * Base Functionality for EndPoint calls
 */
@Getter
public class TestBase extends DataProviders {

    public static Properties configProp;
    public RequestSpecBuilder requestSpecBuilder;
    public RequestSpecification requestSpecification;

    public TestBase() {
         requestSpecBuilder = new RequestSpecBuilder();
    }

    public Properties setRequestSpec(String configName) {
        try {
            configProp = new Properties();
            FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources"
                    + "/" + configName + ".properties");
            try {
                configProp.load(ip);
            } catch (Exception loadException) {
                Reporter.log(loadException.getMessage());
            }
        } catch (FileNotFoundException exception) {
            Reporter.log(exception.getMessage());
        }
        return configProp;
    }

    public RequestSpecification buildRequestSpec(Properties configProp){
        requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.setBaseUri(configProp.getProperty("baseuri"));
        requestSpecBuilder.setContentType(ContentType.JSON);
        requestSpecification = requestSpecBuilder.build();
        return requestSpecification;
    }


}
