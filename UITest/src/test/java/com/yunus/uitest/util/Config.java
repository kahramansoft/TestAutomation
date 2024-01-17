package com.yunus.uitest.util;

import java.time.Duration;

public final class Config {
    public static String baseURL = "https://www.trendyol.com/";
    public static String chromeDriverPath = "src/test/resources/drivers/chromedriver.exe";
    public static String selectedDriver = "chrome";
    public static Duration DEFAULT_WAIT = Duration.ofSeconds(10);
    public static String validEmail = "validusermailadress@gmail.com";
    public static String validPassword = "1q2w3e4re!!";
    public static String invalidPassword = "invalidPassword";
    public static String invalidEmail = "invalidemail@gmail";
    public static String invalidEmailCharacter = "invalidPassword!!";
    public static String apiKey = "f9e0cf72";
    public static String apiURL = "https://www.omdbapi.com/";
}