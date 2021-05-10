package com.toy.toyboard.shared;

import com.google.gson.Gson;

public class JsonUtil {
    //
    private static Gson gson = new Gson();

    public static String toJson(Object target) {
        //
        return gson.toJson(target);
    }
}
