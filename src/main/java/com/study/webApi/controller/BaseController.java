package com.study.webApi.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import com.study.infrastructure.extension.HttpRequestUtility;

public class BaseController {
	private static final Logger log = LoggerFactory.getLogger(BaseController.class);
	
	protected byte[] getRequestPostBytes(HttpServletRequest request) {
		if(request == null) {
			return null;
		}
		byte[] content = null;
		
		try {
			content = HttpRequestUtility.getRequestPostBytes(request);
		} catch (IOException e) {
			log.error("An error occured while get post");
		}
		
		return content;
	}
	
	protected MultipartFile getMultipartFileFromRequest(HttpServletRequest request) {
		if(request == null) {
			return null;
		}
		byte[] content = this.getRequestPostBytes(request);
		
		if(content == null || content.length == 0) {
			return null;
		}
//		MultipartFile file = Base64DecodedMultipartFile(request);
		return null;
	}
}
