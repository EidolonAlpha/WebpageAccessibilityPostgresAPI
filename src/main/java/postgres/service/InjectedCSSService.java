package postgres.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import postgres.model.CssRuleSet;
import postgres.model.SessionDetails;
import postgres.repository.InjectedCssRepository;

@Service
public class InjectedCSSService {
	
	private InjectedCssRepository cssRepo;
	@Autowired
	private JdbcTemplate template;
	private ObjectMapper mapper = new ObjectMapper();

	@Autowired
	public InjectedCSSService(final InjectedCssRepository cssRepo) {
		this.cssRepo = cssRepo;
	}
	
	public CssRuleSet create(final String ruleSet) {
		return cssRepo.save(new CssRuleSet(ruleSet));
	}

	
	public Optional<CssRuleSet> getByID(final Long id) {
		return cssRepo.findById(id);
	}
	
	public List<String> getRuleSetsFrom(final String sessionDetailsParam) throws JsonMappingException, JsonProcessingException {
		SessionDetails sessionDetails = mapper.readValue(sessionDetailsParam, SessionDetails.class);
		List<String> returnedRuleSets = template.queryForList("Select users.css_rule_sets.css_rule_set \r\n" + 
				"From users.user_details\r\n" + 
				"join users.webpage_css_details ON users.user_details._id = users.webpage_css_details.user_id\r\n" + 
				"join users.css_rule_sets ON users.webpage_css_details.css_rule_set_id = users.css_rule_sets._id\r\n" + 
				"WHERE users.webpage_css_details.url='" +sessionDetails.getUrl() + "' \r\n" + 
				"AND  users.webpage_css_details.user_id = " +sessionDetails.getUserId(), String.class);
		return returnedRuleSets;
	}	
	
	
	public boolean deleteRuleSetsFrom(final List<String> ruleSets) throws JsonMappingException, JsonProcessingException {
		for (String cssId : ruleSets) {
			cssRepo.deleteById(Long.valueOf(cssId));
		}
		return true;
	}	
		
	public List<String> findCssRulesetIdToDelete(String sessionDetailsParam) throws JsonMappingException, JsonProcessingException {
		SessionDetails sessionDetails = mapper.readValue(sessionDetailsParam, SessionDetails.class);
		List<String> returnedRuleSets = template.queryForList("SELECT users.webpage_css_details.css_rule_set_id  \r\n" + 
				"From users.user_details\r\n" + 
				"join users.webpage_css_details ON users.user_details._id = users.webpage_css_details.user_id\r\n" + 
				"join users.css_rule_sets ON users.webpage_css_details.css_rule_set_id = users.css_rule_sets._id\r\n" + 
				"WHERE users.webpage_css_details.url='" +sessionDetails.getUrl() + "' \r\n" + 
				"AND  users.webpage_css_details.user_id = " +sessionDetails.getUserId(), String.class);
		return returnedRuleSets;
	}
	
}
