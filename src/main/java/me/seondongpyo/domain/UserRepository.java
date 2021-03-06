package me.seondongpyo.domain;

import java.util.Optional;

public interface UserRepository {

	User save(User user);

	Optional<User> findById(Long id);

	Optional<User> findByUsername(String username);

	void delete(User user);
}
