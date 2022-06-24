package me.seondongpyo.exception;

public class DuplicateUsernameException extends RuntimeException {

	private static final String MESSAGE = "이미 등록된 계정 id입니다. (현재 : %s)";

	public DuplicateUsernameException(String username) {
		super(String.format(MESSAGE, username));
	}
}
