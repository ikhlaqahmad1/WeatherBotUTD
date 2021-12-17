/*
* Custom JSON parser class for the bored api.
*/






import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class JsonParserForBored {
    public String BoredParser(String jsonStr){

        //Json Object to parse json
        JsonObject jsonObject = new JsonParser().parse(jsonStr).getAsJsonObject();

        //returns a string of activity
        return jsonObject.get("activity").toString();
    }
}
