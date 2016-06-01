package com.trsvax.hotelbooking.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import org.hibernate.annotations.Immutable;

@Entity
@Immutable
@NamedQueries(value = { @NamedQuery(name = "@Role.byRole", query = " from Role where role = :role") }
		)
public class Role {
	
	@Id 
	@GeneratedValue
	public Long id;
	
	@Column(nullable=false)
	public String role;
	
	@ManyToMany
	@JoinTable(
		name = "USER_ROLE",
		joinColumns = {@JoinColumn(name="ROLE_ID_FK", nullable=false)},
		inverseJoinColumns = {@JoinColumn(name="USER_ID_FK", nullable=false)})
	public Set<User> users;
	
	public boolean equals(Object o) {
		return role.equals(o);
	}	

	@Override
	public int hashCode() {
		return role.hashCode();
	}

	@Override
	public String toString() {
		return role;
	}


}
