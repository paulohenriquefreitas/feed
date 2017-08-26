package br.com.feed.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.List;

@JsonIgnoreProperties({ "creator","guid"})
@JacksonXmlRootElement(localName = "employees") 
public class Item {
	@JsonProperty
	@JacksonXmlProperty(localName = "title")
	private String title;
	@JsonIgnore
	@JacksonXmlProperty(localName = "description")
	private String description;
	@JsonProperty
	@JacksonXmlProperty(localName = "link")
	private String link;
	@JacksonXmlProperty(localName = "creator")
	private String creator;
	@JacksonXmlProperty(localName = "guid")
	private String guid;
	@JsonProperty
	private List<Content> content;
	
	public String getTitle() {
		return title;
	}
	public String getDescription() {
		return description;
	}
	public String getLink() {
		return link;
	}
	public String getGuid() {
		return guid;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public void setGuid(String guid) {
		this.guid = guid;
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public List<Content> getContent() {
		return content;
	}
	public void setContent(List<Content> content) {
		this.content = content;
	}	
	
	
	
	
}
