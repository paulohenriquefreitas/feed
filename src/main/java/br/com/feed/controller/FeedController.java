package br.com.feed.controller;

import java.io.IOException;

import javax.xml.bind.JAXBException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import br.com.feed.model.Feed;
import br.com.feed.service.FeedService;


@RestController
@RequestMapping("feed")
public class FeedController {
	
	@Autowired
	private FeedService feedService;
	
	@RequestMapping(method=RequestMethod.GET)	
	public ResponseEntity<?> get() throws JAXBException{
		
		Feed feed = null;
		try {
			feed = feedService.getFeed();
		} catch (JsonParseException e) {
			return new ResponseEntity<JsonParseException>(e, HttpStatus.BAD_REQUEST);
		} catch (JsonMappingException e) {
			return new ResponseEntity<JsonMappingException>(e, HttpStatus.BAD_REQUEST);
		} catch (IOException e) {
			return new ResponseEntity<IOException>(e, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<Feed>(feed, HttpStatus.OK) ;		
	}

}
