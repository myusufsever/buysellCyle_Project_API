@HS @API-US39
Feature:US_039 As an administrator, I want to be able to access the city information registered in the system with the specified state_id via the API connection.
  @API-US39-TC01
  Scenario Outline:TC01/US_039 When a GET request body containing valid authorization credentials and the desired state_id to access city information is sent to the /api/profile/stateCities endpoint, the returned status code should be validated as 200, and the message information in the response body should confirm as "success".
    * The api user constructs the base url with the "admin" token
    * The api user sets "api/profile/stateCities" path parameters
    * The api user prepares a GET request containing "the desired state" <id> to send to the api "profile/stateCities" endpoint.
    * The api user sends the "getbody" request and saves the "response"
    * The api user verifies that for "getbody" request type the status code is 200 and the message information in the response body is "success"
    Examples:
      | id |
      | 3669 |
  @API-US39-TC02
  Scenario Outline:TC02/US_039 When a GET request body containing valid authorization credentials and a state_id of 3669 is sent to the /api/profile/stateCities endpoint, the returned response body should be validated to confirm that the city with an ID number of 40325 has the "name" attribute as "Kizilcahamam".
    * The api user constructs the base url with the "admin" token
    * The api user sets "api/profile/stateCities" path parameters
    * The api user prepares a GET request containing "the desired state" <id> to send to the api "profile/stateCities" endpoint.
    * The api user sends the "getbody" request and saves the "response"
    * The api user verifies the content of the data <cityID>, "<city_name>" in the response body.
    Examples:
      | id   | cityID | city_name    |
      |3669  | 40325  | Kizilcahamam |
  @API-US39-TC03
  Scenario Outline:TC03/US_039 When a GET request body containing valid authorization credentials and an incorrect (not found in the system) state_id is sent to the /api/profile/stateCities endpoint, the returned status code should be validated as 404, and the message information in the response body should confirm as "address not found".
    * The api user constructs the base url with the "admin" token
    * The api user sets "api/profile/stateCities" path parameters
    * The api user prepares a GET request containing "an incorrect state" <id> to send to the api "profile/stateCities" endpoint.
    * The api user verifies that for "getbody" request type the status code is 404 and the message information in the response body is "Not Found"
    Examples:
      | id |
      | 369 |
  @API-US39-TC04
  Scenario Outline:TC04/US_039 When a GET request body containing invalid authorization credentials and the desired state_id to access city information is sent to the /api/profile/stateCities endpoint, the returned status code should be validated as 401, and the message information in the response body should confirm as "Unauthenticated.".
    * The api user constructs the base url with the "invalid" token
    * The api user sets "api/profile/stateCities" path parameters
    * The api user prepares a GET request containing "the desired state" <id> to send to the api "profile/stateCities" endpoint.
    * The api user verifies that for "get" request type the status code is 401 and the message information in the response body is "Unauthorized"
    Examples:
      | id |
      | 3669 |