package me.seondongpyo.exception;

public class ClientNotFoundException extends RuntimeException {

    private static final String MESSAGE = "고객이 존재하지 않습니다. (id = %d)";

    public ClientNotFoundException(Long id) {
        super(String.format(MESSAGE, id));
    }
}
