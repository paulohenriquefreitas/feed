package br.com.feed.service;

import br.com.feed.model.Feed;
import br.com.feed.model.RSS;
import br.com.feed.utils.CrawlerUtils;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

@Service
public class FeedService {
    
	@Value("${feed.url}")
	private String url;
	
	public Feed getFeed() throws JsonParseException, JsonMappingException, IOException{
		
	    String xml = getURLContent(url);
	    ObjectMapper objectMapper = new XmlMapper();
	    RSS employees = objectMapper.readValue(xml,RSS.class);
	    Feed f = new Feed();	    
	    f.setItem(employees.getChannel().getItem());
	    CrawlerUtils.setContent(f);
	    
		return f;
	}
	
	public static String getURLContent(String p_sURL)
	{
	    URL oURL;
	    URLConnection oConnection;
	    BufferedReader oReader;
	    String sLine;
	    StringBuilder sbResponse;
	    String sResponse = null;

	    try
	    {
	        oURL = new URL(p_sURL);
	        oConnection = oURL.openConnection();
	        oReader = new BufferedReader(new InputStreamReader(oConnection.getInputStream()));
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
}
