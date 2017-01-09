package com.may.java.compress;

import org.junit.Test;

/**
 *
 * @author bebeside77
 */
public class HuffmanCodingTest {
	private HuffmanCoding huffmanCoding = new HuffmanCoding();

	@Test
	public void encode() throws Exception {
		huffmanCoding.encode("qqqqqssssssssccccgggggg");
	}

}