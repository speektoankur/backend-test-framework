package UserData;

import DataModels.Pet.Category;
import DataModels.Pet.Pet;
import DataModels.Pet.Tag;
import DataModels.User.User;
import DataModels.eNums.StatusEnums;
import Utils.GenericUtil;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Test function Data Providers
 */
public class DataProviders extends GenericUtil {

    @DataProvider(name="UserCreateData")
    public Object[][] userCreateData() {
        List<User> users = JSONReader.getUsersFromJSON("createUsers.json");
        User [] userArray = users.toArray(new User[users.size()]);
        return new Object [][] {
                {userArray}
        };
    }

    @DataProvider(name="UserUpdateData")
    public Object[][] userUpdateData() {
        List<User> users = JSONReader.getUsersFromJSON("updateUsers.json");
        User [] userArray = users.toArray(new User[users.size()]);
        return new Object [][] {
                {userArray}
        };
    }

    @DataProvider(name="petData")
    public Object[][] petData(Method method) {
        List<Pet> pets = new ArrayList<>();
        if(method.getName().equals("testCreateMultiplePets")){
            pets = JSONReader.getPetsFromJSON("createNewPet.json");
        }
        if(method.getName().equals("testUpdatePetDetails") || method.getName().equals("testUpdatedData")){
            pets = JSONReader.getPetsFromJSON("updatePets.json");
        }
        Pet [] userArray = pets.toArray(new Pet[pets.size()]);
        Object [][] data = new Object[pets.size()][1];
        int counter = 0;
        for(Pet pet : userArray){ data[counter++][0] = pet;}
        return data;
    }

}
