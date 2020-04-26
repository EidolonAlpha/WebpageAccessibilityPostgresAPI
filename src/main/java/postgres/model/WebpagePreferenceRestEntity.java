package postgres.model;

public class WebpagePreferenceRestEntity {
	
	private String url;
	private long userId;
	private long ruleSetId;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public long getRuleSetIdArray() {
		return ruleSetId;
	}

	public void setRuleSetIdArray(long ruleSetId) {
		this.ruleSetId = ruleSetId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}
	
	

}
