package com.mycomism;

public class Source {
	private String link;
	private String title;
	
	public Source(String link, String title) {
		super();
		this.link = link;
		this.title = title;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return 
		"<a " +
			"href =\"" + link + "\"  " +
			"title=\"" + title + "\" " +
			"target=\"_blank\"" +
		">" +
			"<img src=\"/edietitian-web/images/Icon_External_Link.png\">" +
		"</a>";
	}
	

	
}


