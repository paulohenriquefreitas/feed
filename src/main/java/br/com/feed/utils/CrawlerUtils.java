package br.com.feed.utils;


import br.com.feed.model.Content;
import br.com.feed.model.Feed;
import br.com.feed.model.Item;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;


public class CrawlerUtils {
	
	public static void setContent(Feed f){
		
		for(Item item : f.getItem()){
			List<Content> contents = new ArrayList<>();
		    Document doc = Jsoup.parse(item.getDescription());
		    
		    Elements p = doc.getElementsByTag("p");
		    for(Element e : p){		    	
		    	if(!p.isEmpty() && e.html().length() > 6){
		    		
		    		Content c = new Content();
		    		//System.out.println(e.text());
		    		c.setType("text"); 
		    		c.setContent(e.text());
		    		contents.add(c);
		    	}		    	
		    }	    
		    
		    Elements img = doc.getElementsByTag("img");
			if(!img.isEmpty()){
				for(Element e : img){
		    		Content c = new Content();
		    		c.setType("image");
		    		c.setContent(e.attr("src"));
		    		contents.add(c);
		    	}		    	
		    }	    
		    Elements links = doc.getElementsByTag("ul");
		    for(Element e : links){
				Content c = new Content();
				List<String> linkList = new ArrayList<>();
				c.setType("links");
				e.select("a").forEach(name -> {
					System.out.println(name.attr("abs:href"));
					linkList.add(name.attr("abs:href"));
				});
				c.setContents(linkList);
				contents.add(c);
		    }
		    
		    item.setContent(contents);
		    System.out.println("*****");
		    }
	}

}
