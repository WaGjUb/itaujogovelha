# Quickstart
NOTE: I deployed it in my personal AWS account, please do not stress test on my AWS API... I don't want to exceed the free requests from my api gateway

My api gateway is online at this end point: 
https://q8oonx75l9.execute-api.sa-east-1.amazonaws.com/Prod/jogovelha

## How to run?

curl -XPOST "http://tralalala:8080/jogovelha" -d "{"jogo": ["XXO", "XOX", "OOX"]}"

or just use Postman


## Run an local API

NOTE: You should to have AWS sam cli installed on your machine

sam local start-api


