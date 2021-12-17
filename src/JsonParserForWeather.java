/*
* JSON parser custom class for the weather api. It receives
* a json string and only fetches the Fahrenheit temperature from
* the string.
*/




import com.google.gson.*;

public class JsonParserForWeather {
    public String jsonParser(String jsonStr) {

        //Json Object to parse json
        JsonObject jsonObject = new JsonParser().parse(jsonStr).getAsJsonObject();

        //Gets the sub object "main"
        JsonObject mainObj = jsonObject.getAsJsonObject("main");

        //Gets "temp" from the "main" object as a double
        double temp = mainObj.get("temp").getAsDouble();

        //Returns a string value of the temperature
        return Double.toString(temp);

    }
}


