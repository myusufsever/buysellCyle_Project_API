Feature: US_019 Verify that the opening_balance value of the data with bank_name=?
  in the bank_accounts table is not updated with a negative value.

  Background:Database connection
    * Database connection is established.

  @HSDB
  Scenario: In the support_tickets table, list the unique user_ids of the data with and without '-' in reference_no.
    * "Update the opening_balance with a negative value" query is prepared and executed.
    * Verify that the opening_balance is updated with a negative value.
    * Database connection is closed