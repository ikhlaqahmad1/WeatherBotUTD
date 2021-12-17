The program is a custom implementation of the pircbot IRC bot class.
The program connects to a web interface from libera.chat via custom channel. In this
program, #cs02336 has been used.

The program uses two APIs, one for weather and the other for a random activity. The response is
received in json format and, with the help of a gson library, is parsed.

Api used:
    1) www.openweather.org
        Returns the temperature for the input city/zip in Fahrenheit for any location in
        the U.S., either by name or zip code. Zip code is the preferred method to inquire
        about the weather to avoid any ambiguity (e.g. Dallas, TX, Dallas, GA).

    2) www.boredapi.com
        If a user's message is, or includes, "bored", then a random activity is displayed.

Libraries used:
    1) gson 2.6.2
    2) pircbot 1.5.0