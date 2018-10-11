package com.xmas.game.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

public class UserDto {
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Valid
	@NotBlank
	public String emailId;
	@Valid
	@NotBlank
	public String password;
}
