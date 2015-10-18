package br.com.compositeam.businessmodel.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
@Table(name = "User")
public class User {
	@Id
    @Column(name="id_user")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
	
	
	private String password;
	
	@Column(unique = true)
	private String email;
	
	@ManyToMany(fetch = FetchType.EAGER,cascade = {CascadeType.ALL})
    @JoinTable(name="USER_ROLE", 
                joinColumns={@JoinColumn(name="id_user")}, 
                inverseJoinColumns={@JoinColumn(name="id_role")})
	private List<Role> roles;
	
	public User(){
		roles = new ArrayList<Role>(); 
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getEncryPassword(){
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashedPassword = passwordEncoder.encode(this.getPassword());
		return hashedPassword;
	}

	
	

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public void addRole(String role){
		Role ObRole = new Role();
		ObRole.setDescription(role);
		ObRole.addUser(this);
		this.roles.add(ObRole);
	}
	
	public void addRole(Role role){
		this.roles.add(role);
	}

	
	
	
}
