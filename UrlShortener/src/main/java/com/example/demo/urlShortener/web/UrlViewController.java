package com.example.demo.urlShortener.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping(value = "/")
public class UrlViewController {

	@RequestMapping("index")
	public String index() {
		return "index";
	}
}
