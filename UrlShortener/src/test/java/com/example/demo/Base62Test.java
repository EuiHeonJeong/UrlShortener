package com.example.demo;

import org.junit.Test;

import com.example.demo.urlShortener.service.Base62;

public class Base62Test {

	@Test
	public void testBase62() throws Exception{
		String[] url = {
				"https://www.naver.com/"
				,"https://www.google.com/"
				,"https://www.bing.com/"
				,"https://www.daum.net/"
				,"https://en.wikipedia.org/wiki/URL_shortening"
				,"https://example.com/assets/category_B/subcategory_C/Foo/"
				,"https://en.wikipedia.org/wiki/URL_shortening"
		};

		Base62 base62 = new Base62();

		for(int i=0; i<url.length; i++) {
			String base62Encode = base62.encode(url[i]);
			System.out.println(base62Encode);
		}
	}
}
