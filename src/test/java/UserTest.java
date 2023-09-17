
import DataModels.User.User;
import DataModels.Generic.ApiResponse;
import Utils.GenericUtil;
import Utils.TestBase;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

/**
 * Test Class for User Service
 */
@Test(groups = "regression")
public class UserTest extends TestBase {

    RequestSpecification requestSpecification;
    GenericUtil genericUtil;

    @BeforeTest
    public void setUp() {
        requestSpecification = buildRequestSpec(setRequestSpec("stagingEnv"));
        genericUtil = new GenericUtil();
    }

    @Test(dataProvider = "UserCreateData", priority = 1, groups = "user_service,smoke")
    public void validateUserCreation(User [] user){
        ApiResponse response = given()
                .spec(requestSpecification)
                .body(user)
                .post("/user/createWithArray").as(ApiResponse.class);
        Assert.assertEquals(200, response.getCode());
        Assert.assertEquals("unknown", response.getType());
        Assert.assertEquals("ok", response.getMessage());
    }

    @Test(dataProvider = "UserUpdateData", priority = 2, groups = "user_service,smoke")
    public void validateUpdatedUser(User [] users){
        for(User user : users){
            Reporter.log("Updating details of user " + user.getId());
            ApiResponse response = given()
                    .spec(requestSpecification)
                    .and()
                    .body(user)
                    .put("/user/" + user.getUsername())
                    .as(ApiResponse.class);
            Assert.assertEquals(200, response.getCode());
            Assert.assertEquals("unknown", response.getType());
            Assert.assertNotNull(response.getMessage());

            User getUser = given()
                    .spec(requestSpecification)
                    .and()
                    .get("/user/" + user.getUsername())
                    .as(User.class);
            Assert.assertEquals(user.getId(),getUser.getId());
            Assert.assertEquals(user.getUsername(),getUser.getUsername());
            Assert.assertEquals(user.getLastName(),getUser.getLastName());
            Assert.assertEquals(user.getFirstName(),getUser.getFirstName());
            Assert.assertEquals(user.getEmail(),getUser.getEmail());
            Assert.assertEquals(user.getPhone(),getUser.getPhone());
            Assert.assertEquals(user.getUserStatus(),getUser.getUserStatus());
        }
    }


}
