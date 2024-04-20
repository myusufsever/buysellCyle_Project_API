Feature: As an administrator, I want to be able to access the FAQ's list via API connection.

  Scenario: When a GET request with valid authorization information is sent to the /api/refundReasonList endpoint
  the returned status code should be verified as 200, and the message in the response body should be verified as "success".
    * The api user constructs the base url with the "admin" token
    * The api user sets "api/faqsList" path parameters
    * The API user sends a "GET" request and records the response from the "api faqsList" endpoint.
    * The api user verifies that the status code is 200 and the message information in the response body is "success".

  Scenario: When a GET request with valid authorization information is sent to the /api/refundReasonList endpoint
  the returned status code should be verified as 200, and the message in the response body should be verified as "success".
    * The api user constructs the base url with the "admin" token
    * The api user sets "api/faqsList" path parameters
    * The API user sends a "GET" request and records the response from the "api faqsList" endpoint.
    * The api user verifies that the status code is 200 and the message information in the response body is "success".

  Scenario: When a GET request containing invalid authorization credentials is sent to the /api/faqsList endpoint,
  the expected status code returned should be 401, and the message in the response body should confirm: "Unauthenticated.".
    * The api user constructs the base url with the "invalid" token
    * The api user sets "api/faqsList" path parameters
    * The API user sends a "GET" request and records the response from the "api faqsList" endpoint.
    * The api user verifies that the status code is 401 and the message information in the response body is "Unauthenticated.".
