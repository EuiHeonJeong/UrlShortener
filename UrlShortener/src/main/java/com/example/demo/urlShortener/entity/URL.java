package com.example.demo.urlShortener.entity;

import lombok.Data;

@Data
public class URL {

	private String URL;

	private String result;

	public String getURL() {
		return URL;
	}

	public void setURL(String uRL) {
		URL = uRL;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

}
