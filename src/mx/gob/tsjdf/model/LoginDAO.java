package mx.gob.tsjdf.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.NamingException;

import com.sun.media.jfxmedia.logging.Logger;

import mx.gob.tsjdf.bean.LoginBean;
import mx.gob.tsjdf.db.ConnectionDB;
import mx.gob.tsjdf.utils.security.cryptography.CryptMD5;

public class LoginDAO {
	
	Connection        con ;
	PreparedStatement psmt;
	ResultSet 		  rs;
	
	
	public boolean obtenUsuario(LoginBean loginBean){
		ConnectionDB connectionDB = new ConnectionDB();
		boolean pasa = false;
		try {
			con = connectionDB.getConexion();
			String sql = "SELECT count(*) \n"+
						 " FROM dbo.USUARIOS\n"+
						 "	WHERE NUM_EMPLEADO = ?\n"+
						 "	AND   PASSWORD = ?";
			psmt = con.prepareStatement(sql);
			psmt.setString(1, loginBean.getUsername());
			psmt.setString(2, CryptMD5.getMD5(loginBean.getPassword(),"MD5") );
			rs = psmt.executeQuery();
			int count = 0;
			while(rs.next()){
				count = rs.getInt(1);
			}
			if(count > 0){
				pasa = true;
				
			}
		} catch (NamingException | SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				psmt.close();
				rs.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		return pasa;
		
	}

}
