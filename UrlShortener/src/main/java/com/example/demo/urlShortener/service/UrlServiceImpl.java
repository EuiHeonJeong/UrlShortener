package com.example.demo.urlShortener.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.urlShortener.entity.URL;

import lombok.extern.slf4j.Slf4j;

/**
 *
 * @author LG Gram15
 *
 */
@Slf4j
@Service
public class UrlServiceImpl implements UrlService{

	static final Logger log = LoggerFactory.getLogger(UrlServiceImpl.class);

	@Autowired
	Base62 base62;

	/**
	 * <pre>
	 * 단축 URL을 생성한다.
	 * </pre>
	 */
	@Override
	public String createShortingUrl(URL url)  throws Exception{
		log.info("START UrlServiceImpl createShortingUrl : "+url.getURL());
		String shortenUrl = base62.encode(url.getURL());
		return shortenUrl;
	}

	/**
	 * <pre>
	 * 단축 URL을 원래URL을 가져온다.
	 * </pre>
	 */
	@Override
	public void readOriginalUrl(HttpServletRequest request, HttpServletResponse response) throws Exception{
		log.info("START readOriginalUrl");
		String shortenUrl = request.getRequestURL().toString();
		String redirectUrl = base62.decode(shortenUrl);

		response.setStatus(HttpServletResponse.SC_MOVED_PERMANENTLY);
		response.setHeader("Location", redirectUrl);
	}
}
