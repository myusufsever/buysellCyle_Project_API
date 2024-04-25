Feature: US_021 Calculate the number of orders placed according to the order_id in the guest_order_details table.
Update the shipping_name information of the data with order number (order_id=?).

  Background:Database connection
    * Database connection is established.

  @HSDB
  Scenario: In the support_tickets table, list the unique user_ids of the data with and without '-' in reference_no.
    * Query is prepared and executed.

    * Database connection is closed