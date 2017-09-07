 

package com.axway.arrowmbs;
import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JSONUtil {

  private static GsonBuilder gsonBuilder;

  static {
    gsonBuilder = new GsonBuilder();
    gsonBuilder.serializeNulls();
    gsonBuilder.setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
  }

  public static GsonBuilder getGsonBuilder() {
    return gsonBuilder;
  }

  public static Gson getGson() {
    return gsonBuilder.create();
  }

  public static String serialize(Object obj) {
    return getGson().toJson(obj);
  }

  public static <T> T deserialize(String jsonString, Type t) {
    return getGson().fromJson(jsonString, t);
  }

}
