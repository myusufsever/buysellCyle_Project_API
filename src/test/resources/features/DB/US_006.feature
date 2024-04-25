@DB06
Feature:BACKEND JDBC TESTING

  Background:Database connection
    * Database connection is established.

   Scenario: US_006 Group the coupon_products table by coupon_id and find how many products there are for each coupon
      #coupon_products tablosunu coupon_id'ye göre gruplayarak her kupon için kaç ürün olduğunu bulunuz.

     * Verify whether there is data Query is prepared and executed.
     * Verify the "reason" information result are obtained.
     * Database connection is closed