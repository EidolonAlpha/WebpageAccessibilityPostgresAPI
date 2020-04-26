package postgres.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import postgres.model.SessionDetails;
import postgres.model.WebpagePreference;
import postgres.model.WebpagePreferenceRestEntity;
import postgres.repository.WebpagePrefernceRepository;

@Service
public class WebpagePreferenceService {
	@Autowired
	private JdbcTemplate template;
	
	private ObjectMapper mapper = new ObjectMapper();
	private WebpagePrefernceRepository webpagePreferenceRepo;

	@Autowired
	public WebpagePreferenceService(WebpagePrefernceRepository webpagePreferenceRepo) {
		this.webpagePreferenceRepo = webpagePreferenceRepo;
	}
	
	
	public Optional<WebpagePreference> getByID(Long id) {
		return webpagePreferenceRepo.findById(id);
	}

	public WebpagePreference create(String webPrefString) throws JsonMappingException, JsonProcessingException {
		WebpagePreferenceRestEntity webpagePref = mapper.readValue(webPrefString, WebpagePreferenceRestEntity.class);
		return webpagePreferenceRepo.save(new WebpagePreference(webpagePref.getUserId(), webpagePref.getRuleSetIdArray(), webpagePref.getUrl()));
	}
	
	public void deleteRuleSetsFrom(final String sessionDetailsParam) throws JsonMappingException, JsonProcessingException {
		SessionDetails sessionDetails = mapper.readValue(sessionDetailsParam, SessionDetails.class);
		for (String webPrefId : findWebpageIdToDelete(sessionDetails)) {
			webpagePreferenceRepo.deleteById(Long.valueOf(webPrefId));
		}
	}	
	
	private List<String> findWebpageIdToDelete(SessionDetails sessionDetails) {
		List<String> returnedRuleSets = template.queryForList("SELECT users.webpage_css_details._id \r\n" + 
				"From users.user_details\r\n" + 
				"join users.webpage_css_details ON users.user_details._id = users.webpage_css_details.user_id\r\n" + 
				"join users.css_rule_sets ON users.webpage_css_details.css_rule_set_id = users.css_rule_sets._id\r\n" + 
				"WHERE users.webpage_css_details.url='" +sessionDetails.getUrl() + "' \r\n" + 
				"AND  users.webpage_css_details.user_id = " +sessionDetails.getUserId(), String.class);
		return returnedRuleSets;
	}
	
}
