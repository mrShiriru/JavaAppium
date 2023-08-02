package lib;

import java.util.Arrays;

public enum PlatformName{
    ANDROID_PLATFORM_NAME("android"),
    IOS_PLATFORM_NAME("ios");

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
