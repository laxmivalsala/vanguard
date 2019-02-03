package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Properties;

public class PropertyReader {

    /***
     * Read property file based on a key
     * @param key
     * @return value assigned to key
     */
    public String readProperty(String key) {

        Properties prop = new Properties();
        InputStream input = null;
        String value = "";
        try {

            String filename = System.getProperty("user.dir") + "\\config.properties";
            input = new FileInputStream(filename);

            if (input == null) {
                System.out.println("Sorry, unable to find " + filename);
                return null;
            }

            prop.load(input);
            value = prop.getProperty(key);

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return value;
    }

    /***
     * Read property file based on key
     * @param propFilePath
     * @param key
     * @return value assigned to key
     */
    public String readProperty(String propFilePath,String key) {

        Properties prop = new Properties();
        InputStream input = null;
        String value = "";
        try {

            input = new FileInputStream(propFilePath);

            if (input == null) {
                System.out.println("Sorry, unable to find " + propFilePath);
                return null;
            }

            prop.load(input);
            value = prop.getProperty(key);

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return value;
    }


}
