package com.example.tianfeng.smallpos.utils;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;


public class GsonUtil {
	public static <T> T jsonToBean(String result, Class<T> clazz) {
		Gson gson = new Gson();
		T t = gson.fromJson(result, clazz);
		
		return t;
	}
	
	public static <T> T jsonToBean(String result, Type type) {
		Gson gson = new Gson();
		T t = gson.fromJson(result, type);
		return t;
	}

	public static <T> String beanToJson(T t) {
		Gson gson = new Gson();
		return gson.toJson(t);
	}

	public static boolean isError(String result) {
		JSONObject object = null;
		try {
			object = new JSONObject(result);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		if (object.has("error")) {
			return true;
		} else {
			return false;
		}
	}

}
