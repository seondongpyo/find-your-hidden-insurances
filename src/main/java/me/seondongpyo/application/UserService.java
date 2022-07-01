package me.seondongpyo.application;

import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import me.seondongpyo.domain.Role;
import me.seondongpyo.domain.User;
import me.seondongpyo.domain.UserRepository;
import me.seondongpyo.dto.UserUpdateForm;
import me.seondongpyo.exception.DuplicateUsernameException;
import me.seondongpyo.exception.UserNotFoundException;

@RequiredArgsConstructor
@Transactional
@Service
public class UserService {

	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;

	public User create(User user) {
		Optional<User> maybeUser = userRepository.findByUsername(user.getUsername());
		if (maybeUser.isPresent()) {
			throw new DuplicateUsernameException(user.getUsername());
		}
		user.encodePassword(passwordEncoder);
		return userRepository.save(user);
	}

	@Transactional(readOnly = true)
	public User findById(Long id) {
		return userRepository.findById(id)
			.orElseThrow(() -> new UserNotFoundException(id));
	}

	public void update(Long id, UserUpdateForm updateParam) {
		User user = findById(id);
		user.update(updateParam);
	}

	public void delete(Long id) {
		User user = findById(id);
		userRepository.delete(user);
	}

	@PostConstruct
	private void init() {
		userRepository.save(new User("어드민", "admin", passwordEncoder.encode("1234"), Role.ADMIN));
		userRepository.save(new User("매니저", "manager", passwordEncoder.encode("1234"), Role.MANAGER));
		userRepository.save(new User("유저", "user", passwordEncoder.encode("1234"), Role.USER));
	}
}
