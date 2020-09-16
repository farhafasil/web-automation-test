package steps.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Environment {
    public Properties properties;

    private static Environment _environment;


    private Environment() {
        File propertiesFile = new File("./environment.properties");
        FileInputStream fileInput = null;

        try {
            fileInput = new FileInputStream(propertiesFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        properties = new Properties();
        try {
            properties.load(fileInput);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public static Environment getInstance() {
        if(_environment == null) {
            _environment = new Environment();
        }
        return _environment;
    }
}
