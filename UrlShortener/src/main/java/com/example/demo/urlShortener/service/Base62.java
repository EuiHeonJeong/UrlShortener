package com.example.demo.urlShortener.service;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class Base62 {

	static final Logger log = LoggerFactory.getLogger(Base62.class);

	private Long counter = 1L;
	private static Map<String, Long> urlToIndex = new HashMap<String, Long>();
	private static Map<Long, String> indexToUrl = new HashMap<Long, String>();
	static final char[] BASE62 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789".toCharArray();

	private String path = "http://localhost:8080/";

	/**
	 * Encodes a URL to a shortened URL.
	 * @param originalUrl
	 * @return
	 */
	public String encode(String originalUrl) {
		if (urlToIndex.containsKey(originalUrl)) {
			return path+base62Encode(urlToIndex.get(originalUrl));
		} else {
			urlToIndex.put(originalUrl, counter);
			indexToUrl.put(counter, originalUrl);
			counter++;
			return path+base62Encode(urlToIndex.get(originalUrl));
		}
	}

	/**
	 * Decodes a shortened URL to its original URL.
	 * @param shortenUrl
	 * @return
	 */
	public String decode(String shortenUrl) {
		String base62 = shortenUrl.substring(shortenUrl.lastIndexOf("/") + 1);
		long decode = 0;
		for(int i = 0; i < base62.length(); i++) {
			decode = decode * 62 + new String(BASE62).indexOf("" + base62.charAt(i));
		}

		return indexToUrl.get(decode);
	}

	/**
	 *
	 * @param value
	 * @return
	 */
	private String base62Encode(long value) {
		StringBuilder sb = new StringBuilder();
		while (value != 0) {
			sb.append(BASE62[(int)(value % 62)]);
			value /= 62;
		}
		while (sb.length() < 8) {
			sb.append(0);
		}
		return sb.reverse().toString();
	}

}
