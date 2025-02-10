package pdp.uz.service;

import com.github.javafaker.Country;
import com.github.javafaker.Faker;
import pdp.uz.model.Capital;
import pdp.uz.util.FileUtil;

import java.util.StringJoiner;

/**
 * Created by Avazbek on 10/02/25 10:39
 */
public class CapitalService {
    public static String generateCapitals(int count) {
        Faker faker = new Faker();
        Country country = faker.country();
        StringJoiner joiner = new StringJoiner("\n,", "[", "]");
        for (int i = 0; i < 50; i++) {
            Capital capital = new Capital(
                    country.capital(),
                    country.currency()
            );
            joiner.add(capital.toString());
        }
        String fileName = "files/capitals.txt";
        FileUtil.saveToFile(joiner, fileName);
        return fileName;
    }
}
