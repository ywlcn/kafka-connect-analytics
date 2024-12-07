package com.sea.utils;

import java.io.StringWriter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class StringUtils {

	@Autowired
	ObjectMapper objectMapper;

	public <T> T fromJson(String json, Class<T> type) throws Exception {
		try {
			return objectMapper.readValue(json, type);
		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	public String toJson(Object obj) throws Exception {
		StringWriter sw = new StringWriter();

		try {
			objectMapper.writeValue(sw, obj);
		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
		return sw.toString();
	}

}
