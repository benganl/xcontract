package za.co.wyzetech.cms.common.utils;

import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

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
