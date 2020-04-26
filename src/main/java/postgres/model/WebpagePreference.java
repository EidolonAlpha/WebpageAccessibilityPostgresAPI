package postgres.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="webpage_css_details")
public class WebpagePreference {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long _id;
	private long cssRuleSetId;
	private long userId;
	private String url;
	
	public WebpagePreference(long userId, long cssRuleSetIdList, String url) {
		this.cssRuleSetId = cssRuleSetIdList;
		this.url = url;
		this.userId = userId;
	}
	
	
	public WebpagePreference() {
	}


	public long get_id() {
		return _id;
	}
	public void set_id(long _id) {
		this._id = _id;
	}
	
	public long getCssRuleSetId() {
		return cssRuleSetId;
	}
	public void setCssRuleSetId(long cssRuleSetIdList) {
		this.cssRuleSetId = cssRuleSetIdList;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	
	

}
