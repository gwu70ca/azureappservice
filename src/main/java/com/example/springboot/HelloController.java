package com.example.springboot;

import java.util.Map;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@RestController
public class HelloController {

	@RequestMapping("/")
	public String index() {
		return "Greetings from Spring Boot and Azure App Service";
	}

	@GetMapping("/listHeaders")
	public ResponseEntity<String> listAllHeaders(@RequestHeader Map<String, String> headers) {
		StringBuilder buf = new StringBuilder();
		headers.forEach((key, value) -> {
			buf.append(String.format("%s = %s<br>\n", key, value));
			//LOG.info(String.format("Header '%s' = %s", key, value));
		});

		return new ResponseEntity<String>(buf.toString(), HttpStatus.OK);
	}

}
