/*
* Pircbot boiler-plate code. It just sets up the bot
* with the server as programmed. Also, it sends two messages
* on the welcome screen.
*/




public class MyBotMain {
    public static void main(String [] args) {

        // Now start our bot up.
        MyBot bot = new MyBot();

        try {
            //To record log entries
            bot.setVerbose(true);

            // Connect to the IRC server.
            bot.connect("irc.us.libera.chat");
        }
        catch (Exception e){
            System.out.println("Could not connect to the server");
        }
        finally {
            //Default channel for pircbot
            bot.joinChannel("#cs02336");

            //Welcome Messages when the bot connects to the server
            bot.sendMessage("#cs02336", "Hey! Enter any message and I’ll respond!");
            bot.sendMessage("#cs02336", "Type \"bored\" for a spontaneous activity");
        }

    }
}
