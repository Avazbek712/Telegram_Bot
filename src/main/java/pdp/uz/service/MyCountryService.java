package pdp.uz.service;

import com.github.javafaker.Country;
import com.github.javafaker.Faker;
import pdp.uz.model.MyCountry;
import pdp.uz.util.FileUtil;

import java.util.StringJoiner;

/**
 * Created by Avazbek on 10/02/25 10:37
 */
public class MyCountryService {
    public static String generateCountries(int count) {
        Faker faker = new Faker();
        StringJoiner joiner = new StringJoiner("\n", "[", "]");
        Country country = faker.country();
        for (int i = 0; i < count; i++) {
            MyCountry myCountry = new MyCountry(
                    country.name(),
                    country.currency(),
                    country.capital()
            );
            joiner.add(myCountry.getCountryName());
        }
        String fileName = "files/countries.txt";
        FileUtil.saveToFile(joiner, fileName);
        return fileName;
    }
}
