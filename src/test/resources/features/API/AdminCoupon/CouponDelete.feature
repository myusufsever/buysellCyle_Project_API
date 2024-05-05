@HS @API-US31
Feature:US_031 As an administrator, I want to be able to delete coupon information with the specified ID number via the API connection.
  Background:
    * The api user constructs the base url with the "admin" token
    * The api user sets "api/coupon/couponList" path parameters
    * The api user detects the id at the last index in the response
  @API-US15-TC01
  Scenario:TC01/US_031 When a DELETE body containing valid authorization information and the coupon ID to be deleted is sent to the /api/coupon/couponDelete endpoint, the returned status code should be 202, and the message information in the response body should be verified as "coupon deleted successfully".
    * The api user constructs the base url with the "admin" token
    * The api user sets "api/coupon/couponDelete" path parameters
    * The api user adds a key field "id" with the value "lastItemId" to the request body
    * The api user sends the "delete" request and saves the "response"
    * The api user verifies that for "delete" request type the status code is 202 and the message information in the response body is "coupon deleted successfully"
  @API-US15-TC02
  Scenario:TC02/US_031 When a DELETE body containing valid authorization information and an incorrect (non-existent in the system) coupon ID is sent to the /api/coupon/couponDelete endpoint, the returned status code should be 404, and the message information in the response body should be verified as "coupon not found".
    * The api user constructs the base url with the "admin" token
    * The api user sets "api/coupon/couponDelete" path parameters
    * The api user adds a key field "id" with the value "-1" to the request body
    * The api user verifies that for "delete" request type the status code is 404 and the message information in the response body is "Not Found"
  @API-US15-TC03
  Scenario:TC03/US_031 When a DELETE body containing invalid authorization information and the coupon ID to be deleted is sent to the /api/coupon/couponDelete endpoint, the returned status code should be 401, and the message information in the response body should be verified as "Unauthenticated.".
    * The api user constructs the base url with the "invalid" token
    * The api user sets "api/coupon/couponDelete" path parameters
    * The api user adds a key field "id" with the value "lastItemId" to the request body
    * The api user verifies that for "delete" request type the status code is 401 and the message information in the response body is "Unauthorized"
  @API-US15-TC04
  Scenario:TC04/US_031 The Deleted_Id information in the response body returned from the /api/coupon/couponDelete endpoint should be verified to match the id information in the DELETE request body sent to the same /api/coupon/couponDelete endpoint.
    * The api user constructs the base url with the "admin" token
    * The api user sets "api/coupon/couponDelete" path parameters
    * The api user adds a key field "id" with the value "lastItemId" to the request body
    * The api user sends the "delete" request and saves the "response"
    * The api user verifies that for "delete" request type the status code is 202 and the message information in the response body is "coupon deleted successfully"
    * The api user verifies that the "Deleted_Id" information in the response body matches the id path parameter specified in the endpoint.
  @API-US15-TC05
  Scenario:TC05/US_031 The deletion of the coupon record via the API should be verified through the API by sending a GET request to the /api/coupon/couponDetails endpoint with the Deleted_Id returned in the response.
    * The api user constructs the base url with the "admin" token
    * The api user sets "api/coupon/couponDelete" path parameters
    * The api user adds a key field "id" with the value "lastItemId" to the request body
    * The api user sends the "delete" request and saves the "response"
    * The api user verifies that for "delete" request type the status code is 202 and the message information in the response body is "coupon deleted successfully"
    * The api user sets "api/coupon/couponDetails" path parameters
    * The api user adds a key field "id" with the value "Deleted_Id" to the request body
    * The api user verifies that for "getbody" request type the status code is 404 and the message information in the response body is "Not Found"
