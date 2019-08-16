package com.ukorlu;

import com.ukorlu.utility.ConversionDto;
import com.ukorlu.utility.FileUtil;
import com.ukorlu.utility.JsonUtil;

/**
 * Hello world!
 *
 */
public class App {

	public static void main(String[] args) {
		String jsonFile = FileUtil.readFile("input.json");
		ConversionDto conversion = JsonUtil.convertFromJson(jsonFile, ConversionDto.class);
		StringBuilder builder = new StringBuilder();
		builder.append(conversion.getField1() + ";");
		builder.append(conversion.getField2() + ";");
		builder.append(conversion.getField3() + ";");
		FileUtil.writeFile("output.csv", builder.toString());
	}
}
