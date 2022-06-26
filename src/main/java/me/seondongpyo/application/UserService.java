package me.seondongpyo.application;

import java.util.Optional;

import lombok.RequiredArgsConstructor;
import me.seondongpyo.domain.User;
import me.seondongpyo.domain.UserRepository;
import me.seondongpyo.exception.DuplicateUsernameException;
import me.seondongpyo.exception.UserNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
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

	public User findById(Long id) {
		return userRepository.findById(id)
			.orElseThrow(() -> new UserNotFoundException(id));
	}
}
