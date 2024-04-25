Feature: US_003 Delete

  Background:Database connection
    * Database connection is established.

  @DB03

  Scenario: US_016 Delete the data containing the values (id=?,name=?) in the cities table. Verify that it has been deleted.
    * Verify delete Query from cities table is prepared and executed.
    * Verify that it has been deleted.
    * Database connection is closed
