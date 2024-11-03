package com.javareact.springboot.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.javareact.springboot.dao.OpenWeatherMapDao;
import com.javareact.springboot.exceptionhandler.CustomBadRequestException;
import com.javareact.springboot.exceptionhandler.CustomNotFoundException;
import com.javareact.springboot.openweathermapdto.OpenWeatherMapDto;
import com.javareact.springboot.openweathermapdto.ResponseDto;

@Service
public class OpenWeatherMapService {
	
	public static final String API_KEY_1 = "aa86df0438e5a3a619706a92b64eac97";
	
	public static final String API_KEY_2 = "fed9f0beee9f21fd6b74d7dad89225d9";
	
	@Value("${openweather.report.baseurl}")
    String baseUrl;
	
	public static Set<String> API_KEYS = new HashSet<>();
	
	static {
		API_KEYS.add(API_KEY_1);
		API_KEYS.add(API_KEY_2);
	}
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	OpenWeatherMapDao openWeatherMapDao;
	
	@Transactional(propagation = Propagation.REQUIRED)
	public ResponseDto getOpenWeatherMapData(String city, String country, String apiKey) {
		
		OpenWeatherMapDto response=null;
		ResponseDto result=null;
		StringBuilder urlBuilder = new StringBuilder(baseUrl);
		
		validateHttpParameters(city, apiKey);
		
		if(city!=null && country!=null) {
			urlBuilder.append("?q=").append(city).append(",").append(country).append("&appid=").append(apiKey);
		}
		if(city!=null && (country==null || country.isEmpty())) {
			urlBuilder.append("?q=").append(city).append("&appid=").append(apiKey);
		}
		try {
			response = restTemplate.getForObject(urlBuilder.toString(), OpenWeatherMapDto.class);
		    if(response!=null) {
		    	result= openWeatherMapDao.saveWeatherReportinDB(response, apiKey);
		    }
		} catch (HttpClientErrorException.NotFound ex) {
	        throw new CustomNotFoundException("404", "Weather data not found.");
	    } 
		catch (HttpClientErrorException.BadRequest ex) {
	        throw new CustomBadRequestException("400", "Bad weather request.");
	    } catch (Exception e) {
	    }
		
		return result;
		
	}
	
	private void validateHttpParameters(String city, String apiKey) {
		
		if(apiKey==null || apiKey.isEmpty() || apiKey.isBlank()) {
			 throw new CustomNotFoundException("400", "!! Please enter app id.");
		}
		
		if(!API_KEYS.contains(apiKey)) {
			throw new CustomNotFoundException("400", "!! Please enter a valid api key.");
		}
		
		if(city==null || city.isEmpty() || apiKey.isBlank()) {
			 throw new CustomNotFoundException("400", "!! Please enter a city.");
		}
		
	}

}
