package com.lexia.school;

import java.util.List;

import org.apache.http.impl.client.CloseableHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class SchoolClientConfig {
	@Autowired
	CloseableHttpClient httpClient;

	@Bean
	public RestTemplate restTemplate() {

		RestTemplate restTemplate = new RestTemplate(clientHttpRequestFactory());

		List<HttpMessageConverter<?>> messageConverterList = restTemplate.getMessageConverters();
		MappingJackson2HttpMessageConverter jsonMessageConverter = new MappingJackson2HttpMessageConverter();
		ObjectMapper mapper = new ObjectMapper();
		jsonMessageConverter.setObjectMapper(mapper);
		messageConverterList.add(jsonMessageConverter);
		restTemplate.setMessageConverters(messageConverterList);

		return restTemplate;

	}

	@Bean
	public HttpComponentsClientHttpRequestFactory clientHttpRequestFactory() {
		HttpComponentsClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory();
		clientHttpRequestFactory.setHttpClient(httpClient);
		return clientHttpRequestFactory;
	}

	@Bean
	public TaskScheduler taskScheduler() {
		ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
		scheduler.setThreadNamePrefix("poolScheduler");
		scheduler.setPoolSize(50);
		return scheduler;
	}

}
