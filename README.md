# PostgresSQL Service API

PostgresSQL Service API is a project that supports the Webpage Design Manipulator Extension by handling requests to Save and Get data from the PostgreSQL database.

## Prerequisites
Installed latest Version of Java
PostgreSQL must be installed and the service is running.
PostgreSQL doesnt support Create if not exist so the following must be created

A schema called users
Inside the schema Tables Called
    css_rule_sets
    user_details
    webpage_css_details

The creation scripts are available in this repo

## Installing PostgresSQL Service API
An installer has been created to aid install.


## Server Details
Port Number: 5000

## Create User EndPoint
URL: /CreateUser

Parameters: id <long>

Example: http://localhost:5000/CreateUser?id=1

Output: This will return the user id created

## Get User Endpoint
URL: /GetUser

Parameters: id <long>

Example: http://localhost:5000/GetUser?id=1
    
Output: This will return the user id created

## Get User Preference Endpoint
URL: /GetSessionRuleSets

Parameters: None

Body Example: {"userId":1, "url": "file:///D:/jonny/Documents/University/FinalYearProject/TestWebsite/TestWebsite.html", "ruleSetIdArray":34}
    
Output: This will return the stored user preferences for the specified Webpage and user

## Delete User Preference Injection Rules Endpoint
URL: /DeleteInjectionCssRules

Parameters: None

Body Example: {"userId":1, "url": "file:///D:/jonny/Documents/University/FinalYearProject/TestWebsite/TestWebsite.html", "ruleSetIdArray":34}
    
Output: This will delete the stored user preferences for the specified Webpage and user should it exist

## Contact
Email: jhughes61@qub.ac.uk

