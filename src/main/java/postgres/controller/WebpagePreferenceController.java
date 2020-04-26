package postgres.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;

import postgres.model.WebpagePreference;
import postgres.service.WebpagePreferenceService;

@RestController
public class WebpagePreferenceController {
	
	private WebpagePreferenceService webpagePreferenceService;
	
	@Autowired
	public WebpagePreferenceController(WebpagePreferenceService webpagePreferenceService) {
		this.webpagePreferenceService = webpagePreferenceService;
	}
	
	@RequestMapping("/CreateWepagePreference")
	public ResponseEntity<WebpagePreference> createUserFromId(@RequestBody String webpagePrefString) {
		WebpagePreference webpagePreference = null;
		try {
			webpagePreference = webpagePreferenceService.create(webpagePrefString);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>(webpagePreference, HttpStatus.CREATED);
	}
	
}
