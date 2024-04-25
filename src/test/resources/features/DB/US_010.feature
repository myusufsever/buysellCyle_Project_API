Feature:BACKEND JDBC TESTING

  Background:Database connection
    * Database connection is established.

    @dbys
  Scenario:Verify the number of users whose 'shipping_address' and 'billing_address' are not the same in the order_address_details table.


    * Verify the shipping_address and billing_address are not the same in the order_address_ Query is prepared and executed.
    * Verify the 2 information Results are obtained.
    * Database connection is closed
