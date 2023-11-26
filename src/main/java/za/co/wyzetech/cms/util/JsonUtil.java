package za.co.wyzetech.cms.util;

import camundajar.impl.com.google.gson.Gson;
import camundajar.impl.com.google.gson.GsonBuilder;
import org.springframework.stereotype.Component;

@Component
public class JsonUtil {
    private final Gson gson; //todo Thread-safe?

    JsonUtil() {
        gson = new GsonBuilder()
                .setLenient()
                .serializeNulls()
                .create();

    }

    public String toJson(Object object) {
        return gson.toJson(object);
    }

    public <T> T fromJson(String json, Class<T> klass) {
        return gson.fromJson(json, klass);
    }
}
