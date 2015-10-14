package mx.gob.tsjdf.db;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConnectionDB {
	
	Connection con;
	
    public Connection getConexion() throws NamingException, SQLException{
        
           Context envContext = new InitialContext();
           DataSource ds = (DataSource)envContext.lookup("java:/comp/env/jdbc/TSJDFM4HE");
           con = ds.getConnection();
        return con;
       }

}
