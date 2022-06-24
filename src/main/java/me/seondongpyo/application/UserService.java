package me.seondongpyo.application;

import java.util.Optional;

import lombok.RequiredArgsConstructor;
import me.seondongpyo.domain.User;
import me.seondongpyo.domain.UserRepository;
import me.seondongpyo.exception.DuplicateUsernameException;

@RequiredArgsConstructor
public class UserService {

	private final UserRepository userRepository;

	public User create(User user) {
		Optional<User> maybeUser = userRepository.findByUsername(user.getUsername());
		if (maybeUser.isPresent()) {
			throw new DuplicateUsernameException(user.getUsername());
		}
		return userRepository.save(user);
	}
}
