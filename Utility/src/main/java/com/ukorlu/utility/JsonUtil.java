package com.ukorlu.utility;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonUtil {

	private static GsonBuilder INSTANCE;

	public static GsonBuilder getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new GsonBuilder();
			INSTANCE.setPrettyPrinting();
		}
		return INSTANCE;
	}

	/**
	 * 
	 * ObjectMapper mapper = new ObjectMapper();
	 * 
	 * // 1. convert JSON array to Array objects Content content =
	 * mapper.readValue(source, Content.class);
	 * 
	 * // 2. convert JSON array to List of objects List<StudentInfo> ppl2 =
	 * Arrays.asList(mapper.readValue(source, StudentInfo[].class));
	 * 
	 * @param <T>
	 * @param source
	 * @return
	 */
	public static <T> String convertToJson(T source) {
		String json = null;
		try {
			Gson gson = getInstance().create();
			json = gson.toJson(source);
		} catch (Exception ignored) {
		}
		return json;
	}

	public static <T> T convertFromJson(String source, Class<T> type) {
		Gson gson = getInstance().create();
		return gson.fromJson(source, type);
	}
}
