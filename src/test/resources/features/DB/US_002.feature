Feature:BACKEND JDBC TESTING

  Background:Database connection
    * Database connection is established.

    @ZSDB
    Scenario: cities tablosuna (id,name,state_id,status,created_at) degerlerini iceren bir veri ekleyiniz.
    cities tablosu uzerinden verinin eklendigini dogrulayiniz.

      * getCities veri ekleme query is prepared and executed.
      * cities tablosu uzerinden 1 adet verinin eklendigini dogrulayiniz.
      * Database connection is closed