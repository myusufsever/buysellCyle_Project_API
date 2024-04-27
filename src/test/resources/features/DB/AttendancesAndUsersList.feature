Feature: DB17

  Background:Database connection
    * Database connection is established.

  @DB17

  Scenario: US_017 Verify the email address from the information of the data with id=5 in the user table from the attendances created before 2022 in the attendances table.

    * "Email_address_from_the_attendances" query is prepared and executed.
    * Verify the email address from the information of the data in the users with attendances table.
    * Database connection is closed
