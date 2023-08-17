package ru.javaAppium.properties;

import java.util.Arrays;

public enum PlatformName{
    PLATFORM_ANDROID("android"),
    PLATFORM_MOBILE_WEB("mobile_web"),
    PLATFORM_IOS("ios");

    public String getPlatformName() {
        return platformName;
    }

    private final String platformName;

    PlatformName(String platformName){
        this.platformName = platformName;
    }

    public static PlatformName findEnum(String value){
        return Arrays.stream(values())
                .filter(a -> a.getPlatformName().equals(value))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Can't find enum platform name"));
    }
}
