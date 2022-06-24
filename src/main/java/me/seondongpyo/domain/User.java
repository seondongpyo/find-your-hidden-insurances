package me.seondongpyo.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;

@Getter
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	private String username;

	private String password;

	public User(String name, String username, String password) {
		this.name = name;
		this.username = username;
		this.password = password;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
