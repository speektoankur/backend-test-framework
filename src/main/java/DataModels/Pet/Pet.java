package DataModels.Pet;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import java.util.List;


@Getter
@Builder
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
public class Pet {
    public Object id;
    public Category category;
    public String name;
    public List<String> photoUrls;
    public List<Tag> tags;
    public String status;
}
