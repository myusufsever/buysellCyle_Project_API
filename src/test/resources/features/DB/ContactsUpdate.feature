@DBUS_4
Feature:BACKEND JDBC TESTING

  Background:Database connection
    * Database connection is established.


  Scenario: US04_ Add a data containing (id,name,email,query_type,message) information in the contacts table.
            # contacts tablosunda (id,name,email,query_type,message) bilgileri iceren bir veri ekleyip message bilgisini update ediniz.
            # 1. STEP: INSERT INTO contacts VALUES (52, 'QA_abc', 'abc@gmail.com', 'query001', 'just do it','2024-04-19','2024-04-25', 'db_04');
            # INSERT INTO contacts (id, name, email, query_type, message, created_at, updated_at, others) VALUES (?,?,?,?,?,?,?,?)
    * Prepare a query that adds data to the contacts table and execute the query.
    * Database connection is closed

  Scenario: US04_ Update the message information in the new added row.
            # 2. STEP: UPDATE contacts SET message = 'message is updated' WHERE id = 52;
    * Update the message information in the contacts table.
    * Database connection is closed