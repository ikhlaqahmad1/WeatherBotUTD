/* Second Api is used from the www.boredapi.com
* Receives a random activity whenever the api call
* is made. User just have to type "Bored" to initiate
* the call.
*/




import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class SecondApiData {
    public String BookReviewApi() throws Exception {

        //Bored API
        String BoredApi = "http://www.boredapi.com/api/activity/";

        //Establishes a connection and reads response
        URL url = new URL(BoredApi);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));

        //Converts json to string
        String result = bufferedReader.readLine();

        //Json result parser
        JsonParserForBored jsonParserForBored = new JsonParserForBored();

        return jsonParserForBored.BoredParser(result);

    }

}
