Feature:BACKEND JDBC TESTING

  Background:Database connection
    * Database connection is established.

  @dbys
  Scenario:list the unique 'notes' in the attendances table, separated by days.


    * List the unique notes in the attendances table, separated by days.
    * Verify list the unique 3 in the attendances table, separated by days.
    * Database connection is closed

