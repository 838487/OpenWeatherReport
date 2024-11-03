package com.javareact.springboot.dao;

import java.security.SecureRandom;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.javareact.springboot.entity.OpenWeatherMapEntity;
import com.javareact.springboot.openweathermapdto.OpenWeatherMapDto;
import com.javareact.springboot.openweathermapdto.ResponseDto;
import com.javareact.springboot.repository.OpenWeatherMapRepository;

@Repository
public class OpenWeatherMapDao {
	
	private static final String str = "12A4BCD3EF5GH6IJKLM7NO8PQ9RSTUVWXYZ0";
    private static final int uniqueLengthUpto5 = 5;
    private static final SecureRandom randomIndex = new SecureRandom();
	
	
	@Autowired
	OpenWeatherMapRepository openWeatherMapRepository;
	
	@Transactional
	public ResponseDto saveWeatherReportinDB(OpenWeatherMapDto response, String apiKey) {
		ResponseDto result=new ResponseDto();
		try {
			OpenWeatherMapEntity weatherEntity = new OpenWeatherMapEntity();
	        weatherEntity.setLongitude(response.getCoord().getLon());
	        weatherEntity.setLattitude(response.getCoord().getLat());
	        weatherEntity.setWeatherStatus(response.getWeather().get(0).getMain());
	        weatherEntity.setWeatherDescription(response.getWeather().get(0).getDescription());
	        weatherEntity.setCityName(response.getName());
	        weatherEntity.setCountry(response.getSys().getCountry());
	        weatherEntity.setApiKey(apiKey);
	        String uniqueStr=generateUniqueStringOfUpto5Char();
	        weatherEntity.setUniqueId(uniqueStr);
	        openWeatherMapRepository.save(weatherEntity);
	        OpenWeatherMapEntity weatherData = openWeatherMapRepository.findByUniqueIdAndCityNameAndApiKey(uniqueStr,response.getName(),
					 apiKey);
	        if(weatherData!=null) {
	        	result.setCity(weatherData.getCityName());
	        	result.setCountry(weatherData.getCountry());
	        	result.setWeatherDescription(weatherData.getWeatherDescription());
	        	result.setWeatherStatus(weatherData.getWeatherStatus());
	        }
		}catch(Exception e) {
		}
		return result;
	}
	
	private static String generateUniqueStringOfUpto5Char() {
        StringBuilder result;
        String uniqueString;

            result = new StringBuilder(uniqueLengthUpto5);
            for (int i = 0; i < uniqueLengthUpto5; i++) {
                int index = randomIndex.nextInt(str.length());
                result.append(str.charAt(index));
            }
            uniqueString = result.toString();
            
        return uniqueString;
    }
	
}
