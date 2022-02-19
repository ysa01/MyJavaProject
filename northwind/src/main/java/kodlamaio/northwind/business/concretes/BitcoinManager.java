package kodlamaio.northwind.business.concretes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import kodlamaio.northwind.entities.concretes.AvgPrice;

@Service
public class BitcoinManager {
	private final RestTemplate restTemplate;

	
	public BitcoinManager(RestTemplateBuilder restTemplateBuilder) {
		this.restTemplate = restTemplateBuilder.build();
		List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
		converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
		messageConverters.add(converter);
		this.restTemplate.setMessageConverters(messageConverters);
	}
	
	public AvgPrice getEmployees(String symbol) { 	
	return	this.restTemplate.getForObject("https://api.binance.com/api/v3/avgPrice?symbol="+symbol,AvgPrice.class);
		
		
	}
}
