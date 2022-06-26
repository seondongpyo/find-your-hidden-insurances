package me.seondongpyo.application;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import me.seondongpyo.domain.Role;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import me.seondongpyo.domain.User;
import me.seondongpyo.domain.UserRepository;
import me.seondongpyo.exception.DuplicateUsernameException;
import me.seondongpyo.exception.UserNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

class UserServiceTest {

	private UserRepository userRepository;
	private UserService userService;

	@BeforeEach
	void setUp() {
		userRepository = new InMemoryUserRepository();
		userService = new UserService(userRepository, new BCryptPasswordEncoder());
	}

	@DisplayName("새로운 사용자를 등록한다.")
	@Test
	void create() {
		User user = createUser();

		User created = userService.create(user);

		assertAll(
			() -> assertThat(created.getId()).isEqualTo(user.getId()),
			() -> assertThat(created.getName()).isEqualTo(user.getName()),
			() -> assertThat(created.getUsername()).isEqualTo(user.getUsername()),
			() -> assertThat(created.getPassword()).isEqualTo(user.getPassword())
		);
	}

	@DisplayName("이미 등록된 계정 id가 있다면, DuplicateUsernameException이 발생한다.")
	@Test
	void duplicateUsername() {
		User user = createUser();

		userRepository.save(user);

		assertThatThrownBy(() -> userService.create(user))
			.isInstanceOf(DuplicateUsernameException.class);
	}

	@DisplayName("식별자로 사용자를 조회한다.")
	@Test
	void findById() {
		User user = userService.create(createUser());

		User foundUser = userService.findById(user.getId());

		assertAll(
			() -> assertThat(foundUser.getId()).isEqualTo(user.getId()),
			() -> assertThat(foundUser.getName()).isEqualTo(user.getName()),
			() -> assertThat(foundUser.getUsername()).isEqualTo(user.getUsername()),
			() -> assertThat(foundUser.getPassword()).isEqualTo(user.getPassword())
		);
	}

	@DisplayName("식별자에 해당하는 사용자가 없는 경우, UserNotFoundException이 발생한다.")
	@Test
	void userNotFound() {
		userService.create(createUser());

		assertThatThrownBy(() -> userService.findById(999L))
			.isInstanceOf(UserNotFoundException.class);
	}

	private User createUser() {
		return new User("홍길동", "hong", "1234", Role.USER);
	}
}
