package mx.gob.tsjdf.view;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.apache.log4j.Logger;

@ManagedBean
@RequestScoped
public class LoginView implements Serializable{
	
private static final long serialVersionUID = 1L;
	
	private static org.apache.log4j.Logger logger = Logger.getLogger(LoginView.class);
	String username;
	String password;
	

	public String passUser(){
		System.out.println("Usuario: " + this.username);
		logger.info("Usuario: " + this.password);
		logger.info("Entro en el Bean******************+");
		return "";
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}



}
