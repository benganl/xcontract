package za.co.wyzetech.cms.util;

import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Component
public class JsonUtil {
    private final Gson gson; // todo Thread-safe?

    JsonUtil() {
	gson = new GsonBuilder().setLenient().serializeNulls().create();
    }

    public String toJson(Object object) {
	return gson.toJson(object);
    }

    public <T> T fromJson(String json, Class<T> klass) {
	return gson.fromJson(json, klass);
    }
}
