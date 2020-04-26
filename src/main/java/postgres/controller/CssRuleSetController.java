package postgres.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import postgres.model.CssRuleSet;
import postgres.service.InjectedCSSService;
import postgres.service.WebpagePreferenceService;

@RestController
public class CssRuleSetController {
	
	private InjectedCSSService cssService;
	private WebpagePreferenceService webPreference;
	
	@Autowired
	public CssRuleSetController(InjectedCSSService cssService, WebpagePreferenceService webPreference) {
		this.cssService = cssService;
		this.webPreference = webPreference;
	}
	
	@RequestMapping("/GetRuleSet")
	public ResponseEntity<CssRuleSet> getRuleSetFrom(@RequestParam long id) {
		Optional<CssRuleSet> ruleSet = cssService.getByID(id);
		if (ruleSet.isPresent()) {
			return new ResponseEntity<>(ruleSet.get(), HttpStatus.FOUND);
		}
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping("/SaveRuleset")
	public ResponseEntity<CssRuleSet> createRuleSetFrom(@RequestBody String ruleSetString) {
		CssRuleSet ruleSet = cssService.create(ruleSetString);
		return new ResponseEntity<>(ruleSet, HttpStatus.CREATED);
	}
	
	@RequestMapping("/GetSessionRuleSets")
	public ResponseEntity<List<String>> getRuleSetsFrom(@RequestBody String sessionDetails){
		try {
			return new ResponseEntity<>(cssService.getRuleSetsFrom(sessionDetails), HttpStatus.FOUND);
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping("/DeleteInjectionCssRules")
	public ResponseEntity<Object> deleteWebpageChanges(@RequestBody String sessionDetails){
		try {
			List<String> ruleSets = cssService.findCssRulesetIdToDelete(sessionDetails);
			webPreference.deleteRuleSetsFrom(sessionDetails);
			cssService.deleteRuleSetsFrom(ruleSets);
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<>(null,HttpStatus.OK);
	}
	
	
}
