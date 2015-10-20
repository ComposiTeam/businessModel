package br.com.compositeam.businessmodel.model;

import java.util.logging.Logger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "Person")
public class Person {
	
	@Id
    @Column(name="id_person")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private final static Logger LOGGER = Logger.getLogger(Person.class.getName());
	
	private String name;
	
	private String surname;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_user", referencedColumnName = "id_user")
	private User user;
	
	public Person(){
		
	}
	
	public Person(User user){
		this.setUser(user);
	}
	
	public Person(User user, String name){
		this.setUser(user);
		this.setName(name);
	}
	
	public Person(User user, String name, String surname){
		this.setUser(user);
		this.setName(name);
		this.setSurName(surname);
	}
	
	public Person(String email, String password, String name, String surname){
		User user = new User();
		user.setEmail(email);
		user.setPassword(password);
		this.setUser(user);
		this.setName(name);
		this.setSurName(surname);
	}
	
	public void setName(String name){
		if(name == null || name.length() < 1){
			LOGGER.info("Trying to set name null or less than 1 caracter.");
			throw new NullPointerException("The name has to have unless 1 caracter.");
		}else{
			this.name = name;
		}
	}
	
	public String getName(){
		return name;
	}
	
	public String getSurname(){
		return this.surname;
	}
	
	public void setSurName(String surname){
		if(surname == null || surname.length() < 1){
			LOGGER.info("Trying to set surname null or less than 1 caracter.");
			throw new NullPointerException("The surname has to have unless 1 caracter.");
		}else{
			this.surname = surname;
		}
	}
	
	public void setUser(User user){
		if(user == null){
			LOGGER.info("Trying to set user  null.");
			throw new NullPointerException("User cannot be null");
		}else{
			this.user = user;
		}
	}

}
