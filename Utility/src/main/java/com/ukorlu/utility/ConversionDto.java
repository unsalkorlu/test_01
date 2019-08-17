package com.ukorlu.utility;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * xml conversion annotations https://howtodoinjava.com/jaxb/jaxb-annotations/
 * 
 * @author unsalk
 *
 */
@XmlRootElement(name = "ConversionDto")
@XmlAccessorType(XmlAccessType.FIELD)
public class ConversionDto implements Serializable {

	private static final long serialVersionUID = -1128560438958857539L;

	@XmlElement(name = "field1")
	private String field1;

	@XmlElement(name = "field2")
	private String field2;

	@XmlElement(name = "field3")
	private String field3;

	public String getField1() {
		return field1;
	}

	public void setField1(String field1) {
		this.field1 = field1;
	}

	public String getField2() {
		return field2;
	}

	public void setField2(String field2) {
		this.field2 = field2;
	}

	public String getField3() {
		return field3;
	}

	public void setField3(String field3) {
		this.field3 = field3;
	}

}
