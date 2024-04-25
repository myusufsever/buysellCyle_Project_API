Feature: BACKEND JDBC TESTING


  Background:Database connection
    * Database connection is established.

    #"seller_products tablosunda hiçbir kuponla ilişkilendirilmemiş olan ilk 3 ürünü listeleyip dogrulayiniz.
  Scenario: US_13 List and validate the first 3 products that are not associated with any coupon in the seller_products table.

    * Verify whether  there is data Query is prepared and executed.
    #Sorgunun hazırlandığını ve yürütüldüğünü doğrulayın.
    * List and verify 3 items without coupons.
    #kupon içermeyen 3 ürün listeleyip doğrulayın
    * Database connection is closed
