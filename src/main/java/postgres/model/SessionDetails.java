package postgres.model;

public class SessionDetails {
	
	long userId;
	String url;
	
	public SessionDetails() {
		
	}
	
	public SessionDetails(long userId, String url) {
		this.userId = userId;
		this.url = url;
	}
	
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	

}
