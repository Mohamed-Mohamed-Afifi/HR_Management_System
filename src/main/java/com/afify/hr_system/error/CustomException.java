package com.afify.hr_system.error;

import java.util.Map;

import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

@Component
public class CustomException extends DefaultErrorAttributes{
	@Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest,ErrorAttributeOptions options){
		Map<String,Object> errorAttributes=super.getErrorAttributes(webRequest, options);
		errorAttributes.put("sucess", Boolean.FALSE);
		errorAttributes.put("status",errorAttributes.get("status"));
		errorAttributes.put("massage",errorAttributes.get("error"));
		errorAttributes.remove("path");
		errorAttributes.remove("error");
		return errorAttributes;
	}

}
