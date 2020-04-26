package postgres.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="css_rule_sets")
public class CssRuleSet {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long _id;
	
	private String cssRuleSet;
	
	public CssRuleSet() {
		
	}
	
	public CssRuleSet(String cssRuleSet) {
		this.cssRuleSet = cssRuleSet;
	}
	
	public Long get_id() {
		return _id;
	}
	public void set_id(Long _id) {
		this._id = _id;
	}
	
	public String getCssRuleSet() {
		return cssRuleSet;
	}
	public void setCssRuleSet(String cssRuleSet) {
		this.cssRuleSet = cssRuleSet;
	}

}
