package kodlamaio.northwind.business.concretes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import kodlamaio.northwind.entities.concretes.AvgPrice;
import kodlamaio.northwind.entities.concretes.MoneyPrice;

@Service
public class BitcoinManager {
	private final RestTemplate restTemplate;

	
	public BitcoinManager(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
//		List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
//		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
//		converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
//		messageConverters.add(converter);
//		this.restTemplate.setMessageConverters(messageConverters);
	}
	
	public AvgPrice getEmployees(String symbol) { 	
	AvgPrice avgPrice=	this.restTemplate.getForObject("https://api.binance.com/api/v3/avgPrice?symbol="+symbol,AvgPrice.class);
		avgPrice.setSymbol(symbol);
		return avgPrice;
		
	}
	
	public List<Object> getMoney() { 	
		
		String responseEntity = this.restTemplate.getForObject("https://evds2.tcmb.gov.tr/service/evds/series="
			+ "TP.DK.USD.A-TP.DK.EUR.A-TP.DK.CHF.A-TP.DK.GBP.A-TP.DK.JPY.A&startDate=01-10-2017"
			+ "&endDate=01-11-2017&type=json&key=GhpKqYvQn0",String.class);
       JSONObject response =new JSONObject(responseEntity);
       JSONArray jResul = response.getJSONArray("items");
      
			return jResul.toList();
		}
}
//GhpKqYvQn0