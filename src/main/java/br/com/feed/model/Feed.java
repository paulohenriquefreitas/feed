package br.com.feed.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Feed {
	@JsonProperty("feed")
   private List<Item> item;

	public List<Item> getItem() {
		return item;
	}

	public void setItem(List<Item> item) {
		this.item = item;
	}
	
	
}
