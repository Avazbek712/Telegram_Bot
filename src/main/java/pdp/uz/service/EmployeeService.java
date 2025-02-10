package pdp.uz.service;

import com.github.javafaker.*;
import org.telegram.telegrambots.meta.api.objects.Message;
import pdp.uz.bot.FakerBotService;
import pdp.uz.model.Employee;

import java.sql.Date;
import java.time.LocalDate;
import java.util.StringJoiner;

import pdp.uz.util.FileUtil;

/**
 * Created by Avazbek on 10/02/25 10:36
 */
public class EmployeeService {

    public static String generateEmployees(int count) {
        Faker faker = new Faker();
        StringJoiner joiner = new StringJoiner("\n", "[", "]");

        for (int i = 0; i < count; i++) {
            Name name = faker.name();
            Address address = faker.address();
            Country country = faker.country();
            DateAndTime date = faker.date();

            LocalDate birthDate = new Date(date.birthday(18, 35).getTime()).toLocalDate();

            Employee employee = new Employee(
                    name.firstName(),
                    name.lastName(),
                    birthDate,
                    name.bloodGroup(),
                    country.name(),
                    address.city(),
                    address.streetAddress(),
                    name.title()
            );

            joiner.add(employee.toString());
        }

        String fileName = "files/employees.txt";
        FileUtil.saveToFile(joiner, fileName);
        return fileName;
    }
}

