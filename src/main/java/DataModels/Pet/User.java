package DataModels.Pet;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Getter
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
@AllArgsConstructor
public class User {
    public Object id;
    public String username;
    public String firstname;
    public String lastname;
    public String email;
    public String password;
    public String phone;
    public int userStatus;
}
