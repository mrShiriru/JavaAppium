package ru.javaAppium.properties;

import lombok.extern.slf4j.Slf4j;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;

@Slf4j
public class Property {

    public static String getConfigPropertyVariable(String variableName) {

        String rootPath = Objects.requireNonNull(Thread.currentThread().getContextClassLoader().getResource("")).getPath();
        String appConfigPath = rootPath + "config.properties";
        log.debug("appConfigPath = {}", appConfigPath);

        java.util.Properties configProperty = new java.util.Properties();
        String variableValue = null;

        try {
            configProperty.load(new FileInputStream(appConfigPath));
            variableValue = configProperty.getProperty(variableName);

        } catch (IOException e) {
            log.error("ERROR: 'config.properties' file is not found!", e);
        }

        if (variableValue == null){
            throw new IllegalArgumentException(
                    String.format("ERROR: variable '%s' in config.properties wa not found!", variableName));
        }
        log.info("Used value from ConfigProperties file. {} = {}", variableName, variableValue);
        return variableValue;
    }

}
