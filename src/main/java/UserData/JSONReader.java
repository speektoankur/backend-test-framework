package UserData;

import DataModels.Pet.Pet;
import DataModels.User.User;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Util to read data from JSON files
 */
public class JSONReader {

    public static List<User> getUsersFromJSON(String fileName){
        List<User> users = new ArrayList<>();
        try {
            final ObjectMapper objectMapper = new ObjectMapper();
            users = objectMapper.readValue(new File(System.getProperty("user.dir") + "/src/main/java/UserData/testData/" + fileName), new TypeReference<List<User>>() {
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }

    public static List<Pet> getPetsFromJSON(String fileName){
        List<Pet> pets = new ArrayList<>();
        try {
            final ObjectMapper objectMapper = new ObjectMapper();
            pets = objectMapper.readValue(new File(System.getProperty("user.dir") + "/src/main/java/UserData/testData/" + fileName), new TypeReference<List<Pet>>() {
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pets;
    }
    /**
    public List<List<Root>> createPartitions(List<Root> list,int streams){
        int partitionSize = list.size()/streams;
        List<List<Root>> partitions = ListUtils.partition(list, partitionSize);
        return partitions;
    }*/
}
