package com.example.demo.urlShortener.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.demo.urlShortener.entity.URL;

public interface UrlService {

	public String createShortingUrl(URL url) throws Exception;

	public void readOriginalUrl(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
