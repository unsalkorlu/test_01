package com.ukorlu.utility;

import java.io.StringReader;
import java.io.StringWriter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class XmlUtil {

	public static final String DEFAULT_ENCODING = "UTF-8";

	public static <T> String convertToXml(T source, Class<T> type, String encoding) {
		StringWriter stringWriter = new StringWriter();
		try {
			JAXBContext carContext = JAXBContext.newInstance(type);
			Marshaller marshaller = carContext.createMarshaller();
			marshaller.setAdapter(new MapAdapter());
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.setProperty(Marshaller.JAXB_ENCODING, (encoding != null) ? encoding : DEFAULT_ENCODING);
			marshaller.marshal(source, stringWriter);
			return stringWriter.toString();
		} catch (JAXBException e) {
			throw new RuntimeException(e);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static <T> String convertToXml(T source, Class<T> type) {
		return convertToXml(source, type, DEFAULT_ENCODING);
	}

	@SuppressWarnings("unchecked")
	public static <T> T convertFromXml(String source, Class<T> type) {
		StringReader reader = new StringReader(source);
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(type);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			jaxbUnmarshaller.setAdapter(new MapAdapter());
			return (T) jaxbUnmarshaller.unmarshal(reader);
		} catch (JAXBException e) {
			throw new RuntimeException(e);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}