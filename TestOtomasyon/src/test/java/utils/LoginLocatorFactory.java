package utils;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.openqa.selenium.By;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class LoginLocatorFactory {

    private static final String RESOURCE = "data/login_Locators.json";
    private static final Map<String, JSONObject> INDEX = new HashMap<>();
    private static boolean initialized = false;

    private LoginLocatorFactory() {}

    // JSON'u (array) yükle ve key -> jsonObject indexini kur
    public static synchronized void init() {
        if (initialized) return;

        try (InputStream is = LoginLocatorFactory.class.getClassLoader().getResourceAsStream(RESOURCE)) {
            if (is == null) {
                throw new IllegalStateException("Locator dosyası bulunamadı (classpath): " + RESOURCE);
            }
            JSONArray arr = new JSONArray(new JSONTokener(is));
            for (int i = 0; i < arr.length(); i++) {
                JSONObject o = arr.getJSONObject(i);
                String key = o.getString("key");
                INDEX.put(key, o);
            }
            initialized = true;
        } catch (Exception e) {
            throw new RuntimeException("Locator dosyası yüklenemedi: " + e.getMessage(), e);
        }
    }

    // Gauge Hooks @BeforeSuite içinde bir kez çağır: LoginLocatorFactory.init();
    private static void ensureInit() {
        if (!initialized) init();
    }

    public static By getLocator(String key) {
        ensureInit();

        JSONObject def = INDEX.get(key);
        if (def == null) {
            throw new IllegalArgumentException("Locator bulunamadı: key=" + key);
        }

        String type = def.getString("type").trim().toLowerCase();
        String value = def.getString("value").trim();

        switch (type) {
            case "id":
                return By.id(value);
            case "name":
                return By.name(value);
            case "xpath":
                return By.xpath(value);
            case "css":
                // Eğer saf class adı verildiyse (örn: sf-OldMyAccount-...), başına '.' ekle
                if (!value.startsWith(".") && !value.startsWith("#")
                        && !value.contains(" ") && !value.contains("[")
                        && !value.contains(">") && !value.contains(":")) {
                    value = "." + value;
                }
                return By.cssSelector(value);
            default:
                throw new IllegalArgumentException("Geçersiz locator type: " + type + " (key=" + key + ")");
        }
    }
}
