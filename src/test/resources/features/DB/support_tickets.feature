Feature:BACKEND JDBC TESTING

  Background:Database connection
    * Database connection is established.

      #support_tickets tablosunda reference_no bilgilerinde '-' içeren ve
      # içermeyen dataların benzersiz user_id'lerini listeleyiniz.
  @01
  Scenario: In the support_tickets table, list the unique user_ids of the data with and without '-' in reference_no.

    * Query is prepared and executed.
    * List the unique user_id information results are obtained.
    * Database connection is closed