Feature: As an administrator, I want to be able to delete Refund&Reason information with the specified ID number
  via the API connection.
@zehra
  Scenario Outline: When a DELETE body containing valid authorization information and the refund&reason ID to be deleted is sent
  to the /api/refundReasonDelete endpoint, the returned status code should be 202, and the message information
  in the response body should be verified as "refundReason deleted successfully".

    * The api user constructs the base url with the "admin" token
    * The api user sets "api/refundReasonDelete" path parameters
    * The api user prepares a GET request containing the  <id> for which details are to be accessed
    * The api user sends the "delete" request and saves the "Response"
    * The api user verifies that the status code is 202
    * The api user verifies that the message information in the response body is "refundReason deleted successfully"
    * The api user verifies that the Deleted id information in the response body is the same as the id information in the request body.
    # Api kullanicisi response body icindeki Deleted Id bilgisinin request body icindeki id bilgisi ile ayni oldugu dogrular

    Examples:
      | id |
      | 120|


  Scenario Outline: When a DELETE request body containing valid authorization information and an incorrect (non-existent in the
  system) refund&reason ID is sent to the /api/refundReasonDelete endpoint, the returned status code should be
  404, and the message information in the response body should be verified as "refundReason not found".

    * The api user constructs the base url with the "admin" token
    * The api user sets "api/refundReasonDelete" path parameters
    * The api user prepares a GET request containing the  <id> for which details are to be accessed
    * The api user verifies that for "delete" request type the status code is 404 and the message information in the response body is "Not Found"

    Examples:
      | id |
      | 120|


  Scenario Outline: When a DELETE body containing invalid authorization information and the refund&reason ID to be deleted is
  sent to the /api/refundReasonDelete endpoint, the returned status code should be 401, and the message
  information in the response body should be verified as "Unauthenticated.".

    * The api user constructs the base url with the "invalid" token
    * The api user sets "api/refundReasonDelete" path parameters
    * The api user prepares a GET request containing the  <id> for which details are to be accessed
    * The api user verifies that for "delete" request type the status code is 401 and the message information in the response body is "Unauthorized"

    Examples:
      | id |
      | 121 |


  Scenario Outline: The deletion of the desired Refund&Reason record via the API should be validated from the API.
  (The deletion of the record can be confirmed by sending a GET request to the /api/refundReasonDetails
  endpoint with the Deleted_Id returned in the response body.)

    * The api user constructs the base url with the "admin" token
    * The api user sets "api/refundReasonDetails" path parameters
    * The api user prepares a GET request containing the  <id> for which details are to be accessed
    * The API user records the response from the api refundReasonDetails endpoint, verifying that the status code is '404' and the reason phrase is Not Found.

    Examples:
      | id |
      | 120|