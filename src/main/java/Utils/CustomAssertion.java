package Utils;

import DataModels.Pet.Pet;
import org.testng.Reporter;

import java.util.List;

/**
 * Custom Assertions for Test Methods
 */
public class CustomAssertion {

    public boolean checkPetUpdatedDataWithGetCall(List<Pet> pets, Pet pet){
        for(Pet petEntity : pets){
            if(petEntity.getId().equals(pet.getId())){
                if(petEntity.getStatus().equals(pet.getName())){
                    return true;
                }
                else {
                    Reporter.log("Pet Status did not match with Provided ID " + petEntity.getId());
                    return false;
                }
            }
        }
        return false;
    }
}
