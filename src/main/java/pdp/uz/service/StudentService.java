package pdp.uz.service;

import com.github.javafaker.DateAndTime;
import com.github.javafaker.Faker;
import com.github.javafaker.Name;
import pdp.uz.model.Student;
import pdp.uz.util.FileUtil;

import java.sql.Date;
import java.time.LocalDate;
import java.util.StringJoiner;

/**
 * Created by Avazbek on 10/02/25 10:37
 */
public class StudentService {
    public static String generateStudents(int count) {
        Faker faker = new Faker();
        Name name = faker.name();
        DateAndTime date = faker.date();
        StringJoiner joiner = new StringJoiner("\n", "[", "]");
        LocalDate birthDate = new Date(date.birthday(18, 35).getTime()).toLocalDate();
        for (int i = 0; i < count; i++) {
            Student student = new Student(
                    name.firstName(),
                    name.lastName(),
                    name.username(),
                    name.bloodGroup(),
                    birthDate
            );
            joiner.add(student.toString());
        }
        String fileName = "files/students.txt";
        FileUtil.saveToFile(joiner, fileName);
        return fileName;
    }


}
