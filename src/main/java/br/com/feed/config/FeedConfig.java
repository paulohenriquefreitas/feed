package br.com.feed.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.feed.service.FeedService;


@Configuration
public class FeedConfig {
	
	@Bean
	public FeedService feedService() {
		return new FeedService();
	}

}
