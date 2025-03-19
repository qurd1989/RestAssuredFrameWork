package product.utils;

import com.spotify.oauth2.utils.PropertyUtils;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigLoader {

    private static Properties properties;


    static {
        try {
            InputStream input = Thread.currentThread().getContextClassLoader().getResourceAsStream("config.properties");
            if (input == null) {
                throw new RuntimeException("Unable to find config.properties file");
            }
            properties = new Properties();
            properties.load(input);
        } catch (IOException e) {
            throw new RuntimeException("Failed to read from config.properties file");
        }
    }
    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}