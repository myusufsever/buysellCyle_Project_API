Feature: US_016

  Background:Database connection
    * Database connection is established.

  @DB16

  Scenario: US_016 List ids with shipping_address = 'Switzerland' in the order_address_details table according to the orders table.

    * "List_ids_with_shipping_address" query is prepared and executed.
    * Verify the id information results are listed with shipping_address using order_address_details table
    * Database connection is closed
