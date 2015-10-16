## Synopsis

This project consists in a very simple Java project which was developed to attend the requirements of the selection process test of CurrencyFair company. Basically it consists in a Spring MVC Project which provides a web-service to consumes trade messages via an endpoint, persists the information in a database using Hibernate framework, and at last it delivers the processed messages in either table and graph formats in a web page.

## Language / Frameworks used

Java 1.6 </br>
Spring MVC 3 </br>
Hibernate 4 </br>
Google Charts (JSP and Javascript rendering Table and Charts) </br>
JUnit and Rest Assured (Multiple requests test) </br>

Deployed in Heroku </br>
Tested using PostgreSQL database and Apache Tomcat 7 WebServer

## Endpoints

POST Endpoint: https://sheltered-fjord-8254.herokuapp.com/trade </br>
Tested using Advanced Rest Client from Chrome Extensions, with the following JSON (from the test document): </br>
{"userId": "134256", "currencyFrom": "EUR", "currencyTo": "GBP", "amountSell": 1000, "amountBuy": 747.10, "rate": 0.7471, "timePlaced" : "24-JAN-15 10:27:44", "originatingCountry" : "FR"}

Frontend Endpoint: https://sheltered-fjord-8254.herokuapp.com/allTrades </br>
Displays a table with all processed messages, and two different graphs showing the volume of messages by Incoming and Outcoming Currencies

GET Endpoint: https://sheltered-fjord-8254.herokuapp.com/allTradesJson </br>
Returns a JSON with a list of all received messages

## Tests

There is a JUnit Test file in the project (com.test.currencyfair.test.CurrencyFairTest) with holds two tests: a simple post and a multiple post test. </br>
The multiple post test is set to submit a random number of posts (from 1 to 2000) with different currencies and values. In the end, it checks whether the number of messages persisted is at least equal to the number of messages posted in the same test. 

## Considerations
This is only a draft in order to attend the minimum requirements for CurrencyFair's selection process, using a restricted amount of hours. 

## GitHub
This is a comment regarding my GitHub commit test