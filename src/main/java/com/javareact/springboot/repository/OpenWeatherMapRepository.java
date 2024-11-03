package com.javareact.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javareact.springboot.entity.OpenWeatherMapEntity;

public interface OpenWeatherMapRepository extends JpaRepository<OpenWeatherMapEntity, Long>{

	OpenWeatherMapEntity findByUniqueIdAndCityNameAndApiKey(String uUID, String name, String apiKey);

}
