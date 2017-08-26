package br.com.feed.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.List;
@JacksonXmlRootElement(localName = "channel") 
public class Channel {
	@JacksonXmlProperty(localName = "title")
  private String title;
	@JacksonXmlProperty(localName = "link")
  private String link;
	@JacksonXmlProperty(localName = "description")
  private String description;
	@JacksonXmlProperty(localName = "language")
  private String language;
	@JacksonXmlProperty(localName = "copyright")
  private String copyright;
	 @JacksonXmlProperty(localName = "image")
	  @JacksonXmlElementWrapper(useWrapping = false)
  private List<Image> image;
  @JacksonXmlProperty(localName = "item")
  @JacksonXmlElementWrapper(useWrapping = false)
  private List<Item> item;
public String getTitle() {
	return title;
}
public String getLink() {
	return link;
}
public String getDescription() {
	return description;
}
public String getLanguage() {
	return language;
}
public String getCopyright() {
	return copyright;
}
public List<Image> getImage() {
	return image;
}
public List<Item> getItem() {
	return item;
}
public void setTitle(String title) {
	this.title = title;
}
public void setLink(String link) {
	this.link = link;
}
public void setDescription(String description) {
	this.description = description;
}
public void setLanguage(String language) {
	this.language = language;
}
public void setCopyright(String copyright) {
	this.copyright = copyright;
}
public void setImage(List<Image> image) {
	this.image = image;
}
public void setItem(List<Item> item) {
	this.item = item;
}
}

