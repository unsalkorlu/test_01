package com.ukorlu.utility;

import org.junit.Test;

import junit.framework.TestCase;

public class StringUtilTest extends TestCase {

	@Test
	public void testTrim() {
		assertEquals(StringUtil.trim("dsfasd"), "dsfasd");
		assertEquals(StringUtil.trim("dsfasd    "), "dsfasd");
		assertEquals(StringUtil.trim("   dsfasd"), "dsfasd");
		assertEquals(StringUtil.trim("   dsfasd    "), "dsfasd");
		assertEquals(StringUtil.trim("   dsfasd    "), "dsfasd");
		assertNull(StringUtil.trim(null));
	}

}
