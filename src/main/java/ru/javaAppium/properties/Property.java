package ru.javaAppium.properties;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

@Slf4j
public class Property {


    public static String getCustomProperty(String propertyName){
        String propertyValue  = System.getProperty(propertyName);
        log.debug("Getting value from jenkins: value {} = {}",propertyName, propertyValue);
        if ( StringUtils.isEmpty(propertyValue)) {
            propertyValue = findVariableInConfig(propertyName);
        }

        return propertyValue;
    }

    public static String findVariableInConfig(String propertyName){
        String configPath = "config.properties";
        return getConfigPropertyVariable(configPath, propertyName);
    }

    public static String findVariableInCredential(String propertyName){
        String configPath = "credential.properties";
        return getConfigPropertyVariable(configPath, propertyName);

    }

    private static String getConfigPropertyVariable(String configName, String variableName) {
        String rootPath = Objects.requireNonNull(Thread.currentThread().getContextClassLoader().getResource("")).getPath();
        String configPath = rootPath + configName;
        String variableValue = null;

        Properties configProperty = loadProperty(configPath);
        variableValue = configProperty.getProperty(variableName);

        if (variableValue == null){
            throw new IllegalArgumentException(
                    String.format("ERROR: variable '%s' in config.properties wa not found!", variableName));
        }
        log.info("Used value from ConfigProperties file. {} = {}", variableName, variableValue);
        return variableValue;
    }

    private static Properties loadProperty(String path){
        try {
            Properties prop = new Properties();
            prop.load(new FileInputStream(path));
            return prop;
        } catch (IOException ex) {
            log.error("ERROR: '.properties' file is not found!", ex);
            ex.printStackTrace();
        }
        return null;
    }
}
