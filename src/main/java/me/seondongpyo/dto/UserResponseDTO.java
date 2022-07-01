package me.seondongpyo.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import me.seondongpyo.domain.Role;
import me.seondongpyo.domain.User;

@Getter
@Setter
@NoArgsConstructor
public class UserResponseDTO {

	private Long id;
	private String name;
	private String username;
	private Role role;

	public UserResponseDTO(User user) {
		this.id = user.getId();
		this.name = user.getName();
		this.username = user.getUsername();
		this.role = user.getRole();
	}
}
