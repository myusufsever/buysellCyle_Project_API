package hooks;


import helperDB.JDBC_Structure_Methods;
import org.junit.After;
import org.junit.Before;
import utilities.DB_Utilities.DBUtils;

public class HooksDB extends JDBC_Structure_Methods {
@Before
    public void conection(){
    createConnection();
}
@After
public void deconection(){
    closeConnection();
}
}
