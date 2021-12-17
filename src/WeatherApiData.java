/*
* Weather Api call form www.openweather.org is made.
* The response is received in JSON format. This class
* receives the response after validating the user input.
* Although the code has been implemented to use both
* zip code and city name for the api call; however,
* for the most accurate result and to avoid any ambiguity,
* zip should be used.
*/


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WeatherApiData{
    public String ApiData(String cityOrZip) throws IOException {

        //Api Information key
        final String apiKey = "27714a25b758bf14161d954edd5504f6";

        //Variables
        int zip = 0;
        String city = "";
        String weatherURL = "";
        boolean numeric = true;
        String weatherResult = "";

        //Checks if the input is numeric
        try {
            zip = Integer.parseInt(cityOrZip);
        }
        catch (NumberFormatException e) {
            numeric = false;
        }


        //If numeric, then search by ZipCode
        if((numeric) && (cityOrZip.length() == 5)){
            weatherURL = "http://api.openweathermap.org/data/2.5/weather?zip=" + zip + "&appid=" + apiKey + "&units=imperial";
        }
        //Search by city name
        else if(cityOrZip.matches("^[a-zA-Z]+(?:[\\s-][a-zA-Z]+)*$")) {
            city = cityOrZip;
            weatherURL = "http://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + apiKey + "&units=imperial";
        }
        else{
            weatherResult = "No response";
        }

        //Establishes a connection
        URL url = new URL(weatherURL);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        //Response code from the api call
        int code = connection.getResponseCode();


        if (code==200) {

            //Reads raw data in JSON
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            //Records the response in string format
            String result = bufferedReader.readLine();

            //json parser
            JsonParserForWeather jsonParserForWeather = new JsonParserForWeather();

            weatherResult = jsonParserForWeather.jsonParser(result);

            //closes and disconnects connection
            bufferedReader.close();
            connection.disconnect();

            System.out.println(weatherResult);
        }
        else {
            weatherResult = "Invalid Response!";
        }

        return weatherResult;
    }

}
