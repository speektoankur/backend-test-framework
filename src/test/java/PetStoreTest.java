import DataModels.Pet.*;
import DataModels.eNums.StatusEnums;
import DataModels.Generic.ApiResponse;
import Utils.CustomAssertion;
import Utils.GenericUtil;
import Utils.TestBase;
import io.restassured.common.mapper.TypeRef;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

/**
 * Test Class for Pet Store Service
 */
@Test(groups = "regression")
public class PetStoreTest extends TestBase {

    RequestSpecification requestSpecification;
    GenericUtil genericUtil;
    CustomAssertion customAssertion;
    @BeforeTest
    public void setUp() {
        requestSpecification = buildRequestSpec(setRequestSpec("stagingEnv"));
        genericUtil = new GenericUtil();
        customAssertion = new CustomAssertion();
    }

    @Test(dataProvider = "petData", groups = "regression, pet_service")
    public void testCreateMultiplePets(Pet pet){
        Response addPet = given()
                .spec(requestSpecification)
                .body(pet)
                .post("/pet");
        Reporter.log(addPet.getBody().toString());
        Assert.assertEquals(200, addPet.getStatusCode());
        addPet.prettyPrint();
    }

    @Test(dataProvider = "petData", groups = "regression, pet_service")
    public void testUpdatePetDetails(Pet pet){
        Response updatePet = given()
                .spec(requestSpecification)
                .body(pet)
                .put("/pet");
        Reporter.log(updatePet.getBody().toString());
        Assert.assertEquals(200, updatePet.getStatusCode());
    }

    @Test(dataProvider = "petData", dependsOnMethods = "testUpdatePetDetails")
    public void testUpdatedData(Pet pet){
        Response getPets = given()
                .spec(requestSpecification)
                .param("status", pet.getStatus())
                .get("/pet/findByStatus");
        List<Pet> pets = getPets.getBody().as(new TypeRef<List<Pet>>() {});
        Assert.assertEquals(customAssertion.checkPetUpdatedDataWithGetCall(pets,pet),true);
    }

}
