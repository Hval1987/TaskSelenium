package com.cyborg.core.generic.dataUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.Properties;
import java.util.Set;

import org.apache.log4j.PropertyConfigurator;

// This is the SingleTon Class
public class PropertiesDataUtils {
    private Properties properties = null;
    public static LinkedHashMap<String, String> configDataStore = new LinkedHashMap<String, String>();
    InputStream is = null;
    // This is the static and private reference of the class which you could use anywhere in you framework
    private static PropertiesDataUtils propertiesDataUtils = null;
    boolean centralizeLog = false;

    // This is the Private constructor to create the object
    // but you can not access this from outside the class
    // to maintain the design of the SingleTon pattern ie only one object creation .
    private PropertiesDataUtils(String filePath) {
        generateDataStore(filePath);
        centralizeLog = Boolean.parseBoolean(PropertiesDataUtils.configDataStore.get("centralizedLog"));
        if (centralizeLog)
            PropertyConfigurator.configure(System.getProperty("user.dir") + "//src//test//resources//config//log4j_central.properties");
        else
            PropertyConfigurator.configure(System.getProperty("user.dir") + "//src//test//resources//config//log4j_local.properties");
    }

    private PropertiesDataUtils() {
    }


    // This method basically create the instance of the SingleTon class
    public static PropertiesDataUtils getInstance(String filePath) {
        if (propertiesDataUtils == null)
            propertiesDataUtils = new PropertiesDataUtils(filePath);
        return propertiesDataUtils;
    }

    // this method basically creates the datastore
    // where you want to store all the config data as discussed previously
    private void generateDataStore(String filePath) {
        try {
            this.properties = new Properties();
            is = new FileInputStream(filePath);
            properties.load(is);
            overrideFromEnvironment();
            Set<Object> keys = loadAllKeys();
            for (Object k : keys) {
                String key = (String) k;
                configDataStore.put(key, getPropertyValue(key));
            }
        } catch (FileNotFoundException fileNotFoundException) {
            String exceptionData = String.valueOf(fileNotFoundException.getCause().getMessage());
        } catch (IOException ioException) {
            String exceptionData = String.valueOf(ioException.getCause().getMessage());
        } finally {
            if (null != is) {
                try {
                    is.close();
                } catch (Exception e) {
                    String exceptionData = String.valueOf(e.getCause().getMessage());
                }
            }
        }
    }

    // This method is used to load all the keys from the properties file.
    private Set<Object> loadAllKeys() {
        Set<Object> keys = this.properties.keySet();
        return keys;
    }

    private String getPropertyValue(String key) {
        return this.properties.getProperty(key);
    }

    private void setPropertyValue(String key, String value) {
        this.properties.setProperty(key, value);
    }

    private void overrideFromEnvironment() {
        if (this.properties.getProperty("run_on_jenkins").equals("true")) {
            System.out.println("SET run_on_jenkins FLAG TO FALSE IN YOUR PROPERTIES FILE TO RUN LOCALLY....");
            String build_number = System.getenv("BUILD_NUMBER");
            this.properties.setProperty("build_number", build_number);
        }

    }
}