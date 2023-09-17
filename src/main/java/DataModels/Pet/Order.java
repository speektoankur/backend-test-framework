package DataModels.Pet;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.util.Date;

@Getter
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    public Object id;
    public Object petId;
    public int quantity;
    public Date shipDate;
    public String status;
    public boolean complete;
}
