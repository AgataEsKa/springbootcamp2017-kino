package pl.kodolamacz.spring.services.exceptions;

/**
 * Created by acacko on 04.11.17
 */
public class UserNotFoundException extends Exception {
    public UserNotFoundException(String message) {
        super(message);
    }
}

