package pdp.uz.model;

import java.time.LocalDate;

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
public class Employee {
    private String firstName;

    private String lastName;

    private LocalDate birthDate;

    private String bloodGroup;

    private String country;

    private String city;

    private String addressLine;

    private String position;

}
