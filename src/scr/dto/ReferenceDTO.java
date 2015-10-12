package scr.dto;

import java.sql.Timestamp;

public class ReferenceDTO {

	private int rId;
	private String rName;
	private String rTitle;
	private String rContent;
	private String rfiles;
	private Timestamp rDate;
	
	public int getRId() {
		return rId;
	}
	public void setRId(int rId) {
		this.rId = rId;
	}
	
	
	public String getRName() {
		return rName;
	}
	public void setRName(String rName) {
		this.rName = rName;
	}
	
	
	public String getRTitle() {
		return rTitle;
	}
	public void setRTitle(String rTitle) {
		this.rTitle = rTitle;
	}
	
	
	public String getRContent() {
		return rContent;
	}
	public void setRContent(String rContent) {
		this.rContent = rContent;
	}
	
	
	public String getRfiles() {
		return rfiles;
	}
	public void setRfiles(String rfiles) {
		this.rfiles = rfiles;
	}
	
	
	public Timestamp getRDate() {
		return rDate;
	}
	public void setRDate(Timestamp rDate) {
		this.rDate = rDate;
	}
	
}
