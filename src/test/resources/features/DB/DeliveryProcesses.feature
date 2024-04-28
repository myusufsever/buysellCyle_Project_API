@DBUS_8
Feature:BACKEND JDBC TESTING

  Background:Database connection
    * Database connection is established.

  Scenario: US08_Verify that the first 5 data names in the delivery_processes table are in reverse order (Shipped, Recieved, Processing, Pending, Delivered).
            #  delivery_processes tablosunda ilk 5 verinin name bilgilerinin tersten sırasıyla (Shipped,Recieved,Processing,Pending,Delivered) oldugunu dogrulayiniz.
            # SELECT name FROM delivery_processes ORDER BY name DESC LIMIT 5;

    * Prepare the query that orders the names of delivery processes in reverse order
    * Database connection is closed