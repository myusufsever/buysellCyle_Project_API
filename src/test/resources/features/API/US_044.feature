Feature: As an administrator, I want to be able to delete the address information of the customer with the specified ID number via the API connection.

Scenario:When a DELETE request body containing valid authorization information and the address ID to be deleted is sent to the /api/profile/deleteAddress endpoint, the returned status code should be 202, and the message in the response body should confirm that it is "address deleted successfully".





Scenario: When a DELETE request body containing valid authorization information and an incorrect (non-existent in the system) address ID is sent to the /api/profile/deleteAddress endpoint, the returned status code should be 404, and the message in the response body should confirm that it is "address not found".






Scenario:When a DELETE request body containing invalid authorization information and the address ID to be deleted is sent to the /api/profile/deleteAddress endpoint, the returned status code should be 401, and the message in the response body should confirm that it is "Unauthenticated.".







Scenario:The Deleted_Id information in the response body returned from the /api/profile/deleteAddress endpoint should be verified to be the same as the id information in the DELETE request body sent to the /api/profile/deleteAddress endpoint.







Scenario:"The deletion of the address record should be verified through the API.
(The deletion of the record can be confirmed by sending a GET request to the /api/profile/addressDetails endpoint with the Deleted_Id obtained from the response body.)"
