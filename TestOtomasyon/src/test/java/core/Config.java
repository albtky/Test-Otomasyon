package core;

import io.github.cdimascio.dotenv.Dotenv;

public class Config {
    private static final Dotenv dotenv = Dotenv.configure()
            .ignoreIfMissing() // .env yoksa patlama
            .load();
    public static String getBaseUrl(){
        return dotenv.get("BASE_URL");
    }
    public static String getUserName(){
        return dotenv.get("USERNAME");
    }
    public static String getPassword(){
        return dotenv.get("PASSWORD");
    }
    public static String getBrowserName(){
        return dotenv.get("BROWSER_NAME");
    }
    public static String getUserMail(){
        return dotenv.get("USEREMAIL");
    }
}
