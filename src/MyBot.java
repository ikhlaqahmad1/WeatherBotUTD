/*
* Extension of the Pircbot.java and implementation.
* Checks for certain conditions and validates user
* input for the weather. Returns a custom message if
* user message is out of the scope of the program.
*/



import org.jibble.pircbot.*;
import java.io.IOException;

//PircBot class extension
public class MyBot extends PircBot {

    //PircBot Extension
    public MyBot() {
        //Default name for the bot
        this.setName("IkhlaqBot");
    }

    //Universal Variables
    public static String m = "";
    boolean weatherCheck = false;


    //Message log
    public void onMessage(String channel, String sender, String login, String hostname, String message) {

        m = message;

        //To lower case
        message = message.toLowerCase();

        /************************Conditions*************************/

        //If message is Hi or Hello
        if ((message.contains("hello")) || (message.contains("hi"))){
            sendMessage(channel, sender + ": Hey there! I will respond to your messages.");
        }
        //If message asks for the current time
        else if (message.contains("time")) {
            String time = new java.util.Date().toString();
            sendMessage(channel, sender + ": The time is now " + time);
        }
        //If weather is being inquired
        else if(message.contains("weather")){
            sendMessage(channel, sender + ": Enter the zip/city name: ");
            weatherCheck = true;
        }
        //If input for the weather is valid
        else if (weatherCheck && (m.length() > 2)){

            //Weather Api Call
            try {
                WeatherApiData weatherApiData = new WeatherApiData();
                String weatherResponse = weatherApiData.ApiData(m);
                sendMessage(channel, sender +": The weather in " + m + " is " + weatherResponse + " °F.");
                weatherCheck = false;

            }
            //If no response is available from the api call
            catch (IOException e) {
                e.printStackTrace();
                sendMessage(channel, "Invalid Input for weather");
            }
        }
        //Call for the second api
        else if(message.contains("bored")){

            //Reddit Api Call
            try {
                SecondApiData secondApiData = new SecondApiData();
                String fact = secondApiData.BookReviewApi();
                sendMessage(channel, sender + ": "+ fact);
            }
            catch (Exception e) {
                e.printStackTrace();
                sendMessage(channel, "Invalid Input for bored");
            }
        }
        //Response for everything else
        else{
            sendMessage(channel, sender + ": I don't know that yet. I am still learning...");
        }
    }

}