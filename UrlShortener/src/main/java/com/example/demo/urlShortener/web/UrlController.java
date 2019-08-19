package com.example.demo.urlShortener.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.urlShortener.entity.URL;
import com.example.demo.urlShortener.service.UrlService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping(value = "/")
public class UrlController {


	static final Logger log = LoggerFactory.getLogger(UrlController.class);

	@Autowired
	private UrlService service;

	/**
	 *
	 * @param url
	 * @return
	 */
	@PostMapping("/url/shortingUrl")
	public URL shortingUrl(@RequestBody URL url) throws Exception{
		log.info("START UrlController shortingUrl:" + url.getURL());

		url.setResult(service.createShortingUrl(url));
		return url;
	}

	/**
	 *
	 * @param url
	 * @return
	 */
	@RequestMapping("/*")
	public void originalUrl(HttpServletRequest request, HttpServletResponse response) throws Exception{
		log.info("START UrlController originalUrl");
		service.readOriginalUrl(request, response);
	}
}
