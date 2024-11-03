package com.javareact.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javareact.springboot.openweathermapdto.ResponseDto;
import com.javareact.springboot.service.OpenWeatherMapService;

@RestController
@RequestMapping("/api/openweathermap")
public class OpenWeatherMapController {
	
	@Autowired
	private OpenWeatherMapService openWeatherMapService;
	
	@GetMapping("/getweather")
	public ResponseDto fetchEmployees(@RequestParam("city") String city, @RequestParam("ctyCode") String countryCode, 
			 @RequestParam("appid") String apiKey){
		ResponseDto status = openWeatherMapService.getOpenWeatherMapData(city, countryCode, apiKey);
		return status;
	}
	
	

}
