package com.trsvax.hotelbooking.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.Immutable;

@Entity
@Immutable
public class Permission {

	@Id 
	@GeneratedValue
	public Long id;

	@Column(nullable=false)
	public String permission;
	
	@ManyToMany
	@JoinTable(
		name = "USER_PERMISSION",
		joinColumns = {@JoinColumn(name="PERMISSION_ID_FK", nullable=false)},
		inverseJoinColumns = {@JoinColumn(name="USER_ID_FK", nullable=false)})
	public Set<User> users;

	public boolean equals(Object o) {
		return permission.equals(o);
	}	

	@Override
	public int hashCode() {
		return permission.hashCode();
	}

	@Override
	public String toString() {
		return permission;
	}

	
}
