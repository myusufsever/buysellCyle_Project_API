Feature: Group the coupon_products table by coupon_id and find how many products there are for each coupon

  Background:Database connection
    * Database connection is established.

  @DB16

  Scenario: US_016 List ids with shipping_address = 'Switzerland' in the order_address_details table according to the orders table.

    * Verify the name value of a order_address_details Query is prepared and executed.
    * Verify the id information results are listed with shipping_address using order_address_details table
    * Database connection is closed
