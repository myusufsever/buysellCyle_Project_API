Feature: As an administrator, I want to be able to delete Refund&Reason information with the specified ID number
  via the API connection.

  Scenario Outline: When a DELETE body containing valid authorization information and the refund&reason ID to be deleted is sent
  to the /api/refundReasonDelete endpoint, the returned status code should be 202, and the message information
  in the response body should be verified as "refundReason deleted successfully".

    * The api user constructs the base url with the "admin" token.
    # APi kullanicisi "admin" token ile base urli olusturur
    * The api user sets "api/refundReasonDelete" path parameters
    # APi kullanicisi "api/refundReasonDelete" path parametrelerini olusturur
    * The api user prepares a DELETE request containing the refund reason <id> to be deleted to send to the api refundReasonDelete endpoint.
    # Api kullanicisi api refundReasonDelete endpointine gondermek icin silinmek istenen refund reason idsini iceren bir delete request hazirlar
    * The api user sends the DELETE request and saves the response returned from the api refundReasonDelete endpoint.
    # Api kullanicisi delete request gonderir ve api refundReasonDelete endpointinden donen responsei kaydeder
    * The api user verifies that the status code is 202
    # Api kullanicisi status codeun 202 oldugunu dogrular
    * The api user verifies that the message information in the response body is "refundReason deleted successfully"
    # Api kullanicisi response bodydeki message bilgisinin "refundReason deleted successfully" oldugunu dogrular
    * The api user verifies that the Deleted id information in the response body is the same as the id information in the request body.
    # Api kullanicisi response body icindeki Deleted Id bilgisinin request body icindeki id bilgisi ile ayni oldugu dogrular

    Examples:
      | id |


  Scenario Outline: When a DELETE request body containing valid authorization information and an incorrect (non-existent in the
  system) refund&reason ID is sent to the /api/refundReasonDelete endpoint, the returned status code should be
  404, and the message information in the response body should be verified as "refundReason not found".

    * The api user constructs the base url with the "admin" token.
    # APi kullanicisi "admin" token ile base urli olusturur
    * The api user sets "api/refundReasonDelete" path parameters
    # APi kullanicisi "api/refundReasonDelete" path parametrelerini olusturur
    * The api user prepares a DELETE request containing the refund reason <id> that are not present in the system to send to the api refundReasonDelete endpoint.
    # Api kullanicisi api refundReasonDelete endpointine gondermek icin sistemde bulunmayan refund reason idsini iceren bir delete request hazirlar
    * The api user sends the DELETE request and saves the response returned from the api refundReasonDelete endpoint.
    # Api kullanicisi delete request gonderir ve api refundReasonDelete endpointinden donen responsei kaydeder
    * The api user verifies that the status code is 404
    # Api kullanicisi status codeun 404 oldugunu dogrular
    * The api user verifies that the message information in the response body is "refundReason not found"
    # Api kullanicisi response bodydeki message bilgisinin "refundReason not found" oldugunu dogrular

    Examples:
      | id |


  Scenario Outline: When a DELETE body containing invalid authorization information and the refund&reason ID to be deleted is
  sent to the /api/refundReasonDelete endpoint, the returned status code should be 401, and the message
  information in the response body should be verified as "Unauthenticated.".

    * The api user constructs the base url with the "invalid" token.
    # APi kullanicisi "invalid" token ile base urli olusturur
    * The api user sets "api/refundReasonDelete" path parameters
    # APi kullanicisi "api/refundReasonDelete" path parametrelerini olusturur
    * The api user prepares a DELETE request containing the refund reason <id> to be deleted to send to the api refundReasonDelete endpoint.
    # Api kullanicisi api refundReasonDelete endpointine gondermek icin silinmek istenen refund reason idsini iceren bir delete request hazirlar
    * The api user sends the DELETE request and saves the response returned from the api refundReasonDelete endpoint.
    # Api kullanicisi delete request gonderir ve api refundReasonDelete endpointinden donen responsei kaydeder
    * The api user verifies that the status code is 401
    # Api kullanicisi status codeun 401 oldugunu dogrular
    * The api user verifies that the message information in the response body is "Unauthenticated."
    # Api kullanicisi response bodydeki message bilgisinin "Unauthenticated." oldugunu dogrular

    Examples:
      | id |


  Scenario Outline: The deletion of the desired Refund&Reason record via the API should be validated from the API.
  (The deletion of the record can be confirmed by sending a GET request to the /api/refundReasonDetails
  endpoint with the Deleted_Id returned in the response body.)

    * The api user constructs the base url with the "admin" token.
    # APi kullanicisi "admin" token ile base urli olusturur
    * The api user sets "api/refundReasonDetails" path parameters
    * The api user prepares a GET request containing the refund reason <id> for which details are to be accessed, to send to the api refundReasonDetails endpoint.
    # Api kullanicisi api refundReasonDetails endpointine gondermek icin detaylarina erisilmek istenen refund reason idsini iceren bir get request hazirlar
    * The api user saves the response returned from the api refundReasonDetails endpoint and confirms that the status code is '404' and the reason phrase is Not Found.
    # Api kullanicisi api refundReasonDetails endpointinden donen responsei kaydeder, status codeun '404' ve reason phrase bilgisinin Not Found oldugunu dogrular

    Examples:
      | id |


