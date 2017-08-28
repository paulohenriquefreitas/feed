package br.com.feed.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.http.HttpStatus.OK;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import br.com.feed.model.Feed;
import br.com.feed.service.FeedService;


@RunWith(MockitoJUnitRunner.class)
public class FeedControllerTest {
	
	@InjectMocks
	private FeedController feedController;
	
	@Mock
	private FeedService feedService;
	
	
	@Test
	public void test_success() throws Exception {
		when(feedService.getFeed()).thenReturn(new Feed());
		assertEquals(OK, feedController.get().getStatusCode());
	}

	@Test (expected=RuntimeException.class)
	public void test_error_when_get_feed() throws Exception {
		when(feedService.getFeed()).thenThrow(new RuntimeException());
		
		feedController.get();
	}

}
