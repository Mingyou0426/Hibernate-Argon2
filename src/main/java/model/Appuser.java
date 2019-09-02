package model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="appuser")
public class Appuser {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Size(min=3, max=50)
	@Column(name = "firstname", nullable = false)
	private String firstname;

	@NotNull
	@Column(name = "birthdate", nullable = false)
	private Date birthdate;	
	
	@NotBlank
	@Column(name = "email", nullable = false)
	private String email;	
	
	//1. TODO Properties
	
	@Size(min=3, max=50)
	@Column(name = "surname", nullable = false)
	private String surname;

	@NotNull
	@Column(name = "gender", nullable = false)
	private String gender;

	@Size(min=3, max=50)
	@Column(name = "username", nullable = false)
	private String username;

	// @Size(min=6, max=50)
	@Column(name = "password", nullable = false)
	private String password;
	
	//2. TODO setters and getters
	
	public Appuser() {
		super();
	}
	
	public Appuser(String firstname, String surname, Date birthdate, String gender, String username, String password, String email) {
		super();
		
		this.firstname = firstname;
		this.surname = surname;
		this.birthdate = birthdate;
		this.gender = gender;
		this.username = username;
		this.password = password;
		this.email = email;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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
}