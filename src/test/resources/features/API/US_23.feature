Feature:As an administrator, I want to be able to access detailed information about the
  department with the specified ID number via the API connection.


  @23/1
  Scenario Outline: When a GET request body containing valid authorization information and the department ID
  to access detailed information is sent to the /api/departmentDetails endpoint,
  the returned status code should be 200, and the message information should be verified as "success".

    * The api user constructs the base url with the "admin" token.
    * The api user sets "api/departmentDetails" path parameters
    * The api user prepares a GET request containing the refund reason <id> for which details are to be accessed, to send to the api refundReasonDetails endpoint.
    * The api user sends a GET request and saves the response returned from the api desired endpoint.
    * The api user verifies that the status code is 200
    * The api user verifies that the message information in the response body is "success"

    # * The api user verifies the content of the data <id>, "<reason>", "<created_at>", "<updated_at>" in the response body.
    # API kullanicisi response bodydeki data <id>, "<reason>", "<created_at>", "<updated_at>"  içeriklerini doğrular.

    Examples:
      | id |
      | 1  |


  @23/2
  Scenario Outline: When a GET request body containing valid authorization information and the department ID
  to access detailed information is sent to the /api/departmentDetails endpoint, the data
  (id, name ,details, status, cerated_at, updated_at) in the returned response body should be validated.

    * The api user constructs the base url with the "admin" token.
    # APi kullanicisi "admin" token ile base urli olusturur
    * The api user sets "api/departmentDetails" path parameters
    # APi kullanicisi "api/refundReasonDetails" path parametrelerini olusturur
    * The api user prepares a GET request containing the refund reason <id> for which details are to be accessed, to send to the api refundReasonDetails endpoint.
    # Api kullanicisi api refundReasonDetails endpointine gondermek icin detaylarina erisilmek istenen refund reason idsini iceren bir get request hazirlar
    * The api user sends a GET request and saves the response returned from the api refundReasonDetails endpoint.
    # Api kullanicisi get request gonderir ve api refundReasonDetails endpointinden donen responsei kaydeder
    * The api user verifies that the status code is 200
    # Api kullanicisi status codeun 200 oldugunu dogrular
    * The api user verifies that the message information in the response body is "success"
    # Api kullanicisi response bodydeki message bilgisinin "success" oldugunu dogrular
    * The api user verifies the content of the data <id>, "<name>", <status>, "<details>", "<created_at>", "<updated_at>" in the response body.
    # API kullanicisi response bodydeki data <id>, "<reason>", "<created_at>", "<updated_at>"  içeriklerini doğrular.

    Examples:
      | id | id | name  | status | details          | created_at | updated_at |
      | 1  | 1  | Sales | 1      | Sales Department |            |            |

  @23/3
  Scenario Outline: When a GET request body containing valid authorization information and an incorrect
  (non-existent in the system) department ID is sent to the /api/departmentDetails endpoint,
  the returned status code should be 404, and the message information should be verified as
  "department not found".

    * The api user constructs the base url with the "admin" token.
    # APi kullanicisi "admin" token ile base urli olusturur
    * The api user sets "api/departmentDetails" path parameters
    # APi kullanicisi "api/refundReasonDetails" path parametrelerini olusturur
    * The api user prepares a GET request containing the refund reason <id> for which details are to be accessed, to send to the api refundReasonDetails endpoint.
    # Api kullanicisi api refundReasonDetails endpointine gondermek icin detaylarina erisilmek istenen refund reason idsini iceren bir get request hazirlar
    * The API user records the response from the api refundReasonDetails endpoint, verifying that the status code is '404' and the reason phrase is Not Found.


    Examples:

      | id  |
      | 777 |

  @23/4
  Scenario Outline: When a GET request body containing invalid authorization information and the department ID
  to access detailed information is sent to the /api/departmentDetails endpoint,
  the returned status code should be 401, and the message information should be verified as "Unauthenticated.".

    * The api user constructs the base url with the "invalid" token.
    # APi kullanicisi "admin" token ile base urli olusturur
    * The api user sets "api/departmentDetails" path parameters
    # APi kullanicisi "api/refundReasonDetails" path parametrelerini olusturur
    * The api user prepares a GET request containing the  <id> for which details are to be accessed.
      # Api kullanicisi api refundReasonDetails endpointine gondermek icin detaylarina erisilmek istenen refund reason idsini iceren bir get request hazirlar
    * The API user records the response from the api refundReasonList endpoint, confirming that the status code is '401' and the reason phrase is Unauthorized.
    Examples:

      | id |
      | 1  |


