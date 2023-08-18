package ru.javaAppium.properties;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

import java.io.File;
import java.util.HashMap;

public class Server {

    private static AppiumDriverLocalService service;

    public static void startAppiumServer() {
        startServer();
        if (service == null || !service.isRunning()) {
            throw new RuntimeException("An appium server node is not started!");
        }
    }

    public static void stopAppiumServer() {
        service.stop();
    }

    private static void startServer() {
        AppiumServiceBuilder builder = new AppiumServiceBuilder();
        HashMap<String, String> environment = new HashMap<>();
        environment.put("ANDROID_HOME", "/Users/user/Library/Android/sdk");
        String path = "${PATH}:/$ANDROID_HOME/emulator:/$ANDROID_HOME/tools:/$ANDROID_HOME/tools/bin:" +
                "/$ANDROID_HOME/platform-tools:/$HOME/maven/bin:/usr/local/bin/";
        environment.put("PATH", path);

        builder
                .withEnvironment(environment)
                .withAppiumJS(new File("/usr/local/bin/appium"))
                .usingDriverExecutable(new File("/usr/local/bin/node"))
                .usingPort(4723)
                .withArgument(GeneralServerFlag.LOCAL_TIMEZONE)
                .withLogFile(new File("AppiumLog.txt"));

        service = AppiumDriverLocalService.buildService(builder);
        service.start();
    }

}
