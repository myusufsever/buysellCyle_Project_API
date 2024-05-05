@HS @API-US12
Feature: US_0012 As an administrator, I want to be able to access the FAQ's list via API connection.
  @API-US12-TC01
  Scenario: TC01/US_012 When a GET request with valid authorization information is sent to the /api/refundReasonList endpoint the returned status code should be verified as 200, and the message in the response body should be verified as "success".
    * The api user constructs the base url with the "admin" token
    * The api user sets "api/faqsList" path parameters
    * The api user sends the "get" request and saves the "response"
    * The api user verifies that for "get" request type the status code is 200 and the message information in the response body is "success"
  @API-US12-TC02
  Scenario: TC02/US_012 When a GET request with valid authorization information is sent to the /api/refundReasonList endpoint the returned status code should be verified as 200, and the message in the response body should be verified as "success".
    * The api user constructs the base url with the "admin" token
    * The api user sets "api/faqsList" path parameters
    * The api user sends the "get" request and saves the "response"
    * The api user verifies that for "get" request type the status code is 200 and the message information in the response body is "success"
  @API-US12-TC03
  Scenario: TC03/US_012 When a GET request with valid authorization information is sent to the /api/refundReasonList endpoint the returned status code should be verified as 200, and the message in the response body should be verified as "success".
    * The api user constructs the base url with the "admin" token
    * The api user sets "api/faqsList" path parameters
    * The api user sends the "get" request and saves the "response"
    * The api user verifies that for "get" request type the status code is 200 and the message information in the response body is "success"
  @API-US12-TC04
  Scenario: TC04/US_012 When a GET request containing invalid authorization credentials is sent to the /api/faqsList endpoint, the expected status code returned should be 401, and the message in the response body should confirm: "Unauthenticated.".
    * The api user constructs the base url with the "invalid" token
    * The api user sets "api/faqsList" path parameters
    * The api user verifies that for "get" request type the status code is 401 and the message information in the response body is "Unauthorized"
