Feature: As an administrator, I want to be able to delete Refund&Reason information with the specified ID number
  via the API connection.

  Scenario Outline: When a DELETE body containing valid authorization information and the refund&reason ID to be deleted is sent
  to the /api/refundReasonDelete endpoint, the returned status code should be 202, and the message information
  in the response body should be verified as "refundReason deleted successfully".







    Examples:
      | id |
      | 25 |
