package com.xmas.game.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name="GAME_USER")
public class User {
	  	@Id
	    @GeneratedValue(strategy=GenerationType.AUTO)
	    private Long id;

	    private String name;

	    @Column(nullable = false)
	    private String email;
	    
	    private String password;

	    @OneToMany(targetEntity= UserGroup.class)
	    List<UserGroup> userInGroups;
	    
		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public List<UserGroup> getUserInGroups() {
			return userInGroups;
		}

		public void setUserInGroups(List<UserGroup> userInGroups) {
			this.userInGroups = userInGroups;
		}

		@Override
		public String toString() {
			return "User [id=" + id + ", name=" + name + ", email=" + email + "]";
		}


}
