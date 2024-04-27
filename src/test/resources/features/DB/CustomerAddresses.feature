@US_7
Feature:BACKEND JDBC TESTING

  Background:Database connection
    * Database connection is established.


  Scenario: US07_Check whether the phone data contains 5 according to the first 3 address information in the customer_addresses table
            # customer_addresses tablosunda ilk 3 adres bilgisine gore phone datalarının 5 icerip icermedigini kontrol edin
            #  SELECT address FROM customer_addresses WHERE phone LIKE '%5%' LIMIT 3;

    * Query select is prepared and executed.
    * Verify the required results.
    * Database connection is closed