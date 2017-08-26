package br.com.feed.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "employees") 
public class RSS {
   @JacksonXmlProperty(localName = "version")
   private String version;
   @JacksonXmlElementWrapper(localName = "channel", useWrapping = false)
   private Channel channel;

public Channel getChannel() {
	return channel;
}

public void setChannel(Channel channel) {
	this.channel = channel;
}

public String getVersion() {
	return version;
}

public void setVersion(String version) {
	this.version = version;
}


}

