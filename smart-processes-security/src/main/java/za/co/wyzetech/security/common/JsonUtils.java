package za.co.wyzetech.security.common;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.stereotype.Component;

@Component
public class JsonUtils {
    private final Gson gson; // todo Thread-safe?

    JsonUtils() {
        gson = new GsonBuilder().setLenient().serializeNulls().create();
    }

    public String toJson(Object object) {
        return gson.toJson(object);
    }

    public <T> T fromJson(String json, Class<T> klass) {
        return gson.fromJson(json, klass);
    }
}
