package me.seondongpyo.application;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import me.seondongpyo.domain.User;
import me.seondongpyo.domain.UserRepository;

public class InMemoryUserRepository implements UserRepository {

	private final Map<Long, User> users = new HashMap<>();
	private long sequence;

	@Override
	public User save(User user) {
		user.setId(++sequence);
		users.put(user.getId(), user);
		return user;
	}

	@Override
	public Optional<User> findById(Long id) {
		return Optional.ofNullable(users.get(id));
	}

	@Override
	public Optional<User> findByUsername(String username) {
		return users.values()
			.stream()
			.filter(user -> user.hasUsername(username))
			.findFirst();
	}

	@Override
	public void delete(User user) {
		users.remove(user.getId());
	}
}
