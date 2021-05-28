import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Bid {

    private String userName;

    private Integer amount;
}
