package com.ukorlu;

import java.io.File;

import com.ukorlu.utility.ConversionDto;
import com.ukorlu.utility.FileUtil;
import com.ukorlu.utility.XmlUtil;

/**
 * Hello world!
 *
 */
public class App {

	public static void main(String[] args) {
		if (new File("input.xml").exists()) {
			String jsonFile = FileUtil.readFile("input.xml");
			ConversionDto conversion = XmlUtil.convertFromXml(jsonFile, ConversionDto.class);
			StringBuilder builder = new StringBuilder();
			builder.append(conversion.getField1() + ";");
			builder.append(conversion.getField2() + ";");
			builder.append(conversion.getField3() + ";");
			FileUtil.writeFile("output.csv", builder.toString());
		} else {
			System.out.println("Input file does not exist.");
		}
	}
}
