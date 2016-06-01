package com.trsvax.hotelbooking.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="PERSON")
@NamedQueries(value = { @NamedQuery(name = "@User.byEmail", query = " from User where email = :email"),
		@NamedQuery(name = "@User.byUsername", query = " from User where username = :username")}
)
public class User {
	
	public final static String DAO = "UserDAO";
	
	@Id 
	@GeneratedValue
	public Long id;
	
	public String username;
	
	public String fullname;
	
	public String email;
	
	public String password;
	
	public String salt;
	
	@ManyToMany(cascade={CascadeType.PERSIST})
	@JoinTable(
		name = "USER_ROLE",
		joinColumns = {@JoinColumn(name="USER_ID_FK", nullable=false)},
		inverseJoinColumns = {@JoinColumn(name="ROLE_ID_FK", nullable=false)})
	public Set<Role> roles;
	
	@ManyToMany(cascade={CascadeType.PERSIST})
	@JoinTable(
			name = "USER_PERMISSION",
			joinColumns = {@JoinColumn(name="USER_ID_FK", nullable=false)},
			inverseJoinColumns = {@JoinColumn(name="PERMISSION_ID_FK", nullable=false)})
		public Set<Permission> permissions;
	

}
