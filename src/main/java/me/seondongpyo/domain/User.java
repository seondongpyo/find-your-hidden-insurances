package me.seondongpyo.domain;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;
import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.seondongpyo.dto.UserUpdateForm;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@DynamicUpdate
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

	public void encodePassword(PasswordEncoder passwordEncoder) {
		this.password = passwordEncoder.encode(password);
	}

	public void update(UserUpdateForm updateParam) {
		this.name = updateParam.getName();
		this.role = updateParam.getRole();
	}
}
