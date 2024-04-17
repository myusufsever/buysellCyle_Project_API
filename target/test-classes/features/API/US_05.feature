Feature: As an administrator, I should be able to access all registered user information via API connection.

@US_05
  Scenario: When a GET request is sent to the /api/get-users endpoint with valid authorization credentials, the expected status code
  returned should be 200, and the message in the response body should confirm: "success".

    * The api user constructs the base url with the "admin" token.
    # APi kullanicisi "admin" token ile base urli olusturur
    * The api user sets "api/get-users" path parameters
    # APi kullanicisi "api/get-users" path parametrelerini olusturur
    * The API user sends a GET request and records the response .
    # Api kullanicisi get request gonderir ve  donen responsei kaydeder
    * The api user verifies that the status code is 200
    # Api kullanicisi status codeun 200 oldugunu dogrular
    * The api user verifies that the message information in the response body is "success"
    # Api kullanicisi response bodydeki message bilgisinin "success" oldugunu dogrular


  Scenario Outline: When a GET request is sent to the /api/get-users endpoint with valid authorization credentials, the information returned in the response body for the user with id(x) should be validated,
  including fields such as first_name, username, email, name.

    * The api user constructs the base url with the "admin" token.
    # APi kullanicisi "admin" token ile base urli olusturur
    * The api user sets "api/get-users" path parameters
    # APi kullanicisi "api/get-users" path parametrelerini olusturur
    * The API user sends a GET request and records the response .
    # Api kullanicisi get request gonderir ve  donen responsei kaydeder
    * The api user validates the <id>, "<first_name>", "<username>", "<email>", "<name>" of the response body with index <dataIndex>.
    # API kullanıcısi response body icindeki <dataIndex> indexe sahip olanin "<first_name>" "<username>" "<email>" "<phone>" "<name>" bilgisini doğrular.

    Examples:
      | dataIndex|id | first_name |username| email                | name |
      | 0        |1  | Super      |0181    |info@buysellcycle.com |Super |


    Scenario: When a GET request is sent to the /api/get-users endpoint with invalid authorization credentials,
    the expected status code returned should be 401, and the message in the response body should confirm: "Unauthenticated.".

      * The api user constructs the base url with the "invalid" token.
    # APi kullanicisi "invalid" token ile base urli olusturur
      * The api user sets "api/get-users" path parameters
    # APi kullanicisi "api/get-users" path parametrelerini olusturur
      * The API user records the response , confirming that the status code is '401' and the message is Unauthenticated.
    # Api kullanicisi  responsei kaydeder, status code '401' ve message Unauthenticated oldugunu dogrular
