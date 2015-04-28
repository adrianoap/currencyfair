## Synopsis

This project consists in a very simple Java project which was developed to attend the requirements of the selection process test of CurrencyFair company. Basically it consists in a Spring MVC Project which provides a web-service to consumes trade messages via an endpoint, persists the information in a database using Hibernate framework, and finally delivers the processed messages in either table and graph formats on a web page.

## Language / Frameworks used

Java 1.5 (language)

Spring MVC 3 (MVC framework)

Hibernate 4 (Persistence)

Google Charts (JSP and Javascript rendering Table and Charts)

JUnit and Rest Assured (Multiple requests test)

Tested using MySQL database and Apache Tomcat 7 WebServer

## Installation

You may download the project from GitHub to Eclipse and any other Java IDE. 

Firstly, you should open the file mvc-config.xml (under WEB-INF project folder) and update bean datasource spring definition, replacing the settings for the database you would like to use. 

Next you should go through sessionFactory definition and review hibernate properties to suit the database schema you would like to create for the project. It is only required that you create a schema for the project, once the tables are set to be automatically created once you deploy it. 

Finally, just add the project to a Web Server. 

Once the project is up and running you may be able to access either the URL to post messages and to retrieve the processed messages. 

POST Endpoint: http://"your local address":"server port"/CurrencyFairTest/trade

Tested using Advanced Rest Client from Chrome Extensions, with the following JSON (from the test document): 
{"userId": "134256", "currencyFrom": "EUR", "currencyTo": "GBP", "amountSell": 1000, "amountBuy": 747.10, "rate": 0.7471, "timePlaced" : "24-JAN-15 10:27:44", "originatingCountry" : "FR"}

Frontend Endpoint: http://<your local address>:<server port>/CurrencyFairTest/allTrades 
Displays a table with all processed messages, and two different graphs showing the volume of messages by Incoming and Outcoming Currencies

GET Endpoint: http://<your local address>:<server port>/CurrencyFairTest/allTradesJson
Returns a JSON with a list of all received messages

## Tests

There is a JUnit Test file in the project (com.test.currencyfair.test.CurrencyFairTest) with holds two tests: a simple post and a multiple post test. 

The multiple post test is set to submit a random number of posts (from 1 to 2000) with different currencies and values. In the end, it checks whether the number of messages persisted is at least equal to the number of messages posted. 

## Considerations

This is only a draft in order to attend the minimum requirements for CurrencyFair's selection process, using a restricted amount of hours. 
Any problem when deploying or testing: adrianoap@gmail.com
