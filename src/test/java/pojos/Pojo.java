package pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pojo {
    /*
     {
            "reason": "product mismatch"
        }
     */

    private String reason;
}