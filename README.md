Open Weather step by step guide of how to run Spring boot application
1.	Git clone application and set up in your favorite IDE (Eclipse or Gradle).
2.	Run file SpringbootbackendApplication.java file.
3.	Open postman and hit Http GET request as below:
localhost:8080/api/openweathermap/getweather?city=delhi&ctyCode=in&appid=fed9f0beee9f21fd6b74d7dad89225d9
1.	I have created 2 Api Key from the given URL http://openweathermap.org/current#name
Which is as follows:

 	API_KEY_1 = "aa86df0438e5a3a619706a92b64eac97"
	
API_KEY_2 = "fed9f0beee9f21fd6b74d7dad89225d9"

2.	Now, according to the guidelines I have implemented rate limiting to 5 requests per 1 minute. We can do it for 1 hour, but just for testing, I have made it 1 minute. 

3.	We can hit only 5 rest api call per minute per API_KEY mentioned above. If call is greater than 5 then following error will be thrown:

“Limit Exceeded!! Only 5 requests are allowed in one minute.”

4.	Request parameters validations have also been implemented for missing City and App Id parameters. Error will also be been thrown if App id or key is Invalid. Following error will be thrown with proper Http Status as:

!! Please enter a city.
!! Please enter a valid api key.
!! Please enter app id.

5.	If everything is valid then we should get proper weather response with weather status, description, city and country. Valid response as follows:

<ResponseDto>
   <weatherStatus>Clouds</weatherStatus>
    <weatherDescription>overcast clouds</weatherDescription>
    <country>GB</country>
    <city>London</city>
</ResponseDto>

6.	All weather report fetched from the url https://api.openweathermap.org/data/2.5/weather has been successfully saved in H2 database using Spring data Jpa and after that http response has been retrieved from the database.

Thanks
Mohit
+61481852618












