package me.seondongpyo.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import me.seondongpyo.domain.Role;

@Getter
@Setter
@NoArgsConstructor
public class UserUpdateForm {

	private String name;
	private Role role;
}
