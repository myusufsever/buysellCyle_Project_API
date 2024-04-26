Feature: US_020 Enter 10 data into the device_tokens table at the same time and verify that it is added to the table.

  Background:Database connection
    * Database connection is established.

  @HSDB
  Scenario: Enter 10 data into the device_tokens table at the same time and verify that it is added to the table.

    * "Entering 10 data to the device_tokens table at the same time and verify the add" query is prepared and executed.
    * Verify that the opening_balance is updated with a negative value.
    * Database connection is closed
