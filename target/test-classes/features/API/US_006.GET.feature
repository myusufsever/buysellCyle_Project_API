Feature:When a GET request containing valid authorization credentials and the customer id data for the desired detailed information is sent to the /api/get-user endpoint, the expected status code returned should be 200, and the message in the response body should confirm: "success".




  @API
  Scenario Outline:When a GET request containing valid authorization credentials and the customer id data for the desired detailed information is sent to the /api/get-user endpoint, the expected status code returned should be 200, and the message in the response body should confirm: "success".

    * The api user constructs the base url with the "admin" token.

    * The api user sets "api/get-user" path parameters

    * The api user prepares a GET request containing the  <id> for which details are to be accessed.


    * The API user sends a GET request and records the response .

    * The api user verifies that the status code is 200

    * The api user verifies that the message information in the response body is "success"





    Examples:
      | id |
      | 1 |





