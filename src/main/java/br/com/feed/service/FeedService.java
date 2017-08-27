package br.com.feed.service;

import br.com.feed.model.Feed;
import br.com.feed.model.RSS;
import br.com.feed.utils.CrawlerUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Service
public class FeedService {
    
	@Value("${feed.url}")
	private String url;
	
	public Feed getFeed() throws IOException{
		
	    RSS rss = readXml();
	    Feed f = new Feed();	    
	    f.setItem(rss.getChannel().getItem());
	    CrawlerUtils.setContent(f);
	    
		return f;
	}

	private RSS readXml() throws IOException {
		String xml = getURLContent(url);
	    ObjectMapper objectMapper = new XmlMapper();
	    RSS rss = objectMapper.readValue(xml,RSS.class);
		return rss;
	}
	
	public String getURLContent(String p_sURL)
	{
	    BufferedReader oReader;
	    String sLine;
	    StringBuilder sbResponse;
	    String sResponse = null;

	    try
	    {
	        oReader = new BufferedReader(new InputStreamReader(new URLWrapper(p_sURL).openConnection().getInputStream()));
	        sbResponse = new StringBuilder();

	        while((sLine = oReader.readLine()) != null)
	        {
	            sbResponse.append(sLine);
	        }

	        sResponse = sbResponse.toString();
	    }
	    catch(Exception e)
	    {
	        e.printStackTrace();
	    }

	    return sResponse;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
