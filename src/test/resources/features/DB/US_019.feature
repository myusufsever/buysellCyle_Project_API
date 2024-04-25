Feature: US_019 Verify that the opening_balance value of the data with bank_name=? in the bank_accounts table is not
updated with a negative value.

  Background:Database connection
    * Database connection is established.

  @HSDB
  Scenario: In the support_tickets table, list the unique user_ids of the data with and without '-' in reference_no.
    * Query is prepared and executed.

    * Database connection is closed