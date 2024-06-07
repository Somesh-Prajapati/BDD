package dataProviders;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {

    private Properties properties;
    private final String propertyFilePath = "src/test/resources/configuration.properties";

    public ConfigFileReader() {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration.properties File not found at " + propertyFilePath);
        }
    }

    public String getApplicationUrl(){
        String url = properties.getProperty("url");
        if (url!=null){
            return url;
        }else {
            throw new RuntimeException("Url not specified at configuration.properties file");
        }
    }

    public String getBrowser(){
        String browser = properties.getProperty("browser");
        if (browser!=null){
            return browser;
        }else
            throw new RuntimeException("Browser not specified at configuration.properties file");
    }

    public long getImplicitWait(){
        String implicitWait = properties.getProperty("implicitWait");
        if (implicitWait !=null){
            return Long.parseLong(implicitWait);
        }else
            throw new RuntimeException("implicit wait is not specified at configuration.properties file");
    }

    public long getExplicitWait(){
        String explicitWait = properties.getProperty("explicitWait");
        if (explicitWait !=null){
            return Long.parseLong(explicitWait);
        }else
            throw new RuntimeException("explicit wait is not specified at configuration.properties file");
    }

    public long getPageLoadTimeout() {
        String pageLoadTimeout = properties.getProperty("pageLoadTimeout");
        if (pageLoadTimeout != null)
            return Long.parseLong(pageLoadTimeout);
        else
            throw new RuntimeException("pageLoadTimeout not specified in the Configuration.properties file.");
    }


}
