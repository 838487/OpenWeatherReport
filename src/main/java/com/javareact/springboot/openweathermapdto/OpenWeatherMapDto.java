package com.javareact.springboot.openweathermapdto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OpenWeatherMapDto {
	
	private Coord coord;
    private List<Weather> weather;
    private Main main;
    private Wind wind;
    private Clouds clouds;
    private Sys sys;
    private String base;
    private int visibility;
    private int timezone;
    private long dt;
    private long id;
    private String name;
    private int cod;
    
    // Getters and Setters
    
    public Coord getCoord() {
		return coord;
	}

	public void setCoord(Coord coord) {
		this.coord = coord;
	}

	public List<Weather> getWeather() {
		return weather;
	}

	public void setWeather(List<Weather> weather) {
		this.weather = weather;
	}

	public Main getMain() {
		return main;
	}

	public void setMain(Main main) {
		this.main = main;
	}

	public Wind getWind() {
		return wind;
	}

	public void setWind(Wind wind) {
		this.wind = wind;
	}

	public Clouds getClouds() {
		return clouds;
	}

	public void setClouds(Clouds clouds) {
		this.clouds = clouds;
	}

	public Sys getSys() {
		return sys;
	}

	public void setSys(Sys sys) {
		this.sys = sys;
	}

	public String getBase() {
		return base;
	}

	public void setBase(String base) {
		this.base = base;
	}

	public int getVisibility() {
		return visibility;
	}

	public void setVisibility(int visibility) {
		this.visibility = visibility;
	}

	public int getTimezone() {
		return timezone;
	}

	public void setTimezone(int timezone) {
		this.timezone = timezone;
	}

	public long getDt() {
		return dt;
	}

	public void setDt(long dt) {
		this.dt = dt;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public static class Coord {
    	
        private double lon;
        private double lat;
		public double getLon() {
			return lon;
		}
		public void setLon(double lon) {
			this.lon = lon;
		}
		public double getLat() {
			return lat;
		}
		public void setLat(double lat) {
			this.lat = lat;
		}

        // Getters and Setters
        
    }

    public static class Weather {
    	
        private int id;
        private String main;
        private String description;
        private String icon;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getMain() {
			return main;
		}
		public void setMain(String main) {
			this.main = main;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public String getIcon() {
			return icon;
		}
		public void setIcon(String icon) {
			this.icon = icon;
		}

        // Getters and Setters
        
    }

    public static class Main {
    	
        private double temp;
        
        @JsonProperty("feels_like")
        private double feelsLike;
        
        @JsonProperty("temp_min")
        private double tempMin;
        
        @JsonProperty("temp_max")
        private double tempMax;
        
        private int pressure;
        
        private int humidity;

        @JsonProperty("sea_level")
        private int seaLevel;

        @JsonProperty("grnd_level")
        private int groundLevel;

		public double getTemp() {
			return temp;
		}

		public void setTemp(double temp) {
			this.temp = temp;
		}

		public double getFeelsLike() {
			return feelsLike;
		}

		public void setFeelsLike(double feelsLike) {
			this.feelsLike = feelsLike;
		}

		public double getTempMin() {
			return tempMin;
		}

		public void setTempMin(double tempMin) {
			this.tempMin = tempMin;
		}

		public double getTempMax() {
			return tempMax;
		}

		public void setTempMax(double tempMax) {
			this.tempMax = tempMax;
		}

		public int getPressure() {
			return pressure;
		}

		public void setPressure(int pressure) {
			this.pressure = pressure;
		}

		public int getHumidity() {
			return humidity;
		}

		public void setHumidity(int humidity) {
			this.humidity = humidity;
		}

		public int getSeaLevel() {
			return seaLevel;
		}

		public void setSeaLevel(int seaLevel) {
			this.seaLevel = seaLevel;
		}

		public int getGroundLevel() {
			return groundLevel;
		}

		public void setGroundLevel(int groundLevel) {
			this.groundLevel = groundLevel;
		}

        // Getters and Setters
        
    }

    public static class Wind {
        private double speed;
        private int deg;
        
		public double getSpeed() {
			return speed;
		}
		public void setSpeed(double speed) {
			this.speed = speed;
		}
		public int getDeg() {
			return deg;
		}
		public void setDeg(int deg) {
			this.deg = deg;
		}

        // Getters and Setters
        
    }

    public static class Clouds {
        private int all;

		public int getAll() {
			return all;
		}

		public void setAll(int all) {
			this.all = all;
		}

        // Getters and Setters
        
    }

    public static class Sys {
        private int type;
        private int id;
        private String country;
        private long sunrise;
        private long sunset;
        
		public int getType() {
			return type;
		}
		public void setType(int type) {
			this.type = type;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getCountry() {
			return country;
		}
		public void setCountry(String country) {
			this.country = country;
		}
		public long getSunrise() {
			return sunrise;
		}
		public void setSunrise(long sunrise) {
			this.sunrise = sunrise;
		}
		public long getSunset() {
			return sunset;
		}
		public void setSunset(long sunset) {
			this.sunset = sunset;
		}

        // Getters and Setters
        
    }
}