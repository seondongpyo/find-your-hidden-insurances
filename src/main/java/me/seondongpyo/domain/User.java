package me.seondongpyo.domain;

import javax.persistence.*;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "users")
@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	private String username;

	private String password;

	@Enumerated(EnumType.STRING)
	private Role role;

	public User(String name, String username, String password, Role role) {
		this.name = name;
		this.username = username;
		this.password = password;
		this.role = role;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean hasUsername(String username) {
		return this.username.equals(username);
	}
}
