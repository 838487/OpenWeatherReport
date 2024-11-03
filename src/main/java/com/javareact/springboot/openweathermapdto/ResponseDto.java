package com.javareact.springboot.openweathermapdto;

public class ResponseDto {

	private String weatherStatus;
	
	private String weatherDescription;
	
	private String country;
	
	private String city;

	public String getWeatherStatus() {
		return weatherStatus;
	}

	public void setWeatherStatus(String weatherStatus) {
		this.weatherStatus = weatherStatus;
	}

	public String getWeatherDescription() {
		return weatherDescription;
	}

	public void setWeatherDescription(String weatherDescription) {
		this.weatherDescription = weatherDescription;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	
}
