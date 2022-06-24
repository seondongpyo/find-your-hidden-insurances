package me.seondongpyo.application;

import lombok.RequiredArgsConstructor;
import me.seondongpyo.domain.User;
import me.seondongpyo.domain.UserRepository;

@RequiredArgsConstructor
public class UserService {

	private final UserRepository userRepository;

	public User create(User user) {
		return userRepository.save(user);
	}
}
