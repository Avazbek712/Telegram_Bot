package pdp.uz.model;

import lombok.*;

import java.time.LocalDate;

/**
 * Created by Avazbek on 10/02/25 10:27
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString

public class Student {
    private String firstName;
    private String lastName;
    private String userName;
    private String bloodGroup;
    private LocalDate birthDate;
}
