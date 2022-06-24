package me.seondongpyo.exception;

public class UserNotFoundException extends RuntimeException {

	private static final String MESSAGE = "해당 사용자가 존재하지 않습니다. (식별자 : %s)";

	public UserNotFoundException(Long id) {
		super(String.format(MESSAGE, id));
	}
}
