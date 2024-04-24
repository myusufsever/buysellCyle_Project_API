Feature: US_0031 As an administrator, I want to be able to delete
coupon information with the specified ID number via the API connection.


  @HS
  Scenario: When a DELETE body containing valid authorization information and the coupon ID to be deleted is sent to the
  /api/coupon/couponDelete endpoint, the returned status code should be 202, and the message information in the response
  body should be verified as "coupon deleted successfully".

    * The api user constructs the base url with the "admin" token
    * The api user sets "api/coupon/couponDelete" path parameters
    * The api user adds a key field "id" with the value "123" to the request body
    * The api user sends the "delete" request and saves the "response"
    * The api user verifies that for "delete" request type the status code is 202 and the message information in the response body is "coupon deleted successfully"


  @HS
  Scenario: When a DELETE body containing valid authorization information and an incorrect (non-existent in the system)
  coupon ID is sent to the /api/coupon/couponDelete endpoint, the returned status code should be 404, and the message
  information in the response body should be verified as "coupon not found".

    * The api user constructs the base url with the "admin" token
    * The api user sets "api/coupon/couponDelete" path parameters
    * The api user adds a key field "id" with the value "127" to the request body
    * The api user verifies that for "delete" request type the status code is 404 and the message information in the response body is "Not Found"


  @HS
  Scenario: When a DELETE body containing invalid authorization information and the coupon ID to be deleted is sent to the
  /api/coupon/couponDelete endpoint, the returned status code should be 401, and the message information in the response
  body should be verified as "Unauthenticated.".

    * The api user constructs the base url with the "invalid" token
    * The api user sets "api/coupon/couponDelete" path parameters
    * The api user adds a key field "id" with the value "127" to the request body
    * The api user verifies that for "delete" request type the status code is 401 and the message information in the response body is "Unauthorized"


  @HS
  Scenario: The Deleted_Id information in the response body returned from the /api/coupon/couponDelete endpoint should be
  verified to match the id information in the DELETE request body sent to the same /api/coupon/couponDelete endpoint.

    * The api user constructs the base url with the "admin" token
    * The api user sets "api/coupon/couponDelete" path parameters
    * The api user adds a key field "id" with the value "122" to the request body
    * The api user sends the "delete" request and saves the "response"
    * The api user verifies that for "delete" request type the status code is 202 and the message information in the response body is "coupon deleted successfully"
    * The api user verifies that the "Deleted_Id" information in the response body matches the id path parameter specified in the endpoint.


  @HS
  Scenario Outline: The deletion of the coupon record via the API should be verified through the API by sending a GET
  request to the /api/coupon/couponDetails endpoint with the Deleted_Id returned in the response.

    * The api user constructs the base url with the "admin" token
    * The api user sets "api/coupon/couponDelete" path parameters
    * The api user adds a key field "id" with the value "125" to the request body
    * The api user sends the "delete" request and saves the "response"
    * The api user verifies that for "delete" request type the status code is 202 and the message information in the response body is "coupon deleted successfully"
    * The api user verifies that for "getbody" request type the status code is 404 and the message information in the response body is "Not Found"
    Examples:
      |id |
      |127|