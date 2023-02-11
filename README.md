# intertrust-tech-task

To execute the tests just simply run PageTest.java class.

I've created 3 simple tests, one validating the UI part and two others that send the request and validate the response code, city, validate the key of my account.

Tasks

Part 1 – UI test

Create UI automated test for the following user scenario:

 1. Open VisualCrossing URL: https://www.visualcrossing.com

2. Select the “Weather Data” menu

3. Enter your current city in the text field and press “Search” button

4. Verify that weather forecast for your city is shown

 
Part 2 - API test

Create an automated test for getting weather data using API endpoint:

In order to use API you need to get a key, for this you have to sign up for a VisualCrossing account at https://www.visualcrossing.com. 

You can find the API key under you "Account Details" menu after you log in to VisualCrossing (click on “Account” button on the top right).

The test should send GET request to the VisualCrossing API endpoint:

 
https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/timeline/Tallinn?unitGroup=metric&key=YOUR_API_KEY&contentType=json

Verify returned response contains correct data (for example City is correct). It is up to you to decide what assertions to use to verify the correctness of the response.

 
