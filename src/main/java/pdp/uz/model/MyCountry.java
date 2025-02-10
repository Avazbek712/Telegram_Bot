package pdp.uz.model;

import lombok.*;

/**
 * Created by Avazbek on 10/02/25 10:27
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString

public class MyCountry {
    private String countryName;
    private String currency;
    private String capital;
}
