package mx.gob.tsjdf.view;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.apache.log4j.Logger;

import mx.gob.tsjdf.bean.LoginBean;
import mx.gob.tsjdf.model.LoginDAO;

@ManagedBean
@RequestScoped
public class LoginView implements Serializable{
	
private static final long serialVersionUID = 1L;
	
	private static org.apache.log4j.Logger logger = Logger.getLogger(LoginView.class);
	String username;
	String password;
	LoginDAO loginDAO;
	LoginBean loginBean;
	

	public String passUser(){
		loginBean = new LoginBean();
		String paso = "";
		logger.info("Entro en el Bean******************+");
		loginBean.setUsername(this.username);
		loginBean.setPassword(this.password);
		loginDAO = new LoginDAO();
		boolean ok = loginDAO.obtenUsuario(loginBean);
		if(ok){
			paso = "home";
			logger.info("CORRECTO");
		}else{
			logger.info("INCORRECTO");
		}
		return paso;
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
