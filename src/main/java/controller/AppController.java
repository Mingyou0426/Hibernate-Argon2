package controller;

import java.beans.Transient;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.persistence.Column;
import javax.validation.constraints.Size;

import model.Appuser;
import dao.UserDAO;

@ManagedBean(name = "appController", eager = true)
@RequestScoped
public class AppController{
	private String firstname;
	private Date birthdate;
	private String email;
	
	public String registration() {
		return "registration";
	}
	
	//TODO
    private UserDAO userDAO;

	private String surname;

	private String gender;
	private String username;
	private String password;
	

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
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
	
	public String saveUser() {
		userDAO = new UserDAO();
		Appuser user = new Appuser(this.firstname, this.surname, this.birthdate, this.gender, 
				this.username, this.password, this.email);
		userDAO.saveUser(user);
		return "successRegistration";
	}
}
