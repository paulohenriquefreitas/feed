package br.com.feed.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "image") 
public class Image {
	@JacksonXmlProperty(localName = "url")
	private String url;
	public String getUrl() {
		return url;
	}
	public String getTitle() {
		return title;
	}
	public String getLink() {
		return link;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setLink(String link) {
		this.link = link;
	}
	private String title;
	private String link;
}
